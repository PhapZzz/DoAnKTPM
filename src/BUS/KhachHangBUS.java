package BUS;

import java.sql.Date;
import java.text.Normalizer;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;

public class KhachHangBUS {
    public static  ArrayList<KhachHangDTO> khDTO=new ArrayList<KhachHangDTO>();
	public KhachHangBUS() {
		// TODO Auto-generated constructor stub
	}
public boolean docKH() {
	try {
		
		khDTO = KhachHangDAO.getIntance().selectAll();
		return true;
//		if(khDTO != null) return true;
//		else {
//			System.out.println("Du lieu rong");
//			return false;
//		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
	}
	
}

public int xoaKh(KhachHangDTO kh) {
    try {
        // Thực hiện xóa từ cơ sở dữ liệu
        int rowsAffected = KhachHangDAO.getIntance().deleteKhachHang(kh);
        
        // Nếu xóa từ cơ sở dữ liệu thành công, cập nhật danh sách
        if (rowsAffected > 0) {
            khDTO.removeIf(v -> v.getMakh().equals(kh.getMakh()));
        } else {
            // Xử lý trường hợp xóa từ cơ sở dữ liệu không thành công
            // Có thể thông báo lỗi hoặc thực hiện hành động phù hợp khác
            System.out.println("Xóa từ cơ sở dữ liệu không thành công");
        }

        return rowsAffected;
    } catch (Exception e) {
        // Xử lý ngoại lệ một cách cẩn thận
        // Có thể thông báo lỗi hoặc thực hiện hành động phù hợp khác
        e.printStackTrace();
        return -1;
    }
}

public int suaKh(KhachHangDTO kh) {
	try {
		
		for(KhachHangDTO t : khDTO) {
			System.out.println(t.getMakh() + kh.getMakh());
			if(t.getMakh().equalsIgnoreCase(kh.getMakh())) {
				t.copyKhachhang(kh);;
				return KhachHangDAO.getIntance().upDateKhachHang(t);
			}
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return -1;
}

public ArrayList<KhachHangDTO> timKiem(String condition, String type){

ArrayList<KhachHangDTO> tmp = new ArrayList<KhachHangDTO>();
try {
	if(type.equalsIgnoreCase("Mã số")) {
		for(KhachHangDTO kh : khDTO) {
			if(kh.getMakh().equalsIgnoreCase(condition)) {
				tmp.add(kh);
			}
		}
	}
	else if(type.equalsIgnoreCase("Họ Tên")) {
		condition = KiemTra.getInstance().formatchString(condition);
		for(KhachHangDTO kh : khDTO) {
			String name = (kh.getHokh().concat(" ").concat(kh.getTenkh())).toLowerCase();
			if(name.contains(condition)) {
				tmp.add(kh);
			}
		}
	}
	else if(type.equalsIgnoreCase("Tên")) {
		condition = KiemTra.getInstance().formatchString(condition);
		for(KhachHangDTO kh : khDTO) {
			String name = kh.getTenkh().toLowerCase();
			if(name.contains(condition)) {
				tmp.add(kh);
			}
		}
	}
	

} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
return tmp;
}
//Hàm loại bỏ dấu trong chuỗi
	
}
