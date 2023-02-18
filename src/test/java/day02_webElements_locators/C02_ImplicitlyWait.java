package day02_webElements_locators;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ImplicitlyWait {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /*
            driver'i bir web uygulamasina gonderdigimizde
            o sayfanin acilmasi,
            orada istedigimiz islemleri yapmak icin elementleri bulmasi... gibi islemler
            zaman gerektirebilir
            implicitlyWait bu tür zaman isteyen islemler icin
            driver'in max. ne kadar bekleyecegini belirler
         */



    }
}
