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
import java.util.Calendar;

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
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

import BUS.HoaDonBUS;
import BUS.KHToursBUS;
import BUS.KhachHangBUS;
import BUS.KhuyenMaiBUS;
import BUS.NhanVienBUS;
import BUS.QlyToursBUS;
import BUS.taikhoanBUS;
import DTO.NhanVienDTO;
import DTO.taikhoanDTO;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;

public class TrangChuGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_NgayVL;
	private Label label;
	private JLabel Tour_lb;
	JButton btn_TrangChu,btn_DatTour,btn_HoaDon,btn_ThongKe;
	static taikhoanBUS tkBUS = new taikhoanBUS();
	public static taikhoanDTO tkDTO = new taikhoanDTO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChuGUI frame = new TrangChuGUI();
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
	public TrangChuGUI() {
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
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
		panel_1.setBounds(10, 10, 940, 42);
		KhachHang.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel trangchu_lb = new JLabel("Trang chủ");
		trangchu_lb.setBounds(415, 0, 110, 42);
		panel_1.add(trangchu_lb);
		trangchu_lb.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_Tour = new JPanel();
		panel_Tour.setBackground(new Color(102, 204, 204));
		panel_Tour.setBounds(96, 116, 200, 120);
		KhachHang.add(panel_Tour);
		panel_Tour.setLayout(null);
		
		JLabel tour_lbl = new JLabel("Tour");
		tour_lbl.setFont(new Font("Tahoma", Font.BOLD, 24));
		tour_lbl.setBounds(71, 21, 63, 26);
		panel_Tour.add(tour_lbl);
		
		JLabel tour_num = new JLabel("");
		tour_num.setText("" + QlyToursBUS.tourDTO.size());
		tour_num.setFont(new Font("Tahoma", Font.BOLD, 26));
		tour_num.setBounds(91, 57, 53, 33);
		panel_Tour.add(tour_num);
		
		JPanel panel_NhanVien = new JPanel();
		panel_NhanVien.setBackground(new Color(255, 204, 153));
		panel_NhanVien.setLayout(null);
		panel_NhanVien.setBounds(96, 314, 200, 120);
		KhachHang.add(panel_NhanVien);
		
		JLabel NhanVien_lbl = new JLabel("Nhân Viên");
		NhanVien_lbl.setFont(new Font("Tahoma", Font.BOLD, 24));
		NhanVien_lbl.setBounds(42, 21, 131, 26);
		panel_NhanVien.add(NhanVien_lbl);
		
		JLabel NhanVien_num = new JLabel("0");
		NhanVien_num.setText("" + NhanVienBUS.nvDTO.size());
		NhanVien_num.setFont(new Font("Tahoma", Font.BOLD, 26));
		NhanVien_num.setBounds(91, 57, 48, 33);
		panel_NhanVien.add(NhanVien_num);
		
		JPanel panel_KhachHang = new JPanel();
		panel_KhachHang.setBackground(new Color(204, 204, 255));
		panel_KhachHang.setLayout(null);
		panel_KhachHang.setBounds(374, 314, 200, 120);
		KhachHang.add(panel_KhachHang);
		
		JLabel KhachHang_lbl = new JLabel("Khách Hàng");
		KhachHang_lbl.setFont(new Font("Tahoma", Font.BOLD, 24));
		KhachHang_lbl.setBounds(28, 18, 145, 30);
		panel_KhachHang.add(KhachHang_lbl);
		
		JLabel KhachHang_num = new JLabel("0");
		KhachHang_num.setText("" + KhachHangBUS.khDTO.size());
		KhachHang_num.setFont(new Font("Tahoma", Font.BOLD, 26));
		KhachHang_num.setBounds(91, 57, 65, 33);
		panel_KhachHang.add(KhachHang_num);
		
		JPanel KhuyenMai_panel = new JPanel();
		KhuyenMai_panel.setBackground(new Color(255, 204, 255));
		KhuyenMai_panel.setLayout(null);
		KhuyenMai_panel.setBounds(639, 314, 200, 120);
		KhachHang.add(KhuyenMai_panel);
		
		JLabel KhuyenMai_lbl = new JLabel("Khuyến mãi");
		KhuyenMai_lbl.setFont(new Font("Tahoma", Font.BOLD, 24));
		KhuyenMai_lbl.setBounds(28, 18, 145, 30);
		KhuyenMai_panel.add(KhuyenMai_lbl);
		
		JLabel KhuyenMai_num = new JLabel("0");
		KhuyenMai_num.setText("" + KhuyenMaiBUS.kmDTO.size());
		KhuyenMai_num.setFont(new Font("Tahoma", Font.BOLD, 26));
		KhuyenMai_num.setBounds(91, 57, 51, 33);
		KhuyenMai_panel.add(KhuyenMai_num);
		
		JPanel panel_KHT = new JPanel();
		panel_KHT.setBackground(new Color(153, 204, 255));
		panel_KHT.setLayout(null);
		panel_KHT.setBounds(374, 116, 200, 120);
		KhachHang.add(panel_KHT);
		
		JLabel KHT_lbl = new JLabel("Kế hoạch tour");
		KHT_lbl.setFont(new Font("Tahoma", Font.BOLD, 24));
		KHT_lbl.setBounds(18, 17, 169, 30);
		panel_KHT.add(KHT_lbl);
		
		JLabel KHT_num = new JLabel("0");
		KHT_num.setText("" + KHToursBUS.khtList.size());
		KHT_num.setFont(new Font("Tahoma", Font.BOLD, 26));
		KHT_num.setBounds(85, 57, 62, 33);
		panel_KHT.add(KHT_num);
		
		JPanel panel_HD = new JPanel();
		panel_HD.setBackground(new Color(255, 102, 102));
		panel_HD.setLayout(null);
		panel_HD.setBounds(639, 116, 200, 120);
		KhachHang.add(panel_HD);
		
		JLabel HoaDon_lbl = new JLabel("Hóa đơn");
		HoaDon_lbl.setFont(new Font("Tahoma", Font.BOLD, 24));
		HoaDon_lbl.setBounds(50, 17, 107, 30);
		panel_HD.add(HoaDon_lbl);
		
		JLabel hoaDon_num = new JLabel("0");
		hoaDon_num.setText("" + HoaDonBUS.listHD.size());
		hoaDon_num.setFont(new Font("Tahoma", Font.BOLD, 26));
		hoaDon_num.setBounds(91, 57, 66, 33);
		panel_HD.add(hoaDon_num);
		
		String []item_loai = {"Trong nước", "Ngoài nước"};
		
		btn_DatTour = new JButton("Đặt Tour");
		btn_DatTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DatTourGUI dt = new DatTourGUI();
				dt.btn_DatTour.setBackground(Color.ORANGE);
				dt.btn_DatTour.setForeground(Color.BLACK);
			}
		});
		btn_DatTour.setForeground(Color.WHITE);
		btn_DatTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_DatTour.setFocusable(false);
		btn_DatTour.setBorderPainted(false);
		btn_DatTour.setBorder(null);
		btn_DatTour.setBackground(new Color(24, 171, 138));
		btn_DatTour.setBounds(317, 65, 120, 40);
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
}
