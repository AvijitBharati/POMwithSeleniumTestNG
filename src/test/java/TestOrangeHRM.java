import com.pageEvents.OrangeHRMDashboardPageEvent;
import com.pageEvents.OrangeHRMLoginPageEvent;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.util.GlobalVariables;
import com.util.TestDataObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestOrangeHRM extends Hook{
    GlobalVariables globalVar=new GlobalVariables();
    OrangeHRMLoginPageEvent newLoginPageEvent;
    OrangeHRMDashboardPageEvent newDashboardEvent;

    @Test(dataProvider="orangedata")
    public void testOrangeHRM(TestDataObject testData) throws InterruptedException{
        newLoginPageEvent=new OrangeHRMLoginPageEvent(driver);
        testExtent.log(LogStatus.INFO,"Login Start");
        newLoginPageEvent.logIn(testData);
        newDashboardEvent=new OrangeHRMDashboardPageEvent(driver);
        Assert.assertEquals(true,newDashboardEvent.validateDashboard());
        testExtent.log(LogStatus.INFO,"Login Complete");
    }

    @DataProvider(name="orangedata")
    public Object[][] testDataSetup(){
        int noOfData=globalVar.readTestData();
        Object[][] testData=new Object[noOfData-1][1];
        for (int i=1;i<noOfData;i++){
            testData[i-1][0]=globalVar.readTestDataAsObject(i);
        }
        return testData;
    }

}

