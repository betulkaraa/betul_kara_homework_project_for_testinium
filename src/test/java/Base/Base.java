package Base;

import MethodsAndCommands.Commands;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Base {

    public static void main(String[] args) throws InterruptedException {
        //Kullanılacak paramtreler "public" olarak tanıtılarak çağrılması kolaylaştırıldı.
        WebDriver driver;
        Commands steps = new Commands();
         ExpectedConditions ExceptionConditions;

           //Web tarayıcısı ile bağlantı kurulması ve login sayfasına erişimi

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            System.setProperty("webdriver.chrome.driver", "C:/Users/BETÜL/selenium/ChromeDriver/chromedriver.exe");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://www.gittigidiyor.com");

          //Giriş yap kısmı sayfada bulundu (xpath ile)
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/section[1]/section[2]/a")).click();
        Thread.sleep(1000);
        //Giriş için ilgili buttona tıkla komut verildi.(xpath ile)
         driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div[1]/div[3]/div/div[1]/div")).click();
        Thread.sleep(1000);
        driver.get("https://www.gittigidiyor.com/uye-girisi?s=1");

            // Erişilen login sayfasına action ile erişim sağlanması
            //Test kısmında hesap girişin doğruluk kontrolü methods & methodsları kontrol altında tutan commands sınıfı ile yapıldı.
            Actions action = new Actions(driver);
            WebElement we = driver.findElement(By.className("clearfix"));
            action.moveToElement(we).moveToElement(driver.findElement(By.className("clearfix"))).click().build().perform();
            driver.findElement(By.id("L-UserNameField")).sendKeys("cevherbtl.trky@gmail.com");
            driver.findElement(By.id("L-PasswordField")).sendKeys("708090Be");
            driver.findElement(By.id("gg-login-enter")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);











    }
    }

