package imp;

import com.thoughtworks.gauge.Step;
import helpers.methods.DisplayHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DisplayImp extends DisplayHelper {
    Logger log = LogManager.getLogger(LaunchBrowserImp.class);


    @Step("<text> element is Displayed")
    public void isDisplayedImp(String text){
        isDiplayed(text);
        log.info("Displayed element \"{}\"", text);

    }

    @Step("Is Not Display the <element> element")
    public void elementNotDisplayedImp(String element) {
        elementNotDisplayed(element);
        log.info("Not Displayed element \"{}\"", element);


    }


}
