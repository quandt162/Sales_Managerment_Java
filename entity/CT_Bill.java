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
public class CT_Bill {
    private String sohd;
    private String makh;
    private String tenkh;
    private int dongia;
    private int soluong;
    private int thanhtien;

    public CT_Bill() {
    }

    public CT_Bill(String sohd, String makh, String tenkh, int dongia, int soluong) {
        this.sohd = sohd;
        this.makh = makh;
        this.tenkh = tenkh;
        this.dongia = dongia;
        this.soluong = soluong;
    }

    public String getSohd() {
        return sohd;
    }

    public void setSohd(String sohd) {
        this.sohd = sohd;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }
    
}
