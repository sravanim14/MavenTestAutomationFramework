package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
    int count = 0;
    int retryCount = 0; //number of times to repeat a test, 0 if you only want to run once
    @Override
    public boolean retry (ITestResult iTestResult){
        while (count<retryCount){
            count++;
            return true;
        }
        return false;
    }
}
