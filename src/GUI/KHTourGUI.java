package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageProducer;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import com.toedter.calendar.JDateChooser;

import BUS.ChiTietKHT_BUS;
import BUS.DichVuBUS;
import BUS.KHToursBUS;
import BUS.QlyToursBUS;
import DTO.CTKHT_DTO;
import DTO.KHTourDTO;
import DTO.KhachSanDTO;
import DTO.NhaHangDTO;
import DTO.PhuongTienDTO;
import DTO.QlyToursDTO;
import BUS.taikhoanBUS;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class KHTourGUI extends JFrame {

	// private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField timkiem_tf;
	JButton btn_QLTour, btn_KHTour, btn_QLDV, btn_KhuyenMai, btn_NhanVien, btn_KhachHang;
	KHToursBUS khtBUS=new KHToursBUS();
	ChiTietKHT_BUS ctkhtBUS=new ChiTietKHT_BUS();
	private JTextField tfSongay;
	JTextField tfHuongDanVien;
	private JTextField tfGiaVe;
	private JTextField tfTongChi;
	private JTextField tfMaKHT;
	JComboBox cbMatour;
	JTextArea textAreaMoTa;
	JComboBox cbSoCho;
	JDateChooser ngaydi_date;
	JDateChooser ngayve_date;
	JButton anh1_btn;
	JButton anh2_btn;
	JButton anh3_btn;
	JButton btnLuu;
	JButton btnThoat;
	JPanel panel_2;
	private JTable table;
	JTextArea textArea_mota;
	JLabel hinh3_lb;
	JLabel hinh2_lb;
	JLabel hinh1_lb;
	JLabel lbTenTour;
	JLabel lbGiaTour;
	JLabel thoigian_lb;
	JLabel noikhoihanh_lb;
	JLabel sochoconnhan_lb;
	JLabel lbThoigian,lbNoikhoihanh;
	JLabel lbSoChoConNhan;
	String anh1_path="",anh2_path="",anh3_path="";
	JButton btnThem,btnXoa,btnSua;
	JComboBox cbTimkiem;
	public static String makht_row;
	private JButton btn_chon_nv;
	private String key_Tour;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KHTourGUI frame = new KHTourGUI();
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
	public KHTourGUI() {
		this.setBackground(SystemColor.windowText);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 1000, 650);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
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

		btn_KHTour = new JButton("Kế hoạch Tours");
		btn_KHTour.setForeground(Color.WHITE);
		btn_KHTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_KHTour.setFocusable(false);
		btn_KHTour.setBorderPainted(false);
		btn_KHTour.setBorder(null);
		btn_KHTour.setBackground(new Color(24, 171, 138));
		btn_KHTour.setBounds(273, 65, 120, 40);
		btn_KHTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				KHTourGUI kht = new KHTourGUI();
				kht.btn_KHTour.setBackground(Color.ORANGE);
				kht.btn_KHTour.setForeground(Color.BLACK);
			}
		});
		btn_QLTour.setBounds(126, 65, 120, 40);
		panel.add(btn_KHTour);

		btn_QLDV = new JButton("Quản lý dịch vụ");
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
		panel.add(btn_NhanVien);
		btn_NhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				NhanVien nv = new NhanVien();
				nv.btn_NhanVien.setBackground(Color.ORANGE);
				nv.btn_NhanVien.setForeground(Color.BLACK);
			}
		});

		btn_KhuyenMai = new JButton("Khuyến mãi");
		btn_KhuyenMai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		JButton btnNewButton_2 = new JButton("Đổi mật khẩu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatKhauGUI mk = new MatKhauGUI();
				
			}
		});
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(849, 24, 124, 30);
		panel.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("User");
		
		

		lblNewLabel = new JLabel("Xin chào " + TrangChuGUI.tkBUS.getName(TrangChuGUI.tkDTO.getUser()));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(609, 23, 230, 30);
		panel.add(lblNewLabel);
		JLabel logo_lb = new JLabel();
		logo_lb.setBackground(new Color(128, 255, 128));
		logo_lb.setPreferredSize(new Dimension(90, 90));
		logo_lb.setBounds(10, 25, 100, 96);
//		ImageIcon originalIcon = new ImageIcon("/Images/vtv-logo.png");
		ImageIcon originalIcon = new ImageIcon("src\\Images\\logo.png");
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(logo_lb.getPreferredSize().width,
				logo_lb.getPreferredSize().height, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		// logo_lb.setIcon(new
		// ImageIcon(QlyToursGUI.class.getResource("/Images/vtv-logo.png")));
		logo_lb.setIcon(scaledIcon);
		logo_lb.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				setVisible(false);
				TrangChuGUI tc = new TrangChuGUI();
				tc.btn_TrangChu.setBackground(Color.ORANGE);
				tc.btn_TrangChu.setForeground(Color.BLACK);
			}
		});
		panel.add(logo_lb);

		Panel KHTOUR = new Panel();
		KHTOUR.setBackground(new Color(255, 255, 255));
		KHTOUR.setBounds(13, 127, 960, 495);
		panel.add(KHTOUR);
		KHTOUR.setLayout(null);

		JLabel thongtintour_lb = new JLabel("Thông tin Kế hoạch Tour");
		thongtintour_lb.setForeground(new Color(0, 0, 0));
		thongtintour_lb.setBounds(10, 10, 230, 30);
		thongtintour_lb.setFont(new Font("Tahoma", Font.BOLD, 17));
		KHTOUR.add(thongtintour_lb);

		String[] loaiTour = { "Tour trong nước", "Tour nước ngoài" };

		String[] socho = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20" };

		String[] arr_tinh = { "An Giang", "Bà Rịa – Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh",
				"Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ",
				"Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam",
				"Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Thành phố Hồ Chí Minh",
				"Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lạng Sơn", "Lào Cai", "Lâm Đồng",
				"Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình",
				"Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình",
				"Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long",
				"Vĩnh Phúc", "Yên Bái" };

		timkiem_tf = new JTextField();
		timkiem_tf.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		timkiem_tf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		timkiem_tf.setBounds(250, 9, 230, 30);
		timkiem_tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String condition = timkiem_tf.getText();
				if(condition.isEmpty()) return;
				String condType = (String)cbTimkiem.getSelectedItem();
				ArrayList<KHTourDTO> t = khtBUS.timkiem(condition, condType);
				if (t == null) {
					JOptionPane.showMessageDialog(panel, "Lỗi!");
				} else {
					XoaDataTable();
					initData2(t);
				}
				
			}
		});
		KHTOUR.add(timkiem_tf);
		timkiem_tf.setColumns(10);
		KHTOUR.setBackground(new Color(255, 255, 255));

//	JOptionPane.showMessageDialog(this, "Thêm thành công!");

		JButton ctkehoachtour_btn = new JButton("Chi tiết");
		ctkehoachtour_btn.setFocusable(false);
		ctkehoachtour_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row==-1) {
					JOptionPane.showMessageDialog(panel, "Bạn chưa chọn KHT muốn xem chi tiết.");
					return;
				}
				else {
					makht_row="";
					DefaultTableModel model_table = (DefaultTableModel) table.getModel();
					makht_row = model_table.getValueAt(row, 1) + "";
					setVisible(false);
					new ChiTietKeHoachTourGUI();
				}
			}
		});
		ctkehoachtour_btn.setForeground(new Color(255, 255, 255));
		ctkehoachtour_btn.setBackground(new Color(255, 102, 0));
		ctkehoachtour_btn.setBorder(null);
		ctkehoachtour_btn.setFont(new Font("Tahoma", Font.BOLD, 13));
		ctkehoachtour_btn.setBounds(875, 10, 75, 25);
		KHTOUR.add(ctkehoachtour_btn);
		KHTOUR.setBackground(new Color(255, 255, 255));
		
		btnSua = new JButton("Sửa");
		btnSua.setFocusable(false);
		btnSua.setBackground(new Color(50, 205, 50));
		btnSua.setBorder(null);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setBounds(700, 10, 80, 25);
		btnSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnXoa.setEnabled(false);
				btnXoa.setBackground(Color.GRAY);
				btnThem.setEnabled(false);
				btnThem.setBackground(Color.GRAY);
				btnLuu.setEnabled(true);
				btnLuu.setBackground(Color.orange);
				noneInit();
				tfMaKHT.setEditable(false);
				cbMatour.setEnabled(false);
				ngaydi_date.setEnabled(false);
				ngayve_date.setEnabled(false);
			}
		});
		KHTOUR.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFocusable(false);
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setBorder(null);
		btnXoa.setBounds(790, 10, 75, 25);
		btnXoa.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				KHTourDTO kht = GetKHTDaChon();
				if (khtBUS.xoa(kht) == -1) {
					JOptionPane.showMessageDialog(panel, "Lỗi!");
				} else {
					XoaDataTable();
					initData();
					Reset();
					JOptionPane.showMessageDialog(panel, "Xóa thành công!");
				}
			}
		});
		KHTOUR.add(btnXoa);
		
		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnThem.setBackground(new Color(65, 105, 255));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBorder(null);
		btnThem.setBounds(615, 10, 75, 25);
		btnThem.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				btnXoa.setEnabled(false);
				btnXoa.setBackground(Color.GRAY);
				btnSua.setEnabled(false);
				btnSua.setBackground(Color.GRAY);
				btnLuu.setEnabled(true);
				btnLuu.setBackground(Color.orange);
				Reset();
				noneInit();
				tfSongay.setText(getTour((String) cbMatour.getSelectedItem()).getSongay()+"");
				tfTongChi.setText("Chưa cập nhật");
				java.util.Date currentDate = (java.util.Date) ngaydi_date.getDate();
                java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(sqlDate);
                calendar.add(Calendar.DAY_OF_MONTH, getTour((String) cbMatour.getSelectedItem()).getSongay()-1);
                ngayve_date.setDate(calendar.getTime());
//                ngayve_date.setEnabled(false);
				
			}
		});
		KHTOUR.add(btnThem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(171, 183, 0, 109);
		KHTOUR.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 50, 230, 435);
		KHTOUR.add(scrollPane_1);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setPreferredSize(new Dimension(210, 925));
		panel_2.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(panel_2);
		
		JLabel matour_lb = new JLabel("Mã Tour :");
		matour_lb.setForeground(Color.BLACK);
		matour_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		matour_lb.setBounds(10, 10, 153, 35);
		panel_2.add(matour_lb);
		
		JLabel loaitour_lb = new JLabel("Mã Kế hoạch Tour :");
		loaitour_lb.setForeground(Color.BLACK);
		loaitour_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		loaitour_lb.setBounds(10, 77, 153, 35);
		panel_2.add(loaitour_lb);
		
		JLabel mota_lb = new JLabel("Mô tả :");
		mota_lb.setForeground(Color.BLACK);
		mota_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		mota_lb.setBounds(10, 148, 153, 35);
		panel_2.add(mota_lb);
		
		JLabel socho_lb = new JLabel("Số chỗ :");
		socho_lb.setForeground(Color.BLACK);
		socho_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		socho_lb.setBounds(10, 237, 153, 35);
		panel_2.add(socho_lb);
		
		String [] arrSocho= {"1","2","3","4","5","6","7","8","9","10",
				"11","12","13","14","15","16","17","18","19","20"};
		cbSoCho = new JComboBox(arrSocho);
		cbSoCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                   ngaydi_date.requestFocusInWindow();
                    // Perform actions based on the selected item
                }
            }
        });
		cbSoCho.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbSoCho.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cbSoCho.setBackground(Color.WHITE);
		cbSoCho.setBounds(10, 268, 70, 35);
		panel_2.add(cbSoCho);
		
		JLabel ngaydi_lb = new JLabel("Ngày đi :");
		ngaydi_lb.setForeground(Color.BLACK);
		ngaydi_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		ngaydi_lb.setBounds(10, 304, 153, 35);
		panel_2.add(ngaydi_lb);
		
		ngaydi_date = new JDateChooser();
		ngaydi_date.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ngaydi_date.setBounds(10, 340, 190, 35);
		ngaydi_date.addPropertyChangeListener(new PropertyChangeListener() {
	        @Override
	        public void propertyChange(PropertyChangeEvent e) {
	            if ("date".equals(e.getPropertyName())) {
	            	java.util.Date currentDate = (java.util.Date) e.getNewValue();
	                java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
	                Calendar calendar = Calendar.getInstance();
	                calendar.setTime(sqlDate);
	                calendar.add(Calendar.DAY_OF_MONTH, getTour((String) cbMatour.getSelectedItem()).getSongay()-1);
	                ngayve_date.setDate(calendar.getTime());
	            }
	        }
		});
		panel_2.add(ngaydi_date);
		
		JLabel ngayve_lb = new JLabel("Ngày về :");
		ngayve_lb.setForeground(Color.BLACK);
		ngayve_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		ngayve_lb.setBounds(10, 375, 153, 35);
		panel_2.add(ngayve_lb);
		
		ngayve_date = new JDateChooser();
		ngayve_date.setEnabled(false);
		ngayve_date.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ngayve_date.setBounds(10, 404, 190, 35);
		panel_2.add(ngayve_date);
		
		JLabel songay_lb = new JLabel("Số ngày :");
		songay_lb.setForeground(Color.BLACK);
		songay_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		songay_lb.setBounds(10, 437, 153, 35);
		panel_2.add(songay_lb);
		
		tfSongay = new JTextField();
		tfSongay.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfHuongDanVien.requestFocusInWindow();
				}
			}
		});
		tfSongay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfSongay.setEditable(false);
		tfSongay.setColumns(10);
		tfSongay.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfSongay.setBounds(10, 469, 70, 35);
		panel_2.add(tfSongay);
		
		JLabel huongdanvien_lb = new JLabel("Hướng dẫn viên :");
		huongdanvien_lb.setForeground(Color.BLACK);
		huongdanvien_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		huongdanvien_lb.setBounds(10, 505, 153, 35);
		panel_2.add(huongdanvien_lb);
		
		tfHuongDanVien = new JTextField();
		tfHuongDanVien.setEnabled(false);
		tfHuongDanVien.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfGiaVe.requestFocusInWindow();
				}
			}
		});
		tfHuongDanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfHuongDanVien.setColumns(10);
		tfHuongDanVien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfHuongDanVien.setBounds(10, 538, 143, 35);
		panel_2.add(tfHuongDanVien);
		
		JLabel giave_lb = new JLabel("Giá vé :");
		giave_lb.setForeground(Color.BLACK);
		giave_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		giave_lb.setBounds(10, 571, 153, 35);
		panel_2.add(giave_lb);
		
		tfGiaVe = new JTextField("");
		tfGiaVe.setEnabled(false);
		tfGiaVe.setText("0");
		tfGiaVe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfGiaVe.setColumns(10);
		tfGiaVe.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfGiaVe.setBounds(10, 600, 190, 35);
		panel_2.add(tfGiaVe);
		
		JLabel tongchi_lb = new JLabel("Tổng chi :");
		tongchi_lb.setForeground(new Color(0, 0, 128));
		tongchi_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		tongchi_lb.setBounds(10, 638, 153, 35);
		panel_2.add(tongchi_lb);
		
		tfTongChi = new JTextField();
		tfTongChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfTongChi.setEditable(false);
		tfTongChi.setColumns(10);
		tfTongChi.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfTongChi.setBounds(10, 673, 190, 35);
		panel_2.add(tfTongChi);
		
		JLabel anh1_lb = new JLabel("Ảnh 1:");
		anh1_lb.setForeground(new Color(0, 0, 128));
		anh1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		anh1_lb.setBounds(10, 718, 60, 35);
		panel_2.add(anh1_lb);
		
		anh1_btn = new JButton("Thêm");
		anh1_btn.setFocusable(false);
		anh1_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		anh1_btn.setBackground(Color.CYAN);
		anh1_btn.setBounds(64, 718, 85, 35);
		anh1_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file =new JFileChooser();
				File defaultDirectory = new File("C:\\Users\\Hung\\Pictures"); // Đường dẫn thư mục mặc định
		        file.setCurrentDirectory(defaultDirectory);
				int returnVal = file.showOpenDialog(panel);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                	String path_tmp=file.getSelectedFile().getAbsolutePath();
                	String[] parts = path_tmp.split("\\\\");
                    Path source = Paths.get(path_tmp);
                    // Đường dẫn của thư mục đích
                    String pathString="src/Images/";
                    Path destination = Paths.get(pathString);
                    anh1_path=pathString+parts[parts.length - 1];
                    try {
                        // Sao chép file từ source đến destination                                       
                        if (!Files.exists(Paths.get(anh1_path))) {
                        	Files.copy(source, destination.resolve(source.getFileName()));
                            System.out.println("File copied successfully.");
                        } else {
                            System.out.println("File already exists at the destination.");
                        }
    
                    }catch (FileAlreadyExistsException e1) {
                        System.out.println("File already exists at the destination."); 
                    }catch (IOException e1) {
                        e1.printStackTrace();
                    }
    				ImageIcon img1=new ImageIcon(anh1_path);
    				Image image1 = img1.getImage().getScaledInstance(388, 187, Image.SCALE_DEFAULT);
    		        ImageIcon scaledIcon1 = new ImageIcon(image1);
    				hinh1_lb.setIcon(scaledIcon1);
                }
				
			}
		});
		panel_2.add(anh1_btn);
		
		JLabel anh2_lb = new JLabel("Ảnh 2:");
		anh2_lb.setForeground(new Color(0, 0, 128));
		anh2_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		anh2_lb.setBounds(10, 754, 60, 35);
		panel_2.add(anh2_lb);
		
		anh2_btn = new JButton("Thêm");
		anh2_btn.setFocusable(false);
		anh2_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		anh2_btn.setBackground(Color.CYAN);
		anh2_btn.setBounds(64, 754, 85, 35);
		anh2_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file =new JFileChooser();
				File defaultDirectory = new File("C:\\Users\\Hung\\Pictures"); // Đường dẫn thư mục mặc định
		        file.setCurrentDirectory(defaultDirectory);
				int returnVal = file.showOpenDialog(panel);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                	String path_tmp=file.getSelectedFile().getAbsolutePath();
                	String[] parts = path_tmp.split("\\\\");
                    Path source = Paths.get(path_tmp);
                    // Đường dẫn của thư mục đích
                    String pathString="src/Images/";
                    Path destination = Paths.get(pathString);
                    anh2_path=pathString+parts[parts.length - 1];
                    try {
                        // Sao chép file từ source đến destination                                       
                        if (!Files.exists(Paths.get(anh2_path))) {
                        	Files.copy(source, destination.resolve(source.getFileName()));
                            System.out.println("File copied successfully.");
                        } else {
                            System.out.println("File already exists at the destination.");
                        }
    
                    }catch (FileAlreadyExistsException e1) {
                        System.out.println("File already exists at the destination."); 
                    }catch (IOException e1) {
                        e1.printStackTrace();
                    }
                	
                	ImageIcon img2=new ImageIcon(anh2_path);
            		Image image2 = img2.getImage().getScaledInstance(250, 90, Image.SCALE_DEFAULT);
                    ImageIcon scaledIcon2 = new ImageIcon(image2);
            		hinh2_lb.setIcon(scaledIcon2);
                }
				
			}
		});
		panel_2.add(anh2_btn);
		
		JLabel anh3_lb = new JLabel("Ảnh 3:");
		anh3_lb.setForeground(new Color(0, 0, 128));
		anh3_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		anh3_lb.setBounds(10, 791, 60, 35);
		panel_2.add(anh3_lb);
		
		anh3_btn = new JButton("Thêm");
		anh3_btn.setFocusable(false);
		anh3_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		anh3_btn.setBackground(Color.CYAN);
		anh3_btn.setBounds(64, 791, 85, 35);
		anh3_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file =new JFileChooser();
				File defaultDirectory = new File("C:\\Users\\Hung\\Pictures"); // Đường dẫn thư mục mặc định
		        file.setCurrentDirectory(defaultDirectory);
				int returnVal = file.showOpenDialog(panel);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                	String path_tmp=file.getSelectedFile().getAbsolutePath();
                	String[] parts = path_tmp.split("\\\\");
                    Path source = Paths.get(path_tmp);
                    // Đường dẫn của thư mục đích
                    String pathString="src/Images/";
                    Path destination = Paths.get(pathString);
                    anh3_path=pathString+parts[parts.length - 1];
                    try {
                        // Sao chép file từ source đến destination                                       
                        if (!Files.exists(Paths.get(anh3_path))) {
                        	Files.copy(source, destination.resolve(source.getFileName()));
                            System.out.println("File copied successfully.");
                        } else {
                            System.out.println("File already exists at the destination.");
                        }
    
                    }catch (FileAlreadyExistsException e1) {
                        System.out.println("File already exists at the destination."); 
                    }catch (IOException e1) {
                        e1.printStackTrace();
                    }
                	
                	ImageIcon img3=new ImageIcon(anh3_path);
            		Image image3 = img3.getImage().getScaledInstance(250, 90, Image.SCALE_DEFAULT);
                    ImageIcon scaledIcon3 = new ImageIcon(image3);
            		hinh3_lb.setIcon(scaledIcon3);
                }
			}
		});
		panel_2.add(anh3_btn);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFocusable(false);
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThoat.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnThoat.setBackground(Color.RED);
		btnThoat.setBounds(115, 836, 85, 35);
		btnThoat.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Reset();
				init();
				btnThem.setEnabled(true);
				btnThem.setBackground(Color.BLUE);
				btnXoa.setEnabled(true);
				btnXoa.setBackground(Color.RED);
				btnSua.setEnabled(true);
				btnSua.setBackground(Color.GREEN);
				btnLuu.setEnabled(false);
				btnLuu.setBackground(Color.gray);
			}
		});
		panel_2.add(btnThoat);
		
		JScrollPane mota_sp = new JScrollPane();
		mota_sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mota_sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mota_sp.setBackground(Color.WHITE);
		mota_sp.setBounds(10, 179, 190, 60);
		panel_2.add(mota_sp);
		
		textAreaMoTa = new JTextArea();
		textAreaMoTa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaMoTa.setLineWrap(true);
		textAreaMoTa.setWrapStyleWord(true);
		textAreaMoTa.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				cbSoCho.showPopup();
			}
		});
		
		mota_sp.setViewportView(textAreaMoTa);
		
		tfMaKHT = new JTextField();
		tfMaKHT.setEnabled(false);
		tfMaKHT.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					textAreaMoTa.requestFocusInWindow();
				}
			}
		});
		tfMaKHT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfMaKHT.setColumns(10);
		tfMaKHT.setBounds(10, 110, 190, 35);
		panel_2.add(tfMaKHT);
		
//		cbMatour = new JComboBox();
//		cbMatour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
//		cbMatour.setBounds(10, 39, 190, 35);
//		panel_2.add(cbMatour);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setForeground(new Color(255, 255, 255));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLuu.setEnabled(false);
		btnLuu.setFocusable(false);
		btnLuu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnLuu.setBackground(Color.gray);
		btnLuu.setBounds(20, 836, 85, 35);
		btnLuu.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnXoa.isEnabled()==false&&btnSua.isEnabled()==false) {
					ThemKHT();
				}
				else if(btnXoa.isEnabled()==false&&btnThem.isEnabled()==false) {
					SuaKHT();
				}
			}
		});
		panel_2.add(btnLuu);
		
		String [] arr_timkiem= {"Mã Tour","Mã KHT","Giá vé"};
		cbTimkiem = new JComboBox(arr_timkiem);
		cbTimkiem.setBounds(490, 10, 80, 29);
		KHTOUR.add(cbTimkiem);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(250, 49, 700, 436);
		KHTOUR.add(scrollPane_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(590, 600));
		panel_3.setBackground(Color.WHITE);
		scrollPane_2.setViewportView(panel_3);
		
		JScrollPane table_sp = new JScrollPane();
		table_sp.setForeground(Color.BLACK);
		table_sp.setFont(new Font("Tahoma", Font.BOLD, 10));
		table_sp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_sp.setBounds(10, 10, 664, 172);
		panel_3.add(table_sp);
		
		table = new JTable();
		table_sp.setViewportView(table);
		
		JLabel tentour1_lb = new JLabel("Tên tour");
		tentour1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		tentour1_lb.setBounds(20, 184, 70, 30);
		panel_3.add(tentour1_lb);
		
		JLabel giatour1_lb = new JLabel("Giá tour");
		giatour1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		giatour1_lb.setBounds(417, 184, 100, 30);
		panel_3.add(giatour1_lb);
		
//		JLabel diadiem_lb = new JLabel("Địa điểm");
//		diadiem_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
//		diadiem_lb.setBounds(456, 402, 85, 30);
//		panel_3.add(diadiem_lb);
//		
//		JLabel diadiem_icon = new JLabel(new ImageIcon("src/Images/Designcontest-Ecommerce-Business-Maps.48.png"));
//		diadiem_icon.setBounds(460, 426, 70, 49);
//		panel_3.add(diadiem_icon);
//		
//		JLabel diadiem_nd = new JLabel("New label");
//		diadiem_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
//		diadiem_nd.setBounds(469, 484, 85, 20);
//		panel_3.add(diadiem_nd);
//		
//		JLabel phuongtien_icon = new JLabel(new ImageIcon("src/Images/Bevel-And-Emboss-Car-Van-bus.48.png"));
//		phuongtien_icon.setBackground(new Color(128, 255, 128));
//		phuongtien_icon.setBounds(580, 426, 70, 49);
//		panel_3.add(phuongtien_icon);
//		
//		JLabel nhahang_lb = new JLabel("Nhà hàng");
//		nhahang_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
//		nhahang_lb.setBounds(457, 514, 85, 30);
//		panel_3.add(nhahang_lb);
//		
//		JLabel nhahang_icon = new JLabel(new ImageIcon("src/Images/Iconarchive-Essential-Buildings-Restaurant.48.png"));
//		nhahang_icon.setBackground(new Color(128, 255, 128));
//		nhahang_icon.setBounds(460, 538, 70, 49);
//		panel_3.add(nhahang_icon);
//		
//		JLabel khachsan_lb = new JLabel("Khách sạn");
//		khachsan_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
//		khachsan_lb.setBounds(570, 514, 85, 30);
//		panel_3.add(khachsan_lb);
//		
//		JLabel khachsan_icon = new JLabel(new ImageIcon("src/Images/Iconarchive-Essential-Buildings-Hotel.48.png"));
//		khachsan_icon.setBackground(new Color(128, 255, 128));
//		khachsan_icon.setBounds(575, 538, 70, 49);
//		panel_3.add(khachsan_icon);
		
		JScrollPane mota1_sp = new JScrollPane();
		mota1_sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mota1_sp.setBounds(10, 414, 404, 102);
		panel_3.add(mota1_sp);
		
		textArea_mota = new JTextArea();
		textArea_mota.setLineWrap(true);
		textArea_mota.setWrapStyleWord(true);
		mota1_sp.setViewportView(textArea_mota);
		
		thoigian_lb = new JLabel("Thời gian");
		thoigian_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		thoigian_lb.setBounds(10, 515, 85, 30);
		panel_3.add(thoigian_lb);
		
		noikhoihanh_lb = new JLabel("Nơi khởi hành");
		noikhoihanh_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		noikhoihanh_lb.setBounds(10, 541, 117, 30);
		panel_3.add(noikhoihanh_lb);
		
		sochoconnhan_lb = new JLabel("Số chỗ còn nhận");
		sochoconnhan_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		sochoconnhan_lb.setBounds(10, 571, 134, 30);
		panel_3.add(sochoconnhan_lb);
		
//		JLabel nhahang_nd = new JLabel("New label");
//		nhahang_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
//		nhahang_nd.setBounds(469, 582, 85, 20);
//		panel_3.add(nhahang_nd);
//		
//		JLabel khachsan_nd = new JLabel("New label");
//		khachsan_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
//		khachsan_nd.setBounds(589, 582, 85, 20);
//		panel_3.add(khachsan_nd);
//		
//		JLabel phuongtien_lb = new JLabel("Phương tiện");
//		phuongtien_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
//		phuongtien_lb.setBounds(569, 402, 104, 30);
//		panel_3.add(phuongtien_lb);
//		
//		JLabel phuongtien_nd = new JLabel("New label");
//		phuongtien_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
//		phuongtien_nd.setBounds(589, 484, 85, 20);
//		panel_3.add(phuongtien_nd);
		
		JPanel hinh1_panel = new JPanel();
		hinh1_panel.setLayout(null);
		hinh1_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh1_panel.setBounds(10, 214, 404, 187);
		panel_3.add(hinh1_panel);
		
		hinh1_lb = new JLabel("Hình 1:");
		hinh1_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		hinh1_lb.setBorder(null);
		hinh1_lb.setBackground(Color.WHITE);
		hinh1_lb.setBounds(10, 0, 388, 187);
		hinh1_panel.add(hinh1_lb);
		
		JPanel hinh2_panel = new JPanel();
		hinh2_panel.setLayout(null);
		hinh2_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh2_panel.setBounds(424, 214, 250, 90);
		panel_3.add(hinh2_panel);
		
		hinh2_lb = new JLabel("Hình 2:");
		hinh2_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		hinh2_lb.setBorder(null);
		hinh2_lb.setBackground(Color.WHITE);
		hinh2_lb.setBounds(10, 0, 250, 90);
		hinh2_panel.add(hinh2_lb);
		
		JPanel hinh3_panel = new JPanel();
		hinh3_panel.setLayout(null);
		hinh3_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh3_panel.setBounds(424, 310, 250, 90);
		panel_3.add(hinh3_panel);
		
		hinh3_lb = new JLabel("Hình 3:");
		hinh3_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		hinh3_lb.setBorder(null);
		hinh3_lb.setBackground(Color.WHITE);
		hinh3_lb.setBounds(10, 0, 250, 90);
		hinh3_panel.add(hinh3_lb);
		
		lbTenTour = new JLabel("");
		lbTenTour.setBounds(100, 184, 300, 29);
		panel_3.add(lbTenTour);
		
		lbGiaTour = new JLabel("");
		lbGiaTour.setBounds(484, 184, 190, 29);
		panel_3.add(lbGiaTour);
		
		lbThoigian = new JLabel("Thời gian");
		lbThoigian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbThoigian.setBounds(145, 514, 190, 30);
		panel_3.add(lbThoigian);
		
		lbNoikhoihanh = new JLabel("Nơi khởi hành");
		lbNoikhoihanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNoikhoihanh.setBounds(145, 541, 134, 30);
		panel_3.add(lbNoikhoihanh);
		
		lbSoChoConNhan = new JLabel("Số chỗ còn nhận");
		lbSoChoConNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSoChoConNhan.setBounds(145, 571, 134, 30);
		panel_3.add(lbSoChoConNhan);
		
		btn_chon_nv = new JButton("...");
		btn_chon_nv.setForeground(new Color(0, 0, 0));
		btn_chon_nv.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_chon_nv.setFocusable(false);
		btn_chon_nv.setBackground(new Color(192, 192, 192));
		btn_chon_nv.setBounds(160, 538, 40, 35);
		btn_chon_nv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new infoNhanVien(KHTourGUI.this);
			}
		});
		panel_2.add(btn_chon_nv);
		
		init();
		initData();
		HienThiKHT2();

		this.getContentPane().add(panel);
		this.setVisible(true);
	}
	public void initData() {
		String [] colname= {"Mã Tour","Mã kế hoạch Tour","Ngày đi","Ngày về","Số người/Dự kiến","Tiền chi","Thực chi","Giá vé"};
		DefaultTableModel tableModel=new DefaultTableModel() {
			 public boolean isCellEditable(int row,int col) {
	                return false;
	         }
		};
		table.setModel(tableModel);
		ArrayList<String> arrMatour=new ArrayList<String>();
		tableModel.setColumnIdentifiers(colname);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					HienThiKHT();
				}
			}
		});
		String danhgiaTongChi="";
		for(KHTourDTO kht:KHToursBUS.khtList) {
			if(kht.getTongchi()==0) {
				danhgiaTongChi="Chưa cập nhật";
			}
			else {
				danhgiaTongChi=kht.getTongchi()+"";
			}
			tableModel.addRow(new Object[] {
					kht.getMatour(),kht.getMakht(),kht.getNgaydi()+"",kht.getNgayve()+"",
					kht.getSonguoi()+"/"+kht.getSonguoidukien(),danhgiaTongChi,kht.getThucchi()+"",kht.getGiaVe()+""
			});
		}
		
		for(QlyToursDTO tour:QlyToursBUS.tourDTO) {
			arrMatour.add(tour.getMatour());
		}
		
		HashSet<String> set = new HashSet<>(arrMatour);
	    ArrayList<String> arrMaTour2 = new ArrayList<>(set);
	    Collections.reverse(arrMaTour2);
		
		cbMatour = new JComboBox(arrMaTour2.toArray());
		cbMatour.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                   tfMaKHT.requestFocusInWindow();
                    // Perform actions based on the selected item
                }
            }
        });
		cbMatour.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbMatour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cbMatour.setBounds(10, 39, 190, 35);
		cbMatour.setEnabled(false);
		cbMatour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfSongay.setText(getTour((String) cbMatour.getSelectedItem()).getSongay()+"");
                Calendar calendar = Calendar.getInstance();
                ngaydi_date.setDate(calendar.getTime());
                calendar.add(Calendar.DAY_OF_MONTH, getTour((String) cbMatour.getSelectedItem()).getSongay()-1);
                ngayve_date.setDate(calendar.getTime());
			}
		});
		panel_2.add(cbMatour);
		
	}
	
	public void initData2(ArrayList<KHTourDTO> khtour) {
		String [] colname= {"Mã Tour","Mã kế hoạch Tour","Ngày đi","Ngày về","Số người/Dự kiến","Tiền chi","Thực chi","Giá vé"};
		DefaultTableModel tableModel=new DefaultTableModel() {
			 public boolean isCellEditable(int row,int col) {
	                return false;
	         }
		};
		table.setModel(tableModel);
		ArrayList<String> arrMatour=new ArrayList<String>();
		tableModel.setColumnIdentifiers(colname);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					HienThiKHT();
				}
			}
		});
		String danhgiaTongChi="";
		for(KHTourDTO kht:khtour) {
			if(kht.getTongchi()==0) {
				danhgiaTongChi="Chưa cập nhật";
			}
			else {
				danhgiaTongChi=kht.getTongchi()+"";
			}
			tableModel.addRow(new Object[] {
					kht.getMatour(),kht.getMakht(),kht.getNgaydi()+"",kht.getNgayve()+"",
					kht.getSonguoi()+"/"+kht.getSonguoidukien(),danhgiaTongChi,kht.getThucchi()+"",kht.getGiaVe()+""
			});
		}
		
		for(QlyToursDTO tour:QlyToursBUS.tourDTO) {
			arrMatour.add(tour.getMatour());
		}
		
		HashSet<String> set = new HashSet<>(arrMatour);
	    ArrayList<String> arrMaTour2 = new ArrayList<>(set);
	    Collections.reverse(arrMaTour2);
		
		cbMatour = new JComboBox(arrMaTour2.toArray());
		cbMatour.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                   tfMaKHT.requestFocusInWindow();
                    // Perform actions based on the selected item
                }
            }
        });
		cbMatour.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbMatour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cbMatour.setBounds(10, 39, 190, 35);
		cbMatour.setEnabled(false);
		cbMatour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfSongay.setText(getTour((String) cbMatour.getSelectedItem()).getSongay()+"");
                Calendar calendar = Calendar.getInstance();
                ngaydi_date.setDate(calendar.getTime());
                calendar.add(Calendar.DAY_OF_MONTH, getTour((String) cbMatour.getSelectedItem()).getSongay()-1);
                ngayve_date.setDate(calendar.getTime());
			}
		});
		panel_2.add(cbMatour);
	}
	
	public void HienThiKHT() {
		KHTourDTO kht=GetKHTDaChon();
		QlyToursDTO tour=getTour(kht.getMatour());
		cbMatour.setSelectedItem(kht.getMatour());
		tfMaKHT.setText(kht.getMakht());
		textAreaMoTa.setText(kht.getMota());
		cbSoCho.setSelectedItem(kht.getSonguoi()+"");
		ngaydi_date.setDate(kht.getNgaydi());
		ngayve_date.setDate(kht.getNgayve());
		tfSongay.setText(tour.getSongay()+"");
		tfHuongDanVien.setText(kht.getHuongdanvien());
		DecimalFormat decimalFormat = new DecimalFormat("#,##0");
		String formattedNumber;
		tfGiaVe.setText(kht.getGiaVe()+"");
		if(kht.getTongchi()==0) {
			tfTongChi.setText("Chưa cập nhật");
		}
		else {
			formattedNumber = decimalFormat.format(kht.getTongchi()) + " VNĐ";
			tfTongChi.setText(formattedNumber);
		}
		cbMatour.setSelectedItem(kht.getMatour());
		lbTenTour.setText(tour.getTentour());
		formattedNumber = decimalFormat.format(kht.getGiaVe()) +  " VNĐ";
		lbGiaTour.setText(formattedNumber);
		
		//Hiển thị Chi tiết kế hoạch Tour
		String chitiet="";
		for(CTKHT_DTO ctkht:ChiTietKHT_BUS.ctkhtList) {
			if(ctkht.getMakht().equals(kht.getMakht())) {
				String ngay="Ngày :"+ctkht.getNgay().toString()+"\n";
				String khachsan="Khách sạn :"+GetTenKS(ctkht.getMaks())+"\n";
				String nhahang="Nhà hàng :"+GetTenNH(ctkht.getManh())+"\n";
				String phuongtien="Phương tiện :"+GetTenPT(ctkht.getMapt())+"\n";
				chitiet=chitiet+ngay+khachsan+nhahang+phuongtien;
			}
			
		}
		
		textArea_mota.setText(chitiet);
		
		ImageIcon img1=new ImageIcon(kht.getAnh1().replace('#', '\\'));
		Image image1 = img1.getImage().getScaledInstance(388, 187, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon1 = new ImageIcon(image1);
		hinh1_lb.setIcon(scaledIcon1);
		
		ImageIcon img2=new ImageIcon(kht.getAnh2().replace('#', '\\'));
		Image image2 = img2.getImage().getScaledInstance(250, 90, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon2 = new ImageIcon(image2);
		hinh2_lb.setIcon(scaledIcon2);
		
		ImageIcon img3=new ImageIcon(kht.getAnh3().replace('#', '\\'));
		Image image3 = img3.getImage().getScaledInstance(250, 90, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon3 = new ImageIcon(image3);
		hinh3_lb.setIcon(scaledIcon3);
		
		lbThoigian.setText(tour.getSongay()+"");
		lbNoikhoihanh.setText(tour.getNoikhoihanh());
		lbSoChoConNhan.setText(kht.getSonguoi()+"");
		
	}
	
	public void HienThiKHT2() {
		if(!ChiTietKeHoachTourGUI.makht_ctkht.equals("")) {
			KHTourDTO kht = null;
			for(KHTourDTO t:KHToursBUS.khtList) {
				if(t.getMakht().equals(ChiTietKeHoachTourGUI.makht_ctkht)) {
					kht=t;
				}
			}
			QlyToursDTO tour=getTour(kht.getMatour());
			cbMatour.setSelectedItem(kht.getMatour());
			tfMaKHT.setText(kht.getMakht());
			textAreaMoTa.setText(kht.getMota());
			cbSoCho.setSelectedItem(kht.getSonguoi()+"");
			ngaydi_date.setDate(kht.getNgaydi());
			ngayve_date.setDate(kht.getNgayve());
			tfSongay.setText(tour.getSongay()+"");
			tfHuongDanVien.setText(kht.getHuongdanvien());
			DecimalFormat decimalFormat = new DecimalFormat("#,##0");
			String formattedNumber;
			tfGiaVe.setText(kht.getGiaVe()+"");
			if(kht.getTongchi()==0) {
				tfTongChi.setText("Chưa cập nhật");
			}
			else {
				formattedNumber = decimalFormat.format(kht.getTongchi()) + " VNĐ";
				tfTongChi.setText(formattedNumber);
			}
			cbMatour.setSelectedItem(kht.getMatour());
			lbTenTour.setText(tour.getTentour());
			formattedNumber = decimalFormat.format(kht.getGiaVe()) +  " VNĐ";
			lbGiaTour.setText(formattedNumber);
			
			//Hiển thị kế hoạch Tour
			String chitiet="";
			for(CTKHT_DTO ctkht:ChiTietKHT_BUS.ctkhtList) {
				if(ctkht.getMakht().equals(kht.getMakht())) {
					String ngay="Ngày :"+ctkht.getNgay().toString()+"\n";
					String khachsan="Khách sạn :"+GetTenKS(ctkht.getMaks())+"\n";
					String nhahang="Nhà hàng :"+GetTenNH(ctkht.getManh())+"\n";
					String phuongtien="Phương tiện :"+GetTenPT(ctkht.getMapt())+"\n";
					chitiet=chitiet+ngay+khachsan+nhahang+phuongtien;
				}
				
			}
			
			textArea_mota.setText(chitiet);
			
			ImageIcon img1=new ImageIcon(kht.getAnh1().replace('#', '\\'));
			Image image1 = img1.getImage().getScaledInstance(388, 187, Image.SCALE_DEFAULT);
			ImageIcon scaledIcon1 = new ImageIcon(image1);
			hinh1_lb.setIcon(scaledIcon1);
			
			ImageIcon img2=new ImageIcon(kht.getAnh2().replace('#', '\\'));
			Image image2 = img2.getImage().getScaledInstance(250, 90, Image.SCALE_DEFAULT);
			ImageIcon scaledIcon2 = new ImageIcon(image2);
			hinh2_lb.setIcon(scaledIcon2);
			
			ImageIcon img3=new ImageIcon(kht.getAnh3().replace('#', '\\'));
			Image image3 = img3.getImage().getScaledInstance(250, 90, Image.SCALE_DEFAULT);
			ImageIcon scaledIcon3 = new ImageIcon(image3);
			hinh3_lb.setIcon(scaledIcon3);
			
			lbThoigian.setText(tour.getSongay()+"");
			lbNoikhoihanh.setText(tour.getNoikhoihanh());
			lbSoChoConNhan.setText(kht.getSonguoi()+"");
			
			btn_KHTour.setBackground(Color.ORANGE);
			btn_KHTour.setForeground(Color.BLACK);
			 for (int row = 0; row < table.getRowCount(); row++) {
	            String valueInRow = table.getValueAt(row, 1).toString();
	            if (valueInRow.equals(ChiTietKeHoachTourGUI.makht_ctkht)) {
	                table.setRowSelectionInterval(row, row);
	                break;
	            }
		      }
			
		}else {
			return;
		}
	}
	
	public QlyToursDTO getTour(String matour) {
		for(QlyToursDTO tour:QlyToursBUS.tourDTO) {
			if(tour.getMatour().equals(matour)) {
				return tour;
			}
		}
		return null;
	}
	public void init() {
//		if(!khtBUS.docKHT()) {
//			JOptionPane.showMessageDialog(this, "Lỗi không đọc được DataBase");
//		}
//		if (!ctkhtBUS.docCTKHT()) {
//			JOptionPane.showMessageDialog(this, "Lỗi không đọc được database!");
//		}
		tfMaKHT.setEditable(false);
		textAreaMoTa.setEditable(false);
		cbSoCho.setEnabled(false);
		tfHuongDanVien.setEditable(false);
		tfGiaVe.setEditable(false);
		textArea_mota.setEditable(false);
	}
	public void noneInit() {
		cbMatour.setEnabled(true);
//		tfMaKHT.setEditable(true);
		textAreaMoTa.setEditable(true);
		cbSoCho.setEnabled(true);
		ngaydi_date.setEnabled(true);
		ngayve_date.setEnabled(true);
		tfHuongDanVien.setEditable(true);
		tfGiaVe.setEditable(true);
	}
	public void Reset() {
		cbMatour.setSelectedIndex(0);
		tfMaKHT.setText("");
		textAreaMoTa.setText("");
		cbSoCho.setSelectedIndex(0);;
		tfHuongDanVien.setText("");
		tfGiaVe.setText("0");
		tfSongay.setText("");
		lbTenTour.setText("");
		lbGiaTour.setText("");
		textArea_mota.setText("");
		Calendar currentDate = Calendar.getInstance();
		ngaydi_date.setCalendar(currentDate);
		ngayve_date.setCalendar(currentDate);
		tfTongChi.setText("");
		lbTenTour.setText("");
		lbGiaTour.setText("");
		lbThoigian.setText("");
		lbSoChoConNhan.setText("");
		lbNoikhoihanh.setText("");
		hinh1_lb.setIcon(null);
		hinh2_lb.setIcon(null);
		hinh3_lb.setIcon(null);
	}
	public KHTourDTO GetKHTDaChon() {
		int row = table.getSelectedRow();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		String makht = model_table.getValueAt(row, 1) + "";
		for(KHTourDTO kht:KHToursBUS.khtList) {
			if(kht.getMakht().equals(makht)) {
				return kht;
			}
		}
		return null;
	}
	public void ThemKHT() {
		String matour=cbMatour.getSelectedItem().toString();
		String makht=khtBUS.TaoMaKHT();
		String mota=textAreaMoTa.getText();
	
        java.util.Date ngaydi_tmp=(java.util.Date) ngaydi_date.getDate();
        java.sql.Date ngaydi=new java.sql.Date(ngaydi_tmp.getTime());
        
        java.util.Date ngayve_tmp=(java.util.Date) ngayve_date.getDate();
        java.sql.Date ngayve=new java.sql.Date(ngayve_tmp.getTime());
				
		int songuoi=Integer.parseInt(cbSoCho.getSelectedItem().toString().trim());
//		long giave=Long.parseLong(tfGiaVe.getText());
		long giave=0;
		String huongdanvien=tfHuongDanVien.getText();
		//long tongchi=Long.parseLong(tfTongChi.getText());
		long tongchi=0;
		long thucchi=0;
		
//		String anh1_path_new="";
//		String anh2_path_new="";
//		String anh3_path_new="";
//		if(!anh1_path.isEmpty()) {			
//			anh1_path_new =anh1_path.replace('\\', '#');
//		}
//		else if(!anh2_path.isEmpty()) {			
//			anh2_path_new =anh2_path.replace('\\', '#');
//		}
//		else if(!anh3_path.isEmpty()) {			
//			anh3_path_new =anh3_path.replace('\\', '#');
//		}
		
		KHTourDTO kht=new KHTourDTO(makht, matour, mota, huongdanvien, anh1_path, anh2_path, 
				anh3_path, ngaydi, ngayve, songuoi, tongchi, giave,thucchi,songuoi);	
		if(khtBUS.themKHT(kht)!=-1) {
			JOptionPane.showMessageDialog(this, "Thêm thành công!");
		}
		else {
			JOptionPane.showMessageDialog(this, "Thêm thất bại!");
		}
		XoaDataTable();
		initData();
		Reset();
		
	}
	
	public void XoaDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.setRowCount(0);
	}
	
	public void SuaKHT() {
		KHTourDTO kht=GetKHTDaChon();
		String MaKHT_Bandau=kht.getMakht();
		kht.setMatour(cbMatour.getSelectedItem().toString());
		kht.setMakht(tfMaKHT.getText());
		kht.setMota(textAreaMoTa.getText());
		kht.setSonguoi(Integer.parseInt(cbSoCho.getSelectedItem().toString()));
		kht.setSonguoidukien(Integer.parseInt(cbSoCho.getSelectedItem().toString()));
		
		java.util.Date ngaydi_tmp=(java.util.Date) ngaydi_date.getDate();
        java.sql.Date ngaydi=new java.sql.Date(ngaydi_tmp.getTime());
        kht.setNgaydi(ngaydi);
        
        java.util.Date ngayve_tmp=(java.util.Date) ngayve_date.getDate();
        java.sql.Date ngayve=new java.sql.Date(ngayve_tmp.getTime());
        kht.setNgayve(ngayve);
        
        kht.setHuongdanvien(tfHuongDanVien.getText());
//        kht.setGiave(Long.parseLong(tfGiaVe.getText()));
        
//        String anh1_path_new="";
//		String anh2_path_new="";
//		String anh3_path_new="";
//		if(!anh1_path.isEmpty()) {			
//			anh1_path_new =anh1_path.replace('\\', '#');
//		}
//		if(!anh2_path.isEmpty()) {			
//			anh2_path_new =anh2_path.replace('\\', '#');
//		}
//		if(!anh3_path.isEmpty()) {			
//			anh3_path_new =anh3_path.replace('\\', '#');
//		}
        if(anh1_path.equals("")) {
        	kht.setAnh1(kht.getAnh1());
        }else {
        	kht.setAnh1(anh1_path);
        }
        if(anh2_path.equals("")) {
        	kht.setAnh2(kht.getAnh2());
        }else {
        	kht.setAnh2(anh2_path);
        }
        if(anh3_path.equals("")) {
        	kht.setAnh3(kht.getAnh3());
        }else {
        	kht.setAnh3(anh3_path);
        }	
//		System.out.println(kht.getMakht());
        
        if (khtBUS.sua(kht,MaKHT_Bandau) != -1) {
        	JOptionPane.showMessageDialog(this, "Sửa thành công!");
			
		} else {
			JOptionPane.showMessageDialog(this, "Lỗi!");
		}
        XoaDataTable();
		initData();
		Reset();
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
	
}
