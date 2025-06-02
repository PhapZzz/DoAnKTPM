package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.CTKhuyenMaiBUS;
import BUS.KhuyenMaiBUS;
import BUS.KiemTra;
import BUS.QlyToursBUS;
import DTO.CTKhuyenMaiDTO;
import DTO.KhuyenMaiDTO;
import DTO.QlyToursDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class CTKhuyenMaiGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tentour_txt;
	private JTextField tenct_txt;
	private JComboBox makm_cb , matour_cb;
	private DefaultTableModel tableModel;
	private JButton them_btn, xoa_btn;
	/**
	 * Launch the application.
	 */
	CTKhuyenMaiBUS ctkmBUS = new CTKhuyenMaiBUS();
	public static void main(String[] args) {
		for(KhuyenMaiDTO km: KhuyenMaiBUS.kmDTO) {
			System.out.println(km.getDieukien());						
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CTKhuyenMaiGUI frame = new CTKhuyenMaiGUI();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CTKhuyenMaiGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 830, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 99, 138));
		panel.setBounds(0, 0, 818, 613);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 283, 797, 320);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class,null);
		String[] colname =  {"Mã khuyến mãi","Mã tour"};
		tableModel = new DefaultTableModel();
		table.setModel(tableModel);
		tableModel.setColumnIdentifiers(colname);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT KHUYẾN MÃI");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(244, 10, 285, 54);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã tour");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(206, 151, 138, 24);
		panel.add(lblNewLabel_1);
		
		ArrayList<String> itemList_tour = new ArrayList<>();
		for(QlyToursDTO tour: QlyToursBUS.tourDTO) {
			itemList_tour.add(tour.getMatour());
		}
		String[] item_tour = itemList_tour.toArray(new String[0]);
		matour_cb = new JComboBox(item_tour);
		matour_cb.setBounds(354, 151, 199, 26);
		panel.add(matour_cb);
		matour_cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected_matour = (String) matour_cb.getSelectedItem();
				for(QlyToursDTO tour: QlyToursBUS.tourDTO) {
					if(tour.getMatour().equals(selected_matour)){
						tentour_txt.setText(tour.getTentour());
						break;
					}
				}
			}
		});
		JLabel lblNewLabel_1_1 = new JLabel("Tên tour");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(206, 194, 138, 24);
		panel.add(lblNewLabel_1_1);
		
		tentour_txt = new JTextField();
		tentour_txt.setFont(new Font("Tahoma", Font.BOLD, 10));
		tentour_txt.setEditable(false);
		tentour_txt.setBounds(354, 196, 199, 26);
		panel.add(tentour_txt);
		tentour_txt.setText(QlyToursBUS.tourDTO.get(0).getTentour());
		tentour_txt.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã khuyến mãi");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(206, 62, 138, 24);
		panel.add(lblNewLabel_1_2);
		
		ArrayList<String> itemList = new ArrayList<>();
		for(KhuyenMaiDTO km: KhuyenMaiBUS.kmDTO) {
			itemList.add(km.getMakm());
		}
		String[] item = itemList.toArray(new String[0]);
		makm_cb = new JComboBox(item);
		makm_cb.setBounds(354, 62, 199, 26);
		panel.add(makm_cb);
		makm_cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected_matour = (String) makm_cb.getSelectedItem();
				for(KhuyenMaiDTO km: KhuyenMaiBUS.kmDTO) {
					if(km.getMakm().equals(selected_matour)){
						tenct_txt.setText(km.getTectkm());
						break;
					}
				}
			}
		});
		
		tenct_txt = new JTextField();
		tenct_txt.setFont(new Font("Tahoma", Font.BOLD, 10));
		tenct_txt.setEditable(false);
		tenct_txt.setColumns(10);
		tenct_txt.setBounds(354, 107, 199, 26);
		tenct_txt.setText(KhuyenMaiBUS.kmDTO.get(0).getTectkm());
		panel.add(tenct_txt);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tên chương trình");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(206, 105, 138, 24);
		panel.add(lblNewLabel_1_1_1);
		
		them_btn = new JButton("Thêm");
		them_btn.setForeground(Color.WHITE);
		them_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		them_btn.setFocusable(false);
		them_btn.setBackground(new Color(65, 105, 225));
		them_btn.setBounds(329, 244, 75, 25);
		them_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
				resetTable();
				initArrayList();
				reSetForm();
			}
		});
		panel.add(them_btn);
		
		xoa_btn = new JButton("Xóa");
		xoa_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
				resetTable();
				initArrayList();
				reSetForm();
			}
		});
		xoa_btn.setForeground(Color.WHITE);
		xoa_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoa_btn.setFocusable(false);
		xoa_btn.setBackground(new Color(255, 64, 0));
		xoa_btn.setBounds(438, 244, 75, 25);
		panel.add(xoa_btn);
		setVisible(true);
		initData();
	}
	
	public Boolean them() {
		CTKhuyenMaiDTO ctkm = new CTKhuyenMaiDTO();
		ctkm.setMakm((String)this.makm_cb.getSelectedItem());
		ctkm.setMatour((String)this.matour_cb.getSelectedItem());
		
		if(ctkmBUS.themCTKM(ctkm)!=-1) {
			JOptionPane.showMessageDialog(null, "Thêm thành công chi tiết khuyến mãi");
		}else JOptionPane.showMessageDialog(null, "Không thể thêm chi tiết khuyến mãi");
		return true;
	}
	
	public Boolean xoa() {
		CTKhuyenMaiDTO ctkm = new CTKhuyenMaiDTO();
		ctkm.setMakm((String)this.makm_cb.getSelectedItem());
		ctkm.setMatour((String)this.matour_cb.getSelectedItem());
		
		if(ctkmBUS.xoaCTKM(ctkm)!=-1) {
			JOptionPane.showMessageDialog(null, "Xóa thành công chi tiết khuyến mãi");
		}else JOptionPane.showMessageDialog(null, "Không thể xóa chi tiết khuyến mãi");
		return true;
	}
	
	public void initArrayList() {
			for(CTKhuyenMaiDTO ctkm: CTKhuyenMaiBUS.ctkmDTO) {
				tableModel.addRow(new Object[]{
						ctkm.getMakm().toUpperCase(),ctkm.getMatour().toUpperCase()
				});
			}
		
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 1) {
					hienThiThongTin();
					}
				}
			});
	}
	
	public void initData() {
//		if(ctkmBUS.docCTKM()) {
			for(CTKhuyenMaiDTO ctkm: CTKhuyenMaiBUS.ctkmDTO) {
				tableModel.addRow(new Object[]{
						ctkm.getMakm().toUpperCase(),ctkm.getMatour().toUpperCase()
				});
		}
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 1) {
						hienThiThongTin();
					}
				}
			});
//		}
	}
	public void resetTable() {
		DefaultTableModel tableModel =(DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
	}
	
	public void reSetForm() {
		this.makm_cb.setSelectedIndex(0);
		this.tenct_txt.setText(KhuyenMaiBUS.kmDTO.get(0).getTectkm());
		this.matour_cb.setSelectedIndex(0);
		this.tentour_txt.setText(QlyToursBUS.tourDTO.get(0).getTentour());
	}
	public void hienThiThongTin() {
		CTKhuyenMaiDTO ctkm = getSelectedCTKM();
		this.makm_cb.setSelectedItem(ctkm.getMakm().toLowerCase());
		this.matour_cb.setSelectedItem(ctkm.getMatour().toLowerCase());
		for(QlyToursDTO tour: QlyToursBUS.tourDTO) {
			if(ctkm.getMatour().equalsIgnoreCase(tour.getMatour())) {
				this.tentour_txt.setText(tour.getTentour());
				break;
			}
		}
		for(KhuyenMaiDTO km: KhuyenMaiBUS.kmDTO) {
			if(ctkm.getMakm().equalsIgnoreCase(km.getMakm())) {
				this.tenct_txt.setText(km.getTectkm());
				break;
			}
		}
	}
	
	public CTKhuyenMaiDTO getSelectedCTKM() {
		int row = table.getSelectedRow();
		if(row == -1) return null;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String makm = model.getValueAt(row, 0) + "";
		String matour = model.getValueAt(row, 1) + "";
		
		CTKhuyenMaiDTO ctkm = new CTKhuyenMaiDTO(makm, matour);
		return ctkm;
	}
}
