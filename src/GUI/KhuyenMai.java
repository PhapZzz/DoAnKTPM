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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

import BUS.KhuyenMaiBUS;
import BUS.KiemTra;
import BUS.NhanVienBUS;
import BUS.taikhoanBUS;
import DTO.KhuyenMaiDTO;
import DTO.NhanVienDTO;

public class KhuyenMai extends JFrame {

//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_MSKM;
	private JTextField textField_GiamGia;
	private JTable table_KhuyenMai;
	private JTextField textField_TimKiem;
//	private JTextField textField_DieuKien;
	JComboBox timkiem_cb;
	JButton luu_btn,thoat_btn,sua_btn,xoa_btn,them_btn;
	JTextArea textArea_tenCT;
	JDateChooser dateChooser_NgayBD, dateChooser_NgayKT;
	DefaultTableModel tableModel;
	JButton btn_QLTour,btn_KHTour,btn_QLDV,btn_KhuyenMai,btn_NhanVien,btn_KhachHang;
	Calendar calendar;
	
	KhuyenMaiBUS kmBUS  = new KhuyenMaiBUS();
	JTextField textField_tinhtrang;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhuyenMai frame = new KhuyenMai();
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
	public KhuyenMai() {
		setBackground(SystemColor.windowText);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		setContentPane(contentPane);
		
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
		
		Panel KhachHang = new Panel();
		KhachHang.setBounds(13, 127, 960, 495);
		panel.add(KhachHang);
		KhachHang.setLayout(null);
		KhachHang.setBackground(new Color(255, 255, 255));
		
		JLabel lb_TTKH = new JLabel("Thông tin Khuyến Mãi");
		lb_TTKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_TTKH.setBounds(19, 10, 218, 30);
		KhachHang.add(lb_TTKH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 50, 249, 435);
		KhachHang.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã khuyến mãi");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 27, 120, 20);
		panel_2.add(lblNewLabel_2);
		
		textField_MSKM = new JTextField();
		textField_MSKM.setEnabled(false);
		textField_MSKM.addKeyListener( new KeyListener() {
			
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
				textArea_tenCT.requestFocusInWindow();
			}
		});
		textField_MSKM.setBackground(new Color(255, 255, 255));
		textField_MSKM.setEditable(false);
		textField_MSKM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MSKM.setBounds(127, 25, 110, 26);
		panel_2.add(textField_MSKM);
		textField_MSKM.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên chương trình");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 74, 144, 20);
		panel_2.add(lblNewLabel_2_1);
		
		String [] item_gender = {"Nam","Nữ"};
		
		textField_GiamGia = new JTextField();
		textField_GiamGia.addKeyListener(new KeyListener() {
			
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
//				if (e.getKeyCode() == KeyEvent.VK_ENTER)
//				textField_DieuKien.requestFocusInWindow();
			}
		});
		textField_GiamGia.setBackground(new Color(255, 255, 255));
		textField_GiamGia.setEditable(false);
		textField_GiamGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_GiamGia.setColumns(10);
		textField_GiamGia.setBounds(127, 203, 110, 26);
		panel_2.add(textField_GiamGia);
		
		JLabel lblNewLabel_2_4 = new JLabel("Phần trăm (%)");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(10, 205, 120, 20);
		panel_2.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Ngày bắt đầu");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4_1.setBounds(10, 250, 106, 20);
		panel_2.add(lblNewLabel_2_4_1);
		
		luu_btn = new JButton("Lưu");
		luu_btn.setEnabled(false);
		luu_btn.setBackground(Color.GRAY);
		luu_btn.setFocusable(false);
		luu_btn.setForeground(new Color(255, 255, 255));
		luu_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		luu_btn.setBackground(Color.GRAY);
		luu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!sua_btn.isEnabled()) {
					if(checkNull()) {
						JOptionPane.showMessageDialog(null, "Vui long dien du thong tin","ERROR",JOptionPane.INFORMATION_MESSAGE);
						return;
					}else if(!checkValidate()) return;
					if(themKM()) {
						resetTable();
						initArrayList();
						reSetForm();
					}
				}else if(!them_btn.isEnabled()) {
					if(getSelectedKM() == null) {
						JOptionPane.showMessageDialog(null, "Chưa chọn khuyến mãi");
						return;
					}else if(!checkValidate()) return;
					if(suaKM()) {
						resetTable();
						initArrayList();
						reSetForm();
					}
				}
			}
		});
		luu_btn.setBounds(30, 397, 85, 26);
		panel_2.add(luu_btn);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setBounds(10, 110, 227, 83);
		panel_2.add(scrollPane_3);
		
		textArea_tenCT = new JTextArea();
		textArea_tenCT.addKeyListener(new KeyListener() {
			
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
						textField_GiamGia.requestFocusInWindow();
			}
		});
		textArea_tenCT.setEditable(false);
		textArea_tenCT.setLineWrap(true);
		textArea_tenCT.setWrapStyleWord(true);
		textArea_tenCT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_3.setViewportView(textArea_tenCT);
		
		dateChooser_NgayBD = new JDateChooser();
		dateChooser_NgayBD.addKeyListener(new KeyListener() {
			
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
					dateChooser_NgayKT.requestFocusInWindow();
			}
		});
		calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        dateChooser_NgayBD.setCalendar(calendar);
		dateChooser_NgayBD.getCalendarButton().setEnabled(false);
		dateChooser_NgayBD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateChooser_NgayBD.setBounds(127, 250, 110, 26);
		panel_2.add(dateChooser_NgayBD);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Ngày kết thúc");
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4_1_1.setBounds(10, 296, 106, 20);
		panel_2.add(lblNewLabel_2_4_1_1);
		
		dateChooser_NgayKT = new JDateChooser();
		dateChooser_NgayKT.addKeyListener(new KeyListener() {
			
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
					textField_tinhtrang.requestFocusInWindow();
			}
		});
		calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        dateChooser_NgayKT.setCalendar(calendar);
		dateChooser_NgayKT.getCalendarButton().setEnabled(false);
		dateChooser_NgayKT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateChooser_NgayKT.setBounds(127, 296, 110, 26);
		panel_2.add(dateChooser_NgayKT);
		
//		textField_DieuKien = new JTextField();
//		textField_DieuKien.addKeyListener(new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//				if (e.getKeyCode() == KeyEvent.VK_ENTER)
//				dateChooser_NgayBD.requestFocusInWindow();
//			}
//		});
//		textField_DieuKien.setBackground(new Color(255, 255, 255));
//		textField_DieuKien.setEditable(false);
//		textField_DieuKien.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		textField_DieuKien.setColumns(10);
//		textField_DieuKien.setBounds(127, 193, 110, 26);
//		panel_2.add(textField_DieuKien);
		String []item_dt = {"Tất cả","Người lớn","Trẻ em"};
		
		thoat_btn = new JButton("Thoát");
		thoat_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lockForm();
				them_btn.setEnabled(true);
				them_btn.setBackground(Color.blue);
				xoa_btn.setEnabled(true);
				xoa_btn.setBackground(Color.red);
				sua_btn.setEnabled(true);
				sua_btn.setBackground(new Color(50, 205, 50));
				sua_btn.setForeground(new Color(255, 255, 255));
				thoat_btn.setEnabled(false);
				thoat_btn.setBackground(Color.gray);
				luu_btn.setEnabled(false);
				luu_btn.setBackground(Color.GRAY);
				resetTable();
				reSetForm();
				initArrayList();
			}
		});
		thoat_btn.setForeground(Color.WHITE);
		thoat_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		thoat_btn.setFocusable(false);
		thoat_btn.setEnabled(false);
		thoat_btn.setBackground(Color.GRAY);
		thoat_btn.setBounds(138, 397, 85, 26);
		
		panel_2.add(thoat_btn);
		
		JLabel lblNewLabel_2_5 = new JLabel("Tình trạng");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_5.setBounds(10, 344, 120, 20);
		panel_2.add(lblNewLabel_2_5);
		
		textField_tinhtrang = new JTextField();
		textField_tinhtrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_tinhtrang.setEditable(false);
		textField_tinhtrang.setColumns(10);
		textField_tinhtrang.setBackground(Color.WHITE);
		textField_tinhtrang.setBounds(127, 342, 110, 26);
		panel_2.add(textField_tinhtrang);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(269, 83, 681, 402);
		KhachHang.add(scrollPane_2);
		
		table_KhuyenMai = new JTable();
		scrollPane_2.setViewportView(table_KhuyenMai);
		table_KhuyenMai.setDefaultEditor(Object.class,null);
		String[] colname =  {"Mã khuyến mãi","Tên chương trình","Phần trăm","Ngày bắt đầu","Ngày kết thúc","Tình trạng"};
		tableModel = new DefaultTableModel();
		table_KhuyenMai.setModel(tableModel);
		tableModel.setColumnIdentifiers(colname);
		table_KhuyenMai.getColumnModel().getColumn(0).setPreferredWidth(90);
		table_KhuyenMai.getColumnModel().getColumn(1).setPreferredWidth(210);
		table_KhuyenMai.getColumnModel().getColumn(2).setPreferredWidth(70);
//		table_KhuyenMai.getColumnModel().getColumn(3).setPreferredWidth(70);
		table_KhuyenMai.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_KhuyenMai.getColumnModel().getColumn(5).setPreferredWidth(100);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(269, 10, 681, 30);
		KhachHang.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 9, 70, 13);
		panel_3.add(lblNewLabel_3);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_TimKiem.setBounds(81, 3, 450, 25);
		panel_3.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);
		
		String []item_tk = {"Mã khuyến mãi","Tên chương trình"};
		timkiem_cb = new JComboBox(item_tk);
		timkiem_cb.setBounds(541, 3, 140, 25);
		textField_TimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String condition = textField_TimKiem.getText();
				if(condition.isEmpty()) {
					resetTable();
					initArrayList();
					return;
				}
				String type = (String) timkiem_cb.getSelectedItem();
				ArrayList<KhuyenMaiDTO> tmp = kmBUS.timKiem(condition.toLowerCase(), type);
				if(tmp != null) {
					resetTable();
					initArrayList(tmp);
				}
				
			}
		});
		panel_3.add(timkiem_cb);
		
		JButton ctkm_btn = new JButton("Xem chi tiết");
		ctkm_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CTKhuyenMaiGUI ctkm = new CTKhuyenMaiGUI();
			}
		});
		ctkm_btn.setForeground(new Color(255, 255, 255));
		ctkm_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		ctkm_btn.setFocusable(false);
		ctkm_btn.setBackground(new Color(255, 128, 64));
		ctkm_btn.setBounds(279, 48, 135, 25);
		KhachHang.add(ctkm_btn);
		
		them_btn = new JButton("Thêm");
		them_btn.setBounds(706, 48, 75, 25);
		KhachHang.add(them_btn);
		them_btn.setFocusable(false);
		them_btn.setForeground(new Color(255, 255, 255));
		them_btn.setBackground(new Color(65, 105, 225));
		them_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		sua_btn = new JButton("Sửa");
		sua_btn.setBounds(790, 48, 75, 25);
		KhachHang.add(sua_btn);
		sua_btn.setFocusable(false);
		sua_btn.setBackground(new Color(50, 205, 50));
		sua_btn.setForeground(new Color(255, 255, 255));
		sua_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initForm();
				textField_MSKM.setEditable(false);
				them_btn.setBackground(Color.gray);
				them_btn.setEnabled(false);
				xoa_btn.setBackground(Color.gray);
				xoa_btn.setEnabled(false);
				luu_btn.setBackground(Color.orange);
				luu_btn.setEnabled(true);
				thoat_btn.setBackground(Color.red);
				thoat_btn.setEnabled(true);
				textField_MSKM.setEnabled(false);
			}
		});
		sua_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		xoa_btn = new JButton("Xóa");
		xoa_btn.setBounds(875, 48, 75, 25);
		KhachHang.add(xoa_btn);
		xoa_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				luu_btn.setEnabled(false);
				luu_btn.setBackground(Color.gray);
				thoat_btn.setEnabled(false);
				thoat_btn.setBackground(Color.gray);
				lockForm();
				KhuyenMaiDTO km = getSelectedKM();
				if(km!= null) {
					int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khuyến mãi " + km.getMakm(),"Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) {
						xoaKM();
						resetTable();
						initArrayList();
						reSetForm();
					}
				}else JOptionPane.showMessageDialog(null,"Chưa chọn khuyến mãi");
			}
		});
		xoa_btn.setFocusable(false);
		xoa_btn.setBackground(new Color(255, 0, 0));
		xoa_btn.setForeground(new Color(255, 255, 255));
		xoa_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		them_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_tenCT.requestFocusInWindow();
				luu_btn.setEnabled(true);
				luu_btn.setBackground(Color.orange);
				thoat_btn.setEnabled(true);
				thoat_btn.setBackground(Color.RED);
				xoa_btn.setBackground(Color.gray);
				xoa_btn.setEnabled(false);
				sua_btn.setBackground(Color.gray);
				sua_btn.setEnabled(false);
				reSetForm();
				initForm();
			}
		});
		
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
		
		JLabel lblNewLabel_4 = new JLabel("Xin chào " + TrangChuGUI.tkBUS.getName(TrangChuGUI.tkDTO.getUser()));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(609, 24, 230, 30);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Đổi mật khẩu");
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
		initData();
	}
	
	
	public void initData() {
//		if(kmBUS.docKM()) {
			
			for(KhuyenMaiDTO km: KhuyenMaiBUS.kmDTO) {
				boolean tinhtrang = KiemTra.getInstance().checkTinhTrang(KiemTra.getInstance().toDateUtil(km.getNgaykt()));
				if(!tinhtrang && km.getTinhtrang()){
					km.setTinhtrang(tinhtrang);
					JOptionPane.showMessageDialog(null, "Mã khuyến mãi " + km.getMakm() + " đã hết thời hạn");
					kmBUS.suaKM(km);
				};
				tableModel.addRow(new Object[]{
						km.getMakm(),km.getTectkm(),km.getPhantram(),
						km.getNgaybd()+"",km.getNgaykt(),
						KiemTra.getInstance().tinhTrang(tinhtrang)
				});
		}
			table_KhuyenMai.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 1) {
						hienThiThongTin();
					}
				}
			});
//		}
	}
	
	
	public void initArrayList(ArrayList<KhuyenMaiDTO> t) {
		for(KhuyenMaiDTO km: t) {
			tableModel.addRow(new Object[]{
					km.getMakm(),km.getTectkm(),km.getPhantram(),
					km.getNgaybd()+"",km.getNgaykt(),KiemTra.getInstance().tinhTrang(km.getTinhtrang())
			});
		}
		
		table_KhuyenMai.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					hienThiThongTin();
				}
			}
		});
	}
	public void initArrayList() {
		for(KhuyenMaiDTO km: KhuyenMaiBUS.kmDTO) {
			tableModel.addRow(new Object[]{
					km.getMakm(),km.getTectkm(),km.getPhantram(),
					km.getNgaybd()+"",km.getNgaykt(),KiemTra.getInstance().tinhTrang(km.getTinhtrang())
			});
		}
		
		table_KhuyenMai.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					hienThiThongTin();
				}
			}
		});
	}
	
	public void hienThiThongTin() {
		KhuyenMaiDTO km = getSelectedKM();
		this.textField_MSKM.setText(km.getMakm());
		this.textArea_tenCT.setText(km.getTectkm());
		this.textField_GiamGia.setText(km.getPhantram()+"");
		this.dateChooser_NgayBD.setDate(km.getNgaybd());
		this.dateChooser_NgayKT.setDate(km.getNgaykt());
		this.textField_tinhtrang.setText(KiemTra.getInstance().tinhTrang(km.getTinhtrang()));
//		this.textField_DieuKien.setText(km.getDieukien()+"");
//		this.textField.setText(km.getCmnd());
//		this.comboBox_GioiTinh.setSelectedItem(KiemTra.getInstance().GioiTinh(nv.getGioitinh()) );
	}
	
	public KhuyenMaiDTO getSelectedKM() {
		int row = table_KhuyenMai.getSelectedRow();
		if(row == -1) return null;
		DefaultTableModel model = (DefaultTableModel) table_KhuyenMai.getModel();
		String makm = model.getValueAt(row, 0) + "";
		String tenct = model.getValueAt(row, 1) + "";
		double phantram = (double)model.getValueAt(row, 2);
//		int dieukien = (int)model.getValueAt(row, 3);
		// Giả sử ngayvlString là một chuỗi chứa ngày tháng năm trong định dạng chuẩn
		String ngaybdString =  model.getValueAt(row, 3) + "";

		// Chuyển đổi chuỗi thành kiểu java.sql.Date
		java.sql.Date ngaybd = java.sql.Date.valueOf(ngaybdString);
		
		String ngayktString =  model.getValueAt(row, 4) + "";

		// Chuyển đổi chuỗi thành kiểu java.sql.Date
		java.sql.Date ngaykt = java.sql.Date.valueOf(ngayktString);
		Boolean tinhtrang = KiemTra.getInstance().tinhTrang(model.getValueAt(row, 5).toString());		
		KhuyenMaiDTO km = new KhuyenMaiDTO(makm, tenct,0,phantram, ngaybd, ngaykt,tinhtrang);
		return km;
	}
	public boolean checkNull() {
		if(this.textArea_tenCT.getText().isEmpty() || this.textField_GiamGia.getText().isEmpty() 
				|| this.dateChooser_NgayKT.getDate()==null) 
		{
			return true;
		}
		return false;
	}

	public Boolean themKM() {
		KhuyenMaiDTO km = new KhuyenMaiDTO();
		km.setMakm(kmBUS.TaoMaKM());
		km.setTectkm(this.textArea_tenCT.getText());
		km.setPhantram(Double.parseDouble(this.textField_GiamGia.getText()));
//		km.setDieukien(Integer.parseInt(this.textField_DieuKien.getText()));
		java.util.Date utilDate = this.dateChooser_NgayBD.getDate();
		java.sql.Date sqlDate_ngayBD = new java.sql.Date(utilDate.getTime());
		km.setNgaybd(sqlDate_ngayBD);
		
		java.util.Date utilDate1 = this.dateChooser_NgayKT.getDate();
		java.sql.Date sqlDate_ngayKT = new java.sql.Date(utilDate1.getTime());
		km.setNgaykt(sqlDate_ngayKT);
		if(!KiemTra.getInstance().checkTinhTrang(sqlDate_ngayBD,sqlDate_ngayKT)) {
			JOptionPane.showMessageDialog(null, "Ngày kết thúc phải lớn hơn ngày bắt đầu khuyến mãi");
			return false;
		}
		km.setTinhtrang(KiemTra.getInstance().checkTinhTrang(utilDate1));
		if(kmBUS.themKM(km)!=-1) {
			JOptionPane.showMessageDialog(null, "Thêm thành công khuyến mãi");
		}else JOptionPane.showMessageDialog(null, "Không thể thêm khuyến mãi");
		return true;
	}
	
	public void reSetForm() {
		this.textField_MSKM.setText("");
		this.textArea_tenCT.setText("");
		this.textField_GiamGia.setText("");
//		this.textField_DieuKien.setText("");
		calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
		this.dateChooser_NgayBD.setCalendar(calendar);
		this.dateChooser_NgayKT.setCalendar(calendar);
		this.textField_tinhtrang.setText("");
	}
	public void initForm() {
//		this.textField_MSKM.setEnabled(true);
		this.textField_MSKM.setEditable(true);
		this.textArea_tenCT.setEditable(true);
		this.textField_GiamGia.setEditable(true);
//		this.textField_DieuKien.setEditable(true);
		this.dateChooser_NgayBD.getCalendarButton().setEnabled(true);
		this.dateChooser_NgayKT.getCalendarButton().setEnabled(true);
	}
	public void resetTable() {
		DefaultTableModel tableModel =(DefaultTableModel) table_KhuyenMai.getModel();
		tableModel.setRowCount(0);
	}
	public void lockForm() {
//		this.textField_MSKM.setEditable(false);
		this.textArea_tenCT.setEditable(false);
		this.textField_GiamGia.setEditable(false);
//		this.textField_DieuKien.setEditable(false);
//		this.textField_SDT.setEditable(false);
		this.dateChooser_NgayBD.getCalendarButton().setEnabled(false);
		this.dateChooser_NgayKT.getCalendarButton().setEnabled(false);
	}
	
	public void xoaKM() {
		KhuyenMaiDTO km = getSelectedKM();
		if(kmBUS.xoaKM(km)!=-1) {
			JOptionPane.showMessageDialog(null,"Xoá thành công");
		}else JOptionPane.showMessageDialog(null,"Không thể xóa khuyến mãi " + km.getMakm());
	}
	
	public Boolean suaKM() {
		KhuyenMaiDTO km = getSelectedKM();
		if(km == null) return false;
		km.setMakm(this.textField_MSKM.getText());
		km.setTectkm(this.textArea_tenCT.getText());
//		km.setDieukien(Integer.parseInt(this.textField_DieuKien.getText()));
		km.setPhantram(Double.parseDouble(this.textField_GiamGia.getText()));
		java.util.Date utilDate = this.dateChooser_NgayBD.getDate();
		java.sql.Date sqlDate_ngayBD = new java.sql.Date(utilDate.getTime());
		km.setNgaybd(sqlDate_ngayBD);
		java.util.Date utilDate1 = this.dateChooser_NgayKT.getDate();
		java.sql.Date sqlDate_ngayKT = new java.sql.Date(utilDate1.getTime());
		km.setNgaykt(sqlDate_ngayKT);
		km.setTinhtrang(KiemTra.getInstance().checkTinhTrang(utilDate1));
		kmBUS.suaKM(km);
		if(kmBUS.suaKM(km)!=-1) {
			JOptionPane.showMessageDialog(null,"Sửa thông tin thành công khuyến mãi " + km.getMakm());
		}
		else if(kmBUS.suaKM(km)==-1)JOptionPane.showMessageDialog(null,"Không thể sửa thông tin khuyến mãi " + km.getMakm());
		return true;
	}
	
	public boolean checkValidate() {
		String phanTram = this.textField_GiamGia.getText();
		if(KiemTra.getInstance().validate_OnlyNumber(phanTram) == false) {
			JOptionPane.showMessageDialog(null, "phần trăm khuyến mãi chỉ chứa số");
			return false;
		}
		return true;
	}
}
