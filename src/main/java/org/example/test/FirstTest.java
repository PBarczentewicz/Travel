package org.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.example.base.BaseTest;
import org.example.front.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;

public class FirstTest extends BaseTest {

    @Test
    public void ShopNewJogaButton() {
        navigateToHomePage();

        WebElement newJogaButton = homePage.findByXpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/span/span[2]");
        newJogaButton.click();

        WebElement numberInShop = homePage.findByXpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]/text()");
    }


}
