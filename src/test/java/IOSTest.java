import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSTest {
    AppiumDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("platformVersion", "15.5");
        capabilities.setCapability("deviceName", "iPhone 13");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/UIKitCatalog.app");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
    public void click_App_Button() {
        driver.findElement(By.id("Buttons")).click();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
