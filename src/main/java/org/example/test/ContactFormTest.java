package org.example.test;

import org.example.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactFormTest extends BaseTest {

    @Test
    public void contactFormFront (){
        navigateToHomePage();

        homePage.findByXpath("//a[@class='nav-link']").click();



       // WebElement contactForm = homePage.findByXpath("//a[@class='nav-link']");
       // contactForm.click();

    }
}
