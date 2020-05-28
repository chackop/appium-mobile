import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mobile_Test {

    // private static final String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.app.zip";
    private static final String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk";
    
    private static final String APPIUM = "http://localhost:4723/wd/hub";

    // private IOSDriver driver;
    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        
        // caps.setCapability("platformName", "iOS");
        // caps.setCapability("platformVersion", "11.4");
        // caps.setCapability("deviceName", "iPhone 8");
        // caps.setCapability("automationName", "XCUITest");
        // caps.setCapability("app", APP);
        // driver = new IOSDriver(new URL(APPIUM), caps);

        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", APP);
        driver = new AndroidDriver(new URL(APPIUM), caps);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        // WebDriverWait wait = new WebDriverWait(driver, 10);

        // WebElement screen = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Login Screen")));
        // screen.click();

        // Elements basic

    //     WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("username")));
    //     username.sendKeys("alice");

    //     WebElement password = driver.findElement(MobileBy.AccessibilityId("password"));
    //     password.sendKeys("mypassword");

    //     WebElement login = driver.findElement(MobileBy.AccessibilityId("loginBtn"));
    //     login.click();

    
    //     WebElement loginText = wait.until(
        //         ExpectedConditions.presenceOfElementLocated(
            //             MobileBy.xpath("//android.widget.TextView[contains(@text, 'You are logged in')]")
            //         )
            //     );
            
            //    assert(loginText.getText().contains("alice"));

        // try { Thread.sleep(1001); } catch (Exception ign) {}

        // Page source
        // System.out.println(driver.getPageSource());

        // Other element location
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Echo Box"))).click();

        // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("messageInput"))).sendKeys("hello world");
        // driver.findElement(MobileBy.AccessibilityId("messageSaveBtn")).click();

        // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("hello world")));
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement screen = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("List Demo")));
        screen.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Altocumulus")));

        PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
        Interaction moveToStart = finger.createPointerMove(Duration.ZERO, Origin.viewport(), 520, 1530);
        Interaction pressDown = finger.createPointerDown(MouseButton.LEFT.asArg());
        Interaction moveToEnd = finger.createPointerMove(Duration.ofMillis(1000), Origin.viewport(), 520, 490);
        Interaction pressUp = finger.createPointerUp(MouseButton.LEFT.asArg());

        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(moveToStart);
        swipe.addAction(pressDown);
        swipe.addAction(moveToEnd);
        swipe.addAction(pressUp);

        driver.perform(Arrays.asList(swipe));

        driver.findElement(MobileBy.AccessibilityId("Stratus"));
    }
}
