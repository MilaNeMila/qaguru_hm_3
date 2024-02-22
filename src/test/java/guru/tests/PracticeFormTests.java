package guru.tests;

import guru.TestBase;
import guru.pages.components.BirthCalendar;
import guru.pages.RegistrationPage;
import guru.pages.components.StudentTableForm;
import guru.utils.RandomUtilits;
import org.junit.jupiter.api.Test;


public class PracticeFormTests extends TestBase {

 RegistrationPage registrationPage = new RegistrationPage();
 StudentTableForm studentTableForm = new StudentTableForm();
 BirthCalendar birthCalendar = new BirthCalendar();
 RandomUtilits randomData = new RandomUtilits();



    @Test
    void fullFieldTest(){
        registrationPage.openPage();
        registrationPage.setFirstName(randomData.firstName)
                .setLastName(randomData.lastName)
                .setNumber(randomData.userNumber)
                .setGenderField(randomData.gender);
        birthCalendar.birthDayInputField(randomData.birthMonth, randomData.birthYear);
        registrationPage.setAddress(randomData.streetAddress)
                        .setEmail(randomData.userEmail)
                        .setHobbie(randomData.userHobbie)
                        .setSubjects(randomData.userSubjects)
                        .setState(randomData.userState)
                        .setCity(randomData.userCity)
                        .setPicture();

        registrationPage.submitButtonClick();
        studentTableForm.assertName(randomData.firstName, randomData.lastName)
                .assertFieldShouldHave(randomData.userNumber)
                .assertBirth(randomData.birthMonth,randomData.birthYear)
                .assertFieldShouldHave(randomData.gender)
                .assertFieldShouldHave(randomData.streetAddress)
                .assertFieldShouldHave(randomData.userEmail)
                .assertFieldShouldHave(randomData.userHobbie)
                .assertCity(randomData.userState, randomData.userCity)
                .assertFieldShouldHave(randomData.userSubjects);

}

    @Test
    void minimumFieldTest(){
        registrationPage.openPage();
        registrationPage.setFirstName("Name")
                .setLastName("Last")
                .setNumber("7777777777")
                .setGenderField("Female");
        birthCalendar.birthDayInputField("February","2001");
        registrationPage.submitButtonClick();
        studentTableForm.assertName("Name", "Last")
                .assertFieldShouldHave("7777777777")
                .assertBirth("February","2001")
                .assertFieldShouldHave("Female");
    }

    @Test
    void negativTest(){
        registrationPage.openPage().submitButtonClick().validationForm();
    }

}
