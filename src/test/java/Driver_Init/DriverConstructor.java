package Driver_Init;


import org.openqa.selenium.WebDriver;

abstract public class DriverConstructor {
    protected static WebDriver driver;

    public static void setDriver(WebDriver WebDriver){
        driver = WebDriver;
    }
}
