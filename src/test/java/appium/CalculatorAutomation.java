package appium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.time.Duration;

public class CalculatorAutomation {
    public static void main(String[] args) throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("BA6HLRAABQYX5TT8");
        options.setPlatformName("Android");
        options.setPlatformVersion("15");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.coloros.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");
        options.setNoReset(true);

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);

        Thread.sleep(2000); // wait for calculator to open

        // ===== Input 500 ÷ 0.081 =====
        clickNumber(driver, "5");
        clickNumber(driver, "0");
        clickNumber(driver, "0");

        driver.findElement(By.id("com.coloros.calculator:id/img_op_div")).click(); // ÷ button

        clickNumber(driver, "0");
        clickNumber(driver, ".");
        clickNumber(driver, "0");
        clickNumber(driver, "8");
        clickNumber(driver, "1");

        //driver.findElement(By.id("com.coloros.calculator:id/img_op_div")).click(); // = button

        // ===== Get result =====
        WebElement result = driver.findElement(By.id("com.coloros.calculator:id/result"));
        System.out.println("Coins Owned = " + result.getText());

        driver.quit();
    }

    // Helper to click digits
    public static void clickNumber(AndroidDriver driver, String num) {
        driver.findElement(By.xpath("//android.widget.Button[@text='" + num + "']")).click();
    }
}
