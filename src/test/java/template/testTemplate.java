package template;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class testTemplate {

    private WebDriver driver;
    private WebDriverWait wait;
    String  baseUrl = "https://";


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver.get(baseUrl + "");
        driver.manage().window().maximize();
    }


    @Test(priority = 1)
    @Description("Test #1:  some description")
    public void someDescription() throws InterruptedException {

        driver.findElement(By.cssSelector(".")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(""))
                .getText().contains("a"),"");

        driver.findElement(By.xpath("")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains(""),"");

        wait.until(ExpectedConditions.numberOfElementsToBe(
                (By.cssSelector("")), 1));

        Assert.assertEquals(driver.getTitle(),"");



    }



    @AfterMethod
    public void sleep() throws InterruptedException {
        Thread.sleep(3000);
    }

    @AfterClass
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}

//