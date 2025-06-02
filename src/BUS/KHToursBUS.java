package BUS;

import java.util.ArrayList;

import DAO.KHTourDAO;
import DTO.CTKHT_DTO;
import DTO.KHTourDTO;
import DTO.QlyToursDTO;

public class KHToursBUS {
	public static ArrayList<KHTourDTO> khtList=new ArrayList<KHTourDTO>();
	KHTourDAO khtDAO=new KHTourDAO();
	public boolean docKHT() {
		khtList=khtDAO.getIntance().selectAll();
		if(khtList!=null) {
			return true;
		}
		return false;
	}
	public ArrayList<KHTourDTO> docKHT(String matour) {
		ArrayList<KHTourDTO> tmp=new ArrayList<KHTourDTO>();
		for(KHTourDTO kht: khtList) {
			if(kht.getMatour().equals(matour)) {
				tmp.add(kht);
			}
		}
		if(khtList!=null) {
			return tmp;
		}
		return null;
	}
	
	public String TaoMaKHT() {
		try {
			return khtDAO.getIntance().TaoMaKHT();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int themKHT(KHTourDTO kht) {
		try {
			khtList.add(kht);
			return khtDAO.getIntance().InsertKHT(kht);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int xoa(KHTourDTO t) {
		try {
			for(CTKHT_DTO ctkht:ChiTietKHT_BUS.ctkhtList) {
				if(ctkht.getMakht().equals(t.getMakht())) {
					KHToursBUS.khtList.remove(ctkht);
				}
			}
			khtList.removeIf(tour -> tour.getMakht().equals(t.getMakht()));
			
			return khtDAO.getIntance().delete(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int sua(KHTourDTO  t,String maKHTBandau) {
		try {
			for(KHTourDTO m:khtList) {
				if(m.getMakht().equals(maKHTBandau)) {
					m.copyKHT(t);
				}
			}
			return khtDAO.getIntance().updateKHT(t,maKHTBandau);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public ArrayList<KHTourDTO> timkiem(String cond,String condType){
		ArrayList<KHTourDTO> tmp=new ArrayList<KHTourDTO>();
		try {
			for(KHTourDTO tour:khtList) {
				if(condType.equals("Mã Tour")) {
					if(tour.getMatour().equals(cond)) {
						tmp.add(tour);
					}
				}
				else if(condType.equals("Mã KHT")) {
					if(tour.getMakht().equals(cond)) {
						tmp.add(tour);
					}
				}
				else if(condType.equals("Giá vé")) {
					long p=Long.parseLong(cond);
					if(tour.getGiaVe()<=p) {
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
