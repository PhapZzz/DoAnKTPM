package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.KHTourDTO;
import DTO.QlyToursDTO;
import Util.JDBCUtil;

public class KHTourDAO {
	public KHTourDAO getIntance() {
		return new KHTourDAO();
	}
	public ArrayList<KHTourDTO> selectAll() {
		ArrayList<KHTourDTO> ketqua=new ArrayList<KHTourDTO>();
		try {
			Connection con=JDBCUtil.getConnection();
			Statement st=con.createStatement();
			String sql="select * from kehoachtour where tinhtrang = 1 order by giave";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String makht=rs.getString("makht");
				String matour=rs.getString("matour");
				String mota=rs.getString("mota");
				Date ngaydi=rs.getDate("ngaydi");
				Date ngayve=rs.getDate("ngayve");
				int songuoi=rs.getInt("songuoi");
				long giave=rs.getLong("giave");
				String huongdanvien=rs.getString("huongdanvien");
				long tongchi=rs.getLong("tongchi");
				String anh1=rs.getString("anh1");
				String anh2=rs.getString("anh2");
				String anh3=rs.getString("anh3");
				int songuoidukien=rs.getInt("soluong");
				long thucchi=rs.getLong("thucchi");
				KHTourDTO kht=new KHTourDTO(makht, matour, mota, huongdanvien, anh1, anh2, anh3, 
						ngaydi, ngayve, songuoi, tongchi, giave,thucchi,songuoidukien);
				ketqua.add(kht);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	
	
	
	public String TaoMaKHT() {
		String ketQua = null;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "SELECT IFNULL(MAX(id)+1,1) as id FROM kehoachtour";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			// Bước 4:Xử lý kết quả trả về
			while (rs.next()) {
				String id = rs.getString("id");
				ketQua = "kht".concat(id);
			}
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
	
	public int InsertKHT(KHTourDTO t) {
		int ketQua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			Statement st=con.createStatement();
			String sql="INSERT INTO kehoachtour (makht,matour,mota,ngaydi,ngayve,songuoi,giave,huongdanvien,"
					+ "tongchi,anh1,anh2,anh3,soluong,thucchi,tinhtrang)"+" VALUES ('"+t.getMakht()+"','"+t.getMatour()+"','"+t.getMota()+"','"+t.getNgaydi()+"','"
					+t.getNgayve()+"',"+t.getSonguoi()+","+t.getGiaVe()+",'"+t.getHuongdanvien()+"',"+t.getTongchi()+",'"+t.getAnh1()+"','"
					+t.getAnh2()+"','"+t.getAnh3()+ "',"+t.getSonguoidukien()+","+t.getThucchi()+","+ 1 +")";
			System.out.println(sql);
			ketQua=st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi la: " + ketQua);
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public int updateKHT(KHTourDTO t,String MaKHT_Bandau) {
		int ketQua = -1;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "UPDATE kehoachtour" + " SET makht='" + t.getMakht() + "',matour='" + t.getMatour() + "',mota='" 
			+ t.getMota()+ "',ngaydi='" + t.getNgaydi()+ "',ngayve='" + t.getNgayve()+ "',songuoi=" + t.getSonguoi()
			+ ",giave=" + t.getGiaVe()+ ",huongdanvien='" + t.getHuongdanvien()+ "',tongchi='" + t.getTongchi()+ "',anh1='" + t.getAnh1()
			+ "',anh2='" + t.getAnh2()+ "',anh3='" + t.getAnh3()+"',soluong="+t.getSonguoidukien()+ ",thucchi=" + t.getThucchi()+" WHERE makht='"+MaKHT_Bandau+"';";
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
	
	public int delete(KHTourDTO t) {
		int ketQua = 0;
		try {
			// Bước 1:Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			// Bước 2:Tạo đối tượng statement
			java.sql.Statement st = con.createStatement();
			// Bước 3:Thực thi statement
			String sql = "UPDATE kehoachtour SET tinhtrang = 0 WHERE makht='" + t.getMakht() + "';";
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

//	public int delete(KHTourDTO t) {
//		int ketQua = 0;
//		try {
//			// Bước 1:Tạo kết nối
//			Connection con = JDBCUtil.getConnection();
//			// Bước 2:Tạo đối tượng statement
//			java.sql.Statement st = con.createStatement();
//			// Bước 3:Thực thi statement
//			String sql = "DELETE FROM kehoachtour WHERE makht='" + t.getMakht() + "';";
//			ketQua = st.executeUpdate(sql);
//			// Bước 4:Xử lý kết quả trả về
//			System.out.println("Ban da thuc thi: " + sql);
//			System.out.println("So dong thay doi la: " + ketQua);
//			// Bước 5:Ngắt kết nối
//			JDBCUtil.closeConnection(con);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return ketQua;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
