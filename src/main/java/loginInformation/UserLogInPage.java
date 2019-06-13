package loginInformation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogInPage {

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLOgin;

    @FindBy(css = ".alert>ol>li:first-child()")
    //"//*[@id=\\\"create_account_error\\\"]/ol/li")
    private WebElement errorMessage;

    @FindBy(css = ".alert>ol>li:first-child()")
    //"//div[contains(@class,'alert alert-danger')]//li[text() = 'Authentication failed.']")
    private WebElement authenticationMessage;

    public UserLogInPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void inputUserEmail(String email) {
        emailAddress.sendKeys(email);
    }

    public void inputUserPassword(String passwd) {
        password.sendKeys(passwd);
    }

    public void submitLogIn() {
        submitLOgin.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getAuthenticationMessage() {
        return authenticationMessage.getText();
    }
}

