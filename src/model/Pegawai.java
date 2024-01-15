/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.ResultSet;
/**
 *
 * @author RHYZONE
 */
import config.Koneksi;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Pegawai {
    public String kode_pegawai, nama_pegawai, alamat, tanggal_lahir, jenis_kelamin, posisi;
    private Koneksi obj = new Koneksi();
    
    public void input() {
        try
        {
            obj.bukaKoneksi();
            String sql = "insert into pegawai(kode_pegawai, nama_pegawai, alamat, tanggal_lahir, jenis_kelamin, posisi) "
                    + "values(?, ?, ?, ?, ?, ?)";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1,kode_pegawai);
            pr.setString(2, nama_pegawai);
            pr.setString(3, alamat);
	    pr.setString(4, tanggal_lahir);
            pr.setString(5, jenis_kelamin);
            pr.setString(6, posisi);

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
            String sql = "delete from pegawai where kode_pegawai = ?";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1,kode_pegawai);

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
              String sql = "update pegawai set "
                    + "nama_pegawai=?,"
                    + "alamat=?,"
                    + "tanggal_lahir=?,"
                    + "jenis_kelamin=?,"
                    + "posisi=? "
                    + "where kode_pegawai=?";
            PreparedStatement pr = obj.con.prepareStatement(sql);
            pr.setString(1, nama_pegawai);
            pr.setString(2, alamat);
	    pr.setString(3, tanggal_lahir);
            pr.setString(4, jenis_kelamin);
            pr.setString(5, posisi);
            pr.setString(6,kode_pegawai);

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
            String str = "SELECT * FROM pegawai WHERE kode_pegawai = ?";
            PreparedStatement pr = obj.con.prepareStatement(str);
            pr.setString(1, kode_pegawai);
            ResultSet rs = pr.executeQuery();   
            while(rs.next()) {
                arr.add(rs.getString(1));
                arr.add(rs.getString(2));
                arr.add(rs.getString(3));
                arr.add(rs.getString(4));
                arr.add(rs.getString(5));
                arr.add(rs.getString(6));
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
            String str = "SELECT * FROM pegawai";
            PreparedStatement pr = obj.con.prepareStatement(str);
            ResultSet rs = pr.executeQuery();   
            while(rs.next()) {
                arr.add(rs.getString(1));
                arr.add(rs.getString(2));
                arr.add(rs.getString(3));
                arr.add(rs.getString(4));
                arr.add(rs.getString(5));
                arr.add(rs.getString(6));
            }          
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return arr;
    }
}