package BUS;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import DAO.CTKHT_ThucChiDAO;
import DAO.ChiTietKHT_DAO;
import DTO.CTDV_An_DTO;
import DTO.CTDV_KS_DTO;
import DTO.CTDV_PT_DTO;
import DTO.SdDichVuDTO;
import GUI.KHTourGUI;
import DTO.CTKHT_DTO;
import DTO.CTKHT_ThucChiDTO;
import DTO.KHTourDTO;
import DTO.QlyToursDTO;

public class ChiTietKHT_BUS {
	public ArrayList<SdDichVuDTO> sddvList=new ArrayList<SdDichVuDTO>();
	public ArrayList<CTDV_An_DTO> ctdvAnList=new ArrayList<CTDV_An_DTO>();
	public ArrayList<CTDV_KS_DTO> ctdvKSList=new ArrayList<CTDV_KS_DTO>();
	public ArrayList<CTDV_PT_DTO> ctdvPTList=new ArrayList<CTDV_PT_DTO>();
	public static ArrayList<CTKHT_DTO> ctkhtList=new ArrayList<CTKHT_DTO>();
	
	ChiTietKHT_DAO ctkhtDAO=new ChiTietKHT_DAO();
	CTKHT_ThucChiDAO thucchiDAO=new CTKHT_ThucChiDAO();
	KHToursBUS kht_bus=new KHToursBUS();
	
	
	public boolean docCTKHT() {
		sddvList=ChiTietKHT_DAO.getIntance().selectAll_SdDichVu();
		ctdvAnList=ChiTietKHT_DAO.getIntance().selectAll_CTDV_An();
		ctdvKSList=ChiTietKHT_DAO.getIntance().selectAll_CTDV_KS();
		ctdvPTList=ChiTietKHT_DAO.getIntance().selectAll_CTDV_PT();		
		ctkhtList.clear();
		for(int i=0;i<sddvList.size();i++) {
			CTKHT_DTO ctkht=new CTKHT_DTO();
			ctkht.setMakht(sddvList.get(i).getMakht());
			ctkht.setNgay(sddvList.get(i).getNgay());
			ctkht.setMaks(ctdvKSList.get(i).getMaks());
			ctkht.setThanhtienKS(ctdvKSList.get(i).getThanhtien());
			ctkht.setManh(ctdvAnList.get(i).getManh());
			ctkht.setThanhtienNH(ctdvAnList.get(i).getThanhtien());
			ctkht.setMapt(ctdvPTList.get(i).getMapt());
			ctkht.setThanhtienPT(ctdvPTList.get(i).getThanhtien());
			ctkhtList.add(ctkht);
		}
		
		if(sddvList!=null&&ctdvAnList!=null&&ctdvKSList!=null&&ctdvPTList!=null) {
			return true;
		}
		return false;
	}
	public int them(CTKHT_DTO t) {
		try {
			double tongchi=0;
			ctkhtList.add(t);
			CTDV_An_DTO dvan=new CTDV_An_DTO(t.getMakht(), t.getNgay(), t.getManh(), t.getThanhtienNH());
			CTDV_KS_DTO dvks=new CTDV_KS_DTO(t.getMakht(), t.getNgay(), t.getMaks(), t.getThanhtienKS());
			CTDV_PT_DTO dvpt=new CTDV_PT_DTO(t.getMakht(), t.getNgay(), t.getMapt(), t.getThanhtienPT());
			SdDichVuDTO sddv=new SdDichVuDTO(t.getMakht(), t.getNgay(), t.getTongtien());
			CTKHT_ThucChiDTO thucchiDTO=new CTKHT_ThucChiDTO(t.getMakht(), t.getMaks(),t.getMapt(), t.getManh(), 0, 0, 0, 0, t.getNgay());
			int a=-1,b=-1,c=-1,d=-1;
			
			for(CTKHT_DTO m:ctkhtList) {
				if(m.getMakht().equals(t.getMakht())) {
					tongchi=tongchi+m.getTongtien();
				}
			}
			
			for(KHTourDTO kht:KHToursBUS.khtList) {
				if(kht.getMakht().equals(t.getMakht())) {
					kht.setTongchi((long) tongchi);
					kht.setGiave((long)tongchi*130/100/kht.getSonguoidukien());	
					kht_bus.sua(kht, kht.getMakht());
				}
			}
			
			try {
				d=ctkhtDAO.getIntance().Insert_SDDichVu(sddv);
				a=ctkhtDAO.getIntance().Insert_CTDV_An(dvan);
				b=ctkhtDAO.getIntance().Insert_CTDV_KS(dvks);
				c=ctkhtDAO.getIntance().Insert_CTDV_PT(dvpt);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			ctkhtDAO.getIntance().UpdateTongChiKHT(t.getMakht(),tongchi);
			CTKHT_ThucChiBUS.thucchiList.add(thucchiDTO);
			thucchiDAO.getIntance().Insert(thucchiDTO);
			
			ctdvAnList.add(dvan);
			ctdvKSList.add(dvks);
			ctdvPTList.add(dvpt);
			sddvList.add(sddv);
			if(a!=-1&&b!=-1&&c!=-1&&d!=-1) {
				return 5;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int sua(CTKHT_DTO t) {
		try {
			double tongchi=0;
			for(CTKHT_DTO m:ctkhtList) {
				if(m.getMakht().equals(t.getMakht())&& convertDateToString(m.getNgay()).equals(convertDateToString(t.getNgay()))) {
					m.copyCTKHT(t);
				}
			}
			
			for(CTKHT_DTO m:ctkhtList) {
				if(m.getMakht().equals(t.getMakht())) {
					tongchi=tongchi+m.getTongtien();
				}
			}
			
			for(KHTourDTO kht:KHToursBUS.khtList) {
				if(kht.getMakht().equals(t.getMakht())) {
					kht.setTongchi((long) tongchi);
					kht.setGiave((long)tongchi*130/100/kht.getSonguoidukien());
					kht_bus.sua(kht, kht.getMakht());
				}
			}
			
			CTDV_An_DTO dvan=new CTDV_An_DTO(t.getMakht(), t.getNgay(), t.getManh(), t.getThanhtienNH());
			CTDV_KS_DTO dvks=new CTDV_KS_DTO(t.getMakht(), t.getNgay(), t.getMaks(), t.getThanhtienKS());
			CTDV_PT_DTO dvpt=new CTDV_PT_DTO(t.getMakht(), t.getNgay(), t.getMapt(), t.getThanhtienPT());
			SdDichVuDTO sddv=new SdDichVuDTO(t.getMakht(), t.getNgay(), t.getTongtien());
			int a=ctkhtDAO.getIntance().update_SdDichVu(sddv);
			int b=ctkhtDAO.getIntance().update_CTDV_An(dvan);
			int c=ctkhtDAO.getIntance().update_CTDV_KS(dvks);
			int d=ctkhtDAO.getIntance().update_CTDV_PT(dvpt);
			
			
			ctkhtDAO.getIntance().UpdateTongChiKHT(t.getMakht(),tongchi);
			
			for(SdDichVuDTO m:sddvList) {
				if(m.getMakht().equals(sddv.getMakht())&&m.getNgay().equals(sddv.getNgay())) {
					m.copySDDV(sddv);
				}
			}
			for(CTDV_An_DTO m:ctdvAnList) {
				if(m.getMakht().equals(dvan.getMakht())&&m.getNgay().equals(dvan.getNgay())) {
					m.copyDVAn(dvan);
				}
			}
			for(CTDV_KS_DTO m:ctdvKSList) {
				if(m.getMakht().equals(dvks.getMakht())&&m.getNgay().equals(dvks.getNgay())) {
					m.copyDVKS(dvks);
				}
			}
			for(CTDV_PT_DTO m:ctdvPTList) {
				if(m.getMakht().equals(dvpt.getMakht())&&m.getNgay().equals(dvpt.getNgay())) {
					m.copyDVPT(dvpt);
				}
			}
			if(a!=-1&&b!=-1&&c!=-1&&d!=-1) {
				return 5;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int xoa(CTKHT_DTO t) {
		try {
			for(CTKHT_DTO p:ctkhtList) {
				if(p.getMakht().equals(t.getMakht())&&p.getNgay().equals(t.getNgay())) {
					ctkhtList.remove(p);
					break;
				}
			}
			CTDV_An_DTO dvan=new CTDV_An_DTO(t.getMakht(), t.getNgay(), t.getManh(), t.getThanhtienNH());
			CTDV_KS_DTO dvks=new CTDV_KS_DTO(t.getMakht(), t.getNgay(), t.getMaks(), t.getThanhtienKS());
			CTDV_PT_DTO dvpt=new CTDV_PT_DTO(t.getMakht(), t.getNgay(), t.getMapt(), t.getThanhtienPT());
			SdDichVuDTO sddv=new SdDichVuDTO(t.getMakht(), t.getNgay(), t.getTongtien());
			int b=ctkhtDAO.getIntance().delete_CTDV_An(dvan,t.getNgay());
			int c=ctkhtDAO.getIntance().delete_CTDV_KS(dvks,t.getNgay());
			int d=ctkhtDAO.getIntance().delete_CTDV_PT(dvpt,t.getNgay());
			int a=ctkhtDAO.getIntance().delete_SdDichVu(sddv,t.getNgay());
			sddvList.removeIf(dv -> dv.getMakht().equals(sddv.getMakht())&&dv.getNgay().equals(t.getNgay()));
			ctdvAnList.removeIf(an -> an.getMakht().equals(dvan.getMakht())&&an.getNgay().equals(t.getNgay()));
			ctdvKSList.removeIf(ks -> ks.getMakht().equals(dvks.getMakht())&&ks.getNgay().equals(t.getNgay()));
			ctdvPTList.removeIf(pt -> pt.getMakht().equals(dvpt.getMakht())&&pt.getNgay().equals(t.getNgay()));			
			if(a!=-1&&b!=-1&&c!=-1&&d!=-1) {
				return 5;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<CTKHT_DTO> timkiem(String cond,String condType){
		ArrayList<CTKHT_DTO> tmp=new ArrayList<CTKHT_DTO>();
		try {
			for(CTKHT_DTO ctkht:ctkhtList) {
				if(condType.equals("Mã Khách sạn")) {
					if(ctkht.getMaks().equals(cond)&&ctkht.getMakht().equals(KHTourGUI.makht_row)) {
						tmp.add(ctkht);
					}
				}
				else if(condType.equals("Mã Nhà hàng")) {
					if(ctkht.getManh().equals(cond)&&ctkht.getMakht().equals(KHTourGUI.makht_row)) {
						tmp.add(ctkht);
					}
				}
				else if(condType.equals("Mã Phương tiện")) {
					if(ctkht.getMapt().equals(cond)&&ctkht.getMakht().equals(KHTourGUI.makht_row)) {
						tmp.add(ctkht);
					}
				}
			}
			return tmp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String convertDateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }
	
	
	
	
	
	
	
	
	
}
