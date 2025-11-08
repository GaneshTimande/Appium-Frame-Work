package appium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartRealDevice {
    public static void main(String[] args) throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        // Device details
        options.setDeviceName("BA6HLRAABQYX5TT8");   // your adb device ID
        options.setPlatformName("Android");
        options.setPlatformVersion("15");             // your device Android version
        options.setAutomationName("UiAutomator2");

        // Flipkart app details
        options.setAppPackage("com.flipkart.android");
        options.setAppActivity("com.flipkart.android.activity.HomeFragmentHolderActivity"); // correct activity

        // Optional
        options.setNoReset(true);   // keeps login/session
        options.setFullReset(false);

        // Connect to Appium server
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);

        System.out.println("Flipkart app launched successfully on real device!");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Tap search bar
        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.flipkart.android:id/search_widget_textbox")));
        searchBar.click();

        // 2. Enter product name
        searchBar.sendKeys("iPhone");

        // 3. Tap search button
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.flipkart.android:id/search_autoCompleteItem")));
        searchBtn.click();

        // 4. Verify results displayed
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[contains(@text,'iPhone')]")));
        if (firstProduct.isDisplayed()) {
            System.out.println("Search successful, product displayed!");
        } else {
            System.out.println("Search failed!");
        }

        // Close session
        driver.quit();
    }
}