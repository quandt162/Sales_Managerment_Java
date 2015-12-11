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
public class Product {
    private String mahh;
    private String tenhh;
    private double giaban;
    private String donvitinh;

    public Product() {
    }

    public Product(String mahh, String tenhh, double giaban, String donvitinh) {
        this.mahh = mahh;
        this.tenhh = tenhh;
        this.giaban = giaban;
        this.donvitinh = donvitinh;
    }

    public String getMahh() {
        return mahh;
    }

    public void setMahh(String mahh) {
        this.mahh = mahh;
    }

    public String getTenhh() {
        return tenhh;
    }

    public void setTenhh(String tenhh) {
        this.tenhh = tenhh;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    
    
}
