package guru.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private static SelenideElement tableField = $(".table"),
            submitButton = $("#submit"),
            userForm = $("#userForm");;
    public RegistrationPage openPage(){
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage assertName(String firstName,
                                       String lastName){
        tableField.shouldHave(text(firstName+ " " + lastName));
        return this;
    }

    public RegistrationPage assertGender(String gender){
        tableField.shouldHave(text(gender));
        return this;
    }

    public RegistrationPage assertNumber(String userNumber){
        tableField.shouldHave(text(userNumber));
        return this;
    }
    public RegistrationPage assertBirth(String month,
                                        String year){
        tableField.shouldHave(text("26 "+month+","+year));
        return this;
    }

    public RegistrationPage assertSubjects(String subjects){
        tableField.shouldHave(text(subjects));
        return this;
    }

    public RegistrationPage assertAddress(String address){
        tableField.shouldHave(text(address));
        return this;
    }
    public RegistrationPage assertHobbie(String hobbie
    ){
        tableField.shouldHave(text(hobbie));
        return this;
    }

    public RegistrationPage assertEmail(String emailUser){
        tableField.shouldHave(text(emailUser));
        return this;
    }

    public RegistrationPage assertCity(String state,
                                       String city){
        tableField.shouldHave(text(state +" " +city));
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
}
