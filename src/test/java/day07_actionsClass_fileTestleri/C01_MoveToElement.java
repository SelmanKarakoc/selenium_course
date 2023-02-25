package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_MoveToElement extends TestBase {

    @Test
    public void test(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //   mouse’u bu menunun ustune getirin
        WebElement accountListElementi=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountListElementi).perform();

        //3- “Create a list” butonuna basin
        driver.findElement(By.linkText("Create a List")).click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String expectedYazi="Your Lists";
        String actualYazi=driver.findElement(By.xpath("//div[@role='heading']")).getText();

        Assert.assertEquals(expectedYazi,actualYazi);











    }

}
