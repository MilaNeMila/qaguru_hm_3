package guru.utils;
import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RandomUtilits {
    static Faker faker = new Faker(new Locale("ru"));
    static Faker emailFaker = new Faker(new Locale("eng"));

    static public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = emailFaker.internet().emailAddress(),
            streetAddress = faker.twinPeaks().quote(),
            userNumber = faker.phoneNumber().subscriberNumber(11),
            gender = randomGender(),
            birthMonth = randomMonth(),
            birthYear = String.valueOf(faker.number().numberBetween(1950, 2024)),
            userState = randomState(),
            userCity = cityByState(userState),
            userSubjects = randomSubjects(),
            userHobbie = randomHobbie();


    static public String randomMonth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    static public String randomHobbie() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    static public String randomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    static public String randomSubjects() {
        return faker.options().option("Maths", "Arts", "English", "Biology");
    }

    static public String randomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    static public String cityByState(String state) {
        Map<String, String> city = new HashMap<>() {{
            put("NCR","Delhi");
            put("NCR","Gurgaon");
            put("NCR","Noida");
            put("Uttar Pradesh","Agra");
            put("Uttar Pradesh","Lucknow");
            put("Uttar Pradesh","Merrut");
            put("Haryana","Karnal");
            put("Haryana","Panipat");
            put("Rajasthan","Jaipur");
            put("Rajasthan","Jaiselmer");
        }};
        return city.get(state);
    }
}
