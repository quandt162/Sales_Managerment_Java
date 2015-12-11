/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Blob;

/**
 *
 * @author Love Jav
 */
public class Employees {
    private int manv;
    private String tennv;
    private String sdt;
    private String diachi;
    private String taikhoan;
    private String matkhau;
    private String NgayBatDau;
    private String quyen;
    private Blob anh;
    
    public Employees() {
    }

    public Employees(int manv, String tennv, String sdt, String diachi, String taikhoan, String matkhau, String NgayBatDau, String quyen, Blob anh) {
        this.manv = manv;
        this.tennv = tennv;
        this.sdt = sdt;
        this.diachi = diachi;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.NgayBatDau = NgayBatDau;
        this.quyen = quyen;
        this.anh = anh;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
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

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public Blob getAnh() {
        return anh;
    }

    public void setAnh(Blob anh) {
        this.anh = anh;
    }

    
   
}
