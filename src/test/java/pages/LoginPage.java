package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Helpers;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    Helpers helper = new Helpers();

    SelenideElement titleLabel = $(".main-header"),
            loginName = $("#userName"),
            password = $("#password"),
            loginButton = $("#login"),
            invalidLoginMessage = $("#name"),
            invalidUserName = $("#userName.is-invalid"),
            invalidPassword = $("#password.is-invalid"),
            logOutButton = $("#submit");

    public LoginPage openPage() {
        open("/login");
        titleLabel.shouldHave(text("Login"));

        return this;

    }
    public LoginPage setLoginName(String value) {
        loginName.setValue(value);

        return this;
    }

    public LoginPage setPassword(String value) {
        password.setValue(value);

        return this;
    }
    public LoginPage clickLogin() {
        loginButton.click();

        return this;
    }
    public LoginPage checkRedirectToPage(String value) {
        titleLabel.shouldHave(text(value));

        return this;
    }
    public LoginPage checkMessageInvalidLogin() {
        invalidLoginMessage.shouldHave(text("Invalid username or password!"));

        return this;
    }
    public LoginPage checkInvalidUserName() {
        invalidUserName.shouldBe(visible);

        return this;
    }
    public LoginPage checkInvalidPassword() {
        invalidPassword.shouldBe(visible);

        return this;
    }
    public LoginPage clickLogOut() {
        logOutButton.shouldHave(text("Log out"));
        logOutButton.click();

        return this;
    }
}