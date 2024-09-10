package pageEvents;

import utils.Constants;
import utils.pageObjects.BoardPageElements;
import utils.ElementFetch;
import org.testng.Assert;

public class BoardPageEvents {
    public void verifyBoardPageIsOpen() {
        ElementFetch elementFetch = new ElementFetch();
        if ((Constants.testType.equalsIgnoreCase("chrome")) || (Constants.testType.equalsIgnoreCase("firefox"))) {
            Assert.assertTrue(elementFetch.getListWebElements("XPATH", BoardPageElements.boardPageTitle).size() > 0);
        } else if (Constants.testType.equalsIgnoreCase("android")) {
            Assert.assertTrue(elementFetch.getListAndroidAppElements("XPATH", BoardPageElements.boardPageTitle).size() > 0);

        }
    }
}
