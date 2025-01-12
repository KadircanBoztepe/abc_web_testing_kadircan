package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriverService;
import org.openqa.selenium.safari.SafariOptions;

import java.io.IOException;

public class Safari implements BrowserSelectable {

    private SafariDriverService safariDriverService;

    @Override
    public MutableCapabilities getCapabilities() {
        SafariOptions options = new SafariOptions();
        options.setCapability("browserstack.local", "false");
        options.setUseTechnologyPreview(true);
        return options;
    }

    @Override
    public RemoteWebDriver getBrowser(){
        WebDriverManager.safaridriver().setup();
        safariDriverService = new SafariDriverService.Builder()
                .usingAnyFreePort()
                .build();
        try {
            safariDriverService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RemoteWebDriver(safariDriverService.getUrl(), getCapabilities());
    }
}
