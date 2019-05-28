import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase


{
    public static WebDriver driver;
    public static Properties prop;


    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/config");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        String downloadPath = prop.getProperty("DefaultDownloadPath");

        if (browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("download.default_directory", downloadPath);
            driver = new ChromeDriver();
        } else if (browserName.equals("Chrome_headless")) {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");

            driver = new ChromeDriver(options);

        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
            driver = new FirefoxDriver();
        } else if (browserName.equals("FF_headless")) {
            System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("headless");
            driver = new FirefoxDriver(options);


        }


        driver.manage().window().setSize(new Dimension(Integer.valueOf(prop.getProperty("WINDOW_WIDTH")), Integer.valueOf(prop.getProperty("WINDOW_HEIGHT"))));
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));

    }

    public static void InitforDownload() {
        String browserName = prop.getProperty("browser");
        String downloadPath = prop.getProperty("DefaultDownloadPath");
        String urlDownloadPDF = prop.getProperty("urlDownloadPDF");

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);
        //driver.get(prop.getProperty("url"));
        driver.get(prop.getProperty("urlDownloadPDF"));
        //driver.navigate().to(urlDownloadPDF);

    }

    public static void InitPDFDownload() {

    String browserName = prop.getProperty("browser");
    String downloadPath = prop.getProperty("DefaultDownloadPath");

    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("download.default_directory", downloadPath);
    driver = new ChromeDriver();
    driver.get(prop.getProperty("urlDownloadPDF"));

    }

}
