package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;



public class Firefox implements BrowserSelectable{
    @Override
    public MutableCapabilities getCapabilities() {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("dom.webnotifications.enabled", false);
        profile.setPreference("dom.push.enabled", false);
        options.setProfile(profile);
        options.addArguments("--private");  // Özel tarayıcı modunda başlat

        return options;
    }

    @Override
    public WebDriver getBrowser()  {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = (FirefoxOptions) getCapabilities();
        WebDriver driver = new FirefoxDriver(options);

        return driver;

    }
}


