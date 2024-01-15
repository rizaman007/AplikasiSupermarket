/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form;

/**
 *
 * @author RHYZONE
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Akun;
import model.Pegawai;

public class FrmAkun extends javax.swing.JFrame {
    Akun akun = new Akun();
    /**
     * Creates new form FrmAkun
     */
    public FrmAkun() {
        initComponents();
        this.setLocationRelativeTo(null);
        bt_hapus.setEnabled(false);
        bt_ubah.setEnabled(false);
        this.tampilKode();
    }
    
    public FrmAkun(String id) {
        initComponents();
        this.setLocationRelativeTo(null);
        bt_simpan.setEnabled(false);
        tx_username.setEditable(false);
        this.tampilKode();
        this.cari(id);        
    }
    
    private void tampilKode() {
        Pegawai obj = new Pegawai();
        ArrayList data = obj.tampil();
        for(int i = 0; i < data.size() - 1; i+=6) {
            cb_kode.addItem(data.get(i));
        }
    }
    
    private void cari(String id)
    {
        try{
            akun.username = id;
            ArrayList data = akun.cari();
            tx_username.setText((String)data.get(0));
            tx_password.setText((String)data.get(1));
            tx_confirm.setText((String)data.get(1));
            cb_level.setSelectedItem((String)data.get(2));
            cb_kode.setSelectedItem((String)data.get(3));
            
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan " + ex.getMessage());
        }
    }
    
    private void setData() {
        try {
            akun.username = tx_username.getText();
            akun.password = tx_password.getText();
            akun.level = cb_level.getSelectedItem().toString();
            akun.kode_pegawai = cb_kode.getSelectedItem().toString();
        }
        catch(Exception ex) {
            
        }
    }
    
    private void kosong() {
        tx_username.setText("");
        tx_password.setText("");
        tx_confirm.setText("");
        cb_level.setSelectedIndex(0);
        cb_kode.setSelectedIndex(0);
    }
    
    private int validasi() {
        int hasil = 0;
        if(akun.username.equals("") || akun.password.equals("")) {
            hasil = 1;
        }   
        if(!tx_password.getText().equals(tx_confirm.getText())) {
            hasil = 1;
            JOptionPane.showMessageDialog(null, "Password dan Confirm Password tidak sama");
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
        tx_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tx_password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        tx_confirm = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        cb_level = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cb_kode = new javax.swing.JComboBox();
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

        jLabel1.setText("FORM AKUN");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel4.setText("Confirm Password");

        jLabel5.setText("Level");

        cb_level.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Kasir", "Manajer" }));

        jLabel6.setText("Kode Pegawai");

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
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tx_username)
                            .addComponent(tx_password)
                            .addComponent(tx_confirm)
                            .addComponent(cb_level, 0, 269, Short.MAX_VALUE)
                            .addComponent(cb_kode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_hapus)
                        .addGap(0, 181, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tx_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tx_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tx_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cb_kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
        // TODO add your handling code here:
        this.setData();
        int hasil = this.validasi();
        if(hasil == 0) {
            int pilih = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?", "Pilih", JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION) {
                akun.hapus();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                this.kosong();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Data harap diisi dengan benar");
        }
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_simpanActionPerformed
        // TODO add your handling code here:
        this.setData();
        int hasil = this.validasi();
        if(hasil == 0) {
            int pilih = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menginput data ini?", "Pilih", JOptionPane.YES_NO_OPTION);
            if(pilih == JOptionPane.YES_OPTION) {
                akun.input();
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
                akun.edit();
                JOptionPane.showMessageDialog(null, "Data berhasil diubah");
                this.kosong();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Data harap diisi dengan benar");
        }
    }//GEN-LAST:event_bt_ubahActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        FrmDaftarAkun obj = new FrmDaftarAkun();
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
            java.util.logging.Logger.getLogger(FrmAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAkun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JButton bt_ubah;
    private javax.swing.JComboBox cb_kode;
    private javax.swing.JComboBox cb_level;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField tx_confirm;
    private javax.swing.JPasswordField tx_password;
    private javax.swing.JTextField tx_username;
    // End of variables declaration//GEN-END:variables
}
