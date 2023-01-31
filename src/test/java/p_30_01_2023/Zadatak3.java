package p_30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().window().maximize();

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        driver.findElement(By.className("btn-primary")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("toast"))));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast")));
        System.out.println("Element se pojavio");

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("toast"))));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast")));
        System.out.println("Element se izgubio");

        driver.findElement(By.className("btn-primary")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("toast"))));
        System.out.println("Element se pojavio");

        driver.findElement(By.className("btn-close")).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("toast"))));
        System.out.println("Element se izgubio");

//        wait.until(ExpectedConditions.p(By.className("toast")));

//        wait.until(ExpectedConditions.titleContains("Progres"));
//        wait.until(ExpectedConditions.)



//        driver.quit();
    }
}

//Napisati program koji
//ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Klik Primary dugme
//Ceka da se pojavi toasts u gornjem desnom uglu
//Ispisuje da se element pojavio
//Ceka da se izgubi toasts u gornjem desnom uglu
//Ispisuje da se elment izgubio
//Klik na primary dugme
//Ceka da se pojavi toasts u gornjem desnom uglu
//Ispisuje da se element pojavio
//Klik na x dugme iz toasts-a
//Ceka da se element izgubi
//Ispisuje da se element izgubio