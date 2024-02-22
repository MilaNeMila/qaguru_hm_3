package guru.tests;

import guru.TestBase;
import guru.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends TestBase {
    TextBoxPage textBox = new TextBoxPage();

    @Test
    public void fullFieldTest(){
        textBox.openPage()
                .setUserName("Name")
                .setUserEmail("test@test.com")
                .setCurrentAddress("Current Address")
                .setPermanentAddress("Permanent Address")
                .submitButtonClick()
                .assertForm("Name", "test@test.com", "Current Address", "Permanent Address");
    }
}
