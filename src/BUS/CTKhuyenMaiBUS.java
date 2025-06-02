package BUS;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAO.CTKhuyenMaiDAO;
import DAO.KhuyenMaiDAO;
import DTO.CTKhuyenMaiDTO;
import DTO.KhuyenMaiDTO;
public class CTKhuyenMaiBUS {
public static ArrayList<CTKhuyenMaiDTO> ctkmDTO;
	
	public boolean docCTKM(){
		try {
			ctkmDTO= CTKhuyenMaiDAO.getIntance().selectAll();
			if(ctkmDTO!=null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int themCTKM(CTKhuyenMaiDTO km) {
		try {
			for(CTKhuyenMaiDTO ctkm: ctkmDTO) {
				if(km.getMakm().equalsIgnoreCase(ctkm.getMakm()) && km.getMatour().equalsIgnoreCase(ctkm.getMatour())) {
					JOptionPane.showMessageDialog(null, "Mã " + km.getMatour() +" đã tồn tại ở " + km.getMakm());
					return -1;
				}
			}
				ctkmDTO.add(km);
			return CTKhuyenMaiDAO.getIntance().InsertCTKhuyenMai(km);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public int xoaCTKM(CTKhuyenMaiDTO km) {
		try {
			ctkmDTO.removeIf(v -> v.getMakm().equalsIgnoreCase(km.getMakm()) && v.getMatour().equalsIgnoreCase(km.getMatour()));
			return CTKhuyenMaiDAO.getIntance().deleteCTKhuyenMai(km);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
}
