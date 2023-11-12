package lesson_four;

import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LessonFourPartTwo extends BaseTest {
    //ДЗ 5. Selenide #2.
    @Test
    void  menuSolutionsTest(){
        //arrange
        open("https://www.github.com/");
        //act
        $(byText("Solutions")).parent().hover().$(".HeaderMenu-dropdown ul").$(byText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));
    }
    @Test
    void dragAndDropTest (){
        //arrange
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //act
        $("#column-a").$("header").shouldHave(text("A"));
        $("#column-b").$("header").shouldHave(text("B"));
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(200,0).release().perform();
        //assert
        $$("#columns .column").first().shouldNotHave(text("a"));
        $$("#columns .column").get(1).shouldNotHave(text("B"));

    }
    @Test
    void dragAndDrop2Test() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").$("header").shouldHave(text("A"));
        $("#column-b").$("header").shouldHave(text("B"));
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
    }
}
