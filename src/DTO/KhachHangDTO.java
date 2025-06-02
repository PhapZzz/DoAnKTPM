package DTO;

import java.sql.Date;

public class KhachHangDTO {
    private String makh, hokh, tenkh, diachi, sdt, email;
    private Date ngaysinh;
    private boolean gioitinh;
	public KhachHangDTO() {
	}
	
	public KhachHangDTO(String makh, String hokh, String tenkh, String diachi, String sdt, String email,boolean gioitinh,Date ngaysinh) {
		this.makh = makh;
		this.hokh = hokh;
		this.tenkh = tenkh;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
		this.gioitinh = gioitinh;
		this.ngaysinh=ngaysinh;
	}

	public void copyKhachhang(KhachHangDTO kh) {
		this.makh = kh.makh;
		this.hokh = kh.hokh;
		this.tenkh = kh.tenkh;
		this.gioitinh = kh.gioitinh;
		this.diachi = kh.diachi;
		this.sdt = kh.sdt;
		this.email = kh.email;
		this.ngaysinh=kh.ngaysinh;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getHokh() {
		return hokh;
	}
	public void setHokh(String hokh) {
		this.hokh = hokh;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh=ngaysinh;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
}
