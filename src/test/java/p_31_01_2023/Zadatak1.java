package p_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

//        String uploadImgPath = new File("test_data/1674929816267.jpeg").getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://tus.io/demo.html");
//        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("js-file-input")));
        actions.perform();

        driver.findElement(By.id("js-file-input")).sendKeys(new File("src/test/test_data/1674929816267.jpeg").getAbsolutePath());


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='button button-primary']")));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='js-upload-container']")));


        Thread.sleep(3000);
        driver.quit();

    }
}

//Napisati program koji:
//Krairajte folder za fajlove u okviru projekta pod nazivom test_data
//U folder skinite i postavite proizvoljnu sliku
//Ucitava stranu https://tus.io/demo.html
//Skrola do dela za upload fajla
//Aploadujte sliku
//Cekajte da se pojava dugme za download fajla