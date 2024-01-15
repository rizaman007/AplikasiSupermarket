/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Pegawai;

/**
 *
 * @author RHYZONE
 */
public class FrmPegawai extends javax.swing.JFrame {
    Pegawai pegawai = new Pegawai();
    /**
     * Creates new form FrmPegawai
     */
    public FrmPegawai() {
        initComponents();
        this.setLocationRelativeTo(null);
        Date date = new Date();
        dt_lahir.setDate(date);
        bt_hapus.setEnabled(false);
        bt_ubah.setEnabled(false);
    }

    public FrmPegawai(String id) {
        initComponents();
        this.setLocationRelativeTo(null);
        bt_simpan.setEnabled(false);
        tx_kode.setEditable(false);
        this.cari(id);        
    }
    
    private void cari(String id)
    {
        try{
            pegawai.kode_pegawai = id;
            ArrayList data = pegawai.cari();
            tx_kode.setText((String)data.get(0));
            tx_nama.setText((String)data.get(1));
            tx_alamat.setText((String)data.get(2));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)data.get(3));
            dt_lahir.setDate(date);
            cb_kelamin.setSelectedItem((String)data.get(4));
            cb_posisi.setSelectedItem((String)data.get(5));
            
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan " + ex.getMessage());
        }
    }
    
    private void setData() {
        try {
            pegawai.kode_pegawai = tx_kode.getText();
            pegawai.nama_pegawai = tx_nama.getText();
            pegawai.alamat = tx_alamat.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            pegawai.tanggal_lahir = sdf.format(dt_lahir.getDate());
            pegawai.jenis_kelamin = cb_kelamin.getSelectedItem().toString();
            pegawai.posisi = cb_posisi.getSelectedItem().toString();
        }
        catch(Exception ex) {
            
        }
    }
    
    private void kosong() {
        tx_kode.setText("");
        tx_nama.setText("");
        tx_alamat.setText("");
        Date date = new Date();
        dt_lahir.setDate(date);
        cb_kelamin.setSelectedIndex(0);
        cb_posisi.setSelectedIndex(0);
    }
    
    private int validasi() {
        int hasil = 0;
        if(pegawai.kode_pegawai.equals("") || pegawai.nama_pegawai.equals("") || pegawai.alamat.equals("")) {
            hasil = 1;
        }   
        Date date = new Date();
        if(dt_lahir.getDate().after(date)) {
            hasil = 1;
        }
        return hasil;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        tx_kode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tx_nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tx_alamat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dt_lahir = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        cb_kelamin = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cb_posisi = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        bt_simpan = new javax.swing.JButton();
        bt_ubah = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("FORM PEGAWAI");

        jLabel2.setText("Kode Pegawai");

        jLabel3.setText("Nama");

        jLabel4.setText("Alamat");

        jLabel5.setText("Tanggal Lahir");

        jLabel6.setText("Jenis Kelamin");

        cb_kelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pria", "Wanita" }));

        jLabel7.setText("Posisi");

        cb_posisi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kasir", "Manajer" }));

        bt_simpan.setText("Simpan");
        bt_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_simpanActionPerformed(evt);
            }
        });

        bt_ubah.setText("Ubah");
        bt_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ubahActionPerformed(evt);
            }
        });

        bt_hapus.setText("Hapus");
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_posisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_kelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tx_kode)
                                        .addComponent(tx_nama)
                                        .addComponent(tx_alamat)
                                        .addComponent(dt_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_simpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_ubah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_hapus)))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tx_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tx_kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tx_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(dt_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_kelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(cb_posisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_simpan)
                    .addComponent(bt_ubah)
                    .addComponent(bt_hapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
        // TODO add your handling code here:
        this.setData();
        int hasil = this.validasi();
        if(hasil == 0) {
            int pilih = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menginput data ini?", "Pilih", JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION) {
                pegawai.input();
                JOptionPane.showMessageDialog(null, "Data berhasil diinput");
                this.kosong();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Data harap diisi dengan benar");
        }
    }//GEN-LAST:event_bt_simpanActionPerformed

    private void bt_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ubahActionPerformed
        // TODO add your handling code here:
        this.setData();
        int hasil = this.validasi();
        if(hasil == 0) {
            int pilih = JOptionPane.showConfirmDialog(null, "Anda yakin ingin mengubah data ini?", "Pilih", JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION) {
                pegawai.edit();
                JOptionPane.showMessageDialog(null, "Data berhasil diubah");
                this.kosong();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Data harap diisi dengan benar");
        }
    }//GEN-LAST:event_bt_ubahActionPerformed

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
        // TODO add your handling code here:
        this.setData();
        int hasil = this.validasi();
        if(hasil == 0) {
            int pilih = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?", "Pilih", JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION) {
                pegawai.hapus();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                this.kosong();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Data harap diisi dengan benar");
        }
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        FrmDaftarPegawai obj = new FrmDaftarPegawai();
        obj.show();
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(FrmPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JButton bt_ubah;
    private javax.swing.JComboBox cb_kelamin;
    private javax.swing.JComboBox cb_posisi;
    private com.toedter.calendar.JDateChooser dt_lahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField tx_alamat;
    private javax.swing.JTextField tx_kode;
    private javax.swing.JTextField tx_nama;
    // End of variables declaration//GEN-END:variables
}
