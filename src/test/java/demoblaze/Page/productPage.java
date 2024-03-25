package demoblaze.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static demoblaze.Helper.utility.driver;

public class productPage {

    By text_productDetPage(String product) {
        return By.xpath("//div[@id='tbodyid']/descendant::h2[text()='"+product+"']");
    }
    By addToCartButton = By.xpath("//a[text()='Add to cart']");

    public void productDetPageDisplayed(String product) {
        driver.findElement(text_productDetPage(product)).isDisplayed();
    }

    public void clickAddToCartButton() throws InterruptedException {
        driver.findElement(addToCartButton).click();
        Thread.sleep(5000);
    }
}
