package tests;

import com.relevantcodes.extentreports.LogStatus;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginScreenFactory;
import report.ExtentTestManager;


public class SignInScreenTests extends BaseTest {

    LoginScreenFactory loginScreenFactory;

    @BeforeClass
    public void startUp(){
        loginScreenFactory = new LoginScreenFactory(driver);
    }


    @Test
    public void firstTest() {
        try {
            ExtentTestManager.getTest().setDescription("Test sign up");

            loginScreenFactory.fillEmail("dodarchenko+4e");
            loginScreenFactory.fillPassword("Testing1");
            loginScreenFactory.loginClick();
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public  void checkPasswordValidationPopUp(){
        ExtentTestManager.getTest().setDescription("Test password validation Pop up");
        try{

            loginScreenFactory.fillEmail("dodarchenko+4e");
            loginScreenFactory.fillPassword("dsadasda");
            loginScreenFactory.loginClick();
            Assert.assertTrue(loginScreenFactory.tryAgainButton.isDisplayed());
            loginScreenFactory.tryAgainButtonClick();
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }
}
