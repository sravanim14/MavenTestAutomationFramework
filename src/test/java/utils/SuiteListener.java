package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SuiteListener implements ITestListener, IAnnotationTransformer {

    @Override
    public void onTestStart(ITestResult iTestResult){

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult){

    }

    @Override
    public void onTestFailure(ITestResult iTestResult){
        int random = (int)(Math.random() * 9999999 + 1);
        String fileName = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + Constants.testType + "Failure" + random;
        File f = null;
        switch (Constants.testType){
            case "firefox":
            case "chrome":
                f = ((TakesScreenshot) DriverBuilder.driver).getScreenshotAs(OutputType.FILE);
                break;
            case "desktop":
                f = ((TakesScreenshot) DriverBuilder.desktopDriver).getScreenshotAs(OutputType.FILE);
                break;
            case "android":
                f = ((TakesScreenshot) DriverBuilder.androidDriver).getScreenshotAs(OutputType.FILE);
                break;
            default:
        }

        try {
            FileUtils.copyFile(f, new File(fileName + ".png"));
            } catch (IOException e) {
            e.printStackTrace();
            }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult){

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult){

    }

    @Override
    public void onStart(ITestContext iTestContext){

    }

    @Override
    public void onFinish(ITestContext iTestContext){

    }

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class myClass, Constructor constructor, Method method){
        iTestAnnotation.setRetryAnalyzer(RetryAnalyser.class);
    }

}
