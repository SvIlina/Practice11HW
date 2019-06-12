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
    private WebElement signIn;

    @FindBy(xpath = "//div[contains(@class,'alert alert-danger')]//li[text() ='Invalid email address.']")
    private WebElement errorMessage;

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
        signIn.submit();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}

