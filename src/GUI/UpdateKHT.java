package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.ChiTietKHT_BUS;
import BUS.DatTourBUS;
import BUS.DichVuBUS;
import BUS.KHToursBUS;
import BUS.KhachHangBUS;
import BUS.KiemTra;
import DTO.CTKHT_DTO;
import DTO.KHTourDTO;
import DTO.KhachHangDTO;
import DTO.KhachSanDTO;
import DTO.NhaHangDTO;
import DTO.PhuongTienDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JTextArea;

public class UpdateKHT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel tableModel;
	private KhachHangBUS khBus = new KhachHangBUS();
	private JTextField tf_songuoi;
	JLabel lbl_giakhachsan,lbl_gianhahang,lbl_giaphuongtien;
	JComboBox cb_ngay;
	private int songuoi=0;
	private ChiTietKHT_BUS ct_bus=new ChiTietKHT_BUS();
	private KHToursBUS kht_bus=new KHToursBUS();
	private DatTourBUS dt_bus=new DatTourBUS();
	private JLabel lblTenks,lblTenNhaHang,lblTenPhuongTien;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					infoKhachHang frame = new infoKhachHang();
//					frame.setSize(700,400);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UpdateKHT(DatKHTGUI dattour,KHTourDTO kht_moi,String makht_cu) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700,400);
		setBounds(400, 220, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 686, 363);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cập nhật kế hoạch tour");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 5, 686, 52);
		panel.add(lblNewLabel);
		
		JPanel panel_func = new JPanel();
		panel_func.setBounds(10, 54, 666, 299);
		panel.add(panel_func);
		panel_func.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Khách sạn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(21, 45, 89, 29);
		panel_func.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhà hàng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(21, 104, 89, 29);
		panel_func.add(lblNewLabel_1_1);
		
		ArrayList<String> arrMaKS=new ArrayList<String>();
		for(KhachSanDTO ks:DichVuBUS.ksDTO) {
			arrMaKS.add(ks.getMaso());
		}
		JComboBox cb_khachsan = new JComboBox(arrMaKS.toArray());
		cb_khachsan.setBounds(136, 44, 115, 34);
		cb_khachsan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KhachSanDTO ks=GetKhachSan(cb_khachsan.getSelectedItem().toString());
				lbl_giakhachsan.setText(formatCurrency(ks.getGiaca()));
				lblTenks.setText(ks.getTendv());
				
			}
		});
		panel_func.add(cb_khachsan);
		
		ArrayList<String> arrMaNH=new ArrayList<String>();
		for(NhaHangDTO ks:DichVuBUS.nhDTO) {
			arrMaNH.add(ks.getMaso());
		}
		JComboBox cb_nhahang = new JComboBox(arrMaNH.toArray());
		cb_nhahang.setBounds(136, 103, 115, 34);
		cb_nhahang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NhaHangDTO nh=GetNhaHang(cb_nhahang.getSelectedItem().toString());
				lbl_gianhahang.setText(formatCurrency(nh.getGiaca()));
				lblTenNhaHang.setText(nh.getTendv());
			}
		});
		panel_func.add(cb_nhahang);
		
		ArrayList<String> arrMaPT=new ArrayList<String>();
		for(PhuongTienDTO ks:DichVuBUS.ptDTO) {
			arrMaPT.add(ks.getMaso());
		}
		JComboBox cb_phuongtien = new JComboBox(arrMaPT.toArray());
		cb_phuongtien.setBounds(136, 164, 115, 34);
		cb_phuongtien.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PhuongTienDTO pt=GetPhuongTien(cb_phuongtien.getSelectedItem().toString());
				lbl_giaphuongtien.setText(formatCurrency(pt.getGiaca()));
				lblTenPhuongTien.setText(pt.getTendv());
			}
		});
		panel_func.add(cb_phuongtien);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phương tiện");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(21, 165, 105, 29);
		panel_func.add(lblNewLabel_1_1_1);
		
		JButton btn_luu = new JButton("Lưu");
		btn_luu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_luu.setBounds(262, 243, 123, 46);
		btn_luu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(songuoi==0) {
					JOptionPane.showMessageDialog(null, "Bạn chưa cập nhật số người!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}else {
					String date=cb_ngay.getSelectedItem().toString();
					long sum=0;
					for(CTKHT_DTO ct:ChiTietKHT_BUS.ctkhtList) {
						if(convertDateToString(ct.getNgay()).equals(date) && ct.getMakht().equals(kht_moi.getMakht())) {
							KhachSanDTO ksan=GetKhachSan(cb_khachsan.getSelectedItem().toString());
							NhaHangDTO nhahang=GetNhaHang(cb_nhahang.getSelectedItem().toString());
							PhuongTienDTO ptien=GetPhuongTien(cb_phuongtien.getSelectedItem().toString());
							ct.setThanhtienKS(ksan.getGiaca());
							ct.setThanhtienNH(nhahang.getGiaca());
							ct.setThanhtienPT(ptien.getGiaca());
							ct.setMaks(ksan.getMaso());
							ct.setManh(nhahang.getMaso());
							ct.setMapt(ptien.getMaso());
							ct_bus.sua(ct);
							sum=(long) (sum+ct.getThanhtienKS()+ct.getThanhtienNH()+ct.getThanhtienPT());
						}
					}
					
					kht_moi.setTongchi((long) sum*kht_moi.getSonguoidukien());
					kht_moi.setGiave(sum*130/100);
					kht_bus.sua(kht_moi, kht_moi.getMakht());
					dt_bus.suaDatTour(kht_moi);
					JOptionPane.showMessageDialog(null, "Bạn đã cập nhật thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					dattour.initData();
					dattour.selectRowByColumnValue(kht_moi.getMakht());
				}
				
				
			}
		});
		panel_func.add(btn_luu);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(21, 6, 58, 29);
		panel_func.add(lblNewLabel_1_2);
		
		
		cb_ngay = new JComboBox(convertDateRangeToStringArray(kht_moi.getNgaydi(),kht_moi.getNgayve()));
		cb_ngay.setBounds(136, 13, 123, 21);
		panel_func.add(cb_ngay);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Số người:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(21, 204, 89, 29);
		panel_func.add(lblNewLabel_1_2_1);
		
		tf_songuoi = new JTextField();
		tf_songuoi.setBounds(136, 211, 96, 19);
		panel_func.add(tf_songuoi);
		tf_songuoi.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("Giá tiền");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(507, 6, 66, 29);
		panel_func.add(lblNewLabel_1_3);
		
		
		lbl_giakhachsan = new JLabel(formatCurrency(GetKhachSan(arrMaKS.toArray()[0].toString()).getGiaca()));
		lbl_giakhachsan.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_giakhachsan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_giakhachsan.setBounds(432, 45, 224, 29);
		panel_func.add(lbl_giakhachsan);
		
		lbl_gianhahang = new JLabel(formatCurrency(GetNhaHang(arrMaNH.toArray()[0].toString()).getGiaca()));
		lbl_gianhahang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_gianhahang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_gianhahang.setBounds(432, 104, 224, 29);
		panel_func.add(lbl_gianhahang);
		
		lbl_giaphuongtien = new JLabel(formatCurrency(GetPhuongTien(arrMaPT.toArray()[0].toString()).getGiaca()));
		lbl_giaphuongtien.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_giaphuongtien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_giaphuongtien.setBounds(432, 169, 224, 29);
		panel_func.add(lbl_giaphuongtien);
		
		JButton btn_xacnhan = new JButton("Xác nhận");
		btn_xacnhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KHTourDTO kht_cu=GetKHT(makht_cu);
				if(songuoi>kht_cu.getSonguoi()) {
					JOptionPane.showMessageDialog(null, "Số người vượt quá giới hạn!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}else {
					songuoi=Integer.parseInt(tf_songuoi.getText());
					kht_moi.setSonguoi(songuoi);
					kht_moi.setSonguoidukien(songuoi);
					kht_bus.sua(kht_cu, kht_cu.getMakht());
					kht_bus.sua(kht_moi, kht_moi.getMakht());
					JOptionPane.showMessageDialog(null, "Cập nhật số người thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				
				btn_xacnhan.setEnabled(false);
				
			}
		});
		btn_xacnhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_xacnhan.setBounds(235, 208, 105, 25);
		panel_func.add(btn_xacnhan);
		
		lblTenks = new JLabel("Tên khách sạn");
		lblTenks.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenks.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenks.setBounds(261, 45, 161, 29);
		panel_func.add(lblTenks);
		
		lblTenNhaHang = new JLabel("Tên nhà hàng");
		lblTenNhaHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNhaHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNhaHang.setBounds(261, 104, 161, 29);
		panel_func.add(lblTenNhaHang);
		
		lblTenPhuongTien = new JLabel("Tên phương tiện");
		lblTenPhuongTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenPhuongTien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenPhuongTien.setBounds(261, 164, 161, 29);
		panel_func.add(lblTenPhuongTien);
		
		String item[] = {"Mã số","Họ tên","Tên"};
		String[] colname =  {"Mã kh","Họ","Tên","Giới tính","Địa chỉ","Số điện thoại","Email","Ngày sinh"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(colname);
		this.setVisible(true);
	}
	
	
	
	
	public String[] convertDateRangeToStringArray(Date startDate, Date endDate) {
        List<String> dateList = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        // Chuyển java.sql.Date sang LocalDate để dễ xử lý vòng lặp
        LocalDate start = startDate.toLocalDate();
        LocalDate end = endDate.toLocalDate();

        while (!start.isAfter(end)) {
            dateList.add(formatter.format(Date.valueOf(start)));
            start = start.plusDays(1);
        }

        return dateList.toArray(new String[0]);
    }
	
	
	public String convertDateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }
	
	
	
	public NhaHangDTO GetNhaHang(String MaNH) {
		for(NhaHangDTO nh:DichVuBUS.nhDTO) {
			if(nh.getMaso().equals(MaNH)) {
				return nh;
			}
		}
		return null;
	}
	
	public KhachSanDTO GetKhachSan(String MaKS) {
		for(KhachSanDTO ks:DichVuBUS.ksDTO) {
			if(ks.getMaso().equals(MaKS)) {
				return ks;
			}
		}
		return null;
	}
	
	public PhuongTienDTO GetPhuongTien(String MaPT) {
		for(PhuongTienDTO pt:DichVuBUS.ptDTO) {
			if(pt.getMaso().equals(MaPT)) {
				return pt;
			}
		}
		return null;
	}
	
	public String formatCurrency(double amount) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(amount) + " VNĐ";
    }
	
	public KHTourDTO GetKHT(String makht) {
		for(KHTourDTO t:KHToursBUS.khtList) {
			if(t.getMakht().equals(makht)) {
				return t;
			}
		}
		return null;
	}
	
	public double parseCurrency(String currency) {
        try {
            // Loại bỏ "VNĐ" và khoảng trắng
            String cleaned = currency.replace("VNĐ", "").trim();

            // Dùng NumberFormat để xử lý dấu phẩy
            NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
            Number number = format.parse(cleaned);

            return number.doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0; // Trả về 0 nếu có lỗi
        }
    }
}
