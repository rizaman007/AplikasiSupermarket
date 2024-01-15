/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author RHYZONE
 */
import config.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Akun {
    public String username, password, level, kode_pegawai;
    private Koneksi obj = new Koneksi();
    
    public void input() {
        try
        {
            obj.bukaKoneksi();
            String sql = "insert into akun(username, password, level, kode_pegawai) "
                    + "values(?, ?, ?, ?)";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1,username);
            pr.setString(2, password);
            pr.setString(3, level);
	    pr.setString(4, kode_pegawai);

            int i = pr.executeUpdate();
            if(i > 0) {
                System.out.println("Input Sukses");
            }
            else {
                System.out.println("Input Gagal");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void hapus() {
         try
        {
            obj.bukaKoneksi();
            String sql = "delete from akun where username = ?";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1,username);

            int i = pr.executeUpdate();
            if(i > 0) {
                System.out.println("Hapus Sukses");
            }
            else {
                System.out.println("Hapus Gagal");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void edit() {
         try
        {
            obj.bukaKoneksi();
              String sql = "update akun set "
                    + "password=?,"
                    + "level=?,"
                    + "kode_pegawai=? "
                    + "where username=?";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1, password);
            pr.setString(2, level);
	    pr.setString(3, kode_pegawai);
            pr.setString(4, username);

            int i = pr.executeUpdate();
            if(i > 0) {
                System.out.println("Edit Sukses");
            }
            else {
                System.out.println("Edit Gagal");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public ArrayList cari() {
        ArrayList arr = new ArrayList();
        try
        {
            obj.bukaKoneksi();
            String str = "SELECT * FROM akun WHERE username = ?";
            PreparedStatement pr = obj.con.prepareStatement(str);
            pr.setString(1, username);
            ResultSet rs = pr.executeQuery();     
            while(rs.next()) {
                arr.add(rs.getString(1));
                arr.add(rs.getString(2));
                arr.add(rs.getString(3));
                arr.add(rs.getString(4));
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return arr;
    }
    
    public ArrayList tampil(){
        ArrayList arr = new ArrayList();
        try
        {
            obj.bukaKoneksi();
            String str = "SELECT * FROM akun";
            PreparedStatement pr = obj.con.prepareStatement(str);
            ResultSet rs = pr.executeQuery();
            while(rs.next()) {
                arr.add(rs.getString(1));
                arr.add(rs.getString(2));
                arr.add(rs.getString(3));
                arr.add(rs.getString(4));
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return arr;
    }
    
    public ArrayList verifikasi() {
        ArrayList arr = new ArrayList();
        try
        {
            obj.bukaKoneksi();
            String str = "SELECT * FROM akun WHERE username = ? AND password = ?";
            PreparedStatement pr = obj.con.prepareStatement(str);
            pr.setString(1, username);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery(); 
            while(rs.next()) {
                arr.add(rs.getString(1));
                arr.add(rs.getString(2));
                arr.add(rs.getString(3));
                arr.add(rs.getString(4));
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return arr;
    }
}
