package com.bmcong2k.luyentapsql2;

import java.io.Serializable;

public class Book1 implements Serializable {
    private int id;
    private String tenSach, tacGia, tomTat, nxb;
    private double danhGia;

    public Book1(int id, String tenSach, String tacGia, String tomTat, String nxb, double danhGia) {
        this.id = id;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.tomTat = tomTat;
        this.nxb = nxb;
        this.danhGia = danhGia;
    }

    public Book1() {
    }

    public Book1(String tenSach, String tacGia, String tomTat, String nxb, double danhGia) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.tomTat = tomTat;
        this.nxb = nxb;
        this.danhGia = danhGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public double getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(double danhGia) {
        this.danhGia = danhGia;
    }
}
