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
public class TransaksiHeader {
    public String nomor_transaksi, tanggal_transaksi, kode_pegawai;
    public int total_harga;
    private Koneksi obj = new Koneksi();
    
    public void input() {
        try
        {
            obj.bukaKoneksi();
            String sql = "insert into transaksi_header(nomor_transaksi, tanggal_transaksi, total_harga, kode_pegawai) "
                    + "values(?, ?, ?, ?)";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1,nomor_transaksi);
            pr.setString(2, tanggal_transaksi);
            pr.setInt(3, total_harga);
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
            String sql = "delete transaksi_header where nomor_transaksi = ?";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1,nomor_transaksi);

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
              String sql = "update transaksi_header set "
                    + "tanggal_transaksi=?,"
                    + "total_harga=?,"
                    + "kode_pegawai=? "
                    + "where nomor_transaksi=?";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1, tanggal_transaksi);
            pr.setInt(2, total_harga);
	    pr.setString(3, kode_pegawai);
            pr.setString(4,nomor_transaksi);
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
            String str = "SELECT * FROM transaksi_header WHERE nomor_transaksi = ?";
            PreparedStatement pr = obj.con.prepareStatement(str);
            pr.setString(1, nomor_transaksi);
            ResultSet rs = pr.executeQuery();     
            while(rs.next()) {
                arr.add(rs.getString(1));
                arr.add(rs.getString(2));
                arr.add(rs.getInt(3));
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
            String str = "SELECT * FROM transaksi_header";
            PreparedStatement pr = obj.con.prepareStatement(str);
            ResultSet rs = pr.executeQuery();     
            while(rs.next()) {
                arr.add(rs.getString(1));
                arr.add(rs.getString(2));
                arr.add(rs.getInt(3));
                arr.add(rs.getString(4));
            }           
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return arr;
    }
}