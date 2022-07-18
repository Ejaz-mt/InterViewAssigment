package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utlities.BrowserUtils.waitUntilVisible;


public class CheckoutPage extends BasePage {


    @FindBy(xpath = "//button[text()='Empty Cart']")
    public WebElement emptyCartButton;

    @FindBy(xpath = "//button[@class='bg-origin-box-border bg-repeat-x border-solid border box-border cursor-pointer inline-block text-center no-underline hover:no-underline antialiased hover:bg-position-y-15 mr-2 rounded-normal text-base px-7 py-2-1/2 hover:bg-green-600 text-white text-shadow-black-60 bg-green-primary bg-linear-gradient-180-green border-black-25 shadow-inset-black-17 align-middle font-semibold']")

    public WebElement verifyEmptyCartButton;

    @FindBy(css = "p[class='header-1']")
    public WebElement emptyCartHeader;






    public void waitForText(){
        waitUntilVisible(emptyCartHeader);
    }


    public void verifyingTheEmptyCard(){
        Assert.assertEquals(emptyCartHeader.getText(), "Your cart is empty.");

    }

    public void waitAndClick() {
        waitUntilVisible(verifyEmptyCartButton);
        verifyEmptyCartButton.click();
    }



}