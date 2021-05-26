package com.testframework.tests;

import org.testng.annotations.Test;
import extent.testng.listener.ExtentITestListenerClassAdapter;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class})
public class AmazonPracticeTest extends BaseTest{

    //@Test
    public void firstTestCase() throws InterruptedException {
        amazonProductsPO.enterSearch(firstSearch);
        amazonProductsPO.clickOnSearchButton();
        String firstPrice = amazonProductsPO.getPriceInSearchPage();
        amazonProductsPO.clickOnSelectedItem();
        String secondPrice = amazonProductsPO.getPriceInProductPage();
        amazonProductsPO.comparePrices(firstPrice, secondPrice);
        amazonProductsPO.clickOnAddToCartButton();
        String cartPrice = amazonProductsPO.getPriceInCartPage();
        amazonProductsPO.compareCartPrice(firstPrice, cartPrice);
        amazonProductsPO.deleteCartProduct();
        amazonProductsPO.verifyProductDeleted();
    }
    
    //@Test
    public void secondTestCase() throws InterruptedException {
        amazonProductsPO.enterSearch(secondSearch);
        amazonProductsPO.clickOnSearchButton();
        String firstPrice = amazonProductsPO.getPriceInSearchPage();
        amazonProductsPO.clickOnSelectedItem();
        String secondPrice = amazonProductsPO.getPriceInProductPage();
        amazonProductsPO.comparePrices(firstPrice, secondPrice);
        amazonProductsPO.clickOnAddToCartButton();
        String cartPrice = amazonProductsPO.getPriceInCartPage();
        amazonProductsPO.compareCartPrice(firstPrice, cartPrice);
        amazonProductsPO.deleteCartProduct();
        amazonProductsPO.verifyProductDeleted();
    }

    @Test
    public void thirdTestCase() throws InterruptedException {
        amazonProductsPO.clickOnStartHereLink();
        amazonProductsPO.fillNewAccountFormular(customerName);
        amazonProductsPO.clickOnConditionsOfUseLink();
        amazonProductsPO.enterEchoSearch();
        amazonProductsPO.clickOnEchoSupport();
        amazonProductsPO.verifyThatElementsListIsDisplayed();
    }
}
