package Query;

import javax.xml.transform.Result;
import java.sql.*;

public class Q2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();

        // SORU01: ÖĞRENCİLER TABLOSUNDAKİ ERKEK ÖĞRENCİ BİLGİLERİ GETİRİN

        ResultSet rs = st.executeQuery("select * from ogrenciler where cinsiyet = 'E'");
        while (rs.next()){
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        }

        //SORU02: ÖĞRENCİLER TABLOSUNDAKİ  9. SINIF KIZ ÖĞRENCİ BİLGİLERİ GETİRİN
        ResultSet rs2 = st.executeQuery("select * from ogrenciler where cinsiyet = 'K' and sinid =9");

    }
}
