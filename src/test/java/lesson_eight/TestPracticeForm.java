package lesson_eight;

import lesson_eight.component.CalendarComponent;
import lesson_eight.component.CheckResult;
import lesson_eight.faker.FakerBox;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$;
import static lesson_eight.faker.RandomString.*;

public class TestPracticeForm extends BaseTest {
    PageForm pageForm = new PageForm();
    CalendarComponent component = new CalendarComponent();
    CheckResult checkResult = new CheckResult();
    FakerBox fakerBox = new FakerBox();
    String phone = getRandomPhone();
    String month = getRandomMonth();
    String year = getRandomYear();
    String gender = getRandomGender();
    String hobbies = getRandomHobbies();
    String subjects= getRandomSubjects();
    String fileName = "cupcake.png";
    String city = "State and City";
    String gurgaon ="NCR Gurgaon";
    String phoneNumberIsIncorrect = "3456789";
    @Test
    public void formTest() {
        //act
        pageForm.setFirstName(fakerBox.firstName)
                .setLastName(fakerBox.lastName)
                .setUserEmail(fakerBox.userEmai)
                .clickGender(gender)
                .setUserNumber(phone)
                .clickDateOfBirthInput();
        component.setCalendarComponent(month,year);
        pageForm.setSubjects(subjects)
                .setHobbies(hobbies)
                .setPictures(fileName)
                .setCurrentAddress(fakerBox.streetAddress)
                .execute()
                .clickState()
                .clickCity()
                .clickSubmit();
        //assert
        checkResult.checkResult("Student Name", fakerBox.firstName+" "+fakerBox.lastName)
                .checkResult("Student Email", fakerBox.userEmai)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", "01 "+ month+ ","+year)
                .checkResult("Subjects",subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", fileName)
                .checkResult("Address", fakerBox.streetAddress)
                .checkResult(city, gurgaon);

    }

    @Test
    public void formWithEmptyFieldsTest() {
        String gender = getRandomGender();
        pageForm.setFirstName(fakerBox.firstName)
                .setLastName(fakerBox.lastName)
                .clickGender(gender)
                .setUserNumber(phone)
                .clickDateOfBirthInput();
        component.setCalendarComponent(month,year);
        pageForm.execute()
                .clickSubmit();
        //assert
        checkResult.checkResult("Student Name", fakerBox.firstName+" "+fakerBox.lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth","01 "+ month+ ","+year);

    }
    @Test
    public void formPhoneBorderRedTest() {
        String gender = getRandomGender();
        pageForm.setFirstName(fakerBox.firstName)
                .setLastName(fakerBox.lastName)
                .clickGender(gender)
                .setUserNumber(phoneNumberIsIncorrect)
                .clickDateOfBirthInput();
        component.setCalendarComponent(month,year);
        pageForm.execute()
                .clickSubmit();
        //assert
        $("#userNumber").shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
    }
}
