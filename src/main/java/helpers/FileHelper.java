package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileHelper {

    private final Logger log = LogManager.getLogger(FileHelper.class);
    public String readFileAsString(String fileDirectory) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileDirectory)));
        } catch (IOException e) {
            log.error("An error occurred message:{}", e.getMessage());
            return "";
        }
    }
}