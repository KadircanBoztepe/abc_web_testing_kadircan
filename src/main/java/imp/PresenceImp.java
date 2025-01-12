package imp;

import com.thoughtworks.gauge.Step;
import helpers.methods.PresenceHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PresenceImp extends PresenceHelper {
    Logger log = LogManager.getLogger(LaunchBrowserImp.class);

    @Step("Presence on <string>")
    public void presenceWaitImp(String jsonKey) {
        presenceWait(jsonKey);
        log.info("Presence element \"{}\"", jsonKey);

    }
}
