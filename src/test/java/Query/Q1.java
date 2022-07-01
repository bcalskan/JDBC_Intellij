package Query;

import java.sql.*;

public class Q1 {
    //1) Driver Yükle
    //2) Baglanti olustur
    //3) Statement : SQL kodlarimizi yazmak icin bir nesne olustur
    //4) ResultSet :
    //5) sonuclari al
    //6) kapatma
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1) Driver Yükle
        Class.forName("com.mysql.jdbc.Driver");

        //2) Baglanti olustur
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "1234");

        //3) Statement : SQL kodlarimizi yazmak icin bir nesne olustur
        Statement st = con.createStatement();

        //4) ResultSet :
        ResultSet rs = st.executeQuery("select * from manav");

        //5) sonuclari al
        while (rs.next()) {
            System.out.printf("%-8s %-8s %-2d\n", rs.getString(1), rs.getString(2), rs.getInt(3));
        }

        //6) kapatma
        con.close();
        st.close();
        rs.close();

    }
}
