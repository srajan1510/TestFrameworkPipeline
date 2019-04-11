import WebLibraries.SingletonDesignPatternDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testSingletonDriver2 {

    WebDriver driver;

    @BeforeMethod
    public void initDriver(){
        SingletonDesignPatternDriverInstance instanceDriver = SingletonDesignPatternDriverInstance.getInstanceDriver();
        driver=instanceDriver.initWebdriver();
    }

    @Test
    public void openGoogle(){

        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
