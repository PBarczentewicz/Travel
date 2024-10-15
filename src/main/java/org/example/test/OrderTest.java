package org.example.test;

import org.example.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class OrderTest extends BaseTest {

    @Test
    public void orderButton(){
        navigateToHomePage();
        homePage.switchToOrderCard();
        homePage.findByXpath("//button[@class='btn btn-success']").click();
        homePage.setNameInOrder("Tomas")
                .setCountry("Poland")
                .setCity("New York")
                .setCreditCard("1111 2222 3333 4444 5555")
                .setMonth("01")
                .setYear("2025")
                .clickPurchaseButton();
        homePage.assertSuccesOrder();
    }
}
