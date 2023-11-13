package lesson_eight;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeEach
    void beforeEach(){
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920*1080";
        open("https://demoqa.com/automation-practice-form");
    }
}
