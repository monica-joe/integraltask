package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    protected WebDriver driver;

    public PageBase( WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static void clickElement(WebElement element) {
        element.click();
    }

    public static void scrollDownToFindElement (WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
    }

    public static void enterText(WebElement element, String text) {
        element.sendKeys(text);;
    }

}
