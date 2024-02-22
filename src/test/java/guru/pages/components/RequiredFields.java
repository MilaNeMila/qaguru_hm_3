package guru.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RequiredFields {
    public static SelenideElement firstNameField = $("#firstName"),
            lastNameField = $("#lastName"),
            genderField = $("#genterWrapper"),
            numberField = $("#userNumber");

    public RequiredFields setFirstName (String firstName) {
        firstNameField.setValue(firstName);
        return this;
    }
    public RequiredFields setLastName (String lastName) {
        lastNameField.setValue(lastName);
        return this;
    }
    public RequiredFields setNumber (String userNumber) {
        numberField.setValue(userNumber);
        return this;
    }


    public RequiredFields setGenderField(String gender){
        genderField.$(byText(gender)).click();
        return this;
    }
}
