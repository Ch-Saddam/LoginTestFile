package testLogin;

import Base.BaseTest;
import Data.LoginDataProvider;
import Pages.LoginPageAllCases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTestAllcases extends BaseTest {
    private LoginPageAllCases loginPage;

    @BeforeMethod
    public void setUp() {
        launchApp("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPageAllCases(driver);
    }

    @Test(priority = 1,dataProvider = "validCredentials", dataProviderClass = LoginDataProvider.class)
    public void testValidLogin(String username, String password) {
        loginPage.login(username, password);
        assertEquals(driver.getCurrentUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @Test(priority = 2,dataProvider = "emptyFieldsData", dataProviderClass = LoginDataProvider.class)
    public void testEmptyFieldValidation(String username, String password) {
        loginPage.login(username, password);

        if (username.trim().isEmpty())
            assertEquals(loginPage.getEmptyUsernameErrorText(), "Required");

        if (password.trim().isEmpty())
            assertEquals(loginPage.getEmptyPasswordErrorText(), "Required");
    }

    @Test(priority = 3,dataProvider = "invalidCredentials", dataProviderClass = LoginDataProvider.class)
    public void testInvalidCredentials(String username, String password) {
        loginPage.login(username, password);
        assertEquals(loginPage.getInvalidUserPasswordAlert(), "Invalid credentials");
    }
}
