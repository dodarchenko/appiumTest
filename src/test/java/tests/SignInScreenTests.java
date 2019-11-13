package tests;

import com.relevantcodes.extentreports.LogStatus;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginScreenFactory;
import pages.SignUpPage;
import report.ExtentTestManager;


public class SignInScreenTests extends BaseTest {

    LoginScreenFactory loginScreenFactory;
    SignUpPage signUpPage;
    @BeforeClass
    public void startUp(){
        loginScreenFactory = new LoginScreenFactory(driver);
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

            loginScreenFactory.fillEmail("dodarchenko+4e");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in email");
            loginScreenFactory.fillPassword("Testing1");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in password");
            loginScreenFactory.loginClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Click Login button");
            Assert.assertTrue(loginScreenFactory.notNowTutorialButton.isDisplayed());
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }

    @Test(priority = 1)
    public  void checkPasswordValidationPopUp(){
        ExtentTestManager.getTest().setDescription("Test password validation Pop up");
        try{
            loginScreenFactory.fillEmail("dodarchenko+4e");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in email");
            loginScreenFactory.fillPassword("dsadasda");
            ExtentTestManager.getTest().log(LogStatus.INFO, "Fill in invalid password");
            loginScreenFactory.loginClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Click Login button");
            Assert.assertTrue(loginScreenFactory.tryAgainButton.isDisplayed());
            loginScreenFactory.tryAgainButtonClick();
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }
    @Test
    public void openSignInScreen(){
        ExtentTestManager.getTest().setDescription("Test transition to Sign in screen");
        try{
            signUpPage.alreadyHaveAnAccountLinkClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Switch to Sign in screen");
            Assert.assertTrue(loginScreenFactory.createAccountButton.isDisplayed());
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }
    @Test(priority = 1)
    public void openSignUpScreen(){
        ExtentTestManager.getTest().setDescription("Test transition to Sign Up screen");
        try{
            loginScreenFactory.createAccountHyperLinkClick();
            ExtentTestManager.getTest().log(LogStatus.INFO, "Switch to Sign up screen");
            Assert.assertTrue(signUpPage.alreadyHaveAnAccountLink.isDisplayed());
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }
}
