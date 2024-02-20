package guru.textBoxComponents;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBox {
    private static SelenideElement userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit");

    private static SelenideElement outputUserName = $("#output #name"),
            outputUserEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");
    public TextBox openPage(){
        open("text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBox setUserName(String name){
        userName.setValue(name);
        return this;
    }
    public TextBox setUserEmail(String email){
        userEmail.setValue(email);
        return this;
    }
    public TextBox setCurrentAddress(String address){
        currentAddress.setValue(address);
        return this;
    }
    public TextBox setPermanentAddress(String address){
        permanentAddress.setValue(address);
        return this;
    }

    public TextBox submitButtonClick(){
        submitButton.click();
        return this;
    }

    public TextBox assertForm(String name, String email, String currentAddress, String permanentAddress){
        outputUserName.shouldHave(text(name));
        outputUserEmail.shouldHave(text(email));
        outputCurrentAddress.shouldHave(text(currentAddress));
        outputPermanentAddress.shouldHave(text(permanentAddress));
        return this;
    }


}
