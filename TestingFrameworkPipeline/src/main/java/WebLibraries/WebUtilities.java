package WebLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.logging.Level;

public class WebUtilities {



    public static void fetchBrowserLogs(WebDriver driver){
        for(LogEntry logEntry:driver.manage().logs().get(LogType.BROWSER).filter(Level.ALL)){
            System.out.println(logEntry);
        }
    }


}
