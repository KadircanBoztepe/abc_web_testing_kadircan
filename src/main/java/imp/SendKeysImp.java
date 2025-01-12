package imp;

import com.thoughtworks.gauge.Step;
import helpers.methods.SendKeysHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SendKeysImp extends SendKeysHelper {
    Logger log = LogManager.getLogger(LaunchBrowserImp.class);


    @Step("Type <text> into <element> element")
    public void sendKeysImp(String text, String jsonKey) {
        sendKeys(jsonKey, text);
        log.info("Send keys \"{}\" on  \"{}\" element",text, jsonKey);
    }

    @Step("Wait for <second> second presence of <element> and type <text> into  it")
    public void sendKeysImp(long sec, String jsonKey, String text) {
        sendKeys(jsonKey, text, sec);
        log.info("Send keys \"{}\" on  \"{}\" element",text, jsonKey);

    }

    @Step("Send <number> number to calculator")
    public void enterNumberImğ(String number) {
        enterNumber(number);
        log.info("Send number calculator \"{}\" ",number);

    }

    @Step("Send <number> number to calculator <loop> times and multiply")
    public void enterNumberWithLoopImp(String number, int loop) throws InterruptedException {
       enterNumberWithLoop(number, loop);
        log.info("Send number calculator \"{}\" to  \"{}\" loop ",number, loop);
    }
    @Step("Get <storedElement> stored value and send number to calculator")
    public void getTextAndStoresScenarioStoreImp(String storeKey) {
        getTextAndStoresScenarioStore(storeKey);
        log.info("Stored value \"{}\" send calculator",storeKey);
    }



}



