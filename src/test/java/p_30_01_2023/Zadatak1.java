package p_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/klDWV");

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("precent")));

//        wait.until(ExpectedConditions.textToBe(By.id("precent"), "100%"));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader-wrap")));
        wait.until(ExpectedConditions.attributeContains(By.className("glow"), "style", "width: 100%"));


//        wait.until(ExpectedConditions.titleContains("Progres"));
//        wait.until(ExpectedConditions.)

        System.out.println("Stranica ucitana");


        driver.quit();
    }
}

//Zadatak
//Napisati program koji ucitava stranicu https://s.bootsnipp.com/iframe/klDWV
// i ceka da se ucita progress bar na 100% a zatim ispisuje tekst u konzoli “Stranica ucitana”