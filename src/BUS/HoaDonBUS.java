package BUS;

import java.util.ArrayList;
import DAO.HoaDonDAO;
import DTO.HoaDonDTO;

public class HoaDonBUS {
    private HoaDonDAO hoadonDAO = HoaDonDAO.getIntance();
    public static ArrayList<HoaDonDTO> listHD;

    public boolean docHoaDon() {
        try {
            listHD = hoadonDAO.selectAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int them(HoaDonDTO t) {
        try {
            int result = hoadonDAO.InsertHoaDon(t);
            if (result > 0) {
                listHD.add(t);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static ArrayList<HoaDonDTO> getListHD() {
        return listHD;
    }
    public String getTenTourByMaHD(String maHoaDon) {
        HoaDonDAO dao = HoaDonDAO.getIntance();
        return dao.getTenTourByMaHD(maHoaDon);
    }
}