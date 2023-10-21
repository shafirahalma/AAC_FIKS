package connect;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author shafira halmahera
 */
public class koneksi {

    private static Connection mysqlkonek;
    public static Connection  koneksiDB;

    public static void main(String[] args) throws SQLException {
        koneksiDB();
    }

    public static Connection koneksiDB() throws SQLException {
        if (mysqlkonek == null) {
            try {
                String url = "jdbc:mysql://localhost/loginprojek"; // alamat local host
                String user = "root"; // user database
                String pass = ""; // password database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkonek = (Connection) DriverManager.getConnection(url, user, pass);
//                JOptionPane.showMessageDialog(null, "Koneksi Sukses"); 
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal");
            }
        }
        return mysqlkonek; 
    }
}
