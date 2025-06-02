package DTO;

public class taikhoanDTO {
	private String user,pass;

	public taikhoanDTO() {}

	public taikhoanDTO(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
