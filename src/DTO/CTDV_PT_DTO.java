package DTO;

import java.sql.Date;

public class CTDV_PT_DTO {
	private String makht;
	private Date ngay;
	private String mapt;
	private double thanhtien;
	public CTDV_PT_DTO() {
	
	}
	public CTDV_PT_DTO(String makht, Date ngay, String mapt, double thanhtien) {
		this.makht = makht;
		this.ngay = ngay;
		this.mapt = mapt;
		this.thanhtien = thanhtien;
	}
	
	public void copyDVPT(CTDV_PT_DTO t) {
		this.makht = t.makht;
		this.ngay = t.ngay;
		this.mapt = t.mapt;
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
	public String getMapt() {
		return mapt;
	}
	public void setMapt(String mapt) {
		this.mapt = mapt;
	}
	public double getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}
	
	
	
	
	
}
