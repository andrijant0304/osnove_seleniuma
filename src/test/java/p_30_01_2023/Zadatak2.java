package p_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().window().maximize();

        driver.get("https://youtube.com");

        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("soad");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.SPACE);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//li[@role='presentation']"), 3));
        driver.findElement(By.xpath("//li[@role='presentation'][last()]")).click();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("precent")));
//        wait.until(ExpectedConditions.titleContains("Progres"));
//        wait.until(ExpectedConditions.)



//        driver.quit();
    }
}

//Napisati program koji ucitava stranicu https://youtube.com i u search baru unosi tekste Breskvica
// i ceka da se pojavi vise od 3 rezultata iz padajuceg menija i zatim klikce na prvi.