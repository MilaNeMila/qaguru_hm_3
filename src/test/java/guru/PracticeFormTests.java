package guru;

import guru.registrationComponents.BirthCalendar;
import guru.registrationComponents.RegistrationPage;
import guru.registrationComponents.RequiredFields;
import guru.registrationComponents.UnrequiredFields;
import org.junit.jupiter.api.Test;


public class PracticeFormTests extends TestBase {

 RegistrationPage registrationPage = new RegistrationPage();
 BirthCalendar birthCalendar = new BirthCalendar();
 RequiredFields requiredFields = new RequiredFields();
 UnrequiredFields unrequiredFields = new UnrequiredFields();


    @Test
    void fullFieldTest(){
        registrationPage.openPage();
        requiredFields.setFirstName("Name")
                .setLastName("Last")
                .setNumber("7777777777")
                .setGenderField("Female");
        birthCalendar.birthDayInputField("February","2001");
        unrequiredFields.setAddress("Address")
                        .setEmail("test@test.com")
                        .setHobbie("Sports")
                        .setState("NCR")
                        .setSubjects("Arts")
                        .setCity("Delhi")
                        .setPicture();
        registrationPage.submitButtonClick();
        registrationPage.assertName("Name", "Last")
                .assertNumber("7777777777")
                .assertBirth("February","2001")
                .assertGender("Female")
                .assertAddress("Address")
                .assertEmail("test@test.com")
                .assertHobbie("Sports")
                .assertCity("NCR", "Delhi")
                .assertSubjects("Arts");

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
