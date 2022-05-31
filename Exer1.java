package ex1;
import javax.mail.*;
import java.util.Properties;
import java.util.Scanner;

public class Exer1 {
    public static void fetch(String pop3Host, String user, String password) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.println("subject of email you want to search");
        String subject = sc.nextLine();
        // create properties field
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "pop3");
        properties.put("mail.pop3.host", pop3Host);
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");
        Session emailSession = Session.getDefaultInstance(properties);
        Store store = null;
        try {
            store = emailSession.getStore("pop3s");
            store.connect(pop3Host, user, password);
            // create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length:" + messages.length);
            for (Message msg : messages) {
                    if (msg.getSubject().contains(subject)) {
                        System.out.println("Found the Email with Subject : " + subject);
                        System.out.println("subject: "+msg.getSubject());
                        System.out.println("From: "+msg.getFrom()[0]);
                        break;
                    }
            }
            // close the store and folder objects
            emailFolder.close(false);
            store.close();
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException e){
            System.out.println("there's no mail with subject " + subject);
        }
    }
        public static void main(String[] args) {
            String host = "pop.gmail.com";
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter username");
            String userName = sc.nextLine();
            System.out.println("password");
            String password = sc.nextLine();
            fetch(host, userName, password);
    }
}
