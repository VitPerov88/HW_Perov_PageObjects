package tests;

import com.github.javafaker.Faker;

import java.util.Locale;
public class TestData {
    Faker faker = new Faker(new Locale("en-GB"));
    String[] genders = {"Male", "Female", "Other"},
            subjects = {"Hindi", "English", "Maths", "Physics", "Chemistry",
                    "Computer Science", "Commerce", "Accounting", "Economics",
                    "Arts", "Social Studies", "History", "Civics"},
            hobbies = {"Sports", "Reading", "Music"},
            states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
            months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                    "October", "November", "December"},
            ncrCities = {"Delhi", "Gurgaon", "Noida"},
            uttarPradeshCities = {"Agra", "Lucknow", "Merrut"},
            haryanaCities = {"Karnal", "Panipat"},
            rajasthanCities = {"Jaipur", "Jaiselmer"};

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String streetAddress = faker.address().streetAddress();
    String gender = faker.options().nextElement(genders);
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String subject = faker.options().nextElement(subjects);
    String hobby = faker.options().nextElement(hobbies);
    String state = faker.options().nextElement(states);
    String img = "photo.jpg";
    String dayOfBirth = getDayOfBirth();
    String month = faker.options().nextElement(months);
    String yearOfBirth = String.valueOf(faker.number().numberBetween(1950, 2000));
    String city = getCity(state);

    public String getDayOfBirth() {
        int day = faker.random().nextInt(1, 28);
        if (day >= 10) {
            return String.format("%s", day);
        } else {
            return String.format("0%s", day);
        }
    }
    public String getCity(String state) {
        if (state.equals("NCR")) {
            return faker.options().nextElement(ncrCities);
        } else if (state.equals("Uttar Pradesh")) {
            return faker.options().nextElement(uttarPradeshCities);
        } else if (state.equals("Haryana")) {
            return faker.options().nextElement(haryanaCities);
        } else {
            return faker.options().nextElement(rajasthanCities);
        }
    }
}
