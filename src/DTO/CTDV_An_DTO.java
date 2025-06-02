package DTO;

import java.sql.Date;

public class CTDV_An_DTO {
	private String makht;
	private Date ngay;
	private String manh;
	private double thanhtien;
	
	public CTDV_An_DTO() {
	
	}

	public CTDV_An_DTO(String makht, Date ngay, String manh, double thanhtien) {
		this.makht = makht;
		this.ngay = ngay;
		this.manh = manh;
		this.thanhtien = thanhtien;
	}
	
	public void copyDVAn(CTDV_An_DTO t) {
		this.makht = t.makht;
		this.ngay = t.ngay;
		this.manh = t.manh;
		this.thanhtien = t.thanhtien;
	}

	public String getMakht() {
		return makht;
	}

	public void setMakht(String makht) {
		this.makht = makht;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public String getManh() {
		return manh;
	}

	public void setManh(String manh) {
		this.manh = manh;
	}

	public double getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}
	
	
	
	
}
