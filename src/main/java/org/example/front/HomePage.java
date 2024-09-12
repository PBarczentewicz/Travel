package org.example.front;

import org.example.base.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public HomePage setLastName(String lastname) {
        findById("lastname").sendKeys(lastname);
        return this;
    }

    public HomePage setPhone(String phone) {
        findByXpath("//*[@id='phone']").sendKeys(phone);
        return this;
    }

    public HomePage clickSubmitButton() {
        findById("submitContact").click();
        return this;
    }


}
