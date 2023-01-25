package p_24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UvodUSelenium {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com/");

        WebElement in = driver.findElement(
                By.xpath("//input[@name='q']"));

        long startTime = System.currentTimeMillis();
//        driver.findElement(By.xpath("//img[@class='lnXdpd']"));
//        driver.findElement(
//                By.xpath("//input[@name='q']"));
        in.sendKeys("I");
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Trazenje " + duration + "ms");


        String imgAttr = driver.findElement(By.xpath("//img[@class='lnXdpd']"))
                .getAttribute("src");

        System.out.println(imgAttr);

//        Thread.sleep(5000);

//        driver.findElement(By.xpath("//input[@name='q']"))
//                .sendKeys("IT Bootcamp");
//
//        driver.findElement(By.xpath("//input[@name='q']"))
//                .sendKeys(Keys.ENTER);
//
//        Thread.sleep(1000);

//        WebElement firstLink =
//                driver.findElement(
//                        By.xpath("//a[@href='https://itbootcamp.rs/']"));
//        firstLink.click();

//        driver.findElement(By.xpath("//a[@href='https://itbootcamp.rs/']"))
//
//
//        driver.findElement(By.xpath("//a[@href='https://itbootcamp.rs/']"))
//                        .click();




        Thread.sleep(5000);
        driver.quit();
    }
}
