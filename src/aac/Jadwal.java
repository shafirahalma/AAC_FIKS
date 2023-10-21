package aac;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Jadwal {

    private String Id_Santri;
    private String Wihdah;
    private String Hari;
    private String Ruang;

    Database Db = new Database();

    Jadwal(String Id_Santri, String Wihdah, String Hari, String Ruang) {
        setId_Santri(Id_Santri);
        setWihdah(Wihdah);
        setHari(Hari);
        setRuang(Ruang);

    }
    public void setId_Santri(String Id_Santri) {
        this.Id_Santri = Id_Santri;
    }

    public String getId_Santri() {
        return Id_Santri;
    }

    public void setWihdah(String Wihdah) {
        this.Wihdah = Wihdah;
    }

    public String getWihdah() {
        return Wihdah;
    }

    public void setRuang(String Ruang) {
        this.Ruang = Ruang;
    }

    public String getRuang() {
        return Ruang;
    }

    public void setHari(String Hari) {
        this.Hari = Hari;
    }

    public String getHari() {
        return Hari;
    }

    public void insert() {
        try {
            Db.insert(getId_Santri(), getWihdah(), getHari(), getRuang());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void delete() {
        Db.delete(getId_Santri(), getWihdah(), getHari(), getRuang());
    }

    public void update() {
        Db.update(getId_Santri(), getWihdah(),getHari(), getRuang());
    }

}
