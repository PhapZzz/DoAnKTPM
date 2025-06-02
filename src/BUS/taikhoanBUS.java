package BUS;

import java.util.ArrayList;

import DAO.taikhoanDAO;
import DTO.NhanVienDTO;
import DTO.taikhoanDTO;



public class taikhoanBUS {
	public static ArrayList<taikhoanDTO> tkDTO;
	public boolean docTK() {
		try {
			tkDTO = taikhoanDAO.getIntance().selectAll();
			if(tkDTO != null) return true;
			else {
				System.out.println("DU LIEU RONG");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	public String getName(String user) {
		try {
			return taikhoanDAO.getIntance().getInfo(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public NhanVienDTO getNhanVien(String user) {
		try {
			return taikhoanDAO.getIntance().getInfo_NhanVien(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public int change_info(taikhoanDTO tk) {
		try {
			return taikhoanDAO.getIntance().change_Info(tk);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}
	
}
