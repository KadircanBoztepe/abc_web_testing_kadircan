package helpers.methods;

import utils.ReuseStoreData;
import java.util.AbstractMap;
import java.util.Map;

public class SendKeysHelper extends GetElementHelper {

    private static final Map<String, String> elementMap = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(",", "calculator_page_comma_button"),
            new AbstractMap.SimpleEntry<>("0", "calculator_page_zero_button"),
            new AbstractMap.SimpleEntry<>("1", "calculator_page_one_button"),
            new AbstractMap.SimpleEntry<>("2", "calculator_page_two_button"),
            new AbstractMap.SimpleEntry<>("3", "calculator_page_three_button"),
            new AbstractMap.SimpleEntry<>("4", "calculator_page_four_button"),
            new AbstractMap.SimpleEntry<>("5", "calculator_page_five_button"),
            new AbstractMap.SimpleEntry<>("6", "calculator_page_six_button"),
            new AbstractMap.SimpleEntry<>("7", "calculator_page_seven_button"),
            new AbstractMap.SimpleEntry<>("8", "calculator_page_eight_button"),
            new AbstractMap.SimpleEntry<>("9", "calculator_page_nine_button")
    );

    public void sendKeys(String jsonKey, String keys, long timeout, long sleepInMillis) {
        getClickableElement(jsonKey, timeout, sleepInMillis).sendKeys(keys);
    }

    public void sendKeys(String jsonKey, String keys, long timeout) {
        sendKeys(jsonKey, keys, timeout, DEFAULT_SLEEP_IN_MILLIS);
    }

    public void sendKeys(String jsonKey, String keys) {
        sendKeys(jsonKey, keys, DEFAULT_WAIT, DEFAULT_SLEEP_IN_MILLIS);
    }

    public void enterNumber(String number) {
        for (char digit : number.toCharArray()) {
            String jsonKey = elementMap.get(String.valueOf(digit));
            if (jsonKey != null) {
                ClickHelper clickHelper = new ClickHelper();
                clickHelper.clickElement (jsonKey);
            } else {
                throw new IllegalArgumentException("Unsupported digit: " + digit);
            }
        }
    }
    public void enterNumberWithLoop(String number, int loop) throws InterruptedException {
        for (int i = 1; i < loop; i++) {
            Thread.sleep(120);
            ClickHelper clickHelper = new ClickHelper();
            clickHelper.clickElement("calculator_page_multiply_button");
            for (char digit : number.toCharArray()) {
                String jsonKey = elementMap.get(String.valueOf(digit));
                if (jsonKey != null) {
                    Thread.sleep(120);
                    clickHelper.clickElement(jsonKey);
                }else {
                    throw new IllegalArgumentException("Unsupported digit: " + digit);
                }
            }
            Thread.sleep(120);
            clickHelper.clickElement("calculator_page_result_button");
        }
    }

    public void getTextAndStoresScenarioStore(String storeKey) {
        ReuseStoreData reuseStoreData = new ReuseStoreData();
        String storedValue = reuseStoreData.get(storeKey).toString();
        enterNumber(storedValue);
    }

}