package Data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "validCredentials")
    public static Object[][] validCredentials() {
        return new Object[][]{
                {"Admin", "admin123"}
        };
    }

    @DataProvider(name = "emptyFieldsData")
    public static Object[][] emptyFieldsData() {
        return new Object[][]{
                {"", ""},          // both fields empty
                {" ", " "},        // both fields with spaces
                {"Admin", ""},     // password empty
                {"", "admin123"},
                {"Admin", " "},     // username with password spaces
                {" ", "admin123"},  // Password with username spaces
                {" ", ""},         // Username spaces with empty password
                {"", " "}         // Empty username with username spaces
        };
    }

    @DataProvider(name = "invalidCredentials")
    public static Object[][] invalidCredentials() {
        return new Object[][]{
                {"wrongUser", "admin123"},
                {"Admin", "wrongPass"},
                {"invalid", "invalid"}
        };
    }
}

