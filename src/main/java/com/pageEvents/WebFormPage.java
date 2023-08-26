package com.pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebFormPage {
    WebDriver driver;

    public WebFormPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    final String a="asd";
    @FindBy(xpath = "//*[@id=\"my-text-id\"]")
    WebElement userName;

    @FindBy(xpath = "/html/body/main/div/form/div/div[1]/label[2]/input")
    WebElement password;

    @FindBy(xpath = "//*[@class=\"btn btn-outline-primary mt-3\"]")
    WebElement submitButton;

    @FindBy(xpath = "/html/body/main/div/form/div/div[1]/label[3]/textarea")
    WebElement textArea;


    public void webFormPageSubmitEvent(){
        userName.sendKeys("Abc");
        password.sendKeys("pass");
        submitButton.click();
    }

    public void webFormPageSubmitEvent(String a,String b) throws InterruptedException{
        userName.sendKeys(a);
        textArea.sendKeys(b);
        Thread.sleep(5000);
        submitButton.click();
    }
    public String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }
}
