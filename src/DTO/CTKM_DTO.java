package DTO;

public class CTKM_DTO {
	private String makm,matour;

	public CTKM_DTO() {
		
	}

	public CTKM_DTO(String makm, String matour) {
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
