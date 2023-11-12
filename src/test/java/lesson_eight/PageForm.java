package lesson_eight;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageForm {
    private SelenideElement firstName = $("#firstName");
    private SelenideElement lastName = $("#lastName");
    private SelenideElement userEmail = $("#userEmail");
    private SelenideElement gender = $("#genterWrapper");
    private SelenideElement userNumber = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjects = $("#subjectsInput");
    private SelenideElement hobbies = $("#hobbiesWrapper");
    private SelenideElement pictures = $("#uploadPicture");
    private SelenideElement currentAddress = $("#currentAddress");
    private SelenideElement state = $("#state");
    private SelenideElement city = $("#city");
    private SelenideElement optionMenuNCR = $(byText("NCR"));
    private SelenideElement cityGurgaon = $(byText("Gurgaon"));
    private SelenideElement submit = $("#submit");

    public PageForm setFirstName(String name) {
        firstName.setValue(name);
        return this;
    }

    public PageForm setLastName(String lastNam) {
        lastName.setValue(lastNam);
        return this;
    }

    public PageForm setUserEmail(String userEm) {
        userEmail.setValue(userEm);
        return this;
    }

    public PageForm clickGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    public PageForm setUserNumber(String userNumber) {
        this.userNumber.setValue(userNumber);
        return this;
    }

    public PageForm clickDateOfBirthInput() {
        dateOfBirthInput.click();
        return this;
    }

    public PageForm setSubjects(String value) {
        this.subjects.click();
        this.subjects.setValue(value).hover().pressEnter();
        return this;
    }

    public PageForm setHobbies(String value) {
        this.hobbies.$(byText(value)).click();
        return this;
    }

    public PageForm setPictures(String fileName) {
        pictures.uploadFromClasspath(fileName);
        return this;
    }

    public PageForm setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public PageForm clickState() {
        state.click();
        optionMenuNCR.click();
        return this;
    }

    public PageForm clickCity() {
        city.click();
        cityGurgaon.click();
        return this;
    }

    public PageForm clickSubmit() {
        submit.click();
        return this;
    }
    public PageForm execute(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

}
