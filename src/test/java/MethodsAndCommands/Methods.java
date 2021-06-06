package MethodsAndCommands;

import Base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static java.lang.Thread.*;

public class Methods extends Base //MAİN CLASS MİRAS OLARAK ALINDI.
{

    public static String text = ""; //alınıcak element yolları için
    WebDriver driver;

    public void clickToElement(WebElement element) throws InterruptedException { //tıklama

        scrollToElement(element);
        sleep(5000);
        element.click();
    }


    public void scrollToElement(WebElement element) { // kaydırma
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center',})", element);
    }
    public void sendKeysToElement(WebElement element, String text) throws InterruptedException { //istenen yere değer yazırma

        scrollToElement(element);
        sleep(5000);
        element.sendKeys(text);
    }

     //getTextElement,getAttributeElement,getTextControl,getAttributeControl,textControl methodları ile istenen yerde kontrol işelemleri yapıldı.
    public String getTextElement(WebElement element) throws InterruptedException {
        scrollToElement(element);
        Thread.sleep(5000);
        String elemaninTexti = "";
        elemaninTexti = element.getText();
        return elemaninTexti;
    }

    public String getAttributeElement(WebElement element) throws InterruptedException {
        scrollToElement(element);
        Thread.sleep(5000);
        String elemaninAttribute = "";
        elemaninAttribute = element.getAttribute("value");
        return elemaninAttribute;
    }

    public void getTextControl(WebElement element, String key) throws InterruptedException {
        Assert.assertEquals("NULL VALUE", getTextElement(element), key);
    }

    public void getAttributeControl(WebElement element, String key) throws InterruptedException {
        Assert.assertEquals("NULL VALUE", getAttributeElement(element), key);
    }

    public void textControl(WebElement element) throws InterruptedException {
        Assert.assertTrue("NULL VALUE", getTextElement(element).contains(text));
    }

    public void saveStaticString(WebElement element) { //Okunan veri kaydedilmesi
        text = element.getText();

    }
    public List<WebElement> findElements(String key) { //arama
        try {
            WebDriverWait waitForFormLabel = new WebDriverWait(driver, 30);
            List<WebElement> elements = driver.findElements(By.cssSelector(key));
            waitForFormLabel.until(ExpectedConditions.visibilityOfAllElements(elements));
            return elements;

        } catch (Exception ex) {
            Assert.fail("" + key + "NULL VALUE");
            return null;
        }
    }

    public int randomInt() {
        //Erişilen sayfada 1-48 (belirtilen değer gittigidiyor sitesinde listelenen ürünlerin sayfadaki adetidir) arasından rastgele seç
        Random r = new Random();
        int low = 1;
        int high = 48;
        int result = r.nextInt(high - low) + low;
        return result;
    }
    public void SelectMethod(String key, String text) { //seçme işlemi
        Select element = new Select(findElement(key));
        element.selectByVisibleText(text);
    }
    public WebElement findElement(String key) { //arama
        try {
            WebElement element = (new WebDriverWait(driver, 5, 300))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector(key)));
            return element;

        } catch (Exception ex) {
            Assert.fail("" + key + "NULL VALUE");
            return null;
        }
    }

}