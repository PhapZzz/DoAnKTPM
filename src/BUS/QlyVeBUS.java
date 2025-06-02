package BUS;

import java.util.ArrayList;

import DAO.KHTourDAO;
import DAO.KhachHangDAO;
import DAO.QlyToursDAO;
import DAO.QlyVeDAO;
import DTO.CTKM_DTO;
import DTO.HoaDonDTO;
import DTO.KHTourDTO;
import DTO.KhachHangDTO;
import DTO.KhuyenMaiDTO;
import DTO.QlyToursDTO;
import DTO.VeDTO;

public class QlyVeBUS {
	public static ArrayList<CTKM_DTO> ctkmList=new ArrayList<CTKM_DTO>();
	public static ArrayList<VeDTO> veList=new ArrayList<VeDTO>();
	private ArrayList<KhachHangDTO> khachhang=new ArrayList<KhachHangDTO>();
	private ArrayList<VeDTO> ve=new ArrayList<VeDTO>();
	QlyVeDAO veDAO=new QlyVeDAO();
	KhachHangDAO khDAO=new KhachHangDAO();
	KHTourDAO khtDAO=new KHTourDAO();
	
	public boolean docCTKM(){
		try {
			ctkmList= veDAO.getIntance().selectAllCTKM();
			if(ctkmList!=null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean docDSVe(){
		try {
			veList= veDAO.getIntance().selectAllVe();
			if(veList!=null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int them(CTKM_DTO t) {
		try {
			ctkmList.add(t);
			return veDAO.getIntance().InsertCTKM(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public void ThemTTKhachHang(KhachHangDTO kh) {
		khachhang.add(kh);
	}
	public ArrayList<KhachHangDTO> GetListKH(){
		return khachhang;
	}
	
	public void ThemTTVe(VeDTO v) {
		ve.add(v);
	}
	public ArrayList<VeDTO> GetListVe(){
		return ve;
	}
	
	public boolean checkTinhTrangKM(String makm) {
		for(KhuyenMaiDTO km:KhuyenMaiBUS.kmDTO) {
			if(km.getMakm().equals(makm)&&km.getTinhtrang()==true) {
				return true;
			}
		}
		return false;
	}
	
	public void themKH() {
		try {
			for(KhachHangDTO kh:khachhang) {
				if(checkMakh(kh.getMakh())==false) {
					khDAO.getIntance().InsertKhachHang(kh);
					KhachHangBUS.khDTO.add(kh);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void themVe() {
		try {
			for(VeDTO v:ve) {
				veDAO.getIntance().InsertVe(v);
				veList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateSoCho(String makht,int socho) {
		for(KHTourDTO kht:KHToursBUS.khtList) {
			if(kht.getMakht().equals(makht)) {
				kht.setSonguoi(socho);
				khtDAO.updateKHT(kht, makht);
			}
		}	
	}
	public boolean checkMakh(String Makh) {
		for(KhachHangDTO kh:KhachHangBUS.khDTO) {
			if(kh.getMakh().equals(Makh)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
