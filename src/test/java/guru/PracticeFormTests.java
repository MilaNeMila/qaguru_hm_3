package guru;

import org.junit.jupiter.api.Test;

import java.util.SplittableRandom;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests extends Fixture{


    @Test
    void firstTest(){
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        formInputRequiredFields("Name", "lastName", "Female", "7777777777");
        birthDayInputField("February","2001");
        formInputFields("Arts", "textadress","Sports", "test@test.com", "NCR", "Delhi");
        $("#submit").click();
        assertsFormsRequiredFields("Name", "lastName", "Female","7777777777","February","2001");
        assertsForms("Arts","textadress","Sports","test@test.com","NCR","Delhi");
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
                                String EMAIL_USER,
                                String STATE,
                                String CITY
                                ){
        $("#subjectsInput").setValue(SUBJECTS).pressEnter();
        $("#userEmail").setValue(EMAIL_USER);
        $("#hobbiesWrapper").$(byText(HOBBIE)).click();
        $("#currentAddress").setValue(ADDRESS);
        $("#uploadPicture").uploadFromClasspath("photo_2024-01-02_16-20-48.jpg");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText(STATE)).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText(CITY)).click();
    }

    public void birthDayInputField(String MONTH,
                                   String YEAR
                                   ){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(MONTH);
        $(".react-datepicker__year-select").selectOption(YEAR);
        $(".react-datepicker__day--026").click();
    }

    public void assertsFormsRequiredFields(String FIRST_NAME,
                                           String LAST_NAME,
                                           String GENDER,
                                           String USER_NUMBER,
                                           String MONTH,
                                           String YEAR){
        $(".table").shouldHave(text(FIRST_NAME+ " " + LAST_NAME));
        $(".table").shouldHave(text(GENDER));
        $(".table").shouldHave(text(USER_NUMBER));
        $(".table").shouldHave(text("26 "+MONTH+","+YEAR));
    }

    public void assertsForms(String SUBJECTS,
                             String ADDRESS,
                             String HOBBIE,
                             String EMAIL_USER,
                             String STATE,
                             String CITY
    ){
        $(".table").shouldHave(text(SUBJECTS));
        $(".table").shouldHave(text(ADDRESS));
        $(".table").shouldHave(text(HOBBIE));
        $(".table").shouldHave(text(EMAIL_USER));
        $(".table").shouldHave(text(STATE +" " +CITY));
    }
}
