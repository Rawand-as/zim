package pa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;

import java.util.List;
public class W3schoolPage {
    WebDriver driver;
    public W3schoolPage(WebDriver driver){
        this.driver=driver;
    }
    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        String retVal = null;
        try {
            retVal = getTableCellTextByXpath(table, searchColumn, searchText, returnColumnText);
        } catch (Exception e) {
            System.out.println("Element"+searchText+" not Found!");
        }
        return retVal;
    }

    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText){
        String actualText = getTableCellText(table,searchColumn,searchText,returnColumnText);
        if(actualText.equals(expectedText)){
            return true;
        }else{
            System.out.println("actual text is:"+actualText+" but the expected is "+expectedText);
        }
        return false;
    }
    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) throws Exception {
        int i=1;
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//td["+searchColumn+"]"));
        for (WebElement element : rows) {
            i++;
            if (element.getText().equalsIgnoreCase(searchText)){
                break;
            }
        }
        List<WebElement> col = driver.findElements(By.xpath("//table[@id='customers']//tr["+i+"]/*["+returnColumnText+"]"));
        String retVal = col.get(0).getText();
        return retVal;
    }
}