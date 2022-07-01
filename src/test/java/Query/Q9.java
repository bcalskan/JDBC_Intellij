package Query;

import java.util.ArrayList;
import java.util.List;

public class Q9 {
    public static void main(String[] args) {
        //SORU: urunler tablosuna asagidaki verileri toplu bir sekilde ekleyin
        List<Urun> kayitlar = new ArrayList<>();
        kayitlar.add(new Urun(200, "Asus", 7500));
        kayitlar.add(new Urun(201, "HP", 8500));
        kayitlar.add(new Urun(202, "Acer", 9500));
        kayitlar.add(new Urun(203, "Monster", 11500));
        kayitlar.add(new Urun(204, "Klavye", 1200));
        kayitlar.add(new Urun(205, "Fare", 1000));
    }
}
