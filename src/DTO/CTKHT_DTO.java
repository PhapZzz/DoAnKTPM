package DTO;

import java.sql.Date;

public class CTKHT_DTO {
	private String makht;
	private Date ngay;
	private String maks;
	private double thanhtienKS;
	private String manh;
	private double thanhtienNH;
	private String mapt;
	private double thanhtienPT;
	
	public CTKHT_DTO() {
		
	}
	
	

	public CTKHT_DTO(String makht, Date ngay, String maks, double thanhtienKS, String manh, double thanhtienNH,
			String mapt, double thanhtienPT) {
		this.makht = makht;
		this.ngay = ngay;
		this.maks = maks;
		this.thanhtienKS = thanhtienKS;
		this.manh = manh;
		this.thanhtienNH = thanhtienNH;
		this.mapt = mapt;
		this.thanhtienPT = thanhtienPT;
	}

	public void copyCTKHT(CTKHT_DTO t) {
		this.makht = t.makht;
		this.ngay = t.ngay;
		this.maks = t.maks;
		this.thanhtienKS = t.thanhtienKS;
		this.manh = t.manh;
		this.thanhtienNH = t.thanhtienNH;
		this.mapt = t.mapt;
		this.thanhtienPT = t.thanhtienPT;
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

	public double getThanhtienKS() {
		return thanhtienKS;
	}

	public void setThanhtienKS(double thanhtienKS) {
		this.thanhtienKS = thanhtienKS;
	}

	public String getManh() {
		return manh;
	}

	public void setManh(String manh) {
		this.manh = manh;
	}

	public double getThanhtienNH() {
		return thanhtienNH;
	}

	public void setThanhtienNH(double thanhtienNH) {
		this.thanhtienNH = thanhtienNH;
	}

	public String getMapt() {
		return mapt;
	}

	public void setMapt(String mapt) {
		this.mapt = mapt;
	}

	public double getThanhtienPT() {
		return thanhtienPT;
	}

	public void setThanhtienPT(double thanhtienPT) {
		this.thanhtienPT = thanhtienPT;
	}
	
	public double getTongtien() {
		return thanhtienPT+thanhtienNH+thanhtienKS;
	}
	
	
}
