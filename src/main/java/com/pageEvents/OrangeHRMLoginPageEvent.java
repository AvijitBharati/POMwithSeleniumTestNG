package com.pageEvents;

import com.pageElements.OrangeHRMLoginPageElement;
import com.util.TestDataObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPageEvent implements OrangeHRMLoginPageElement{

    WebDriver driver;

    @FindBy(xpath=OrangeHRMLoginPageElement.userName)
    WebElement userName;

    @FindBy(xpath = OrangeHRMLoginPageElement.password)
    WebElement password;

    @FindBy(xpath = OrangeHRMLoginPageElement.password)
    WebElement login;

    public OrangeHRMLoginPageEvent(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void logIn(TestDataObject testdata) throws InterruptedException {
        userName.clear();
        userName.sendKeys(testdata.getUserName());
        password.clear();
        password.sendKeys(testdata.getPassword());
        Thread.sleep(2000);
        login.clear();
    }

}
