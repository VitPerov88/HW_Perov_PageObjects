package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class ParametrizedLoginTest extends TestBase {

    @Test
    @DisplayName("Login и Password корректные, вошли в личный кабинет")
    @Tag("successful")
    void successfulLoginTest() {

        loginPage.openPage()
                .setLoginName("Chupakabra")
                .setPassword("Pass1234_*")
                .clickLogin()
                .checkRedirectToPage("Profile")
                .clickLogOut();
    }
    /*@CsvSource(value = {
            "Chupakabra, Pass1234_",
            "Username, Pass1234_*"
    })*/
    @CsvFileSource(resources = "/ParametrizedLoginTest.csv")
    @ParameterizedTest(name = "Login {0} и Password {1} некорректные, сайт выводит сообщение об ошибке")
    @Tag("unsuccessful")
    void unsuccessfulLoginTestWrongPassword(String login, String password) {

        loginPage.openPage()
                .setLoginName(login)
                .setPassword(password)
                .clickLogin()
                .checkMessageInvalidLogin();
    }

    @Test
    @DisplayName("Поля Login и Password пустые, на сайте подсвечиваются пустые поля")
    @Tag("unsuccessful")
    void unsuccessfulLoginWithEmptyFields() {
        loginPage.openPage()
                .setLoginName("")
                .setPassword("")
                .clickLogin()
                .checkInvalidUserName()
                .checkInvalidPassword();
    }
    @Test @Disabled
    @DisplayName("Login корректный, Password не заполнен, сообщение об ошибке")
    @Tag("unsuccessful")
    void unsuccessfulLoginWithEmptyPassword() {
        loginPage.openPage()
                .setLoginName("Chupakabra")
                .setPassword("")
                .clickLogin()
                .checkInvalidPassword();
    }
}