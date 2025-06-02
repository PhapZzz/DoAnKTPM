package BUS;

import java.util.ArrayList;

import DTO.chitiethoadonDTO;
import DAO.chitiethoadonDAO;
public class chitiethoadonBUS {
    public static ArrayList<chitiethoadonDTO> listChiTietHoaDon;

    public chitiethoadonBUS() {
        listChiTietHoaDon = chitiethoadonDAO.getIntance().selectAll();
    }

    public ArrayList<chitiethoadonDTO> getList() {
        return listChiTietHoaDon;
    }
    public ArrayList<chitiethoadonDTO> getListByMaHD(String maHoaDon) {
        ArrayList<chitiethoadonDTO> list = new ArrayList<>();
        for (chitiethoadonDTO ct : listChiTietHoaDon) {
            if (ct.getMahd().equals(maHoaDon)) {
                list.add(ct);
            }
        }
        return list;
    }
    public double getTotal(String mahd) {
    	return chitiethoadonDAO.getIntance().getTongGiaVe(mahd);
    }

}