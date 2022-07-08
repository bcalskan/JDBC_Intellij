package Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Q6 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();

        // SORU1: Bölümler tablosunda yeni bir kayıt (80, 'ARGE', 'ISTANBUL')
        //int etkilenenSatirSayisi = st.executeUpdate("insert into bolumler values (80,'Arge', 'ISTANBUL')");

        // SORU2; Bölümler tablosuna birden fazla kayıt ekleyelim.
        // 1. yol

        /*
        String[] veri1 = {"insert into bolumler values (99, 'YEMEKHANE', 'ISTANBUL')",
                "insert into bolumler values (98, 'OFIS1', 'ANKARA')",
                "insert into bolumler values (97, 'OFIS2', 'TRABZON')"};
        int count = 0;
        for (String each : veri1) {
            count = count + st.executeUpdate(each);
        }
        System.out.println(count + " data eklendi");
        */

        // 2. yol
        String[] veri2 = {"insert into bolumler values (100, 'YEMEKHANE', 'ISTANBUL')",
                "insert into bolumler values (101, 'OFIS1', 'ANKARA')",
                "insert into bolumler values (102, 'OFIS2', 'TRABZON')"};
        for (String each : veri2) {
            st.addBatch(each);
        }
        st.executeBatch();
        System.out.println("Bir araya getirilen verilen database´e eklendi.");

        // SORU3; Bölümler tablosuna birden fazla kayıt ekleyelim.


    }
}
