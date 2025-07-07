package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;

public class WaitUtils {
    public static void waitForCondition(WebDriver driver, ExpectedCondition<?> condition, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(condition);
    }
}
