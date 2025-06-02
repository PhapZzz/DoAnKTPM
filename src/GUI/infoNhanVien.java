package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.KhachHangBUS;
import BUS.KiemTra;
import BUS.NhanVienBUS;
import DTO.NhanVienDTO;

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

public class infoNhanVien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_NhanVien;
	private JTextField textField_TimKiem;
	private DefaultTableModel tableModel;
	private JComboBox timkiem_cb;
	private NhanVienBUS nvBUS = new NhanVienBUS();
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
	public infoNhanVien(KHTourGUI kht) {
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
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH NHÂN VIÊN");
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
						ArrayList<NhanVienDTO> tmp = nvBUS.timKiem(condition.toLowerCase(), type);
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
		
		table_NhanVien = new JTable();
		scrollPane.setViewportView(table_NhanVien);
		table_NhanVien.setDefaultEditor(Object.class,null);
		String[] colname =  {"Mã nv","Họ","Tên","Giới tính","Số điện thoại","CMND","Ngày sinh","Ngày vào làm"};
		tableModel = new DefaultTableModel();
		table_NhanVien.setModel(tableModel);
		tableModel.setColumnIdentifiers(colname);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienDTO kh = new NhanVienDTO();
				kh = getSelectedNhanVien();
				if(kh== null) {
					JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên");
				}else {
					setVisible(false);
					setData(kh,kht);
				}
			}
		});
		this.setVisible(true);
		initData();
	}
	
	
	
	public void initData() {
		
//		if(khBus.docKH()) {
			for(NhanVienDTO nv : NhanVienBUS.nvDTO ) {
				tableModel.addRow(new Object[] {
						nv.getManv(), nv.getHonv(), nv.getTennv(), KiemTra.getInstance().GioiTinh(nv.getGioitinh()), nv.getSdt(), nv.getCmnd(), nv.getNgaysinh(), nv.getNgayvl()
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
	
	public void initData(ArrayList<NhanVienDTO> listNV) {
			if(nvBUS.docNV()) {
				for(NhanVienDTO nv : listNV ) {
					tableModel.addRow(new Object[] {
							nv.getManv(), nv.getHonv(), nv.getTennv(), KiemTra.getInstance().GioiTinh(nv.getGioitinh()), nv.getSdt(), nv.getCmnd(), nv.getNgaysinh(), nv.getNgayvl()
					});
				}
			}
	}
	
	public NhanVienDTO getSelectedNhanVien() {
		int row = table_NhanVien.getSelectedRow();
		if(row == -1) return null;
		DefaultTableModel model = (DefaultTableModel) table_NhanVien.getModel();
		String manv = model.getValueAt(row, 0)+ "";
		String honv = model.getValueAt(row, 1)+ "";
		String tennv = model.getValueAt(row, 2)+ "";
		Boolean gioitinh =  KiemTra.getInstance().GioiTinh((String)model.getValueAt(row, 3));		
		String sdt = model.getValueAt(row, 4)+ "";
		String cmnd = model.getValueAt(row, 5)+ "";
		String ngaysinh = model.getValueAt(row, 6)+ "";
		java.sql.Date ngaysinhdate = java.sql.Date.valueOf(ngaysinh);
		String ngayVL = model.getValueAt(row, 7)+ "";
		java.sql.Date ngayVLdate = java.sql.Date.valueOf(ngayVL);
        NhanVienDTO kh = new NhanVienDTO(manv, honv, tennv, sdt, cmnd, ngayVLdate, ngaysinhdate,gioitinh );
        return kh;
	}
	
	public void resetTable() {
		   DefaultTableModel tableModel =(DefaultTableModel) table_NhanVien.getModel();
			tableModel.setRowCount(0);
		 
	}
	
	public void setData(NhanVienDTO nv, KHTourGUI kht) {
//		Ve ve = new Ve(DatTourGUI.tourduocchon);
//		ve.setSize(1000, 780);
		kht.tfHuongDanVien.setText(nv.getHonv() + " " + nv.getTennv());

	}
}
