package BUS;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import DAO.DichVuDAO;
import DAO.NhanVienDAO;
import DTO.DichVuDTO;
import DTO.KhachSanDTO;
import DTO.NhaHangDTO;
import DTO.NhanVienDTO;
import DTO.PhuongTienDTO;
public class DichVuBUS {
	public static ArrayList<NhaHangDTO> nhDTO;
	public static ArrayList<KhachSanDTO> ksDTO;
	public static ArrayList<PhuongTienDTO> ptDTO;
	public boolean docNH() {
		try {
			nhDTO = DichVuDAO.getIntance().selectAll_NhaHang();
			if(nhDTO != null) return true;
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
	
	public boolean docKS() {
		try {
			ksDTO = DichVuDAO.getIntance().selectAll_KhachSan();
			if(ksDTO != null) return true;
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
	
	public boolean docPT() {
		try {
			ptDTO = DichVuDAO.getIntance().selectAll_PhuongTien();
			if(ptDTO != null) return true;
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
	
	public String TaoMaKhachSan() {
		try {
			return DichVuDAO.getIntance().TaoMaKhachSan();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String TaoMaNhaHang() {
		try {
			return DichVuDAO.getIntance().TaoMaNhaHang();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String TaoMaPhuongTien() {
		try {
			return DichVuDAO.getIntance().TaoMaPhuongTien();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int themDV(DichVuDTO dv) {
		try {
			if(KiemTra.getInstance().loaiDV(dv.getMaso()).equalsIgnoreCase("Khách sạn"))
			{
				for(KhachSanDTO v: ksDTO) {
					if(v.getMaso().equalsIgnoreCase(dv.getMaso())) {
						JOptionPane.showMessageDialog(null, "Mã dịch vụ " + dv.getMaso() +" đã tồn tại");
						return -1;
					}
				}
				ksDTO.add((KhachSanDTO) dv);
				return DichVuDAO.getIntance().InsertKhanhSan((KhachSanDTO) dv);
			}
			if(KiemTra.getInstance().loaiDV(dv.getMaso()).equalsIgnoreCase("Nhà hàng"))
			{
				for(NhaHangDTO v: nhDTO) {
					if(v.getMaso().equalsIgnoreCase(dv.getMaso())) {
						JOptionPane.showMessageDialog(null, "Mã dịch vụ " + dv.getMaso() +" đã tồn tại");
						return -1;
					}
				}
				nhDTO.add((NhaHangDTO) dv);
				return DichVuDAO.getIntance().InsertNhaHang((NhaHangDTO)dv);
			}
			if(KiemTra.getInstance().loaiDV(dv.getMaso()).equalsIgnoreCase("Phương tiện"))
			{
				for(PhuongTienDTO v: ptDTO) {
					if(v.getMaso().equalsIgnoreCase(dv.getMaso())) {
						JOptionPane.showMessageDialog(null, "Mã dịch vụ " + dv.getMaso() +" đã tồn tại");
						return -1;
					}
				}
				PhuongTienDTO dvpt = (PhuongTienDTO) dv;
				ptDTO.add(dvpt);
				return DichVuDAO.getIntance().InsertPhuongTien(dvpt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public int xoaDV(DichVuDTO dv) {
		try {
			if(KiemTra.getInstance().loaiDV(dv.getMaso()).equalsIgnoreCase("Khách sạn"))
			{
				ksDTO.removeIf(v -> v.getMaso().equals(dv.getMaso()));
				return DichVuDAO.getIntance().deleteDichVu((KhachSanDTO)dv);
			}
			if(KiemTra.getInstance().loaiDV(dv.getMaso()).equalsIgnoreCase("Nhà Hàng"))
			{
				nhDTO.removeIf(v -> v.getMaso().equals(dv.getMaso()));
				return DichVuDAO.getIntance().deleteDichVu((NhaHangDTO)dv);
			}
			if(KiemTra.getInstance().loaiDV(dv.getMaso()).equalsIgnoreCase("Phương Tiện"))
			{
				ptDTO.removeIf(v -> v.getMaso().equals(dv.getMaso()));
				return DichVuDAO.getIntance().deleteDichVu((PhuongTienDTO)dv);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public int suaDV(DichVuDTO dv) {
		try {
			if(KiemTra.getInstance().loaiDV(dv.getMaso()).equalsIgnoreCase("Khách sạn"))
			{
				for(DichVuDTO t : ksDTO) {
					if(t.getMaso().equalsIgnoreCase(dv.getMaso())) {
						t.copyDichVu(dv);
						return DichVuDAO.getIntance().upDateDichVu((KhachSanDTO) t);
					}
				}
			}
			if(KiemTra.getInstance().loaiDV(dv.getMaso()).equalsIgnoreCase("Phương Tiện"))
			{
				for(DichVuDTO t : ptDTO) {
					if(t.getMaso().equalsIgnoreCase(dv.getMaso())) {
						t.copyDichVu(dv);
						System.out.println(t);
						return DichVuDAO.getIntance().upDateDichVu((PhuongTienDTO) t);
					}
				}
			}
			if(KiemTra.getInstance().loaiDV(dv.getMaso()).equalsIgnoreCase("Nhà Hàng"))
			{
				for(DichVuDTO t : nhDTO) {
					if(t.getMaso().equalsIgnoreCase(dv.getMaso())) {
						t.copyDichVu(dv);
						
						return DichVuDAO.getIntance().upDateDichVu((NhaHangDTO) t);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<DichVuDTO> timKiem(String condition, String type){
		ArrayList<DichVuDTO> tmp = new ArrayList<>();
		try {
			if(type.equalsIgnoreCase("Mã Dịch Vụ") && KiemTra.getInstance().loaiDV(condition) != null) {
				if(KiemTra.getInstance().loaiDV(condition).equalsIgnoreCase("Khách sạn")) {
					for(DichVuDTO t : ksDTO) {
						if(t.getMaso().equalsIgnoreCase(condition)) {
							tmp.add(t);
						}
					}
				}else if(KiemTra.getInstance().loaiDV(condition).equalsIgnoreCase("Nhà Hàng")) {
					for(DichVuDTO t : nhDTO) {
						if(t.getMaso().equalsIgnoreCase(condition))
							tmp.add(t);
					}
				}else if(KiemTra.getInstance().loaiDV(condition).equalsIgnoreCase("Phương Tiện")) {
					for(DichVuDTO t : ptDTO) {
						if(t.getMaso().equalsIgnoreCase(condition))
							tmp.add(t);
					}
				}
			}
			else if(type.equalsIgnoreCase("Loại Dịch Vụ")) {
				if(condition.equalsIgnoreCase("Khách sạn")) {
					tmp.addAll(ksDTO);
				}else if(condition.equalsIgnoreCase("Nhà Hàng")) {
					tmp.addAll(nhDTO);
				}else if(condition.equalsIgnoreCase("Phương Tiện")) {
					tmp.addAll(ptDTO);
				}
			}else if(type.equalsIgnoreCase("Tên Dịch Vụ")){
				for(DichVuDTO t : nhDTO) {
					if(t.getTendv().toLowerCase().contains(condition.toLowerCase()))
					{
						tmp.add(t);
					}
				}
				for(DichVuDTO t : ksDTO) {
					if(t.getTendv().toLowerCase().contains(condition.toLowerCase()))
					{
						tmp.add(t);
					}
				}
				for(DichVuDTO t : ptDTO) {
					if(t.getTendv().toLowerCase().contains(condition.toLowerCase()))
					{
						tmp.add(t);
					}
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return tmp;
	}


	
	
	
	
	
}
