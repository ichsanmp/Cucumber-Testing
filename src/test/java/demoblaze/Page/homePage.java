package demoblaze.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static demoblaze.Helper.utility.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class homePage {

    productPage productP;

    WebDriverWait wait;
    Actions act;

    public homePage() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.act = new Actions(driver);
    }

    By text_selectNavbar(String menu) {
        if (menu.equals("Home")) {
            return By.xpath("//li[@class='nav-item active']");
        } else {
            return By.xpath("//li[@class='nav-item']/descendant::*[text()='"+menu+"']");
        }
    }
    By contentDisplayed = By.xpath("//div[@class='modal-content']");
    By validHomePage = By.xpath("//a[@id='cat']");
    By text_categories(String cat) {
        return By.xpath("//div[@class='list-group']//*[contains(.,'"+cat+"')]");
    }
    By validSortByCategories = By.xpath("(//h4[@class='card-title'])[1]");
    By text_selectProd(String product) {
        return By.xpath("//div[@class='card-block']/descendant::a[text()='"+product+"']");
    }

    public void getHomePage() throws InterruptedException {
        driver.get("https://www.demoblaze.com");
        Thread.sleep(5000);
    }

    public void clickNavbar(String menu) {
        wait.until(ExpectedConditions.presenceOfElementLocated(text_selectNavbar(menu)));
        driver.findElement(text_selectNavbar(menu)).click();
    }

    public void validateHomePage() {
        String categoriesColomn = driver.findElement(validHomePage).getText();
        assertEquals("CATEGORIES",categoriesColomn);
    }

    public void validateContentDisplayed() {
        driver.findElement(contentDisplayed).isDisplayed();
    }

    public void clickProduct(String product) {
        wait.until(ExpectedConditions.presenceOfElementLocated(text_selectProd(product)));
        driver.findElement(text_selectProd(product)).click();
    }

    public void selectCategories(String cat) throws InterruptedException {
        driver.findElement(text_categories(cat)).click();
        Thread.sleep(5000);
    }

    public void validateSortByCategories() {
        ArrayList<String> containText = new ArrayList<>();
        containText.add("Samsung galaxy s6");
        containText.add("Sony vaio i5");
        containText.add("Apple monitor 24");

        wait.until(ExpectedConditions.presenceOfElementLocated(validSortByCategories));
        String text = driver.findElement(validSortByCategories).getText();
        assertTrue(containText.contains(text));
    }
}
