package appium;import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;
import java.time.Duration;

public class ChromeScrollSimple {
    public static void main(String[] args) throws Exception {

        // ===== Desired Capabilities =====
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("BA6HLRAABQYX5TT8"); // adb device ID
        options.setPlatformName("Android");
        options.setPlatformVersion("15"); // your Android version
        options.setAutomationName("UiAutomator2");
        options.setNoReset(true);

        // For Chrome, use setCapability
        options.setCapability("browserName", "Chrome");

        // ===== Start Appium session =====
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ===== Open website =====
        driver.get("https://www.google.com");

        // ===== Scroll page 3 times =====
        for (int i = 0; i < 3; i++) {
            driver.executeScript("window.scrollBy(0,1000)"); // scroll down 1000px
            Thread.sleep(2000); // wait to see scroll effect
        }

        System.out.println("Chrome opened and scrolled successfully!");

        // ===== Close session =====
        driver.quit();
    }
}
