package org.example.test;

import org.example.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCart (){
        navigateToHomePage();

        WebElement elelementOnHomePage = driver.findElement(By.linkText("Samsung galaxy s6"));
        String textFromHomePage = elelementOnHomePage.getText();
        elelementOnHomePage.click();

        homePage.findByXpath("//*[@class='btn btn-success btn-lg']").click();
        //Alert succesAlert = driver.switchTo().alert();

        WebElement cartElelemnt = homePage.findById("cartur");
        cartElelemnt.click();

        WebElement itemInCart = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]"));
        String itemInCartText = itemInCart.getText();

        Assertions.assertEquals(textFromHomePage, itemInCartText);

    }
}
