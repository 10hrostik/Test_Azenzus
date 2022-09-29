package DriverInitialization;


import org.openqa.selenium.WebDriver;

abstract public class DriverConstructor {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
    }
}
