package DTO;

import java.sql.Date;

public class DatTourDTO {
	private String matour,makht,tentour,hinh1,hinh2,hinh3,mota,noikhoihanh,diadiem,phuongtien,nhahang,khachsan;
	private long giatour;
	private int songuoi;
	private Date ngaydi,ngayve;
	
	public DatTourDTO() {

	}

	public DatTourDTO(String matour, String makht, String tentour, String hinh1, String hinh2, String hinh3,
			String mota, String noikhoihanh, String diadiem, String phuongtien, String nhahang, String khachsan,
			long giatour, int songuoi, Date ngaydi, Date ngayve) {
		this.matour = matour;
		this.makht = makht;
		this.tentour = tentour;
		this.hinh1 = hinh1;
		this.hinh2 = hinh2;
		this.hinh3 = hinh3;
		this.mota = mota;
		this.noikhoihanh = noikhoihanh;
		this.diadiem = diadiem;
		this.phuongtien = phuongtien;
		this.nhahang = nhahang;
		this.khachsan = khachsan;
		this.giatour = giatour;
		this.songuoi = songuoi;
		this.ngaydi = ngaydi;
		this.ngayve = ngayve;
	}

	public String getMatour() {
		return matour;
	}

	public void setMatour(String matour) {
		this.matour = matour;
	}

	public String getMakht() {
		return makht;
	}

	public void setMakht(String makht) {
		this.makht = makht;
	}

	public String getTentour() {
		return tentour;
	}

	public void setTentour(String tentour) {
		this.tentour = tentour;
	}

	public String getHinh1() {
		return hinh1;
	}

	public void setHinh1(String hinh1) {
		this.hinh1 = hinh1;
	}

	public String getHinh2() {
		return hinh2;
	}

	public void setHinh2(String hinh2) {
		this.hinh2 = hinh2;
	}

	public String getHinh3() {
		return hinh3;
	}

	public void setHinh3(String hinh3) {
		this.hinh3 = hinh3;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getNoikhoihanh() {
		return noikhoihanh;
	}

	public void setNoikhoihanh(String noikhoihanh) {
		this.noikhoihanh = noikhoihanh;
	}

	public String getDiadiem() {
		return diadiem;
	}

	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}

	public String getPhuongtien() {
		return phuongtien;
	}

	public void setPhuongtien(String phuongtien) {
		this.phuongtien = phuongtien;
	}

	public String getNhahang() {
		return nhahang;
	}

	public void setNhahang(String nhahang) {
		this.nhahang = nhahang;
	}

	public String getKhachsan() {
		return khachsan;
	}

	public void setKhachsan(String khachsan) {
		this.khachsan = khachsan;
	}

	public double getGiatour() {
		return giatour;
	}

	public void setGiatour(long giatour) {
		this.giatour = giatour;
	}

	public int getSonguoi() {
		return songuoi;
	}

	public void setSonguoi(int songuoi) {
		this.songuoi = songuoi;
	}

	public Date getNgaydi() {
		return ngaydi;
	}

	public void setNgaydi(Date ngaydi) {
		this.ngaydi = ngaydi;
	}

	public Date getNgayve() {
		return ngayve;
	}

	public void setNgayve(Date ngayve) {
		this.ngayve = ngayve;
	}

	
}
