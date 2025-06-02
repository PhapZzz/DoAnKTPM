package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import BUS.CTKHT_ThucChiBUS;
import BUS.CTKhuyenMaiBUS;
import BUS.ChiTietKHT_BUS;
import BUS.DatTourBUS;
import BUS.DichVuBUS;
import BUS.HoaDonBUS;
import BUS.KHToursBUS;
import BUS.KhachHangBUS;
import BUS.KhuyenMaiBUS;
import BUS.NhanVienBUS;
import BUS.QlyToursBUS;
import BUS.chitiethoadonBUS;
import BUS.taikhoanBUS;
import DTO.chitiethoadonDTO;
import DTO.taikhoanDTO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;

public class DangNhapGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_User;
	private JTextField textField_Password;
	taikhoanBUS tkBUS = new taikhoanBUS();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapGUI frame = new DangNhapGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhapGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 344, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(51, 204, 204));
		panel.setBackground(new Color(51, 204, 204));
		panel.setBounds(0, 0, 330, 291);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(45, 74, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TRAVEL");
		lblNewLabel_2.setForeground(new Color(51, 0, 0));
		lblNewLabel_2.setFont(new Font("Eras Bold ITC", Font.BOLD, 28));
		lblNewLabel_2.setBounds(104, 22, 123, 42);
		panel.add(lblNewLabel_2);
		
		textField_User = new JTextField();
		textField_User.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            textField_Password.requestFocusInWindow();
		        }
		    }
		});
		textField_User.setBounds(45, 97, 236, 27);
		panel.add(textField_User);
		textField_User.setColumns(10);
		
		textField_Password = new JPasswordField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(45, 167, 236, 27);
		textField_Password.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        	String user = textField_User.getText();
					String pass = textField_Password.getText();
					checktk(user,pass);
		        }
		    }
		});
		panel.add(textField_Password);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(45, 144, 77, 13);
		panel.add(lblNewLabel_1_1);
		
		JButton dangnhap_btn = new JButton("SIGN IN");
		dangnhap_btn.setFocusPainted(false);
		dangnhap_btn.setBackground(new Color(255, 0, 128));
		dangnhap_btn.setForeground(new Color(255, 255, 255));
		dangnhap_btn.setFont(new Font("Tahoma", Font.BOLD, 16));
		dangnhap_btn.setBounds(104, 233, 135, 33);
		dangnhap_btn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = textField_User.getText();
				String pass = textField_Password.getText();
				
				checktk(user,pass);
			}
		});
		panel.add(dangnhap_btn);
		tkBUS.docTK();
		setVisible(true);
	}
	

	public void checktk(String user, String pass) {
			boolean fl = false;
			for(taikhoanDTO tk: taikhoanBUS.tkDTO) {
				if(tk.getUser().equals(user) && tk.getPass().equals(pass)) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					DichVuBUS dv = new DichVuBUS();
					dv.docKS();
					dv.docNH();
					dv.docPT();
					NhanVienBUS nvBUS = new NhanVienBUS();
					nvBUS.docNV();
					KhachHangBUS khBUS = new KhachHangBUS();
					khBUS.docKH();
					KhuyenMaiBUS kmBUS = new KhuyenMaiBUS();
					kmBUS.docKM();
					QlyToursBUS tourBUS = new QlyToursBUS();
					tourBUS.docTour();
					KHToursBUS khtour = new KHToursBUS();
					khtour.docKHT();
					ChiTietKHT_BUS ctkh_tour = new ChiTietKHT_BUS();
					ctkh_tour.docCTKHT();
					CTKhuyenMaiBUS ctkm = new CTKhuyenMaiBUS();
					ctkm.docCTKM();
					DatTourBUS dat_tour = new DatTourBUS();
					dat_tour.docDSTour();
					HoaDonBUS hdBUS = new HoaDonBUS();
					hdBUS.docHoaDon();
					CTKHT_ThucChiBUS ctkht_thucchi=new CTKHT_ThucChiBUS();
					ctkht_thucchi.docfile();
					setVisible(false);
					TrangChuGUI.tkDTO.setUser(user);
					TrangChuGUI.tkDTO.setPass(pass);
					TrangChuGUI tc = new TrangChuGUI();
					tc.btn_TrangChu.setBackground(Color.ORANGE);
					tc.btn_TrangChu.setForeground(Color.BLACK);
					fl =true;
					return;
				}
			}
			if(!fl) {
				JOptionPane.showMessageDialog(null, "Không tồn tại tài khoản");
				return;
			}
		}
}
