package pageEvents;

import utils.pageObjects.HomePageElements;
import utils.Constants;
import utils.ElementFetch;

public class HomePageEvents {
    public void clickOnSignInButton(){
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))){
            elementFetch.getWebElement("XPATH", HomePageElements.signInButton).click();
        }else if (Constants.testType.equalsIgnoreCase("android")){
            elementFetch.getAndroidAppElement("XPATH", HomePageElements.mobileMenuButton).click();
            elementFetch.getAndroidAppElement("XPATH", HomePageElements.mobileSignInButton).click();
        }
    }
}
