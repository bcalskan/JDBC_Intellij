package Query;

import java.sql.*;

public class Q4_ResultSetMetaData {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();
        PreparedStatement ps = con.prepareStatement("select * from ogrenciler");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        //ResultSetMetaData daha detayli bilgi almak icin.

        System.out.println("1. sütunun ismi : " + rsmd.getColumnName(1));
        System.out.println("2. sütunun ismi : " + rsmd.getColumnName(2));
        System.out.println("3. sütunun ismi : " + rsmd.getColumnName(3));

        System.out.println("Toplam sütun sayisi : " + rsmd.getColumnCount());

        System.out.println("1.sütunun data türü : " + rsmd.getColumnTypeName(1));
        System.out.println("2.sütunun data türü : " + rsmd.getColumnTypeName(2));

        System.out.println("Tablo ismi : " + rsmd.getTableName(1));

    }
}
