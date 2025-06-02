package BUS;

import java.util.ArrayList;

import DAO.QlyToursDAO;
import DTO.CTKHT_DTO;
import DTO.KHTourDTO;
import DTO.QlyToursDTO;
import GUI.QuanLyTour;

public class QlyToursBUS {
	QlyToursDAO tourDAO=new QlyToursDAO();
	public static ArrayList<QlyToursDTO> tourDTO;
	
	public boolean docTour(){
		try {
			tourDTO= tourDAO.getIntance().selectAll();
			if(tourDTO!=null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public String TaoMaTour() {
		try {
			return tourDAO.getIntance().TaoMaTour();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int them(QlyToursDTO t) {
		try {
			tourDTO.add(t);
			return tourDAO.getIntance().InsertTour(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int xoa(QlyToursDTO t) {
		try {
			for(QlyToursDTO p:tourDTO) {
				if(p.getMatour().equals(t.getMatour())) {
					tourDTO.remove(p);
					break;
				}
			}
			ArrayList<String> makht=new ArrayList<String>();
			for(KHTourDTO kht:KHToursBUS.khtList) {
				if(kht.getMatour().equals(t.getMatour())) {
					makht.add(kht.getMakht());
					KHToursBUS.khtList.remove(kht);
				}
			}
			for(int i=0;i<makht.size();i++) {
				for(CTKHT_DTO ctkht:ChiTietKHT_BUS.ctkhtList) {
					if(ctkht.getMakht().equals(makht.toArray()[i])) {
						KHToursBUS.khtList.remove(ctkht);
					}
				}
			}			
			tourDTO.removeIf(tour -> tour.getMatour().equals(t.getMatour()));
			return tourDAO.getIntance().delete(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int sua(QlyToursDTO t,String maTourBanDau) {
		try {
			for(QlyToursDTO m:tourDTO) {
				if(m.getMatour().equals(maTourBanDau)) {
					m.copyTour(t);
				}
			}
			return tourDAO.getIntance().updateTour(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public ArrayList<QlyToursDTO> timkiem(String cond,String condType){
		ArrayList<QlyToursDTO> tmp=new ArrayList<QlyToursDTO>();
		try {
			for(QlyToursDTO tour:tourDTO) {
				if(condType.equals("Mã Tour")) {
					if(tour.getMatour().equals(cond)) {
						tmp.add(tour);
					}
				}
				else if(condType.equals("Số ngày")) {
					int p=Integer.parseInt(cond);
					if(tour.getSongay()==p) {
						tmp.add(tour);
					}
				}
				else if(condType.equals("Nơi đến")) {
					if(tour.getNoiden().equals(cond)) {
						tmp.add(tour);
					}
				}
			}
			return tmp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
