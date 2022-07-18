package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

       @FindBy(id = "buyButton")
         public WebElement addToCart;

  @FindBy(css = "a[class='btn btn-small btn-primary']")
  public WebElement viewCart;

}
