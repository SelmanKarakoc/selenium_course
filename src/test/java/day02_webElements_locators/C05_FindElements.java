package day02_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_FindElements {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusuna java yazip aratin
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Java"+ Keys.ENTER);
        //aramakutusu.submit();

        // arama sonuclarinda cikan resimlerdeki yazilari yazdirin
        //birden fazla olacağı için
        List<WebElement> aramaSonuclariElementList= driver.findElements(By.className("sg-col-inner"));
        System.out.println(aramaSonuclariElementList.size()); //82

        // bu 82 elementi yazdiralim
        int elementno=1;
        for (WebElement eachElement:aramaSonuclariElementList
             ) {
            System.out.println(elementno+" --- "+ eachElement.getText());
            elementno++;

        }

        Thread.sleep(3000);
        driver.close();
    }
}
