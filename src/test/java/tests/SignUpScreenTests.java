package tests;

import com.relevantcodes.extentreports.LogStatus;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginScreenPage;
import pages.SignUpPage;
import report.ExtentTestManager;

public class SignUpScreenTests extends BaseTest {

    SignUpPage signUpPage;

    @BeforeClass
    public void startUp() {
        signUpPage = new SignUpPage(driver);
    }

    @Test(enabled = false)
    public void checkEmailValidationMessage() {

        try {
            signUpPage.fillEmail("test@test");
            Assert.assertTrue(signUpPage.vallidationErrorMessage.isDisplayed());
            signUpPage.emailField.clear();
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }

    @Test(enabled = false)
    public void checkPasswordValidationMessage() {
        try {
            signUpPage.fillPassword("1234");
            Assert.assertTrue(signUpPage.vallidationErrorMessage.isDisplayed());
        } catch (Exception e) {
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }

    @Test(enabled = false)
    public void signUpWithNewEmail() {
        try {
            signUpPage.fillEmail(generateString() + "@autotests.com");
            signUpPage.fillPassword("Testing1");
            signUpPage.signUpButtonClick();
            //need assertion
        } catch (Exception e) {
            signUpPage.fillPassword("1234");
            Assert.assertTrue(signUpPage.vallidationErrorMessage.isDisplayed());
        }
    }

    @Test
    public void changeLanguageInSelector(){
        try {
            signUpPage.openLanguageSelector();
            signUpPage.selectLanguageInSelector(signUpPage.russianLanguageInSelector);
            Assert.assertEquals(signUpPage.getTextOfElement(signUpPage.signUpButton), "СОЗДАТЬ СЧЕТ");
            signUpPage.openLanguageSelector();
            signUpPage.selectLanguageInSelector(signUpPage.englishLanguageInSelector);
            Assert.assertEquals(signUpPage.getTextOfElement(signUpPage.signUpButton), "CREATE ACCOUNT");
        }catch (Exception e){
            ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
            Assert.fail();
        }
    }



}
