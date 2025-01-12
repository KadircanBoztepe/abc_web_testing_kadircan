package helpers.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PresenceHelper extends WaitHelper {

    private final Logger log = LogManager.getLogger(PresenceHelper.class);

    public WebElement presenceWait(String jsonKey) {
        var by = getByValue(jsonKey);
        return getWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement presenceWait(String jsonKey, long timeout, long sleepInMillis) {
        var by = getByValue(jsonKey);
        return getWait(timeout, sleepInMillis).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement presenceWait(By by, long timeout, long sleepInMillis) {
        return getWait(timeout, sleepInMillis).until(ExpectedConditions.presenceOfElementLocated(by));
    }

}