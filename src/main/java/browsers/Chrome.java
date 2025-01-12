package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




import java.util.HashMap;

public class Chrome implements BrowserSelectable {
    @Override
    public MutableCapabilities getCapabilities() {
        ChromeOptions options = new ChromeOptions();
        var prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--log-level=3");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-logging");
        return options;
    }

    @Override
    public WebDriver getBrowser()  {
        //kendisi otomatik olarak indiriyor exe olayi icinde oluyor
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = (ChromeOptions) getCapabilities();

        // ChromeDriver'ı başlat
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }
}