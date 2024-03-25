package demoblaze.Helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class utility {

    public static WebDriver driver;

    public static void startDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void quitDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    public static String generateRandomUsername() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String username = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        username = temp + "@testdata.com";
        return username;
    }

    public static String generateRandomPassword() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String password = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        password = temp;
        return password;
    }
}
