package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageAllCases {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By usernameField = By.cssSelector("input[placeholder='Username']");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector(".orangehrm-login-button");
    private final By usernameErrorMessage = By.xpath("//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]");
    private final By passwordErrorMessage = By.xpath("//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]");
    private final By alertErrorMessage = By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");


    public LoginPageAllCases(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username) {
        WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        userInput.clear();
        userInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passInput.clear();
        passInput.sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public String getEmptyUsernameErrorText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameErrorMessage));
        return driver.findElement(usernameErrorMessage).getText();
    }

    public String getEmptyPasswordErrorText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordErrorMessage));
        return driver.findElement(passwordErrorMessage).getText();
    }

    public String getInvalidUserPasswordAlert() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertErrorMessage));
        return driver.findElement(alertErrorMessage).getText();
    }
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

}
