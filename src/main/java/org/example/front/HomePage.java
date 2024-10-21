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
        findById("loginusername").sendKeys(loginUsername);
        return this;
    }

    public HomePage setLoginPassword(String loginPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("loginusername"), ""));

        findById("loginpassword").sendKeys(loginPassword);
        return this;
    }

    public HomePage clickLoginButton2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("loginpassword"), ""));
        findByXpath("//*[@onclick='logIn()']").click();
        return this;
    }

    public void logiAndPasswordOk() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        WebElement temp = driver.findElement(By.id("nameofuser"));
        String welcomeAdmin = temp.getText();
        String textExpected = "Welcome admin";

        Assertions.assertEquals("Welcome admin", welcomeMessage.getText());
        Assertions.assertEquals(textExpected, welcomeAdmin);
    }

    public void okUserWrongPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert wrongPassword = driver.switchTo().alert();
        String alertText = driver.switchTo().alert().getText();

        Assertions.assertEquals("Wrong password.", alertText);
    }

    public void wrongUserWrongPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert wrongPassword = driver.switchTo().alert();
        String alertText = wrongPassword.getText();

        Assertions.assertEquals("Wrong password.", alertText);
        wrongPassword.accept();
    }

    public void wrongUserOkPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert okUserWrongPassword = driver.switchTo().alert();
        String alertText = okUserWrongPassword.getText();

        if (alertText == "User does not exist.") {
            Assertions.assertEquals(("User does not exist."), alertText);
        } else if (alertText == "Wrong password.") {
            Assertions.assertEquals(("Wrong password."), alertText);
        } else if (alertText == "Please fill out Username and Password.") {
            Assertions.assertEquals(("Please fill out Username and Password."), alertText);
        }
    }
}
