/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import config.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author RHYZONE
 */
public class Admin {
    //definisi atribut
    public String username, password;
    private Koneksi obj = new Koneksi();
    
    //fungsi untuk melakukan verifikasi login admin
    public ArrayList verifikasi() {
        ArrayList arr = new ArrayList();
        try
        {
            obj.bukaKoneksi();
            String str = "SELECT * FROM admin WHERE username = ? AND password = ?";
            PreparedStatement pr = obj.con.prepareStatement(str);
            pr.setString(1, username);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();  
            while(rs.next()) {
                arr.add(rs.getString(1));
                arr.add(rs.getString(2));
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return arr;
    }
    
    public void ubahPassword() {
         try
        {
            obj.bukaKoneksi();
            String sql = "update admin set "
                    + "password=? "
                    + "where username=?";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1, password);
            pr.setString(2, "administrator");
            int i = pr.executeUpdate();
            if(i > 0) {
                System.out.println("Ubah Password Sukses");
            }
            else {
                System.out.println("Ubah Password Gagal");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
