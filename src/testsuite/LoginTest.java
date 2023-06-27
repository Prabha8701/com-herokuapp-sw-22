package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void closeDown() {
        // closeBrowser();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        String expectedText = "Your username is invalid!\n" +
                "×";
        String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals(expectedText,actualText);

    }

    @Test
    public void verifyThePasswordErrorMessage() {

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword");

        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        String expectedText = "Your password is invalid!\n" +
                "×";
        String actualText =driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
}
