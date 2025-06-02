package DTO;

import java.sql.Date;

public class HoaDonDTO {
    private String mahd, manv, makh;
    private Date ngaytao;
    private double tongtien,tongcong_truocgg;

    public HoaDonDTO() {
    }

    public HoaDonDTO(String mahd, String manv, String makh, Date ngaytao, double tongtien,double tongcong_truocgg) {
        this.mahd = mahd;
        this.manv = manv;
        this.makh = makh;
        this.ngaytao = ngaytao;
        this.tongtien = tongtien;
        this.tongcong_truocgg=tongcong_truocgg;
    }


    public double getTongcong_truocgg() {
		return tongcong_truocgg;
	}

	public void setTongcong_truocgg(double tongcong_truocgg) {
		this.tongcong_truocgg = tongcong_truocgg;
	}

	public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    

    

    
}
