package demoblaze.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static demoblaze.Helper.utility.driver;

public class productPage {
    WebDriverWait wait;

    public productPage() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    By text_productDetPage(String product) {
        return By.xpath("//div[@id='tbodyid']/descendant::h2[text()='"+product+"']");
    }
    By addToCartButton = By.xpath("//a[text()='Add to cart']");

    public void productDetPageDisplayed(String product) {
        driver.findElement(text_productDetPage(product)).isDisplayed();
    }

    public void clickAddToCartButton() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButton));
        driver.findElement(addToCartButton).click();
        Thread.sleep(5000);
    }
}
