package imp;

import com.thoughtworks.gauge.Step;
import helpers.methods.AssertHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ReuseStoreData;


public class StoreImp {
    Logger log = LogManager.getLogger(LaunchBrowserImp.class);
    AssertHelper assertHelper = new AssertHelper();
    ReuseStoreData reuseStoreData = new ReuseStoreData();

    @Step("Get <key> element text and store it Scenario Store with <storeKey> key")
    public void getTextAndStoreScenarioStore(String jsonKey, String storeKey) {
        String text = assertHelper.getElmText(jsonKey);
        text = text.split("=")[1].trim();
        reuseStoreData.put(storeKey, text);
        log.info(" \"{}\" Json store with \"{}\"", jsonKey, storeKey);
    }


}
