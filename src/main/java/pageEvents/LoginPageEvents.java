package pageEvents;

import utils.pageObjects.LoginPageElements;
import utils.Constants;
import utils.ElementFetch;
import org.testng.Assert;


public class LoginPageEvents {

    public void verifyLoginPageIsOpen(){
        System.out.println("Waiting for login page to open");
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            elementFetch.waitForWebElementXpath(LoginPageElements.loginText, 10);
            Assert.assertTrue(elementFetch.getListWebElements("XPATH", LoginPageElements.loginText).size() > 0);
        }
        else if (Constants.testType.equalsIgnoreCase("android")){
            elementFetch.waitForAndroidElementXpath(LoginPageElements.loginText, 10);
            Assert.assertTrue(elementFetch.getListAndroidAppElements("XPATH", LoginPageElements.loginText).size() > 0);
        }
        System.out.println("Login page is open");
    }

    public void enterLoginCredentials() throws InterruptedException {
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            elementFetch.getWebElement("ID", LoginPageElements.emailField).sendKeys(Constants.emailAddress);
            elementFetch.getWebElement("ID", LoginPageElements.loginButtonUsername).click();
            elementFetch.waitForWebElementXpath(LoginPageElements.passwordScreenText, 10);
            Assert.assertTrue(elementFetch.getListWebElements("XPATH", LoginPageElements.passwordScreenText).size() > 0);
            elementFetch.getWebElement("ID", LoginPageElements.passwordField).sendKeys(Constants.password);
        }
        else if (Constants.testType.equalsIgnoreCase("android")){
            elementFetch.getAndroidAppElement("ID", LoginPageElements.emailField).sendKeys(Constants.emailAddress);
            elementFetch.getAndroidAppElement("ID", LoginPageElements.loginButtonUsername).click();
            Assert.assertTrue(elementFetch.getListAndroidAppElements("XPATH", LoginPageElements.passwordScreenText).size() > 0);
            elementFetch.getAndroidAppElement("ID", LoginPageElements.passwordField).sendKeys(Constants.password);
        }

    }

    public void enterInvalidLoginCredentials(){
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            elementFetch.getWebElement("ID", LoginPageElements.emailField).sendKeys("this is an invalid email");
            elementFetch.getWebElement("ID", LoginPageElements.loginButtonUsername).click();
            Assert.assertTrue(elementFetch.getListWebElements("XPATH", LoginPageElements.passwordScreenText).size() > 0);
            elementFetch.getWebElement("ID", LoginPageElements.passwordField).sendKeys("this is an invalid password");
        }
        else if (Constants.testType.equalsIgnoreCase("android")){
            elementFetch.getAndroidAppElement("ID", LoginPageElements.emailField).sendKeys("this is an invalid email");
            elementFetch.getAndroidAppElement("ID", LoginPageElements.loginButtonUsername).click();
            Assert.assertTrue(elementFetch.getListAndroidAppElements("XPATH", LoginPageElements.passwordScreenText).size() > 0);
            elementFetch.getAndroidAppElement("ID", LoginPageElements.passwordField).sendKeys("this is an invalid password");
        }

    }

    public void submitLoginCredentials(){
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            elementFetch.getWebElement("ID", LoginPageElements.loginButtonPassword).click();
        }
        else if (Constants.testType.equalsIgnoreCase("android")){
            elementFetch.getAndroidAppElement("ID", LoginPageElements.loginButtonPassword).click();
        }
    }
}
