package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_DinamikDosyaYolu {

    @Test
    public void test(){

// Masaustumuzde Tytkonular.xlsx isimli bir dosya bulundugunu test edin

        String dosyaYolu=System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\Tytkonular.xlsx";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
