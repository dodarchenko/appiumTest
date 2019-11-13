package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginScreenFactory {


    public LoginScreenFactory(AppiumDriver<WebElement> driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.dev.ct.dev:id/CIdLoginView_EmailOrCTraderIdEditText")
    public WebElement emailField;

    @AndroidFindBy(id = "com.dev.ct.dev:id/CIdLoginView_PasswordEditText")
    public WebElement passwordField;

    @AndroidFindBy(className = "android.widget.Button")
    public WebElement signInButton;

    @AndroidFindBy(id = "android:id/button2")
    public WebElement tryAgainButton;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement resetPasswordButton;

    @AndroidFindBy(id="com.dev.ct.dev:id/CIdLoginView_CreateANewAccountHyperlink")
    public WebElement createAccountButton;

    @AndroidFindBy(id="com.dev.ct.dev:id/TutorialStartStepView_NotNowBottom")
    public WebElement notNowTutorialButton;



    public void fillEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void loginClick(){
        signInButton.click();
    }

    public void tryAgainButtonClick(){
        tryAgainButton.click();
    }
    public void resetPasswordClick(){
        resetPasswordButton.click();
    }
    public void createAccountHyperLinkClick(){
        createAccountButton.click();
    }
}
