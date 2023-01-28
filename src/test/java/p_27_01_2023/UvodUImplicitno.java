package p_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UvodUImplicitno {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("file:///C:/HTML%201/IT%20Bootcamp/IT%20Bootcamp%202022/Nastava/9.%20nedelja%20-%20Selenium/predavanja/Zadatak4.html");

//        WebElement div = driver.findElement(By.id("id-0"));
        boolean elementExist = true;
        try {
//            System.out.println("Posle trazenja");
            WebElement div = driver.findElement(By.id("id-0"));

        } catch (NoSuchElementException error) {
            elementExist = false;
//            System.out.println("Greska");
        }

        if (elementExist){
            System.out.println("Element postoji");
        } else {
            System.out.println("Element ne postoji");
        }


        Thread.sleep(2000);
        driver.quit();
    }
}
