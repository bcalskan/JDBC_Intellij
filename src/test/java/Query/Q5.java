package Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Q5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();

        //SORU: Isciler adinda bir tablo olustur. id int, birim VARCHAR(10), maas int

        String sorgu = "create table isciler1(id int, birim varchar(10), maas int);";
        st.execute(sorgu);
        System.out.println("isciler1 Schema wurde erstellt");

        //st.execute() --> tablo olusturmada kullanilir

        //SORU: Isciler tablosunu sil

        /*
        st.execute("drop table isciler1");
        */

        //SORU: Isciler tablosunda soyisim varchar(20), sehir varchar(10) adinda 2 sütun ekleyin
        st.execute("alter table isciler1 add soyisim varchar(20);");
        st.execute("alter table isciler1 add sehir varchar(10););");
        System.out.println("2 Säulen wurden hinzugefügt");

        //SORU: Isciler tablosundaki sehir sütunun ismini ülke olarak degistirin
        st.execute("alter table isciler1 rename column sehir to ulke");

        //SORU: Tablonun ismini employee olarak degistirin
        st.execute("alter table isciler1 rename to employee;");

        //SORU: Ulke sütunun data türünü char(30) yapin
        st.execute("alter table emplooye modify ulke char(30);");


    }
}
