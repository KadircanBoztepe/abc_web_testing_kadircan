package imp;

import com.thoughtworks.gauge.Step;
import helpers.methods.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WaitImp extends WaitHelper {
    Logger log = LogManager.getLogger(LaunchBrowserImp.class);


    @Step("Wait <ms> ms")
    public void waitForMiliSeconds(int ms){
        waitSomeTime(ms);
        log.info(" Wait ms \"{}\"", ms);
    }
}
