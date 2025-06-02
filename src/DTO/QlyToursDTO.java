package DTO;

import java.sql.Date;

public class QlyToursDTO {
	private String matour, tentour, noiden, noikhoihanh, maloai;
	private int songay;

	public QlyToursDTO() {

	}

	public QlyToursDTO(String matour, String tentour, String noiden, String noikhoihanh, String maloai, int songay) {
		this.matour = matour;
		this.tentour = tentour;
		this.noiden = noiden;
		this.noikhoihanh = noikhoihanh;
		this.maloai = maloai;
		this.songay = songay;
	}

	public QlyToursDTO(QlyToursDTO t) {
		this.matour = t.matour;
		this.tentour = t.tentour;
		this.noiden = t.noiden;
		this.noikhoihanh = t.noikhoihanh;
		this.maloai = t.maloai;
		this.songay = t.songay;
	}
	
	public void copyTour(QlyToursDTO t) {
		this.matour=t.matour;
		this.tentour=t.tentour;
		this.noiden=t.noiden;
		this.noikhoihanh=t.noikhoihanh;
		this.songay=t.songay;
		this.maloai=t.maloai;
	}

	public String getMatour() {
		return matour;
	}

	public void setMatour(String matour) {
		this.matour = matour;
	}

	public String getTentour() {
		return tentour;
	}

	public void setTentour(String tentour) {
		this.tentour = tentour;
	}

	public String getNoiden() {
		return noiden;
	}

	public void setNoiden(String noiden) {
		this.noiden = noiden;
	}

	public String getNoikhoihanh() {
		return noikhoihanh;
	}

	public void setNoikhoihanh(String noikhoihanh) {
		this.noikhoihanh = noikhoihanh;
	}

	public String getMaloai() {
		return maloai;
	}

	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}

	public int getSongay() {
		return songay;
	}

	public void setSongay(int songay) {
		this.songay = songay;
	}

}
