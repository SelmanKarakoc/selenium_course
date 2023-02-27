package day08_explicitlyWait_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test
    public void test(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSeti=driver.manage().getCookies();

        int sirano=1;
        for (Cookie each:cookieSeti
             ) {
            System.out.println(sirano+" - "+each );
            sirano++;

        }
        System.out.println("========================");

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        int actualCookiesSayisi=cookieSeti.size();

        Assert.assertTrue(actualCookiesSayisi>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedValue="USD";

        Assert.assertEquals(expectedValue,actualValue);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun
        //   ve sayfaya ekleyin

        Cookie benimCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(benimCookie);

        cookieSeti= driver.manage().getCookies();
        sirano=1;
        for (Cookie eachCookie:cookieSeti
        ) {
            System.out.println(sirano + "- " + eachCookie.toString());
            sirano++;
        }

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        actualValue=driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        expectedValue="cikolatali";
        Assert.assertEquals(expectedValue,actualValue);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        System.out.println("========================");

        // olmayan bir elemani test edemem
        // bunun yerine for-each Loop ile ele aldigimiz her cookie'yi kontrol edelim
        // ismi skin olan varsa test failed olsun

        cookieSeti=driver.manage().getCookies();

        for (Cookie each:cookieSeti
             ) {
            Assert.assertFalse(each.getName().equals("skin"));
        }

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        cookieSeti=driver.manage().getCookies();

        Assert.assertTrue(cookieSeti.size()==0);


    }
}
