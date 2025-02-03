package project_de_vente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Giris extends Islemler{
    Scanner scan=new Scanner(System.in);
    void menu(){
        Urun urun1=new Urun("Portakalli Kurabiye",10);
        Urun urun2=new Urun("Tarcinli Kurabiye",20);
        Urun urun3=new Urun("Elmali Kurabiye",15);
        Urun urun4=new Urun("Uzumlu Kurabiye",12);
        Urun urun5=new Urun("Cikolatali Kurabiye",30);
        Urun urun6=new Urun("Kavala Kurabiye",35);

        urunler.put(10001,urun1);
        urunler.put(10002,urun2);
        urunler.put(10003,urun3);
        urunler.put(10004,urun4);
        urunler.put(10005,urun5);
        urunler.put(10006,urun6);

        System.out.println("***************T148 KURABIYE DUKKANINA HOSGELDINIZ*******************");
        System.out.println("Yapmak istediginiz islemin numarasini yaziniz"+
                "1.URUN LISTELEME\n"+
                "2.ALISVERIS\n"+
                "3.SEPETI GÖRÜNTÜLEME\n"+
                "4.ODEME\n"+
                "CIKIS ICIN Q YA BASINIZ\n"+
                "SECIMINIZ: ");

        int secim= scan.nextInt();

        try {

            switch (secim){
                case 1:{
                    urunlisteleme(urunler);
                    menu();
                } case 2:{
                    alisveris();
                    menu();
                } case 3:{
                    sepetiGoruntuleme();
                    menu();
                } case 4:{
                    odeme();
                    menu();
                } default: {
                    System.out.println("Hatali islem yaptiniz");
                    menu();
                }
            }


        }catch (InputMismatchException e){
            if (scan.next().equalsIgnoreCase("q")){
                System.out.println("Sistemden cikiliyor, bizi tercih ettiginiz icin tesekkür ederiz");
                System.exit(0);
            }else {
                System.out.println("hatali giris yaptiniz");
                menu();
            }
        }






    }
}
