package guru.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private static SelenideElement userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit");

    private static SelenideElement outputUserName = $("#output #name"),
            outputUserEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");
    public TextBoxPage openPage(){
        open("text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName(String name){
        userName.setValue(name);
        return this;
    }
    public TextBoxPage setUserEmail(String email){
        userEmail.setValue(email);
        return this;
    }
    public TextBoxPage setCurrentAddress(String address){
        currentAddress.setValue(address);
        return this;
    }
    public TextBoxPage setPermanentAddress(String address){
        permanentAddress.setValue(address);
        return this;
    }

    public TextBoxPage submitButtonClick(){
        submitButton.click();
        return this;
    }

    public TextBoxPage assertForm(String name, String email, String currentAddress, String permanentAddress){
        outputUserName.shouldHave(text(name));
        outputUserEmail.shouldHave(text(email));
        outputCurrentAddress.shouldHave(text(currentAddress));
        outputPermanentAddress.shouldHave(text(permanentAddress));
        return this;
    }


}
