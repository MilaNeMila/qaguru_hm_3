package guru;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests extends TestBase {


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

    public void formInputRequiredFields (String firstName,
                                         String lastName,
                                         String gender,
                                         String userNumber) {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
    }

    public void formInputFields(String subjects,
                                String address,
                                String hobbie,
                                String emailUser,
                                String state,
                                String city
                                ){
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#userEmail").setValue(emailUser);
        $("#hobbiesWrapper").$(byText(hobbie)).click();
        $("#currentAddress").setValue(address);
        $("#uploadPicture").uploadFromClasspath("photo_2024-01-02_16-20-48.jpg");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }

    public void birthDayInputField(String month,
                                   String year
                                   ){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--026").click();
    }

    public void assertsFormsRequiredFields(String firstName,
                                           String lastName,
                                           String gender,
                                           String userNumber,
                                           String month,
                                           String year){
        $(".table").shouldHave(text(firstName+ " " + lastName));
        $(".table").shouldHave(text(gender));
        $(".table").shouldHave(text(userNumber));
        $(".table").shouldHave(text("26 "+month+","+year));
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
