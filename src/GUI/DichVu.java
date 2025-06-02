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
import java.text.DecimalFormat;
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
import javax.swing.ListSelectionModel;
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

import com.toedter.calendar.JCalendar;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

import BUS.DichVuBUS;
import BUS.KiemTra;
import BUS.NhanVienBUS;
import BUS.taikhoanBUS;
import DTO.DichVuDTO;
import DTO.KhachSanDTO;
import DTO.NhaHangDTO;
import DTO.NhanVienDTO;
import DTO.PhuongTienDTO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class DichVu extends JFrame {
/**
	 * 
	 */
	//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_MaDichVu;
	private JTable table_DichVu;
	private JTextField textField_TimKiem;
	private JTextField textField_Gia;
	private JComboBox comboBox_LoaiDV, timkiem_cb;
	private JButton them_btn, sua_btn, xoa_btn, thoat_btn, luu_btn;
	JTextArea textArea_tendv;
	JButton btn_QLTour,btn_KHTour,btn_KhuyenMai,btn_NhanVien,btn_KhachHang,btn_QLDV;
	DefaultTableModel tableModel;
	DichVuBUS dvBUS = new DichVuBUS();
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DichVu frame = new DichVu();
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
	public DichVu() {
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
		
		JLabel lb_TTKH = new JLabel("Thông tin Dịch Vụ");
		lb_TTKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_TTKH.setBounds(19, 10, 218, 30);
		KhachHang.add(lb_TTKH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 50, 249, 305);
		KhachHang.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Dịch Vụ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 28, 92, 20);
		panel_2.add(lblNewLabel_2);
		
		textField_MaDichVu = new JTextField();
		textField_MaDichVu.setEnabled(false);
		textField_MaDichVu.addKeyListener(new KeyListener() {
			
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
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					comboBox_LoaiDV.showPopup();
			}
		});;
		textField_MaDichVu.setBackground(Color.WHITE);
		textField_MaDichVu.setEditable(false);
		textField_MaDichVu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MaDichVu.setBounds(112, 26, 125, 26);
		panel_2.add(textField_MaDichVu);
		textField_MaDichVu.setColumns(10);
		
		luu_btn = new JButton("Lưu");
		luu_btn.setEnabled(false);
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
					
					themDV();
					resetTable();
					initArrayList();
					reSetForm();
					
				}else if(!them_btn.isEnabled()) {
					if(getSelectedDichVu() == null ) {
						JOptionPane.showMessageDialog(null, "Chưa chọn dịch vụ");
						return;
					}else if(!checkValidate()) return;
					
					suaDV();
					resetTable();
					initArrayList();
					reSetForm();
				}
			}
		});
		luu_btn.setBounds(28, 267, 85, 26);
		panel_2.add(luu_btn);
		
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tên Dịch Vụ");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(10, 115, 92, 20);
		panel_2.add(lblNewLabel_2_1_1);
		
		textField_Gia = new JTextField();
		textField_Gia.setBackground(Color.WHITE);
		textField_Gia.setEditable(false);
		textField_Gia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Gia.setColumns(10);
		textField_Gia.setBounds(112, 220, 125, 26);
		panel_2.add(textField_Gia);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Giá");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(10, 222, 61, 20);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Loại Dịch Vụ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 72, 92, 20);
		panel_2.add(lblNewLabel_2_1);
		
		String[] item_loaiDV = {"Nhà hàng","Khách sạn","Phương tiện"};
		comboBox_LoaiDV = new JComboBox(item_loaiDV);
		comboBox_LoaiDV.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    textArea_tendv.requestFocusInWindow();
                    // Perform actions based on the selected item
                }
            }
        });
		comboBox_LoaiDV.setEnabled(false);
		comboBox_LoaiDV.setBackground(new Color(255, 255, 255));
		comboBox_LoaiDV.setBounds(112, 70, 125, 26);
		panel_2.add(comboBox_LoaiDV);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setBounds(10, 145, 227, 52);
		panel_2.add(scrollPane_3);
		
		textArea_tendv = new JTextArea();
		textArea_tendv.addKeyListener(new KeyListener() {
			
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
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					textField_Gia.requestFocusInWindow();
				// TODO Auto-generated method stub
				
			}
		});
		textArea_tendv.setEditable(false);
		textArea_tendv.setLineWrap(true);
		textArea_tendv.setWrapStyleWord(true);
		textArea_tendv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_3.setViewportView(textArea_tendv);
		
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
				resetTable();
				reSetForm();
				initArrayList();
			}
		});
		thoat_btn.setForeground(Color.WHITE);
		thoat_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		thoat_btn.setFocusable(false);
		thoat_btn.setBackground(Color.GRAY);
		thoat_btn.setBounds(136, 267, 85, 26);
		panel_2.add(thoat_btn);
		

		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(269, 50, 681, 435);
		KhachHang.add(scrollPane_2);
		
		table_DichVu = new JTable();
		table_DichVu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(table_DichVu);
		table_DichVu.setDefaultEditor(Object.class,null);
		String[] colname =  {"Mã Dịch Vụ","Loại Dịch Vụ","Tên Dịch Vụ","Giá"};
		tableModel = new DefaultTableModel();
		table_DichVu.setModel(tableModel);
		tableModel.setColumnIdentifiers(colname);
		table_DichVu.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_DichVu.getColumnModel().getColumn(1).setPreferredWidth(120);
		table_DichVu.getColumnModel().getColumn(2).setPreferredWidth(360);
		table_DichVu.getColumnModel().getColumn(3).setPreferredWidth(100);
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(269, 10, 681, 30);
		KhachHang.add(panel_3);
		panel_3.setLayout(null);
		
		xoa_btn = new JButton("Xóa");
		xoa_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lockForm();
				DichVuDTO dv = getSelectedDichVu();
				if(dv!= null) {
					int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dịch vụ" + dv.getMaso(),"Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) {
						xoaDV();
						resetTable();
						initArrayList();
						reSetForm();
					}
				}else JOptionPane.showMessageDialog(null,"Chưa chọn nhân viên");
			}
		});
		xoa_btn.setFocusable(false);
		xoa_btn.setBackground(new Color(255, 0, 0));
		xoa_btn.setForeground(new Color(255, 255, 255));
		xoa_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoa_btn.setBounds(596, 3, 75, 25);
		panel_3.add(xoa_btn);
		
		sua_btn = new JButton("Sửa");
		sua_btn.setFocusable(false);
		sua_btn.setBackground(new Color(50, 205, 50));
		sua_btn.setForeground(new Color(255, 255, 255));
		sua_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initForm();
				them_btn.setBackground(Color.gray);
				them_btn.setEnabled(false);
				xoa_btn.setBackground(Color.gray);
				xoa_btn.setEnabled(false);
				luu_btn.setBackground(Color.orange);
				luu_btn.setEnabled(true);
				thoat_btn.setBackground(Color.red);
				thoat_btn.setEnabled(true);
				textField_MaDichVu.setEditable(false);
				textField_MaDichVu.setEnabled(false);
				comboBox_LoaiDV.setEnabled(false);
			}
		});
		sua_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		sua_btn.setBounds(511, 3, 75, 25);
		panel_3.add(sua_btn);
		
		them_btn = new JButton("Thêm");
		them_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_MaDichVu.requestFocusInWindow();
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
		them_btn.setBounds(427, 3, 75, 25);
		panel_3.add(them_btn);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 9, 70, 13);
		panel_3.add(lblNewLabel_3);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_TimKiem.setBounds(81, 3, 160, 25);
		panel_3.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);
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
				condition = KiemTra.getInstance().formatchString(condition);
				ArrayList<DichVuDTO> tmp = dvBUS.timKiem(condition.toLowerCase(), type);
				if(tmp != null) {
					resetTable();
					initArrayList(tmp);
				}
				
			}
		});
		
		
		String[] item_tk = {"Mã Dịch vụ","Loại dịch vụ","Tên dịch vụ"};
		timkiem_cb = new JComboBox(item_tk);
		timkiem_cb.setBackground(Color.WHITE);
		timkiem_cb.setBounds(251, 3, 111, 25);
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
	
	public void initData() {
		
//		if(dvBUS.docNH()) {
			for(NhaHangDTO ks: DichVuBUS.nhDTO) {
				tableModel.addRow(new Object[]{
					ks.getMaso(),"Nhà Hàng",ks.getTendv(),ks.getGiaca()+""
					});
			}
//		}
//		if(dvBUS.docKS()) {
			for(KhachSanDTO ks: DichVuBUS.ksDTO) {
				tableModel.addRow(new Object[]{
					ks.getMaso(),"Khách Sạn",ks.getTendv(),ks.getGiaca()+""
					});
			}
//		}

		
//		if(dvBUS.docPT()) {
			for(PhuongTienDTO pt: DichVuBUS.ptDTO) {
				tableModel.addRow(new Object[]{
					pt.getMaso(),"Phương Tiện",pt.getTendv(),pt.getGiaca()+""
					});
		}
			table_DichVu.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 1) {
						hienThiThongTin();
					}
				}
			});
//		}
	}
	public void initArrayList(ArrayList<DichVuDTO> dv) {
		for(DichVuDTO v: dv) {
			tableModel.addRow(new Object[]{
				v.getMaso(),KiemTra.getInstance().loaiDV(v.getMaso()),v.getTendv(),v.getGiaca()+""
			});
		}
		
		table_DichVu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					hienThiThongTin();
				}
			}
		});
	}
	
	public void initArrayList() {
		
		for(NhaHangDTO nh: DichVuBUS.nhDTO) {
			tableModel.addRow(new Object[]{
				nh.getMaso(),"Nhà Hàng",nh.getTendv(),nh.getGiaca()+""
			});
		}
		
		for(KhachSanDTO ks: DichVuBUS.ksDTO) {
			tableModel.addRow(new Object[]{
				ks.getMaso(),"Khách Sạn",ks.getTendv(),ks.getGiaca()+""
			});
		}
		for(PhuongTienDTO pt: DichVuBUS.ptDTO) {
			tableModel.addRow(new Object[]{
				pt.getMaso(),"Phương Tiện",pt.getTendv(),pt.getGiaca()+""
			});
		}
		
		table_DichVu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					hienThiThongTin();
				}
			}
		});
	}
	public DichVuDTO getSelectedDichVu() {
		int row = table_DichVu.getSelectedRow();
		if(row == -1) return null;
		DefaultTableModel model = (DefaultTableModel) table_DichVu.getModel();
		String madv = model.getValueAt(row, 0) + "";
		String loaidv = model.getValueAt(row, 1) + "";
		String tendv = model.getValueAt(row, 2) + "";
		double giaca = Double.parseDouble(model.getValueAt(row, 3)+"");
		if(KiemTra.getInstance().loaiDV(madv).equalsIgnoreCase("Nhà hàng"))
		{
			DichVuDTO dv = new NhaHangDTO(madv, tendv, giaca);
			return dv;
		}
		else if(KiemTra.getInstance().loaiDV(madv).equalsIgnoreCase("Khách sạn")) {
			DichVuDTO dv = new KhachSanDTO(madv, tendv, giaca);
			return dv;
		}
		else {
			DichVuDTO dv = new PhuongTienDTO(madv, tendv, giaca);
			return dv;
		}
	}
	
	public void hienThiThongTin() {
		DichVuDTO dv = getSelectedDichVu();
		this.textField_MaDichVu.setText(dv.getMaso());
		this.comboBox_LoaiDV.setSelectedItem(KiemTra.getInstance().loaiDV(dv.getMaso()));
		this.textArea_tendv.setText(dv.getTendv());
//		DecimalFormat decimalFormat = new DecimalFormat("#,##0");
//		String formattedNumber = decimalFormat.format(dv.getGiaca()) + " VNĐ";
		this.textField_Gia.setText(dv.getGiaca()+"");
	}
	
	public void reSetForm() {
		this.textField_MaDichVu.setText("");
		this.comboBox_LoaiDV.setSelectedIndex(0);;
		this.textField_Gia.setText("");
		this.textArea_tendv.setText("");
	}
	
	public void initForm() {
		this.textField_Gia.setEditable(true);
		this.textArea_tendv.setEditable(true);
		this.comboBox_LoaiDV.setEnabled(true);
	}
	
	public void lockForm() {
		this.textField_MaDichVu.setEnabled(false);
		this.textField_MaDichVu.setEditable(false);
		this.textField_Gia.setEditable(false);
		this.textArea_tendv.setEditable(false);
		this.comboBox_LoaiDV.setEnabled(false);
	}
	
	public boolean checkNull() {
		if(this.textField_Gia.getText().isEmpty() || this.textArea_tendv.getText().isEmpty()) 
		{
			return true;
		}
		return false;
	}
	
//	public String TaoMaDV(String dv) {
//		int max=1000,min=0;
//		int randNum=(int) ((Math.random() * (max - min)) + min);
//		Random random = new Random();
//        StringBuilder randomLetters = new StringBuilder();
//
//        for (int i = 0; i < 3; i++) {
//            char randomChar = (char) (random.nextInt(26) + 'a');
//            randomLetters.append(randomChar);
//        }
//		return dv+randomLetters.toString()+randNum;
//	}
	
	public void themDV() {
		String maso = comboBox_LoaiDV.getSelectedItem().toString();
		if(maso.equalsIgnoreCase("Nhà Hàng"))
		{
			DichVuDTO dv = new NhaHangDTO();
			maso = dvBUS.TaoMaNhaHang();
			dv.setMaso(maso);
			dv.setTendv(this.textArea_tendv.getText());
			dv.setGiaca(Double.parseDouble(this.textField_Gia.getText()));
			if(dvBUS.themDV(dv)!=-1) {
				JOptionPane.showMessageDialog(null, "Thêm thành công dịch vụ " + dv.getMaso());
			}else JOptionPane.showMessageDialog(null, "Không thể thêm dịch vụ " + dv.getMaso());
		}else if(maso.equalsIgnoreCase("Phương tiện")) {
			DichVuDTO dv = new PhuongTienDTO();
			maso = dvBUS.TaoMaPhuongTien();
			dv.setMaso(maso);
			dv.setTendv(this.textArea_tendv.getText());
			dv.setGiaca(Double.parseDouble(this.textField_Gia.getText()));
			if(dvBUS.themDV(dv)!=-1) {
				JOptionPane.showMessageDialog(null, "Thêm thành công dịch vụ " + dv.getMaso());
			}else JOptionPane.showMessageDialog(null, "Không thể thêm dịch vụ " + dv.getMaso());
		}else {
			DichVuDTO dv = new KhachSanDTO();
			maso = dvBUS.TaoMaKhachSan();
			dv.setMaso(maso);
			dv.setTendv(this.textArea_tendv.getText());
			dv.setGiaca(Double.parseDouble(this.textField_Gia.getText()));
			if(dvBUS.themDV(dv)!=-1) {
				JOptionPane.showMessageDialog(null, "Thêm thành công dịch vụ " + dv.getMaso());
			}else JOptionPane.showMessageDialog(null, "Không thể thêm dịch vụ " + dv.getMaso());
		}
	}
	
	public void xoaDV() {
		DichVuDTO dv = getSelectedDichVu();
		if(KiemTra.getInstance().loaiDV(dv.getMaso()).equalsIgnoreCase("Nhà hàng"))
		{
			if(dvBUS.xoaDV((NhaHangDTO)dv)!=-1) {
				JOptionPane.showMessageDialog(null,"Xoá thành công "+dv.getMaso() );
			}else JOptionPane.showMessageDialog(null,"Không thể xóa dịch vụ " + dv.getMaso());
		}
		else if(KiemTra.getInstance().loaiDV(dv.getMaso()).equalsIgnoreCase("Phương Tiện")) {
			if(dvBUS.xoaDV((PhuongTienDTO)dv)!=-1) {
				JOptionPane.showMessageDialog(null,"Xoá thành công "+dv.getMaso() );
			}else JOptionPane.showMessageDialog(null,"Không thể xóa dịch vụ " + dv.getMaso());
		}
		else if(KiemTra.getInstance().loaiDV(dv.getMaso()).equalsIgnoreCase("Khách Sạn")) {
			if(dvBUS.xoaDV((KhachSanDTO)dv)!=-1) {
				JOptionPane.showMessageDialog(null,"Xoá thành công "+dv.getMaso() );
			}else JOptionPane.showMessageDialog(null,"Không thể xóa dịch vụ " + dv.getMaso());
		}
	}
	
	public void suaDV() {
		DichVuDTO dv = getSelectedDichVu();
		if(dv == null) return;
		String maso = this.textField_MaDichVu.getText();
		if(KiemTra.getInstance().loaiDV(maso).equalsIgnoreCase("Nhà Hàng"))
		{
			dv.setMaso(maso);
			dv.setTendv(this.textArea_tendv.getText());
			dv.setGiaca(Double.parseDouble(this.textField_Gia.getText()));
	
			if(dvBUS.suaDV((NhaHangDTO)dv)!=-1) {
				JOptionPane.showMessageDialog(null,"Sửa thông tin thành công dịch vụ " + dv.getMaso());
			}
			else if(dvBUS.suaDV((NhaHangDTO)dv)==-1)JOptionPane.showMessageDialog(null,"Không thể sửa thông tin dịch vụ " + dv.getMaso());
		}
		if(KiemTra.getInstance().loaiDV(maso).equalsIgnoreCase("Khách Sạn"))
		{
			dv.setMaso(maso);
			dv.setTendv(this.textArea_tendv.getText());
			dv.setGiaca(Double.parseDouble(this.textField_Gia.getText()));
	
			if(dvBUS.suaDV((KhachSanDTO)dv)!=-1) {
				JOptionPane.showMessageDialog(null,"Sửa thông tin thành công dịch vụ " + dv.getMaso());
			}
			else if(dvBUS.suaDV((KhachSanDTO)dv)==-1)JOptionPane.showMessageDialog(null,"Không thể sửa thông tin dịch vụ " + dv.getMaso());
		}
		if(KiemTra.getInstance().loaiDV(maso).equalsIgnoreCase("Phương Tiện"))
		{
			dv.setMaso(maso);
			dv.setTendv(this.textArea_tendv.getText());
			dv.setGiaca(Double.parseDouble(this.textField_Gia.getText()));
	
			if(dvBUS.suaDV((PhuongTienDTO)dv)!=-1) {
				JOptionPane.showMessageDialog(null,"Sửa thông tin thành công dịch vụ " + dv.getMaso());
			}
			else if(dvBUS.suaDV((PhuongTienDTO)dv)==-1)JOptionPane.showMessageDialog(null,"Không thể sửa thông tin dịch vụ " + dv.getMaso());
		}
		
	}
	
	
	public void resetTable() {
		DefaultTableModel tableModel =(DefaultTableModel) table_DichVu.getModel();
		tableModel.setRowCount(0);
	}
	
	public boolean checkValidate() {
		String giaDichVu = this.textField_Gia.getText();
		if(KiemTra.getInstance().validate_OnlyNumber(giaDichVu) == false) {
			JOptionPane.showMessageDialog(null, "Giá dịch vụ chỉ chứa số");
			return false;
		}
		return true;
	}
}
