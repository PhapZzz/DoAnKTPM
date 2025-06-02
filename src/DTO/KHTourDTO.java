package DTO;

import java.sql.Date;

public class KHTourDTO {
	private String makht,matour,mota,huongdanvien,anh1,anh2,anh3;
	private Date ngaydi,ngayve;
	private int songuoi,songuoidukien;
	private long tongchi,giave,thucchi;
	public KHTourDTO() {
		
	}
	public KHTourDTO(String makht, String matour, String mota, String huongdanvien, String anh1, String anh2,
			String anh3, Date ngaydi, Date ngayve, int songuoi, long tongchi,long giave,long thucchi,int songuoidukien) {
		this.makht = makht;
		this.matour = matour;
		this.mota = mota;
		this.huongdanvien = huongdanvien;
		this.anh1 = anh1;
		this.anh2 = anh2;
		this.anh3 = anh3;
		this.ngaydi = ngaydi;
		this.ngayve = ngayve;
		this.songuoi = songuoi;
		this.tongchi = tongchi;
		this.giave=giave;
		this.thucchi=thucchi;
		this.songuoidukien=songuoidukien;
	}

	public void copyKHT(KHTourDTO t) {
		this.makht = t.makht;
		this.matour = t.matour;
		this.mota = t.mota;
		this.huongdanvien = t.huongdanvien;
		this.anh1 = t.anh1;
		this.anh2 = t.anh2;
		this.anh3 = t.anh3;
		this.ngaydi = t.ngaydi;
		this.ngayve = t.ngayve;
		this.songuoi = t.songuoi;
		this.tongchi = t.tongchi;
		this.giave=t.giave;
		this.thucchi=t.thucchi;
		this.songuoidukien=t.songuoidukien;
	}

	public int getSonguoidukien() {
		return songuoidukien;
	}
	public void setSonguoidukien(int songuoidukien) {
		this.songuoidukien = songuoidukien;
	}
	public long getThucchi() {
		return thucchi;
	}
	public void setThucchi(long thucchi) {
		this.thucchi = thucchi;
	}
	public String getMakht() {
		return makht;
	}
	public void setMakht(String makht) {
		this.makht = makht;
	}
	public String getMatour() {
		return matour;
	}
	public void setMatour(String matour) {
		this.matour = matour;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getHuongdanvien() {
		return huongdanvien;
	}
	public void setHuongdanvien(String huongdanvien) {
		this.huongdanvien = huongdanvien;
	}
	public String getAnh1() {
		return anh1;
	}
	public void setAnh1(String anh1) {
		this.anh1 = anh1;
	}
	public String getAnh2() {
		return anh2;
	}
	public void setAnh2(String anh2) {
		this.anh2 = anh2;
	}
	public String getAnh3() {
		return anh3;
	}
	public void setAnh3(String anh3) {
		this.anh3 = anh3;
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
	public int getSonguoi() {
		return songuoi;
	}
	public void setSonguoi(int songuoi) {
		this.songuoi = songuoi;
	}
	public long getTongchi() {
		return tongchi;
	}
	public void setTongchi(long tongchi) {
		this.tongchi = tongchi;
	}
	public long getGiaVe() {
		return giave;
	}
	public void setGiave(long giave) {
		this.giave = giave;
	}
	
	
	
}
