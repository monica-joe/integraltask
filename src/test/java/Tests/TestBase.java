package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @SuppressWarnings("deprecation")
    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            Reporter.log("=====Chrome Browser Session Started=====", true);
            String chromePath = "Drivers/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromePath);
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            Reporter.log("=====FireFox Browser Session Started=====", true);
            String firefoxPath = System.getProperty("Drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", firefoxPath);
            driver = new FirefoxDriver();
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://subscribe.stctv.com/sa-en");
        System.out.println("---------Site Successfully Launched------------");
    }

    @AfterSuite
    public void stopDriver() {
        driver.quit();
    }
}






