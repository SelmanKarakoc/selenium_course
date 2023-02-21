package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_ilkAssertion {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin
    //   farkli test method’lari olusturarak asagidaki testleri yapin
    //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //		○ logoTest => BestBuy logosunun görüntülendigini test edin
    //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;
@BeforeClass
    public static void BestBuyAssertions(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.get("https://www.bestbuy.com/");
}
@AfterClass
    public static void teardown(){
    driver.close();
}
@Test
    public void test01(){
    String expectedURL="https://www.bestbuy.com/";
    String actualURL=driver.getCurrentUrl();
    Assert.assertEquals(expectedURL,actualURL);
}
@Test
    public void test02(){
    String expectedTitle="Rest";
    Assert.assertFalse(driver.getTitle().contains(expectedTitle));
}
@Test
    public void test03(){
    Assert.assertTrue(driver.findElement(By.xpath("//img[@class='logo']")).isDisplayed());
}
@Test
    public void test04(){
    Assert.assertTrue(driver.findElement(By.xpath("//button[@lang='fr']")).isDisplayed());
}

}
