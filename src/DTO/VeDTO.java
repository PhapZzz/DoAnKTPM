package DTO;

public class VeDTO {
	private String mave,makht,mahd,makm,makh;
	private double giave,giavegg;
	
	public VeDTO() {
		
	}

	public VeDTO(String mave, String makht, String mahd, String makm, String makh, double giave,double giavegg) {
		this.mave = mave;
		this.makht = makht;
		this.mahd = mahd;
		this.makm = makm;
		this.makh = makh;
		this.giave = giave;
		this.giavegg=giavegg;
	}

	public double getGiavegg() {
		return giavegg;
	}

	public void setGiavegg(double giavegg) {
		this.giavegg = giavegg;
	}

	public String getMave() {
		return mave;
	}

	public void setMave(String mave) {
		this.mave = mave;
	}

	public String getMakht() {
		return makht;
	}

	public void setMakht(String makht) {
		this.makht = makht;
	}

	public String getMahd() {
		return mahd;
	}

	public void setMahd(String mahd) {
		this.mahd = mahd;
	}

	public String getMakm() {
		return makm;
	}

	public void setMakm(String makm) {
		this.makm = makm;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public double getGiave() {
		return giave;
	}

	public void setGiave(double giave) {
		this.giave = giave;
	}
	
	
	
	
	
}
