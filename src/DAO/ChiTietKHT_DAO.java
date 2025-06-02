package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.CTDV_An_DTO;
import DTO.CTDV_KS_DTO;
import DTO.CTDV_PT_DTO;
import DTO.CTKHT_DTO;
import DTO.KHTourDTO;
import DTO.KhachSanDTO;
import DTO.NhaHangDTO;
import DTO.PhuongTienDTO;
import DTO.SdDichVuDTO;
import Util.JDBCUtil;

public class ChiTietKHT_DAO {
	public static ChiTietKHT_DAO getIntance() {
		return new ChiTietKHT_DAO();
	}
	
	public ArrayList<SdDichVuDTO> selectAll_SdDichVu() {
		ArrayList<SdDichVuDTO> ketQua=new ArrayList<SdDichVuDTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM sddichvu";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String makht=rs.getString("makht");
				Date ngay=rs.getDate("ngay");
				double thanhtientheongay=rs.getDouble("thanhtientheongay");
				SdDichVuDTO dv = new SdDichVuDTO(makht, ngay, thanhtientheongay);
				ketQua.add(dv);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
	
	public ArrayList<CTDV_An_DTO> selectAll_CTDV_An() {
		ArrayList<CTDV_An_DTO> ketQua=new ArrayList<CTDV_An_DTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM ctdv_an";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String makht=rs.getString("makht");
				Date ngay=rs.getDate("ngay");
				String manh=rs.getString("manh");
				double thanhtien=rs.getDouble("thanhtien");
				CTDV_An_DTO nh = new CTDV_An_DTO(makht, ngay, manh,thanhtien);
				ketQua.add(nh);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
	
	public ArrayList<CTDV_KS_DTO> selectAll_CTDV_KS() {
		ArrayList<CTDV_KS_DTO> ketQua=new ArrayList<CTDV_KS_DTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM ctdv_ks";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String makht=rs.getString("makht");
				Date ngay=rs.getDate("ngay");
				String maks=rs.getString("maks");
				double thanhtien=rs.getDouble("thanhtien");
				CTDV_KS_DTO ks = new CTDV_KS_DTO(makht, ngay, maks, thanhtien);
				ketQua.add(ks);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
	
	public ArrayList<CTDV_PT_DTO> selectAll_CTDV_PT() {
		ArrayList<CTDV_PT_DTO> ketQua=new ArrayList<CTDV_PT_DTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM ctdv_pt";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String makht=rs.getString("makht");
				Date ngay=rs.getDate("ngay");
				String mapt=rs.getString("mapt");
				double thanhtien=rs.getDouble("thanhtien");
				CTDV_PT_DTO ks = new CTDV_PT_DTO(makht, ngay, mapt, thanhtien);
				ketQua.add(ks);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}

	public int Insert_SDDichVu(SdDichVuDTO dv) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO sddichvu (makht, ngay, thanhtientheongay) VALUES ('"
		            + dv.getMakht() + "' , '" + dv.getNgay() + "' , " + dv.getThanhtientheongay() + ")";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public int Insert_CTDV_An(CTDV_An_DTO nh) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO ctdv_an (makht,ngay, manh, thanhtien) VALUES ('"
		            + nh.getMakht() + "' , '" + nh.getNgay() + "' , '" +nh.getManh() + "' , " + nh.getThanhtien() + ")";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public int Insert_CTDV_KS(CTDV_KS_DTO ks) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO ctdv_ks (makht,ngay, maks, thanhtien) VALUES ('"
		            + ks.getMakht() + "' , '" + ks.getNgay() + "' , '" +ks.getMaks() + "' , " + ks.getThanhtien() + ")";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public int Insert_CTDV_PT(CTDV_PT_DTO pt) {
		int kq = 0;
		// ket noi
		try {
			Connection con = JDBCUtil.getConnection();
			//tao statement
			java.sql.Statement st = con.createStatement();
			//truy van
			String sql = "INSERT INTO ctdv_pt (makht,ngay, mapt, thanhtien) VALUES ('"
		            + pt.getMakht() + "' , '" + pt.getNgay() + "' , '" +pt.getMapt() + "' , " + pt.getThanhtien() + ")";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public int delete_SdDichVu(SdDichVuDTO t,Date ngay) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM sddichvu WHERE makht = '" + t.getMakht() + "' AND ngay='"+ngay+"';";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return kq;
	}
	public int delete_CTDV_An(CTDV_An_DTO t,Date ngay) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM ctdv_an WHERE makht = '" + t.getMakht() + "' AND ngay='"+ngay+"';";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return kq;
	}
	public int delete_CTDV_KS(CTDV_KS_DTO t,Date ngay) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM ctdv_ks WHERE makht = '" + t.getMakht() + "' AND ngay='"+ngay+"';";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return kq;
	}
	public int delete_CTDV_PT(CTDV_PT_DTO t,Date ngay) {
		int kq = 0;
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM ctdv_pt WHERE makht = '" + t.getMakht() + "' AND ngay='"+ngay+"';";
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi: " + kq);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return kq;
	}
	
	public int UpdateTongChiKHT(String makht,double tongchi) {
		int ketQua = -1;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql ="UPDATE kehoachtour SET tongchi=" + tongchi + " WHERE makht='" + makht +"';";
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			// Bước 4:Xử lý kết quả trả về
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi la: " + ketQua);
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public int update_SdDichVu(SdDichVuDTO t) {
		int ketQua = -1;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql ="UPDATE sddichvu SET makht='" + t.getMakht() + "',ngay='"+ t.getNgay() + "',thanhtientheongay="
					+t.getThanhtientheongay()+" WHERE makht='" + t.getMakht() + "' AND ngay='"+t.getNgay()+"';";
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			// Bước 4:Xử lý kết quả trả về
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi la: " + ketQua);
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public int update_CTDV_An(CTDV_An_DTO t) {
		int ketQua = -1;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql ="UPDATE ctdv_an SET makht='" + t.getMakht() + "',ngay='"+ t.getNgay() + "',manh='"+t.getManh()
			+ "',thanhtien="+t.getThanhtien()+" WHERE makht='" + t.getMakht() + "' AND ngay='"+t.getNgay()+"';";
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			// Bước 4:Xử lý kết quả trả về
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi la: " + ketQua);
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	
	public int update_CTDV_KS(CTDV_KS_DTO t) {
		int ketQua = -1;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql ="UPDATE ctdv_ks SET makht='" + t.getMakht() + "',ngay='"+ t.getNgay() + "',maks='"+t.getMaks()
			+ "',thanhtien="+t.getThanhtien()+" WHERE makht='" + t.getMakht() + "' AND ngay='"+t.getNgay()+"';";
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			// Bước 4:Xử lý kết quả trả về
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi la: " + ketQua);
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public int update_CTDV_PT(CTDV_PT_DTO t) {
		int ketQua = -1;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql ="UPDATE ctdv_pt SET makht='" + t.getMakht() + "',ngay='"+ t.getNgay() + "',mapt='"+t.getMapt()
			+ "',thanhtien="+t.getThanhtien()+" WHERE makht='" + t.getMakht() + "' AND ngay='"+t.getNgay()+"';";
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			// Bước 4:Xử lý kết quả trả về
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi la: " + ketQua);
			// Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
}
