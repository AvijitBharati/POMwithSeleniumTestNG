import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.util.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Hook {

    WebDriver driver;
    ExtentReports report;
    ExtentTest testReport;

    @BeforeClass
    public void initiateReporting(){
        report=new ExtentReports(System.getProperty("user.dir")+"/report.html",true);
    }

    @BeforeMethod
    public void initiateWebDriver(){
        driver=new GlobalVariables().initializeWebDriver("OrangeHRMApp");
    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

    @AfterTest
    public void completeReport(){
        if(report!=null) {
            // Appends the HTML file with all the ended tests. There
            report.flush();

            // Closes the underlying stream and clears all resources
            report.close();
        }
    }
}
