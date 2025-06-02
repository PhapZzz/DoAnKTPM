package DTO;

import java.sql.Date;

public class CTDV_KS_DTO {
	private String makht;
	private Date ngay;
	private String maks;
	private double thanhtien;
	
	public CTDV_KS_DTO() {
		
	}

	public CTDV_KS_DTO(String makht, Date ngay, String maks, double thanhtien) {
		this.makht = makht;
		this.ngay = ngay;
		this.maks = maks;
		this.thanhtien = thanhtien;
	}

	public void copyDVKS(CTDV_KS_DTO t) {
		this.makht = t.makht;
		this.ngay = t.ngay;
		this.maks = t.maks;
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

	public String getMaks() {
		return maks;
	}

	public void setMaks(String maks) {
		this.maks = maks;
	}

	public double getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}
	
	
	
}
