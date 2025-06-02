package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.KhachHangBUS;
import BUS.KiemTra;
import DTO.KhachHangDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;

public class infoKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_KhachHang;
	private JTextField textField_TimKiem;
	private DefaultTableModel tableModel;
	private JComboBox timkiem_cb;
	private KhachHangBUS khBus = new KhachHangBUS();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					infoKhachHang frame = new infoKhachHang();
//					frame.setSize(700,400);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public infoKhachHang(Ve ve) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700,400);
		setBounds(400, 220, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 686, 363);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 5, 686, 52);
		panel.add(lblNewLabel);
		
		JPanel panel_func = new JPanel();
		panel_func.setBounds(10, 54, 666, 63);
		panel.add(panel_func);
		panel_func.setLayout(null);
		
		JLabel lb_timKiem = new JLabel("Tìm kiếm");
		lb_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_timKiem.setBounds(10, 10, 80, 13);
		panel_func.add(lb_timKiem);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_TimKiem.setBounds(10, 28, 246, 25);
		textField_TimKiem.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String condition = textField_TimKiem.getText();
						if(condition.isEmpty()) {
							resetTable();
							initData();
							return;
						}
						String type = (String) timkiem_cb.getSelectedItem();
						ArrayList<KhachHangDTO> tmp = khBus.timKiem(condition.toLowerCase(), type);
						if(tmp != null) {
							resetTable();
							initData(tmp);
						}
						
					}
				});
		panel_func.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);
		
		String item[] = {"Mã số","Họ tên","Tên"};
		timkiem_cb = new JComboBox(item);
		timkiem_cb.setBounds(269, 28, 80, 25);
		panel_func.add(timkiem_cb);
		
		JButton btnNewButton = new JButton("Lưu");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setDefaultCapable(false);
		btnNewButton.setBackground(new Color(0, 204, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(282, 124, 75, 30);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 162, 666, 191);
		panel.add(scrollPane);
		
		table_KhachHang = new JTable();
		scrollPane.setViewportView(table_KhachHang);
		table_KhachHang.setDefaultEditor(Object.class,null);
		String[] colname =  {"Mã kh","Họ","Tên","Giới tính","Địa chỉ","Số điện thoại","Email","Ngày sinh"};
		tableModel = new DefaultTableModel();
		table_KhachHang.setModel(tableModel);
		tableModel.setColumnIdentifiers(colname);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHangDTO kh = new KhachHangDTO();
				kh = getSelectedKhachHang();
				if(kh== null) {
					JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng");
				}else {
					setVisible(false);
					setData(kh,ve);
				}
			}
		});
		this.setVisible(true);
		initData();
	}
	
	
	
	public void initData() {
		
//		if(khBus.docKH()) {
			for(KhachHangDTO kh : KhachHangBUS.khDTO ) {
				tableModel.addRow(new Object[] {
						kh.getMakh(), kh.getHokh(), kh.getTenkh(), KiemTra.getInstance().GioiTinh(kh.isGioitinh()), kh.getDiachi(), kh.getSdt(), kh.getEmail(), kh.getNgaysinh()
				});
			}
			
//	     table_KhachHang.addMouseListener( new MouseAdapter() {
//					public void mouseClicked(MouseEvent e) {
//						if(e.getClickCount() == 1) {
//							hienThiThongTin();
//						}
//					}
//	     });
	     
	     
//		}
	}
	
	public void initData(ArrayList<KhachHangDTO> listKH) {
			if(khBus.docKH()) {
				for(KhachHangDTO kh : listKH ) {
					tableModel.addRow(new Object[] {
							kh.getMakh(), kh.getHokh(), kh.getTenkh(), KiemTra.getInstance().GioiTinh(kh.isGioitinh()), kh.getDiachi(), kh.getSdt(), kh.getEmail(), kh.getNgaysinh()
					});
				}
			}
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
	
	public void resetTable() {
		   DefaultTableModel tableModel =(DefaultTableModel) table_KhachHang.getModel();
			tableModel.setRowCount(0);
		 
	}
	
	public void setData(KhachHangDTO kh, Ve ve) {
//		Ve ve = new Ve(DatTourGUI.tourduocchon);
//		ve.setSize(1000, 780);
		ve.tf_maso.setText(kh.getMakh());
		ve.tfHoTen.setText(kh.getHokh()+" " +kh.getTenkh());
		ve.tfEmail.setText(kh.getEmail());
		ve.tfSdt.setText(kh.getSdt());
		ve.tfDiachi.setText(kh.getDiachi());
		ve.cbGioitinh.setSelectedItem(KiemTra.getInstance().GioiTinh(kh.isGioitinh()));
		ve.datechooserNgaysinh.setDate(kh.getNgaysinh());
	}
}
