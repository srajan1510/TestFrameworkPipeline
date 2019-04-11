package WebLibraries;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.logging.Level;

public class BrowserClass {

    public static final String browserDriverPath="src/main/resources/";
    public static WebDriver driver=null;
    public static JavascriptExecutor js;

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

    public static void enablejQuery() throws Exception{
        String readyState = js.executeScript("return document.readyState").toString();
        System.out.println("Ready State: " + readyState);
        System.out.println("Is Jquery loaded......" + isjQueryLoaded());
        if(!isjQueryLoaded()) {
            URL jqueryUrl = Resources.getResource("jquery-3.3.1.min.js");
            System.out.println(jqueryUrl.getPath());
            String jqueryText = Resources.toString(jqueryUrl, Charsets.UTF_8);
            js.executeScript(jqueryText);
        }
        System.out.println("Is Jquery loaded......" + isjQueryLoaded());
    }

    public static Boolean isjQueryLoaded() throws Exception {
        return (Boolean) js.executeScript("return !!window.jQuery;");
    }
}
