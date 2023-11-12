package lesson_four;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LessonFourPartOne extends BaseTest {

    //ДЗ 4. Selenide #1.
    //  1. Есть ли разница между $("h1 div"); и $("h1").$("div");
    //  ответ -  найдет первый div который обернут в h1, надет первый h1 в котором div мщжет отсутствовать.

    @Test
    void softAssertionsTest() {
        //arrange
        open("https://www.github.com/selenide/selenide");
        //act
        $("a#wiki-tab").click();
        $("[data-filterable-for=wiki-pages-filter]").lastChild().$("button").click();
        $("[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions")).click();
        //assert
        $("#user-content-3-using-junit5-extend-test-class a").shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}
