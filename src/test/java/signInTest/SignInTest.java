package signInTest;

import loginInformation.UserLogInPage;
import loginInformation.UserLogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest {

    private WebDriver webDriver;

    @BeforeTest
    public void BeforeTestSignIn() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("http://automationpractice.com/index.php");
        WebElement clickSignIn = webDriver.findElement(By.xpath("//*[contains(@title,'Log in to your customer account')]"));
        clickSignIn.click();
    }

    @Test
    public void UserSignInTest() {
        UserLogInPage userLogIn = new UserLogInPage(webDriver);
        userLogIn.inputUserEmail("iteaiteatester@gmail.com");
        userLogIn.inputUserPassword("test1234");
        userLogIn.submitLogIn();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void UserSignInValidation() {
        UserLogInPage userLogInPage = new UserLogInPage(webDriver);
        userLogInPage.inputUserEmail("invalid_email");
        userLogInPage.inputUserPassword("fszjcf");
        userLogInPage.submitLogIn();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String expectedResult = "Invalid email address.";
        String actualResult = userLogInPage.getErrorMessage();
        Assert.assertEquals(expectedResult, actualResult);
    }
}

