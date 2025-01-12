package helpers.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ClickHelper extends GetElementHelper {
    private Logger log = LogManager.getLogger(ClickHelper.class);
    private final String LOG_INFO = "Clicked on {}";

    public void clickElement(String jsonKey) {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickElement(jsonKey, DEFAULT_WAIT, DEFAULT_SLEEP_IN_MILLIS);
    }

    public void clickElement(String jsonKey, long timeout) {
        clickElement(jsonKey, timeout, DEFAULT_SLEEP_IN_MILLIS);
        log.info(LOG_INFO, jsonKey);
    }
    public void clickElement(String jsonKey, long timeout, long sleepMillis) {
        getClickableElement(jsonKey, timeout, sleepMillis).click();
        log.info(LOG_INFO, jsonKey);
    }


}
