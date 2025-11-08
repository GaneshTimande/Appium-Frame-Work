package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class MobileActionsComplete {

    public AndroidDriver driver;

    // ---------------- Launch App ----------------
    public void launchApp(String deviceName, String platformVersion, String appPackage,
                          String appActivity, String serverURL) throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setPlatformName("Android");
        options.setPlatformVersion(platformVersion);
        options.setAppPackage(appPackage);
        options.setAppActivity(appActivity);
        options.setNoReset(true);

        driver = new AndroidDriver(new URL(serverURL), options); 
        System.out.println("Android app launched successfully!");
    }

    // ---------------- Gestures ----------------
    public void scrollVertical(double startPercent, double endPercent) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * startPercent);
        int endY = (int) (size.height * endPercent);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }

    public void swipeHorizontal(double startPercent, double endPercent, double yPercent) {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * startPercent);
        int endX = (int) (size.width * endPercent);
        int y = (int) (size.height * yPercent);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }

    public void tap(double xPercent, double yPercent) {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width * xPercent);
        int y = (int) (size.height * yPercent);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }

    public void longPress(double xPercent, double yPercent, int durationMs) {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width * xPercent);
        int y = (int) (size.height * yPercent);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longPress = new Sequence(finger, 1);
        longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(finger.createPointerMove(Duration.ofMillis(durationMs), PointerInput.Origin.viewport(), x, y));
        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(longPress));
    }

    public void dragAndDrop(double startXPercent, double startYPercent, double endXPercent, double endYPercent) {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * startXPercent);
        int startY = (int) (size.height * startYPercent);
        int endX = (int) (size.width * endXPercent);
        int endY = (int) (size.height * endYPercent);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence drag = new Sequence(finger, 1);
        drag.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        drag.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        drag.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), endX, endY));
        drag.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(drag));
    }

    // ---------------- Permissions ----------------
    public void grantPermission(String packageName, String permission) {
        driver.executeScript("mobile: shell",
                ImmutableMap.of("command", "pm grant " + packageName + " " + permission));
    }

    // ---------------- Device Settings ----------------
    public void toggleWifi(boolean enable) {
        driver.executeScript("mobile: shell",
                ImmutableMap.of("command", enable ? "svc wifi enable" : "svc wifi disable"));
    }

    public void toggleBluetooth(boolean enable) {
        driver.executeScript("mobile: shell",
                ImmutableMap.of("command", enable ? "service call bluetooth_manager 6" : "service call bluetooth_manager 8"));
    }

    public void toggleLocation(boolean enable) {
        driver.executeScript("mobile: shell",
                ImmutableMap.of("command", enable ? "settings put secure location_mode 3" : "settings put secure location_mode 0"));
    }

    public void toggleFlightMode(boolean enable) {
        driver.executeScript("mobile: shell",
                ImmutableMap.of("command", enable ? "settings put global airplane_mode_on 1" : "settings put global airplane_mode_on 0"));
        driver.executeScript("mobile: shell",
                ImmutableMap.of("command", "am broadcast -a android.intent.action.AIRPLANE_MODE --ez state " + enable));
    }

    public void toggleDoNotDisturb(boolean enable) {
        driver.executeScript("mobile: shell",
                ImmutableMap.of("command", enable ? "settings put global zen_mode 1" : "settings put global zen_mode 0"));
    }

    public void toggleFlashlight(boolean enable) {
        driver.executeScript("mobile: shell",
                ImmutableMap.of("command", enable ? "input keyevent 26 && input swipe 0 1000 0 0" : "input keyevent 26"));
    }

    public void toggleMobileData(boolean enable) {
        driver.executeScript("mobile: shell",
                ImmutableMap.of("command", enable ? "svc data enable" : "svc data disable"));
    }

    // ---------------- Lock / Unlock Device ----------------
    public void lockDevice(int seconds) {
        driver.lockDevice(Duration.ofSeconds(seconds));
    }

    public void unlockDevice() {
        driver.unlockDevice();
    }

    // ---------------- File Push / Pull ----------------
    public void pushFile(String devicePath, String localPath) throws IOException {
        driver.pushFile(devicePath, new File(localPath));
    }

    public void pullFile(String devicePath, String localPath) {
        byte[] fileData = driver.pullFile(devicePath);
        try (FileOutputStream fos = new FileOutputStream(localPath)) {
            fos.write(fileData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- App Background / Foreground ----------------
    public void backgroundApp(int seconds) {
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

    // ---------------- Switch Context ----------------
    public void switchToWebView(String webViewName) {
        driver.context(webViewName);
    }

    public void switchToNative() {
        driver.context("NATIVE_APP");
    }

    // ---------------- Rotate Screen ----------------
    public void rotateScreen(ScreenOrientation orientation) {
        driver.rotate(orientation);
    }

    // ---------------- Handle Alerts ----------------
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // ---------------- SMS / Call ----------------
    public void sendSMS(String number, String message) {
        driver.executeScript("mobile: shell",
                ImmutableMap.of("command", "am start -a android.intent.action.SENDTO -d sms:" + number +
                        " --es sms_body '" + message + "' --ez exit_on_sent true"));
    }

    public void makeCall(String number) {
        driver.executeScript("mobile: shell",
                ImmutableMap.of("command", "am start -a android.intent.action.CALL -d tel:" + number));
    }

    public void makeCallWithUI(By numberField, By callButton, String number) {
        driver.findElement(numberField).sendKeys(number);
        driver.findElement(callButton).click();
    }

    // ---------------- Volume ----------------
    public void adjustVolume(int level) {
        driver.executeScript("mobile: shell",
                ImmutableMap.of("command", "media volume --set " + level));
    }

    // ---------------- Screenshot / Clipboard ----------------
    public void takeScreenshot(String localPath) {
        byte[] data = driver.getScreenshotAs(OutputType.BYTES);
        try (FileOutputStream fos = new FileOutputStream(localPath)) {
            fos.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void copyToClipboard(String text) {
        driver.setClipboardText(text);
    }

    public String getClipboardText() {
        return driver.getClipboardText();
    }

    // ---------------- Notifications ----------------
    public void openNotifications() {
        driver.openNotifications();
    }

    // ---------------- Battery Info ----------------
    public void printBatteryInfo() {
        Object batteryInfo = driver.executeScript("mobile: batteryInfo");
        System.out.println("Battery Info: " + batteryInfo);
    }
}
