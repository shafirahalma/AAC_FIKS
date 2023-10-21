package aac;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Mualim extends Insan {
    private String Id_Mualim;
    
    Insan i = new Insan();
    Database Db = new Database();
    
    Mualim(String Id_Mualim, String Nama,String TTL, String Pendidikan,String Alamat ){
        setId_Mualim(Id_Mualim);
        setNama(Nama);
        setTTL(TTL);
        setPendidikan(Pendidikan);
        setAlamat(Alamat);
     
    }
    public void setId_Mualim(String Id_Mualim) {
        this.Id_Mualim = Id_Mualim;
    }

    public String getId_Mualim() {
        return Id_Mualim;
    }
    
    @Override
    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String getStatus() {
        return Status;
    }
    @Override
    public void insert() {
         try {
        Db.insert(getId_Mualim(), getNama(), getTTL(), getPendidikan(), getAlamat());
                } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @Override
    public void delete() {
        Db.delete(getId_Mualim(), getNama(), getTTL(), getPendidikan(), getAlamat());
    }
    @Override
    public void update() {
        Db.update(getId_Mualim(), getNama(), getTTL(), getPendidikan(), getAlamat());
            
    }
}
