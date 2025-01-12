package helpers.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClickableHelper extends WaitHelper {

    public WebElement elementToBeClickable(String jsonHelper) {
        var by = getByValue(jsonHelper);
        return getWait().until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement elementToBeClickable(By by) {
        return elementToBeClickable(by, DEFAULT_WAIT, DEFAULT_SLEEP_IN_MILLIS);
    }

    public WebElement elementToBeClickable(By by, long timeout, long sleepInMillis) {
        return getWait(timeout, sleepInMillis).until(ExpectedConditions.elementToBeClickable(by));
    }


    public WebElement elementToBeClickable(String jsonHelper, long timeout, long sleepInMillis) {
        var by = getByValue(jsonHelper);
        return getWait(timeout, sleepInMillis).until(ExpectedConditions.elementToBeClickable(by));
    }

}