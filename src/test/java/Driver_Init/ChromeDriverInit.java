package Driver_Init;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

abstract public class ChromeDriverInit {
    protected WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(65, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(65,TimeUnit.SECONDS);
        DriverConstructor.setDriver(driver);
    }


    @After
    public void shutDown(){
        //driver.close();
    }
}