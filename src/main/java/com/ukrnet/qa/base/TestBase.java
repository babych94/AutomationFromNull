package com.ukrnet.qa.base;

import com.ukrnet.qa.com.ukrnet.qa.util.TestUtil;
import com.ukrnet.qa.com.ukrnet.qa.util.WebEventListener;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by babych on 05.09.2018.
 */
public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public  static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\projects\\AutomationFromNull\\src\\main\\java\\com\\ukrnet\\qa\\config\\config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void windowsize (){
        driver.manage().window().fullscreen();
        int windheigth = driver.manage().window().getSize().getHeight();
    }


    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().setPosition(new Point(-5,0));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenResolution = new Dimension((int)
                toolkit.getScreenSize().getWidth()+10, (int)
                toolkit.getScreenSize().getHeight());

        driver.manage().window().setSize(screenResolution);


        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }


}
