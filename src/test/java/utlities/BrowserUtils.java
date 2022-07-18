package utlities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BrowserUtils {

    private static String parentWindow;



    public static List<WebElement> getElements(String xpath) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        return wait.until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }



    public static WebElement waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForClickable(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }




    public static String getCurrentPageTitle() {
        return Driver.getDriver().getTitle();
    }


    public static void waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
