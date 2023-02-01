package p_31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

//        String uploadImgPath = new File("test_data/1674929816267.jpeg").getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        driver.manage().window().maximize();

//        Actions actions = new Actions(driver);

        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys(new File("src/test/test_data/1674929816267.jpeg")
                        .getAbsolutePath());

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//span[@class='preview']"), 1));

        driver.findElement(By.xpath("//tr/td[4]/button[2]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".template-download .btn-danger.delete"))).click();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("1674929816267")));

//        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//span[@class='preview']"), 0));
//        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("template-upload"), 0));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".template-download .btn-danger.delete"), 0));

        Thread.sleep(3000);
        driver.quit();
    }
}

//Napisati program koji:
//Ucitava stranu https://blueimp.github.io/jQuery-File-Upload/
//Uploadujte sliku
//Ceka se da se pojavi slika u listi uploadovanih fajlova
//Koristite uslov da broj elemenata bude 1.
//Klik na Start dugme u okviru item-a koji se uploadovao
//Ceka se da se pojavi delete dugme pored itema
//Klik na delete dugme pored itema
//Ceka se da se element obrise
//Koristite da broj elemenata bude 0