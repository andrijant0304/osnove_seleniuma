package domaci_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        Select select = new Select(driver.findElement(By.id("delay-select")));
        select.selectByValue("2000");
        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='item'][last()" + -1 +"]")));
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='item'][last()]")));
        actions.perform();
        Thread.sleep(1000);

        actions.moveToElement(driver.findElement(By.className("disabled-text")));
        actions.perform();
        Thread.sleep(1500);

        wait.until(ExpectedConditions.elementToBeClickable(By.className("active-text")));

        driver.findElement(By.id("infinite-scroll-button")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='item']"),8));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.className("active-text"))));

        actions.moveToElement(driver.findElement(By.className("footer")));
        actions.perform();

        Thread.sleep(3000);
        driver.quit();
    }
}

//Napisati program koji testira infinity scroll.
//●	Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//●	Selektujte delay od 2000ms, koristeci Select klasu.
//●	Skrol do Show more dugmeta koje se nalazi na dnu stranice
//●	Sacekajte da dugme bude klikljivo
//●	Klik na Show more dugme
//●	Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//●	Sacekajte da dugme vise ne bude klikljivo