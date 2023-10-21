package aac;

import connect.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shafira halmahera
 */
public class FRAMEMAIN extends javax.swing.JFrame {

    // Reset 
    void kosongkanform() {

        // Santri 
        txt_idsantri.setText(null);
        txt_nama.setText(null);
        txt_ttl.setText(null);
        txt_pendidikan.setText(null);
        txt_alamat.setText(null);
        cmb_idmualim.setSelectedItem(null);
        txt_jadwalhari.setText(null);
        cmb_programcourse.setSelectedItem(null);

        // Mualim
        txt_idmualim.setText(null);
        txt_namamualim.setText(null);
        txt_ttlmualim.setText(null);
        cmb_pendidikan.setSelectedItem(null);
        txt_alamatmualim.setText(null);

        // Program
        cmb_program.setSelectedItem(null);
        cmb_biaya.setSelectedItem(null);
        cmb_masaAktif.setSelectedItem(null);

        // Jadwal
        cmb_idsantrijadwal.setSelectedItem(null);
        cmb_wihdahjadwal.setSelectedItem(null);
        cmb_harijadwal.setSelectedItem(null);
        cmb_ruangjadwal.setSelectedItem(null);

    }

    private DefaultTableModel model;
    public static Statement stm;
    public static ResultSet res;
    public static ResultSet data1 = null;

    // tampil data Santri
    private void tampildata() {

        String cari = txt_carisantri.getText();

        try {
            Object[] judul_kolom = {"id_Santri", "Nama", "ttl", "Pendidikan", "Alamat", "Id_Mualim", "JadwalHari", "Program"};
            model = new DefaultTableModel(null, judul_kolom);
            tbl_santri.setModel(model);

            Connection conn = (Connection) connect.koneksi.koneksiDB();
            Statement stt = conn.createStatement();
            model.getDataVector().removeAllElements();

            data1 = stt.executeQuery("SELECT * from santri WHERE nama LIKE '%" + cari + "%' or ttl LIKE '%" + cari + "%' or pendidikan LIKE"
                    + "'%" + cari + "%' or alamat LIKE '%" + cari + "%' or id_mualim LIKE '%" + cari + "%' or jadwal_hari LIKE '%" + cari + "%'"
                    + " or program LIKE '%" + cari + "%'");
            while (data1.next()) {
                Object[] data = {
                    data1.getString("id_Santri"),
                    data1.getString("Nama"),
                    data1.getString("ttl"),
                    data1.getString("Pendidikan"),
                    data1.getString("Alamat"),
                    data1.getString("Id_Mualim"),
                    data1.getString("jadwal_hari"),
                    data1.getString("Program"),};
                model.addRow(data);
            }
        } catch (Exception ex) {
            System.err.println("tampil data:" + ex.getMessage());
        }
    }

    // tampil data Mualim
    public void tampildata1() {

        String cari = txt_carimualim.getText();

        try {
            Object[] judul_kolom = {"id_mualim", "nama", "ttl", "pendidikan", "alamat"};
            model = new DefaultTableModel(null, judul_kolom);
            tbl_mualim.setModel(model);

            Connection conn = (Connection) connect.koneksi.koneksiDB();
            Statement stt = conn.createStatement();
            model.getDataVector().removeAllElements();

            data1 = stt.executeQuery("SELECT * from mualim WHERE id_mualim LIKE '%" + cari + "%' or nama LIKE  '%" + cari + "%'"
                    + " or ttl LIKE '%" + cari + "%' or pendidikan LIKE  '%" + cari + "%' or alamat LIKE '%" + cari + "%' ");
            while (data1.next()) {
                Object[] data = {
                    data1.getString("id_mualim"),
                    data1.getString("nama"),
                    data1.getString("ttl"),
                    data1.getString("pendidikan"),
                    data1.getString("alamat"),};
                model.addRow(data);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    // tampil data Program
    private void tampildata3() {
        try {
            Object[] judul_kolom = {"programkursus", "biaya", "masaaktif"};
            model = new DefaultTableModel(null, judul_kolom);
            tbl_programkursus.setModel(model);

            Connection conn = (Connection) connect.koneksi.koneksiDB();
            Statement stt = conn.createStatement();
            model.getDataVector().removeAllElements();

            data1 = stt.executeQuery("SELECT * from program");
            while (data1.next()) {
                Object[] data = {
                    data1.getString("program_kursus"),
                    data1.getString("biaya"),
                    data1.getString("masa_aktif"),};

                model.addRow(data);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    // tampil data Jadwal
    private void tampildata2() {
        try {
            Object[] judul_kolom = {"id_santri", "wihdah", "hari", "ruang"};
            model = new DefaultTableModel(null, judul_kolom);
            tbl_jadwal.setModel(model);

            Connection conn = (Connection) connect.koneksi.koneksiDB();
            Statement stt = conn.createStatement();
            model.getDataVector().removeAllElements();

            data1 = stt.executeQuery("SELECT * from jadwal");
            while (data1.next()) {
                Object[] data = {
                    data1.getString("id_santri"),
                    data1.getString("wihdah"),
                    data1.getString("hari"),
                    data1.getString("ruang"),};

                model.addRow(data);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Creates new form FRAMEMAIN
     */
    public FRAMEMAIN() {
        initComponents();
        tampildata();
        tampildata1();
        tampildata2();
        tampildata3();
        kosongkanform();

        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(santriPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyPanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        programPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbl_program = new javax.swing.JLabel();
        lbl_biaya = new javax.swing.JLabel();
        lbl_masaaktif = new javax.swing.JLabel();
        cmb_program = new javax.swing.JComboBox<>();
        cmb_biaya = new javax.swing.JComboBox<>();
        btn_saveprogram = new javax.swing.JButton();
        btn_deleteprogram = new javax.swing.JButton();
        btn_updateprogram = new javax.swing.JButton();
        btn_resetprogram = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_programkursus = new javax.swing.JTable();
        cmb_masaAktif = new javax.swing.JComboBox<>();
        jadwalPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbl_idsantrijadwal = new javax.swing.JLabel();
        lbl_wihdahjadwal = new javax.swing.JLabel();
        lbl_harijadwal = new javax.swing.JLabel();
        lbl_ruang = new javax.swing.JLabel();
        cmb_idsantrijadwal = new javax.swing.JComboBox<>();
        cmb_wihdahjadwal = new javax.swing.JComboBox<>();
        cmb_harijadwal = new javax.swing.JComboBox<>();
        cmb_ruangjadwal = new javax.swing.JComboBox<>();
        btn_savejadwal = new javax.swing.JButton();
        btn_deletejadwal = new javax.swing.JButton();
        btn_updatejadwal = new javax.swing.JButton();
        btn_resetjadwal = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_jadwal = new javax.swing.JTable();
        santriPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lb_idsantri = new javax.swing.JLabel();
        lb_nama = new javax.swing.JLabel();
        lb_ttl = new javax.swing.JLabel();
        lb_pendidikan = new javax.swing.JLabel();
        lb_alamat = new javax.swing.JLabel();
        lb_idmualim = new javax.swing.JLabel();
        lb_jadwalhari = new javax.swing.JLabel();
        lb_programcourse = new javax.swing.JLabel();
        txt_idsantri = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_ttl = new javax.swing.JTextField();
        txt_pendidikan = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        cmb_idmualim = new javax.swing.JComboBox<>();
        txt_jadwalhari = new javax.swing.JTextField();
        cmb_programcourse = new javax.swing.JComboBox<>();
        btn_saveSantri = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        lbl_cari = new javax.swing.JLabel();
        txt_carisantri = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_santri = new javax.swing.JTable();
        mualimPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbl_idmualim = new javax.swing.JLabel();
        lbl_nama = new javax.swing.JLabel();
        lbl_ttl = new javax.swing.JLabel();
        lbl_pendidikan = new javax.swing.JLabel();
        lbl_alamat = new javax.swing.JLabel();
        txt_idmualim = new javax.swing.JTextField();
        txt_namamualim = new javax.swing.JTextField();
        txt_ttlmualim = new javax.swing.JTextField();
        cmb_pendidikan = new javax.swing.JComboBox<>();
        txt_alamatmualim = new javax.swing.JTextField();
        btn_savemualim = new javax.swing.JButton();
        btn_deletemualim = new javax.swing.JButton();
        btn_updatemualim = new javax.swing.JButton();
        btn_resetmualim = new javax.swing.JButton();
        lbl_carimualim = new javax.swing.JLabel();
        txt_carimualim = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_mualim = new javax.swing.JTable();
        menuPanel = new javax.swing.JPanel();
        btnSantri = new javax.swing.JButton();
        btnMualim = new javax.swing.JButton();
        btnProgram = new javax.swing.JButton();
        btnJadwal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AL FIKRI ARABIC COURSE");

        bodyPanel.setBackground(new java.awt.Color(0, 153, 153));

        mainPanel.setBackground(new java.awt.Color(0, 153, 153));
        mainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        mainPanel.setLayout(new java.awt.CardLayout());

        programPanel.setBackground(new java.awt.Color(0, 204, 204));

        jLabel6.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel6.setText("PROGRAM COURSE");

        lbl_program.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_program.setText("Program");

        lbl_biaya.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_biaya.setText("Biaya");

        lbl_masaaktif.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_masaaktif.setText("Masa Aktif");

        cmb_program.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Intensif", "Reguler", "Basic" }));
        cmb_program.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_programActionPerformed(evt);
            }
        });

        cmb_biaya.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rp. 1000.000", "Rp. 500.000", "Rp. 300.000 " }));
        cmb_biaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_biayaActionPerformed(evt);
            }
        });

        btn_saveprogram.setBackground(new java.awt.Color(255, 255, 255));
        btn_saveprogram.setText("SAVE");
        btn_saveprogram.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_saveprogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveprogramActionPerformed(evt);
            }
        });

        btn_deleteprogram.setBackground(new java.awt.Color(255, 255, 255));
        btn_deleteprogram.setText("DELETE");
        btn_deleteprogram.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_deleteprogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteprogramActionPerformed(evt);
            }
        });

        btn_updateprogram.setBackground(new java.awt.Color(255, 255, 255));
        btn_updateprogram.setText("UPDATE");
        btn_updateprogram.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_updateprogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateprogramActionPerformed(evt);
            }
        });

        btn_resetprogram.setBackground(new java.awt.Color(255, 255, 255));
        btn_resetprogram.setText("RESET");
        btn_resetprogram.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_resetprogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetprogramActionPerformed(evt);
            }
        });

        tbl_programkursus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Program", "Biaya", "Masa Aktif"
            }
        ));
        tbl_programkursus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_programkursusMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_programkursus);

        cmb_masaAktif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Tahun", "6 Bulan ", "3 Bulan " }));
        cmb_masaAktif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_masaAktifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout programPanelLayout = new javax.swing.GroupLayout(programPanel);
        programPanel.setLayout(programPanelLayout);
        programPanelLayout.setHorizontalGroup(
            programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(programPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(programPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_program)
                            .addComponent(lbl_biaya)
                            .addComponent(lbl_masaaktif))
                        .addGap(24, 24, 24)
                        .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_masaAktif, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_biaya, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_program, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95)
                        .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_updateprogram, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(btn_saveprogram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_deleteprogram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_resetprogram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, programPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(229, 229, 229))
        );
        programPanelLayout.setVerticalGroup(
            programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(programPanelLayout.createSequentialGroup()
                .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(programPanelLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_program, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_program)))
                    .addGroup(programPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, programPanelLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(btn_saveprogram, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(programPanelLayout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_biaya, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_biaya))
                        .addGap(4, 4, 4))
                    .addGroup(programPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_deleteprogram, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, programPanelLayout.createSequentialGroup()
                        .addComponent(btn_updateprogram, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_resetprogram, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(programPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(programPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_masaAktif, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_masaaktif))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        mainPanel.add(programPanel, "card4");

        jadwalPanel.setBackground(new java.awt.Color(153, 153, 153));

        jLabel7.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel7.setText("JADWAL COURSE");

        lbl_idsantrijadwal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_idsantrijadwal.setText("id_Santri");

        lbl_wihdahjadwal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_wihdahjadwal.setText("Wihdah");

        lbl_harijadwal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_harijadwal.setText("Hari");

        lbl_ruang.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_ruang.setText("Ruang");

        cmb_idsantrijadwal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cmb_idsantrijadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_idsantrijadwalActionPerformed(evt);
            }
        });

        cmb_wihdahjadwal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mufrodat (kosakata)", "Kalam (speaking)", "Qiroah (membaca)", "Istima (mendengarkan)", "Kitabah (menulis)", " " }));
        cmb_wihdahjadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_wihdahjadwalActionPerformed(evt);
            }
        });

        cmb_harijadwal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" }));

        cmb_ruangjadwal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E" }));

        btn_savejadwal.setBackground(new java.awt.Color(255, 255, 255));
        btn_savejadwal.setText("SAVE");
        btn_savejadwal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_savejadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_savejadwalActionPerformed(evt);
            }
        });

        btn_deletejadwal.setBackground(new java.awt.Color(255, 255, 255));
        btn_deletejadwal.setText("DELETE");
        btn_deletejadwal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_deletejadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletejadwalActionPerformed(evt);
            }
        });

        btn_updatejadwal.setBackground(new java.awt.Color(255, 255, 255));
        btn_updatejadwal.setText("UPDATE");
        btn_updatejadwal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_updatejadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updatejadwalActionPerformed(evt);
            }
        });

        btn_resetjadwal.setBackground(new java.awt.Color(255, 255, 255));
        btn_resetjadwal.setText("RESET");
        btn_resetjadwal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_resetjadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetjadwalActionPerformed(evt);
            }
        });

        tbl_jadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id_Santri", "Wihdah", "Hari", "Ruang "
            }
        ));
        tbl_jadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_jadwalMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_jadwal);

        javax.swing.GroupLayout jadwalPanelLayout = new javax.swing.GroupLayout(jadwalPanel);
        jadwalPanel.setLayout(jadwalPanelLayout);
        jadwalPanelLayout.setHorizontalGroup(
            jadwalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jadwalPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jadwalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_ruang)
                    .addComponent(lbl_wihdahjadwal)
                    .addComponent(lbl_idsantrijadwal)
                    .addComponent(lbl_harijadwal))
                .addGap(49, 49, 49)
                .addGroup(jadwalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_ruangjadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_idsantrijadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_harijadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_wihdahjadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(jadwalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_savejadwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_deletejadwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_updatejadwal, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(btn_resetjadwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(88, 88, 88))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jadwalPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jadwalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jadwalPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(241, 241, 241))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jadwalPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        jadwalPanelLayout.setVerticalGroup(
            jadwalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jadwalPanelLayout.createSequentialGroup()
                .addGroup(jadwalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jadwalPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(42, 42, 42)
                        .addGroup(jadwalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_idsantrijadwal)
                            .addComponent(cmb_idsantrijadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jadwalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_wihdahjadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_wihdahjadwal)))
                    .addGroup(jadwalPanelLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btn_savejadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_deletejadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jadwalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_updatejadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_harijadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_harijadwal))
                        .addGap(18, 18, 18)
                        .addGroup(jadwalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_resetjadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_ruangjadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ruang))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        mainPanel.add(jadwalPanel, "card5");

        santriPanel.setBackground(new java.awt.Color(0, 255, 204));

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel4.setText("DATA SANTRI ARABIC COURSE");

        lb_idsantri.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lb_idsantri.setText("id_Santri");

        lb_nama.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lb_nama.setText("Nama");

        lb_ttl.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lb_ttl.setText("TTL");

        lb_pendidikan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lb_pendidikan.setText("Pendidikan");

        lb_alamat.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lb_alamat.setText("Alamat");

        lb_idmualim.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lb_idmualim.setText("id_Mualim");

        lb_jadwalhari.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lb_jadwalhari.setText("Jadwal Hari");

        lb_programcourse.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lb_programcourse.setText("Program Course");

        txt_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaActionPerformed(evt);
            }
        });

        txt_alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alamatActionPerformed(evt);
            }
        });

        cmb_idmualim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", " " }));

        cmb_programcourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Intensif", "Reguler", "Basic" }));
        cmb_programcourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_programcourseActionPerformed(evt);
            }
        });

        btn_saveSantri.setBackground(new java.awt.Color(255, 255, 255));
        btn_saveSantri.setText("SAVE");
        btn_saveSantri.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_saveSantri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveSantriActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(255, 255, 255));
        btn_update.setText("UPADATE");
        btn_update.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("DELETE");
        btn_delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_reset.setBackground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("RESET");
        btn_reset.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        lbl_cari.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_cari.setText("Cari");

        txt_carisantri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_carisantriActionPerformed(evt);
            }
        });
        txt_carisantri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_carisantriKeyReleased(evt);
            }
        });

        tbl_santri.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_santri.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        tbl_santri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, "", null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_SANTRI", "NAMA", "TTL", "PENDIDIKAN", "ALAMAT", "ID_MUALIM", "JADWAL HARI ", "PROGRAM"
            }
        ));
        tbl_santri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_santriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_santri);

        javax.swing.GroupLayout santriPanelLayout = new javax.swing.GroupLayout(santriPanel);
        santriPanel.setLayout(santriPanelLayout);
        santriPanelLayout.setHorizontalGroup(
            santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(santriPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_idsantri, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ttl, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_pendidikan)
                    .addComponent(lb_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_idmualim)
                    .addComponent(lb_jadwalhari)
                    .addComponent(lb_programcourse))
                .addGap(44, 44, 44)
                .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nama)
                    .addComponent(txt_idsantri)
                    .addComponent(txt_ttl)
                    .addComponent(txt_pendidikan)
                    .addComponent(txt_alamat)
                    .addComponent(cmb_idmualim, 0, 312, Short.MAX_VALUE)
                    .addComponent(txt_jadwalhari)
                    .addComponent(cmb_programcourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(btn_saveSantri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
            .addGroup(santriPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(santriPanelLayout.createSequentialGroup()
                        .addGap(0, 483, Short.MAX_VALUE)
                        .addComponent(lbl_cari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_carisantri, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, santriPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(207, 207, 207))
        );
        santriPanelLayout.setVerticalGroup(
            santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(santriPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(santriPanelLayout.createSequentialGroup()
                        .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, santriPanelLayout.createSequentialGroup()
                                .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_idsantri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_idsantri, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_nama)
                                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, santriPanelLayout.createSequentialGroup()
                                .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_ttl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_ttl))
                                .addGap(17, 17, 17)))
                        .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_pendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_pendidikan)))
                    .addGroup(santriPanelLayout.createSequentialGroup()
                        .addComponent(btn_saveSantri, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(santriPanelLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lb_idmualim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_jadwalhari, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(santriPanelLayout.createSequentialGroup()
                        .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(santriPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_alamat))
                                .addGap(18, 18, 18)
                                .addComponent(cmb_idmualim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(santriPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_jadwalhari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_programcourse)
                    .addComponent(cmb_programcourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(santriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_carisantri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(santriPanel, "card2");

        mualimPanel.setBackground(new java.awt.Color(255, 153, 51));

        jLabel5.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel5.setText("DATA MUALIM/MUALIMAH");

        lbl_idmualim.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_idmualim.setText("id_Mualim");

        lbl_nama.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_nama.setText("Nama");

        lbl_ttl.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_ttl.setText("TTL");

        lbl_pendidikan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_pendidikan.setText("Pendidikan");

        lbl_alamat.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_alamat.setText("Alamat");

        txt_ttlmualim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ttlmualimActionPerformed(evt);
            }
        });

        cmb_pendidikan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sarjana Bahasa Arab S.Pd.", "Sarjana Sastra Arab S.S", "Magister Pendidikan Bahasa Arab M.Pd.", "Magister Pendidikan Agama Islam M.Pd. " }));

        txt_alamatmualim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alamatmualimActionPerformed(evt);
            }
        });

        btn_savemualim.setBackground(new java.awt.Color(255, 255, 255));
        btn_savemualim.setText("SAVE");
        btn_savemualim.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_savemualim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_savemualimActionPerformed(evt);
            }
        });

        btn_deletemualim.setBackground(new java.awt.Color(255, 255, 255));
        btn_deletemualim.setText("DELETE");
        btn_deletemualim.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_deletemualim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletemualimActionPerformed(evt);
            }
        });

        btn_updatemualim.setBackground(new java.awt.Color(255, 255, 255));
        btn_updatemualim.setText("UPDATE");
        btn_updatemualim.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_updatemualim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updatemualimActionPerformed(evt);
            }
        });

        btn_resetmualim.setBackground(new java.awt.Color(255, 255, 255));
        btn_resetmualim.setText("RESET");
        btn_resetmualim.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btn_resetmualim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetmualimActionPerformed(evt);
            }
        });

        lbl_carimualim.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_carimualim.setText("Cari");

        txt_carimualim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_carimualimActionPerformed(evt);
            }
        });
        txt_carimualim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_carimualimKeyReleased(evt);
            }
        });

        tbl_mualim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_Mualim", "Nama", "TTL", "Pendidikan", "Alamat"
            }
        ));
        tbl_mualim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_mualimMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_mualim);

        javax.swing.GroupLayout mualimPanelLayout = new javax.swing.GroupLayout(mualimPanel);
        mualimPanel.setLayout(mualimPanelLayout);
        mualimPanelLayout.setHorizontalGroup(
            mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mualimPanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(mualimPanelLayout.createSequentialGroup()
                        .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(mualimPanelLayout.createSequentialGroup()
                                .addComponent(lbl_idmualim)
                                .addGap(49, 49, 49)
                                .addComponent(txt_idmualim, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mualimPanelLayout.createSequentialGroup()
                                .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nama)
                                    .addComponent(lbl_ttl)
                                    .addComponent(lbl_pendidikan)
                                    .addComponent(lbl_alamat))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_pendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_namamualim, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ttlmualim, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_alamatmualim, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(47, 47, 47)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_savemualim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_deletemualim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_updatemualim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(btn_resetmualim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73))
            .addGroup(mualimPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mualimPanelLayout.createSequentialGroup()
                        .addComponent(lbl_carimualim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_carimualim, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        mualimPanelLayout.setVerticalGroup(
            mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mualimPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mualimPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btn_savemualim, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mualimPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_idmualim, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_idmualim))))
                .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mualimPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_deletemualim, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btn_updatemualim, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_resetmualim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mualimPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_namamualim, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nama))
                        .addGap(26, 26, 26)
                        .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ttlmualim, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ttl))
                        .addGap(32, 32, 32)
                        .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_pendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_pendidikan))
                        .addGap(26, 26, 26)
                        .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_alamatmualim, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_alamat))))
                .addGap(30, 30, 30)
                .addGroup(mualimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_carimualim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_carimualim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        mainPanel.add(mualimPanel, "card3");

        menuPanel.setBackground(new java.awt.Color(0, 153, 153));
        menuPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        btnSantri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aac/IMG/btnsantri.png"))); // NOI18N
        btnSantri.setText("SANTRI");
        btnSantri.setIconTextGap(10);
        btnSantri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSantriActionPerformed(evt);
            }
        });

        btnMualim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aac/IMG/btnmualim.png"))); // NOI18N
        btnMualim.setText("MUALIM/AH");
        btnMualim.setIconTextGap(10);
        btnMualim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMualimActionPerformed(evt);
            }
        });

        btnProgram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aac/IMG/btnprogram.png"))); // NOI18N
        btnProgram.setText("PROGRAM");
        btnProgram.setIconTextGap(10);
        btnProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramActionPerformed(evt);
            }
        });

        btnJadwal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aac/IMG/btnjadwal.png"))); // NOI18N
        btnJadwal.setText("JADWAL");
        btnJadwal.setIconTextGap(10);
        btnJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AL FIKRI");

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ARABIC COURSE");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("مَنْ جَدَّ وَجَدَ");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aac/IMG/mainsantri.png"))); // NOI18N

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel9))
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2))
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnMualim, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSantri, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel1)))
                        .addGap(11, 11, 11)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(33, 33, 33))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnSantri, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMualim, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel9)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    Santri s;

    private void btnSantriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSantriActionPerformed
        // TODO add your handling code here:

        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(santriPanel);
        mainPanel.repaint();
        mainPanel.revalidate();

    }//GEN-LAST:event_btnSantriActionPerformed

    Mualim m;

    private void btnMualimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMualimActionPerformed
        // TODO add your handling code here:

        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(mualimPanel);
        mainPanel.repaint();
        mainPanel.revalidate();

    }//GEN-LAST:event_btnMualimActionPerformed

    ProgramKursus p;

    private void btnProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramActionPerformed
        // TODO add your handling code here:

        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(programPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnProgramActionPerformed

    Jadwal j;

    private void btnJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJadwalActionPerformed
        // TODO add your handling code here:

        //remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(jadwalPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnJadwalActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here: 

        int dialogBtn = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Anda yakin akan keluar?", "WARNING", dialogBtn);

        if (dialogResult == 0) {
            // true condition
            System.exit(0);
        } else {
            // false condition
        }

    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btn_saveSantriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveSantriActionPerformed
        // TODO add your handling code here:

        s = new Santri(txt_idsantri.getText(), txt_nama.getText(), txt_ttl.getText(), txt_pendidikan.getText(), txt_alamat.getText(),
                (String) cmb_idmualim.getSelectedItem(), txt_jadwalhari.getText(), (String) cmb_programcourse.getSelectedItem());
        s.insert();
        tampildata();
        kosongkanform();

    }//GEN-LAST:event_btn_saveSantriActionPerformed

    private void btn_updatemualimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updatemualimActionPerformed
        // TODO add your handling code here:

        try {
            String sql = "update mualim set nama = '" + txt_namamualim.getText() + "', ttl ='" + txt_ttlmualim.getText()
                    + "' ,pendidikan ='" + cmb_pendidikan.getSelectedItem() + "', alamat = '" + txt_alamatmualim.getText()
                    + "'where id_mualim = '" + txt_idmualim.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksiDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil di update");
            tampildata1();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btn_updatemualimActionPerformed

    private void btn_deleteprogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteprogramActionPerformed
        // TODO add your handling code here:

        try {
            String sql = "DELETE from program WHERE program_kursus = '" + cmb_program.getSelectedItem() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksiDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil di delete");
            tampildata3();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_deleteprogramActionPerformed

    private void btn_updateprogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateprogramActionPerformed
        // TODO add your handling code here:

        try {
            String sql = "update program set biaya ='" + cmb_biaya.getSelectedItem()
                    + "', masa_aktif ='" + cmb_masaAktif.getSelectedItem() + "'where program_kursus = '" + cmb_program.getSelectedItem() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksiDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil di update");
            tampildata3();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_updateprogramActionPerformed

    private void cmb_idsantrijadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_idsantrijadwalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_idsantrijadwalActionPerformed

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaActionPerformed

    private void txt_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alamatActionPerformed

    private void txt_carimualimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_carimualimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_carimualimActionPerformed

    private void btn_savemualimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_savemualimActionPerformed
        // TODO add your handling code here:

        m = new Mualim(txt_idmualim.getText(), txt_namamualim.getText(), txt_ttlmualim.getText(), (String) cmb_pendidikan.getSelectedItem(),
                txt_alamatmualim.getText());
        m.insert();
        tampildata1();
        kosongkanform();

    }//GEN-LAST:event_btn_savemualimActionPerformed

    private void btn_savejadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_savejadwalActionPerformed
        // TODO add your handling code here:

        j = new Jadwal((String) cmb_idsantrijadwal.getSelectedItem(), (String) cmb_wihdahjadwal.getSelectedItem(),
                (String) cmb_harijadwal.getSelectedItem(), (String) cmb_ruangjadwal.getSelectedItem());
        j.insert();
        tampildata2();
        kosongkanform();

    }//GEN-LAST:event_btn_savejadwalActionPerformed

    private void btn_deletejadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletejadwalActionPerformed
        // TODO add your handling code here:

        try {
            String sql = "DELETE from jadwal WHERE id_santri = '" + cmb_idsantrijadwal.getSelectedItem() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksiDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil di delete");
            tampildata2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }//GEN-LAST:event_btn_deletejadwalActionPerformed

    private void btn_updatejadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updatejadwalActionPerformed
        // TODO add your handling code here:

        try {
            String sql = "update jadwal set wihdah = '" + cmb_wihdahjadwal.getSelectedItem() + "', hari ='" + cmb_harijadwal.getSelectedItem()
                    + "' , ruang ='" + cmb_ruangjadwal.getSelectedItem() + "' where id_santri = '" + cmb_idsantrijadwal.getSelectedItem() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksiDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil di update");
            tampildata2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_updatejadwalActionPerformed

    private void btn_resetjadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetjadwalActionPerformed
        // TODO add your handling code here: 

        kosongkanform();
    }//GEN-LAST:event_btn_resetjadwalActionPerformed

    private void btn_saveprogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveprogramActionPerformed
        // TODO add your handling code here:

        p = new ProgramKursus((String) cmb_program.getSelectedItem(), (String) cmb_biaya.getSelectedItem(), (String) cmb_masaAktif.getSelectedItem());
        try {
            p.insert();
        } catch (SQLException ex) {
            Logger.getLogger(FRAMEMAIN.class.getName()).log(Level.SEVERE, null, ex);
        }

        tampildata3();
        kosongkanform();

    }//GEN-LAST:event_btn_saveprogramActionPerformed

    private void cmb_biayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_biayaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_biayaActionPerformed

    private void cmb_masaAktifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_masaAktifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_masaAktifActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:

        // Update Santri 
        try {
            String sql = "update santri set nama = '" + txt_nama.getText() + "', ttl ='" + txt_ttl.getText()
                    + "' , pendidikan ='" + txt_pendidikan.getText() + "', alamat = '" + txt_alamat.getText()
                    + "', id_mualim = '" + cmb_idmualim.getSelectedItem() + "' ,jadwal_hari = '" + txt_jadwalhari.getText()
                    + "', program = '" + cmb_programcourse.getSelectedItem() + "' where id_santri = '" + txt_idsantri.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksiDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil di update");
            tampildata();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btn_updateActionPerformed

    private void tbl_santriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_santriMouseClicked
        // TODO add your handling code here:

        // menampilkan di setiap text field tabel Santri 
        int baris = tbl_santri.rowAtPoint(evt.getPoint());

        String id_santri = tbl_santri.getValueAt(baris, 0).toString();
        txt_idsantri.setText(id_santri);

        String nama = tbl_santri.getValueAt(baris, 1).toString();
        txt_nama.setText(nama);

        String ttl = tbl_santri.getValueAt(baris, 2).toString();
        txt_ttl.setText(ttl);

        String pendidikan = tbl_santri.getValueAt(baris, 3).toString();
        txt_pendidikan.setText(pendidikan);

        String alamat = tbl_santri.getValueAt(baris, 4).toString();
        txt_alamat.setText(alamat);

        String id_mualim = tbl_santri.getValueAt(baris, 5).toString();
        cmb_idmualim.setSelectedItem(id_mualim);

        String jadwal_hari = tbl_santri.getValueAt(baris, 6).toString();
        txt_jadwalhari.setText(jadwal_hari);

        String programcourse = tbl_santri.getValueAt(baris, 7).toString();
        cmb_programcourse.setSelectedItem(programcourse);
    }//GEN-LAST:event_tbl_santriMouseClicked

    private void btn_deletemualimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletemualimActionPerformed
        // TODO add your handling code here:

        try {
            String sql = "DELETE from mualim WHERE id_mualim = '" + txt_idmualim.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksiDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil di delete");
            tampildata1();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }//GEN-LAST:event_btn_deletemualimActionPerformed

    private void tbl_mualimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_mualimMouseClicked
        // TODO add your handling code here:

        int baris = tbl_mualim.rowAtPoint(evt.getPoint());

        String id_mualim = tbl_mualim.getValueAt(baris, 0).toString();
        txt_idmualim.setText(id_mualim);

        String nama = tbl_mualim.getValueAt(baris, 1).toString();
        txt_namamualim.setText(nama);

        String ttl = tbl_mualim.getValueAt(baris, 2).toString();
        txt_ttlmualim.setText(ttl);

        String pendidikan = tbl_mualim.getValueAt(baris, 3).toString();
        cmb_pendidikan.setSelectedItem(pendidikan);

        String alamat = tbl_mualim.getValueAt(baris, 4).toString();
        txt_alamatmualim.setText(alamat);
    }//GEN-LAST:event_tbl_mualimMouseClicked

    private void txt_ttlmualimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ttlmualimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ttlmualimActionPerformed

    private void tbl_programkursusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_programkursusMouseClicked
        // TODO add your handling code here:

        int baris = tbl_programkursus.rowAtPoint(evt.getPoint());

        String program = tbl_programkursus.getValueAt(baris, 0).toString();
        cmb_program.setSelectedItem(program);

        String biaya = tbl_programkursus.getValueAt(baris, 1).toString();
        cmb_biaya.setSelectedItem(biaya);

        String masa_aktif = tbl_programkursus.getValueAt(baris, 2).toString();
        cmb_masaAktif.setSelectedItem(masa_aktif);
    }//GEN-LAST:event_tbl_programkursusMouseClicked

    private void txt_alamatmualimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alamatmualimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alamatmualimActionPerformed

    private void btn_resetprogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetprogramActionPerformed
        // TODO add your handling code here:

        kosongkanform();

    }//GEN-LAST:event_btn_resetprogramActionPerformed

    private void cmb_wihdahjadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_wihdahjadwalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_wihdahjadwalActionPerformed

    private void cmb_programActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_programActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_programActionPerformed

    private void btn_resetmualimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetmualimActionPerformed
        // TODO add your handling code here:

        kosongkanform();
    }//GEN-LAST:event_btn_resetmualimActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:

        // Delete Santri 
        try {
            String sql = "DELETE from santri WHERE id_santri = '" + txt_idsantri.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.koneksiDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil di delete");
            tampildata();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void txt_carisantriKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_carisantriKeyReleased
        // TODO add your handling code here:

        tampildata();
    }//GEN-LAST:event_txt_carisantriKeyReleased

    private void txt_carimualimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_carimualimKeyReleased
        // TODO add your handling code here:

        tampildata1();
    }//GEN-LAST:event_txt_carimualimKeyReleased

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:

        // Button Reset Santri
        kosongkanform();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void tbl_jadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_jadwalMouseClicked
        // TODO add your handling code here:

        int baris = tbl_jadwal.rowAtPoint(evt.getPoint());

        String id_santri = tbl_jadwal.getValueAt(baris, 0).toString();
        cmb_idsantrijadwal.setSelectedItem(id_santri);

        String wihdah = tbl_jadwal.getValueAt(baris, 1).toString();
        cmb_wihdahjadwal.setSelectedItem(wihdah);

        String hari = tbl_jadwal.getValueAt(baris, 2).toString();
        cmb_harijadwal.setSelectedItem(hari);

        String ruang = tbl_jadwal.getValueAt(baris, 3).toString();
        cmb_ruangjadwal.setSelectedItem(ruang);
    }//GEN-LAST:event_tbl_jadwalMouseClicked

    private void cmb_programcourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_programcourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_programcourseActionPerformed

    private void txt_carisantriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_carisantriActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_txt_carisantriActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRAMEMAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRAMEMAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRAMEMAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRAMEMAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRAMEMAIN().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton btnJadwal;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMualim;
    private javax.swing.JButton btnProgram;
    private javax.swing.JButton btnSantri;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_deletejadwal;
    private javax.swing.JButton btn_deletemualim;
    private javax.swing.JButton btn_deleteprogram;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_resetjadwal;
    private javax.swing.JButton btn_resetmualim;
    private javax.swing.JButton btn_resetprogram;
    private javax.swing.JButton btn_saveSantri;
    private javax.swing.JButton btn_savejadwal;
    private javax.swing.JButton btn_savemualim;
    private javax.swing.JButton btn_saveprogram;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_updatejadwal;
    private javax.swing.JButton btn_updatemualim;
    private javax.swing.JButton btn_updateprogram;
    private javax.swing.JComboBox<String> cmb_biaya;
    private javax.swing.JComboBox<String> cmb_harijadwal;
    private javax.swing.JComboBox<String> cmb_idmualim;
    private javax.swing.JComboBox<String> cmb_idsantrijadwal;
    private javax.swing.JComboBox<String> cmb_masaAktif;
    private javax.swing.JComboBox<String> cmb_pendidikan;
    private javax.swing.JComboBox<String> cmb_program;
    private javax.swing.JComboBox<String> cmb_programcourse;
    private javax.swing.JComboBox<String> cmb_ruangjadwal;
    private javax.swing.JComboBox<String> cmb_wihdahjadwal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jadwalPanel;
    private javax.swing.JLabel lb_alamat;
    private javax.swing.JLabel lb_idmualim;
    private javax.swing.JLabel lb_idsantri;
    private javax.swing.JLabel lb_jadwalhari;
    private javax.swing.JLabel lb_nama;
    private javax.swing.JLabel lb_pendidikan;
    private javax.swing.JLabel lb_programcourse;
    private javax.swing.JLabel lb_ttl;
    private javax.swing.JLabel lbl_alamat;
    private javax.swing.JLabel lbl_biaya;
    private javax.swing.JLabel lbl_cari;
    private javax.swing.JLabel lbl_carimualim;
    private javax.swing.JLabel lbl_harijadwal;
    private javax.swing.JLabel lbl_idmualim;
    private javax.swing.JLabel lbl_idsantrijadwal;
    private javax.swing.JLabel lbl_masaaktif;
    private javax.swing.JLabel lbl_nama;
    private javax.swing.JLabel lbl_pendidikan;
    private javax.swing.JLabel lbl_program;
    private javax.swing.JLabel lbl_ruang;
    private javax.swing.JLabel lbl_ttl;
    private javax.swing.JLabel lbl_wihdahjadwal;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel mualimPanel;
    private javax.swing.JPanel programPanel;
    private javax.swing.JPanel santriPanel;
    private javax.swing.JTable tbl_jadwal;
    private javax.swing.JTable tbl_mualim;
    private javax.swing.JTable tbl_programkursus;
    private javax.swing.JTable tbl_santri;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_alamatmualim;
    private javax.swing.JTextField txt_carimualim;
    private javax.swing.JTextField txt_carisantri;
    private javax.swing.JTextField txt_idmualim;
    private javax.swing.JTextField txt_idsantri;
    private javax.swing.JTextField txt_jadwalhari;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_namamualim;
    private javax.swing.JTextField txt_pendidikan;
    private javax.swing.JTextField txt_ttl;
    private javax.swing.JTextField txt_ttlmualim;
    // End of variables declaration//GEN-END:variables
}
