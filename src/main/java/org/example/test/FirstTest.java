package org.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.example.base.BaseTest;
import org.example.base.CommonPage;
import org.example.drivermenager.DriverManager;
import org.example.drivermenager.DriverManagerFactory;
import org.example.drivermenager.DriverType;
import org.example.front.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.internal.BaseTestMethod;

import java.time.Duration;

public class FirstTest extends BaseTest {

   @Test
    public void ShopNewJogaButton() {
        navigateToHomePage();
        homePage.findByXpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/span/span[2]");
       // WebElement numberInShop = homePage.findByXpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]/text()");
    }
}
