package DTO;

import java.sql.Date;

public class SdDichVuDTO {
	private String makht;
	private Date ngay;
	private double thanhtientheongay;
	
	public SdDichVuDTO(String makht, Date ngay, double thanhtientheongay) {
		this.makht = makht;
		this.ngay = ngay;
		this.thanhtientheongay = thanhtientheongay;
	}
	
	public void copySDDV(SdDichVuDTO t) {
		this.makht = t.makht;
		this.ngay = t.ngay;
		this.thanhtientheongay = t.thanhtientheongay;
	}

	public SdDichVuDTO() {
		
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

	public double getThanhtientheongay() {
		return thanhtientheongay;
	}

	public void setThanhtientheongay(double thanhtientheongay) {
		this.thanhtientheongay = thanhtientheongay;
	}
	
	
	
	
	
}
