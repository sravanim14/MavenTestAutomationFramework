package runners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import org.junit.Before;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;
import utils.DriverBuilder;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@CucumberOptions(
        features = "src/test/resources/webFeatures/",
        glue = {"stepDefinitions", "runners"},
        monochrome = true,
        tags = ""
)
public class WebRunner extends AbstractTestNGCucumberTests{

    public ExtentSparkReporter htmlReporter; //was ExtentHtmlReporter. Now called ExtentSparkReporter in extentreports ver 5.0.x
    public static ExtentReports extent;
    public static ExtentTest logger;
    public String testName = "";
    public int testNum = 1;

    public void setupDriver(String testType) throws MalformedURLException, InterruptedException{
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion", "10");
        browserstackOptions.put("browserVersion", "latest");
        browserstackOptions.put("local", "false");
        browserstackOptions.put("seleniumVersion", "3.141.59");
        capabilities.setCapability("bstack:options", browserstackOptions);

        if (testType.equalsIgnoreCase("chrome")){
            capabilities.setCapability("browserName", "Chrome");
            if (Constants.enable_browserstack){
                DriverBuilder.driver = new RemoteWebDriver(new URL(Constants.BROWSERSTACK_URL), capabilities);
            }
            else {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver110.exe");
                DriverBuilder.driver = new ChromeDriver();
            }
        }
        else if (testType.equalsIgnoreCase("firefox")){
            capabilities.setCapability("browserName", "Firefox");
            if (Constants.enable_browserstack){
                DriverBuilder.driver = new RemoteWebDriver(new URL(Constants.BROWSERSTACK_URL), capabilities);
            }
            else {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver.exe");
                DriverBuilder.driver = new FirefoxDriver();
            }
        }
        else {
        }
    }

    @BeforeTest
    public void beforeTestMethod(){
        Constants.testType = Constants.browser;
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "WebAutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", Constants.nameOfTester);
    }

    @BeforeMethod
    public void beforeMethodMethod(Method testMethod) throws MalformedURLException, InterruptedException {
        logger = extent.createTest(testMethod.getName() + Constants.testType);
        setupDriver(Constants.testType);
        DriverBuilder.driver.manage().window().maximize();
        DriverBuilder.driver.get(Constants.url);
        DriverBuilder.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void afterTestMethod() {
        extent.flush();
    }

    @AfterMethod
    public void afterMethodMethod(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS){
            String methodName = result.getTestContext().getName();
            String logText = "Test Case: " + methodName + " " + testNum + " Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,m);
        }
        else if(result.getStatus() == ITestResult.FAILURE){
            String methodName = result.getTestContext().getName();
            String logText = "Test Case: " + methodName + " " + testNum + " Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL,m);
        }
        else if(result.getStatus() == ITestResult.SKIP){
            String methodName = result.getTestContext().getName();
            String logText = "Test Case: " + methodName + " " + testNum + " Skipped";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            logger.log(Status.SKIP,m);
        }
        testNum++;
        DriverBuilder.driver.quit();
    }

}
