package tests;

import com.relevantcodes.extentreports.LogStatus;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginScreenPage;
import pages.SignUpPage;
import report.ExtentTestManager;


public class SignInScreenTests extends BaseTest {

    LoginScreenPage loginScreenPage;
    SignUpPage signUpPage;
    @BeforeClass
    public void startUp(){
        loginScreenPage = new LoginScreenPage(driver);
        signUpPage = new SignUpPage(driver);
    }


    @Test(priority = 2)
    public void signInTest() {
        try {
            ExtentTestManager.getTest().setDescription("Test sign in with valida data");
            if(signUpPage.alreadyHaveAnAccountLink.isDisplayed()){
                signUpPage.alreadyHaveAnAccountLinkClick();
                ExtentTestManager.getTest().log(LogStatus.INFO, "Switch to Sign in Screen");
            }

            loginScreenPage.fillEmail("dodarchenko+4e");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in email");
            loginScreenPage.fillPassword("Testing1");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in password");
            loginScreenPage.loginClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Click Login button");
            Assert.assertTrue(loginScreenPage.notNowTutorialButton.isDisplayed());
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }

    @Test(priority = 1)
    public  void checkPasswordValidationPopUp(){
        ExtentTestManager.getTest().setDescription("Test password validation Pop up");
        try{
            loginScreenPage.fillEmail("dodarchenko+4e");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in email");
            loginScreenPage.fillPassword("dsadasda");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in invalid password");
            loginScreenPage.loginClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Click Login button");
            Assert.assertTrue(loginScreenPage.tryAgainButton.isDisplayed());
            loginScreenPage.tryAgainButtonClick();
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void checkEmailValidationMessage(){
        try{
            loginScreenPage.fillEmail("asdasd@asda");
            Assert.assertTrue(loginScreenPage.vallidationErrorMessage.isDisplayed());
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }


}
