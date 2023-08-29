package com.pageEvents;

import com.pageElements.OrangeHRMDashboardPageElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMDashboardPageEvent implements OrangeHRMDashboardPageElement {
    WebDriver driver;

    @FindBy(xpath=OrangeHRMDashboardPageElement.dashboard)
    WebElement dashboard;

    public OrangeHRMDashboardPageEvent(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean validateDashboard(){
        return dashboard.isDisplayed();
    }

}
