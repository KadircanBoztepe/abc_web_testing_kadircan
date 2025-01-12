package enums;

public enum Browsers {
    CHROME("chrome"),
    FIREFOX("firefox"),
    SAFARI("safari");
    private final String browser;

    Browsers(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return this.browser;
    }
}