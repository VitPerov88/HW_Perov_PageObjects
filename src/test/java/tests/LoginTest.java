package tests;

import org.junit.jupiter.api.Test;

public class LoginTest extends tests.TestBase {

    @Test
    void successfulLoginTest() {

        loginPage.openPage()
                .setLoginName("Chupakabra")
                .setPassword("Pass1234_*")
                .clickLogin()
                .checkRedirectToPage("Profile")
                .clickLogOut();
    }
}