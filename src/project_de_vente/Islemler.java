package project_de_vente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Islemler {
    Scanner scan=new Scanner(System.in);
    Map<Integer,Urun>urunler=new HashMap<>();

    ArrayList<String>sepet=new ArrayList<>();

    double tutar=0;

    void urunlisteleme(Map<Integer,Urun>urunler) {
        System.out.println("Urun listesi: ");
        for (Map.Entry<Integer,Urun>entry:urunler.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue().getUrunAdi()+" "+entry.getValue().getUrunFiyati());
        }
    }



    void odeme() {

        System.out.println("Odemeniz gereken tutar: "+ tutar);
        double nakit=0;

        do {
            System.out.println("Nakit girisi yapiniz");
            nakit+=scan.nextDouble();

            if (tutar>nakit){
                System.out.println("Yetersiz nakit girisi");
                System.out.println(tutar-nakit + " kadar daha nakit girmelisiniz");
            }
        }while (tutar>nakit);


        if (tutar==nakit){
            System.out.println("Tam para ödendi, yine bekleriz");
            System.exit(0);
        }else {
            System.out.println("Paraüstü hazirlaniyor");
            double paraustu=nakit-tutar;
            System.out.println(paraustu +" lira paraüstü veriliyor");
            System.exit(0);

        }



    }

    void sepetiGoruntuleme() {
        for (String sepettekiurun:sepet) {
            System.out.println(sepettekiurun);
        }
    }

    void alisveris() {

        try {
            System.out.println("Satin almak istediginiz kurabiyenin kodunu yaziniz");
            int kod= scan.nextInt();
            System.out.println("Satin almak istediginiz miktari kilo cinsinden yaziniz");
            double miktar=scan.nextDouble();

            System.out.println("urun kodu "+kod+ "olan "+urunler.get(kod).getUrunAdi()+"  den"+ miktar+" kilo aliyorsunuz");
            tutar+=miktar*urunler.get(kod).getUrunFiyati();

            String sepeturunu="urun kodu "+kod+ "olan "+urunler.get(kod).getUrunAdi()+"  den"+ miktar+" kilo sepette bekliyor";
            sepet.add(sepeturunu);

        }catch (NullPointerException e){
            System.out.println("Hatali kod girdiniz, tekrar deneyiniz");
            alisveris();

        }

        System.out.println("Baska bir urun almak ister misiniz?(E/H olarak yaziniz");
        String devam=scan.next();
        if (devam.equalsIgnoreCase("H")){
            System.out.println("baska urun alinmiyor");
        }else {
            alisveris();
        }

    }

}
