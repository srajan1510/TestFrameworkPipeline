import WebLibraries.BrowserClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.*;

@Listeners(TestNGListeners.class)
public class testClass {

    @Test
    public void testName() {
        WebDriver driver= BrowserClass.initchromeDriver();
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        WebdriverEventListeners eventListeners = new WebdriverEventListeners();
        eventFiringWebDriver.register(eventListeners);
        eventFiringWebDriver.get("http://google.com");
        String webPageTitle=eventFiringWebDriver.getTitle();
        Assert.assertEquals(webPageTitle.length()>0,true);
        //System.out.println(driver.manage().logs().get(LogType.PERFORMANCE).getAll().get(0));

    }
}
