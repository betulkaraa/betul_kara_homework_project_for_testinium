package MethodsAndCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Commands extends Methods//KOMUTLAR İÇİN METHOD CLASS MİRAS OLARAK ALINDI.
{
    //Burdaki yapılan tüm işlemlet methods sınıfını mirasa alınarak işlemler yapılması adına yazılmıştır.
    //Kullanıldıkları yeri isimlerine bakarak methods sınıfında kolayca bulunması adına benzer isimlendirme sağlandı.
    public void clickElement(String key) throws InterruptedException {
        WebElement element = findElement(key);
        clickToElement(element);
    }

    public void sendKeysToElementTest(String key, String text) throws InterruptedException {
        WebElement element = findElement(key);
        sendKeysToElement(element, text);
    }
    public void randomClick(String key) throws InterruptedException {
        List<WebElement> elements = findElements(key);
        clickToElement(elements.get(randomInt()));

    }
    public void saveText(String key) {
        WebElement element = findElement(key);
        saveStaticString(element);

    }
    public void getTextControlTest(String key, String text) throws InterruptedException {
        WebElement element = findElement(key);
        getTextControl(element, text);
    }
    public void getAttributeControlTest(String key, String text) throws InterruptedException {
        WebElement element = findElement(key);
        getAttributeControl(element, text);
    }

    public void textControlTest(String key) throws InterruptedException {
        WebElement element = findElement(key);
        textControl(element);
    }

    public void changeControl() throws InterruptedException {
        if (driver.findElements(By.cssSelector("div[class='cart-group-item product-item-box product" +
                "                        selected ']")).size() > 0) {
            textControlTest("div[class='total-price-box']"); // fiyatı kontrol et
            clickElement("button[class='gg-input gg-input-select ']"); //ürün adet arttır
            Thread.sleep(5000);
            getAttributeControlTest("input[class='amount']", "2"); //ürün adeti  kontrol et

        }
    }


}
