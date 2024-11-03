package Test;

import Pages.LoginPage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() throws IOException, CsvValidationException {
        String CSV_file = System.getProperty("user.dir") + "\\src\\test\\java\\Data\\Login.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV_file));
        List<Object[]> csvData = new ArrayList<>();
        String[] csvCell;


        while ((csvCell = reader.readNext()) != null) {
            csvData.add(new Object[]{csvCell[0], csvCell[1]});
        }


        return csvData.toArray(new Object[0][0]);
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.clearFields();
        loginPage.login(username, password);

        String expected = "we are in landing page";
        String actual = loginPage.logovisability();
        Assert.assertEquals(actual, expected, "Login test failed for user: " + username);

        loginPage.logout();
    }
}
