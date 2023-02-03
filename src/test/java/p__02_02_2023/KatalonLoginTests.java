package p__02_02_2023;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class KatalonLoginTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://cms.demo.katalon.com";

    @BeforeClass
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void beforeMethod2(){
        driver.get(baseUrl);
    }


    @Test
    @Description("Test #1: Visit login page from Nav bar")
    public void visitLoginPageFromNavBar(){

        driver.get(baseUrl);
        driver.manage().window().maximize();

//        driver.findElement(By.cssSelector(".page-item-10")).click();
        driver.findElement(By.linkText("MY ACCOUNT")).click();

        String title = driver.getTitle();
        Assert.assertEquals(title, "My account – Katalon Shop", "Not on my account page.");

//        String url = driver.getCurrentUrl();
//        Assert.assertEquals(url.contains("/my-account"), true,"Webpage url.");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl +"/my-account", "Not on my account page.");

//        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Not on my account page.");
    }

    @Test
    @Description("Test #2: Check input types")
    public void checkInputTypes(){

        driver.get("https://cms.demo.katalon.com/my-account/");

        String typeUser = driver.findElement(By.id("username")).getAttribute("type");
        Assert.assertEquals(typeUser, "text", "Type attribute of username/email input field");

        String typePass = driver.findElement(By.id("password")).getAttribute("type");
        Assert.assertEquals(typePass, "password", "Type attribute of password input field");

        String checkbox = driver.findElement(By.id("rememberme")).getAttribute("type");
        Assert.assertEquals(checkbox, "checkbox", "Type attribute of checkbox input field");

        boolean checkboxSelected = driver.findElement(By.id("rememberme")).isSelected();
        Assert.assertEquals(!checkboxSelected, true, "'Remember me' should not be checked");
    }

    @Test
    @Description("Test #3: Display error when credentials are wrong")

    public void displayErrorWithWrongCredentials(){

        driver.get("https://cms.demo.katalon.com/my-account/");

        driver.findElement(By.id("username")).sendKeys("invalidemail@gmail.com");
        driver.findElement(By.id("password")).sendKeys("invalid123");
        driver.findElement(By.name("login")).click();

        Assert.assertNotNull(driver.findElement(By.cssSelector(".woocommerce-error")), "Login error is displayed");
//        Assert.assertTrue(new Helper().elementExist(driver.findElement(By.cssSelector(".woocommerce-error"))), "Login error is displayed");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".woocommerce-error")));

        Assert.assertEquals(driver.findElement(
                By.cssSelector(".woocommerce-error")).getText(),
                "ERROR: Invalid email address",
                "Error message is not displayed when credentials are wrong");

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url.contains("/my-account"), true,"Webpage url.");
    }

    @AfterMethod
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}

//Zadatak
//Kreirati klasu KatalonLoginTests za testove
//Base url: https://cms.demo.katalon.com
//Test #1: Visit login page from Nav bar
//Koraci:
//Ucitati home stranicu
//Kliknuti na My account link
//Verifikovati da je naslov stranice My account – Katalon Shop
//Verifikovati da se u url-u stranice javlja /my-account
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske

//Test #2: Check input types
//Koraci:
//Ucitati /my-account stranicu
//Verifikovati da  polje za unos email-a za atribu type ima vrednost text
//Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//Verifikovati da checkbox Remember me za atribut type ima vrednost checkbox
//Verifikovati da je Remember me checkbox decekiran.
// Koristan link kako naci informaciu da li je checkbox cekiran ili ne.
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske

//Test #3: Display error when credentials are wrong
//Podaci:
//email: invalidemail@gmail.com
//password: invalid123
//Koraci:
//Ucitati /my-account stranicu
//Unesite email
//Unesite password
//Kliknite na login dugme
//Verifikovati da postoji element koji prikazuje gresku
//Verifikovati da je prikazana greska ERROR: Invalid email address
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//Verifikovati da smo idalje na login stranici posle greske, tako sto proveravamo da se url-u javlja /my-account