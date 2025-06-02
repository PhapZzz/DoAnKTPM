package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import BUS.KiemTra;
import DTO.DatTourDTO;
import DTO.QlyToursDTO;
import Util.JDBCUtil;

public class DatTourDAO {
	public static DatTourDAO getIntance() {
		return new DatTourDAO();
	}
	
	public ArrayList<QlyToursDTO> getLoc(String loaitour,String noiBD, String noiDen,java.sql.Date ngayDi, int soNgay, int soNguoi, int giaVeBD, int giaveKT) {
		ArrayList<QlyToursDTO> list = new ArrayList<>();
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM tours t"
					+ " WHERE t.tinhtrang = 1 AND t.maloai = '" + loaitour+"'";
					if(!noiBD.equalsIgnoreCase("Địa điểm")) {
						sql += " AND t.noikhoihanh = '" + noiBD+"'";
					}
					if(!noiDen.equalsIgnoreCase("Địa điểm")) {
						sql += " AND t.noiden = '" + noiDen+"'";
					}
//						sql += " AND kht.giave >= " + giaVeBD + " AND kht.giave <= " + giaveKT;
					sql += " ORDER BY t.matour";
			System.err.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String matour = rs.getString("t.matour");
				String tentour = rs.getString("t.tentour");
				String noiden = rs.getString("t.noiden");
				String noikhoihanh = rs.getString("t.noikhoihanh");
				String maloai = rs.getString("t.maloai");
				int songay = rs.getInt("t.songay");
						QlyToursDTO tour = new QlyToursDTO(matour, tentour,noiden,noikhoihanh, maloai,songay);					
						list.add(tour);
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	
	
}
