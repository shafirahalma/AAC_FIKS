package aac;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProgramKursus {

    private String ProgramKursus;
    private String Biaya;
    private String MasaAktif;

    Database Db = new Database();
  

    ProgramKursus(String ProgramKursus, String Biaya, String MasaAktif) {
        setProgramKursus(ProgramKursus);
        setBiaya(Biaya);
        setMasaAktif(MasaAktif);

    }

    public void setProgramKursus(String ProgramKursus) {
        this.ProgramKursus = ProgramKursus;
    }

    public String getProgramKursus() {
        return ProgramKursus;
    }

    public void setBiaya(String Biaya) {
        this.Biaya = Biaya;
    }

    public String getBiaya() {
        return Biaya;
    }

    public void setMasaAktif(String MasaAktif) {
        this.MasaAktif = MasaAktif;
    }

    public String getMasaAktif() {
        return MasaAktif;
    }

    public void insert() throws SQLException {
        try {
            Db.insert(getProgramKursus(), getBiaya(), getMasaAktif());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void delete() {
        Db.delete(getProgramKursus(), getBiaya(), getMasaAktif());
    }

    public void update() {
        Db.update(getProgramKursus(),getBiaya(), getMasaAktif());
    }
}
