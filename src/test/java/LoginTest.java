import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1500x980";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/login");
        $(".practice-form-wrapper").shouldHave(text("Login in Book Store"));

        $("#userName").setValue("Vit");
        $("#passwordName").setValue("Perov");
        $("#login").click();

        $("#name").shouldHave(text("Invalid username or password"));
    }
}