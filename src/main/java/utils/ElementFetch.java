package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static utils.DriverBuilder.*;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return driver.findElement(By.id(identifierValue));
            case "CSS":
                return driver.findElement(By.cssSelector(identifierValue));
            case "NAME":
                return driver.findElement(By.name(identifierValue));
            case "XPATH":
                return driver.findElement(By.xpath(identifierValue));
            default:
                return null;
        }
    }
    public List<WebElement> getListWebElements(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return driver.findElements(By.id(identifierValue));
            case "CSS":
                return driver.findElements(By.cssSelector(identifierValue));
            case "NAME":
                return driver.findElements(By.name(identifierValue));
            case "XPATH":
                return driver.findElements(By.xpath(identifierValue));
            default:
                return null;
        }
    }
    public WebElement getDesktopAppElement(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return desktopDriver.findElement(By.id(identifierValue));
            case "CSS":
                return desktopDriver.findElement(By.cssSelector(identifierValue));
            case "NAME":
                return desktopDriver.findElement(By.name(identifierValue));
            case "XPATH":
                return desktopDriver.findElement(By.xpath(identifierValue));
            default:
                return null;
        }
    }
    public List<WebElement> getListDesktopAppElements(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return desktopDriver.findElements(By.id(identifierValue));
            case "CSS":
                return desktopDriver.findElements(By.cssSelector(identifierValue));
            case "TAGNAME":
                return desktopDriver.findElements(By.name(identifierValue));
            case "XPATH":
                return desktopDriver.findElements(By.xpath(identifierValue));
            default:
                return null;
        }
    }
    public WebElement getAndroidAppElement(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return androidDriver.findElement(By.id(identifierValue));
            case "CSS":
                return androidDriver.findElement(By.cssSelector(identifierValue));
            case "NAME":
                return androidDriver.findElement(By.name(identifierValue));
            case "XPATH":
                return androidDriver.findElement(By.xpath(identifierValue));
            default:
                return null;
        }
    }
    public List getListAndroidAppElements(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return androidDriver.findElements(By.id(identifierValue));
            case "CSS":
                return androidDriver.findElements(By.cssSelector(identifierValue));
            case "NAME":
                return androidDriver.findElements(By.name(identifierValue));
            case "XPATH":
                return androidDriver.findElements(By.xpath(identifierValue));
            default:
                return null;
        }
    }
    public void androidHardWait(int timeToWait) throws InterruptedException {
        Thread.sleep(timeToWait);
    }
    public void waitForWebElementId(String identifierValue, int secondsToWait) {
        //WebDriverWait waitOld = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait)); // this does not work, I do not know why
        WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(secondsToWait)); // this works, I do not know why
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(identifierValue))));
    }
    public void waitForWebElementXpath(String identifierValue, int secondsToWait) {
        //WebDriverWait waitOld = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait)); // this does not work, I do not know why
        WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(secondsToWait)); // this works, I do not know why
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(identifierValue))));
    }
    public void waitForAndroidElementId(String identifierValue, int secondsToWait) {
        //WebDriverWait waitOld = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait)); // this does not work, I do not know why
        WebDriverWait wait = new WebDriverWait(androidDriver, TimeUnit.SECONDS.toSeconds(secondsToWait)); // this works, I do not know why
        wait.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.id(identifierValue))));
    }
    public void waitForAndroidElementXpath(String identifierValue, int secondsToWait) {
        //WebDriverWait waitOld = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait)); // this does not work, I do not know why
        WebDriverWait wait = new WebDriverWait(androidDriver, TimeUnit.SECONDS.toSeconds(secondsToWait)); // this works, I do not know why
        wait.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.xpath(identifierValue))));
    }
    public void waitForDesktopElementId(String identifierValue, int secondsToWait) {
        //WebDriverWait waitOld = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait)); // this does not work, I do not know why
        WebDriverWait wait = new WebDriverWait(desktopDriver, TimeUnit.SECONDS.toSeconds(secondsToWait)); // this works, I do not know why
        wait.until(ExpectedConditions.visibilityOf(desktopDriver.findElement(By.id(identifierValue))));
    }
}
