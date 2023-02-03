package p__02_02_2023;


import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class UvodUTestNg {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "drivers/chromedriver.exe");

        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://google.com");
    }
    @Test
    @Description("TC-1 Login with invalid credentials.")
    public void googleTitleTest()  {
//
        int numberOfLink = driver.findElements(
                By.xpath("//div[contains(@class, 'blabla')]")).size();
        Assert.assertEquals(numberOfLink, 18,
                "Number of links on home page.");


    }
//    @Test
//    public void googleUrlTest() {
////        Assert.assertEquals(driver.getCurrentUrl(), "https://google.com/");
//    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AFTER TEST");
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
