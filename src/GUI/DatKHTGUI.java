package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
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
import java.awt.image.ImageProducer;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import com.toedter.calendar.JDateChooser;

import BUS.ChiTietKHT_BUS;
import BUS.DatTourBUS;
import BUS.DichVuBUS;
import BUS.KHToursBUS;
import BUS.KiemTra;
import BUS.QlyToursBUS;
import DTO.CTKHT_DTO;
import DTO.DatTourDTO;
import DTO.KHTourDTO;
import DTO.KhachSanDTO;
import DTO.NhaHangDTO;
import DTO.PhuongTienDTO;
import DTO.QlyToursDTO;
import BUS.taikhoanBUS;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class DatKHTGUI extends JFrame {

	// private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	KHToursBUS khtBUS=new KHToursBUS();
	ChiTietKHT_BUS ctkhtBUS=new ChiTietKHT_BUS();
	DatTourBUS dt_bus=new DatTourBUS();
	private JTable table;
	JTextArea textArea_mota;
	JLabel hinh1_lb;
	JLabel lbTenTour;
	JLabel lbGiaTour;
	JLabel thoigian_lb;
	JLabel noikhoihanh_lb;
	JLabel lbThoigian,lbNoikhoihanh;
	String anh1_path="",anh2_path="",anh3_path="";
	public static String makht_row;
	private String matour = null;
	private JButton btnCpNht;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KHTourGUI frame = new KHTourGUI();
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
	public DatKHTGUI(String matour) {
		this.setBackground(SystemColor.windowText);
		setBounds(290, 150, 976, 564);
		this.matour = matour;
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(34, 99, 138));
		panel.setBounds(10, 10, 1000, 515);
		contentPane.add(panel);
		panel.setLayout(null);


		Panel KHTOUR = new Panel();
		KHTOUR.setBackground(new Color(255, 255, 255));
		KHTOUR.setBounds(10, 10, 933, 495);
		panel.add(KHTOUR);
		KHTOUR.setLayout(null);

		JLabel thongtintour_lb = new JLabel("Thông tin Kế hoạch Tour");
		thongtintour_lb.setForeground(new Color(0, 0, 0));
		thongtintour_lb.setBounds(10, 10, 230, 30);
		thongtintour_lb.setFont(new Font("Tahoma", Font.BOLD, 17));
		KHTOUR.add(thongtintour_lb);

		String[] loaiTour = { "Tour trong nước", "Tour nước ngoài" };

		String[] socho = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20" };

		String[] arr_tinh = { "An Giang", "Bà Rịa – Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh",
				"Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ",
				"Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam",
				"Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Thành phố Hồ Chí Minh",
				"Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lạng Sơn", "Lào Cai", "Lâm Đồng",
				"Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình",
				"Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình",
				"Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long",
				"Vĩnh Phúc", "Yên Bái" };
		KHTOUR.setBackground(new Color(255, 255, 255));
		KHTOUR.setBackground(new Color(255, 255, 255));
		
		String [] arrSocho= {"1","2","3","4","5","6","7","8","9","10",
				"11","12","13","14","15","16","17","18","19","20"};
		
		String [] arr_timkiem= {"Mã Tour","Mã KHT","Giá vé"};
		
		lbTenTour = new JLabel("");
		lbTenTour.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbTenTour.setBounds(230, 10, 230, 30);
		KHTOUR.add(lbTenTour);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 48, 905, 437);
		KHTOUR.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(590, 600));
		panel_3.setBackground(Color.WHITE);
		
		JScrollPane table_sp = new JScrollPane();
		table_sp.setForeground(Color.BLACK);
		table_sp.setFont(new Font("Tahoma", Font.BOLD, 10));
		table_sp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_sp.setBounds(10, 10, 568, 240);
		panel_3.add(table_sp);
		
		table = new JTable();
		table_sp.setViewportView(table);
		
		JLabel giatour1_lb = new JLabel("Giá vé");
		giatour1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		giatour1_lb.setBounds(313, 340, 100, 30);
		panel_3.add(giatour1_lb);
		
		
		JScrollPane mota1_sp = new JScrollPane();
		mota1_sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mota1_sp.setBounds(588, 10, 300, 417);
		panel_3.add(mota1_sp);
		
		textArea_mota = new JTextArea();
		textArea_mota.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mota1_sp.setViewportView(textArea_mota);
		textArea_mota.setLineWrap(true);
		textArea_mota.setWrapStyleWord(true);
		
		thoigian_lb = new JLabel("Thời gian");
		thoigian_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		thoigian_lb.setBounds(313, 300, 85, 35);
		panel_3.add(thoigian_lb);
		
		noikhoihanh_lb = new JLabel("Nơi khởi hành");
		noikhoihanh_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		noikhoihanh_lb.setBounds(313, 260, 106, 35);
		panel_3.add(noikhoihanh_lb);

		
		JPanel hinh1_panel = new JPanel();
		hinh1_panel.setLayout(null);
		hinh1_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh1_panel.setBounds(10, 263, 293, 164);
		panel_3.add(hinh1_panel);
		
		hinh1_lb = new JLabel("");
		hinh1_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		hinh1_lb.setBorder(null);
		hinh1_lb.setBackground(Color.WHITE);
		hinh1_lb.setBounds(0, 0, 293, 164);
		hinh1_panel.add(hinh1_lb);
		
		lbGiaTour = new JLabel("0 VND");
		lbGiaTour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGiaTour.setBounds(451, 340, 127, 29);
		panel_3.add(lbGiaTour);
		
		lbThoigian = new JLabel("Thời gian");
		lbThoigian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbThoigian.setBounds(451, 300, 127, 30);
		panel_3.add(lbThoigian);
		
		lbNoikhoihanh = new JLabel("Nơi khởi hành");
		lbNoikhoihanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNoikhoihanh.setBounds(451, 260, 127, 35);
		panel_3.add(lbNoikhoihanh);
		
		JButton btnNewButton = new JButton("Đặt vé");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row==-1) {
					JOptionPane.showMessageDialog(panel, "Bạn chưa chọn Kế hoạch tour.");
					return;
				}
				DatTourDTO tourduocchon=GetKHT();
//				setVisible(false);
				Ve ve = new Ve(tourduocchon);
				ve.setSize(1000, 780);
				setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 127, 80));
		btnNewButton.setBounds(461, 397, 85, 28);
		panel_3.add(btnNewButton);
		
		btnCpNht = new JButton("Cập nhật");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row==-1) {
					JOptionPane.showMessageDialog(panel, "Bạn chưa chọn Kế hoạch tour.");
					return;
				}
				if(GetKHTDaChon()!= null) {
					int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật kế hoạch tour??? " + GetKHTDaChon().getMakht(),"Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) {
						KHTourDTO kht_new=new KHTourDTO();
						KHToursBUS bus=new KHToursBUS();
						DatTourBUS dt_bus=new DatTourBUS();
						ChiTietKHT_BUS ct_bus=new ChiTietKHT_BUS();
						String makht_cu=GetKHTDaChon().getMakht();
						kht_new.copyKHT(GetKHTDaChon());
						kht_new.setMakht(generateRandomString());
						kht_new.setSonguoi(0);
						bus.themKHT(kht_new);
						
						// Không nên thêm trực tiếp -> tạo mảng phụ lưu trc r ms update sau
						
						ArrayList<CTKHT_DTO> ctkht_list=new ArrayList<CTKHT_DTO>();
						
						
						for(CTKHT_DTO t:ChiTietKHT_BUS.ctkhtList) {
							if(t.getMakht().equals(makht_cu)) {
								CTKHT_DTO ct=new CTKHT_DTO();
								ct.copyCTKHT(t);
								ct.setMakht(kht_new.getMakht());
								ctkht_list.add(ct);
							}
						}
						
						for(CTKHT_DTO ct:ctkht_list) {
							ct_bus.them(ct);
						}
						
						dt_bus.themDatTour(kht_new);
						new UpdateKHT(DatKHTGUI.this,kht_new,makht_cu);
					}
				}else JOptionPane.showMessageDialog(null,"Chưa chọn kế hoạch tour");
			}
		});
		btnCpNht.setForeground(Color.WHITE);
		btnCpNht.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCpNht.setFocusPainted(false);
		btnCpNht.setBorder(null);
		btnCpNht.setBackground(new Color(128, 128, 255));
		btnCpNht.setBounds(334, 397, 85, 28);
		panel_3.add(btnCpNht);
		
		init();
		initData();
		HienThiKHT2();

		this.getContentPane().add(panel);
		this.setVisible(true);
	}
	public void initData() {
		dt_bus.docDSTour();
		String [] colname= {"Mã kế hoạch Tour","Ngày đi","Ngày về","Số người/Dự kiến","Giá vé"};
		DefaultTableModel tableModel=new DefaultTableModel() {
			 public boolean isCellEditable(int row,int col) {
	                return false;
	         }
		};
		table.setModel(tableModel);
		ArrayList<String> arrMatour=new ArrayList<String>();
		tableModel.setColumnIdentifiers(colname);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					HienThiKHT();
				}
			}
		});
		ArrayList<KHTourDTO> listKHT = khtBUS.docKHT(matour);
		for(KHTourDTO kht:listKHT) {
			if(!KiemTra.getInstance().checkngaydi(KiemTra.getInstance().toDateUtil(kht.getNgaydi()))) {
				continue;
			}
			tableModel.addRow(new Object[] {
					kht.getMakht(),kht.getNgaydi()+"",kht.getNgayve()+"",
					kht.getSonguoi()+"/"+kht.getSonguoidukien(),kht.getGiaVe()+""
			});
		}
		
	}
	
	public KHTourDTO GetKHTDaChon() {
		int row = table.getSelectedRow();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		String makht = model_table.getValueAt(row, 0) + "";
		for(KHTourDTO kht:KHToursBUS.khtList) {
			if(kht.getMakht().equals(makht)) {
				return kht;
			}
		}
		return null;
	}
	
	public void HienThiKHT() {
		KHTourDTO kht=GetKHTDaChon();
		QlyToursDTO tour=getTour(kht.getMatour());
		DecimalFormat decimalFormat = new DecimalFormat("#,##0");
		String formattedNumber;
		formattedNumber = decimalFormat.format(kht.getGiaVe()) +  " VNĐ";
		lbGiaTour.setText(formattedNumber);
		
		//Hiển thị Chi tiết kế hoạch Tour
		String chitiet="";
		for(CTKHT_DTO ctkht:ChiTietKHT_BUS.ctkhtList) {
			if(ctkht.getMakht().equals(kht.getMakht())) {
				String ngay="  Ngày: "+ctkht.getNgay().toString()+"\n";
				String khachsan="  Khách sạn: "+GetTenKS(ctkht.getMaks())+"\n";
				String nhahang="  Nhà hàng: "+GetTenNH(ctkht.getManh())+"\n";
				String phuongtien="  Phương tiện: "+GetTenPT(ctkht.getMapt())+"\n\n";
				chitiet=chitiet+ngay+khachsan+nhahang+phuongtien;
			}
			
		}
		
		textArea_mota.setText(chitiet);
		
		ImageIcon img1=new ImageIcon(kht.getAnh1().replace('#', '\\'));
		Image image1 = img1.getImage().getScaledInstance(388, 187, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon1 = new ImageIcon(image1);
		hinh1_lb.setIcon(scaledIcon1);
		
		
		lbThoigian.setText(tour.getSongay()+" ngày");
		lbNoikhoihanh.setText(tour.getNoikhoihanh());
		
	}
	
	public void HienThiKHT2() {
		lbTenTour.setText(getTour(matour).getTentour());
	}
	
	public QlyToursDTO getTour(String matour) {
		for(QlyToursDTO tour:QlyToursBUS.tourDTO) {
			if(tour.getMatour().equals(matour)) {
				return tour;
			}
		}
		return null;
	}
	public void init() {
		textArea_mota.setEditable(false);
	}

	
	public DatTourDTO GetKHT() {
		int row = table.getSelectedRow();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		String makht = model_table.getValueAt(row, 0) + "";
		if(makht!=null) {
			for(DatTourDTO dattour:DatTourBUS.dsTour) {
				if(dattour.getMakht().equals(makht)) {
					return dattour;
				}
			}
		}
		return null;
	}

	public void XoaDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.setRowCount(0);
	}
	
	
	public String GetTenKS(String maks) {
		for(KhachSanDTO ks: DichVuBUS.ksDTO) {
			if(ks.getMaso().equals(maks)) {
				return ks.getTendv();
			}
		}
		return null;
	}
	public String GetTenNH(String manh) {
		for(NhaHangDTO nh: DichVuBUS.nhDTO) {
			if(nh.getMaso().equals(manh)) {
				return nh.getTendv();
			}
		}
		return null;
	}
	public String GetTenPT(String mapt) {
		for(PhuongTienDTO pt: DichVuBUS.ptDTO) {
			if(pt.getMaso().equals(mapt)) {
				return pt.getTendv();
			}
		}
		return null;
	}
	
	public static String generateRandomString() {
        Random random = new Random();
        
        // Sinh số ngẫu nhiên từ 0 đến 9999 (4 chữ số)
        int number = random.nextInt(10000);

        // Sinh 2 ký tự ngẫu nhiên (chữ cái từ 'a' đến 'z')
        char char1 = (char) ('a' + random.nextInt(26));
        char char2 = (char) ('a' + random.nextInt(26));

        // Kết hợp tất cả lại
        return "nd" + number + char1 + char2;
    }
	
	public void selectRowByColumnValue(String valueToFind) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int columnIndex = -1;
        String columnName="Mã kế hoạch Tour";

        // Tìm chỉ mục của cột dựa vào tên cột
        for (int i = 0; i < model.getColumnCount(); i++) {
            if (model.getColumnName(i).equals(columnName)) {
                columnIndex = i;
                break;
            }
        }

        if (columnIndex == -1) {
            System.out.println("Không tìm thấy cột: " + columnName);
            return;
        }

        // Lặp qua tất cả các dòng để tìm giá trị
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, columnIndex).equals(valueToFind)) {
                table.setRowSelectionInterval(i, i); // Chọn dòng
                table.scrollRectToVisible(table.getCellRect(i, 0, true)); // Cuộn tới dòng được chọn
//                System.out.println("Đã chọn dòng: " + i);
//                HienThiTour();
                return;
            }
        }

        System.out.println("Không tìm thấy giá trị: " + valueToFind);
    }
}
