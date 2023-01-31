package p_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
//        driver.manage().window().maximize();

        driver.findElement(By.id("basic-primary-trigger")).click();
        driver.findElement(By.id("basic-secondary-trigger")).click();
        driver.findElement(By.id("basic-success-trigger")).click();
        driver.findElement(By.id("basic-danger-trigger")).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("toast"),4));
//        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class, 'toast-fixed')][contains(@class, 'show'])"),4));
        System.out.println("Prikazani su");

//        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.className("toast"),1));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("toast"))));
//        wait.until(ExpectedConditions.not(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='toast']"))));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='toast']")));

        System.out.println("Toast is lost");

        driver.quit();
    }
}

//Zadatak
//Napisati program koji:
//Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Vrsi klik na Primary dugme, Secondary, Sucess, Danger
//Ceka da broj toasts-a bude 4
//Ispisuje poruku, toasts su prikazani
//Ceka da broj toasts-a bude 0
//Ispisuje poruku, toasts su se izgubili