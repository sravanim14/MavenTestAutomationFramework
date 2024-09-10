package pageEvents;

import utils.DriverBuilder;
import utils.pageObjects.DashboardPageElements;
import utils.Constants;
import utils.ElementFetch;
import org.testng.Assert;
import utils.pageObjects.LoginPageElements;

public class DashboardPageEvents {

    public void verifyDashboardPageIsOpen(){
        System.out.println("Waiting for dashboard page to open");
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            elementFetch.waitForWebElementId(DashboardPageElements.navBar, 10);
            Assert.assertTrue(elementFetch.getListWebElements("ID", DashboardPageElements.navBar).size() > 0);
        }
        else if (Constants.testType.equalsIgnoreCase("android")){
            elementFetch.waitForAndroidElementId(DashboardPageElements.navBar, 10);
            Assert.assertTrue(elementFetch.getListAndroidAppElements("ID", DashboardPageElements.navBar).size() > 0);
        }
        System.out.println("Login page is open");
    }

    public void openAccountDropdown() throws InterruptedException {
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            elementFetch.waitForWebElementXpath(DashboardPageElements.accountDropdown, 10);
            elementFetch.getWebElement("XPATH", DashboardPageElements.accountDropdown).click();
        }
        else if (Constants.testType.equalsIgnoreCase("android")){
            elementFetch.waitForAndroidElementXpath(DashboardPageElements.accountDropdown, 10);
            elementFetch.getAndroidAppElement("XPATH", DashboardPageElements.accountDropdown).click();
        }
    }

    public void goToSettingsPage() {
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            elementFetch.getWebElement("XPATH", DashboardPageElements.settingsButton).click();
        }
        else if (Constants.testType.equalsIgnoreCase("android")) {
            elementFetch.getAndroidAppElement("XPATH", DashboardPageElements.settingsButton).click();
        }
    }

    public void clickCreateBoard() {
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            elementFetch.getWebElement("XPATH", DashboardPageElements.createBoardButton).click();
        }
        else if (Constants.testType.equalsIgnoreCase("android")) {
            elementFetch.getAndroidAppElement("XPATH", DashboardPageElements.createBoardButton).getLocation();
        }
    }

    public void enterNameForBoard(){
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            elementFetch.getWebElement("XPATH", DashboardPageElements.boardTitleField).sendKeys("CreateTest");
        }
        else if (Constants.testType.equalsIgnoreCase("android")){
            elementFetch.getAndroidAppElement("XPATH", DashboardPageElements.boardTitleField).sendKeys("CreateTest");
        }

    }
    public void confirmCreateBoard() {
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            elementFetch.getWebElement("XPATH", DashboardPageElements.confirmCreateBoardButton).click();
        }
        else if (Constants.testType.equalsIgnoreCase("android")) {
            elementFetch.getAndroidAppElement("XPATH", DashboardPageElements.confirmCreateBoardButton).click();
        }
    }

}
