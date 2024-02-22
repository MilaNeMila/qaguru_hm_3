package guru.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private static SelenideElement submitButton = $("#submit"),
            userForm = $("#userForm"),
            subjectsField = $("#subjectsInput"),
            emailField = $("#userEmail"),
            hobbieField = $("#hobbiesWrapper"),
            addressField = $("#currentAddress"),
            pictureField = $("#uploadPicture"),
            stateCityField = $("#stateCity-wrapper"),
            firstNameField = $("#firstName"),
            lastNameField = $("#lastName"),
            genderField = $("#genterWrapper"),
            numberField = $("#userNumber");

    public RegistrationPage openPage(){
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage submitButtonClick(){
        submitButton.click();
        return this;
    }

    public RegistrationPage validationForm(){
        userForm.shouldHave(cssClass("was-validated"));
        return this;
    }

    public RegistrationPage setFirstName (String firstName) {
        firstNameField.setValue(firstName);
        return this;
    }
    public RegistrationPage setLastName (String lastName) {
        lastNameField.setValue(lastName);
        return this;
    }
    public RegistrationPage setNumber (String userNumber) {
        numberField.setValue(userNumber);
        return this;
    }


    public RegistrationPage setGenderField(String gender){
        genderField.$(byText(gender)).click();
        return this;
    }


    public RegistrationPage setSubjects(String subjects){
        subjectsField.setValue(subjects).pressEnter();
        return this;
    }
    public RegistrationPage setPicture(){
        pictureField.uploadFromClasspath("photo_2024-01-02_16-20-48.jpg");
        return this;
    }

    public RegistrationPage setEmail(String emailUser){
        emailField.setValue(emailUser);
        return this;
    }
    public RegistrationPage setAddress(String address){
        addressField.setValue(address);
        return this;
    }
    public RegistrationPage setHobbie(String hobbie){
        hobbieField.$(byText(hobbie)).click();
        return this;
    }

    public RegistrationPage setState(String state){
        stateCityField.$(byText("Select State")).click();
        stateCityField.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city){
        stateCityField.$(byText("Select City")).click();
        stateCityField.$(byText(city)).click();
        return this;
    }


}
