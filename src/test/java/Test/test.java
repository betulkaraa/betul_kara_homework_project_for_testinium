package Test;

import Base.Base;
import MethodsAndCommands.Commands;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Element;

public class test<baseUrl, https> extends Base {
    //Kullanılacak isterler "public" olarak tanıtılarak çağrılması kolaylaştırıldı.
 WebDriver driver;
    Commands steps = new Commands();
        public void loginTest () throws InterruptedException { //login kontorolü

            steps.getTextControlTest("div[class='p-card-img-wr']", "Hesabım"); // hesap giriş kontrolü

        }
        @Test
        public void productFınd() throws InterruptedException { //ürün arama
            loginTest();
            steps.sendKeysToElementTest("input[sc-4995aq-0 sc-14oyvky-0 gHqOYK]", "Bilgisayar");
            steps.clickElement("button[class=qjixn8-0 sc-1bydi5r-0 hKfdXF]");



        }
    @Test
    public void pageScrollıng() throws InterruptedException {
        //2. sayfaya gitmek için sayfayı aşağı kaydırma(2.sayfa tıklanıcak link kadar aşağı in ve tıkla
        loginTest();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a"));
        js.executeScript("arguments[0].scrollIntoView();",Element );
        Thread.sleep(1000);
        steps.clickElement("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a");// 2. sayfaya gitmek için tıkla
        Thread.sleep(1000);
        driver.get("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2"); // 2. sayfaya git

    }
    @Test
    public void randomSelectAndSaveUnitPrice () throws InterruptedException {// rastgele ürün seç ve fiyat karşılaştırmak için kaydet
            loginTest();
        steps.randomClick("catalog-view clearfix products-container");
        steps.saveText("fiyat robotobold price-txt");

        Thread.sleep(1000);
    }
    @Test
    public void cartAdd () throws InterruptedException { //seçilenleri sepet ekle
        loginTest();
        steps.clickElement("button[add-to-basket]"); //sepete ekle
        steps.clickElement("button[gg-ui-btn-default padding-none]"); //sepete git buttonuna tıkla



    }
    @Test
    public void controlCartInsıdeProduct () throws InterruptedException { //sepet eklenen ürünleri kaydedilen fiyat doğrumu karşılaştır
        steps.changeControl();
        Thread.sleep(1000);

    }
    @Test
    public void cartDelete () throws InterruptedException {//sepet boşalt
        steps.clickElement("button[class='btn-delete btn-update-item']");

    }
    @Test
    public void cartControlForEmpty () throws InterruptedException { //sepet boş oldunu doğrula
        steps.getTextControlTest("div[class=header-cart-empty gg-d-24","checked.");
    }












}







