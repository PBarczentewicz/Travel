package org.example.test;

import org.example.base.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTest extends BaseTest {
    @ParameterizedTest
    @CsvSource({
            "admin, admin, ok",
            "admin1, admin1, wrongUserWrongPassword",
            "admin, admin1, okUserWrongPassword",
            "admin1, admin, wrongUserOkPassword",
    })

    public void LoginForm(String loginUsername, String loginPassword, String result) {
        navigateToHomePage();
        homePage.clickLoginButton();
        homePage.setLoginUsername(loginUsername)
                .setLoginPassword(loginPassword)
                .clickFinalLoginButton();

        switch (result) {
            case "ok":
                homePage.assertLoginAndPasswordOk();
                break;
            case "wrongUserWrongPassword":
                homePage.assertWrongUserWrongPassword();
                break;
            case "okUserWrongPassword":
                homePage.assertOkUserWrongPassword();
                break;
            case "wrongUserOkPassword":
                homePage.assertWrongUserOkPassword();
                break;
        }
    }
}


