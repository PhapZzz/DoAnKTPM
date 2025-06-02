package DTO;

public class thongkeDTO {
	private String makht, matour;
	private double chi,thu;
	public thongkeDTO() {
		// TODO Auto-generated constructor stub
	}
	public thongkeDTO(String makht, String matour, double chi, double thu) {
		super();
		this.makht = makht;
		this.matour = matour;
		this.chi = chi;
		this.thu = thu;
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
	public double getChi() {
		return chi;
	}
	public void setChi(double chi) {
		this.chi = chi;
	}
	public double getThu() {
		return thu;
	}
	public void setThu(double thu) {
		this.thu = thu;
	}
	
}
