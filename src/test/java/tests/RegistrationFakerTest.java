package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

public class RegistrationFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();
    @Test
    void successfulRegistrationFillAllFieldsTest() {



        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.month, testData.yearOfBirth)
                .setSubjects(testData.subject)
                .setHobbies(testData.hobby)
                .uploadPicture(testData.img)
                .setAddress(testData.streetAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .clickSubmit();

        registrationPage.checkResultModalTable("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultModalTable("Student Email", testData.userEmail)
                .checkResultModalTable("Gender", testData.gender)
                .checkResultModalTable("Mobile", testData.userNumber)
                .checkResultModalTable("Date of Birth", testData.dayOfBirth + " " + testData.month + "," + testData.yearOfBirth)
                .checkResultModalTable("Subjects", testData.subject)
                .checkResultModalTable("Hobbies", testData.hobby)
                .checkResultModalTable("Picture", testData.img)
                .checkResultModalTable("Address", testData.streetAddress)
                .checkResultModalTable("State and City", testData.state + " " + testData.city);

    }
}
