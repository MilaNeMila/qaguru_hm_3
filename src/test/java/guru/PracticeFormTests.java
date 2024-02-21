package guru;

import com.github.javafaker.Faker;
import guru.registrationComponents.BirthCalendar;
import guru.registrationComponents.RegistrationPage;
import guru.registrationComponents.RequiredFields;
import guru.registrationComponents.UnrequiredFields;
import guru.utils.RandomUtilits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;


public class PracticeFormTests extends TestBase {

 RegistrationPage registrationPage = new RegistrationPage();
 BirthCalendar birthCalendar = new BirthCalendar();
 RequiredFields requiredFields = new RequiredFields();
 UnrequiredFields unrequiredFields = new UnrequiredFields();

    static RandomUtilits randomData = new RandomUtilits();



    @Test
    void fullFieldTest(){
        registrationPage.openPage();
        requiredFields.setFirstName(randomData.firstName)
                .setLastName(randomData.lastName)
                .setNumber(randomData.userNumber)
                .setGenderField(randomData.gender);
        birthCalendar.birthDayInputField(randomData.birthMonth, randomData.birthYear);
        unrequiredFields.setAddress(randomData.userEmail)
                        .setEmail(randomData.userEmail)
                        .setHobbie(randomData.userHobbie)
                        .setSubjects(randomData.userSubjects)
                        .setState(randomData.userState)
                        .setCity(randomData.userCity)
                        .setPicture();

        registrationPage.submitButtonClick();
        registrationPage.assertName(randomData.firstName, randomData.lastName)
                .assertNumber(randomData.userNumber)
                .assertBirth(randomData.birthMonth,randomData.birthYear)
                .assertGender(randomData.gender)
                .assertAddress(randomData.streetAddress)
                .assertEmail(randomData.userEmail)
                .assertHobbie(randomData.userHobbie)
                .assertCity(randomData.userState, randomData.userCity)
                .assertSubjects(randomData.userSubjects);

}

    @Test
    void minimumFieldTest(){
        registrationPage.openPage();
        requiredFields.setFirstName("Name")
                .setLastName("Last")
                .setNumber("7777777777")
                .setGenderField("Female");
        birthCalendar.birthDayInputField("February","2001");
        registrationPage.submitButtonClick();
        registrationPage.assertName("Name", "Last")
                .assertNumber("7777777777")
                .assertBirth("February","2001")
                .assertGender("Female");
    }

    @Test
    void negativTest(){
        registrationPage.openPage().submitButtonClick().validationForm();
    }

}
