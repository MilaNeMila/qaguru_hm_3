package guru.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BirthCalendar {
    private static SelenideElement birthCalendarField = $("#dateOfBirthInput"),
            birthYearField = $(".react-datepicker__year-select"),
            birthMonthField = $(".react-datepicker__month-select"),
            birthDayField = $(".react-datepicker__day--026");
    public void birthDayInputField(String month,
                                   String year
    ){
        birthCalendarField.click();
        birthMonthField.selectOption(month);
        birthYearField.selectOption(year);
        birthDayField.click();
    }
}
