package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NhanVienBUS {
	public NhanVienDAO nvDAO = new NhanVienDAO();
	public static ArrayList<NhanVienDTO> nvDTO;
	public boolean docNV() {
		try {
			nvDTO = NhanVienDAO.getIntance().selectAll();
			if(nvDTO != null) return true;
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
	
	public int themDSNV(ArrayList<NhanVienDTO> listNV) {
		try {
			for(NhanVienDTO v: nvDTO) {
				for(NhanVienDTO t: listNV) {
					if(v.getManv().equals(t.getManv())) {
						JOptionPane.showMessageDialog(null, "Mã nhân viên " + t.getManv() +" đã tồn tại");
						return -1;
					}
				}
			} 
			nvDTO.addAll(listNV);
			return NhanVienDAO.getIntance().Insert_DSNhanVien(listNV);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public int themNV(NhanVienDTO nv) {
		// Validate 
		if (!checkValidate(nv.getManv(), nv.getHonv(), nv.getTennv(), nv.getSdt(), nv.getCmnd(), nv.getNgayvl(), nv.getNgaysinh())) {
			return -1;
		}

		try {
			for(NhanVienDTO v: nvDTO) {
				if(v.getManv().equals(nv.getManv())) {
					JOptionPane.showMessageDialog(null, "Mã nhân viên " + nv.getManv() +" đã tồn tại");
					return -1;
				}
			}
				nvDTO.add(nv);
			return NhanVienDAO.getIntance().InsertNhanVien(nv);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public int xoaNV(NhanVienDTO nv) {
		try {
			nvDTO.removeIf(v -> v.getManv().equals(nv.getManv()));
			return NhanVienDAO.getIntance().deleteNhanVien(nv);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	public int suaNV(NhanVienDTO nv) {
		// Validate 
		if (!checkValidate(nv.getManv(), nv.getHonv(), nv.getTennv(), nv.getSdt(), nv.getCmnd(), nv.getNgayvl(), nv.getNgaysinh())) {
			return -1;
		}

		try {
			for(NhanVienDTO t : nvDTO) {
				if(t.getManv().equals(nv.getManv())) {
					t.copyNhanVien(nv);
					return NhanVienDAO.getIntance().upDateNhanVien(t);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public NhanVienDTO getById(String id) {
		return nvDAO.getById(id);
	}

	public ArrayList<NhanVienDTO> timKiem(String condition, String type) {
    docNV();
    ArrayList<NhanVienDTO> tmp = new ArrayList<>();
    try {
        if (type.equalsIgnoreCase("Mã số")) {
            for (NhanVienDTO nv : nvDTO) {
                if (nv.getManv().contains(condition)) {
                    tmp.add(nv);
                }
            }
        } else if (type.equalsIgnoreCase("Họ Tên")) {
            String formatted = condition.toLowerCase();
            for (NhanVienDTO nv : nvDTO) {
                String name = (nv.getHonv() + " " + nv.getTennv()).toLowerCase();
                if (name.contains(formatted)) {
                    tmp.add(nv);
                }
            }
        } else if (type.equalsIgnoreCase("Tên")) {
            String nameCondition = condition.toLowerCase();
            for (NhanVienDTO nv : nvDTO) {
                String name = nv.getTennv().toLowerCase();
                if (name.contains(nameCondition)) {
                    tmp.add(nv);
                }
            }
        } else if (type.equalsIgnoreCase("Ngày vào làm")) {
            if (KiemTra.getInstance().forMatchDate(condition)) {
                for (NhanVienDTO nv : nvDTO) {
                    if (nv.getNgayvl().toString().contains(condition)) {
                        tmp.add(nv);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Định dạng đúng: YYYY-MM-DD");
                return null;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return tmp;
}


    public int getEmployeeNumber() {
		nvDTO = NhanVienDAO.getIntance().selectAll();
        return nvDTO.size();
    }

	public boolean checkValidate(String id, String honv, String tennv, String sdt, String cmnd, java.util.Date ngayvl, java.util.Date ngaysinh) {
		if (honv.equals("") || tennv.equals("") || sdt.equals("") || cmnd.equals("") || ngayvl == null || ngaysinh == null) {
			return false;
		}
//		if (honv.length() > 255 || tennv.length() > 255) {
//			JOptionPane.showMessageDialog(null, "Độ dài họ đệm và tên phải ít hơn 256 ký tự");
//			return false;
//		}
//		if (!sdt.matches("^(02|03|05|07|08|09)\\d{8}$")) {
//			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
//			return false;
//		}
//		if (checkDuplicatePhoneNumber(sdt, id) == false) {
//			JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại");
//			return false;
//		}
//		if (!cmnd.matches("/^0d{11}$/")) {
//			JOptionPane.showMessageDialog(null, "CMND không hợp lệ");
//			return false;
//		}
//		if (checkDuplicateCMND(cmnd, id) == false) {
//			JOptionPane.showMessageDialog(null, "CMND đã tồn tại");
//			return false;
//		}
//		if (System.currentTimeMillis() - ngaysinh.getTime() < 18L * 365 * 24 * 60 * 60 * 1000) {
//			JOptionPane.showMessageDialog(null, "Nhân viên phải từ 18 tuổi trở lên");
//			return false;
//		}
//		if (ngayvl.before(new Date(System.currentTimeMillis()))) {
//			JOptionPane.showMessageDialog(null, "Ngày vào làm không được trước ngày sinh");
//			return false;
//		}

		if (honv.length() > 255 || tennv.length() > 255) {
			return false;
		}
		if (!sdt.matches("^(02|03|05|07|08|09)\\d{8}$")) {
			return false;
		}
		if (checkDuplicatePhoneNumber(sdt, id) == false) {
			return false;
		}
		if (!cmnd.matches("^(0)\\d{11}$")) {
			return false;
		}
		if (checkDuplicateCMND(cmnd, id) == false) {
			return false;
		}
		if (System.currentTimeMillis() - ngaysinh.getTime() < 18L * 365 * 24 * 60 * 60 * 1000) {
			return false;
		}
		if (ngayvl.after(new Date(System.currentTimeMillis()))) {
			return false;
		}
		if (ngayvl.before(ngaysinh)) {
			return false;
		}
		return true;
	}

	public boolean checkDuplicatePhoneNumber(String sdt, String id) {
		for (NhanVienDTO nv : nvDTO) {
			if (nv.getSdt().equals(sdt) && !nv.getManv().equals(id)) {
				System.out.println("Trung voi ma nv" + nv.getManv());
				return false;
			}
		}
		return true;
	}

	public boolean checkDuplicateCMND(String cmnd, String id) {
		for (NhanVienDTO nv : nvDTO) {
			if (nv.getCmnd().equals(cmnd) && !nv.getManv().equals(id)) {
				System.out.println("Trung voi ma nv" + nv.getManv());
				return false;
			}
		}
		return true;
	}
}
