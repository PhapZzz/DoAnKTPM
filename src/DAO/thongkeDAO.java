package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.HoaDonDTO;
import DTO.thongkeDTO;
import Util.JDBCUtil;

public class thongkeDAO {
	public static thongkeDAO getIntance() {
		return new thongkeDAO();
	}
	public int getLuotKhach(String year) {
		int quantity = 0;
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT COUNT(v.mave) as quatity "
					+ "FROM ve v "
					+ "LEFT JOIN kehoachtour kht ON v.makht = kht.makht "
					+ "LEFT JOIN hoadon hd ON v.mahd = hd.mahd " 
					+ "WHERE YEAR(hd.ngaytao) = '" +year+ "' AND kht.ngayve <= now()";
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				quantity = rs.getInt("quatity");
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantity;
	}
	
	public double getDoanhThu(String year) {
		double total = 0;
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT SUM(v.giave*(100-km.phantram)/100) as total"
					+ " FROM ve v"
					+ " LEFT JOIN kehoachtour kht ON v.makht = kht.makht"
					+ " LEFT JOIN khuyenmai km ON km.makm = v.makm"
					+ " LEFT JOIN hoadon hd ON v.mahd = hd.mahd"
					+ " WHERE kht.ngayve <= now() AND YEAR(hd.ngaytao) = '" +year+ "'";
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				total = rs.getDouble("total");
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public ArrayList<HoaDonDTO> getTK_NV(String year) {
		ArrayList<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
		double total = 0;
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT SUM(v.giave*(100-km.phantram)/100) as total, hd.manv"
					+ " FROM ve v"
					+ " LEFT JOIN kehoachtour kht ON v.makht = kht.makht"
					+ " LEFT JOIN khuyenmai km ON km.makm = v.makm "
					+ " LEFT JOIN hoadon hd ON hd.mahd = v.mahd"
					+ " WHERE kht.ngayve <= now() AND YEAR(hd.ngaytao) = '" +year+ "'"
					+ " GROUP BY hd.manv ORDER BY total DESC";
//			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				total = rs.getDouble("total");
				String manv = rs.getString("hd.manv");
				HoaDonDTO hd = new HoaDonDTO(null,manv , null, null, total,0);
				list.add(hd);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//chi tiet
	public ArrayList<thongkeDTO> getTk_tours_thu(String year){
		ArrayList<thongkeDTO> list = new ArrayList<>();
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT kht.makht, kht.matour, kht.thucchi, IFNULL( SUM(v.giave*(100-km.phantram)/100),0) as thu"+
					" FROM kehoachtour kht" +
					" LEFT JOIN ve v ON kht.makht = v.makht" +
					" LEFT JOIN hoadon hd ON hd.mahd = v.mahd" +
					" LEFT JOIN khuyenmai km ON v.makm = km.makm" + 
					" WHERE kht.ngayve <= now() and YEAR(hd.ngaytao) = '" +year+ "'"+
					" GROUP BY kht.makht,kht.matour, kht.thucchi" +
					" ORDER BY thu DESC";
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String makht = rs.getString("makht");
				String matour = rs.getString("matour");
				double thu = rs.getDouble("thu");
				double chi = rs.getDouble("kht.thucchi");
				thongkeDTO tk = new thongkeDTO(makht, matour, chi, thu);
				list.add(tk);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//chua
	public ArrayList<HoaDonDTO> getTK_KH(String year) {
		ArrayList<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
		double total = 0;
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT hd.makh, SUM(v.giave*(100-km.phantram)/100) as total"
					+ " FROM hoadon hd"
					+ " LEFT JOIN ve v ON hd.mahd = v.mahd"
					+ " LEFT JOIN khuyenmai km ON km.makm = v.makm"
					+ " LEFT JOIN kehoachtour kht ON kht.makht = v.makht"
					+ "	WHERE kht.ngayve <= now() and YEAR(hd.ngaytao) = '" +year+ "'"
					+ " GROUP BY hd.makh"
					+ " ORDER BY total DESC";
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				total = rs.getDouble("total");
				String makh = rs.getString("makh");
				HoaDonDTO hd = new HoaDonDTO(null,null , makh, null, total,0);
				list.add(hd);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public double getTongChi(String year) {
		double total = 0;
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT SUM(kht.thucchi) as chi"
					+ " FROM kehoachtour kht"
					+ " WHERE kht.ngayve <= now() AND YEAR(kht.ngaydi) = '"  +year+ "'";
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				total = rs.getDouble("chi");
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	//thieu nam
	 public double getQuy(int start, int end, String year_Selected) {
		 double doanhthu = 0;
		 try {
				//Bước 1:Tạo kết nối
				Connection con=JDBCUtil.getConnection();
				//Bước 2:Tạo đối tượng statement
				java.sql.Statement st=con.createStatement();
				//Bước 3:Thực thi statement
				String sql="SELECT SUM(v.giave*(100-km.phantram)/100) as thu"
						+ " FROM ve v"
						+ " LEFT JOIN kehoachtour kht ON v.makht = kht.makht"
						+ " LEFT JOIN khuyenmai km ON km.makm = v.makm"
						+ " LEFT JOIN hoadon hd ON hd.mahd = v.mahd"
						+ " WHERE YEAR(hd.ngaytao) = " + year_Selected + " AND "
							+ "kht.ngayve <= now() AND MONTH(hd.ngaytao) BETWEEN " + start +" AND "+ end;
				ResultSet rs=st.executeQuery(sql);
				//Bước 4:Xử lý kết quả trả về
				while(rs.next()){
					doanhthu = rs.getDouble("thu");
				}
				//Bước 5:Ngắt kết nối
				JDBCUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return doanhthu;
	 }
	 
	
}
