package lesson_seven;

import lesson_seven.component.CalendarComponent;
import lesson_seven.component.CheckResult;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$;

public class TestPracticeForm extends BaseTest {
    PageForm pageForm = new PageForm();
    CalendarComponent component = new CalendarComponent();
    CheckResult checkResult = new CheckResult();

    @Test
    public void formTest() {
        pageForm.setFirstName("София")
                .setLastName("Прекрасная")
                .setUserEmail("QA_duru@googl.com")
                .clickGender()
                .setUserNumber("7919345779")
                .clickDateOfBirthInput();
        component.setCalendarComponent("April", "2002");
        pageForm.setSubjects("Computer Science")
                .setHobbies("Sports")
                .setPictures("cupcake.png")
                .setCurrentAddress("Москва, Скатертный переулок 16")
                .execute()
                .clickState()
                .clickCity()
                .clickSubmit();
        //assert
        checkResult.checkResult("Student Name", "София Прекрасная")
                .checkResult("Student Email", "QA_duru@googl.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "7919345779")
                .checkResult("Date of Birth", "01 April,2002")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "cupcake.png")
                .checkResult("Address", "Москва, Скатертный переулок 16")
                .checkResult("State and City", "NCR Gurgaon");

    }

    @Test
    public void formWithEmptyFieldsTest() {
        pageForm.setFirstName("София")
                .setLastName("Прекрасная")
                .clickGender()
                .setUserNumber("7919345779")
                .clickDateOfBirthInput();
        component.setCalendarComponent("April", "2002");
        pageForm.execute()
                .clickSubmit();
        //assert
        checkResult.checkResult("Student Name", "София Прекрасная")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "7919345779")
                .checkResult("Date of Birth", "01 April,2002");

    }
    @Test
    public void formPhoneBorderRedTest() {
        pageForm.setFirstName("София")
                .setLastName("Прекрасная")
                .clickGender()
                .setUserNumber("791934")
                .clickDateOfBirthInput();
        component.setCalendarComponent("April", "2002");
        pageForm.execute()
                .clickSubmit();
        //assert
        $("#userNumber").shouldHave(cssValue("border-color","rgb(220, 53, 69)"));


    }
}
