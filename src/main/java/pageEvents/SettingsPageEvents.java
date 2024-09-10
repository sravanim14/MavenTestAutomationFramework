package pageEvents;

import utils.Constants;
import utils.pageObjects.LoginPageElements;
import utils.pageObjects.SettingsPageElements;
import utils.ElementFetch;
import org.testng.Assert;

public class SettingsPageEvents {

    public void verifySettingsPageIsOpen(){
        System.out.println("Waiting for settings page to open");
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            Assert.assertTrue(elementFetch.getListWebElements("XPATH", SettingsPageElements.settingsTabActive).size() > 0);
        }
        else if (Constants.testType.equalsIgnoreCase("android")){
            Assert.assertTrue(elementFetch.getListAndroidAppElements("XPATH", SettingsPageElements.settingsTabActive).size() > 0);
        }
        System.out.println("Settings page is open");
    }
}
