package org.example.test;

import org.example.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @ParameterizedTest
    @CsvSource({
            "admin, admin, ok",
            "admin1, admin1, wrongUserWrongPassword",
            "admin, admin1, okUserWrongPassword",
            "admin1, admin, wrongUserOkPassword"
    })

    public void LoginForm(String loginUsername, String loginPassword, String result) {
        navigateToHomePage();
        homePage.clickLoginButton();
        homePage.setLoginUsername(loginUsername)
                .setLoginPassword(loginPassword)
                .clickLoginButton2();

        if (result == "ok"){
            homePage.logiAndPasswordOk();}
        else {
            switch (result) {
                case "wrongUserWrongPassword":
                    homePage.wrongUserWrongPassword();
                    break;
                case "okUserWrongPassword":
                    homePage.okUserWrongPassword();
                    break;
                case "wrongUserOkPassword":
                    homePage.wrongUserOkPassword();
                    break;
            }
        }
    }
}

