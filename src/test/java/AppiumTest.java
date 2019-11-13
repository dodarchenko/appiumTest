import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTest extends BaseTest {

    LoginScreenFactory loginScreenFactory;


    @Test
    public void firstTest() {
        try {
            ExtentTestManager.getTest().setDescription("Test sign up");
            loginScreenFactory = new LoginScreenFactory(driver);
            loginScreenFactory.fillEmail("dodarchenko+4e");
            loginScreenFactory.fillPassword("Testing1");
            loginScreenFactory.loginClick();
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();

        }

    }
}
