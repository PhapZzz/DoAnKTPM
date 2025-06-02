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
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

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

import BUS.DatTourBUS;
import BUS.KHToursBUS;
import BUS.KhachHangBUS;
import BUS.KiemTra;
import BUS.QlyToursBUS;
import BUS.taikhoanBUS;
import DTO.DatTourDTO;
import DTO.KHTourDTO;
import DTO.QlyToursDTO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class QuanLyTour extends JFrame {
	/**
		 * 
		 */
	// private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_MaTour;
	private JTextField songay_tf;
	private JTable table_Tours;
	private JTextField textField_TimKiem;
	private JTextField textField_NgayVL;
	private JTextField tentour_tf;
	private JButton luu_btn;
	private JComboBox comboBox_LoaiTour;
	private JComboBox khoihanh_cb;
	private JComboBox noiden_cb;
	private JButton sua_btn;
	private JButton them_btn;
	private JButton xoa_btn;
	private JButton thoat_btn;
	private JComboBox timkiem_cb;
	JButton btn_QLTour,btn_KHTour,btn_QLDV,btn_KhuyenMai,btn_NhanVien,btn_KhachHang;
	// QlyToursDTO tourDTO=new QlyToursDTO();
	QlyToursBUS tourBUS = new QlyToursBUS();
	KhachHangBUS khBUS=new KhachHangBUS();
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyTour frame = new QuanLyTour();
					// frame.setSize(1000, 650);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLyTour() {
		this.setSize(1000, 650);
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
		btn_QLTour.setBounds(113, 65, 120, 40);
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

		taikhoanBUS tkBUS = new taikhoanBUS();

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

		Panel QLTour = new Panel();
		QLTour.setBounds(13, 127, 960, 495);
		panel.add(QLTour);
		QLTour.setLayout(null);
		QLTour.setBackground(new Color(255, 255, 255));

		JLabel lb_TTKH = new JLabel("Thông tin Tour");
		lb_TTKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_TTKH.setBounds(19, 10, 218, 30);
		QLTour.add(lb_TTKH);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 50, 227, 435);
		QLTour.add(scrollPane);

		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Mã Tour");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 32, 61, 13);
		panel_2.add(lblNewLabel_2);

		textField_MaTour = new JTextField();
		textField_MaTour.setEnabled(false);
		textField_MaTour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MaTour.setBounds(90, 26, 125, 26);
		textField_MaTour.addKeyListener(new KeyListener() {
			
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
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					comboBox_LoaiTour.showPopup();
		        }
				
			}
		});
		panel_2.add(textField_MaTour);
		textField_MaTour.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Loại Tour");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 70, 73, 20);
		panel_2.add(lblNewLabel_2_1);

		songay_tf = new JTextField();
		songay_tf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		songay_tf.setColumns(10);
		songay_tf.setBounds(90, 211, 125, 26);
		songay_tf.addKeyListener(new KeyListener() {
			
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
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					khoihanh_cb.showPopup();
				}
		}});
		panel_2.add(songay_tf);

		JLabel songay_lb = new JLabel("Số Ngày");
		songay_lb.setFont(new Font("Tahoma", Font.BOLD, 14));
		songay_lb.setBounds(10, 213, 61, 20);
		panel_2.add(songay_lb);

		JLabel khoihanh_lb = new JLabel("Khởi hành");
		khoihanh_lb.setFont(new Font("Tahoma", Font.BOLD, 14));
		khoihanh_lb.setBounds(10, 259, 85, 13);
		panel_2.add(khoihanh_lb);

		JLabel noiden_lb = new JLabel("Nơi đến");
		noiden_lb.setFont(new Font("Tahoma", Font.BOLD, 14));
		noiden_lb.setBounds(10, 301, 61, 20);
		panel_2.add(noiden_lb);

		String[] arr_tinh = { "An Giang", "Bà Rịa – Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh",
				"Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ",
				"Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam",
				"Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "TP Hồ Chí Minh", "Hưng Yên",
				"Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lạng Sơn", "Lào Cai", "Lâm Đồng", "Long An",
				"Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam",
				"Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên",
				"Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc",
				"Yên Bái" };
		khoihanh_cb = new JComboBox(arr_tinh);
		khoihanh_cb.setBackground(new Color(255, 255, 255));
		khoihanh_cb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		khoihanh_cb.setBounds(91, 254, 124, 26);
//		khoihanh_cb.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                	noiden_cb.showPopup();
//                }
//            }
//        });
		panel_2.add(khoihanh_cb);

		String[] item_loai = { "Trong nước", "Ngoài nước" };
		comboBox_LoaiTour = new JComboBox(item_loai);
		comboBox_LoaiTour.setBackground(new Color(255, 255, 255));
		comboBox_LoaiTour.setBounds(91, 69, 123, 26);
		comboBox_LoaiTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_LoaiTour.getSelectedItem().equals("Trong nước")) {
					noiden_cb.setModel(new DefaultComboBoxModel(arr_tinh));
				} else if (comboBox_LoaiTour.getSelectedItem().equals("Ngoài nước")) {
					String[] arr_nuocngoai = { "Trung Quốc", "Hàn Quốc", "Nhật Bản", "Đài Loan", "Hồng Kông", "Macau",
							"Triều Tiên", "Hàn Quốc", "Mông Cổ", "Brunei", "Campuchia", "Đông Timor", "Indonesia",
							"Lào", "Malaysia", "Myanma", "Philippines", "Singapore", "Thái Lan" };
					noiden_cb.setModel(new DefaultComboBoxModel(arr_nuocngoai));
				}
			}
		});
		comboBox_LoaiTour.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	tentour_tf.requestFocusInWindow();
                }
            }
        });
		panel_2.add(comboBox_LoaiTour);
		

		noiden_cb = new JComboBox(arr_tinh);
		noiden_cb.setBackground(new Color(255, 255, 255));
		noiden_cb.setBounds(91, 300, 124, 26);
		panel_2.add(noiden_cb);

		JLabel tentour_lb = new JLabel("Tên Tour");
		tentour_lb.setFont(new Font("Tahoma", Font.BOLD, 14));
		tentour_lb.setBounds(10, 110, 73, 20);
		panel_2.add(tentour_lb);

		tentour_tf = new JTextField();
		tentour_tf.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            songay_tf.requestFocusInWindow();
		        }
		    }
		});
		tentour_tf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tentour_tf.setBounds(10, 140, 205, 61);
		tentour_tf.addKeyListener(new KeyListener() {
			
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
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					songay_tf.requestFocusInWindow();
		        }
				
			}
		});
		panel_2.add(tentour_tf);
		tentour_tf.setColumns(10);

		thoat_btn = new JButton("Thoát");
		thoat_btn.setForeground(new Color(255, 255, 255));
		thoat_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		thoat_btn.setFocusable(false);
		thoat_btn.setEnabled(false);
		thoat_btn.setBackground(new Color(255, 128, 64));
		thoat_btn.setBounds(117, 348, 85, 26);
		thoat_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResetData();
				init();
				them_btn.setEnabled(true);
				them_btn.setBackground(new Color(65, 105, 225));
				xoa_btn.setEnabled(true);
				xoa_btn.setBackground(new Color(255, 0, 0));
				sua_btn.setEnabled(true);
				sua_btn.setBackground(new Color(50, 205, 50));
			}
		});
		panel_2.add(thoat_btn);

//		textField_NgayVL = new JTextField();
//		textField_NgayVL.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		textField_NgayVL.setColumns(10);
//		textField_NgayVL.setBounds(81, 315, 134, 26);
//		panel_2.add(textField_NgayVL);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(269, 50, 681, 435);

		QLTour.add(scrollPane_2);

		table_Tours = new JTable();
		scrollPane_2.setViewportView(table_Tours);

//		table_Tours.getColumnModel().getColumn(1).setPreferredWidth(80);
//		table_Tours.getColumnModel().getColumn(2).setPreferredWidth(139);
//		table_Tours.getColumnModel().getColumn(3).setPreferredWidth(52);
//		table_Tours.getColumnModel().getColumn(5).setPreferredWidth(88);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(269, 10, 681, 30);
		QLTour.add(panel_3);
		panel_3.setLayout(null);

		xoa_btn = new JButton("Xóa");
		xoa_btn.setFocusable(false);
		xoa_btn.setBackground(new Color(255, 0, 0));
		xoa_btn.setForeground(new Color(255, 255, 255));
		xoa_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoa_btn.setBounds(596, 3, 75, 25);
		xoa_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				QlyToursDTO t = getTourDaChon();
				if (tourBUS.xoa(t) == -1) {
					JOptionPane.showMessageDialog(panel, "Lỗi!");
				} else {
					XoaDataTable();
					initData();
					JOptionPane.showMessageDialog(panel, "Xóa thành công!");
				}
			}
		});
		panel_3.add(xoa_btn);

		sua_btn = new JButton("Sửa");
		sua_btn.setFocusable(false);
		sua_btn.setBackground(new Color(50, 205, 50));
		sua_btn.setForeground(new Color(255, 255, 255));
		sua_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them_btn.setEnabled(false);
				them_btn.setBackground(Color.gray);
				xoa_btn.setEnabled(false);
				xoa_btn.setBackground(Color.gray);
				luu_btn.setEnabled(true);
				luu_btn.setBackground(Color.orange);
				thoat_btn.setEnabled(true);
				thoat_btn.setBackground(Color.red);
				noneInit();
				textField_MaTour.setEnabled(false);
			}
		});
		sua_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		sua_btn.setBounds(511, 3, 75, 25);
		panel_3.add(sua_btn);

		them_btn = new JButton("Thêm");
		them_btn.setFocusable(false);
		them_btn.setForeground(new Color(255, 255, 255));
		them_btn.setBackground(new Color(65, 105, 225));
		them_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		them_btn.setBounds(427, 3, 75, 25);
		them_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_MaTour.requestFocusInWindow();
				sua_btn.setEnabled(false);
				sua_btn.setBackground(Color.gray);
				xoa_btn.setEnabled(false);
				xoa_btn.setBackground(Color.gray);
				luu_btn.setEnabled(true);
				luu_btn.setBackground(Color.orange);
				thoat_btn.setEnabled(true);
				thoat_btn.setBackground(Color.red);
				noneInit();
				ResetData();
			}
		});
		panel_3.add(them_btn);

		luu_btn = new JButton("Lưu");
		luu_btn.setFocusable(false);
		luu_btn.setForeground(new Color(255, 255, 255));
		luu_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		luu_btn.setBackground(new Color(255, 128, 64));
		luu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sua_btn.isEnabled() == false && xoa_btn.isEnabled() == false) {
					if(!checkValidate()) return;
					ThemTour();
					ResetData();
					XoaDataTable();
					initData();
				} else if (them_btn.isEnabled() == false && xoa_btn.isEnabled() == false) {
					if(!checkValidate()) return;
					SuaTour();
					ResetData();
					XoaDataTable();
					initData();
				}
			}
		});
		luu_btn.setBounds(22, 348, 85, 26);
		panel_2.add(luu_btn);

		JLabel timkiem_lb = new JLabel("Tìm kiếm");
		timkiem_lb.setFont(new Font("Tahoma", Font.BOLD, 14));
		timkiem_lb.setBounds(10, 9, 70, 13);
		panel_3.add(timkiem_lb);

		textField_TimKiem = new JTextField();
		textField_TimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_TimKiem.setBounds(81, 3, 130, 25);
		textField_TimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String condition = textField_TimKiem.getText();
				if(condition.isEmpty()) return;
				String condType = (String) timkiem_cb.getSelectedItem();
				ArrayList<QlyToursDTO> t = tourBUS.timkiem(condition, condType);
				if (t == null) {
					JOptionPane.showMessageDialog(panel, "Lỗi!");
				} else {
					XoaDataTable();
					initData2(t);
				}

			}
		});
		panel_3.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);

		String[] arr_timkiem = { "Mã Tour", "Số ngày", "Nơi đến" };
		timkiem_cb = new JComboBox(arr_timkiem);
		timkiem_cb.setBounds(221, 3, 84, 25);
		panel_3.add(timkiem_cb);

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

		init();
		initData();

		btn_KHTour = new JButton("Kế hoạch Tours");
		btn_KHTour.setForeground(Color.WHITE);
		btn_KHTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_KHTour.setFocusable(false);
		btn_KHTour.setBorderPainted(false);
		btn_KHTour.setBorder(null);
		btn_KHTour.setBackground(new Color(24, 171, 138));
		btn_KHTour.setBounds(273, 65, 120, 40);
		panel.add(btn_KHTour);
		
		lblNewLabel = new JLabel("Xin chào " + TrangChuGUI.tkBUS.getName(TrangChuGUI.tkDTO.getUser()));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(609, 24, 230, 30);
		panel.add(lblNewLabel);
		
		btnNewButton = new JButton("Đổi mật khẩu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatKhauGUI mk = new MatKhauGUI();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(849, 25, 124, 30);
		panel.add(btnNewButton);
		this.setVisible(true);
	}

	public void initData() {
		String[] colNames = { "Mã Tour", "Tên Tour", "Số ngày", "Nơi đến", "Mã loại", "Nơi khởi hành" };
		DefaultTableModel tableModel = new DefaultTableModel();
		table_Tours.setModel(tableModel);
		tableModel.setColumnIdentifiers(colNames);
		table_Tours.getColumnModel().getColumn(1).setPreferredWidth(200);
		table_Tours.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					HienThiTour();
				}
			}
		});
		for (QlyToursDTO tour : QlyToursBUS.tourDTO) {
			tableModel.addRow(new Object[] { tour.getMatour(), tour.getTentour(), tour.getSongay() + "",
					tour.getNoiden(), tour.getMaloai(), tour.getNoikhoihanh() });
		}
	}

	public void initData2(ArrayList<QlyToursDTO> list) {
		String[] colNames = { "Mã Tour", "Tên Tour", "Số ngày", "Nơi đến", "Mã loại", "Nơi khởi hành" };
		DefaultTableModel tableModel = new DefaultTableModel();
		table_Tours.setModel(tableModel);
		tableModel.setColumnIdentifiers(colNames);
		table_Tours.getColumnModel().getColumn(1).setPreferredWidth(200);
		table_Tours.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					HienThiTour();
				}
			}
		});
		for (QlyToursDTO tour : list) {
			tableModel.addRow(new Object[] { tour.getMatour(), tour.getTentour(), tour.getSongay() + "",
					tour.getNoiden(), tour.getMaloai(), tour.getNoikhoihanh() });
		}
	}

	public void init() {
		luu_btn.setEnabled(false);
		luu_btn.setBackground(Color.gray);
		thoat_btn.setEnabled(false);
		thoat_btn.setBackground(Color.gray);
		textField_MaTour.setEditable(false);
		tentour_tf.setEditable(false);
		songay_tf.setEditable(false);
		khoihanh_cb.setEditable(false);
		noiden_cb.setEditable(false);
//		if (!tourBUS.docTour()) {
//			JOptionPane.showMessageDialog(this, "Lỗi không đọc được database!");
//		}
//		khBUS.docKH();
		
	}

	public void noneInit() {
		luu_btn.setEnabled(true);
		luu_btn.setBackground(Color.ORANGE);
		textField_MaTour.setEditable(true);
		tentour_tf.setEditable(true);
		songay_tf.setEditable(true);
		comboBox_LoaiTour.setEnabled(true);
		khoihanh_cb.setEnabled(true);
		noiden_cb.setEnabled(true);
	}

	public QlyToursDTO GetTourDaChon() {
		int row = table_Tours.getSelectedRow();
		DefaultTableModel model_table = (DefaultTableModel) table_Tours.getModel();

		String matour = model_table.getValueAt(row, 0) + "";
		String tentour = model_table.getValueAt(row, 1) + "";
		int songay = Integer.valueOf(model_table.getValueAt(row, 2) + "");

		String noiden = model_table.getValueAt(row, 3).toString();
		String maloai = model_table.getValueAt(row, 4).toString();
		String noikhoihanh = model_table.getValueAt(row, 5).toString();
		QlyToursDTO tour = new QlyToursDTO(matour, tentour, noiden, noikhoihanh, maloai, songay);
		return tour;
	}

	public void HienThiTour() {
		QlyToursDTO tour = GetTourDaChon();
		this.textField_MaTour.setText(tour.getMatour());
		if (tour.getMaloai().equals("loai1")) {
			this.comboBox_LoaiTour.setSelectedItem("Trong nước");
		} else if (tour.getMaloai().equals("loai2")) {
			this.comboBox_LoaiTour.setSelectedItem("Ngoài nước");
		}
		this.tentour_tf.setText(tour.getTentour());
		this.songay_tf.setText(tour.getSongay() + "");
		this.khoihanh_cb.setSelectedItem(tour.getNoikhoihanh());
		this.noiden_cb.setSelectedItem(tour.getNoiden());
		comboBox_LoaiTour.setEnabled(false);
		khoihanh_cb.setEnabled(false);
		noiden_cb.setEnabled(false);
	}


	
	public void ThemTour() {
//		sua_btn.setEnabled(false);
//		sua_btn.setBackground(Color.gray);
//		xoa_btn.setEnabled(false);
//		xoa_btn.setBackground(Color.gray);
//		luu_btn.setEnabled(true);
//		luu_btn.setBackground(Color.orange);
		if (tentour_tf.getText().isEmpty() || songay_tf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Chưa điền đầy đủ thông tin, mời bổ sung.");
		} else {
			String matour = tourBUS.TaoMaTour();
			String tentour = tentour_tf.getText();
			int songay = Integer.parseInt(songay_tf.getText());
			System.out.println(songay);
			String noiden = (String) noiden_cb.getSelectedItem();
			String maloai = "";
			if (comboBox_LoaiTour.getSelectedItem().equals("Trong nước")) {
				maloai = "loai1";
			} else if (comboBox_LoaiTour.getSelectedItem().equals("Ngoài nước")) {
				maloai = "loai2";
			}
			String noikhoihanh = (String) khoihanh_cb.getSelectedItem();
			QlyToursDTO tour = new QlyToursDTO(matour, tentour, noiden, noikhoihanh, maloai, songay);
			if (tourBUS.them(tour) == -1) {
				JOptionPane.showMessageDialog(this, "Lỗi!");
			} else {
				JOptionPane.showMessageDialog(this, "Thêm thành công!");
			}
		}
	}

	public void ResetData() {
		textField_MaTour.setText("");
		tentour_tf.setText("");
		songay_tf.setText("");
		comboBox_LoaiTour.setSelectedIndex(0);
		khoihanh_cb.setSelectedIndex(0);
		noiden_cb.setSelectedIndex(0);
	}

	public void XoaDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table_Tours.getModel();
		model_table.setRowCount(0);
	}

	public QlyToursDTO getTourDaChon() {
		int row = table_Tours.getSelectedRow();
		if(row == -1) return null;
		DefaultTableModel model_table = (DefaultTableModel) table_Tours.getModel();
		String matour = model_table.getValueAt(row, 0) + "";
		String tentour = model_table.getValueAt(row, 1) + "";
		int songay = Integer.valueOf(model_table.getValueAt(row, 2) + "");
		String noiden = model_table.getValueAt(row, 3) + "";
		String maloai = model_table.getValueAt(row, 4) + "";
		String noikhoihanh = model_table.getValueAt(row, 5) + "";
		QlyToursDTO tour = new QlyToursDTO(matour, tentour, noiden, noikhoihanh, maloai, songay);
		return tour;
	}

	public void SuaTour() {
		QlyToursDTO tour = getTourDaChon();
		String maTourBanDau=tour.getMatour();
		tour.setMatour(textField_MaTour.getText());
		tour.setTentour(tentour_tf.getText());
		tour.setNoiden((String) noiden_cb.getSelectedItem());
		if (comboBox_LoaiTour.getSelectedItem().equals("Trong nước")) {
			tour.setMaloai("loai1");
		} else if (comboBox_LoaiTour.getSelectedItem().equals("Ngoài nước")) {
			tour.setMaloai("loai2");
		}
		tour.setNoikhoihanh((String) khoihanh_cb.getSelectedItem());
		tour.setSongay(Integer.parseInt(songay_tf.getText()));

		if (tourBUS.sua(tour,maTourBanDau) == -1) {
			JOptionPane.showMessageDialog(this, "Lỗi!");
		} else {
			JOptionPane.showMessageDialog(this, "Sửa thành công!");
		}
	}
	
	public boolean checkValidate() {
		String songay = this.songay_tf.getText();
		if(KiemTra.getInstance().validate_OnlyNumber(songay) == false) {
			JOptionPane.showMessageDialog(null, "số ngày phải là kí tự số và lớn hơn 0");
			return false;
		}
		return true;
	}
	
}
