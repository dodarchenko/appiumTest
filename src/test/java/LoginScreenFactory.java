import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginScreenFactory {


    public LoginScreenFactory(AppiumDriver<WebElement> driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.dev.ct.dev:id/CIdLoginView_EmailOrCTraderIdEditText")
    public WebElement emailField;

    @AndroidFindBy(id = "com.dev.ct.dev:id/CIdLoginView_PasswordEditText1")
    public WebElement passwordField;

    @AndroidFindBy(className = "android.widget.Button")
    public WebElement signInButton;


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
}
