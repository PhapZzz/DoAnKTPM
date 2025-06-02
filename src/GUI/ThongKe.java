package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;

import BUS.HoaDonBUS;
import BUS.KHToursBUS;
import BUS.KiemTra;
import BUS.taikhoanBUS;
import BUS.thongkeBUS;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import DTO.thongkeDTO;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ScrollPaneConstants;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.DecimalFormat;

public class ThongKe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField luotkhach_textField;
	private JTextField tongchi_textField;
	private JTextField doanhthu_textField;
	private JTable table;
	private JTable tour_table;
	JButton btn_TrangChu,btn_DatTour,btn_HoaDon,btn_ThongKe;
	private JTextField total_txt;
	private JTable quy_table;
	private JComboBox year_cbo;
	private DefaultTableModel tableModel_emp,tableModel_cus,tableModel_quy,tableModel_tk;
	private JTable employeeTable, customertable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe frame = new ThongKe();
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
	public ThongKe() {
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
			@Override
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
		
//		Label label = new Label("New label");
//		label.setIgnoreRepaint(true);
//		label.setBackground(new Color(0, 128, 128));
//		label.setBounds(21, 24, 90, 79);
//		panel.add(label);
//		
		
		
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
		
		Panel ThongKe = new Panel();
		ThongKe.setBounds(13, 127, 960, 495);
		panel.add(ThongKe);
		ThongKe.setLayout(null);
		ThongKe.setBackground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 940, 28);
		ThongKe.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Quản Lý Thống Kê Giao Dịch");
		lblNewLabel_1.setBounds(346, 0, 262, 26);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_2_2 = new JLabel("Lượt khách:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(336, 116, 81, 26);
		ThongKe.add(lblNewLabel_2_2);
		
		luotkhach_textField = new JTextField();
		luotkhach_textField.setEditable(false);
		luotkhach_textField.setBounds(415, 120, 68, 21);
		ThongKe.add(luotkhach_textField);
		luotkhach_textField.setColumns(10);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Tổng chi:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2_1.setBounds(515, 116, 68, 26);
		ThongKe.add(lblNewLabel_2_2_1);
		
		tongchi_textField = new JTextField();
		tongchi_textField.setEditable(false);
		tongchi_textField.setColumns(10);
		tongchi_textField.setBounds(573, 120, 130, 21);
		ThongKe.add(tongchi_textField);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Doanh Thu:");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2_1_1.setBounds(734, 116, 81, 26);
		ThongKe.add(lblNewLabel_2_2_1_1);
		
		doanhthu_textField = new JTextField();
		doanhthu_textField.setEditable(false);
		doanhthu_textField.setColumns(10);
		doanhthu_textField.setBounds(808, 121, 130, 21);
		ThongKe.add(doanhthu_textField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 255));
		panel_2.setBounds(13, 151, 309, 43);
		ThongKe.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Thống kê nhân viên");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(85, 0, 138, 41);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setBackground(Color.WHITE);
		
		
		
		// Tạo JScrollPane cho Nhân viên
        JScrollPane employeeScrollPane = new JScrollPane();
        employeeScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        employeeScrollPane.setBorder(BorderFactory.createLineBorder(new Color(130, 135, 144), 2, true));
        employeeScrollPane.setBounds(13, 204, 309, 235);
        ThongKe.add(employeeScrollPane);
        
        employeeTable = new JTable();
        employeeTable.setDefaultEditor(Object.class,null);
		String[] colname_nv =  {"Mã nhân viên","Tổng thu",};
		tableModel_emp = new DefaultTableModel();
		employeeTable.setModel(tableModel_emp);
		tableModel_emp.setColumnIdentifiers(colname_nv);
		employeeScrollPane.setViewportView(employeeTable);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2, true));
		scrollPane.setBounds(13, 204, 309, 235);
		ThongKe.add(scrollPane);
		
		customertable = new JTable();
		customertable.setBounds(13, 204, 309, 235);

        customertable.setDefaultEditor(Object.class,null);
		String[] colname_kh =  {"Mã khách hàng","Tổng chi",};
		tableModel_cus = new DefaultTableModel();
		customertable.setModel(tableModel_cus);
		tableModel_cus.setColumnIdentifiers(colname_kh);
		scrollPane.setViewportView(customertable);
		scrollPane.setVisible(false);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(0, 255, 255));
		panel_2_1.setBounds(332, 152, 622, 43);
		ThongKe.add(panel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Thống kê chi tiết");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBackground(Color.WHITE);
		lblNewLabel_3_1.setBounds(266, 0, 125, 41);
		panel_2_1.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(332, 205, 622, 235);
		ThongKe.add(scrollPane_1);
		
		tour_table = new JTable();
		
		tour_table.setDefaultEditor(Object.class,null);
		String[] colname_tk =  {"Mã kế hoạch","Mã tour","Tổng chi","Doanh thu","Lợi nhuận",};
		tableModel_tk = new DefaultTableModel();
		tour_table.setModel(tableModel_tk);
		tableModel_tk.setColumnIdentifiers(colname_tk);
		
		scrollPane_1.setViewportView(tour_table);
		
		String[] options = {"Nhân viên", "Khách hàng"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(10, 120, 312, 21);
        ThongKe.add(comboBox);
		
          //Sử lý sự kiện combobox
        comboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String) comboBox.getSelectedItem();
				if(selectedOption.equals("Nhân viên")){
					lblNewLabel_3.setText("Thống kê nhân viên");
					employeeScrollPane.setVisible(true);
					scrollPane.setVisible(false);
				} else if(selectedOption.equals("Khách hàng")) {
					lblNewLabel_3.setText("Thống kê khách hàng");
					employeeScrollPane.setVisible(false);
					scrollPane.setVisible(true);
				}
							
			}
        	
        });
		
		year_cbo = new JComboBox();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int year = 2024; year != currentYear+1; year++) {
			year_cbo.addItem(String.valueOf(year));
        }
//		year_cbo.addItem(String.valueOf("2024"));
		year_cbo.setBounds(10, 48, 92, 26);
//		year_cbo.setSelectedIndex(year_cbo.getItemCount()-1);
		year_cbo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					resetTable();
					initData();
				}
			}
		});
		System.out.println(year_cbo.getItemCount());
		year_cbo.setFocusable(false);
		ThongKe.add(year_cbo);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng lợi nhuận");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(13, 457, 126, 28);
		ThongKe.add(lblNewLabel_2);
		
		total_txt = new JTextField();
		total_txt.setFocusable(false);
		total_txt.setEditable(false);
		total_txt.setFont(new Font("Tahoma", Font.BOLD, 12));
		total_txt.setBounds(149, 455, 187, 28);
		ThongKe.add(total_txt);
		total_txt.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(206, 48, 597, 58);
		ThongKe.add(scrollPane_2);
		
		quy_table = new JTable();
		quy_table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane_2.setViewportView(quy_table);
		quy_table.setDefaultEditor(Object.class,null);
		String[] colname =  {"Quý","Quý 1","Quý 2","Quý 3","Quý 4",};
		tableModel_quy = new DefaultTableModel();
		quy_table.setModel(tableModel_quy);
		tableModel_quy.setColumnIdentifiers(colname);
		
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
		initData();
		this.setVisible(true);
		
	}
	public void initData() {
		String year_Selected = (String) year_cbo.getSelectedItem();
		thongkeBUS tkBUS = new thongkeBUS();
		//doanhthu
		double total_doanhthu = tkBUS.getDoanhThu(year_Selected);
		DecimalFormat decimalFormat = new DecimalFormat("#,##0");
		String formattedNumber = decimalFormat.format(total_doanhthu);
		formattedNumber += " VNĐ";
		this.doanhthu_textField.setText(formattedNumber);
		//tong chi
		double total_tongchi = tkBUS.getTongChi(year_Selected);
		formattedNumber = decimalFormat.format(total_tongchi);
		formattedNumber += " VNĐ";
		tongchi_textField.setText(formattedNumber);
		//loinhuan
		double loinhuan = total_doanhthu - total_tongchi;
		formattedNumber = decimalFormat.format(loinhuan);
		formattedNumber += " VNĐ";
		total_txt.setText(formattedNumber);
		//soluong kh
		int quatity = tkBUS.getQuanTity_Cus(year_Selected);
		luotkhach_textField.setText(quatity+"");
		//bang nv
		ArrayList<HoaDonDTO> listHD_NV = tkBUS.getTK_NV(year_Selected);
		for(HoaDonDTO hd: listHD_NV) {
			formattedNumber = decimalFormat.format(hd.getTongtien());
			formattedNumber += " VNĐ";
			tableModel_emp.addRow(new Object[]{
				hd.getManv().toUpperCase(),formattedNumber,
			});
		}
		//bang kh
		ArrayList<HoaDonDTO> listHD_KH = tkBUS.getTK_KH(year_Selected);
		for(HoaDonDTO hd: listHD_KH) {
			formattedNumber = decimalFormat.format(hd.getTongtien());
			formattedNumber += " VNĐ";
			tableModel_cus.addRow(new Object[]{
				hd.getMakh().toUpperCase(),formattedNumber,
			});
		}
		//bang quy
		double quy1 = tkBUS.getQuy(1, 3, year_Selected);
		double quy2 = tkBUS.getQuy(4, 6, year_Selected);
		double quy3 = tkBUS.getQuy(7, 9, year_Selected);
		double quy4 = tkBUS.getQuy(10, 12, year_Selected);
		
		tableModel_quy.addRow(new Object[]{
			"Lợi Nhuận",decimalFormat.format(quy1) + " VNĐ",decimalFormat.format(quy2) + " VNĐ",decimalFormat.format(quy3) + " VNĐ",decimalFormat.format(quy4) + " VNĐ",
		});
		quy_table.setRowHeight(0, 36);
		//thong ke chi tiet tour
		ArrayList<thongkeDTO> listTk_tours = new ArrayList<>();
		listTk_tours = tkBUS.getTk_tours_thu(year_Selected);
		for(thongkeDTO tk: listTk_tours) {
			tableModel_tk.addRow(new Object[] {
					tk.getMakht(),tk.getMatour(),decimalFormat.format(tk.getChi()) + " VNĐ",
					decimalFormat.format(tk.getThu()) + " VNĐ",
					decimalFormat.format(tk.getThu()-tk.getChi())+ " VNĐ",
			});
		}
	}
	
	public void resetTable() {
		tableModel_tk.setRowCount(0);
		tableModel_emp.setRowCount(0);
		tableModel_cus.setRowCount(0);
		tableModel_quy.setRowCount(0);
	}
}
