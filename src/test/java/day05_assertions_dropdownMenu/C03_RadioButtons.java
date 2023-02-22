package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButtons {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //	a. Verilen web sayfasına gidin.
    //	     https://facebook.com
    //	b. Cookies’i kabul edin
    //	c. Create an account buton’una basin
    //	d. Radio button elementlerini locate edin ve size uygun olani secin
    //  e. Sectiginiz radio butoon'un secili, otekilerin ise secili olmadigini test edin

    WebDriver driver;
@Before
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

}
@After
    public void teardown(){
    driver.close();
}
@Test
    public void test01(){

    //	a. Verilen web sayfasına gidin.
    //	     https://facebook.com
    driver.get("https://facebook.com");
    //	b. Cookies’i kabul edin
    //	c. Create an account buton’una basin
    driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
    //	d. Radio button elementlerini locate edin ve size uygun olani secin
    WebElement kadinbutonu= driver.findElement(By.xpath("//input[@value='1']"));
    WebElement erkekbutonu=driver.findElement(By.xpath("//input[@value='2']"));
    WebElement ozelbutonu=driver.findElement(By.xpath("//input[@value='-1']"));

    erkekbutonu.click();
    //  e. Sectiginiz radio butoon'un secili, otekilerin ise secili olmadigini test edin
    Assert.assertTrue(erkekbutonu.isSelected());
    Assert.assertFalse(kadinbutonu.isSelected());
    Assert.assertFalse(ozelbutonu.isSelected());
}
}
