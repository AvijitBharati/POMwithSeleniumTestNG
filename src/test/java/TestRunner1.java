import com.pageEvents.WebFormPage;
import com.util.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRunner1 {
    WebDriver driver;
    WebFormPage wfPage;
    GlobalVariables globalVar=new GlobalVariables();


    @BeforeMethod
    public void initialize(){
        driver=globalVar.initializeWebDriver("webFormApp");
    }
    @Test
    public void testWebFormApplication(){
        wfPage=new WebFormPage(driver);
        wfPage.webFormPageSubmitEvent();
        Assert.assertEquals("Hands-On Selenium WebDriver with Java",wfPage.getPageTitle(driver));

    }
    /*
    @Test(dataProvider="testdata")
    public void testWebFormApplicationwithTestData(String a,String b) throws InterruptedException {
        wfPage=new WebFormPage(driver);
        wfPage.webFormPageSubmitEvent(a,b);
        Assert.assertEquals("Hands-On Selenium WebDriver with Java",wfPage.getPageTitle(driver));
    }*/

    @AfterMethod
    public void quitDriver() throws InterruptedException{
        if(driver!=null){
            Thread.sleep(1000);
            driver.quit();
        }
    }

}
