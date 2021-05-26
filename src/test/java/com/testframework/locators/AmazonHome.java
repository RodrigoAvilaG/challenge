package com.testframework.locators;

import org.openqa.selenium.By;

public interface AmazonHome {
    // Main page
    By searchBox = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By accountAndLists = By.id("nav-link-accountList");
    By startHere = By.xpath("//div[@id='nav-flyout-ya-newCust']/a[normalize-space(text()) = 'Start here.']");

    // Results page
    By priceWhole = By.xpath("//span[@class='a-price-whole']");
    By priceFraction = By.xpath("//span[@class='a-price-fraction']");
    By productImage = By.xpath("//div[@class='a-section a-spacing-medium']");

    // Product page
    By productPrice = By.id("priceblock_ourprice");
    By addToCartButton = By.id("add-to-cart-button");

    // Cart Page
    By cartPrice = By.xpath("//div[@id='hlb-subcart']/div/span/span[2]");
    By cartButton = By.id("hlb-view-cart-announce");
    By deleteLink = By.xpath("//span[@class='a-declarative']/input");
    By emptyCart = By.xpath("//h2[contains(text(),'Your Amazon Cart is empty')]");

    // Create account page
    By name = By.id("ap_customer_name");
    By email = By.id("ap_email");
    By password = By.id("ap_password");
    By passwordCheck = By.id("ap_password_check");
    By conditionsOfUse = By.xpath("//div[@id='legalTextRow']/a[normalize-space(text()) = 'Conditions of Use']");

    // Conditions of use page
    By searchBoxCU = By.id("helpsearch");
    By echoSupport = By.xpath("//a[normalize-space(text()) = 'Echo Support']");
    By gettingStarted = By.xpath("//h4[normalize-space(text()) = 'Getting Started']");
    By wifiAndBluetooth = By.xpath("//h4[normalize-space(text()) = 'Wi-Fi and Bluetooth']");
    By deviceSoftwareAndHardware = By.xpath("//h4[normalize-space(text()) = 'Device Software and Hardware']");
    By troubleShooting = By.xpath("//h4[normalize-space(text()) = 'Troubleshooting']");
}
