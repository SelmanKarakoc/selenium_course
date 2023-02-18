package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C03_driverMethods {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        // amazon anasayfaya gidin
        driver.get("https://amazon.com");

        // gittiginiz sayfadaki title ve url'i yazdirin
        System.out.println("URL: "+driver.getCurrentUrl());
        System.out.println("Baslik: "+driver.getTitle());

        // amazon anasayfaya gittiginizi test edin

        // Test expected result ile actual result'in karsilastirilmasidir
        // ornegin url amazon iceriyorsa diyebiliriz

        String expectedIcerik="amazon";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){//amazon anasayfaya gittiysek
            System.out.println("Test PASSED");
        }else//gidemediysek
            System.out.println("Test FAILED");







        driver.close();
    }
}
