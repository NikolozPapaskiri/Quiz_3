import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import com.codeborne.selenide.testng.ScreenShooter;

import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@Listeners({ ScreenShooter.class})
public class CheckboxTests {

    @BeforeSuite
    public void defaultConfiguration() {
        Configuration.timeout = 10000;
        Configuration.proxyEnabled = false;
        Configuration.baseUrl = "http://the-internet.herokuapp.com";
        ScreenShooter.captureSuccessfulTests = true;
        Configuration.screenshots = true;
    }

    @BeforeClass
    public void failedScreenshots() {
        Configuration.reportsFolder = "src/CheckboxFailedTests";
    }

    @Test(dependsOnMethods = { "checkUnchecked" }, alwaysRun = true)
    private void uncheckChecked() {
        open("/checkboxes");
        List<SelenideElement> checkboxes = $$("input[type = checkbox]");

        for (SelenideElement checkbox:checkboxes) {
            if (checkbox.is(checked)) {
                checkbox.click();
            }
            new SoftAssert().assertEquals(checkbox.is(checked), true);
        }
    }

    @Test
    private void checkUnchecked() {
        open("/checkboxes");
        List<SelenideElement> checkboxes = $$("input[type = checkbox]");

        for (SelenideElement checkbox:checkboxes) {
            if (checkbox.is(checked)) {
                checkbox.click();
            }
            new SoftAssert().assertEquals(checkbox.is(checked), false);
        }
    }
}
