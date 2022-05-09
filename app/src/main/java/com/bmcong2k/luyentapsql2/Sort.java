package com.bmcong2k.luyentapsql2;

import java.io.Serializable;

public class Sort implements Serializable {
    private int dem;
    private String tenSach, nxb;

    public Sort() {
    }

    public Sort(int dem, String tenSach, String nxb) {
        this.dem = dem;
        this.tenSach = tenSach;
        this.nxb = nxb;
    }

    public int getDem() {
        return dem;
    }

    public void setDem(int dem) {
        this.dem = dem;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }
}
