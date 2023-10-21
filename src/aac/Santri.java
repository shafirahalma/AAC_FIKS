package aac;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Santri extends Insan { 

    private String Id_Santri;
    private String Id_Mualim;
    private String Program;
    private String JadwalHari;
    
    

    Insan i = new Insan();
    Database Db = new Database();

    Santri(String Id_Santri, String Nama, String TTL, String Pendidikan, String Alamat,
           String Id_Mualim, String JadwalHari, String Program) {
        setId_Santri(Id_Santri);
        setNama(Nama);
        setTTL(TTL);
        setPendidikan(Pendidikan);
        setAlamat(Alamat);
        setId_Mualim(Id_Mualim);
        setJadwalHari(JadwalHari);
        setProgram(Program);
        setStatus("Santri");
    }

    public void setId_Santri(String Id_Santri) {
        this.Id_Santri = Id_Santri;
    }

    public String getId_Santri() {
        return Id_Santri;
    }

    public void setId_Mualim(String Id_Mualim) {
        this.Id_Mualim = Id_Mualim;
    }

    public String getId_Mualim() {
        return Id_Mualim;
    }

    public void setProgram(String Program) {
        this.Program = Program;
    }

    public String getProgram() {
        return Program;
    }

    public void setJadwalHari(String JadwalHari) {
        this.JadwalHari = JadwalHari;
    }

    public String getJadwalHari() {
        return JadwalHari;
    }
    
    @Override
    public void insert() {
        try {
            Db.insert(getId_Santri(), getNama(), getTTL(), getPendidikan(), getAlamat(), getId_Mualim(),
                    getJadwalHari(), getProgram());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void delete() {
        Db.delete(getId_Santri(), getNama(), getTTL(), getPendidikan(), getAlamat(), getId_Mualim(),
                getJadwalHari(), getProgram(), getStatus(), "", "", "", "", "", "");
    }

    @Override
    public void update() {
        Db.update(getId_Santri(), getNama(), getTTL(), getPendidikan(), getAlamat(), getId_Mualim(),
                getJadwalHari(), getProgram());
    }
}

