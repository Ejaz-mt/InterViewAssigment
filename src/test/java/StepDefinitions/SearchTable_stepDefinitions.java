package StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.ShoppingCartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OutcomePage;
import utlities.ConfigurationReader;
import utlities.Driver;

import java.util.concurrent.TimeUnit;

import static utlities.BrowserUtils.waitUntilClickable;

public class SearchTable_stepDefinitions {

    HomePage homePage = new HomePage();
    OutcomePage searchPage = new OutcomePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();


    @Given("User in on Websturant home Page")
    public void user_in_on_websturant_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("User search for {string} in the Websturant search box and enter")
    public void user_search_for_in_the_websturant_search_box_and_enter(String workTable) {
        homePage.searchBox.sendKeys(workTable + Keys.ENTER);
    }

    @Then("Ensuring every product item has the word {string} its title.")
    public void ensuring_every_product_item_has_the_word_its_title(String table) {
        Driver.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        searchPage.assertingTable(table);

    }

    @Then("User add the last item found to Cart.")
    public void user_add_the_last_item_found_to_cart() {
        searchPage.scrollingDown();
        searchPage.clickTheLastElement();
        waitUntilClickable( shoppingCartPage.viewCart).click();
    }

    @Then("User Empty the Cart.")
    public void empty_the_cart() {
        waitUntilClickable(checkoutPage.emptyCartButton).click();
        checkoutPage.waitAndClick();
        checkoutPage.waitForText();
        checkoutPage.verifyingTheEmptyCard();

    }

}
