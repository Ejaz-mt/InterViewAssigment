package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utlities.Driver;

import java.util.List;

public class OutcomePage extends BasePage {

    @FindBy(xpath = "//a[@data-testid='itemDescription']")
    public List<WebElement> productSearchItems;

    @FindBy(xpath = "//input[starts-with(@name,\"addToCartButton\")]")
    public List<WebElement> addToCartButtons;

    @FindBy(xpath = " //p[.='Related Searches']")
    public WebElement scrollDownPoint;

    public void assertingTable(String itemName) {
        List<WebElement> itemDescriptions = productSearchItems;
        int count = 0;
        for (WebElement each : itemDescriptions) {
            count++;
            Assert.assertTrue("Missing the table from description at List number "+count , each.getText().contains(itemName));
        }
    }

    public void scrollingDown() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(scrollDownPoint).perform();
    }

    public void clickTheLastElement() {
        addToCartButtons.get(addToCartButtons.size() - 1).click();
    }
}


