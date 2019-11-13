package common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public AppiumDriver<WebElement> driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws MalformedURLException {

        //Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("deviceName", "Pixel 2");
        //caps.setCapability("udid", "emulator-5554");
        caps.setCapability("deviceName", "NEXUS 5X");
        caps.setCapability("udid", "025ab90b307ecdd0"); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0");
        caps.setCapability("appPackage", "com.dev.ct.dev");
        caps.setCapability("appActivity", "mobile.droid.ctrader.views.main.SplashScreen");
        caps.setCapability("noReset", "true");
        caps.setCapability("waitForQuiescence", "false");

        //Instantiate Appium Driver

        //driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    public AppiumDriver<WebElement> getDriver() {
        return driver;
    }

    public void setDriver(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }
}
