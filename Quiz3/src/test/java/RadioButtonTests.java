import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Listeners({ScreenShooter.class})
public class RadioButtonTests {

    @BeforeSuite
    public void defaultConfiguration() {
        Configuration.headless = true;
        Configuration.assertionMode = AssertionMode.SOFT;
        Configuration.baseUrl = "https://demoqa.com";
        ScreenShooter.captureSuccessfulTests = true;
        Configuration.screenshots = true;
    }

    @BeforeClass
    public void failedScreenshots() {
        Configuration.reportsFolder = "src/RadioButtonFailedTests";
    }

    @Test
    public void clickYes() {
        open("/radio-button");

        if ($("#yesRadio").isSelected()) {
            $("#yesRadio").click();

            new SoftAssert().assertTrue($("#yesRadio").isSelected());
        }
    }

    @Test
    public void checkNo() {
        open("/radio-button");

        Assert.assertTrue($("#noRadio").isEnabled());
    }


}
