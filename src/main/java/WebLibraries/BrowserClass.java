package WebLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class BrowserClass {

    public static final String browserDriverPath="src/main/resources/";
    public static WebDriver driver=null;

    public static WebDriver initchromeDriver(){

        System.setProperty("webdriver.chrome.driver",browserDriverPath+"chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setJavascriptEnabled(true);
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);
        loggingPreferences.enable(LogType.BROWSER,Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS,loggingPreferences);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
        return driver=new ChromeDriver(capabilities);

    }
}
