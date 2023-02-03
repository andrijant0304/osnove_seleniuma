package p__03_02_2023;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class KatalonShopTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private  String baseUrl = "https://cms.demo.katalon.com";


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.get(baseUrl + "/product/flying-ninja/");
    }

    @Test(priority = 10)
    @Description("Test #1:  Adding product with quantity to the cart")
    public void addingProducWithQuantityToTheCart() throws InterruptedException {

        driver.findElement(By.cssSelector(".quantity-button.quantity-up")).click();
        driver.findElement(By.cssSelector(".quantity-button.quantity-up")).click();
        driver.findElement(By.cssSelector(".single_add_to_cart_button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".woocommerce-message"))
                .getText().contains("Flying Ninja"),"Invalid text");

        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[1]/a")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"),"Invalid URL text");

        wait.until(ExpectedConditions.numberOfElementsToBe(
                (By.cssSelector(".woocommerce-cart-form__cart-item.cart_item")), 1 ));
    }

    @Test(priority = 20)
    @Description("Test #2:  Removing product from cart")
    public void removingProductFromCart(){

        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[1]/a")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"),"Invalid URL text");
        wait.until(ExpectedConditions.numberOfElementsToBe(
                (By.cssSelector(".woocommerce-cart-form__cart-item.cart_item")), 1 ));

        driver.findElement(By.cssSelector(".remove")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(
                (By.cssSelector(".woocommerce-cart-form__cart-item.cart_item")), 0 ));
    }

    @Test(priority = 30)
    @Description("Test #3:  Verify error is displayed when username is missing")
    public void verifyErrorIsDisplayedWhenUsernameIsMissing(){

        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[3]/a")).click();
        driver.findElement(By.cssSelector(".woocommerce-form-login__submit")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li"))
                .getText().contains("Error: Username is required."));
    }

    @Test(priority = 40)
    @Description("Test #4:  Verify error is displayed when password is missing")
    public void verifyErrorIsDisplayedWhenPasswordIsMissing(){

        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[3]/a")).click();
        driver.findElement(By.cssSelector("#username")).sendKeys("customer");
        driver.findElement(By.cssSelector(".woocommerce-form-login__submit")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li"))
                .getText().contains("ERROR: The password field is empty."));
    }

    @Test(priority = 50)
    @Description("Test #5:  Verify error is displayed when password is wrong")
    public void verifyErrorIsDisplayedWhenPasswordIsWrong(){

        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[3]/a")).click();
        driver.findElement(By.cssSelector("#username")).sendKeys("customer");
        driver.findElement(By.cssSelector("#password")).sendKeys("invalidpassword");
        driver.findElement(By.cssSelector(".woocommerce-form-login__submit")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li"))
                .getText().contains("ERROR: The password you entered for the username customer is incorrect. Lost your password?"));
    }

    @Test(priority = 60)
    @Description("Test #6:  Verify error is displayed when user does not exist")
    public void verifyErrorIsDisplayedWhenUserDoesNotExist(){

        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[3]/a")).click();
        driver.findElement(By.cssSelector("#username")).sendKeys("invaliduser");
        driver.findElement(By.cssSelector("#password")).sendKeys("pass1234");
        driver.findElement(By.cssSelector(".woocommerce-form-login__submit")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li"))
                .getText().contains("ERROR: Invalid username. Lost your password?"));
    }

    @Test(priority = 70)
    @Description("//Test #7:  Verify successful login")
    public void verifySuccessfuLogin(){

        driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[3]/a")).click();
        driver.findElement(By.cssSelector("#username")).sendKeys("customer");
        driver.findElement(By.cssSelector("#password")).sendKeys("crz7mrb.KNG3yxv1fbn");
        driver.findElement(By.cssSelector(".woocommerce-form-login__submit")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='post-10']//p[1]"))
                .getText().contains("Hello Katalon Parlitul_Changed"));
    }

    @AfterClass
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}

//Zadatak
//	Kreirati KatalonShopTests klasu:
//	baseUrl: https://cms.demo.katalon.com/product/flying-ninja/
//	Test #1:  Adding product with quantity to the cart
//	Prioritet = 10
//	Koraci:
//Ucitati stranicu /product/flying-ninja/
//Unesite kolicinu 3
//Klik na Add to cart dugme
//Verifikovati da poruka sadrzi tekst “Flying Ninja”.
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
//
//	Test #2:  Removing product from cart
//	Prioritet = 20
//	Koraci:
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
//Klik na remove dugme iz prvog reda
//Verifikovati da je broj proizvoda u korpi jedako 0
//
//Test #3:  Verify error is displayed when username is missing
//	Prioritet = 30
//	Koraci:
//Kliknite na my account link
//Klik na login dugme
//Verifikovati da je prikazana poruka Error: Username is required.
//
//Test #4:  Verify error is displayed when password is missing
//	Prioritet = 40
//	Koraci:
//Kliknite na my account link
//Unesite username customer
//Klik na login dugme
//Verifikovati da je prikazana poruka ERROR: The password field is empty.
//
//Test #5:  Verify error is displayed when password is wrong
//	Prioritet = 50
//	Koraci:
//Kliknite na my account link
//Unesite username customer
//Unesite nevalidan pass invalidpassword
//Klik na login dugme
//Verifikovati da je prikazana poruka ERROR: The password you entered for the username customer is incorrect. Lost your password?
//
//Test #6:  Verify error is displayed when user does not exist
//	Prioritet = 60
//	Koraci:
//Kliknite na my account link
//Unesite username invaliduser
//Unesite nevalidan pass (ex: pass1234)
//Klik na login dugme
//Verifikovati da je prikazana poruka ERROR: Invalid username. Lost your password?
//
//Test #7:  Verify successful login
//	Prioritet = 70
//	Koraci:
//Kliknite na my account link
//Unesite username customer
//Unesite validan pass crz7mrb.KNG3yxv1fbn
//Klik na login dugme
//Verifikovati na stranici pise Hello Katalon Parlitul_Changed
//	Dopunite pageve za sve sto je potrebno za ove testove, ako je potrebno kreirajte i nove pageve