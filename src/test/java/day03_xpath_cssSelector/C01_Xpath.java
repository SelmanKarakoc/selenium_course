package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {
        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu=driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        if (deleteButonu.isDisplayed()) {
            System.out.println("DeleteButonu Test is PASSED");
        }else System.out.println("DeleteButonu Test is FAILED");

        //4- Delete tusuna basin
        deleteButonu.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElementi= driver.findElement(By.xpath("//h3"));
        if (addRemoveElementi.isDisplayed()) {
            System.out.println("AddRemove Yazısı Test is PASSED");
        }else System.out.println("AddRemove Yazsısı Test is FAILED");



        Thread.sleep(3000);
        driver.close();
    }
}
