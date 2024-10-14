package org.example.front;

import org.example.base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final WebDriver driver;

    public HomePage(WebDriver oDriver) {
        super(oDriver);
        this.driver = oDriver;
    }


    public HomePage setEmail(String email) {
        findById("recipient-email").sendKeys(email);
        return this;
    }

    public HomePage setName(String name) {
        findById("recipient-name").sendKeys(name);
        return this;
    }

    public HomePage setMessage(String message) {
        findById("message-text").sendKeys(message);
        return this;
    }

    public HomePage clickContactButton() {
        findByXpath("//button[@onclick='send()']").click();
        return this;
    }

    public HomePage clickAddToCard() {
        findByXpath("//*[@class='btn btn-success btn-lg']").click();
        return this;
    }

    public HomePage setNameInOrder(String nameInOrder) {
        findById("name").sendKeys(nameInOrder);
        return this;
    }

    public HomePage setCountry(String country) {
        findById("country").sendKeys(country);
        return this;
    }

    public HomePage setCity(String city) {
        findById("city").sendKeys(city);
        return this;
    }

    public HomePage setCreditCard(String creditCardNUmber) {
        findById("card").sendKeys(creditCardNUmber);
        return this;
    }

    public HomePage setMonth(String month) {
        findById("month").sendKeys(month);
        return this;
    }

    public HomePage setYear(String year) {
        findById("year").sendKeys(year);
        return this;
    }

    public void switchToOrderCard() {
        driver.get("https://www.demoblaze.com/cart.html");
    }

    public HomePage clickPurchaseButton() {
        findByXpath("//*[@onclick='purchaseOrder()']").click();
        return this;
    }

    public void assertSuccesOrder() {
        WebElement temp = driver.findElement(By.xpath("/html/body/div[10]/h2"));
        String thanksTextActual = temp.getText();
        String thanksTextExpected = "Thank you for your purchase!";

        Assertions.assertEquals(thanksTextExpected, thanksTextActual);
    }
}
