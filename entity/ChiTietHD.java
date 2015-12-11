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
public class ChiTietHD {
    private String MaCTHD;
    private String maHD;
    private String maSP;
    private float soLuong;
    private double tongtien;
    private double dathanhtoan;
    private double conno;

    public ChiTietHD() {
    }

    public ChiTietHD(String MaCTHD, String maHD, String maSP, float soLuong, double tongtien, double dathanhtoan, double conno) {
        this.MaCTHD = MaCTHD;
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.dathanhtoan = dathanhtoan;
        this.conno = conno;
    }

    public String getMaCTHD() {
        return MaCTHD;
    }

    public void setMaCTHD(String MaCTHD) {
        this.MaCTHD = MaCTHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public float getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(float soLuong) {
        this.soLuong = soLuong;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public double getDathanhtoan() {
        return dathanhtoan;
    }

    public void setDathanhtoan(double dathanhtoan) {
        this.dathanhtoan = dathanhtoan;
    }

    public double getConno() {
        return conno;
    }

    public void setConno(double conno) {
        this.conno = conno;
    }

    
   
}
