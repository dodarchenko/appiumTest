package tests;

import com.relevantcodes.extentreports.LogStatus;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentTestManager;


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
