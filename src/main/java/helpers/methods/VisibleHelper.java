package helpers.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class VisibleHelper extends WaitHelper {

    public WebElement waitVisibleOfElement(String jsonHelper) {
        var by = getByValue(jsonHelper);
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitVisibleOfElement(String jsonHelper, long timeout, long sleepInMillis) {
        var by = getByValue(jsonHelper);
        return getWait(timeout, sleepInMillis).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}