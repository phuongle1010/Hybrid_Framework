package Actions.Common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    WebDriver driver;

    private enum Browser {
        CHROME, FIREFOX, CHROME_HEADLESS, FIREFOX_HEADLESS
    }

    protected WebDriver getBrowser(String browserName, String url) {

//        if (browserName.equals("chrome")) {
//            //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browsers/chromedriver.exe");
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (browserName.equals("firefox")) {
//            //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/browsers/geckodriver.exe");
//            driver = new FirefoxDriver();
//        } else if (browserName.equals("chrome_headless")) {
//            //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/browsers/geckodriver.exe");
//            ChromeOptions options = new ChromeOptions();
//            options.setHeadless(true);
//            driver = new ChromeDriver(options);
//        } else if (browserName.equals("firefox_headless")) {
//            //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/browsers/geckodriver.exe");
//            FirefoxOptions options = new FirefoxOptions();
//            options.setHeadless(true);
//            driver = new FirefoxDriver(options);
//        } else
//            throw new RuntimeException("unknow browser");

        Browser browser = Browser.valueOf(browserName.toUpperCase());
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
//            case FIREFOX:
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//            case CHROME_HEADLESS:
//                WebDriverManager.chromedriver().setup();
//                ChromeOptions options = new ChromeOptions();
//                options.setHeadless(true);
//                driver = new ChromeDriver(options);
//            case FIREFOX_HEADLESS:
//                WebDriverManager.firefoxdriver().setup();
//                FirefoxOptions options1 = new FirefoxOptions();
//                options1.setHeadless(true);
//                driver = new FirefoxDriver(options1);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.get("https://demo.nopcommerce.com/");
        return driver;
    }

    // random số
    protected int generatorNumber() {
        Random rand = new Random();
        return rand.nextInt(999);
    }

    //random email
    protected String generatorEmail() {
        return "panda" + generatorNumber() + "@yopmail.com";
    }
}



