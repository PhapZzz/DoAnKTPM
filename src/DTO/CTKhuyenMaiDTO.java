package DTO;

public class CTKhuyenMaiDTO {
	private String makm,matour;


	public CTKhuyenMaiDTO() {
	}

	public CTKhuyenMaiDTO(String makm, String matour) {
		this.makm = makm;
		this.matour = matour;
	}

	public String getMakm() {
		return makm;
	}

	public void setMakm(String makm) {
		this.makm = makm;
	}

	public String getMatour() {
		return matour;
	}

	public void setMatour(String matour) {
		this.matour = matour;
	}
	
}
