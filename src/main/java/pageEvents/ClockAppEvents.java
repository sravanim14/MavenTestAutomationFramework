package pageEvents;

import utils.pageObjects.ClockAppElements;
import utils.ElementFetch;
import org.testng.Assert;

public class ClockAppEvents {

    int timerDisplayAsInt;
    String timerDisplayRaw = "";
    String timerDisplayTruncated = "";
    String timerDisplayModified = "";

    public void verifyClockAppIsOpen(){
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(elementFetch.getListAndroidAppElements("ID", ClockAppElements.timerTab).size()>0);
    }

    public void goToTimerTab(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getAndroidAppElement("ID", ClockAppElements.timerTab).click();
    }

    public void goToStopwatchTab(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getAndroidAppElement("ID", ClockAppElements.stopwatchTab).click();
    }

    public void setTenSecondTimer(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getAndroidAppElement("ID", ClockAppElements.number7).click();
        //elementFetch.getAndroidAppElement("ID", ClockAppElements.number0).click();
    }

    public void clickPlayTimerButton(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getAndroidAppElement("ID", ClockAppElements.playTimerButton).click();
    }

    public void waitTenSeconds() throws InterruptedException {
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.androidHardWait(8000);
    }

    public void waitFiveSeconds() throws InterruptedException {
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.androidHardWait(4000);
    }

    public void pressLapButton(String numOfLaps) throws InterruptedException {
        ElementFetch elementFetch = new ElementFetch();
        int numOfLapsInt = Integer.parseInt(numOfLaps);
        for (int i = 0; i < numOfLapsInt; i++) {
            elementFetch.getAndroidAppElement("ID", ClockAppElements.lapTimerButton).click();
            //elementFetch.androidHardWait(100);
        }
    }

    public void verifyTimerHasFinished(){
        ElementFetch elementFetch = new ElementFetch();
        timerDisplayRaw = elementFetch.getAndroidAppElement("ID", ClockAppElements.activeTimerText).getText(); //the '-' in the negative number appears as a '?'
        if (timerDisplayRaw.length() > 1 ){ //number should only be one digit so if string is longer than this, then it must be negative
            timerDisplayTruncated = timerDisplayRaw.substring(1); //driver is unable to read the negative number, so remove the '?' from raw display
            timerDisplayModified =  "-" + timerDisplayTruncated; //insert the '-' into the negative number
            System.out.println(timerDisplayModified);
            timerDisplayAsInt = Integer.parseInt(timerDisplayModified);
        }
        else{
            System.out.println(timerDisplayRaw);
            timerDisplayAsInt = Integer.parseInt(timerDisplayRaw);
        }
        Assert.assertTrue(timerDisplayAsInt < 0);
    }

    public void checkForCorrectLaps(String expectedNumOfLaps){
        ElementFetch elementFetch = new ElementFetch();
        int expectedNumOfLapsInt = Integer.parseInt(expectedNumOfLaps);
        Assert.assertTrue(elementFetch.getListAndroidAppElements("ID", ClockAppElements.lapNumber).size() == expectedNumOfLapsInt);
    }

    public void closeTimer(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getAndroidAppElement("ID", ClockAppElements.closeTimerButton).click();
    }

}
