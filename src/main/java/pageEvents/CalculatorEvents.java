package pageEvents;

import utils.DriverBuilder;
import utils.pageObjects.CalculatorElements;
import utils.ElementFetch;
import org.testng.Assert;
import utils.pageObjects.LoginPageElements;

import java.util.Objects;

public class CalculatorEvents {

    public void verifyCalculatorIsOpen(){
        ElementFetch elementFetch = new ElementFetch();
        System.out.println("Checking Calculator is open");
        elementFetch.waitForDesktopElementId(CalculatorElements.number2, 5);
        Assert.assertTrue(elementFetch.getListDesktopAppElements("ID", CalculatorElements.number2).size()>0);
        System.out.println("Calculator is open");
    }

    public void enterNumber(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getDesktopAppElement("ID", CalculatorElements.number8).click();
    }

    public void multiplyNumbers(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getDesktopAppElement("ID", CalculatorElements.number2).click();
        elementFetch.getDesktopAppElement("ID",CalculatorElements.multiply).click();
        elementFetch.getDesktopAppElement("ID",CalculatorElements.number3).click();
    }

    public void clickEquals(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getDesktopAppElement("ID", CalculatorElements.equals).click();
    }

    public void clickSquare(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getDesktopAppElement("ID", CalculatorElements.square).click();
    }

    public void verifyAnswerIsSix(){
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(Objects.equals(elementFetch.getDesktopAppElement("ID", CalculatorElements.output).getAttribute("Name"), "Display is 6"));
    }

    public void verifyAnswerIsFive(){
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(Objects.equals(elementFetch.getDesktopAppElement("ID", CalculatorElements.output).getAttribute("Name"), "Display is 5"));
    }

    public void verifyAnswerIsSquared(){
        ElementFetch elementFetch = new ElementFetch();
        int squaredNumber = (int) Math.pow(8, 2);
        Assert.assertTrue(Objects.equals(elementFetch.getDesktopAppElement("ID", CalculatorElements.output).getAttribute("Name"), "Display is " + squaredNumber));
    }

}
