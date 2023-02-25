package day07_actionsClass_fileTestleri;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilePath {

    @Test
    public void test01() {
        // bilgisayarimizin temel dosya yolu user.home

        // /Users/ahmetbulutluoz/Desktop/Thedelta.docx
        //C:\Users\FURKAN\Desktop\TheDelta.docx"
        //C:\Users\Lenovo\Desktop\TheDelta.docx

        // /Users/ahmetbulutluoz/Downloads

        // icinde bulundugumuz projenin temel dosya yolu user.dir
        //    /Users/ahmetbulutluoz/IdeaProjects/seleniumTeam108
        //C:\Users\şeyma\OneDrive\Masaüstü\gitHubTeam108\selenium\src\test\java\day07_actionsClass_fileTestleri\text.txt

        //C:\Users\şeyma\OneDrive\Masaüstü\Tyt konular.xlsx
    String dosyaYolu="C:\\Users\\şeyma\\OneDrive\\Masaüstü\\Tytkonular.xlsx";

    boolean sonuc= Files.exists(Paths.get(dosyaYolu));
        System.out.println(sonuc);
        /*
            Bilgisayarimizda bir dosyanin var oldugunu test etmek icin
            dosya yoluna ihtiyacimiz var
            Ancak herkesin bilgisayarindaki dosya yollari
            farkliliklar gosterir
            herkesin bilgisayarina gore farkli olan kismi
            java'dan bir komut ile elde edebiliriz
         */

        //C:\Users\şeyma\Downloads

        System.out.println(System.getProperty("user.home"));

        dosyaYolu="C:\\Users\\şeyma\\OneDrive\\Masaüstü\\Tytkonular.xlsx";
        dosyaYolu=System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\Tytkonular.xlsx";

        System.out.println(System.getProperty("user.dir"));

    }
}