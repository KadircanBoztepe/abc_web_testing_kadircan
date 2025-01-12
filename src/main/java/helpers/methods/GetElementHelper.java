package helpers.methods;

import elements.GetElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetElementHelper extends GetElement {
    private PresenceHelper presenceHelper;

    private VisibleHelper visibleHelper;
    private ClickableHelper clickableHelper;

    public GetElementHelper() {
        presenceHelper = new PresenceHelper();
        visibleHelper = new VisibleHelper();
        clickableHelper = new ClickableHelper();
    }

    public WebElement getElementWithWait(String jsonKey) {
        return getElementWithWait(jsonKey, DEFAULT_WAIT, DEFAULT_SLEEP_IN_MILLIS);
    }


    public WebElement getElementWithWait(String jsonKey, long timeout, long sleepMils) {
        return presenceHelper.presenceWait(jsonKey, timeout, sleepMils);
    }

    public WebElement getElementWithWait(By by, long timeout, long sleepMils) {
        return presenceHelper.presenceWait(by, timeout, sleepMils);
    }

    public WebElement getClickableElement(String jsonKey, long timeout, long sleepMillis) {
        presenceHelper.presenceWait(jsonKey, timeout, sleepMillis);
        visibleHelper.waitVisibleOfElement(jsonKey, timeout, sleepMillis);
        return clickableHelper.elementToBeClickable(jsonKey, timeout, sleepMillis);
    }

    public WebElement getElementWithoutWait(String jsonKey) {
        return getElement(jsonKey);
    }

    public List<WebElement> getElementsWithoutWait(String jsonKey) {
        return getElements(jsonKey);
    }

}



