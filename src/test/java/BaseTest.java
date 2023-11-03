import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    void BeforeEach(){
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        //Configuration.browserSize = "1920*1080";

    }
}
