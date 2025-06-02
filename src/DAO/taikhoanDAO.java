package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.NhanVienDTO;
import DTO.taikhoanDTO;
import Util.JDBCUtil;

public class taikhoanDAO {
	public static taikhoanDAO getIntance() {
		return new taikhoanDAO();
	}
	
	public ArrayList<taikhoanDTO> selectAll() {
		ArrayList<taikhoanDTO> ketQua=new ArrayList<taikhoanDTO>();

		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM taikhoan";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String user=rs.getString("user_name");
				String passs=rs.getString("PassWord");
				taikhoanDTO tk = new taikhoanDTO(user, passs);
				ketQua.add(tk);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
	
	public String getInfo(String user_name) {
		String user="";
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT honv,tennv FROM nhanvien nv INNER JOIN taikhoan tk ON nv.manv = tk.user_name where nv.manv = '" + user_name + "'";
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next())
				user=rs.getString("honv")+ " " +rs.getString("tennv");
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return user;
	}
	public int change_Info(taikhoanDTO tk) {
		int kq = 0;
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="UPDATE taikhoan SET PassWord = '" + tk.getPass() + "' WHERE user_name = '" + tk.getUser()+"'" ;
			//Bước 4:Xử lý kết quả trả về
			kq = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi: " + kq);
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}	
		return kq;
	}
	public NhanVienDTO getInfo_NhanVien(String user_maso) {
		NhanVienDTO nv = null;
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM nhanvien nv INNER JOIN taikhoan tk ON nv.manv = tk.user_name where nv.manv = '" + user_maso + "'";
//			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()) {
				String manv=rs.getString("manv");
				String honv=rs.getString("honv");
				String tennv=rs.getString("tennv");
				String sdt=rs.getString("sdt");
				Boolean gioitinh=rs.getBoolean("gioitinh");
				String cmnd=rs.getString("cmnd");
				Date ngayvl=rs.getDate("ngayvl");
				Date ngaysinh=rs.getDate("ngaysinh");
				nv= new NhanVienDTO(manv, honv, tennv, sdt, cmnd, ngayvl,ngaysinh, gioitinh);
			}
				
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return nv;
	}
}
