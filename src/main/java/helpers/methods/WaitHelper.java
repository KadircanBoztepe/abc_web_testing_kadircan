package helpers.methods;

import driver.DriverManager;
import elements.GetBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper extends GetBy {
    public static final int DEFAULT_SLEEP_IN_MILLIS = 1000;
    public static final int DEFAULT_WAIT = 1000;



    protected WebDriverWait getWait(long timeout, long sleepInMillis) {
        return new WebDriverWait(DriverManager.getInstances().getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(sleepInMillis));
    }


    protected WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getInstances().getDriver(), Duration.ofSeconds(DEFAULT_WAIT), Duration.ofMillis(DEFAULT_SLEEP_IN_MILLIS));
    }

    public void waitSomeTime(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}