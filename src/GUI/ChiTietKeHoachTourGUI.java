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

import BUS.ChiTietKHT_BUS;
import BUS.DichVuBUS;
import BUS.KHToursBUS;
import BUS.QlyToursBUS;
import BUS.taikhoanBUS;
import DTO.CTDV_An_DTO;
import DTO.CTDV_KS_DTO;
import DTO.CTDV_PT_DTO;
import DTO.CTKHT_DTO;
import DTO.KHTourDTO;
import DTO.KhachSanDTO;
import DTO.NhaHangDTO;
import DTO.PhuongTienDTO;
import DTO.QlyToursDTO;
import DTO.SdDichVuDTO;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;

public class ChiTietKeHoachTourGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfTimKiem;
	private JTextField tfNgay;
	private JTextField tfThanhTienKS;
	private JTextField tfThanhTienNhaHang;
	private JTextField tfThanhTienPhuongTien;
	private JTextField tfTongTien;
	JButton btn_QLTour,btn_KHTour,btn_QLDV,btn_KhuyenMai,btn_NhanVien,btn_KhachHang;
	JButton btnLuu,btnThoat,btnThem,btnSua,btnDuKien;
	JComboBox cbNhaHang,cbKhachSan,cbPhuongTien,cbMaKHT,cbTimKiem;
	private SdDichVuDTO sddv;
	private CTDV_An_DTO dvAn;
	private CTDV_PT_DTO dvPT;
	private CTDV_KS_DTO dvKS;
	private int comparison=5;
	private double thanhtienks=0,thanhtienpt=0,thanhtiennh=0;
	JPanel panel_2;
	public static String makht_ctkht="";
	
	ChiTietKHT_BUS ctkhtBUS=new ChiTietKHT_BUS();
	private JTextField tfSonguoi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietKeHoachTourGUI frame = new ChiTietKeHoachTourGUI();
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
	public ChiTietKeHoachTourGUI() {
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
		
		JLabel lb_TTKH = new JLabel("CTKHT_Dự kiến");
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
		
//		btnXoa = new JButton("Xóa");
//		btnXoa.setFocusable(false);
//		btnXoa.setBackground(new Color(255, 0, 0));
//		btnXoa.setForeground(new Color(255, 255, 255));
//		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnXoa.setBounds(596, 3, 75, 25);
//		btnXoa.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				CTKHT_DTO ctkht=getCTKHT_DaChon();
//				if (ctkhtBUS.xoa(ctkht) == -1) {
//					JOptionPane.showMessageDialog(panel, "Lỗi!");
//				} else {
//					XoaDataTable();
//					initData();
//					JOptionPane.showMessageDialog(panel, "Xóa thành công!");
//				}
//				
//			}
//		});
//		panel_3.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setFocusable(false);
		btnSua.setBackground(new Color(50, 205, 50));
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(panel, "Chưa chọn chi tiết muốn sửa.");
					return;
				}
				btnThem.setEnabled(false);
				btnThem.setBackground(Color.gray);
//				btnXoa.setEnabled(false);
//				btnXoa.setBackground(Color.gray);
				btnLuu.setEnabled(true);
				btnLuu.setBackground(Color.orange);
				btnThoat.setEnabled(true);
				btnThoat.setBackground(Color.red);
				noneInit();
				cbMaKHT.setEnabled(false);
				CTKHT_DTO ctkht=getCTKHT_DaChon();
				thanhtienks=ctkht.getThanhtienKS();
				thanhtiennh=ctkht.getThanhtienNH();
				thanhtienpt=ctkht.getThanhtienPT();
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(493, 3, 70, 25);
		panel_3.add(btnSua);
		
		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(65, 105, 225));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(383, 3, 100, 25);
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnSua.setEnabled(false);
				btnSua.setBackground(Color.gray);
//				btnXoa.setEnabled(false);
//				btnXoa.setBackground(Color.gray);
				btnLuu.setEnabled(true);
				btnLuu.setBackground(Color.orange);
				btnThoat.setEnabled(true);
				btnThoat.setBackground(Color.red);
				ResetData();
				noneInit();
				thanhtienks=0;
				thanhtiennh=0;
				thanhtienpt=0;
				String makht=KHTourGUI.makht_row;
				KHTourDTO kht= GetKHT(makht);
				tfNgay.setText(kht.getNgaydi().toString());	
				tfTongTien.setText("0");
			}
		});
		panel_3.add(btnThem);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 9, 70, 13);
		panel_3.add(lblNewLabel_3);
		
		tfTimKiem = new JTextField();
		tfTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfTimKiem.setBounds(81, 3, 160, 25);
		tfTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String condition = tfTimKiem.getText();
				String condType = (String) cbTimKiem.getSelectedItem();
				ArrayList<CTKHT_DTO> t = ctkhtBUS.timkiem(condition, condType);
				if (t == null) {
					JOptionPane.showMessageDialog(panel, "Lỗi!");
				} else {
					XoaDataTable();
					initData2(t);
				}
				
			}
		});
		panel_3.add(tfTimKiem);
		tfTimKiem.setColumns(10);
		
		String []condType= {"Mã Khách sạn","Mã Nhà hàng","Mã phương tiện"};
		cbTimKiem = new JComboBox(condType);
		cbTimKiem.setBounds(241, 3, 120, 25);
		panel_3.add(cbTimKiem);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQuayLai.setFocusable(false);
		btnQuayLai.setBackground(new Color(255, 0, 0));
		btnQuayLai.setBounds(573, 3, 108, 25);
		btnQuayLai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				makht_ctkht=KHTourGUI.makht_row;
//				DefaultTableModel model_table = (DefaultTableModel) table.getModel();
//				makht_row = model_table.getValueAt(row, 1) + "";
				setVisible(false);
				new KHTourGUI();
				
			}
			
		});
		panel_3.add(btnQuayLai);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(19, 50, 261, 445);
		KhachHang.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Mã KHT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 11, 73, 13);
		panel_2.add(lblNewLabel_2);
		
		tfNgay = new JTextField();
		tfNgay.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNgay.setEditable(false);
		tfNgay.setColumns(10);
		tfNgay.setBounds(106, 40, 134, 26);
		panel_2.add(tfNgay);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ngày");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 42, 61, 20);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Khách sạn");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 112, 86, 20);
		panel_2.add(lblNewLabel_2_2);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuu.setFocusable(false);
		btnLuu.setBackground(new Color(255, 128, 64));
		btnLuu.setBounds(36, 407, 85, 26);
		btnLuu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnSua.isEnabled() == false) {
					KHTourDTO kht= GetKHT(KHTourGUI.makht_row);
					
					System.out.println("makht_row:"+KHTourGUI.makht_row);
					
					String ngay_tmp=tfNgay.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date ngay1=null;
			        try {
			            ngay1 = sdf.parse(ngay_tmp);
			        } catch (Exception e1) {
			            e1.printStackTrace();
			        }
			        java.sql.Date KtrNgay=new java.sql.Date(ngay1.getTime());
			        comparison = KtrNgay.compareTo(kht.getNgayve());			        
			        if(comparison<0) {	
						ThemCTKHT();
						ResetData();
						XoaDataTable();
						initData();
						LocalDate localDate = KtrNgay.toLocalDate();
						LocalDate increasedLocalDate = localDate.plusDays(1); // Tăng giá trị lên một ngày
						java.sql.Date increasedDate = java.sql.Date.valueOf(increasedLocalDate);
						tfNgay.setText(increasedDate.toString());
						thanhtienks=0;
						thanhtiennh=0;
						thanhtienpt=0;
			        }
			        else if(comparison == 0) {
			        	ThemCTKHT();
						ResetData();
						XoaDataTable();
						initData();
						JOptionPane.showMessageDialog(panel, "Bạn đã hoàn tất thêm chi tiết kế hoạch tour.");
						btnThem.setEnabled(false);
						btnThem.setBackground(Color.gray);
						thanhtienks=0;
						thanhtiennh=0;
						thanhtienpt=0;
			        }
				} else if (btnThem.isEnabled() == false) {
					SuaCTKHT();
					ResetData();
					XoaDataTable();
					init();
					initData();
					btnSua.setEnabled(true);
					btnSua.setBackground(new Color(50, 205, 50));
					thanhtienks=0;
					thanhtiennh=0;
					thanhtienpt=0;
				}
				
		
		}});
		panel_2.add(btnLuu);
		
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Thành tiền");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(10, 156, 86, 20);
		panel_2.add(lblNewLabel_2_1_1);
		
		tfThanhTienKS = new JTextField();
		tfThanhTienKS.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfThanhTienKS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfThanhTienKS.setEditable(false);
		tfThanhTienKS.setColumns(10);
		tfThanhTienKS.setBounds(106, 154, 134, 26);
		panel_2.add(tfThanhTienKS);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Nhà hàng");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(10, 201, 86, 20);
		panel_2.add(lblNewLabel_2_2_1);
		
		
		tfThanhTienNhaHang = new JTextField();
		tfThanhTienNhaHang.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfThanhTienNhaHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfThanhTienNhaHang.setEditable(false);
		tfThanhTienNhaHang.setColumns(10);
		tfThanhTienNhaHang.setBounds(106, 243, 134, 26);
		panel_2.add(tfThanhTienNhaHang);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Thành tiền");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(10, 245, 86, 20);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Phương tiện");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_2.setBounds(10, 288, 98, 20);
		panel_2.add(lblNewLabel_2_2_2);
		
		
		tfThanhTienPhuongTien = new JTextField();
		tfThanhTienPhuongTien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfThanhTienPhuongTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfThanhTienPhuongTien.setEditable(false);
		tfThanhTienPhuongTien.setColumns(10);
		tfThanhTienPhuongTien.setBounds(106, 330, 134, 26);
		panel_2.add(tfThanhTienPhuongTien);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Thành tiền");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_2.setBounds(10, 332, 86, 20);
		panel_2.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Tổng tiền");
		lblNewLabel_2_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_2_1.setBounds(10, 370, 86, 20);
		panel_2.add(lblNewLabel_2_1_1_2_1);
		
		tfTongTien = new JTextField();
		tfTongTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTongTien.setEditable(false);
		tfTongTien.setColumns(10);
		tfTongTien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfTongTien.setBounds(106, 368, 134, 26);
		panel_2.add(tfTongTien);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setFocusable(false);
		btnThoat.setBackground(new Color(255, 0, 0));
		btnThoat.setBounds(144, 407, 85, 26);
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ResetData();
				init();
				
				if(comparison==5) {
					return;
				}
				else if(comparison<0) {
					btnThem.setEnabled(true);
					btnThem.setBackground(new Color(65, 105, 225));
				}
				else if(comparison==0) {
					btnThem.setEnabled(false);
					btnThem.setBackground(Color.gray);
				}
				btnSua.setEnabled(true);
				btnSua.setBackground(new Color(50, 205, 50));
			}
		});
		panel_2.add(btnThoat);
		
		JButton btnThucChi = new JButton("Thực chi");
		btnThucChi.setForeground(Color.WHITE);
		btnThucChi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThucChi.setFocusable(false);
		btnThucChi.setBackground(new Color(0, 128, 0));
		btnThucChi.setBounds(850, 462, 100, 26);
		btnThucChi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CTKHT_ThucChi_GUI();
			}
		});
		KhachHang.add(btnThucChi);
		
		btnDuKien = new JButton("Dự kiến");
		btnDuKien.setForeground(Color.WHITE);
		btnDuKien.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDuKien.setFocusable(false);
		btnDuKien.setBackground(new Color(0, 128, 0));
		btnDuKien.setBounds(722, 462, 100, 26);
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
		ArrayList<String> arrMaKHTour=new ArrayList<String>();
		ArrayList<String> arrMaKS=new ArrayList<String>();
		ArrayList<String> arrMaNH=new ArrayList<String>();
		ArrayList<String> arrMaPT=new ArrayList<String>();
		
		

		for(KHTourDTO kht:KHToursBUS.khtList) {
			arrMaKHTour.add(kht.getMakht());
		}
		cbMaKHT = new JComboBox(arrMaKHTour.toArray());
		cbMaKHT.setSelectedItem(KHTourGUI.makht_row);
		cbMaKHT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbMaKHT.setBounds(106, 4, 134, 26);
		
		cbMaKHT.setSelectedItem(KHTourGUI.makht_row);
		KHTourDTO kht= GetKHT(KHTourGUI.makht_row);
		tfNgay.setText(kht.getNgaydi().toString());
		
		panel_2.add(cbMaKHT);
		
		for(KhachSanDTO ks:DichVuBUS.ksDTO) {
			arrMaKS.add(ks.getMaso());
		}
		cbKhachSan = new JComboBox(arrMaKS.toArray());
		cbKhachSan.setBounds(106, 111, 134, 26);
		cbKhachSan.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				KhachSanDTO ks=GetKhachSan(cbKhachSan.getSelectedItem().toString());
				tfThanhTienKS.setText(ks.getGiaca()*Integer.parseInt(tfSonguoi.getText())+"");
				thanhtienks=ks.getGiaca()*Integer.parseInt(tfSonguoi.getText());
				tfTongTien.setText((thanhtienks+thanhtiennh+thanhtienpt)+"");
				System.out.println("Khach san :"+thanhtienks+" "+thanhtiennh+" "+thanhtienpt);
			}
		});
		panel_2.add(cbKhachSan);
		
		for(NhaHangDTO nh:DichVuBUS.nhDTO) {
			arrMaNH.add(nh.getMaso());
		}
		cbNhaHang = new JComboBox(arrMaNH.toArray());
		cbNhaHang.setBounds(106, 200, 134, 26);
		cbNhaHang.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NhaHangDTO nh=GetNhaHang(cbNhaHang.getSelectedItem().toString());
				tfThanhTienNhaHang.setText(nh.getGiaca()*Integer.parseInt(tfSonguoi.getText())+"");
				thanhtiennh=nh.getGiaca()*Integer.parseInt(tfSonguoi.getText());
				tfTongTien.setText((thanhtienks+thanhtiennh+thanhtienpt)+"");
				System.out.println("Nha hang :"+thanhtienks+" "+thanhtiennh+" "+thanhtienpt);
			}
		});
		panel_2.add(cbNhaHang);
		
		for(PhuongTienDTO pt:DichVuBUS.ptDTO) {
			arrMaPT.add(pt.getMaso());
		}
		cbPhuongTien = new JComboBox(arrMaPT.toArray());
		cbPhuongTien.setBounds(106, 287, 134, 26);
		cbPhuongTien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PhuongTienDTO pt=GetPhuongTien(cbPhuongTien.getSelectedItem().toString());
				tfThanhTienPhuongTien.setText(pt.getGiaca()*Integer.parseInt(tfSonguoi.getText())+"");
				thanhtienpt=pt.getGiaca()*Integer.parseInt(tfSonguoi.getText());
				tfTongTien.setText((thanhtienks+thanhtiennh+thanhtienpt)+"");
				System.out.println("Phuong tien :"+thanhtienks+" "+thanhtiennh+" "+thanhtienpt);
			}
		});
		panel_2.add(cbPhuongTien);
		
		cbMaKHT.setEnabled(false);
		cbKhachSan.setEnabled(false);
		cbPhuongTien.setEnabled(false);
		cbNhaHang.setEnabled(false);
		btnLuu.setEnabled(false);
		btnLuu.setBackground(Color.gray);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số người");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 78, 73, 20);
		panel_2.add(lblNewLabel_2_1);
		
		tfSonguoi = new JTextField();
		tfSonguoi.setEditable(false);
		tfSonguoi.setText((String) null);
		tfSonguoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfSonguoi.setColumns(10);
		tfSonguoi.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfSonguoi.setBounds(106, 76, 134, 26);
		tfSonguoi.setText(GetKHT(KHTourGUI.makht_row).getSonguoidukien()+"");
		panel_2.add(tfSonguoi);
		btnDuKien.setBackground(Color.ORANGE);
		
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
		for (CTKHT_DTO ctkht : ChiTietKHT_BUS.ctkhtList) {
			if(ctkht.getMakht().equals(KHTourGUI.makht_row)) {
				tableModel.addRow(new Object[] { ctkht.getMakht(), ctkht.getNgay(), ctkht.getMaks(),
						ctkht.getThanhtienKS()+"", ctkht.getManh(), ctkht.getThanhtienNH()+"",ctkht.getMapt(),ctkht.getThanhtienPT()+"",ctkht.getTongtien()+"" });
				if(ctkht.getNgay().equals(kht.getNgayve())) {
					btnThem.setEnabled(false);
					btnThem.setBackground(Color.gray);
				}
			}
		}
	}
	
	public void initData2(ArrayList<CTKHT_DTO> list) {
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
		for (CTKHT_DTO ctkht : list) {
			tableModel.addRow(new Object[] { ctkht.getMakht(), ctkht.getNgay(), ctkht.getMaks(),
					ctkht.getThanhtienKS()+"", ctkht.getManh(), ctkht.getThanhtienNH()+"",ctkht.getMapt(),ctkht.getThanhtienPT()+"",ctkht.getTongtien()+"" });
		}
	}
	
	public void HienThiChiTietKHT() {
		CTKHT_DTO ctkht = getCTKHT_DaChon();
		cbMaKHT.setSelectedItem(ctkht.getMakht());
		tfNgay.setText(ctkht.getNgay().toString());
		cbKhachSan.setSelectedItem(ctkht.getMaks());
		tfThanhTienKS.setText(ctkht.getThanhtienKS()*GetKHT(ctkht.getMakht()).getSonguoidukien()+"");
		cbNhaHang.setSelectedItem(ctkht.getManh());
		tfThanhTienNhaHang.setText(ctkht.getThanhtienNH()*GetKHT(ctkht.getMakht()).getSonguoidukien()+"");
		cbPhuongTien.setSelectedItem(ctkht.getMapt());
		tfThanhTienPhuongTien.setText(ctkht.getThanhtienPT()*GetKHT(ctkht.getMakht()).getSonguoidukien()+"");
		tfTongTien.setText(ctkht.getTongtien()+"");
		tfSonguoi.setText(GetKHT(ctkht.getMakht()).getSonguoidukien()+"");
	}
	
	public void noneInit() {
		cbKhachSan.setEnabled(true);
		cbNhaHang.setEnabled(true);
		cbPhuongTien.setEnabled(true);
	}
	
	public CTKHT_DTO getCTKHT_DaChon() {
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
     

		for(CTKHT_DTO ctkht:ChiTietKHT_BUS.ctkhtList) {
			if(ctkht.getMakht().equals(makht)&&ctkht.getNgay().compareTo(ngay)==0) {
				return ctkht;
			}
		}
		return null;	
	}
	
	public void ResetData() {
//		cbMaKHT.setSelectedIndex(0);
		tfNgay.setText("");
		cbKhachSan.setSelectedIndex(0);
		tfThanhTienKS.setText("");
		cbNhaHang.setSelectedIndex(0);
		tfThanhTienNhaHang.setText("");
		cbPhuongTien.setSelectedIndex(0);
		tfThanhTienPhuongTien.setText("");
		tfTongTien.setText("");
	}
	public void ThemCTKHT() {		
		String makht=cbMaKHT.getSelectedItem().toString();
		String ngay_tmp=tfNgay.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date ngay1=null;
        try {
            ngay1 = sdf.parse(ngay_tmp);
        } catch (ParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }
        java.sql.Date ngay=new java.sql.Date(ngay1.getTime());
		String MaKS=cbKhachSan.getSelectedItem().toString();
		double thanhtienKS=Double.parseDouble(tfThanhTienKS.getText());
		String MaNH=cbNhaHang.getSelectedItem().toString();
		double thanhtienNH=Double.parseDouble(tfThanhTienNhaHang.getText());
		String MaPT=cbPhuongTien.getSelectedItem().toString();
		double thanhtienPT=Double.parseDouble(tfThanhTienPhuongTien.getText());
		
		CTKHT_DTO ctkht=new CTKHT_DTO(makht, ngay, MaKS, thanhtienKS, MaNH, thanhtienNH, MaPT, thanhtienPT);
			
		if (ctkhtBUS.them(ctkht) == -1) {
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
		CTKHT_DTO ctkht = getCTKHT_DaChon();
		ctkht.setMaks(cbKhachSan.getSelectedItem().toString());
		ctkht.setManh(cbNhaHang.getSelectedItem().toString());
		ctkht.setMapt(cbPhuongTien.getSelectedItem().toString());
		ctkht.setThanhtienKS(Double.parseDouble(tfThanhTienKS.getText()));
		ctkht.setThanhtienNH(Double.parseDouble(tfThanhTienNhaHang.getText()));
		ctkht.setThanhtienPT(Double.parseDouble(tfThanhTienPhuongTien.getText()));
		if (ctkhtBUS.sua(ctkht) == -1) {
			JOptionPane.showMessageDialog(this, "Lỗi!");
		} else {
			JOptionPane.showMessageDialog(this, "Sửa thành công!");
		}
		
	}
}
