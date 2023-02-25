package day07_actionsClass_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyboardActions extends TestBase {
    @Test
    public void test(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement adYazmaElementi= driver.findElement(By.xpath("//input[@placeholder='Adın']"));
        Faker faker=new Faker();

        adYazmaElementi.click();
        adYazmaElementi.sendKeys(faker.name().firstName());
        String fakeEmail=faker.internet().emailAddress();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("20")
                .sendKeys(Keys.TAB)
                .sendKeys("Ocak")
                .sendKeys(Keys.TAB)
                .sendKeys("1998")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();




bekle(3);


    }
}
