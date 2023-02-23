package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C05_Actions extends TestBase {
    @Test
    public void test(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfaWHD=driver.getWindowHandle();
        //3- Cizili alan uzerinde sag click yapin
        Actions actions=new Actions(driver);
        WebElement sagTikElementi=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(sagTikElementi).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualText=driver.switchTo().alert().getText();
        String expectedText="You selected a context menu";

        Assert.assertEquals(expectedText,actualText);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim

        driver.findElement(By.linkText("Elemental Selenium")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> tumSayfaWHD=driver.getWindowHandles();
        String ikinciSayfaWHD="";

        for (String each:tumSayfaWHD
             ) {
            if (!each.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=each;
            }

        }
        driver.switchTo().window(ikinciSayfaWHD);
        String expectedYazi="Elemental Selenium";
        String actualYazi=driver.findElement(By.xpath("//h1")).getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        bekle(3);


    }
}
