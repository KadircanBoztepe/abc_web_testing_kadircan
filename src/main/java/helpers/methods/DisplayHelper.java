package helpers.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DisplayHelper extends VisibleHelper{

    private GetElementHelper getElementHelper;

    private final Logger log = LogManager.getLogger(PresenceHelper.class);

    public DisplayHelper(){
        getElementHelper = new GetElementHelper();

    }

    public void isDiplayed(String json){
        waitVisibleOfElement(json);
         var by = getElementHelper.getElementWithoutWait(json);
        Assert.assertTrue("could not be displayed", by.isDisplayed());
        log.info("{} is displayed", json);
    }

    public void elementNotDisplayed(String jsonKey) {
        List<WebElement> elements = getElementHelper.getElementsWithoutWait(jsonKey);
        Assertions.assertTrue(elements.isEmpty(), "Element is not present");
    }

}
