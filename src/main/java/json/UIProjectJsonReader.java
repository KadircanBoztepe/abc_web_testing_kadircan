package json;

import exceptions.FileNotFound;
import helpers.FileHelper;
import helpers.JsonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Objects;

public class UIProjectJsonReader {
    private final Logger log = LogManager.getLogger(UIProjectJsonReader.class);

    public Map<String, Object> getJsonAsMapStringObject(String filePath, String jsonKey) throws FileNotFound {

        if (jsonKey.contains(" ")) {
            jsonKey = jsonKey.replaceAll(" ", "_");
            log.warn(" The JSON key must be space-free.\n" +
                            "                    The JSON key you specified has been automatically\n" +
                            "                    converted to a space-free format.\\s\n" +
                            "                    new JSON key is \"{}\\\""
                   , jsonKey);
        }
        var jsonStringValue = getJsonAsString(filePath);
        JsonHelper helper = new JsonHelper();
        return helper.getJsonValueAsMap(jsonStringValue, jsonKey);
    }

    private String getJsonAsString(String filePath) {
        var file = new FileHelper();
        String path;
        try {
            path = Objects.requireNonNull(getClass().getClassLoader().getResource(filePath)).getPath();
        } catch (NullPointerException e) {
            throw new FileNotFound(filePath);
        }
        return file.readFileAsString(path);
    }


}