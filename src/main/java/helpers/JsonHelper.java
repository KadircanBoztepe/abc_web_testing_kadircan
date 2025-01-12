package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Map;

import static com.jayway.jsonpath.JsonPath.read;


public class JsonHelper {

    private final Logger log = LogManager.getLogger(JsonHelper.class);
    public Map<String, Object> getJsonValueAsMap(String json, String jsonKey) {
        try {
            return read(json, jsonKey);
        } catch (Exception e) {
            log.fatal("Json path couldn't read error message: '{}'", e.getMessage());
            throw e;
        }
    }

}
