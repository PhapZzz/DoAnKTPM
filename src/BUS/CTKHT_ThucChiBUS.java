package BUS;

import java.util.ArrayList;

import DAO.CTKHT_ThucChiDAO;
import DAO.KHTourDAO;
import DAO.QlyToursDAO;
import DTO.CTKHT_DTO;
import DTO.CTKHT_ThucChiDTO;
import DTO.KHTourDTO;
import DTO.QlyToursDTO;

public class CTKHT_ThucChiBUS {
	CTKHT_ThucChiDAO thucchiDAO=new CTKHT_ThucChiDAO();
	KHTourDAO khtDAO=new KHTourDAO();
	public static ArrayList<CTKHT_ThucChiDTO> thucchiList=new ArrayList<CTKHT_ThucChiDTO>();
	
	public boolean docfile(){
		try {
			thucchiList= thucchiDAO.getIntance().selectAll();
			if(thucchiList!=null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public int them(CTKHT_ThucChiDTO t) {
		try {
			thucchiList.add(t);
			return thucchiDAO.getIntance().Insert(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int xoa(CTKHT_ThucChiDTO t) {
		try {			
			thucchiList.removeIf(thucchi -> thucchi.getMakht().equals(t.getMakht()));
			return thucchiDAO.getIntance().delete(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int sua(CTKHT_ThucChiDTO t) {
		try {
			int a=0;
			for(CTKHT_ThucChiDTO m:thucchiList) {
				if(m.getMakht().equals(t.getMakht())&&m.getNgay().equals(t.getNgay())) {
					m.copy(t);
					a= thucchiDAO.getIntance().Update(t);
				}
			}
			for(KHTourDTO kht1: KHToursBUS.khtList) {
				if(kht1.getMakht().equals(t.getMakht())) {
					kht1.setThucchi((long)GetThucChi(kht1.getMakht()));
					khtDAO.getIntance().updateKHT(kht1, kht1.getMakht());
				}
			}
			return a;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public double GetThucChi(String makht) {
		double thucchi=0;
		for(CTKHT_ThucChiDTO tc : thucchiList) {
			if(tc.getMakht().equals(makht)) {
				thucchi+=tc.getTongtien();
			}
		}
		return thucchi;
	}
//	public ArrayList<QlyToursDTO> timkiem(String cond,String condType){
//		ArrayList<QlyToursDTO> tmp=new ArrayList<QlyToursDTO>();
//		try {
//			for(QlyToursDTO tour:tourDTO) {
//				if(condType.equals("Mã Tour")) {
//					if(tour.getMatour().equals(cond)) {
//						tmp.add(tour);
//					}
//				}
//				else if(condType.equals("Số ngày")) {
//					int p=Integer.parseInt(cond);
//					if(tour.getSongay()==p) {
//						tmp.add(tour);
//					}
//				}
//				else if(condType.equals("Nơi đến")) {
//					if(tour.getNoiden().equals(cond)) {
//						tmp.add(tour);
//					}
//				}
//			}
//			return tmp;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
}
