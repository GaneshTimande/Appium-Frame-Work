package appium;import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.time.Duration;

public class AstroTalkLaunch {
    public static void main(String[] args) throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("BA6HLRAABQYX5TT8");
        options.setPlatformName("Android");
        options.setPlatformVersion("15");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.astrotalk");
        options.setAppActivity(".chatModule.ChatAstrologerlistActivity");
        options.setNoReset(true);
        options.setFullReset(false);

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("AstroTalk app launched successfully!");

        // Scroll 5 times
        for (int i = 0; i < 2; i++) {
            driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
            ));
          

        }
        Thread.sleep(2000);
        WebElement toolbar = driver.findElement(By.id("com.astrotalk:id/userPicIV"));

        toolbar.click();
        Thread.sleep(12000);
        System.out.println(toolbar.getText());

        driver.quit();
        TouchAction Action = new TouchAction(driver);
     //   Action.press(PointOption.point(0,0)).moveTo(PointOption.point(0,1000)).release().pefrom();
    }
}
