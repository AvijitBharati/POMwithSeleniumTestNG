import com.pageEvents.OrangeHRMLoginPageEvent;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.util.GlobalVariables;
import com.util.TestDataObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestOrangeHRM extends Hook{
    GlobalVariables globalVar=new GlobalVariables();
    OrangeHRMLoginPageEvent newLoginPageEvent;
    ExtentTest test;

    @Test(dataProvider="orangedata")
    public void testOrangeHRM(TestDataObject testData) throws InterruptedException{
        test=report.startTest("OrangeScenario");
        newLoginPageEvent=new OrangeHRMLoginPageEvent(driver);
        newLoginPageEvent.logIn(testData);
        test.log(LogStatus.INFO,"Login Complete");
        report.endTest(test);
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

