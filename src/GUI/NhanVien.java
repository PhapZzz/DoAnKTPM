package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.TextField;
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
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ScrollPaneConstants;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.JCalendar;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

import BUS.KiemTra;
import BUS.NhanVienBUS;
import BUS.taikhoanBUS;
import DTO.NhanVienDTO;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

public class NhanVien extends JFrame{
//	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField_MSNV;
	private JTextField textField_HoNV;
	private JTextField textField_TenNV;
	private JTextField textField_SDT;
	private JTable table_NhanVien;
	private JTextField textField_TimKiem;
	private JTextField textField_CMND;
	private JButton them_btn, xoa_btn , sua_btn, thoat_btn, luu_btn;
	private JDateChooser dateChooser_NgayVL, dateChooser_NgaySinh;
	JComboBox comboBox_GioiTinh , timkiem_cb;
	JButton btn_QLTour,btn_KHTour,btn_QLDV,btn_KhuyenMai,btn_NhanVien,btn_KhachHang;
	DefaultTableModel tableModel;
	NhanVienBUS nvBUS = new NhanVienBUS();
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btn_import;
	private JButton btn_export;
	private boolean isAdd = false;
	private boolean isEdit = false;
	private boolean isDelete = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien frame = new NhanVien();
					frame.setSize(1000, 650);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Event transfer
	

	/**
	 * Create the frame.
	 */
	public NhanVien() {
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
		
		// _____ Thanh Menu _____
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
		// _____ Thanh Menu _____
		
		this.getContentPane().add(panel);
		
		Panel NhanVien = new Panel();
		NhanVien.setBounds(13, 127, 960, 495);
		panel.add(NhanVien);
		NhanVien.setLayout(null);
		NhanVien.setBackground(new Color(255, 255, 255));
		
		JLabel lb_TTKH = new JLabel("Thông tin Nhân Viên");
		lb_TTKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_TTKH.setBounds(19, 10, 218, 30);
		NhanVien.add(lb_TTKH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 50, 227, 435);
		NhanVien.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã số");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 32, 45, 13);
		panel_2.add(lblNewLabel_2);
		
		textField_MSNV = new JTextField();
		textField_MSNV.setEnabled(false);
		textField_MSNV.addKeyListener(new KeyListener() {
			
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
					textField_HoNV.requestFocusInWindow();
					
			}
		});
		textField_MSNV.setEditable(false);
		textField_MSNV.setBackground(Color.WHITE);
		textField_MSNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MSNV.setBounds(81, 26, 134, 26);
		panel_2.add(textField_MSNV);
		textField_MSNV.setColumns(10);
		
		textField_HoNV = new JTextField();
		textField_HoNV.addKeyListener(new KeyListener() {
			
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
					textField_TenNV.requestFocusInWindow();
				
			}
		});
		textField_HoNV.setBackground(Color.WHITE);
		textField_HoNV.setEditable(false);
		textField_HoNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_HoNV.setColumns(10);
		textField_HoNV.setBounds(81, 68, 134, 26);
		panel_2.add(textField_HoNV);
		
		JLabel lblNewLabel_2_1 = new JLabel("Họ đệm");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 70, 61, 20);
		panel_2.add(lblNewLabel_2_1);
		
		textField_TenNV = new JTextField();
		textField_TenNV.addKeyListener(new KeyListener() {
			
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
					comboBox_GioiTinh.showPopup();
			}
		});
		textField_TenNV.setBackground(Color.WHITE);
		textField_TenNV.setEditable(false);
		textField_TenNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_TenNV.setColumns(10);
		textField_TenNV.setBounds(81, 110, 134, 26);
		panel_2.add(textField_TenNV);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tên");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 116, 45, 13);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Giới Tính");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(10, 157, 73, 13);
		panel_2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Ngày sinh");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(10, 284, 73, 20);
		panel_2.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("SĐT");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4_1.setBounds(10, 196, 61, 20);
		panel_2.add(lblNewLabel_2_4_1);
		
		textField_SDT = new JTextField();
		textField_SDT.addKeyListener(new KeyListener() {
			
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
					textField_CMND.requestFocusInWindow();
				}
			}
		});
		textField_SDT.setEditable(false);
		textField_SDT.setBackground(Color.WHITE);
		textField_SDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(81, 194, 134, 26);
		panel_2.add(textField_SDT);
		
		luu_btn = new JButton("Lưu");
		luu_btn.setFocusable(false);
		luu_btn.setForeground(new Color(255, 255, 255));
		luu_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		luu_btn.setBackground(Color.GRAY);
		luu_btn.setEnabled(false);
		luu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!sua_btn.isEnabled()) {
					if(checkNull()) {
						JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin","ERROR",JOptionPane.INFORMATION_MESSAGE);
						return;
					} else if(!checkValidate()) return;
					themNV();
					resetTable();
					initArrayList();
					reSetForm();
					isAdd = false;
					
				}else if(!them_btn.isEnabled()) {
					if(!checkValidate()) return;
					suaNV();
					resetTable();
					initArrayList();
					reSetForm();
					isEdit = false;
				}
				
			}
		});
		luu_btn.setBounds(20, 377, 85, 26);
		panel_2.add(luu_btn);
		String [] item_gender = {"Nam","Nữ"};
		comboBox_GioiTinh = new JComboBox<>(item_gender);
		comboBox_GioiTinh.setEnabled(false);
		comboBox_GioiTinh.setBackground(new Color(255, 255, 255));
		comboBox_GioiTinh.setSelectedItem("Nam");
		comboBox_GioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_GioiTinh.setBounds(81, 152, 134, 26);
		comboBox_GioiTinh.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	textField_SDT.requestFocusInWindow();
                }
            }
        });
		panel_2.add(comboBox_GioiTinh);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("CMND");
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4_1_1.setBounds(10, 238, 61, 20);
		panel_2.add(lblNewLabel_2_4_1_1);
		
		textField_CMND = new JTextField();
		textField_CMND.setEditable(false);
		textField_CMND.setBackground(Color.WHITE);
		textField_CMND.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_CMND.setColumns(10);
		textField_CMND.setBounds(81, 236, 134, 26);
		panel_2.add(textField_CMND);
		
		JLabel lblNewLabel_2_4_1_1_1 = new JLabel("Ngày vào làm");
		lblNewLabel_2_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4_1_1_1.setBounds(10, 317, 108, 20);
		panel_2.add(lblNewLabel_2_4_1_1_1);
		
		dateChooser_NgayVL = new JDateChooser();
		dateChooser_NgayVL.setBackground(Color.WHITE);
		dateChooser_NgayVL.getCalendarButton().setEnabled(false);
		dateChooser_NgayVL.setBounds(118, 317, 97, 26);
		dateChooser_NgayVL.setDate(Calendar.getInstance().getTime());
		panel_2.add(dateChooser_NgayVL);
		
		dateChooser_NgaySinh = new JDateChooser();
		dateChooser_NgaySinh.setBackground(Color.WHITE);
		dateChooser_NgaySinh.getCalendarButton().setEnabled(false);
		dateChooser_NgaySinh.setBounds(118, 278, 97, 26);
		panel_2.add(dateChooser_NgaySinh);
		
		thoat_btn = new JButton("Thoát");
		thoat_btn.setEnabled(false);
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
				isAdd = false;
				isEdit = false;
				resetTable();
				reSetForm();
				initArrayList();
			}
		});
		thoat_btn.setForeground(Color.WHITE);
		thoat_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		thoat_btn.setFocusable(false);
		thoat_btn.setBackground(Color.GRAY);
		thoat_btn.setBounds(115, 377, 85, 26);
		panel_2.add(thoat_btn);
		

//		textField_NgayVL = new JTextField();
//		textField_NgayVL.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		textField_NgayVL.setColumns(10);
//		textField_NgayVL.setBounds(81, 315, 134, 26);
//		panel_2.add(textField_NgayVL);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(269, 83, 681, 402);
		NhanVien.add(scrollPane_2);
		
		table_NhanVien = new JTable();
		table_NhanVien.setDefaultEditor(Object.class,null);
		String[] colname =  {"Mã nv","Họ","Tên","Giới tính","Số điện thoại","CMND","Ngày sinh","Ngày vào làm",};
		tableModel = new DefaultTableModel();
		table_NhanVien.setModel(tableModel);
		tableModel.setColumnIdentifiers(colname);
		scrollPane_2.setViewportView(table_NhanVien);
		table_NhanVien.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_NhanVien.getColumnModel().getColumn(1).setPreferredWidth(130);
		table_NhanVien.getColumnModel().getColumn(2).setPreferredWidth(50);
		table_NhanVien.getColumnModel().getColumn(3).setPreferredWidth(30);
//		table_NhanVien.getColumnModel().getColumn(4).setPreferredWidth(123);
//		table_NhanVien.getColumnModel().getColumn(5).setPreferredWidth(71);
//		table_NhanVien.getColumnModel().getColumn(7).setPreferredWidth(91);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(269, 10, 681, 63);
		NhanVien.add(panel_3);
		panel_3.setLayout(null);
		
		xoa_btn = new JButton("Xóa");
		xoa_btn.setFocusable(false);
		xoa_btn.setBackground(new Color(255, 0, 0));
		xoa_btn.setForeground(new Color(255, 255, 255));
		xoa_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoa_btn.setBounds(297, 38, 75, 25);
		xoa_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				luu_btn.setEnabled(false);
				luu_btn.setBackground(Color.gray);
				thoat_btn.setEnabled(false);
				thoat_btn.setBackground(Color.gray);
				lockForm();
				NhanVienDTO nv = getSelectedNhanVien();
				if(nv!= null) {
					int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa nhân viên " + nv.getManv(),"Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) {
						xoaNV();
						resetTable();
						initArrayList();
						reSetForm();
					}
				}else JOptionPane.showMessageDialog(null,"Chưa chọn nhân viên");
				
			}
		});
		panel_3.add(xoa_btn);
		
		sua_btn = new JButton("Sửa");

//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
		sua_btn.setFocusable(false);
		sua_btn.setBackground(new Color(50, 205, 50));
		sua_btn.setForeground(new Color(255, 255, 255));
		sua_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_NhanVien.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên");
					return;
				}
				initForm();
				isEdit = true;
				textField_MSNV.setEditable(false);
				them_btn.setBackground(Color.gray);
				them_btn.setEnabled(false);
				xoa_btn.setBackground(Color.gray);
				xoa_btn.setEnabled(false);
				luu_btn.setBackground(Color.orange);
				luu_btn.setEnabled(true);
				thoat_btn.setBackground(Color.red);
				thoat_btn.setEnabled(true);
				textField_MSNV.setEnabled(false);
			}
		});
		sua_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		sua_btn.setBounds(188, 38, 75, 25);
		panel_3.add(sua_btn);
		
		them_btn = new JButton("Thêm");
		them_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isAdd = true;
				textField_HoNV.requestFocusInWindow();
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
		them_btn.setFocusable(false);
		them_btn.setForeground(new Color(255, 255, 255));
		them_btn.setBackground(new Color(65, 105, 225));
		them_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		them_btn.setBounds(81, 38, 75, 25);
		panel_3.add(them_btn);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 9, 70, 13);
		panel_3.add(lblNewLabel_3);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_TimKiem.setBounds(81, 3, 480, 25);
		panel_3.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);
		String []item = {"Mã số","Họ Tên","Tên","Ngày vào làm"};
		timkiem_cb = new JComboBox(item);
		timkiem_cb.setBounds(571, 5, 100, 25);
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
				ArrayList<NhanVienDTO> tmp = nvBUS.timKiem(condition.toLowerCase(), type);
				if(tmp != null) {
					resetTable();
					initArrayList(tmp);
				}
				
			}
		});
		
		
		
		panel_3.add(timkiem_cb);
		
		btn_import = new JButton("Nhập Excel");
		btn_import.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = openFile();
				readFile(f);
			}
		});
		btn_import.setForeground(Color.WHITE);
		btn_import.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_import.setFocusable(false);
		btn_import.setBackground(new Color(51, 153, 51));
		btn_import.setBounds(403, 38, 100, 25);
		panel_3.add(btn_import);
		
		btn_export = new JButton("Xuất Excel");
		btn_export.setForeground(Color.WHITE);
		btn_export.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_export.setFocusable(false);
		btn_export.setBackground(new Color(51, 153, 51));
		btn_export.setBounds(534, 38, 100, 25);
		btn_export.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubFile f = openFile();
				File f = openFile();
				exportExcel(f);
			}
		});
		panel_3.add(btn_export);
		
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
		initData();
		
		this.setVisible(true);
	}
	
	public File openFile() {
		JFileChooser file =  new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xls", "xlsx");
		file.setFileFilter(filter);
		int option = file.showOpenDialog(null);
		if(option == JFileChooser.APPROVE_OPTION) {
			File selectedFile = file.getSelectedFile();
//			System.out.println();
			return selectedFile;
		}
		return null;
	}
	public void openExcel(String f){
	        try{
	            File path = new File(f);
	            Desktop.getDesktop().open(path);
	        }catch(IOException ioe){
	            System.out.println(ioe);
	        }
	}
	
	public void exportExcel(File f){
		if(f==null) return;
		try {
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("Staff List");
			XSSFRow row = null;
			Cell cell = null;
			row = sheet.createRow(0);
			for(int i=0;i <table_NhanVien.getColumnCount();i++) {
				cell = row.createCell(i);
				cell.setCellValue(table_NhanVien.getColumnName(i));
			}
			
			for(int i = 0; i < table_NhanVien.getRowCount();i++) {
				row = sheet.createRow(i+1);
				for(int j=0;j<table_NhanVien.getColumnCount();j++) {
					cell = row.createCell(j);
					cell.setCellValue(table_NhanVien.getValueAt(i, j).toString());
				}
			}
			String path = f.toString()+".xlsx";
			FileOutputStream out = new FileOutputStream(new File(path));
			wb.write(out);
			wb.close();
			out.close();
			openExcel(path);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
//	
	private void readFile(File file) {
		FileInputStream fis = null;
        XSSFWorkbook wb = null;
        try {
			fis = new FileInputStream(file);
			 wb = new XSSFWorkbook(fis);
			 XSSFSheet sheet = wb.getSheetAt(0);
			 XSSFFormulaEvaluator formul = wb.getCreationHelper().createFormulaEvaluator();
			 int rowTitle = 0;
			 ArrayList <NhanVienDTO> listNV = new ArrayList<>();
			 for(Row row: sheet) {
				 if(rowTitle++ == 0) continue;
				 NhanVienDTO nv = new NhanVienDTO();
				 nv.setManv(TaoMaNV());
				 nv.setHonv(row.getCell(0).getStringCellValue());
				 nv.setTennv(row.getCell(1).getStringCellValue());
				 nv.setSdt(row.getCell(2).getStringCellValue());
				 nv.setCmnd(row.getCell(3).getStringCellValue());
				 nv.setNgayvl(KiemTra.getInstance().toDate(row.getCell(4).getStringCellValue()));
				 nv.setNgaysinh(KiemTra.getInstance().toDate(row.getCell(5).getStringCellValue()));
				 nv.setGioitinh(KiemTra.getInstance().GioiTinh(row.getCell(6).getStringCellValue()));
				 listNV.add(nv);
			 }
			 if(nvBUS.themDSNV(listNV)== -1) {
				JOptionPane.showMessageDialog(null, "Thêm dữ liệu từ Excel thất bại"); 
			 }else {
				 JOptionPane.showMessageDialog(null, "Thêm dữ liệu từ Excel thành công"); 
				 resetTable();
				 initArrayList();
			 }
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
	
	public NhanVienDTO getSelectedNhanVien() {
		if (isAdd || isEdit) {
			return null;
		}
		int row = table_NhanVien.getSelectedRow();
		if(row == -1) return null;
		DefaultTableModel model = (DefaultTableModel) table_NhanVien.getModel();
		String manv = model.getValueAt(row, 0) + "";
		String honv = model.getValueAt(row, 1) + "";
		String tennv = model.getValueAt(row, 2) + "";
		String sdt = model.getValueAt(row, 4) + "";
		String cmnd = model.getValueAt(row, 5) + "";
		// Giả sử ngayvlString là một chuỗi chứa ngày tháng năm trong định dạng chuẩn
		String ngayvlString =  model.getValueAt(row, 7) + "";

		// Chuyển đổi chuỗi thành kiểu java.sql.Date
		java.sql.Date ngayvl = java.sql.Date.valueOf(ngayvlString);
		
		String ngaysinhString =  model.getValueAt(row, 6) + "";

		// Chuyển đổi chuỗi thành kiểu java.sql.Date
		java.sql.Date ngaysinh = java.sql.Date.valueOf(ngaysinhString);
		
		Boolean gioitinh =  KiemTra.getInstance().GioiTinh((String)model.getValueAt(row, 3) );
		
		NhanVienDTO nv = new NhanVienDTO(manv.toLowerCase(), honv, tennv, sdt, cmnd, ngayvl, ngaysinh, gioitinh);
		return nv;
	}
	public void hienThiThongTin() {
		NhanVienDTO nv = getSelectedNhanVien();
		this.textField_MSNV.setText(nv.getManv());
		this.textField_HoNV.setText(nv.getHonv());
		this.textField_TenNV.setText(nv.getTennv());
		this.textField_SDT.setText(nv.getSdt());
		this.dateChooser_NgayVL.setDate(nv.getNgayvl());
		this.dateChooser_NgaySinh.setDate(nv.getNgaysinh());
		this.textField_CMND.setText(nv.getCmnd());
		this.comboBox_GioiTinh.setSelectedItem(KiemTra.getInstance().GioiTinh(nv.getGioitinh()) );
	}
	
	public void initArrayList() {
		for(NhanVienDTO nv: NhanVienBUS.nvDTO) {
			tableModel.addRow(new Object[]{
				nv.getManv(),nv.getHonv(),nv.getTennv(),KiemTra.getInstance().GioiTinh(nv.getGioitinh()),nv.getSdt(),nv.getCmnd(),nv.getNgaysinh()+"",nv.getNgayvl()+""
			});
		}
		
		table_NhanVien.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					hienThiThongTin();
				}
			}
		});
	}
	public void initArrayList(ArrayList<NhanVienDTO> t) {
		for(NhanVienDTO nv: t) {
			tableModel.addRow(new Object[]{
				nv.getManv(),nv.getHonv(),nv.getTennv(),KiemTra.getInstance().GioiTinh(nv.getGioitinh()),nv.getSdt(),nv.getCmnd(),nv.getNgaysinh()+"",nv.getNgayvl()+""
			});
		}
		
		table_NhanVien.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					hienThiThongTin();
				}
			}
		});
	}
	public void initData() {
//		if(nvBUS.docNV()) {
			for(NhanVienDTO nv: NhanVienBUS.nvDTO) {
				tableModel.addRow(new Object[]{
					nv.getManv(),nv.getHonv(),nv.getTennv(),KiemTra.getInstance().GioiTinh(nv.getGioitinh()),nv.getSdt(),nv.getCmnd(),nv.getNgaysinh()+"",nv.getNgayvl()+""
				});
			
		}
			table_NhanVien.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 1) {
						hienThiThongTin();
					}
				}
			});
		}
//	}
	public boolean checkNull() {
		if(this.textField_HoNV.getText().isEmpty() || this.textField_TenNV.getText().isEmpty() 
				|| this.textField_CMND.getText().isEmpty()|| this.textField_SDT.getText().isEmpty() || this.dateChooser_NgaySinh.getDate()==null) 
		{
			return true;
		}
		return false;
	}
	public String TaoMaNV() {
		int max=1000,min=0;
		int randNum=(int) ((Math.random() * (max - min)) + min);
		Random random = new Random();
        StringBuilder randomLetters = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            randomLetters.append(randomChar);
        }
		return "nv"+randomLetters.toString()+randNum;
	}
	
	public void themNV() {
		NhanVienDTO nv = new NhanVienDTO();
		nv.setManv(TaoMaNV());
		nv.setHonv(this.textField_HoNV.getText());
		nv.setTennv(this.textField_TenNV.getText());
		Boolean gioitinh = KiemTra.getInstance().GioiTinh(this.comboBox_GioiTinh.getSelectedItem()+"");
		nv.setGioitinh(gioitinh);
		nv.setCmnd(this.textField_CMND.getText());
		nv.setSdt(this.textField_SDT.getText());
		java.util.Date utilDate = this.dateChooser_NgayVL.getDate();
		java.sql.Date sqlDate_ngayVL = new java.sql.Date(utilDate.getTime());
		nv.setNgayvl(sqlDate_ngayVL);
		java.util.Date utilDate1 = this.dateChooser_NgaySinh.getDate();
		java.sql.Date sqlDate_ngaySinh = new java.sql.Date(utilDate1.getTime());
		nv.setNgaysinh(sqlDate_ngaySinh);
		if(nvBUS.themNV(nv)!=-1) {
			JOptionPane.showMessageDialog(null, "Thêm thành công nhân viên");
		}else JOptionPane.showMessageDialog(null, "Không thể thêm nhân viên");
		isAdd = false;
	}
	
	public void xoaNV() {
		NhanVienDTO nv = getSelectedNhanVien();
		if(nvBUS.xoaNV(nv)!=-1) {
			JOptionPane.showMessageDialog(null,"Xoá thành công");
		}else JOptionPane.showMessageDialog(null,"Không thể xóa nhân viên");
		
	}
	
	public void suaNV() {
		String id = this.textField_MSNV.getText();
		NhanVienDTO nv = nvBUS.getById(id);
		if(nv == null) return;
		nv.setManv(this.textField_MSNV.getText());
		nv.setHonv(this.textField_HoNV.getText());
		nv.setTennv(this.textField_TenNV.getText());
		Boolean gioitinh = KiemTra.getInstance().GioiTinh(this.comboBox_GioiTinh.getSelectedItem()+"");
		nv.setGioitinh(gioitinh);
		nv.setCmnd(this.textField_CMND.getText());
		nv.setSdt(this.textField_SDT.getText());
		java.util.Date utilDate = this.dateChooser_NgayVL.getDate();
		java.sql.Date sqlDate_ngayVL = new java.sql.Date(utilDate.getTime());
		nv.setNgayvl(sqlDate_ngayVL);
		java.util.Date utilDate1 = this.dateChooser_NgaySinh.getDate();
		java.sql.Date sqlDate_ngaySinh = new java.sql.Date(utilDate1.getTime());
		nv.setNgaysinh(sqlDate_ngaySinh);
		
		if(nvBUS.suaNV(nv)!=-1) {
			JOptionPane.showMessageDialog(null,"Sửa thông tin thành công nhân viên " + nv.getManv());
		}
		else if(nvBUS.suaNV(nv)==-1)JOptionPane.showMessageDialog(null,"Không thể sửa thông tin nhân viên " + nv.getManv());
		isEdit = false;
	}
	
	
	
	
	public void initForm() {
		this.textField_HoNV.setEditable(true);
		this.textField_TenNV.setEditable(true);
		this.comboBox_GioiTinh.setEnabled(true);
		this.textField_CMND.setEditable(true);
		this.textField_SDT.setEditable(true);
		this.dateChooser_NgaySinh.getCalendarButton().setEnabled(true);
		this.dateChooser_NgayVL.getCalendarButton().setEnabled(true);
	}
	
	public void lockForm() {
		this.textField_HoNV.setEditable(false);
		this.textField_TenNV.setEditable(false);
		this.comboBox_GioiTinh.setEnabled(false);
		this.textField_CMND.setEditable(false);
		this.textField_SDT.setEditable(false);
		this.dateChooser_NgaySinh.getCalendarButton().setEnabled(false);
		this.dateChooser_NgayVL.getCalendarButton().setEnabled(false);
	}
	
	public void reSetForm() {
		this.textField_MSNV.setText("");
		this.textField_HoNV.setText("");
		this.textField_TenNV.setText("");
		this.comboBox_GioiTinh.setSelectedIndex(0);
		this.textField_CMND.setText("");
		this.textField_SDT.setText("");
		this.dateChooser_NgaySinh.setDate(null);
		this.dateChooser_NgayVL.setDate(Calendar.getInstance().getTime());
	}
	
	public void resetTable() {
		DefaultTableModel tableModel =(DefaultTableModel) table_NhanVien.getModel();
		tableModel.setRowCount(0);
	}
	
	public boolean checkValidate() {
		String id = this.textField_MSNV.getText();
        String honv = this.textField_HoNV.getText(); // String
        String tennv = this.textField_TenNV.getText(); // String 
        java.util.Date ngayvl = this.dateChooser_NgayVL.getDate(); // Date
		String sdt = this.textField_SDT.getText(); // String
		String cmnd = this.textField_CMND.getText(); // String
		java.util.Date ngaysinh = this.dateChooser_NgaySinh.getDate(); // Ensure java.util.Date
		String gioitinh = this.comboBox_GioiTinh.getSelectedItem().toString(); // String
		if (gioitinh.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (honv.length() > 255 || tennv.length() > 255) {
			JOptionPane.showMessageDialog(null, "Độ dài họ đệm và tên phải ít hơn 256 ký tự");
			return false;
		}
		if (!sdt.matches("^(02|03|05|07|08|09)\\d{8}$")) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
			return false;
		}
		if (nvBUS.checkDuplicatePhoneNumber(sdt, id) == false) {
			JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại");
			return false;
		}
		if (!cmnd.matches("^(0)\\d{11}$")) {
			JOptionPane.showMessageDialog(null, "CMND không hợp lệ (Phải đủ 12 ký tự số, bắt đầu bằng số 0)");
			return false;
		}
		if (nvBUS.checkDuplicateCMND(cmnd, id) == false) {
			JOptionPane.showMessageDialog(null, "CMND đã tồn tại");
			return false;
		}
		if (System.currentTimeMillis() - ngaysinh.getTime() < 18L * 365 * 24 * 60 * 60 * 1000) {
			JOptionPane.showMessageDialog(null, "Nhân viên phải từ 18 tuổi trở lên");
			return false;
		}
		if (ngayvl.before(ngaysinh)) {
			JOptionPane.showMessageDialog(null, "Ngày vào làm không được trước ngày sinh");
			return false;
		}
		if (ngayvl.after(new Date(System.currentTimeMillis()))) {
			JOptionPane.showMessageDialog(null, "Ngày vào làm không được đi sau thời điểm hiện tại");
		}
//		return nvBUS.checkValidate(id, honv, tennv, sdt, cmnd, ngayvl, ngaysinh);
		return true;
	}
}

	
