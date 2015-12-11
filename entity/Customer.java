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
public class Customer {
    private String makh;
    private String tenkh;
    private String sdt;
    private String diachi;
    private double dathanhtoan;
    private double conno;

    public Customer() {
    }

    public Customer(String makh, String tenkh, String sdt, String diachi, double dathanhtoan, double conno) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.sdt = sdt;
        this.diachi = diachi;
        this.dathanhtoan = dathanhtoan;
        this.conno = conno;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
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
