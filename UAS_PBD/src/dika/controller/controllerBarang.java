/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dika.controller;

import dika.model.modelBarang;
import dika.view.viewBarangInternal;
import javax.swing.JOptionPane;
/**
 *
 * @author 10 Pro
 */
public class controllerBarang {
    
    private modelBarang mB;
    private viewBarangInternal vB;

    public controllerBarang(viewBarangInternal vB) {
        this.vB = vB;
        
    }
    
    public void bersihkan(){
        vB.getIdBarangView().setText("");
        vB.getNamaBarangView().setText("");
        vB.getStokView().setText("");
        vB.getProduksiView().setText("");
        vB.getKadaluarsaView().setText("");
        vB.getlabaKotorView().setText("");
        vB.getbiayaBahanView().setText("");
        vB.getbiayaLainView().setText("");
        vB.getlabaBersihView().setText("");

    }
    
    public void KontrolButton(){
        vB.getTombolSimpan().setEnabled(true);
        vB.getTombolEdit().setEnabled(false);
        vB.getTombolHapus().setEnabled(false);
        vB.getTombolBatal().setEnabled(true);
   }
    
    public void KontrolButtonDua(){
        vB.getTombolSimpan().setEnabled(false);
        vB.getTombolEdit().setEnabled(true);
        vB.getTombolHapus().setEnabled(true);
        vB.getTombolBatal().setEnabled(true);
   }
    
    public void hapus(){
    mB = new modelBarang();
    mB.setIdBarangModel(vB.getIdBarangView().getText());
    
    mB.deleteDataBarang();
    bersihkan();
    KontrolButton();
    }
    
    public void update(){
       mB = new modelBarang();
       mB.setIdBarangModel(vB.getIdBarangView().getText());
       mB.setNamaBarangModel(vB.getNamaBarangView().getText()); 
       mB.setStokModel(Integer.parseInt(vB.getStokView().getText()));
       mB.setProduksiModel(vB.getProduksiView().getText());
       mB.setKadaluarsaModel(vB.getKadaluarsaView().getText());
       mB.setLabaKotorModel(Integer.parseInt(vB.getlabaKotorView().getText()));
       mB.setBiayaBahanModel(Integer.parseInt(vB.getbiayaBahanView().getText()));
       mB.setBiayaLainModel(Integer.parseInt(vB.getbiayaLainView().getText()));
       mB.setLabaBersihModel(Integer.parseInt(vB.getlabaBersihView().getText()));

        mB.updateDataBarang();
        KontrolButton();
        bersihkan(); 
    }   
    
    public void simpan(){
    mB = new modelBarang();
    mB.setNamaBarangModel(vB.getNamaBarangView().getText());
       mB.setStokModel(Integer.parseInt(vB.getStokView().getText()));
       mB.setProduksiModel(vB.getProduksiView().getText());
       mB.setKadaluarsaModel(vB.getKadaluarsaView().getText());
       mB.setLabaKotorModel(Integer.parseInt(vB.getlabaKotorView().getText()));
       mB.setBiayaBahanModel(Integer.parseInt(vB.getbiayaBahanView().getText()));
       mB.setBiayaLainModel(Integer.parseInt(vB.getbiayaLainView().getText()));
       mB.setLabaBersihModel(Integer.parseInt(vB.getlabaBersihView().getText()));
    
    mB.simpanDataBarang();
    bersihkan();
    }
}
