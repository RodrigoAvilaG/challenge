package com.testframework.tests;

import com.testframework.base.DataReader;
import com.testframework.pageobjects.AmazonProductsPO;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends DataReader {

    public WebDriver driver;
    AmazonProductsPO amazonProductsPO;

    String firstSearch = getSearchData("firstSearch");
    String secondSearch = getSearchData("secondSearch");
    String customerName = getEmployeeData("employee_name");

    @BeforeMethod
    public void setUpDriver() {
        amazonProductsPO = new AmazonProductsPO(driver);
        amazonProductsPO.driverConnection();
    }

    @AfterMethod
    public void afterMethod() {
        amazonProductsPO.closeDriver();
    }
    
}
