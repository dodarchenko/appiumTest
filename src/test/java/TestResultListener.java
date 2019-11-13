import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.*;


public class TestResultListener extends BaseTest implements ITestListener{

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        Object testClass = iTestResult.getInstance();
        AppiumDriver  <WebElement> driver = ((BaseTest) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed"+ ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));

}

        @Override
    public void onTestSkipped(ITestResult iTestResult) {

        ExtentTestManager.skippedTest(iTestResult.getMethod().getMethodName(), " ");
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        iTestContext.setAttribute("WebDriver", this.driver);

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentTestManager.endTest();
        ExtentFactory.getInstance().flush();

    }
}