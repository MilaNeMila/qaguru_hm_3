package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests extends Fixture {


    @Test
    void firstTest(){
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        formInputRequiredFields("Name", "lastName", "Female", "7777777777");
        formInputFields("randomtext", "textadress","Sports", "test@test.com");
}

    public void formInputRequiredFields (String FIRST_NAME,
                                         String LAST_NAME,
                                         String GENDER,
                                         String USER_NUMBER) {
        $("#firstName").setValue(FIRST_NAME);
        $("#lastName").setValue(LAST_NAME);
        $("#genterWrapper").$(byText(GENDER)).click();
        $("#userNumber").setValue(USER_NUMBER);

    }

    public void formInputFields(String SUBJECTS,
                                String ADDRESS,
                                String HOBBIE,
                                String EMAIL_USER
                                ){
        $("#userEmail").setValue(EMAIL_USER);
        $("#hobbiesWrapper").$(byText(HOBBIE)).click();
        $("#currentAddress").setValue(ADDRESS);

    }

}
