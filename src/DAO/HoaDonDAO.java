package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.HoaDonDTO;
import Util.JDBCUtil;

public class HoaDonDAO {
	public static HoaDonDAO getIntance() {
        return new HoaDonDAO();
    }
    public ArrayList<HoaDonDTO> selectAll() throws SQLException {
        ArrayList<HoaDonDTO> ketqua = new ArrayList<>();
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM hoadon ORDER BY ngaytao DESC";
        ResultSet rs = con.createStatement().executeQuery(sql);
        while (rs.next()) {
            ketqua.add(new HoaDonDTO(rs.getString("mahd"), rs.getString("manv"), rs.getString("makh"), rs.getDate("ngaytao"), rs.getDouble("tongtien"),rs.getDouble("tongtien_truocgg")));
        }
        JDBCUtil.closeConnection(con);
        return ketqua;
    }

    public int InsertHoaDon(HoaDonDTO t) throws SQLException {
        Connection con = JDBCUtil.getConnection();
        String sql = "INSERT INTO hoadon (mahd,manv,makh,ngaytao,tongtien,tongtien_truocgg) VALUES('" + t.getMahd() + "','" + t.getManv() + "','" + t.getMakh() + "','" + t.getNgaytao() + "'," + t.getTongtien() + ","+t.getTongcong_truocgg()+")";
        int ketQua = con.createStatement().executeUpdate(sql);
//        con.commit();
        JDBCUtil.closeConnection(con);
        return ketQua;
    }
    public String getTenTourByMaHD(String maHoaDon) {
        String sql = "SELECT t.tentour " +
                     "FROM hoadon hd " +
                     "JOIN ve ON hd.mahd = ve.mahd " +
                     "JOIN kehoachtour kht ON ve.makht = kht.makht " +
                     "JOIN tours t ON kht.matour = t.matour " +
                     "WHERE hd.mahd = ?";
        
        try (Connection conn = JDBCUtil.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maHoaDon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("tentour");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    
}