package BUS;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.KhuyenMaiDAO;
import DAO.NhanVienDAO;
import DTO.KhuyenMaiDTO;
import DTO.NhanVienDTO;


public class KhuyenMaiBUS {
	public static ArrayList<KhuyenMaiDTO> kmDTO;
	public boolean docKM() {
		try {
			kmDTO = KhuyenMaiDAO.getIntance().selectAll();
			if(kmDTO != null) return true;
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
	
	
	public String TaoMaKM() {
		try {
			return KhuyenMaiDAO.getIntance().TaoKhuyenMai();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int themKM(KhuyenMaiDTO km) {
		try {
			for(KhuyenMaiDTO k: kmDTO) {
				if(km.getMakm().equalsIgnoreCase(k.getMakm())) {
					JOptionPane.showMessageDialog(null, "Mã khuyến mãi " + km.getMakm() +" đã tồn tại");
					return -1;
				}
			}
				kmDTO.add(km);
			return KhuyenMaiDAO.getIntance().InsertKhuyenMai(km);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public int suaKM(KhuyenMaiDTO km) {
		try {
			for(KhuyenMaiDTO k : kmDTO) {
				if(km.getMakm().equalsIgnoreCase(k.getMakm())) {
					k.copyKM(km);
					return KhuyenMaiDAO.getIntance().upDateKhuyenMai(k);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return -1;
	}
	
	public int xoaKM(KhuyenMaiDTO km) {
		try {
			kmDTO.removeIf(v -> v.getMakm().equalsIgnoreCase(km.getMakm()));
			return KhuyenMaiDAO.getIntance().deleteKhuyenMai(km);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<KhuyenMaiDTO> timKiem(String condition, String type){
		ArrayList<KhuyenMaiDTO> tmp = new ArrayList<KhuyenMaiDTO>();
		try {
			if(type.equalsIgnoreCase("Mã Khuyến mãi")) {
				for(KhuyenMaiDTO km : kmDTO) {
					if(km.getMakm().equalsIgnoreCase(condition)) {
						tmp.add(km);
					}
				}
			}
			else if(type.equalsIgnoreCase("Tên Chương trình")) {
				condition = KiemTra.getInstance().formatchString(condition);
				for(KhuyenMaiDTO km : kmDTO) {
					if(km.getTectkm().contains(condition)) {
						tmp.add(km);
					}
				}
			}
			else if(type.equalsIgnoreCase("Tình trạng")) {
				condition = KiemTra.getInstance().formatchString(condition);
				if(condition.equalsIgnoreCase("Còn hiệu lực"))
				{
					for(KhuyenMaiDTO km : kmDTO) {
						if(km.getTinhtrang()) {
							tmp.add(km);
						}
					}
				}else if(condition.equalsIgnoreCase("Hết hiệu lực"))
				{
					for(KhuyenMaiDTO km : kmDTO) {
						if(!km.getTinhtrang()) {
							tmp.add(km);
						}
					}
				}
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tmp;
	}
}
