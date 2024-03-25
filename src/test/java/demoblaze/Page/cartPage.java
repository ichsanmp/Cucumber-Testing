package demoblaze.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static demoblaze.Helper.utility.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class cartPage {

    By validCartPage = By.xpath("//h2[text()='Products']");
    By index_prodDetail = By.xpath("//table[@class='table table-bordered table-hover table-striped']//tbody//tr//td[2]");
    By index_nameDetail(int i) {
        return By.xpath("//table[@class='table table-bordered table-hover table-striped']//tbody//tr"+i+"//td[2]");
    }
    By index_priceDetail = By.xpath("//table[@class='table table-bordered table-hover table-striped']//tbody//tr//td[3]");
    By totalPriceOnCart = By.xpath("//h3[@id='totalp']");


    public void validateCartPage() {
        String productsColomn = driver.findElement(validCartPage).getText();
        assertEquals("Products",productsColomn);
    }

    public void productIsDisplayed(String product) {
        List<WebElement> prodDisplayed = driver.findElements(index_prodDetail);
        int countProd = prodDisplayed.size();
        for (int i = 1; i < countProd; i++)  {
            String textOfProduct = driver.findElement(index_nameDetail(i)).getText();
            assertEquals(product, textOfProduct);
        }
    }

    public void countCartDetail() {
        List<WebElement> priceValue = driver.findElements(index_priceDetail);
        int c = priceValue.size();
        for (int i = 0; i < c; i++) {
            int getValue = Integer.parseInt(priceValue.get(i).getText());
            int sum = getValue;
            sum = sum + getValue;
            assertEquals(driver.findElement(totalPriceOnCart).getText(), String.valueOf(sum));
        }
    }
}
