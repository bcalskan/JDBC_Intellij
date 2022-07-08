package Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Q7_DifferenceBetweenStatementAndPreparedStatement {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "1234");

        //STATEMENT, PREPAREDSTATEMENT FARKI
        //Statement st = con.createStatement();
        //st.executeUpdate("insert into ogrenciler values (200, 'Ali Can', 10, 'E')");

        //PREPAREDSTATEMENT:
        PreparedStatement ps = con.prepareStatement("insert into ogrenciler values (?, ?, ?, ?)");
        // insert edilecek degerler/veriler yerine ? koyulur
        ps.setInt(1,201);
        ps.setString(2,"Veli Can");
        ps.setString( 3,"12");
        ps.setString(4,"E");
        // PreaparedStatement ile ekleme yapilirken olusturulan obje üzerinden
        // obje.setInt / obj.setString gibi type isimleri kullanilarak ekleme yapilir

        ps.executeUpdate(); // update islemini bitirmek icin
    }
}
