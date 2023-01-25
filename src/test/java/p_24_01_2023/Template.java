package p_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Template {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("");

//        driver.findElement(By.name());
//        driver.findElement(By.id());
//        driver.findElement(By.className());
//        driver.findElement(By.cssSelector());
//        driver.findElement(By.xpath("//*[text()='']")).click();
//        driver.getTitle();

        driver.findElement(By.xpath("")).sendKeys("");
        driver.findElement(By.xpath("")).click();



        Thread.sleep(5000);
        driver.quit();



    }
}
