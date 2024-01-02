package guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class Fixture {
    @BeforeAll
    static void browserSettings(){
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.pageLoadStrategy = "eager";
    }
}
