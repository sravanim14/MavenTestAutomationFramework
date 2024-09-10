package runners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;


@CucumberOptions(
        features = "src/test/resources/apiFeatures/",
        glue = {"stepDefinitions", "runners"},
        monochrome = true,
        tags = ""
)
public class ApiRunner extends AbstractTestNGCucumberTests{

    public ExtentSparkReporter htmlReporter; //was ExtentHtmlReporter. Now called ExtentSparkReporter in extentreports ver 5.0.x
    public static ExtentReports extent;
    public static ExtentTest logger;
    public int testNum = 1;


    @BeforeTest
    public void beforeTestMethod(){
        Constants.testType = "api";
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "ApiAutomationReport.html");
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
    }
}
