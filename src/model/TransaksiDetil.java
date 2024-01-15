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
public class TransaksiDetil {
    public String nomor_transaksi, kode_produk;
    public int id, jumlah, harga_transaksi;
    private Koneksi obj = new Koneksi();
    
    public void input() {
        try
        {
            obj.bukaKoneksi();
            String sql = "insert into transaksi_detil(nomor_transaksi, kode_produk, jumlah, harga_transaksi) "
                    + "values(?, ?, ?, ?)";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1,nomor_transaksi);
            pr.setString(2, kode_produk);
            pr.setInt(3, jumlah);
	    pr.setInt(4, harga_transaksi);
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
            String sql = "delete transaksi_detil where id = ?";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setInt(1,id);

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
            String sql = "update transaksi_detil set "
                    + "nomor_transaksi=?,"
                    + "kode_produk=?,"
                    + "jumlah=?,"
                    + "harga_transaksi=? "
                    + "where id=?";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1, nomor_transaksi);
            pr.setString(2, kode_produk);
	    pr.setInt(3, jumlah);
            pr.setInt(4,harga_transaksi);
            pr.setInt(5, id);
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
            String str = "SELECT * FROM transaksi_detil WHERE id = ?";
            PreparedStatement pr = obj.con.prepareStatement(str);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery(); 
            while(rs.next()) {
                arr.add(rs.getInt(1));
                arr.add(rs.getString(2));
                arr.add(rs.getString(3));
                arr.add(rs.getInt(4));
                arr.add(rs.getInt(5));
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
            String str = "SELECT * FROM transaksi_detil";
            PreparedStatement pr = obj.con.prepareStatement(str);
            ResultSet rs = pr.executeQuery(); 
            while(rs.next()) {
                arr.add(rs.getInt(1));
                arr.add(rs.getString(2));
                arr.add(rs.getString(3));
                arr.add(rs.getInt(4));
                arr.add(rs.getInt(5));
            }           
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return arr;
    }
    
    public ArrayList carinomor() {
        ArrayList arr = new ArrayList();
        try
        {
            obj.bukaKoneksi();
            String str = "SELECT * FROM transaksi_detil WHERE nomor_transaksi = ?";
            PreparedStatement pr = obj.con.prepareStatement(str);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery(); 
            while(rs.next()) {
                arr.add(rs.getInt(1));
                arr.add(rs.getString(2));
                arr.add(rs.getString(3));
                arr.add(rs.getInt(4));
                arr.add(rs.getInt(5));
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return arr;
    }
}