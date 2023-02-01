package domaci_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menu-item-6408"))).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu-item-6408']/ul")));

        Thread.sleep(2000);

        actions.moveToElement(driver.findElement(By.id("menu-item-5362"))).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu-item-5453']/ul")));

        Thread.sleep(2000);

        actions.moveToElement(driver.findElement(By.id("menu-item-5453"))).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu-item-5453']/ul")));

        Thread.sleep(5000);
        driver.quit();
    }
}

//Zadatak
//Napisati program koji:
//●	Ucitava stranu https://itbootcamp.rs/
//●	Misem prelazi preko Vesti iz navigacionog menija
//●	Ceka da se prikaze padajuci meni za Vesti
//●	Misem prelazi preko Kursevi iz navigacionog menija
//●	Ceka da se prikaze padajuci meni za Kursevi
//●	Misem prelazi preko Prijava i pravilnik iz navigacionog menija
//●	Ceka da se prikaze padajuci meni za Prijava i pravilnik
//●	Koristan link. Mouse over preko seleniuma
// https://www.selenium.dev/documentation/webdriver/actions_api/mouse/#move-to-element