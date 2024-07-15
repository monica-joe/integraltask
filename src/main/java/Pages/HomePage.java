package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="country-btn")
    public WebElement countryButton;

    @FindBy(id ="bh")
    public WebElement bahrainCountry;

    @FindBy(id ="kw")
    public WebElement kuwaitCountry;

    @FindBy(id ="sa")
    public WebElement saudiArabiaCountry;

    @FindBy(id="name-lite")
    public WebElement planName_lite;

    @FindBy(id="name-classic")
    public WebElement planName_classic;

    @FindBy(id="name-premium")
    public WebElement planName_premium;

    @FindBy(id ="currency-lite")
    public WebElement currencyLite;

    @FindBy(id ="currency-classic")
    public WebElement currencyClassic;
    
    @FindBy(id ="currency-premium")
    public WebElement currencyPremium;

     public void switchCountryToBahrain() {
         clickElement(countryButton);
         clickElement(bahrainCountry);
     }

    public void switchCountryToKuwait() {
        clickElement(countryButton);
        clickElement(kuwaitCountry);
    }

}
