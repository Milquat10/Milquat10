/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dika.model;

import dika.db.KoneksiDatabase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 10 Pro
 */
public class modelBarang {
    //inisialisasi variabel model
    private String namaBarangModel;
    private int stokModel;
    private String produksiModel;
    private String kadaluarsaModel;
    private int labaKotorModel;
    private int biayaBahanModel;
    private int biayaLainModel;
    private int labaBersihModel;

    public String getIdBarangModel() {
        return idBarangModel;
    }

    public void setIdBarangModel(String idBarangModel) {
        this.idBarangModel = idBarangModel;
    }
    
    private String idBarangModel;
    
    
    KoneksiDatabase koneksi = new KoneksiDatabase();
    public modelBarang() {    
        
    }    

    public String getNamaBarangModel() {
        return namaBarangModel;
    }

    public void setNamaBarangModel(String namaBarangModel) {
        this.namaBarangModel = namaBarangModel;
    }

    public int getStokModel() {
        return stokModel;
    }

    public void setStokModel(int stokModel) {
        this.stokModel = stokModel;
    }

    public String getProduksiModel() {
        return produksiModel;
    }

    public void setProduksiModel(String produksiModel) {
        this.produksiModel = produksiModel;
    }

    public String getKadaluarsaModel() {
        return kadaluarsaModel;
    }

    public void setKadaluarsaModel(String kadaluarsaModel) {
        this.kadaluarsaModel = kadaluarsaModel;
    }

    public int getLabaKotorModel() {
        return labaKotorModel;
    }

    public void setLabaKotorModel(int labaKotorModel) {
        this.labaKotorModel = labaKotorModel;
    }

    public int getBiayaBahanModel() {
        return biayaBahanModel;
    }

    public void setBiayaBahanModel(int biayaBahanModel) {
        this.biayaBahanModel = biayaBahanModel;
    }

    public int getBiayaLainModel() {
        return biayaLainModel;
    }

    public void setBiayaLainModel(int biayaLainModel) {
        this.biayaLainModel = biayaLainModel;
    }

    public int getLabaBersihModel() {
        return labaBersihModel;
    }

    public void setLabaBersihModel(int labaBersihModel) {
        this.labaBersihModel = labaBersihModel;
    }

    public KoneksiDatabase getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(KoneksiDatabase koneksi) {
        this.koneksi = koneksi;
    }
    
    
    


    
    
    public void simpanDataBarang(){
        
        String sql = ("INSERT INTO barang(namaBarang, stok, produksi, kadaluarsa, labaKotor, biayaBahan, biayaLain, labaBersih)"
                + " VALUES ('"+getNamaBarangModel()+"','"+getStokModel()+"','"+getProduksiModel()+"','"+getKadaluarsaModel()+"','"+getLabaKotorModel()+"','"+getBiayaBahanModel()+"','"+getBiayaLainModel()+"','"+getLabaBersihModel()+"')");
        
        try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n"+ex);
        }
    }
    
    public void deleteDataBarang(){
        String sql = "DELETE FROM barang WHERE idBarang = "
                + "'"+getIdBarangModel()+"'";
        
        try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n"+ex);
        }
    }
    
    public void updateDataBarang(){
        
        /*String sql = ("INSERT INTO pelanggan(namaPelanggan, noHp, jenisKelamin, umur, alamat)"
                + " VALUES ('"+getNamaPelangganModel()+"','"+getNomorHPModel()+"','"+getJenisKelaminModel()+"','"+getUmur()+"','"+getAlamat()+"')");
        */
        
        String sql = "UPDATE barang SET namaBarang = '"+getNamaBarangModel()+"'"
                + " ,stok = '"+getStokModel()+"'"
                + " ,produksi = '"+getProduksiModel()+"'"
                + " ,kadaluarsa = '"+getKadaluarsaModel()+"'"
                + " ,labaKotor = '"+getLabaKotorModel()+"'"
                + " ,biayaBahan = '"+getBiayaBahanModel()+"'"
                + " ,biayaLain = '"+getBiayaLainModel()+"'"
                + " ,labaBersih = '"+getLabaBersihModel()+"'"
                
                + " WHERE idBarang = '"+getIdBarangModel()+"'";
        
                
        try {
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n"+ex);
        }
    }

}
