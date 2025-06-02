package BUS;

import java.util.ArrayList;

import DAO.thongkeDAO;
import DTO.HoaDonDTO;
import DTO.thongkeDTO;


public class thongkeBUS {

//	    public static ArrayList<HoaDonDTO> listHD;
	private thongkeDAO tkDAO = new thongkeDAO();
		public double getQuy(int start, int end,String year_Selected) {
			try {
	            return tkDAO.getQuy(start,end,year_Selected);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0;
	        }
		}
		
		public ArrayList<thongkeDTO> getTk_tours_thu(String Year){
			try {
	            return tkDAO.getTk_tours_thu(Year);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
		}
		
	    public double getDoanhThu(String year) {
	        try {
	            return tkDAO.getDoanhThu(year);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0;
	        }
	    }
	    public double getTongChi(String year) {
	        try {
	            return tkDAO.getTongChi(year);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0;
	        }
	    }
	    
	    public int getQuanTity_Cus(String year) {
	        try {
	            return tkDAO.getLuotKhach(year);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0;
	        }
	    }
	    public ArrayList<HoaDonDTO> getTK_NV(String year){
	    	try {
	            return tkDAO.getTK_NV(year);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    public ArrayList<HoaDonDTO> getTK_KH(String year){
	    	try {
	            return tkDAO.getTK_KH(year);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}
