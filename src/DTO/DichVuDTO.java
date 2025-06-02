package DTO;

public class DichVuDTO {
	private String maso,tendv;
	private double giaca;
	public DichVuDTO() {};
	public DichVuDTO(String maso, String tendv, double giaca) {
		super();
		this.maso = maso;
		this.tendv = tendv;
		this.giaca = giaca;
	}
	public void copyDichVu(DichVuDTO t) {
		this.maso = t.maso;
		this.tendv = t.tendv;
		this.giaca = t.giaca;
	}
	public String getMaso() {
		return maso;
	}
	public void setMaso(String maso) {
		this.maso = maso;
	}
	public String getTendv() {
		return tendv;
	}
	public void setTendv(String tendv) {
		this.tendv = tendv;
	}
	public double getGiaca() {
		return giaca;
	}
	public void setGiaca(double giaca) {
		this.giaca = giaca;
	}
	
}
