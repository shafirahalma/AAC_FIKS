package aac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Database {

    // insert Santri
    void insert(String id_Santri, String nama, String ttl, String pendidikan, String alamat,
            String id_Mualim, String jadwalHari, String program) throws SQLException {

        try {
            String query = "insert into santri values('" + id_Santri + "','" + nama + "','" + ttl + "',"
                    + "'" + pendidikan + "','" + alamat + "','" + id_Mualim + "','" + jadwalHari + "','" + program + "')";

            java.sql.Connection koneksi = (Connection) connect.koneksi.koneksiDB();

            java.sql.PreparedStatement pst = koneksi.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // insert Mualim
    void insert(String Id_Mualim, String Nama, String TTL, String Pendidikan, String Alamat) throws SQLException {

        try {
            String query = "insert into mualim values('" + Id_Mualim + "','" + Nama + "','" + TTL + "',"
                    + "'" + Pendidikan + "','" + Alamat + "')";

            java.sql.Connection koneksi = (Connection) connect.koneksi.koneksiDB();

            java.sql.PreparedStatement pst = koneksi.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // insert Program
    void insert(String ProgramKursus,String Biaya, String MasaAktif) throws SQLException {

        try {
            String query = "insert into program values('" + ProgramKursus + "','" + Biaya + "',"
                    + "'" + MasaAktif + "')";

            java.sql.Connection koneksi = (Connection) connect.koneksi.koneksiDB();

            java.sql.PreparedStatement pst = koneksi.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // insert Jadwal
    void insert (String Id_Santri, String Wihdah, String Hari, String Ruang) throws SQLException {

        try { 
            String query = "insert into jadwal values('" + Id_Santri + "','" + Wihdah + "','" + Hari + "',"
                    + "'" + Ruang + "')";

            java.sql.Connection koneksi = (Connection) connect.koneksi.koneksiDB();

            java.sql.PreparedStatement pst = koneksi.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); 
        }
    }
    
    
    

    void delete(String programKursus, String biaya, String masaAktif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

    void delete(String id_Santri, String wihdah, String hari, String ruang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    void update(String id_Mualim, String nama, String ttl, String pendidikan, String alamat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void delete(String id_Santri, String nama, String ttl, String pendidikan, String alamat, String id_Mualim, String jadwalHari, String program, String status, String string, String string0, String string1, String string2, String string3, String string4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void update(String id_Santri, String nama, String ttl, String pendidikan, String alamat, String id_Mualim, String jadwalHari, String program) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void delete(String id_Mualim, String nama, String ttl, String pendidikan, String alamat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void update(String id_Santri, String wihdah, String hari, String ruang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void update(String programKursus, String biaya, String masaAktif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


