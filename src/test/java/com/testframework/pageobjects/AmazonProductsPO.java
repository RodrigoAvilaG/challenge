package com.testframework.pageobjects;

import com.testframework.base.BaseWeb;
import com.testframework.locators.AmazonHome;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AmazonProductsPO extends BaseWeb implements AmazonHome{

    public AmazonProductsPO(WebDriver driver) {
        super(driver);
    }

    public void enterSearch(String search) {
        waitForElement(searchBox);
        type(searchBox, search);
    }

    public void clickOnSearchButton() {
        waitForElement(searchButton);
        click(searchButton);
    }

    public String getPriceInSearchPage(){
        waitForElement(priceWhole);
        waitForElement(priceFraction);
        String price = "$" + getText(priceWhole)  + "." + getText(priceFraction);
        
        return price;
    }

    public void clickOnSelectedItem() {
        waitForElement(priceWhole);
        click(priceWhole);
    }

    public String getPriceInProductPage() {
        waitForElement(productPrice);
        String price = getText(productPrice);

        return price;
    }

    public String getPriceInCartPage() {
        waitForElement(cartPrice);
        String price = getText(cartPrice);

        return price;
    }

    public void comparePrices(String fisrtPrice, String secondPrice) {
        Assert.assertEquals(fisrtPrice, secondPrice);
    }

    public void clickOnAddToCartButton() {
        waitForElement(addToCartButton);
        click(addToCartButton);
    }

    public void compareCartPrice(String firstPrice, String cartPrice){
        Assert.assertEquals(firstPrice, cartPrice);
    }

    public void deleteCartProduct() {
        waitForElement(cartButton);
        click(cartButton);
        waitForElement(deleteLink);
        click(deleteLink);
    }

    public void verifyProductDeleted() {
        Assert.assertTrue(isDisplayed(emptyCart),"Getting started is not displayed");
    }

    public void clickOnStartHereLink() {
        waitForElement(accountAndLists);
        mouseOver(accountAndLists);
        waitForElement(startHere);
        click(startHere);
    }

    public void fillNewAccountFormular(String customerName) {
        String customerEmail = customerName.replaceAll("\\s", ".")  + "@fake.com";
        waitForElement(name);
        waitForElement(email);
        waitForElement(password);
        waitForElement(passwordCheck);
        waitForElement(conditionsOfUse);
        type(name, customerName);
        type(email, customerEmail);
        type(password, "SuperPassword123");
        type(passwordCheck, "SuperPassword123");
    }

    public void clickOnConditionsOfUseLink() {
        waitForElement(conditionsOfUse);
        click(conditionsOfUse);
    }

    public void enterEchoSearch() {
        waitForElement(searchBoxCU);
        type(searchBoxCU, "Echo");
        tapEnter(searchBoxCU);
    }

    public void clickOnEchoSupport() {
        waitForElement(echoSupport);
        click(echoSupport);
    }

    public void verifyThatElementsListIsDisplayed() {
        waitForElement(gettingStarted);
        waitForElement(wifiAndBluetooth);
        waitForElement(deviceSoftwareAndHardware);
        waitForElement(troubleShooting);
        Assert.assertTrue(isDisplayed(gettingStarted),"Getting started is not displayed");
        Assert.assertTrue(isDisplayed(wifiAndBluetooth),"Wi-fi and Bluetooth is not displayed");
        Assert.assertTrue(isDisplayed(deviceSoftwareAndHardware),"Device Software and Hardware is not displayed");
        Assert.assertTrue(isDisplayed(troubleShooting),"Trouble Shooting is not displayed");
    }
}
