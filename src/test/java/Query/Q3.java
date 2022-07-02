package Query;

import java.sql.*;

public class Q3 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();

        // SORU1: Bölümler tablosundan tüm kayıtları listeleyiniz.
        ResultSet rs = st.executeQuery("select * from bolumler");
        while (rs.next()) {
            System.out.printf("%-8d %-8s %-8s\n",rs.getInt(1), rs.getString(2),rs.getString(3));
        }

        ResultSet rs2 = st.executeQuery("select * from calisanlar");
        while (rs2.next()) {
            System.out.printf("%-8d %-8s %-8s %-8d %-8s\n",rs2.getInt(1), rs2.getString(2),rs2.getString(3), rs2.getInt(4),rs2.getString(5));
        }

        // SORU2: SATIS ve MUHASEBE bolumlerinde calişan personelin isimlerini ve maaşlarını,
        // maaş ters sıralı listeleyiniz.

        ResultSet rs3 = st.executeQuery("select personel_isim, maas from personel " +
                "where bolum_id in(10,30) " +
                "order by maas desc;");

        while (rs3.next()){
            System.out.printf("%-15.15s %-6d\n",
                    rs3.getString(1),
                    rs3.getInt(2));
        }

        // SORU3: Tüm bölümlerde çalışan personel isimlerini, bölüm isimlerini ve maaşlarını,
        // bölüm ve maas sıralı listeleyiniz.
        // NOT: Çalışanı olamasa bile bölüm ismi gösterilmelidir.
        ResultSet veri3 = st.executeQuery("select bolum_isim, personel_isim, maas " +
                "from bolumler as B left join personel as p on B.bolum_id = P.bolum_id " +
                "order by bolum_isim desc, P.maas;");

        while (veri3.next()){
            //System.out.println(veri3.getString(1) + veri3.getString(2) + veri3.getInt(3));

            System.out.printf("%-10s %-10s %6d\n",veri3.getString(1),veri3.getString(2),veri3.getInt(3));
        }

        // SORU4: Maaşı en yüksek 10 kişinin bolümünü, adını ve maaşını listeleyiniz.
        ResultSet veri4 = st.executeQuery("select p.personel_isim, b.bolum_isim, p.maas " +
                "from bolumler b left join personel p on b.bolum_id=p.bolum_id order by maas " +
                "desc limit 10");

        while (veri4.next()){

            System.out.printf("%-10s %-10s %6d\n", veri4.getString(1), veri4.getString(2), veri4.getInt(3));


        }



        /*
        10       MUHASEBE IST
        20       MUDURLUK ANKARA
        30       SATIS    IZMIR
        40       ISLETME  BURSA
        50       DEPO     YOZGAT


        123456789 Ali Seker     Istanbul 2500     Vakko
        234567890 Ayse Gul      Istanbul 1500     LCWaikiki
        345678901 Veli Yilmaz   Ankara   3000     Vakko
        456789012 Veli Yilmaz   Izmir    1000     Pierre Cardin
        567890123 Veli Yilmaz   Ankara   7000     Adidas
        456789012 Ayse Gul      Ankara   1500     Pierre Cardin
        123456710 Fatma Yasa    Bursa    2500     Vakko

Process finished with exit code 0

         */

    }
}
