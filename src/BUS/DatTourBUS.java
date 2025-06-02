package BUS;

import java.sql.Date;
import java.util.ArrayList;

import DAO.DatTourDAO;
import DTO.CTKHT_DTO;
import DTO.DatTourDTO;
import DTO.KHTourDTO;
import DTO.KhachSanDTO;
import DTO.NhaHangDTO;
import DTO.PhuongTienDTO;
import DTO.QlyToursDTO;



public class DatTourBUS {
	public static ArrayList<DatTourDTO> dsTour=new ArrayList<DatTourDTO>();
	
	public void docDSTour() {
		dsTour.clear();
		for(QlyToursDTO t:QlyToursBUS.tourDTO) {
			for(KHTourDTO kht:KHToursBUS.khtList) {
				if(kht.getMatour().equals(t.getMatour())) {
					String matour=t.getMatour();
					String makht=kht.getMakht();
					String tentour=t.getTentour();
					String mota=kht.getMota();
					String noikhoihanh=t.getNoikhoihanh();
					String hinh1=kht.getAnh1();
					String hinh2=kht.getAnh2();
					String hinh3=kht.getAnh3();
					String diadiem=t.getNoiden();
					String phuongtien=getPhuongTien(makht);
					String nhahang=getNhaHang(makht);
					String khachsan=getKhachSan(makht);
					long giave=kht.getGiaVe();
					int songuoi=kht.getSonguoi();
					Date ngaydi=kht.getNgaydi();
					Date ngayve=kht.getNgayve();
					DatTourDTO dattour=new DatTourDTO(matour, makht, tentour, hinh1, hinh2, hinh3, mota, noikhoihanh, diadiem, phuongtien, nhahang, khachsan, giave, songuoi, ngaydi, ngayve);
					dsTour.add(dattour);
				}
			}
		}
	}
	
	public void themDatTour(KHTourDTO kht) {
		QlyToursDTO tour=getTour(kht.getMatour());
		String matour=tour.getMatour();
		String makht=kht.getMakht();
		String tentour=tour.getTentour();
		String mota=kht.getMota();
		String noikhoihanh=tour.getNoikhoihanh();
		String hinh1=kht.getAnh1();
		String hinh2=kht.getAnh2();
		String hinh3=kht.getAnh3();
		String diadiem=tour.getNoiden();
		String phuongtien=getPhuongTien(makht);
		String nhahang=getNhaHang(makht);
		String khachsan=getKhachSan(makht);
		long giave=kht.getGiaVe();
		int songuoi=kht.getSonguoi();
		Date ngaydi=kht.getNgaydi();
		Date ngayve=kht.getNgayve();
		DatTourDTO dattour=new DatTourDTO(matour, makht, tentour, hinh1, hinh2, hinh3, mota, noikhoihanh, diadiem, phuongtien, nhahang, khachsan, giave, songuoi, ngaydi, ngayve);
		dsTour.add(dattour);
	}
	
	public boolean suaDatTour(KHTourDTO kht) {
		for(DatTourDTO dt:DatTourBUS.dsTour) {
			if(dt.getMakht().equals(kht.getMakht())) {
				dt.setGiatour(kht.getGiaVe());
				dt.setPhuongtien(getPhuongTien(kht.getMakht()));
				dt.setNhahang(getNhaHang(kht.getMakht()));
				dt.setKhachsan(getKhachSan(kht.getMakht()));
				dt.setSonguoi(kht.getSonguoi());
				return true;
			}
		}
		return false;
	}
	
	
	
	public QlyToursDTO getTour(String matour) {
		for(QlyToursDTO t:QlyToursBUS.tourDTO) {
			if(t.getMatour().equals(matour)) {
				return t;
			}
		}
		return null;
	}
	
	public String getPhuongTien(String makht) {
		String mapt="";
		String tenpt="";
		for(CTKHT_DTO ctkht:ChiTietKHT_BUS.ctkhtList) {
			if(ctkht.getMakht().equals(makht)) {
				mapt=ctkht.getMapt();
				break;
			}
		}
		
		for(PhuongTienDTO pt:DichVuBUS.ptDTO) {
			if(pt.getMaso().equals(mapt)) {
				tenpt=pt.getTendv();
			}
		}	
		return tenpt;
	}
	public String getKhachSan(String makht) {
			
		String maks="";
		String tenks="";
		for(CTKHT_DTO ctkht:ChiTietKHT_BUS.ctkhtList) {
			if(ctkht.getMakht().equals(makht)) {
				maks=ctkht.getMaks();
				break;
			}
		}
		
		for(KhachSanDTO ks:DichVuBUS.ksDTO) {
			if(ks.getMaso().equals(maks)) {
				tenks=ks.getTendv();
			}
		}	
		return tenks;
	}
	
	public String getNhaHang(String makht) {
		
		String manh="";
		String tennh="";
		for(CTKHT_DTO ctkht:ChiTietKHT_BUS.ctkhtList) {
			if(ctkht.getMakht().equals(makht)) {
				manh=ctkht.getManh();
				break;
			}
		}
		
		for(NhaHangDTO nh:DichVuBUS.nhDTO) {
			if(nh.getMaso().equals(manh)) {
				tennh=nh.getTendv();
			}
		}	
		return tennh;
	}

	public ArrayList<QlyToursDTO> LocTour(String loaitour,String noiBD, String noiDen,java.sql.Date ngayDi, int soNgay, int soNguoi, int giaVeBD, int giaveKT){
		return DatTourDAO.getIntance().getLoc(loaitour, noiBD, noiDen, ngayDi, soNgay, soNguoi, giaVeBD, giaveKT);
	}
	
}
