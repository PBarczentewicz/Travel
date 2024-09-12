package org.example.base;

import org.example.drivermenager.ChromeDriverManager;
import org.example.drivermenager.DriverManager;
import org.example.drivermenager.DriverManagerFactory;
import org.example.drivermenager.DriverType;
import org.example.front.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;
    protected CommonPage commonPage;
    protected HomePage homePage;


    @BeforeEach
    protected void setUp() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/");
        navigateToCommonPage();
    }


    @AfterEach
    public void tearDown() {
        driverManager.quitDriver();
    }

    protected CommonPage navigateToCommonPage() {
        commonPage = PageFactory.initElements(driver, CommonPage.class);
        return commonPage;
    }

    protected HomePage navigateToHomePage() {
        homePage = new HomePage(driver);
        return homePage;
    }
}
