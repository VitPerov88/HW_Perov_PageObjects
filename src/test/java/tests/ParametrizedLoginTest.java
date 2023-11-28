package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParametrizedLoginTest extends TestBase {

    @CsvSource(value = {
            "Chupakabra, Pass1234_*",
            "Vit, 2023_December*"
    })
    @ParameterizedTest
    @DisplayName("Login и Password корректные, вошли в личный кабинет")
    @Tag("successful")
    void successfulLoginTest(String login, String password) {

        loginPage.openPage()
                .setLoginName(login)
                .setPassword(password)
                .clickLogin()
                .checkRedirectToPage("Profile")
                .clickLogOut();
    }
    @CsvFileSource(resources = "/ParametrizedLoginTest.csv")
    @ParameterizedTest(name = "Login и Password некорректные, сайт выводит сообщение об ошибке")
    @Tag("unsuccessful")
    void unsuccessfulLoginTestWrongPassword(String login, String password) {

        loginPage.openPage()
                .setLoginName(login)
                .setPassword(password)
                .clickLogin()
                .checkMessageInvalidLogin();
    }
    @ValueSource( strings = {"Vit", ""})
    @ParameterizedTest
    @DisplayName("Поля Login и Password пустые, на сайте подсвечиваются пустые поля")
    @Tag("unsuccessful")
    void unsuccessfulLoginWithEmptyFields(String login) {
        loginPage.openPage()
                .setLoginName(login)
                .clickLogin()
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