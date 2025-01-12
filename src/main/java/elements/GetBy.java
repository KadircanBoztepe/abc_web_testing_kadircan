package elements;

import base.GetFileName;
import configuration.Configuration;
import enums.LocatorType;
import exceptions.FileNotFound;
import exceptions.KeywordNotFound;

import json.UIProjectJsonReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import utils.ReuseStoreData;

import java.util.HashMap;
import java.util.Map;


public abstract class GetBy {

    private String jsonKey;

    protected long DEFAULT_WAIT = 1000;
    protected long DEFAULT_SLEEP_IN_MILLIS = 1000;
    private static final Logger log = LogManager.getLogger(GetBy.class);

    public By getByValue(String jsonKey) throws FileNotFound {
        this.jsonKey = jsonKey;
        var byObj = ReuseStoreData.get(jsonKey);
        if (byObj != null) {
            return (By) byObj;
        } else {
            var fileName = GetFileName.getInstance().getFileName();
            var locatorFolder = Configuration.getInstance().getStringValueOfProp("locator_folder");
            var filePath = locatorFolder != null ? "locators/" + fileName + ".json" : fileName + ".json";
            var jsonReader = new UIProjectJsonReader();
            var jsonMap = jsonReader.getJsonAsMapStringObject(filePath, jsonKey);
            var by = getBy(jsonMap);
            ReuseStoreData.put(jsonKey, by);
            return getBy(jsonMap);
        }
    }

    private By getByValueAccordingType(LocatorType type, String value) {

        switch (type) {
            case ID : {
                return By.id(value);
            }
            case CSS_SELECTOR : {
                return By.cssSelector(value);
            }
            case XPATH : {
                return By.xpath(value);
            }
            case NAME : {
                return By.name(value);
            }
            case CLASS_NAME : {
                return By.className(value);
            }
            case PARTIAL_LINK_TEXT : {
                return By.partialLinkText(value);
            }
            case LINK_TEXT : {
                return By.linkText(value);
            }
            case TAG_NAME : {
                return By.tagName(value);
            }
            default : throw new IllegalArgumentException(String.format("%s is undefined parameter type", type));
        }
    }

    private LocatorType getLocatorType(Map<String, String> locator) {
        var locatorType = locator.get("locatorType");
        if (locatorType != null)
            return LocatorType.valueOf(locatorType);
        else
            throw new KeywordNotFound("locatorType", this.jsonKey);
    }

    private String getLocatorValue(Map<String, String> locator) {
        var locatorValue = locator.get("locatorValue");
        if (locatorValue != null)
            return locatorValue;
        else
            throw new KeywordNotFound("locatorValue", this.jsonKey);
    }

    private By getBy(Map<String, Object> jsonMap) {
            Map<String, String> locatorMap = new HashMap<>();
            jsonMap.forEach((k, v) -> locatorMap.put(k, String.valueOf(v)));
            var locatorType = getLocatorType(locatorMap);
            var locatorValue = getLocatorValue(locatorMap);
            return getByValueAccordingType(locatorType, locatorValue);
        }
    }
