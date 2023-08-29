package com.util;

import org.apache.commons.exec.ExecuteException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class GlobalVariables {
    public static WebDriver driver;
    public Properties prop;
    XSSFWorkbook testData;
    TestDataObject testObj;

    public GlobalVariables(){
        prop=new Properties();
        try {
            prop.load(new FileReader("src/main/resources/page.properties"));
        }
        catch (Exception e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public WebDriver initializeWebDriver(String appName){
        System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriverPath"));
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public int readTestData(){
        try {
            File s = new File(prop.getProperty("testDataPath"));
            FileInputStream stream = new FileInputStream(s);
            testData = new XSSFWorkbook(stream);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Returning Number of Test data");
        return testData.getSheetAt(0).getLastRowNum()+1;
    }
    public String readRowsfromWorkbook(int row,int column){
        XSSFSheet sheet = testData.getSheetAt(0);
        String data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;
    }

    public TestDataObject readTestDataAsObject(int row){
        try {
            testObj=new TestDataObject();
            File s = new File(prop.getProperty("testDataPath"));
            FileInputStream stream = new FileInputStream(s);
            testData = new XSSFWorkbook(stream);
            XSSFSheet sheet = testData.getSheetAt(0);
            testObj.setUserName(sheet.getRow(row).getCell(1).getStringCellValue());
            testObj.setPassword(sheet.getRow(row).getCell(2).getStringCellValue());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return testObj;
    }
}
