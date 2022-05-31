package pa.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
public class TestBase {
public static WebDriver driver = null;
@BeforeSuite
public void initialize(){
    System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\selenium\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.w3schools.com/html/html_tables.asp");
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterSuite
    public void downTest(){
    TestBase.driver.quit();
}
}