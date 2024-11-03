package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement usernamefield;

    @FindBy(id = "password")
    WebElement passwordfield;

    @FindBy(id = "login-button")
    WebElement loginButton;


    @FindBy(className = "app_logo")
    WebElement appLogo;

    @FindBy(className = "bm-burger-button")
    WebElement headerLabel;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    public String logovisability() {
        if (appLogo.isDisplayed()) {
            return "we are in landing page";
        } else {
            return "we are not in landing page";
        }
    }

    public void login(String username, String password) {
        usernamefield.sendKeys(username);
        passwordfield.sendKeys(password);
        loginButton.click();

    }
    public void logout() {
        headerLabel.click();
        logoutLink.click();
    }
    public void clearFields() {
        usernamefield.clear();
        passwordfield.clear();
    }
}
