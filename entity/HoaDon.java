/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Love Jav
 */
public class HoaDon {
    private String sohd;
    private String ngaylap;
    private String manv;
    private double tongtien;

    public HoaDon() {
    }

    public HoaDon(String sohd, String ngaylap, String manv, double tongtien) {
        this.sohd = sohd;
        this.ngaylap = ngaylap;
        this.manv = manv;
        this.tongtien = tongtien;
    }

    public String getSohd() {
        return sohd;
    }

    public void setSohd(String sohd) {
        this.sohd = sohd;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }
    
    
    
    
}
