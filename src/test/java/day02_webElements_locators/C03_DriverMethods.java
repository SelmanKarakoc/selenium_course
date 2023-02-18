package day02_webElements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverMethods {
    public static void main(String[] args) {
        //Yeni bir class olusturalim (Homework)
        //ChromeDriver kullanarak, facebook sayfasina gidin
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.facebook.com");

        // ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
        // degilse dogru basligi yazdirin.
        String expectedTitle="facebook";
        String actualTitle= driver.getTitle();

        if (expectedTitle.equalsIgnoreCase(actualTitle)){
            System.out.println("Facebook title Test is PASSED");
        }else System.out.println("Facebook title Test is FAILED"+"Doğru title= "+actualTitle);

        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin,
        // icermiyorsa “actual” URL’i yazdirin.

        String expectedURL="facebook";
        String actualURL=driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)){
            System.out.println("Facebook URL Test is PASSED");
        }else System.out.println("Facebook URL Test is FAILED"+"\n Actual URL: "+actualURL);

        // https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com");

        // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String walmartExpectedTitle="Walmart.com";
        String walmartActualTitle= driver.getTitle();

        if (walmartActualTitle.contains(walmartExpectedTitle)){
            System.out.println("Walmart title Test is PASSED");
        }else System.out.println("Walmart title Test is FAILED");

        // Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        // Sayfayi yenileyin
        driver.navigate().refresh();

        //Browser’i  kapatin
        driver.close();



    }
}
