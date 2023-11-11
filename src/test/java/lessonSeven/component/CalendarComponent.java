package lessonSeven.component;

import com.codeborne.selenide.SelenideElement;
import lessonSeven.PageForm;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement datepickerMonth = $(".react-datepicker__month-select");
    private SelenideElement datepickerDey = $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)");
    private SelenideElement datepickerYear = $(".react-datepicker__year-select");

    public CalendarComponent setCalendarComponent(String month, String year, String day){
        datepickerMonth.click();
        datepickerMonth.selectOption(month);
        datepickerYear.click();
        datepickerYear.selectOption(year);
        datepickerDey.hover().click();
        return this;

    }




}
