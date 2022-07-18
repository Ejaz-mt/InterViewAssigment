package pages;

import org.openqa.selenium.support.PageFactory;
import utlities.Driver;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
}
