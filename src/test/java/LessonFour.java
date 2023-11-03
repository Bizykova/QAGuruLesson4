
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LessonFour extends BaseTest {

    //ДЗ 4. Selenide #1.
    //  1. Есть ли разница между $("h1 div"); и $("h1").$("div");
    //  ответ -  найдет первый div который обернут в h1, надет первый h1 в котором div мщжет отсутствовать.

    @Test
    void SoftAssertionsTest() {
        //arrange
        open("https://www.github.com/selenide/selenide");
        //act
        $("a#wiki-tab").click();
        $("[data-filterable-for=wiki-pages-filter]").lastChild().$("button").click();
        $("[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions")).click();
        //assert
        $("#user-content-3-using-junit5-extend-test-class a").shouldHave(text("3. Using JUnit5 extend test class:"));

    }


    //ДЗ 5. Selenide #2.
    @Test
    void  menuSolutions(){
        //arrange
        open("https://www.github.com/");
        //act
        $(byText("Solutions")).parent().hover().$(".HeaderMenu-dropdown ul").$(byText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));

    }

    @Test
    void dragAndDrop (){
        //arrange
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //act
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(200,0).release().perform();
        //assert
        $$("#columns .column").first().shouldNotHave(text("a"));

    }
//    @Test
//    void dragAndDrop2 () {
//        open("https://the-internet.herokuapp.com/drag_and_drop");
//        $("#column-a").dragAndDrop($("#column-b"));
//    }
}
