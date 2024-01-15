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
public class Produk {
    public String kode_produk, nama_produk;
    public int harga, stok;
    
    private Koneksi obj = new Koneksi();
    
    public void input() {
        try
        {
            obj.bukaKoneksi();
            String sql = "insert into produk(kode_produk, nama_produk, harga, stok) "
                    + "values(?, ?, ?, ?)";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1,kode_produk);
            pr.setString(2, nama_produk);
            pr.setInt(3, harga);
	    pr.setInt(4, stok);

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
            String sql = "delete from produk where kode_produk = ?";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1,kode_produk);

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
              String sql = "update produk set "
                    + "nama_produk=?,"
                    + "harga=?,"
                    + "stok=? "
                    + "where kode_produk=?";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1, nama_produk);
            pr.setInt(2, harga);
	    pr.setInt(3, stok);
            pr.setString(4,kode_produk);
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
            String str = "SELECT * FROM produk WHERE kode_produk = ?";
            PreparedStatement pr = obj.con.prepareStatement(str);
            pr.setString(1, kode_produk);
            ResultSet rs = pr.executeQuery();    
            while(rs.next()) {
                arr.add(rs.getString(1));
                arr.add(rs.getString(2));
                arr.add(rs.getInt(3));
                arr.add(rs.getInt(4));
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
            String str = "SELECT * FROM produk";
            PreparedStatement pr = obj.con.prepareStatement(str);
            ResultSet rs = pr.executeQuery();         
            while(rs.next()) {
                arr.add(rs.getString(1));
                arr.add(rs.getString(2));
                arr.add(rs.getInt(3));
                arr.add(rs.getInt(4));
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return arr;
    }
}
