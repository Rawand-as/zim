package pa.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pa.pages.W3schoolPage;

public class W3Tests extends TestBase{

    @FindBy(how = How.XPATH ,using = "//*[@id='customers']")
    WebElement table;
    @Parameters({"searchColumn","searchText","returnColumnText","expectedText"})
    @Test
    public void init(int searchColumn,String searchText,int returnColumnText,String expectedText){
        W3schoolPage w3schoolPage = PageFactory.initElements(driver,W3schoolPage.class);
        boolean result =w3schoolPage.verifyTableCellText(table,searchColumn,searchText,returnColumnText,expectedText);
        Assert.assertEquals(true,result);
    }
}
