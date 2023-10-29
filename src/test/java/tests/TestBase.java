package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.LoginPage;
import pages.RegistrationPage;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    LoginPage loginPage = new LoginPage();

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

}