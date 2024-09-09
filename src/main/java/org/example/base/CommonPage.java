package org.example.base;

import org.openqa.selenium.WebDriver;

public class CommonPage extends BasePage {

    private final WebDriver driver;


    protected CommonPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CommonPage acceptCookie() {
        findByXpath("//*[@class='agreement']//button[contains(@class, 'save-all')]").click();

        return this;
    }
}
