package WebLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDesignPatternDriverInstance {

    private static SingletonDesignPatternDriverInstance instanceDriver=null;
    private WebDriver driver;
    public static final String browserDriverPath="src/main/resources/";

    private SingletonDesignPatternDriverInstance() {
    }

    public static SingletonDesignPatternDriverInstance getInstanceDriver(){

        if (instanceDriver==null){
            instanceDriver = new SingletonDesignPatternDriverInstance();
        }
        return instanceDriver;
    }

    public WebDriver initWebdriver(){

        System.setProperty("webdriver.chrome.driver",browserDriverPath+"chromedriver.exe");
        driver= new ChromeDriver();
        return driver;
    }
}
