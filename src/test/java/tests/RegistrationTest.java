package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends tests.TestBase {

    @Test
    void successfulRegistrationFillAllFieldsTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Vit")
                .setLastName("Perov")
                .setEmail("vit.perov@gmail.com")
                .setGender("Male")
                .setUserNumber("9800000000")
                .setDateOfBirth("02", "October", "1988")
                .setSubjects("Economics")
                .setHobbies("Reading")
                .uploadPicture("photo.jpg")
                .setAddress("Russia")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();

        registrationPage.checkResultModalTable("Student Name", "Vit Perov")
                .checkResultModalTable("Student Email", "vit.perov@gmail.com")
                .checkResultModalTable("Gender", "Male")
                .checkResultModalTable("Mobile", "9800000000")
                .checkResultModalTable("Date of Birth", "02 October,1988")
                .checkResultModalTable("Subjects", "Economics")
                .checkResultModalTable("Hobbies", "Reading")
                .checkResultModalTable("Picture", "photo.jpg")
                .checkResultModalTable("Address", "Russia")
                .checkResultModalTable("State and City", "NCR Delhi");

    }
    @Test
    void successfulRegistrationFillRequiredFieldsTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Vit")
                .setLastName("Perov")
                .setEmail("vit.perov@gmail.com")
                .setGender("Male")
                .setUserNumber("9800000000")
                .setDateOfBirth("02", "October", "1988")
                .setSubjects("Economics")
                .clickSubmit();

        registrationPage.checkResultModalTable("Student Name", "Vit Perov")
                .checkResultModalTable("Student Email", "vit.perov@gmail.com")
                .checkResultModalTable("Gender", "Male")
                .checkResultModalTable("Mobile", "9800000000")
                .checkResultModalTable("Date of Birth", "02 October,1988")
                .checkResultModalTable("Subjects", "Economics");
    }

    @Test
    void unsuccessfulRegistrationFillWrongEmailTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Vit")
                .setLastName("Perov")
                .setEmail("vit.perov")
                .setGender("Male")
                .setUserNumber("9800000000")
                .clickSubmit();

        registrationPage.checkModalDialogHidden();
    }
}