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
        webDriver.get("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
    }

    @Test
    public void UserSignInTest() {
        WebElement clickSignIn = webDriver.findElement(By.xpath("//*[contains(@title,'Log in to your customer account')]"));
        clickSignIn.click();
        UserLogInPage userLogInPage = new UserLogInPage(webDriver);
        userLogInPage.inputUserEmail("iteaiteatester@gmail.com");
        userLogInPage.inputUserPassword("test1234");
        userLogInPage.submitLogIn();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void UserSignInInvalidMessage() {
        WebElement clickSignIn = webDriver.findElement(By.xpath("//*[contains(@title,'Log in to your customer account')]"));
        clickSignIn.click();
        UserLogInPage userLogInPage = new UserLogInPage(webDriver);
        userLogInPage.inputUserEmail("invalid_email");
        userLogInPage.inputUserPassword("fszjcf");
        userLogInPage.submitLogIn();

        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String expectedResult = "Invalid email address.";
        String actualResult = userLogInPage.getErrorMessage();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void UserSignInEmailDoesnotExist() {
        WebElement clickSignIn = webDriver.findElement(By.xpath("//*[contains(@title,'Log in to your customer account')]"));
        clickSignIn.click();
        UserLogInPage userLogInPage = new UserLogInPage(webDriver);
        webDriver.findElement(By.id("email")).clear();
        userLogInPage.inputUserEmail("invalid_email@gmail.com");
        userLogInPage.inputUserPassword("fszjcf");
        userLogInPage.submitLogIn();

        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String expectedResult = "Authentication failed.";
        String actualResult = userLogInPage.getAuthenticationMessage();
        Assert.assertEquals(expectedResult, actualResult);
    }
}

