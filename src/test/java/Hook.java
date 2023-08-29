import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.util.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileReader;
import java.util.Properties;

public class Hook {

    WebDriver driver;
    ExtentReports report;
    ExtentTest testExtent;
    Properties prop;

    public Hook(){
        prop=new Properties();
        try {
            prop.load(new FileReader("src/main/resources/page.properties"));
        }
        catch (Exception e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void initiateReporting(){

        report=new ExtentReports(System.getProperty("user.dir")+"/report.html",true);
        testExtent=report.startTest("OrangeScenario");
    }

    @BeforeMethod
    public void initiateWebDriver(){
        driver=new GlobalVariables().initializeWebDriver("OrangeHRMApp");
        driver.get(prop.getProperty("OrangeHRMApp"));
    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

    @AfterTest
    public void completeReport(){

        report.endTest(testExtent);
            // Appends the HTML file with all the ended tests. There
        report.flush();
            // Closes the underlying stream and clears all resources
        report.close();
    }
}
