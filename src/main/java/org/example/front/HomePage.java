package org.example.front;

import org.example.base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private final WebDriver driver;

    private By endBUttonForLog = By.xpath("//button[@onclick='logIn()']");

    enum id {
        loginUsername("loginusername"),
        loginPassword("loginpassword");

        private final String value;

        id (String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

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

    public HomePage clickLoginButton() {
        findById("login2").click();
        return this;
    }

    public HomePage setLoginUsername(String loginUsername) {
        findById(id.loginUsername.value).sendKeys(loginUsername);
        return this;
    }

    public HomePage setLoginPassword(String loginPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.id(id.loginUsername.value), ""));
        findById(id.loginPassword.value).sendKeys(loginPassword);
        return this;
    }

    public HomePage clickFinalLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.id(id.loginPassword.value), ""));
        driver.findElement(endBUttonForLog).click();
        return this;
    }
    private void assertResult (String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assertions.assertEquals(expectedMessage, alertText);
    }

    public void assertLoginAndPasswordOk() {
        assertResult("Welcome admin");
    }

    public void assertOkUserWrongPassword() {
        assertResult("Wrong password.");
    }

    public void assertWrongUserWrongPassword() {
        assertResult("Wrong password.");
    }

    public void assertWrongUserOkPassword() {
       assertResult("Wrong password.");
    }
}
