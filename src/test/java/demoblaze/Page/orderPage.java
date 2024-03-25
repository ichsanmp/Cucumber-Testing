package demoblaze.Page;

import org.openqa.selenium.By;

import static demoblaze.Helper.utility.driver;

public class orderPage {

    By createOrderButton = By.xpath("//button[@class='btn btn-success']");
    By text_fillOrderForm(String criteria) {
        return By.xpath("//input[@id='"+criteria+"']");
    }
    By successCreateOrder(String notiftText) {
        return By.xpath("//div[@class='sweet-alert  showSweetAlert visible']/descendant::h2[text()='"+notiftText+"']");
    }
    By closeOrderSuccesButton = By.xpath("//div[@class='sa-confirm-button-container']/child::button");
    By validateCreateOrder = By.xpath("(//h5[@class='modal-title'])[3]");

    public void clickCreateOrder() {
        driver.findElement(createOrderButton).click();
    }

    public void fillOrderForm(String criteria, String inputText) {
        driver.findElement(text_fillOrderForm(criteria.toLowerCase())).sendKeys(inputText);
    }

    public void validateSuccessOrder(String notifyText) {
        driver.findElement(successCreateOrder(notifyText)).isDisplayed();
    }

    public void closeOrderNotification() {
        driver.findElement(closeOrderSuccesButton).click();
    }

    public void validateCreateOrder(String message) {
        String createOrder = driver.findElement(validateCreateOrder).getText();
        System.out.println(createOrder.equals(message) ? "Match" : "Not Match");
    }
}
