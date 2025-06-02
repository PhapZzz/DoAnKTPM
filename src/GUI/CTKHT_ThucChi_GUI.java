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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

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
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.CTKHT_ThucChiBUS;
import BUS.ChiTietKHT_BUS;
import BUS.DichVuBUS;
import BUS.KHToursBUS;
import BUS.QlyToursBUS;
import BUS.taikhoanBUS;
import DAO.ChiTietKHT_DAO;
import DTO.CTDV_An_DTO;
import DTO.CTDV_KS_DTO;
import DTO.CTDV_PT_DTO;
import DTO.CTKHT_DTO;
import DTO.CTKHT_ThucChiDTO;
import DTO.KHTourDTO;
import DTO.KhachSanDTO;
import DTO.NhaHangDTO;
import DTO.PhuongTienDTO;
import DTO.QlyToursDTO;
import DTO.SdDichVuDTO;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;

public class CTKHT_ThucChi_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfNgay;
	private JTextField tfThanhTienKS;
	private JTextField tfThanhTienNhaHang;
	private JTextField tfThanhTienPhuongTien;
	private JTextField tfTongTien;
	JButton btn_QLTour,btn_KHTour,btn_QLDV,btn_KhuyenMai,btn_NhanVien,btn_KhachHang;
	JButton btnLuu,btnThoat,btnThem,btnDuKien,btnThucChi;
	JComboBox cbMaKHT;
	private SdDichVuDTO sddv;
	private CTDV_An_DTO dvAn;
	private CTDV_PT_DTO dvPT;
	private CTDV_KS_DTO dvKS;
	private int comparison=5;
	private double thanhtienks=0,thanhtienpt=0,thanhtiennh=0;
	JPanel panel_2;
	
	CTKHT_ThucChiBUS thucchiBUS=new CTKHT_ThucChiBUS();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField tfMaKHT;
	private JTextField tfKhachSan;
	private JTextField tfNhahang;
	private JTextField tfPhuongtien;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CTKHT_ThucChi_GUI frame = new CTKHT_ThucChi_GUI();
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
	public CTKHT_ThucChi_GUI() {
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
		
	btn_QLTour = new JButton("Quản lý Tours");
		btn_QLTour.setBorderPainted(false);
		btn_QLTour.setFocusable(false);
		btn_QLTour.setBorder(null);
		btn_QLTour.setBackground(new Color(24, 171, 138));
		btn_QLTour.setForeground(new Color(255, 255, 255));
		btn_QLTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_QLTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				QuanLyTour qlt = new QuanLyTour();
				qlt.btn_QLTour.setBackground(Color.ORANGE);
				qlt.btn_QLTour.setForeground(Color.BLACK);
			}
		});
		btn_QLTour.setBounds(126, 65, 120, 40);
		panel.add(btn_QLTour);
		
		JButton btn_QLDV = new JButton("Quản lý dịch vụ");
		btn_QLDV.setFocusable(false);
		btn_QLDV.setBorder(null);
		btn_QLDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DichVu dv = new DichVu();
				dv.btn_QLDV.setBackground(Color.ORANGE);
				dv.btn_QLDV.setForeground(Color.BLACK);
			}
		});
		btn_QLDV.setForeground(new Color(255, 255, 255));
		btn_QLDV.setBackground(new Color(24, 171, 138));
		btn_QLDV.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_QLDV.setBounds(420, 65, 120, 40);
		panel.add(btn_QLDV);
		
		btn_KhachHang = new JButton("Khách hàng");
		btn_KhachHang.setFocusable(false);
		btn_KhachHang.setBorder(null);
		btn_KhachHang.setForeground(new Color(255, 255, 255));
		btn_KhachHang.setBackground(new Color(24, 171, 138));
		btn_KhachHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_KhachHang.setBounds(853, 65, 120, 40);
		panel.add(btn_KhachHang);
		btn_KhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				KhachHang kh = new KhachHang();
				kh.btn_KhachHang.setBackground(Color.ORANGE);
				kh.btn_KhachHang.setForeground(Color.BLACK);
			}
		});
		
		
		btn_NhanVien = new JButton("Nhân viên");
		btn_NhanVien.setFocusable(false);
		btn_NhanVien.setBorder(null);
		btn_NhanVien.setForeground(new Color(255, 255, 255));
		btn_NhanVien.setBackground(new Color(24, 171, 138));
		btn_NhanVien.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_NhanVien.setBounds(708, 65, 120, 40);
		btn_NhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				NhanVien nv = new NhanVien();
				nv.btn_NhanVien.setBackground(Color.ORANGE);
				nv.btn_NhanVien.setForeground(Color.BLACK);
			}
		});
		panel.add(btn_NhanVien);
		
		btn_KhuyenMai = new JButton("Khuyến mãi");
		btn_KhuyenMai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				setVisible(false);
				KhuyenMai km = new KhuyenMai();
				km.btn_KhuyenMai.setBackground(Color.ORANGE);
				km.btn_KhuyenMai.setForeground(Color.BLACK);
			}
		});
		btn_KhuyenMai.setFocusable(false);
		btn_KhuyenMai.setBorder(null);
		btn_KhuyenMai.setForeground(new Color(255, 255, 255));
		btn_KhuyenMai.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_KhuyenMai.setBackground(new Color(24, 171, 138));
		btn_KhuyenMai.setBounds(564, 65, 120, 40);
		panel.add(btn_KhuyenMai);
		
		taikhoanBUS tkBUS = new taikhoanBUS();
		JLabel lblNewLabel = new JLabel("Xin chào " + tkBUS.getName(TrangChuGUI.tkDTO.getUser()));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(743, 24, 230, 30);
		panel.add(lblNewLabel);
		
		ImageIcon image = new ImageIcon("src\\Images\\logo.png");
		JLabel label = new JLabel();
		label.setBackground(new Color(0, 128, 255));
		label.setBounds(13, 31, 90, 90);
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
		
		JLabel lb_TTKH = new JLabel("CTKHT_Thực chi");
		lb_TTKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_TTKH.setBounds(19, 10, 240, 30);
		KhachHang.add(lb_TTKH);
		
		String [] item_gender = {"Nam","Nữ"};
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(290, 50, 660, 402);
		KhachHang.add(scrollPane_2);
		
		table = new JTable();
		scrollPane_2.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(269, 10, 681, 30);
		KhachHang.add(panel_3);
		panel_3.setLayout(null);
		
		btnThem = new JButton("Cập nhật");
		btnThem.setFocusable(false);
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(65, 105, 225));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(463, 3, 100, 25);
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row==-1) {
					JOptionPane.showMessageDialog(panel, "Chưa chọn chi tiết muốn cập nhật.");
					return;
				}
				KHTourDTO kht=GetKHT(KHTourGUI.makht_row);
				LocalDate currentDate = LocalDate.now();
			    Date currentDateSql = Date.valueOf(currentDate);
				if(kht.getNgayve().before(currentDateSql)) {	
					btnLuu.setEnabled(true);
					btnLuu.setBackground(Color.orange);
					btnThoat.setEnabled(true);
					btnThoat.setBackground(Color.red);
					tfThanhTienKS.setEditable(true);
					tfThanhTienNhaHang.setEditable(true);
					tfThanhTienPhuongTien.setEditable(true);
					noneInit();	
					tfTongTien.setText("0");
				}else {
					JOptionPane.showMessageDialog(panel, "Kế hoạch tour chưa kết thúc,không được cập nhật.");
					return;
				}
			}
		});
		panel_3.add(btnThem);
		
		String []condType= {"Mã Khách sạn","Mã Nhà hàng","Mã phương tiện"};
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQuayLai.setFocusable(false);
		btnQuayLai.setBackground(new Color(255, 0, 0));
		btnQuayLai.setBounds(581, 3, 100, 25);
		btnQuayLai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChiTietKeHoachTourGUI.makht_ctkht=KHTourGUI.makht_row;
//				DefaultTableModel model_table = (DefaultTableModel) table.getModel();
//				makht_row = model_table.getValueAt(row, 1) + "";
				setVisible(false);
				new KHTourGUI();
				
			}
			
		});
		panel_3.add(btnQuayLai);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(19, 50, 261, 435);
		KhachHang.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Mã KHT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 17, 73, 13);
		panel_2.add(lblNewLabel_2);
		
		tfNgay = new JTextField();
		tfNgay.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNgay.setEditable(false);
		tfNgay.setColumns(10);
		tfNgay.setBounds(106, 46, 134, 26);
		panel_2.add(tfNgay);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ngày");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 48, 61, 20);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Khách sạn");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 82, 86, 20);
		panel_2.add(lblNewLabel_2_2);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuu.setFocusable(false);
		btnLuu.setBackground(new Color(255, 128, 64));
		btnLuu.setBounds(28, 386, 85, 26);
		btnLuu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SuaCTKHT();
//				ResetData();
				XoaDataTable();
				init();
				initData();
		
		}});
		panel_2.add(btnLuu);
		
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Thành tiền");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(10, 126, 86, 20);
		panel_2.add(lblNewLabel_2_1_1);
		
		tfThanhTienKS = new JTextField();
		tfThanhTienKS.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfThanhTienKS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfThanhTienKS.setColumns(10);
		tfThanhTienKS.setBounds(106, 124, 134, 26);
		panel_2.add(tfThanhTienKS);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Nhà hàng");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(10, 171, 86, 20);
		panel_2.add(lblNewLabel_2_2_1);
		
		
		tfThanhTienNhaHang = new JTextField();
		tfThanhTienNhaHang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfThanhTienNhaHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfThanhTienNhaHang.setColumns(10);
		tfThanhTienNhaHang.setBounds(106, 213, 134, 26);
		panel_2.add(tfThanhTienNhaHang);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Thành tiền");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(10, 215, 86, 20);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Phương tiện");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_2.setBounds(10, 258, 98, 20);
		panel_2.add(lblNewLabel_2_2_2);
		
		
		tfThanhTienPhuongTien = new JTextField();
		tfThanhTienPhuongTien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfThanhTienPhuongTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfThanhTienPhuongTien.setColumns(10);
		tfThanhTienPhuongTien.setBounds(106, 300, 134, 26);
		panel_2.add(tfThanhTienPhuongTien);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Thành tiền");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_2.setBounds(10, 302, 86, 20);
		panel_2.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Tổng tiền");
		lblNewLabel_2_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_2_1.setBounds(10, 340, 86, 20);
		panel_2.add(lblNewLabel_2_1_1_2_1);
		
		tfTongTien = new JTextField();
		tfTongTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTongTien.setEditable(false);
		tfTongTien.setColumns(10);
		tfTongTien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfTongTien.setBounds(106, 338, 134, 26);
		panel_2.add(tfTongTien);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setFocusable(false);
		btnThoat.setBackground(new Color(255, 0, 0));
		btnThoat.setBounds(136, 386, 85, 26);
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ResetData();
				init();
			}
		});
		panel_2.add(btnThoat);
		
		tfMaKHT = new JTextField();
		tfMaKHT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfMaKHT.setEditable(false);
		tfMaKHT.setColumns(10);
		tfMaKHT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfMaKHT.setBounds(106, 10, 134, 26);
		panel_2.add(tfMaKHT);
		
		tfKhachSan = new JTextField();
		tfKhachSan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfKhachSan.setEditable(false);
		tfKhachSan.setColumns(10);
		tfKhachSan.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfKhachSan.setBounds(106, 82, 134, 26);
		panel_2.add(tfKhachSan);
		
		tfNhahang = new JTextField();
		tfNhahang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNhahang.setEditable(false);
		tfNhahang.setColumns(10);
		tfNhahang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfNhahang.setBounds(106, 165, 134, 26);
		panel_2.add(tfNhahang);
		
		tfPhuongtien = new JTextField();
		tfPhuongtien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPhuongtien.setEditable(false);
		tfPhuongtien.setColumns(10);
		tfPhuongtien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfPhuongtien.setBounds(106, 256, 134, 26);
		panel_2.add(tfPhuongtien);
		
		btnThucChi = new JButton("Thực chi");
		btnThucChi.setForeground(Color.WHITE);
		btnThucChi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThucChi.setFocusable(false);
		btnThucChi.setBackground(new Color(0, 128, 0));
		btnThucChi.setBounds(850, 462, 100, 26);
		KhachHang.add(btnThucChi);
		
		btnDuKien = new JButton("Dự kiến");
		btnDuKien.setForeground(Color.WHITE);
		btnDuKien.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDuKien.setFocusable(false);
		btnDuKien.setBackground(new Color(0, 128, 0));
		btnDuKien.setBounds(722, 462, 100, 26);
		btnDuKien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ChiTietKeHoachTourGUI();
				
			}
		});
		KhachHang.add(btnDuKien);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(13, 127, 863, 495);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin tours");
		lblNewLabel_1.setBounds(29, 10, 134, 30);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(new Rectangle(0, 0, 190, 300));
		scrollPane_1.setAutoscrolls(true);
		scrollPane_1.setEnabled(false);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(29, 68, 190, 300);
		panel_1.add(scrollPane_1);
		
		JButton btn_KHTour = new JButton("Kế hoạch Tours");
		btn_KHTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				KHTourGUI kht = new KHTourGUI();
				kht.btn_KHTour.setBackground(Color.ORANGE);
				kht.btn_KHTour.setForeground(Color.BLACK);
			}
		});
		init();
		initData();
		btn_KHTour.setForeground(Color.WHITE);
		btn_KHTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_KHTour.setFocusable(false);
		btn_KHTour.setBorderPainted(false);
		btn_KHTour.setBorder(null);
		btn_KHTour.setBackground(new Color(24, 171, 138));
		btn_KHTour.setBounds(273, 65, 120, 40);
		panel.add(btn_KHTour);
		this.setVisible(true);
	}
	
	public void init() {
		KHTourDTO kht1=GetKHT(KHTourGUI.makht_row);
		tfMaKHT.setText(KHTourGUI.makht_row);
		tfNgay.setText(kht1.getNgaydi().toString());
		btnThucChi.setBackground(Color.ORANGE);
		tfThanhTienKS.setEditable(false);
		tfThanhTienNhaHang.setEditable(false);
		tfThanhTienPhuongTien.setEditable(false);
		btnLuu.setEnabled(false);
		btnLuu.setBackground(Color.LIGHT_GRAY);
		btnThoat.setEnabled(false);
		btnThoat.setBackground(Color.LIGHT_GRAY);
		
	}
	
	public void initData() {
		KHTourDTO kht=GetKHT(KHTourGUI.makht_row);
		String[] colNames = { "Mã KHT", "Ngày", "Mã Khách sạn", "Thành tiền", "Mã Nhà hàng", "Thành tiền","Mã Phương tiện","Thành tiền","Tổng tiền" };
		DefaultTableModel tableModel = new DefaultTableModel();
		table.setModel(tableModel);
		tableModel.setColumnIdentifiers(colNames);
		table.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					HienThiChiTietKHT();
				}
			}
		});
		for (CTKHT_ThucChiDTO ctkht : CTKHT_ThucChiBUS.thucchiList) {
			if(ctkht.getMakht().equals(KHTourGUI.makht_row)) {
				tableModel.addRow(new Object[] { ctkht.getMakht(), ctkht.getNgay(), ctkht.getMaks(),
						ctkht.getThanhtienks()+"", ctkht.getManh(), ctkht.getThanhtiennh()+"",ctkht.getMapt(),ctkht.getThanhtienpt()+"",ctkht.getTongtien()+"" });
			}
		}
	}
	
	public void initData2(ArrayList<CTKHT_DTO> list) {
//		String[] colNames = { "Mã KHT", "Ngày", "Mã Khách sạn", "Thành tiền", "Mã Nhà hàng", "Thành tiền","Mã Phương tiện","Thành tiền","Tổng tiền" };
//		DefaultTableModel tableModel = new DefaultTableModel();
//		table.setModel(tableModel);
//		tableModel.setColumnIdentifiers(colNames);
//		table.addMouseListener((MouseListener) new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				if (e.getClickCount() == 1) {
//					HienThiChiTietKHT();
//				}
//			}
//		});
//		for (CTKHT_DTO ctkht : list) {
//			tableModel.addRow(new Object[] { ctkht.getMakht(), ctkht.getNgay(), ctkht.getMaks(),
//					ctkht.getThanhtienKS()+"", ctkht.getManh(), ctkht.getThanhtienNH()+"",ctkht.getMapt(),ctkht.getThanhtienPT()+"",ctkht.getTongtien()+"" });
//		}
	}
	
	public void HienThiChiTietKHT() {
		CTKHT_ThucChiDTO ctkht = getCTKHT_DaChon();
		tfMaKHT.setText(ctkht.getMakht());
		tfNgay.setText(ctkht.getNgay().toString());
		tfKhachSan.setText(ctkht.getMaks());
		tfThanhTienKS.setText(ctkht.getThanhtienks()+"");
		tfNhahang.setText(ctkht.getManh());
		tfThanhTienNhaHang.setText(ctkht.getThanhtiennh()+"");
		tfPhuongtien.setText(ctkht.getMapt());
		tfThanhTienPhuongTien.setText(ctkht.getThanhtienpt()+"");
		tfTongTien.setText(ctkht.getTongtien()+"");
	}
	
	public void noneInit() {
		tfThanhTienKS.setEditable(true);
		tfThanhTienNhaHang.setEditable(true);
		tfThanhTienPhuongTien.setEditable(true);
	}
	
	public CTKHT_ThucChiDTO getCTKHT_DaChon() {
		int row = table.getSelectedRow();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		String makht = model_table.getValueAt(row, 0) + "";
		String ngay_tmp = model_table.getValueAt(row, 1) + "";
		java.sql.Date ngay=null;
		java.util.Date ngaytmp;
		try {
			ngaytmp = new SimpleDateFormat("yyyy-MM-dd").parse(ngay_tmp);
			ngay=new java.sql.Date(ngaytmp.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     

		for(CTKHT_ThucChiDTO ctkht:CTKHT_ThucChiBUS.thucchiList) {
			if(ctkht.getMakht().equals(makht)&&ctkht.getNgay().compareTo(ngay)==0) {
				return ctkht;
			}
		}
		return null;	
	}
	
	public void ResetData() {
		tfNgay.setText("");
		tfKhachSan.setText("");
		tfThanhTienKS.setText("");
		tfNhahang.setText("");
		tfThanhTienNhaHang.setText("");
		tfPhuongtien.setText("");
		tfThanhTienPhuongTien.setText("");
		tfTongTien.setText("");
	}
	public void ThemCTKHT() {		
		String makht=tfMaKHT.getText().toString();
		String ngay_tmp=tfNgay.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date ngay1=null;
        try {
            ngay1 = sdf.parse(ngay_tmp);
        } catch (ParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }
        java.sql.Date ngay=new java.sql.Date(ngay1.getTime());
		String MaKS=tfKhachSan.getText().toString();
		double thanhtienKS=Double.parseDouble(tfThanhTienKS.getText());
		String MaNH=tfNhahang.getText();
		double thanhtienNH=Double.parseDouble(tfThanhTienNhaHang.getText());
		String MaPT=tfPhuongtien.getText();
		double thanhtienPT=Double.parseDouble(tfThanhTienPhuongTien.getText());
		double tongtien=thanhtienKS+thanhtienNH+thanhtienPT;
		
		CTKHT_ThucChiDTO ctkht=new CTKHT_ThucChiDTO(makht, MaKS, MaPT, MaNH, thanhtienKS, thanhtienPT, thanhtienNH, tongtien, ngay);
			
		if (thucchiBUS.them(ctkht) == -1) {
			JOptionPane.showMessageDialog(this, "Lỗi!");
		} else {
			JOptionPane.showMessageDialog(this, "Thêm thành công!");
		}
	}
	
	public void XoaDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.setRowCount(0);
	}
	
	public KHTourDTO GetKHT(String MaKHt) {
		for(KHTourDTO kht:KHToursBUS.khtList) {
			if(kht.getMakht().equals(MaKHt)) {
				return kht;
			}
		}
		return null;
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
	
	public void SuaCTKHT() {
		CTKHT_ThucChiDTO ctkht = getCTKHT_DaChon();
		ctkht.setThanhtienks(Double.parseDouble(tfThanhTienKS.getText()));
		ctkht.setThanhtiennh(Double.parseDouble(tfThanhTienNhaHang.getText()));
		ctkht.setThanhtienpt(Double.parseDouble(tfThanhTienPhuongTien.getText()));
		double thanhtienKS=Double.parseDouble(tfThanhTienKS.getText());
		double thanhtienNH=Double.parseDouble(tfThanhTienNhaHang.getText());
		double thanhtienPT=Double.parseDouble(tfThanhTienPhuongTien.getText());
		double tongtien=thanhtienKS+thanhtienNH+thanhtienPT;
		ctkht.setTongtien(tongtien);
		tfTongTien.setText(tongtien+"");
		if (thucchiBUS.sua(ctkht) == -1) {
			JOptionPane.showMessageDialog(this, "Lỗi!");
		} else {
			JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
		}
		
	}
}
