package guru;

import guru.textBoxComponents.TextBox;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends TestBase{
    TextBox textBox = new TextBox();

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
