package demoblaze.Page;

import static demoblaze.Helper.utility.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class validationAlert {

    public void validateAlertMessage(String alert) {
        String textAlert = driver.switchTo().alert().getText();
        assertEquals(alert, textAlert);
    }

    public void continueAlert() throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
    }
}
