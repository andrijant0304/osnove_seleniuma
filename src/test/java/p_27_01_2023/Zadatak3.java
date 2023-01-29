package p_27_01_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");

        driver.findElement(By.xpath("//summary[@class='btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//details[1]/details-menu/div/div/label[2]")).click();
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@id='org-repositories']/div/div/div[1]/div[2]/a")).click();

        if(new Helper().elementExist(driver, new By.ByClassName("issues-reset-query"))){
            System.out.println("Postoji");
        }

        Thread.sleep(1000);
        driver.quit();
    }
}

//Zadatak
//Napisati program koji ucitava stranicu https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
//Klik na Type drawdown
//Klik na Public iz drowdowna
//Proverava da li je Clear dugme u desnom uglu prikazano
//Kilk na Clear filter u desnom uglu
