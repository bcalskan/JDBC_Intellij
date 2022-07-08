package Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Q8 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();

        // SORU1: Urunler adında bir tablo olusturalım (id int, isim varchar(10), fiyat int)
        st.execute("create table yeniUrunler(id int, isim varchar(10), fiyat int);");

        // SORU2: urunler tablosuna aşağıdaki verileri toplu bir şekilde etkileyin
        // Çok miktarda kayıt eklemek için PreparedStatement metodu kullanılır.
        // 1) Veri girişine uygun bir POJO (Plain Old Java Object) class oluşturulur
        // 2) POJO class ta nesneleri saklayacak bir collection oluşturulur
        // 3) Bir döngü ile kayıtlar eklenir.


        List<Urun> kayitlar = new ArrayList<>();
        kayitlar.add(new Urun(101, "Laptop", 6500));
        kayitlar.add(new Urun(102, "PC", 4500));
        kayitlar.add(new Urun(103, "Telefon", 4500));
        kayitlar.add(new Urun(104, "Anakart", 1500));
        kayitlar.add(new Urun(105, "Klavye", 200));
        kayitlar.add(new Urun(106, "Fare", 100));

        PreparedStatement ps = con.prepareStatement("insert into urunler values (?,?,?);");
        for (Urun each:kayitlar) {
        ps.setInt(1,each.getId());
        ps.setString(2, each.getIsim());
        ps.setDouble(3,each.getFiyat());
        }
        ps.addBatch();
        System.out.println("Veriler Database'e eklendi");

        con.close();
        st.close();
        ps.close();

    }
}
