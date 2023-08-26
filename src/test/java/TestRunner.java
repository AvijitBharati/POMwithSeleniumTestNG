import com.pageEvents.WebFormPage;
import com.util.GlobalVariables;
import com.util.TestDataObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestRunner {
    WebDriver driver;
    WebFormPage wfPage;
    GlobalVariables globalVar=new GlobalVariables();


    @BeforeMethod
    public void initialize(){
        driver=globalVar.initializeWebDriver("webFormApp");
    }
/*
    @Test
    public void testWebFormApplication(){
        wfPage=new WebFormPage(driver);
        wfPage.webFormPageSubmitEvent();
        Assert.assertEquals("Hands-On Selenium WebDriver with Java",wfPage.getPageTitle(driver));

    }

    @Test(dataProvider="testdata")
    public void testWebFormApplicationwithTestData(String a,String b) throws InterruptedException {
        wfPage=new WebFormPage(driver);
        wfPage.webFormPageSubmitEvent(a,b);
        Assert.assertEquals("Hands-On Selenium WebDriver with Java",wfPage.getPageTitle(driver));
    }*/

    @Test(dataProvider="testdata1",testName="OrangeHRMTest")
    public void testWebFormApplicationwithObjTestData(TestDataObject testObj) throws InterruptedException {
        wfPage=new WebFormPage(driver);
        wfPage.webFormPageSubmitEvent(testObj.getUserName(),testObj.getPassword());
        Assert.assertEquals("Hands-On Selenium WebDriver with Java",wfPage.getPageTitle(driver));
    }

    @AfterMethod
    public void quitDriver() throws InterruptedException{
        if(driver!=null){
            Thread.sleep(1000);
            driver.quit();
        }
    }

    @DataProvider(name="testdata")
    public Object[][] testDataSetup(){
        int row=globalVar.readTestData();
        System.out.println("Number of test data"+row);
        Object[][] testData = new Object[row][2];
        for(int i=0;i<row;i++){
            testData[i][0]=globalVar.readRowsfromWorkbook(i,0);
            testData[i][1]=globalVar.readRowsfromWorkbook(i,1);
        }
        return testData;
    }
    @DataProvider(name="testdata1")
    public Object[][] testDataSetup1(){
        int row=globalVar.readTestData();
        System.out.println("Number of test data"+row);
        Object[][] testData = new Object[row][1];
        for(int i=0;i<row;i++){
            testData[i][0]=globalVar.readTestDataAsObject(i);
        }
        return testData;
    }
}
