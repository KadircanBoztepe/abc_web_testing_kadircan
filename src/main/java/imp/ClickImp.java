package imp;

import com.thoughtworks.gauge.Step;
import helpers.methods.ClickHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ClickImp extends ClickHelper {
    Logger log = LogManager.getLogger(LaunchBrowserImp.class);


    @Step("Click on <string>")
    public void clickImp(String jsonKey) {
        clickElement(jsonKey);
        log.info("Click on \"{}\"", jsonKey);

    }

    @Step("Wait for <int> second presence of <element> then click")
    public void clickImp(String jsonKey, long timeout) {
        clickElement(jsonKey, timeout);
        log.info("Click on \"{}\"", jsonKey);
    }

    @Step("Wait for <long> second with sleep in <long> millis presence of <string> then click")
    public void clickImp(String jsonKey, long timeout, long sleepInMillis) {
        clickElement(jsonKey, timeout, sleepInMillis);
        log.info("Click on \"{}\"", jsonKey);

    }
}