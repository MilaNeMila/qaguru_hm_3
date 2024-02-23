package guru.pages.components;

import com.codeborne.selenide.SelenideElement;
import guru.utils.RandomUtilits;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BirthCalendar {

    private SelenideElement birthCalendarField = $("#dateOfBirthInput");
    private SelenideElement birthYearField = $(".react-datepicker__year-select");
    private SelenideElement birthMonthField = $(".react-datepicker__month-select");


    public void birthDayInputField(String day,
                                   String month,
                                   String year){
        birthCalendarField.click();
        birthMonthField.selectOption(month);
        birthYearField.selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month").click();
    }


}
