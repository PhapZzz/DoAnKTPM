package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ScrollPaneConstants;
import java.awt.Cursor;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

import BUS.ChiTietKHT_BUS;
import BUS.DatTourBUS;
import BUS.DichVuBUS;
import BUS.KHToursBUS;
import BUS.KiemTra;
import BUS.QlyToursBUS;
import BUS.taikhoanBUS;
import DTO.CTKHT_DTO;
import DTO.DatTourDTO;
import DTO.KHTourDTO;
import DTO.KhachSanDTO;
import DTO.NhaHangDTO;
import DTO.PhuongTienDTO;
import DTO.QlyToursDTO;

public class DatTourGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_NgayVL;
	JButton btn_TrangChu,btn_DatTour,btn_HoaDon,btn_ThongKe;
	private JTable table;
	JComboBox noiden_cb,loaitour_cb,noibatdau_cb, giave_cb;
	JDateChooser ngaydi_cb;
	
	ArrayList<String> arr_noibatdau=new ArrayList<String>();
	ArrayList<String> arr_denTrongNuoc=new ArrayList<String>();
	ArrayList<String> arr_denNgoaiNuoc=new ArrayList<String>();
	
	private static String loaitour ="",noibatdau="",noiden="";
	private static int songay = 0, songuoi=0;
	private static int giaveBD = 0, giaveKT = 0;
	private static Date ngaydi;
	QlyToursBUS qltBUS = new QlyToursBUS();
	KHToursBUS khtBUS  = new KHToursBUS();
	DatTourBUS dattourBUS=new DatTourBUS();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatTourGUI frame = new DatTourGUI();
					frame.setSize(1000, 650);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DatTourGUI() {
		setBackground(SystemColor.windowText);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(34, 99, 138));
		panel.setBounds(0, -19, 1000, 632);
		contentPane.add(panel);
		panel.setLayout(null);

		btn_TrangChu = new JButton("Trang Chủ");
		btn_TrangChu.setBorderPainted(false);
		btn_TrangChu.setFocusable(false);
		btn_TrangChu.setBorder(null);
		btn_TrangChu.setBackground(new Color(24, 171, 138));
		btn_TrangChu.setForeground(new Color(255, 255, 255));
		btn_TrangChu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_TrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TrangChuGUI tc = new TrangChuGUI();
				tc.btn_TrangChu.setBackground(Color.ORANGE);
				tc.btn_TrangChu.setForeground(Color.BLACK);
			}
		});
		btn_TrangChu.setBounds(154, 65, 120, 40);
		panel.add(btn_TrangChu);

		btn_HoaDon = new JButton("Hóa đơn");
		btn_HoaDon.setFocusable(false);
		btn_HoaDon.setBorder(null);
		btn_HoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HoaDon hd = new HoaDon();
				hd.btn_HoaDon.setBackground(Color.ORANGE);
				hd.btn_HoaDon.setForeground(Color.BLACK);
			}
		});
		btn_HoaDon.setForeground(new Color(255, 255, 255));
		btn_HoaDon.setBackground(new Color(24, 171, 138));
		btn_HoaDon.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_HoaDon.setBounds(478, 65, 120, 40);
		panel.add(btn_HoaDon);

		JButton btn_QlyThongtin = new JButton("Quản lý thông tin");
		btn_QlyThongtin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				QuanLyTour qlt = new QuanLyTour();
				qlt.btn_QLTour.setBackground(Color.ORANGE);
				qlt.btn_QLTour.setForeground(Color.BLACK);
			}
		});
		btn_QlyThongtin.setFocusable(false);
		btn_QlyThongtin.setBorder(null);
		btn_QlyThongtin.setForeground(new Color(255, 255, 255));
		btn_QlyThongtin.setBackground(new Color(24, 171, 138));
		btn_QlyThongtin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_QlyThongtin.setBounds(799, 65, 120, 40);
		panel.add(btn_QlyThongtin);

		btn_ThongKe = new JButton("Thống kê");
		btn_ThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ThongKe tk = new ThongKe();
				tk.btn_ThongKe.setBackground(Color.ORANGE);
				tk.btn_ThongKe.setForeground(Color.BLACK);
			}
		});
		btn_ThongKe.setFocusable(false);
		btn_ThongKe.setBorder(null);
		btn_ThongKe.setForeground(new Color(255, 255, 255));
		btn_ThongKe.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_ThongKe.setBackground(new Color(24, 171, 138));
		btn_ThongKe.setBounds(643, 65, 120, 40);
		panel.add(btn_ThongKe);


		taikhoanBUS tkBUS = new taikhoanBUS();

		ImageIcon image = new ImageIcon("src\\Images\\logo.png");
		JLabel label = new JLabel();
		label.setBackground(new Color(0, 128, 255));
		label.setBounds(26, 24, 90, 81);
		Image img = image.getImage();
		Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon = new ImageIcon(imgScale);
		label.setIcon(scaleIcon);
		label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setVisible(false);
                TrangChuGUI tc = new TrangChuGUI();
                tc.btn_TrangChu.setBackground(Color.ORANGE);
                tc.btn_TrangChu.setForeground(Color.BLACK);
            }
        });
		panel.add(label);


		this.getContentPane().add(panel);

		Panel KhachHang = new Panel();
		KhachHang.setBounds(13, 127, 960, 495);
		panel.add(KhachHang);
		KhachHang.setLayout(null);
		KhachHang.setBackground(new Color(255, 255, 255));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 144, 270, 248);
		KhachHang.add(panel_1);
		panel_1.setLayout(null);

		JLabel loaitour_lb = new JLabel("Loại Tour");
		loaitour_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		loaitour_lb.setBounds(10, 25, 90, 30);
		panel_1.add(loaitour_lb);
		
		String[] arr_tinh = { "Địa điểm","An Giang", "Bà Rịa – Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh",
				"Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ",
				"Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam",
				"Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "TP Hồ Chí Minh", "Hưng Yên",
				"Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lạng Sơn", "Lào Cai", "Lâm Đồng", "Long An",
				"Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam",
				"Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên",
				"Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc",
				"Yên Bái" };

		
		
		

		JLabel noibatdau_lb = new JLabel("Nơi bắt đầu");
		noibatdau_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		noibatdau_lb.setBounds(10, 78, 90, 30);
		panel_1.add(noibatdau_lb);

		

		JLabel noiden_lb = new JLabel("Nơi đến");
		noiden_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		noiden_lb.setBounds(10, 130, 90, 30);
		panel_1.add(noiden_lb);

		

//		JLabel ngaydi_lb = new JLabel("Ngày đi");
//		ngaydi_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
//		ngaydi_lb.setBounds(10, 181, 90, 30);
//		panel_1.add(ngaydi_lb);

//		ngaydi_cb = new JDateChooser();
//		ngaydi_cb.setBounds(110, 181, 145, 30);
//		panel_1.add(ngaydi_cb);

		JButton loc_btn = new JButton("Lọc");
		loc_btn.setFocusPainted(false);
		loc_btn.setBorder(null);
		loc_btn.setBackground(new Color(51, 204, 255));
		loc_btn.setForeground(Color.WHITE);
		loc_btn.setFont(new Font("Tahoma", Font.BOLD, 18));
		loc_btn.setBounds(32, 188, 90, 40);
		loc_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				XoaDataTable();
				Loc2();
//				initData2(Loc());
				
			}
		});
		panel_1.add(loc_btn);

		JButton reset_btn = new JButton("Reset");
		reset_btn.setFocusPainted(false);
		reset_btn.setBackground(new Color(102, 153, 204));
		reset_btn.setBorder(null);
		reset_btn.setForeground(new Color(255, 255, 255));
		reset_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset();
				initData();
			}
		});
		reset_btn.setFont(new Font("Tahoma", Font.BOLD, 18));
		reset_btn.setBounds(135, 188, 90, 40);
		panel_1.add(reset_btn);
		
//		JLabel songuoi_lb_1 = new JLabel("Giá vé");
//		songuoi_lb_1.setFont(new Font("Tahoma", Font.BOLD, 15));
//		songuoi_lb_1.setBounds(10, 230, 102, 30);
//		panel_1.add(songuoi_lb_1);

		JLabel lblNewLabel_1 = new JLabel("Lọc kết quả");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 10, 330, 34);
		KhachHang.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 54, 663, 431);
		KhachHang.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(590, 600));
		panel_3.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(panel_3);
		
		JScrollPane table_sp = new JScrollPane();
		table_sp.setForeground(Color.BLACK);
		table_sp.setFont(new Font("Tahoma", Font.BOLD, 10));
		table_sp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_sp.setBounds(10, 10, 621, 408);
		panel_3.add(table_sp);
		
		table = new JTable();
		table.setDefaultEditor(Object.class,null);
		table_sp.setViewportView(table);
		
		initData();
		Set<String> set = new HashSet<>(arr_noibatdau);
	    ArrayList<String> arr_noibatdau = new ArrayList<>(set);
	    
	    Set<String> set1 = new HashSet<>(arr_denTrongNuoc);
	    ArrayList<String> arr_denTrongNuoc = new ArrayList<>(set1);
	    
	    Set<String> set2 = new HashSet<>(arr_denNgoaiNuoc);
	    ArrayList<String> arr_denNgoaiNuoc = new ArrayList<>(set2);
	    
	    String[] arr_loaiTour= {"Trong nước","Ngoài nước"};
		loaitour_cb = new JComboBox(arr_loaiTour);
		loaitour_cb.setBounds(110, 25, 145, 30);
		loaitour_cb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (loaitour_cb.getSelectedItem().equals("Trong nước")) {
					noiden_cb.setModel(new DefaultComboBoxModel(arr_denTrongNuoc.toArray()));
				} else if (loaitour_cb.getSelectedItem().equals("Ngoài nước")) {
//					String[] arr_nuocngoai = { "Địa điểm","Trung Quốc", "Hàn Quốc", "Nhật Bản", "Đài Loan", "Hồng Kông", "Macau",
//							"Triều Tiên", "Hàn Quốc", "Mông Cổ", "Brunei", "Campuchia", "Đông Timor", "Indonesia",
//							"Lào", "Malaysia", "Myanma", "Philippines", "Singapore", "Thái Lan" };
					noiden_cb.setModel(new DefaultComboBoxModel(arr_denNgoaiNuoc.toArray()));
				}
				
			}
		});
		panel_1.add(loaitour_cb);
		
		noibatdau_cb = new JComboBox(arr_noibatdau.toArray());
		noibatdau_cb.setBounds(110, 78, 145, 30);
		panel_1.add(noibatdau_cb);
		
		noiden_cb = new JComboBox(arr_denTrongNuoc.toArray());
		noiden_cb.setBounds(110, 130, 145, 30);
		panel_1.add(noiden_cb);
		
		
//		String []item_gia = {"Dưới 1 triệu", "Từ 1 - 5 triệu" ,"Trên 5 triệu"};
//		giave_cb = new JComboBox(item_gia);
//		giave_cb.setBounds(110, 232, 145, 30);
//		panel_1.add(giave_cb);
		
		JButton btnNewButton = new JButton("Đặt Tour");
		btnNewButton.setBounds(835, 17, 85, 28);
		KhachHang.add(btnNewButton);
		btnNewButton.setBorder(null);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(new Color(255, 127, 80));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row==-1) {
					JOptionPane.showMessageDialog(panel, "Bạn chưa chọn Tour.");
					return;
				}
				else {
					String tourduocchon=GetTourDaChon();
//					setVisible(false);
					new DatKHTGUI(tourduocchon);
//					Ve ve = new Ve(tourduocchon);
//					ve.setSize(1000, 780);
				}
				
			}
		});

		String []item_loai = {"Trong nước", "Ngoài nước"};

		btn_DatTour = new JButton("Đặt Tour");
		btn_DatTour.setForeground(Color.WHITE);
		btn_DatTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_DatTour.setFocusable(false);
		btn_DatTour.setBorderPainted(false);
		btn_DatTour.setBorder(null);
		btn_DatTour.setBackground(new Color(24, 171, 138));
		btn_DatTour.setBounds(317, 65, 120, 40);
		btn_DatTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DatTourGUI dt = new DatTourGUI();
				dt.btn_DatTour.setBackground(Color.ORANGE);
				dt.btn_DatTour.setForeground(Color.BLACK);
			}
		});
		panel.add(btn_DatTour);
		
		JLabel lblNewLabel = new JLabel("Xin chào " + TrangChuGUI.tkBUS.getName(TrangChuGUI.tkDTO.getUser()));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(609, 24, 230, 30);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Đổi mật khẩu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatKhauGUI mk = new MatKhauGUI();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBounds(849, 25, 124, 30);
		panel.add(btnNewButton_2);
		this.setVisible(true);
	}
	
	public void initData() {
		String[] colNames = { "Mã Tour", "Tên Tour", "Loại tour","Số ngày", "Nơi khởi hành", "Nơi đến" };
		DefaultTableModel tableModel = new DefaultTableModel();
		table.setModel(tableModel);
		tableModel.setColumnIdentifiers(colNames);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
//		table.addMouseListener((MouseListener) new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				if (e.getClickCount() == 1) {
//					String tourduocchon=GetTourDaChon();
//					new DatKHTGUI(tourduocchon);
//				}
//			}
//		});
		String tenloai = null;
		for (QlyToursDTO tour : QlyToursBUS.tourDTO) {
			if(tour.getMaloai().equals("loai1")) tenloai = "Trong nước";
			else tenloai = "Ngoài nước";
			tableModel.addRow(new Object[] { tour.getMatour(),tour.getTentour(), tenloai, tour.getSongay() + "",
					tour.getNoikhoihanh(),tour.getNoiden() });
		}
		
		
		for (DatTourDTO dattour : DatTourBUS.dsTour) {
			arr_noibatdau.add(dattour.getNoikhoihanh());
			if(GetLoaiTour(dattour.getMatour()).equals("loai1")) {
				arr_denTrongNuoc.add(dattour.getDiadiem());
			}else {
				arr_denNgoaiNuoc.add(dattour.getDiadiem());
			}
		}
		
	}
	
	public void initData2(ArrayList<QlyToursDTO> tours) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		String tenloai = null;
		for (QlyToursDTO tour : tours) {
			if(tour.getMaloai().equals("loai1")) tenloai = "Trong nước";
			else tenloai = "Ngoài nước";
			model_table.addRow(new Object[] { tour.getMatour(),tour.getTentour(), tenloai, tour.getSongay() + "",
					tour.getNoikhoihanh(),tour.getNoiden() });
		}
	}
	
	
	public String GetTourDaChon() {
		int row = table.getSelectedRow();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		String matour = null; 
		matour = model_table.getValueAt(row, 0) + "";
		
		return matour;
	}
	public String GetLoaiTour(String matour) {
		String maloai="";
		for(QlyToursDTO t:QlyToursBUS.tourDTO) {
			if(t.getMatour().equals(matour)) {
				maloai=t.getMaloai();
			}
		}
		return maloai;
	}
	
	
	public void Loc2() {
		if(loaitour_cb.getSelectedItem().toString().equals("Trong nước")) {
			loaitour="loai1";
		}else {
			loaitour="loai2";
		}
		if(noibatdau_cb.getSelectedItem() != null) {
			noibatdau=noibatdau_cb.getSelectedItem().toString();			
		}
		if(noiden_cb.getSelectedItem() != null) {
			noiden=noiden_cb.getSelectedItem().toString();			
		}
//		System.out.println(ngaydi);
//		java.util.Date ngaydi_tmp=(java.util.Date) ngaydi_cb.getDate();
//		if(ngaydi_tmp!=null) {
//			ngaydi = new java.sql.Date(ngaydi_tmp.getTime());			
//		}
		
//        if(giave_cb.getSelectedItem() != null) {
//			int stt = (int) giave_cb.getSelectedIndex();
//			if(stt == 0) {
//				giaveBD = 0;
//				giaveKT = 1000000;
//			}else if(stt == 1) {
//				giaveBD = 1000000;
//				giaveKT = 5000000;
//			}else {
//				giaveBD = 5000000;
//				giaveKT = Integer.MAX_VALUE;
//			}
//		}
        
        ArrayList<QlyToursDTO> list = dattourBUS.LocTour(loaitour, noibatdau, noiden, ngaydi, songay, songuoi, giaveBD, giaveKT);
        if(list == null) {
        	JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả phù hợp");
        }else {
        	initData2(list);
        }
	}
	
	
	public int getSoNgay(String matour) {
		for(QlyToursDTO t:QlyToursBUS.tourDTO) {
			if(t.getMatour().equals(matour)) {
				return t.getSongay();
			}
		}
		return -1;
	}
	
	public String getMaLoai(String matour) {
		for(QlyToursDTO t:QlyToursBUS.tourDTO) {
			if(t.getMatour().equals(matour)) {
				return t.getMaloai();
			}
		}
		return null;
	}
	
	public void Reset() {
		loaitour_cb.setSelectedIndex(0);
		noibatdau_cb.setSelectedIndex(0);
		noiden_cb.setSelectedIndex(0);
//		ngaydi_cb.setDate(null);
//		giave_cb.setSelectedIndex(0);
	}
	
	public void XoaDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.setRowCount(0);
	}
	
	public String GetTenKS(String maks) {
		for(KhachSanDTO ks: DichVuBUS.ksDTO) {
			if(ks.getMaso().equals(maks)) {
				return ks.getTendv();
			}
		}
		return null;
	}
	public String GetTenNH(String manh) {
		for(NhaHangDTO nh: DichVuBUS.nhDTO) {
			if(nh.getMaso().equals(manh)) {
				return nh.getTendv();
			}
		}
		return null;
	}
	public String GetTenPT(String mapt) {
		for(PhuongTienDTO pt: DichVuBUS.ptDTO) {
			if(pt.getMaso().equals(mapt)) {
				return pt.getTendv();
			}
		}
		return null;
	}
	public KHTourDTO GetKHTDaChon() {
		int row = table.getSelectedRow();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		String makht = model_table.getValueAt(row, 2) + "";
		for(KHTourDTO kht:KHToursBUS.khtList) {
			if(kht.getMakht().equals(makht)) {
				return kht;
			}
		}
		return null;
	}
	

}