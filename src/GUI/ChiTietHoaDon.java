package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.chitiethoadonBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import DAO.chitiethoadonDAO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.chitiethoadonDTO;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ChiTietHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tongtien;
	private JTable table;
	private JLabel mahd, tennv, tentour, tenkh, ngaytao;
	private JScrollPane scrollPane;
	static String mahd_selected;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietHoaDon frame = new ChiTietHoaDon();
					frame.setSize(700, 450);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	public ChiTietHoaDon(String maHoaDon, String tenNhanVien, String tenKhachHang, String ngayLapHoaDon) {
//	    this();  // Gọi đến hàm khởi tạo không tham số để thiết lập giao diện chung
//
//	    // Đặt văn bản cho các nhãn với dữ liệu cung cấp
//	    mahd.setText(maHoaDon);
//	    tennv.setText(tenNhanVien);
//	    tenkh.setText(tenKhachHang);
//	    ngaytao.setText(ngayLapHoaDon);
//
//	    // Lấy danh sách chi tiết hóa đơn từ cơ sở dữ liệu
//	    chitiethoadonBUS bus = new chitiethoadonBUS();
//	    ArrayList<chitiethoadonDTO> list = bus.getListByMaHD(maHoaDon);
//
//	    // Cập nhật dữ liệu lên bảng
//	    DefaultTableModel model = (DefaultTableModel) table.getModel();
//	    model.setRowCount(0);
//	    for (chitiethoadonDTO ct : list) {
//	        model.addRow(new Object[] {
//	            ct.getMave(),
//	            ct.getMakht(),
//	            ct.getMakh(),
//	            ct.getGiave(),
//	            ct.getMakm(),
//	            ct.getMahd()
//	        });
//	    }
//	}
	public ChiTietHoaDon(String maHoaDon, String tenNhanVien, String tenKhachHang, String ngayLapHoaDon) {
	    this();  // Gọi đến hàm khởi tạo không tham số để thiết lập giao diện chung

	    // Đặt văn bản cho các nhãn với dữ liệu cung cấp
	    for(NhanVienDTO nv: NhanVienBUS.nvDTO) {
	    	if(nv.getManv().equalsIgnoreCase(tenNhanVien)) {
	    		tenNhanVien = nv.getHonv() + " " + nv.getTennv();
	    		break;
	    	}
	    }
	    for(KhachHangDTO kh: KhachHangBUS.khDTO) {
	    	if(kh.getMakh().equalsIgnoreCase(tenKhachHang)) {
	    		tenKhachHang = kh.getHokh() + " " + kh.getTenkh();
	    		break;
	    	}
	    }
	    mahd.setText(maHoaDon);
	    tennv.setText(tenNhanVien);
	    tenkh.setText(tenKhachHang);
	    ngaytao.setText(ngayLapHoaDon);
	    // Lấy tên tour từ HoaDonBUS
	    HoaDonBUS hdBUS = new HoaDonBUS();
	    String tenTour = hdBUS.getTenTourByMaHD(maHoaDon);
	    tentour.setText(tenTour);

	    // Lấy danh sách chi tiết hóa đơn từ cơ sở dữ liệu
	    chitiethoadonBUS bus = new chitiethoadonBUS();
	    ArrayList<chitiethoadonDTO> list = bus.getListByMaHD(maHoaDon);

	    // Cập nhật dữ liệu lên bảng
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);
	    DecimalFormat decimalFormat = new DecimalFormat("#,##0");
	    for (chitiethoadonDTO ct : list) {
	    	String formattedNumber = decimalFormat.format(ct.getGiave()) + " VNĐ";
	        model.addRow(new Object[] {
	            ct.getMave(),
	            ct.getMakht(),
	            ct.getMakh(),
	            formattedNumber,
	            ct.getMakm(),
	            ct.getMahd()
	        });
	    }
	}


	/**
	 * Create the frame.
	 */
	public ChiTietHoaDon() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(480, 200, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 666, 86);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số Hóa Đơn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(31, 10, 99, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Nhân Viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(31, 33, 99, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên Tour:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(31, 56, 87, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tên Khách Hàng:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(356, 10, 114, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày lập HĐ:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(356, 33, 114, 13);
		panel.add(lblNewLabel_4);
		
		mahd = new JLabel(".......................");
		mahd.setBounds(125, 10, 184, 13);
		panel.add(mahd);
		
		tennv = new JLabel(".......................");
		tennv.setBounds(125, 33, 184, 13);
		panel.add(tennv);
		
		tentour = new JLabel(".......................");
		tentour.setBounds(125, 56, 184, 13);
		panel.add(tentour);
		
		tenkh = new JLabel(".......................");
		tenkh.setBounds(472, 10, 184, 13);
		panel.add(tenkh);
		
		ngaytao = new JLabel(".....................");
		ngaytao.setBounds(472, 33, 184, 13);
		panel.add(ngaytao);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		scrollPane.setBounds(10, 98, 666, 270);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Mã Vé", "Mã KHT", "Mã Khách Hàng", "Giá Vé", "Mã Khuyến Mãi"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(2).setPreferredWidth(67);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		
		scrollPane.setViewportView(table);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Thành Tiền :");

		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setBounds(13, 378, 118, 20);
		contentPane.add(lblNewLabel_5);
		chitiethoadonBUS bus = new chitiethoadonBUS();
		ArrayList<chitiethoadonDTO> list = bus.getList();
		double tongGiaVe = bus.getTotal(mahd_selected);
		// Tạo một đối tượng NumberFormat
		NumberFormat nf = NumberFormat.getInstance();

		// Định dạng tongGiaVe với đối tượng NumberFormat
		String tongGiaVeFormatted = nf.format(tongGiaVe);

		tongtien = new JTextField();
		tongtien.setEditable(false);
		tongtien.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		tongtien.setFont(new Font("Tahoma", Font.BOLD, 14));
		tongtien.setBounds(141, 376, 144, 27);

		// Đặt tongGiaVeFormatted + " VND" làm văn bản cho JTextField
		tongtien.setText(tongGiaVeFormatted + " VNĐ");

		contentPane.add(tongtien);
		tongtien.setColumns(10);
		
		this.setVisible(true);
		
		
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		DecimalFormat decimalFormat = new DecimalFormat("#,##0");
		for(chitiethoadonDTO ct : list) {
			String formattedNumber = decimalFormat.format(ct.getGiave()) + " VNĐ";
			model.addRow(new Object[] {
					ct.getMave(),
					ct.getMakht(),
					ct.getMakh(),
					formattedNumber,
					ct.getMakm(),
					ct.getMahd()
			});
		}
		
		
	}
}
