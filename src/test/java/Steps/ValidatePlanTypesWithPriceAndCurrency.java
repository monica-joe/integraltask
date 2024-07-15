package Steps;

import Pages.HomePage;
import Tests.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ValidatePlanTypesWithPriceAndCurrency extends TestBase {

   HomePage HomePageObj = new HomePage(driver) ;
    private String payload;
    private Response response;

    @When("^open the website and validate the default country is saudi arabia$")
    public void open_the_website_and_validate_the_default_country_is_saudi_arabia() {
        System.out.println("------site launched------");
        // Get the current URL of the webpage
        String currentUrl = driver.getCurrentUrl();
        // Assert that the URL contains the text
        Assert.assertTrue(currentUrl.contains("sa-en"));
    }

    @And("^check the plan types$")
    public void check_the_plan_types() {
        assertEquals(HomePageObj.planName_lite.getText(), "LITE");
        assertEquals(HomePageObj.planName_classic.getText(),("CLASSIC"));
        assertEquals(HomePageObj.planName_premium.getText(),("PREMIUM"));
    }

    @Then("^validate the Price and currency for each type in saudi$")
    public void validate_the_Price_and_currency_for_each_type_in_saudi()  {
        Assert.assertTrue(HomePageObj.currencyLite.getText().contains("15 SAR/month"));
        Assert.assertTrue(HomePageObj.currencyClassic.getText().contains("25 SAR/month"));
        Assert.assertTrue(HomePageObj.currencyPremium.getText().contains("60 SAR/month"));
    }

    @And("^switch the country to Bahrain$")
    public void switch_the_country_to_Bahrain() {
        HomePageObj.switchCountryToBahrain();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("bh-en"));
    }

    @Then("^validate the Price and currency for each type in bahrain$")
    public void validate_the_Price_and_currency_for_each_type_in_bahrain()  {
        Assert.assertTrue(HomePageObj.currencyLite.getText().contains("2 BHD/month"));
        Assert.assertTrue(HomePageObj.currencyClassic.getText().contains("3 BHD/month"));
        Assert.assertTrue(HomePageObj.currencyPremium.getText().contains("6 BHD/month"));
    }

    @And("^switch the country to Kuwait")
    public void switch_the_country_to_Kuwait() {
        HomePageObj.switchCountryToKuwait();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("kw-en"));
    }

    @Then("^validate the Price and currency for each type in kuwait$")
    public void validate_the_Price_and_currency_for_each_type_in_kuwait()  {
        Assert.assertTrue(HomePageObj.currencyLite.getText().contains("1.2 KWD/month"));
        Assert.assertTrue(HomePageObj.currencyClassic.getText().contains("2.5 KWD/month"));
        Assert.assertTrue(HomePageObj.currencyPremium.getText().contains("4.8 KWD/month"));
    }

    @Given("^I make a post request to add new device$")
    public void I_make_a_post_request_to_add_new_device()  {
        RestAssured.baseURI = "https://api.restful-api.dev";
        payload = "{\n" +
                       "  \"name\": \"Apple Max Pro 1TB\",\n" +
                       "  \"data\": {\n" +
                       "    \"year\": 2023,\n" +
                       "    \"price\": 7999.99,\n" +
                       "    \"CPU model\": \"Apple ARM A7\",\n" +
                       "    \"Hard disk size\": \"1 TB\"\n" +
                       "  }\n" +
                       "}";
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.body(payload);
        response = request.post("/objects");
    }

    @Then("^validate the response$")
    public void validate_the_response()  {
        assertEquals("Apple Max Pro 1TB", response.jsonPath().getString("name"));
        assertEquals(2023, (int) response.jsonPath().getInt("data.year"));
        assertEquals(7999.99, response.jsonPath().getDouble("data.price"), 0.0);
        assertEquals("Apple ARM A7", response.jsonPath().getString("data.'CPU model'"));
        assertEquals("1 TB", response.jsonPath().getString("data.'Hard disk size'"));
    }

    @And("^Validate id and createdAt should not be null$")
    public void Validate_id_and_createdAt_should_not_be_null() {
        assertNotNull("id should not be null", response.jsonPath().getString("id"));
        assertNotNull("createdAt should not be null", response.jsonPath().getString("createdAt"));
    }
}
