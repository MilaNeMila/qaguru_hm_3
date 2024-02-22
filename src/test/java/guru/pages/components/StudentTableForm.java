package guru.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class StudentTableForm {

    private static SelenideElement tableField = $(".table");

    public StudentTableForm assertName(String firstName,
                                       String lastName){
        tableField.shouldHave(text(firstName+ " " + lastName));
        return this;
    }

    public StudentTableForm assertFieldShouldHave(String value){
        tableField.shouldHave(text(value));
        return this;
    }

    public StudentTableForm assertBirth(String day,
                                        String month,
                                        String year){
        tableField.shouldHave(text(day+" "+month+","+year));
        return this;
    }

    public StudentTableForm assertCity(String state,
                                       String city){
        tableField.shouldHave(text(state +" " +city));
        return this;
    }
}
