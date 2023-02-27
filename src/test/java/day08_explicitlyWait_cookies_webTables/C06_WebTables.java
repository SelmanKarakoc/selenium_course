package day08_explicitlyWait_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C06_WebTables extends TestBase {

    @Test
    public void test(){
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> headers=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));

        int siraNo=1;
        for (WebElement eachElement:headers
             ) {
            System.out.println(siraNo+" - "+eachElement.getText());
            siraNo++;
        }
        //  3. 3.sutunun basligini yazdirin
        System.out.println("3. sütunun başlığı: "+
                driver.findElement(By.xpath("(//div[@class='rt-resizable-header-content'])[3]")).getText());
        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> allDatas=driver.findElements(By.xpath("//div[@class='rt-table']"));

        siraNo=1;
        for (WebElement eachData:allDatas
             ) {
            System.out.println(siraNo+" - "+eachData.getText());
            siraNo++;
        }

        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("Data sayisi: "+driver.findElement(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td']")).getSize());

        //  6. Tablodaki satir sayisini yazdirin
        System.out.println("Satir sayisi: "+driver.findElements(By.xpath("//div[@class='rt-tr-group']")).size());

        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("Sütun sayisi: "+driver.findElements(By.xpath("//div[@class='rt-tr']/*")).size());

        //  8. Tablodaki 3.kolonu yazdirin
        System.out.println("=======3.sütun=======");
        System.out.println(driver.findElement(By.xpath("(//div[@style='flex: 40 0 auto; width: 40px; max-width: 40px;'])[2]")).getText());
        System.out.println(driver.findElement(By.xpath("(//div[@style='flex: 40 0 auto; width: 40px; max-width: 40px;'])[3]")).getText());
        System.out.println(driver.findElement(By.xpath("(//div[@style='flex: 40 0 auto; width: 40px; max-width: 40px;'])[2]")).getText());
        System.out.println("=====================");

        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        System.out.println(driver.findElement(By.xpath("//div[text()='2000']")).getText());

        // 10. Bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde
        //     bana datayi yazdirsin

        dataBul(3,4);

        //(//div[@class='rt-tr-group'])[2]//div[@class='rt-td']







    }
    public void dataBul(int satir, int sutun){

        String databul=driver.findElement(By.xpath("(//div[@class='rt-tr-group'])["+satir+"]//div[@class='rt-td']["+sutun+"]")).getText();
        System.out.println("Bulunan Data: "+databul);




    }

}
