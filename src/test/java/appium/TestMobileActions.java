package appium;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMobileActions {

    public MobileActionsComplete mobileActions;

    @BeforeClass
    public void setUp() throws Exception {
        mobileActions = new MobileActionsComplete();
        mobileActions.launchApp(
                "BA6HLRAABQYX5TT8",             // deviceName
                "15.0",                // platformVersion
                "com.astrotalk",     // appPackage
                ".chatModule.ChatAstrologerlistActivity", // appActivity
                "http://127.0.0.1:4723/wd/hub" // serverURL
        );
    }

    @Test(priority = 1)
    public void testGestures() throws InterruptedException {
        mobileActions.scrollVertical(0.8, 0.2);
        Thread.sleep(14000);
        System.out.println(" scill");
//        
        mobileActions.tap(0.5, 0.5);
        Thread.sleep(14000);
        System.out.println(" tap");
        mobileActions.swipeHorizontal(0.8, 0.2, 0.5);
//    Thread.sleep(14000);
     System.out.println("swipe h");
        mobileActions.longPress(0.5, 0.5, 1500);
        Thread.sleep(14000);
        System.out.println(" long");
   //     mobileActions.dragAndDrop(0.3, 0.5, 0.7, 0.5);
        Thread.sleep(14000);
        System.out.println("a");
    }
}
//    @Test(priority = 22)
//    public void testPermissions() {
//        mobileActions.grantPermission("com.astrotalk", "android.permission.CAMERA");
//        mobileActions.grantPermission("com.astrotalk", "android.permission.RECORD_AUDIO");
//        mobileActions.grantPermission("com.astrotalk", "android.permission.WRITE_EXTERNAL_STORAGE");
//        System.out.println("b");
//    }
//
//    @Test(priority = 3)
//    public void testDeviceSettings() {
//        mobileActions.toggleWifi(true);
//        mobileActions.toggleBluetooth(true);
//        mobileActions.toggleLocation(true);
////       // mobileActions.toggleFlightMode(true);
////        mobileActions.toggleDoNotDisturb(true);
////        mobileActions.toggleFlashlight(true);
////        mobileActions.toggleMobileData(true);
//        System.out.println("c");
//    }
//
////    @Test(priority = 4)
////    public void testLockUnlock() {
////        mobileActions.lockDevice(3);   // locks device for 3 seconds
////        mobileActions.unlockDevice();
////        System.out.println("d");
////    }
//
//	/*
//	 * @Test(priority = 5) public void testFilePushPull() throws Exception {
//	 * mobileActions.pushFile("/sdcard/test.txt",
//	 * "C:\\Users\\DELL\\Desktop\\test.txt");
//	 * mobileActions.pullFile("/sdcard/test.txt",
//	 * "C:\\Users\\DELL\\Desktop\\test_pull.txt"); System.out.println("e"); }
//	 */
//
//	/*
//	 * @Test(priority = 6) public void testAppBackground() {
//	 * mobileActions.backgroundApp(3); System.out.println("e"); }
//	 */
//
//    @Test(priority = 7)
//    public void testContextSwitch() {
//        // Example WebView name, replace with your app's WebView
//        mobileActions.switchToWebView("WEBVIEW_com.example.app");
//        mobileActions.switchToNative();
//        System.out.println("f");
//    }
//
//    @Test(priority = 2)
//    public void testRotateScreen() {
//        mobileActions.rotateScreen(ScreenOrientation.LANDSCAPE);
//        mobileActions.rotateScreen(ScreenOrientation.PORTRAIT);
//        System.out.println("g");
//    }
//
//	/*
//	 * @Test(priority = 9) public void testAlerts() { // Trigger alert manually in
//	 * app for testing mobileActions.acceptAlert(); mobileActions.dismissAlert(); }
//	 * 
//	 * @Test(priority = 10) public void testSMSCall() {
//	 * mobileActions.sendSMS("1234567890", "Test Message");
//	 * mobileActions.makeCall("1234567890"); // Example UI call, replace locators
//	 * mobileActions.makeCallWithUI(By.id("com.example.app:id/numberField"),
//	 * By.id("com.example.app:id/callButton"), "1234567890"); }
//	 */
//
//    @Test(priority = 11)
//    public void testVolumeScreenshotClipboard() {
//        mobileActions.adjustVolume(5);
//        mobileActions.takeScreenshot("C:\\Users\\DELL\\Desktop\\screenshot.png");
//        mobileActions.copyToClipboard("Hello Clipboard");
//        String text = mobileActions.getClipboardText();
//        System.out.println("Clipboard text: " + text);
//        System.out.println("i");
//    }
//
//    @Test(priority = 12)
//    public void testNotificationsBattery() {
//        mobileActions.openNotifications();
//        mobileActions.printBatteryInfo();
//        System.out.println("j");
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (mobileActions.driver != null) {
//            mobileActions.driver.quit();
//        }
//    }
//}
