package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    public SignUpPage(AppiumDriver<WebElement> driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.dev.ct.dev:id/CIdCreateAccountView_EmailOrCTraderIdEditText")
    public WebElement emailField;

    @AndroidFindBy(id = "com.dev.ct.dev:id/CIdCreateAccountView_PasswordEditText")
    public WebElement passwordField;

    @AndroidFindBy(className = "android.widget.Button")
    public WebElement signUpButton;

    @AndroidFindBy(id = "com.dev.ct.dev:id/CIdCreateAccountView_LogInHyperlink")
    public WebElement alreadyHaveAnAccountLink;


    public void fillEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void alreadyHaveAnAccountLinkClick(){
        alreadyHaveAnAccountLink.click();
    }

}
