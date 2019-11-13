package common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public AppiumDriver<WebElement> driver;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"deviceID", "osVersion", "deviceName"})
    public void setUp(String deviceID, String osVersion, String deviceName) throws MalformedURLException {

        //Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("udid", deviceID); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", osVersion);
        caps.setCapability("appPackage", "com.dev.ct.dev");
        caps.setCapability("appActivity", "mobile.droid.ctrader.views.main.SplashScreen");
        caps.setCapability("noReset", "true");
        caps.setCapability("waitForQuiescence", "false");

        //Instantiate Appium Driver

        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.resetApp();
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
