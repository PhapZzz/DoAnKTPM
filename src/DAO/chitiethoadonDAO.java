package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.chitiethoadonDTO;
import Util.JDBCUtil;


public class chitiethoadonDAO {
    public static chitiethoadonDAO getIntance() {
        return new chitiethoadonDAO();
    }

    public ArrayList<chitiethoadonDTO> selectAll() {
        ArrayList<chitiethoadonDTO> ketqua = new ArrayList<chitiethoadonDTO>();
        try {
            Connection con = JDBCUtil.getConnection();
            java.sql.Statement st = con.createStatement();
            String sql = "select * from ve ORDER BY mahd ASC";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String mave = rs.getString("mave");
                String makht = rs.getString("makht");
                String makh = rs.getString("makh");
                double giave = rs.getDouble("giave");
                String makm = rs.getString("makm");
                String mahd = rs.getString("mahd");
                chitiethoadonDTO chitiet = new chitiethoadonDTO(mave, makht, makh, makm, giave, mahd);
                ketqua.add(chitiet);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    public double getTongGiaVe(String mahd) {
        double tongGiaVe = 0.0;
        try {
            Connection con = JDBCUtil.getConnection();
            java.sql.Statement st = con.createStatement();
            String sql = "SELECT tongtien AS tonggiave FROM hoadon WHERE mahd = '" + mahd +"';";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                tongGiaVe = rs.getDouble("tonggiave");
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tongGiaVe;
    }
}