package guru.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class UnrequiredFields {
    private static SelenideElement subjectsField = $("#subjectsInput"),
            emailField = $("#userEmail"),
            hobbieField = $("#hobbiesWrapper"),
            addressField = $("#currentAddress"),
            pictureField = $("#uploadPicture"),
            stateCityField = $("#stateCity-wrapper");
    public UnrequiredFields setSubjects(String subjects){
        subjectsField.setValue(subjects).pressEnter();
        return this;
    }
    public UnrequiredFields setPicture(){
        pictureField.uploadFromClasspath("photo_2024-01-02_16-20-48.jpg");
        return this;
    }

    public UnrequiredFields setEmail(String emailUser){
        emailField.setValue(emailUser);
        return this;
    }
    public UnrequiredFields setAddress(String address){
        addressField.setValue(address);
        return this;
    }
    public UnrequiredFields setHobbie(String hobbie){
        hobbieField.$(byText(hobbie)).click();
        return this;
    }

    public UnrequiredFields setState(String state){
        stateCityField.$(byText("Select State")).click();
        stateCityField.$(byText(state)).click();
        return this;
    }

    public UnrequiredFields setCity(String city){
        stateCityField.$(byText("Select City")).click();
        stateCityField.$(byText(city)).click();
        return this;
    }
}
