package helpers.methods;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;


public class AssertHelper extends VisibleHelper{

    private final Logger log = LogManager.getLogger(PresenceHelper.class);

    private GetElementHelper getElementHelper;

    public AssertHelper(){
        getElementHelper = new GetElementHelper();
    }

    public void assertText(String assertText, String json){
        waitVisibleOfElement(json);
        var by = getElementHelper.getElementWithoutWait(json);
        var text=  by.getText();
        Assertions.assertEquals(assertText,text);
        log.info("{} text assert equals {} json parameter", assertText, json);
    }

    public String getElmText(String jsonKey){
        GetElementHelper getElementHelper = new GetElementHelper();
        return getElementHelper.getElementWithWait(jsonKey).getText();
    }

    public void assertResultCalculator(String assertText, String key)
    {
        GetElementHelper getElementHelper = new GetElementHelper();
        String rawText = getElementHelper.getElementWithWait(key).getText();
        rawText = rawText.split("=")[1].trim();
        assertString(assertText,rawText);

    }
    public void assertString(String val1, String val2)
    {
        Assertions.assertEquals(val1,val2);
    }



}
