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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.PublicKey;
import java.text.Normalizer;
import java.util.ArrayList;
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
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BUS.KhachHangBUS;
import BUS.KiemTra;
import BUS.NhanVienBUS;
import BUS.QlyToursBUS;
import BUS.taikhoanBUS;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.QlyToursDTO;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

public class KhachHang extends JFrame {

//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_MSKH;
	private JTextField textField_HoKH;
	private JTextField textField_TenKH;
	private JTextField textField_SDT;
	private JTable table_KhachHang;
	private JTextField textField_TimKiem;
	private JTextField textField_Email;
	private JButton xoa_btn , sua_btn, btn_thoat, luu_btn;
	private JDateChooser dateChooser_NgaySinh;

	DefaultTableModel tableModel;
	JComboBox comboBox_gioitinh, timkiem_cb;
	
	JTextArea textArea;
    KhachHangBUS khBus = new KhachHangBUS();
    

	JButton btn_QLTour,btn_KHTour,btn_QLDV,btn_KhuyenMai,btn_NhanVien,btn_KhachHang;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang frame = new KhachHang();
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
	public KhachHang() {
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
		
		JLabel lb_TTKH = new JLabel("Thông tin Khách Hàng");
		lb_TTKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_TTKH.setBounds(19, 10, 218, 30);
		KhachHang.add(lb_TTKH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 50, 227, 435);
		KhachHang.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã số");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 32, 45, 13);
		panel_2.add(lblNewLabel_2);
		
		textField_MSKH = new JTextField();
		textField_MSKH.addKeyListener(new KeyListener() {
			
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
					textField_HoKH.requestFocusInWindow();
				}
			}
		});
		textField_MSKH.setEnabled(false);
		textField_MSKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MSKH.setBounds(81, 26, 134, 26);
		panel_2.add(textField_MSKH);
		textField_MSKH.setColumns(10);
		
		textField_HoKH = new JTextField();
		textField_HoKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_HoKH.setColumns(10);
		textField_HoKH.setBounds(81, 72, 134, 26);
		textField_HoKH.addKeyListener(new KeyListener() {
			
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
					textField_TenKH.requestFocusInWindow();
				}
			}
		});
		panel_2.add(textField_HoKH);
		
		JLabel lblNewLabel_2_1 = new JLabel("Họ đệm");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 74, 61, 20);
		panel_2.add(lblNewLabel_2_1);
		
		textField_TenKH = new JTextField();
		textField_TenKH.addKeyListener(new KeyListener() {
			
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
					comboBox_gioitinh.showPopup();
				}
			}
		});
		textField_TenKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_TenKH.setColumns(10);
		textField_TenKH.setBounds(81, 117, 134, 26);
		panel_2.add(textField_TenKH);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tên");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 123, 45, 13);
		panel_2.add(lblNewLabel_2_2);
		
		String [] item_gender = {"Nam","Nữ"};
		
		JLabel diachi = new JLabel("Địa chỉ");
		diachi.setFont(new Font("Tahoma", Font.BOLD, 14));
		diachi.setBounds(10, 234, 61, 20);
		panel_2.add(diachi);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("SĐT");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4_1.setBounds(10, 324, 61, 20);
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
					textField_Email.requestFocusInWindow();
				}
			}
		});
		textField_SDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(81, 318, 134, 26);
		panel_2.add(textField_SDT);
		
		luu_btn = new JButton("Lưu");
		luu_btn.setFocusable(false);
		luu_btn.setForeground(new Color(255, 255, 255));
		luu_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		luu_btn.setBackground(new Color(255, 128, 64));
		luu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getSelectedKhachHang() == null) {
					JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng");
					return;
				}
				suaKH();
				resetTable();
				initArrayList();
				reSetForm();
			}
		});
		luu_btn.setBounds(10, 397, 85, 26);
		panel_2.add(luu_btn);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Email");
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4_1_1.setBounds(10, 356, 61, 20);
		panel_2.add(lblNewLabel_2_4_1_1);
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Email.setColumns(10);
		textField_Email.setBounds(81, 354, 134, 26);
		panel_2.add(textField_Email);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_3.setBounds(10, 262, 205, 46);
		panel_2.add(scrollPane_3);
		
		textArea = new JTextArea();
		textArea.addKeyListener(new KeyListener() {
			
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
					textField_SDT.requestFocusInWindow();
				}
			}
		});
		scrollPane_3.setViewportView(textArea);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Giới Tính");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(10, 171, 76, 13);
		panel_2.add(lblNewLabel_2_2_1);
		
		String item_gioitinh[] = {"Nam","Nữ"};
		comboBox_gioitinh = new JComboBox(item_gioitinh);
		comboBox_gioitinh.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                   textArea.requestFocusInWindow();
                    // Perform actions based on the selected item
                }
            }
        });
		comboBox_gioitinh.setBounds(81, 165, 134, 28);
		panel_2.add(comboBox_gioitinh);
		
		
		String item_dotuoi[] = {"Người lớn","Trẻ em"};
		
		btn_thoat = new JButton("Thoát");
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lockForm();
				xoa_btn.setEnabled(true);
				xoa_btn.setBackground(Color.red);
				sua_btn.setEnabled(true);
				sua_btn.setBackground(new Color(50, 205, 50));
				sua_btn.setForeground(new Color(255, 255, 255));
				btn_thoat.setEnabled(false);
				btn_thoat.setBackground(Color.gray);
				luu_btn.setEnabled(false);
				luu_btn.setBackground(Color.GRAY);
				resetTable();
				initArrayList();
			}
		});
		btn_thoat.setForeground(Color.WHITE);
		btn_thoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_thoat.setFocusable(false);
		btn_thoat.setBackground(new Color(0, 0, 255));
		btn_thoat.setBounds(116, 397, 85, 26);
		panel_2.add(btn_thoat);
		
		dateChooser_NgaySinh = new JDateChooser();
		dateChooser_NgaySinh.getCalendarButton().setEnabled(false);
		dateChooser_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateChooser_NgaySinh.setBounds(81, 203, 134, 26);
		panel_2.add(dateChooser_NgaySinh);
		
		JLabel lblNewLabel_2_4_1_2 = new JLabel("Ngày sinh");
		lblNewLabel_2_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4_1_2.setBounds(10, 206, 76, 20);
		panel_2.add(lblNewLabel_2_4_1_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(269, 50, 681, 435);
		KhachHang.add(scrollPane_2);
		
		table_KhachHang = new JTable();
		table_KhachHang.setFillsViewportHeight(true);
		scrollPane_2.setViewportView(table_KhachHang);
		table_KhachHang.setDefaultEditor(Object.class,null);
		String[] colname =  {"Mã kh","Họ","Tên","Giới tính","Địa chỉ","Số điện thoại","Email","Ngày sinh"};
		tableModel = new DefaultTableModel();
		table_KhachHang.setModel(tableModel);
		tableModel.setColumnIdentifiers(colname);

//		table_KhachHang.getColumnModel().getColumn(1).setPreferredWidth(76);
//		table_KhachHang.getColumnModel().getColumn(2).setPreferredWidth(96);
//		table_KhachHang.getColumnModel().getColumn(5).setPreferredWidth(123);
//		table_KhachHang.getColumnModel().getColumn(6).setPreferredWidth(101);
//		table_KhachHang.getColumnModel().getColumn(7).setPreferredWidth(101);
		
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
		textField_TimKiem.setBounds(81, 3, 160, 25);
		panel_3.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);
		String []item = {"Mã số","Họ Tên","Tên"};
		timkiem_cb = new JComboBox(item);
		timkiem_cb.setBounds(251, 3, 100, 25);
		textField_TimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String condition = textField_TimKiem.getText();
				if(condition.isEmpty()) {
					resetTable();
					initArrayList();
					return;
				}
				String type = (String) timkiem_cb.getSelectedItem();
				ArrayList<KhachHangDTO> tmp = khBus.timKiem(condition.toLowerCase(), type);
				if(tmp != null) {
					resetTable();
					initArrayList(tmp);
				}
				
			}
		});
		panel_3.add(timkiem_cb);

		sua_btn = new JButton("Sửa");
		sua_btn.setForeground(Color.WHITE);
		sua_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		sua_btn.setFocusable(false);
		sua_btn.setBackground(new Color(50, 205, 50));
		sua_btn.setBounds(491, 3, 80, 25);
		sua_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initForm();
				textField_MSKH.setEditable(false);
				xoa_btn.setBackground(Color.gray);
				xoa_btn.setEnabled(false);
				luu_btn.setBackground(Color.orange);
				luu_btn.setEnabled(true);
				btn_thoat.setBackground(Color.red);
				btn_thoat.setEnabled(true);
				textField_MSKH.setEnabled(false);
			}
		});
		panel_3.add(sua_btn);
		
		xoa_btn = new JButton("Xóa");
		xoa_btn.setForeground(Color.WHITE);
		xoa_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoa_btn.setFocusable(false);
		xoa_btn.setBackground(Color.RED);
		xoa_btn.setBounds(581, 3, 75, 25);
		
		xoa_btn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        KhachHangDTO kh = getSelectedKhachHang();
		        if(kh != null) {
		            int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng " + kh.getMakh(),"Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		            if(result == JOptionPane.YES_OPTION) {
		            	int deletedRow = xoaKh(kh);
		            	if(deletedRow != -1) {
		            		tableModel.removeRow(deletedRow);
		            		tableModel.fireTableDataChanged();
		            		table_KhachHang.repaint();
		            		table_KhachHang.revalidate();
		            		reSetForm();
		          
		            	}
	
//		            	resetTable();
//		            	initArrayList();
//		            	reSetForm();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null,"Chưa chọn khách hàng");
		        } 
		    }
		});
		panel_3.add(xoa_btn);
		
		
		
		

		
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
		lockForm();
		this.setVisible(true);
	}
	
public void lockForm() {
		luu_btn.setEnabled(false);
		luu_btn.setBackground(Color.GRAY);
		btn_thoat.setEnabled(false);
		btn_thoat.setBackground(Color.GRAY);
		this.textField_MSKH.setEditable(false);
		this.textField_HoKH.setEditable(false);
		this.textField_TenKH.setEditable(false);
		this.comboBox_gioitinh.setEnabled(false);
		this.dateChooser_NgaySinh.setEnabled(false);
		this.textArea.setEditable(false);
		this.textArea.setEnabled(false);
		this.textField_SDT.setEditable(false);
		this.textField_Email.setEditable(false);
	}
	
	
	public void initData() {
//		if(khBus.docKH()) {
			for(KhachHangDTO kh : KhachHangBUS.khDTO ) {
				tableModel.addRow(new Object[] {
						kh.getMakh(), kh.getHokh(), kh.getTenkh(), KiemTra.getInstance().GioiTinh(kh.isGioitinh()), kh.getDiachi(), kh.getSdt(), kh.getEmail(), kh.getNgaysinh()
				});
			}
			
	     table_KhachHang.addMouseListener( new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount() == 1) {
							hienThiThongTin();
						}
					}
	     });
	     
	     
//		}
	}
	
	
	
	public KhachHangDTO getSelectedKhachHang() {
		int row = table_KhachHang.getSelectedRow();
		if(row == -1) return null;
		DefaultTableModel model = (DefaultTableModel) table_KhachHang.getModel();
		String makh = model.getValueAt(row, 0)+ "";
		String hokh = model.getValueAt(row, 1)+ "";
		String tenkh = model.getValueAt(row, 2)+ "";
		Boolean gioitinh =  KiemTra.getInstance().GioiTinh((String)model.getValueAt(row, 3));		
		String diachi = model.getValueAt(row, 4)+ "";
		String sdt = model.getValueAt(row, 5)+ "";
		String email = model.getValueAt(row, 6)+ "";
		String ngaysinh = model.getValueAt(row, 7)+ "";
		java.sql.Date ngaysinhdate = java.sql.Date.valueOf(ngaysinh);

        KhachHangDTO kh = new KhachHangDTO(makh, hokh, tenkh, diachi, sdt, email, gioitinh, ngaysinhdate);
        return kh;
	}
	public void hienThiThongTin() {
        KhachHangDTO kh =  getSelectedKhachHang();
        if(kh != null) {
        	this.textField_MSKH.setText(kh.getMakh());
        	this.textField_HoKH.setText(kh.getHokh());
        	this.textField_TenKH.setText(kh.getTenkh());
        	this.comboBox_gioitinh.setSelectedItem(KiemTra.getInstance().GioiTinh(kh.isGioitinh()));
        	this.dateChooser_NgaySinh.setDate(kh.getNgaysinh());
        	this.textArea.setText(kh.getDiachi());
        	this.textField_SDT.setText(kh.getSdt());
        	this.textField_Email.setText(kh.getEmail());
        }
	}
	
	
	
	public int xoaKh(KhachHangDTO kh) {
		
		int deletedRow = -1;
		
		if(khBus.xoaKh(kh)!=-1) {
			JOptionPane.showMessageDialog(null,"Xoá thành công");
			
			for (int i = 0; i < table_KhachHang.getRowCount(); i++) {
	            if (table_KhachHang.getValueAt(i, 0).equals(kh.getMakh())) {
	                deletedRow = i;
	                break;
	            }
	        }
		}else {
			JOptionPane.showMessageDialog(null,"Không thể xóa khách hàng");
		}
		return deletedRow;
	}
	
	
	public void suaKH() {
		KhachHangDTO kh = getSelectedKhachHang();
		
		if(kh == null) return;
		
		kh.setMakh(this.textField_MSKH.getText());
		kh.setHokh(this.textField_HoKH.getText());
		kh.setTenkh(this.textField_TenKH.getText());
		Boolean gioitinh = KiemTra.getInstance().GioiTinh(this.comboBox_gioitinh.getSelectedItem()+"");
		kh.setGioitinh(gioitinh);
		kh.setDiachi(this.textArea.getText());
		kh.setSdt(this.textField_SDT.getText());
		kh.setEmail(this.textField_Email.getText());
		java.util.Date utilDate1 = this.dateChooser_NgaySinh.getDate();
		java.sql.Date sqlDate_ngaySinh = new java.sql.Date(utilDate1.getTime());
		kh.setNgaysinh(sqlDate_ngaySinh);
		int result = khBus.suaKh(kh);
		if(result !=-1) {
			JOptionPane.showMessageDialog(null,"Sửa thông tin thành công khách hàng " + kh.getMakh());
		}
		else if(result == -1) {
			JOptionPane.showMessageDialog(null,"Không thể sửa thông tin khách hàng " + kh.getMakh());
		}

	}
	
	
	 public void resetTable() {
		   DefaultTableModel tableModel =(DefaultTableModel) table_KhachHang.getModel();
			tableModel.setRowCount(0);
		 
	}
	 
	 public void initArrayList() {
			for(KhachHangDTO kh: KhachHangBUS.khDTO) {
				tableModel.addRow(new Object[]{
					kh.getMakh().toUpperCase(),kh.getHokh(),kh.getTenkh(),KiemTra.getInstance().GioiTinh(kh.isGioitinh()),kh.getDiachi(),kh.getSdt(),kh.getEmail(),kh.getNgaysinh()
				});
			}
			
			table_KhachHang.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 1) {
						hienThiThongTin();
					}
				}
			});
		}
		public void initArrayList(ArrayList<KhachHangDTO> t) {
			for(KhachHangDTO kh: t) {
				tableModel.addRow(new Object[]{
						kh.getMakh().toUpperCase(),kh.getHokh(),kh.getTenkh(),KiemTra.getInstance().GioiTinh(kh.isGioitinh()),kh.getDiachi(),kh.getSdt(),kh.getEmail(),kh.getNgaysinh()
				});
			}
			
                table_KhachHang.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 1) {
						hienThiThongTin();
					}
				}
			});
		}
	 public void initForm() {
			this.textField_MSKH.setEnabled(true);
			this.textField_HoKH.setEditable(true);
			this.textField_TenKH.setEditable(true);
			this.comboBox_gioitinh.setEnabled(true);
			this.textArea.setEditable(true);
			this.textArea.setEnabled(true);
			this.dateChooser_NgaySinh.setEnabled(true);
			this.textField_SDT.setEditable(true);
			this.textField_Email.setEditable(true);
			
		}
	 
	 public void reSetForm() {
		    KhachHangDTO kh = new KhachHangDTO(); // Tạo đối tượng mới với giá trị mặc định.
		    kh.setDiachi(" "); 
		    this.textField_MSKH.setText("");
		    this.textField_HoKH.setText("");
		    this.textField_TenKH.setText("");
		    this.comboBox_gioitinh.setSelectedIndex(0);
		    this.textArea.setText(kh.getDiachi());
		    this.dateChooser_NgaySinh.setDate(null);
		    this.textField_SDT.setText("");
		    this.textField_Email.setText("");
		}
	 
	 public boolean checkValidate() {
			String ho = this.textField_HoKH.getText();
			String Ten = this.textField_TenKH.getText();
			String diaChi = this.textArea.getText();
			java.util.Date ngaySinh = this.dateChooser_NgaySinh.getDate();
			String gioiTinh = this.comboBox_gioitinh.getSelectedItem().toString();
			String sdt = this.textField_SDT.getText();
			String email = this.textField_Email.getText();
			if(ho.isEmpty() || Ten.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || ngaySinh == null
					|| gioiTinh == null || sdt.isEmpty() || email.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin");
				return false;
			}
			if(KiemTra.getInstance().validate_OnlyString(ho) == false) {
				JOptionPane.showMessageDialog(null, "Họ chỉ chứa chữ cái");
				return false;
			}
			if(KiemTra.getInstance().validate_OnlyString(Ten) == false) {
				JOptionPane.showMessageDialog(null, "Tên chỉ chứa chữ cái");
				return false;
			}
			
			if(KiemTra.getInstance().validate_Email(email) == false) {
				JOptionPane.showMessageDialog(null, "Email không hợp lệ");
				return false;
			}
			
			
			if(KiemTra.getInstance().validate_PhoneNumber(sdt) == false) {
				JOptionPane.showMessageDialog(null, "số điện thoại không hợp lệ");
				return false;
			}
			return true;
		}
}
