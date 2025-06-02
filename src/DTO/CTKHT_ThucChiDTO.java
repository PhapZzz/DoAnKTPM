package DTO;

import java.sql.Date;

public class CTKHT_ThucChiDTO {
	private String makht,maks,mapt,manh;
	private double thanhtienks,thanhtienpt,thanhtiennh,tongtien;
	private Date ngay;
	public CTKHT_ThucChiDTO() {
		
	}
	public CTKHT_ThucChiDTO(String makht, String maks, String mapt, String manh, double thanhtienks, double thanhtienpt,
			double thanhtiennh, double tongtien, Date ngay) {
		this.makht = makht;
		this.maks = maks;
		this.mapt = mapt;
		this.manh = manh;
		this.thanhtienks = thanhtienks;
		this.thanhtienpt = thanhtienpt;
		this.thanhtiennh = thanhtiennh;
		this.tongtien = tongtien;
		this.ngay = ngay;
	}
	
	public void copy(CTKHT_ThucChiDTO t) {
		this.makht = t.makht;
		this.maks = t.maks;
		this.mapt = t.mapt;
		this.manh = t.manh;
		this.thanhtienks = t.thanhtienks;
		this.thanhtienpt = t.thanhtienpt;
		this.thanhtiennh = t.thanhtiennh;
		this.tongtien = t.tongtien;
		this.ngay = t.ngay;
	}
	
	public String getMakht() {
		return makht;
	}
	public void setMakht(String makht) {
		this.makht = makht;
	}
	public String getMaks() {
		return maks;
	}
	public void setMaks(String maks) {
		this.maks = maks;
	}
	public String getMapt() {
		return mapt;
	}
	public void setMapt(String mapt) {
		this.mapt = mapt;
	}
	public String getManh() {
		return manh;
	}
	public void setManh(String manh) {
		this.manh = manh;
	}
	public double getThanhtienks() {
		return thanhtienks;
	}
	public void setThanhtienks(double thanhtienks) {
		this.thanhtienks = thanhtienks;
	}
	public double getThanhtienpt() {
		return thanhtienpt;
	}
	public void setThanhtienpt(double thanhtienpt) {
		this.thanhtienpt = thanhtienpt;
	}
	public double getThanhtiennh() {
		return thanhtiennh;
	}
	public void setThanhtiennh(double thanhtiennh) {
		this.thanhtiennh = thanhtiennh;
	}
	public double getTongtien() {
		return tongtien;
	}
	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	
	
	
}
