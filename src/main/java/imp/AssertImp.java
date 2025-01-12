package imp;

import com.thoughtworks.gauge.Step;
import helpers.methods.AssertHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AssertImp extends AssertHelper {
    Logger log = LogManager.getLogger(LaunchBrowserImp.class);

    @Step("The text of the <locatorValue> element assert <text>")
    public void assertTextImp(String locatorValue, String text){
        assertText(text,locatorValue);
        log.info("Assertion compeleted for \"{}\"", text);

    }

    @Step("Get result with <key> and compare with <assertText>")
    public void assertResult(String key, String assertText) throws Exception{
        assertResultCalculator(assertText, key);
        log.info("Assertion compeleted for \"{}\"", assertText);
    }




}
