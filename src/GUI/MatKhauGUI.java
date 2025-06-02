package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import BUS.taikhoanBUS;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class MatKhauGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField matkhau_old;
	private JTextField matkhau_new;
	private JButton luu_btn;
	/**
	 * Launch the application.
	 */
	taikhoanBUS tkBUS = new taikhoanBUS();
	private JTextField matkhau_renew;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatKhauGUI frame = new MatKhauGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public MatKhauGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 250, 340, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(51, 204, 204));
		panel.setBackground(new Color(51, 204, 204));
		panel.setBounds(0, 0, 332, 362);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu cũ");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(45, 74, 115, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ĐỔI MẬT KHẨU");
		lblNewLabel_2.setForeground(new Color(51, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBounds(75, 22, 186, 42);
		panel.add(lblNewLabel_2);
		
		matkhau_old = new  JPasswordField();
		matkhau_old.setBounds(45, 97, 236, 27);
		panel.add(matkhau_old);
		matkhau_old.setColumns(10);
		
		matkhau_new = new JPasswordField();
		matkhau_new.setColumns(10);
		matkhau_new.setBounds(45, 167, 236, 27);
		panel.add(matkhau_new);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu mới");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(45, 144, 115, 20);
		panel.add(lblNewLabel_1_1);
		
		luu_btn = new JButton("Lưu");
		luu_btn.setBackground(new Color(255, 0, 128));
		luu_btn.setForeground(new Color(255, 255, 255));
		luu_btn.setFont(new Font("Tahoma", Font.BOLD, 16));
		luu_btn.setBounds(109, 307, 135, 33);
		
		matkhau_renew = new JPasswordField();
		matkhau_renew.setColumns(10);
		matkhau_renew.setBounds(45, 244, 236, 27);
		panel.add(matkhau_renew);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nhập lại mật khẩu mới");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(45, 221, 186, 20);
		panel.add(lblNewLabel_1_1_1);
		luu_btn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = matkhau_old.getText();
				String pass = matkhau_new.getText();
				String repass = matkhau_renew.getText();
				change_Password(user,pass,repass);
			}
		});
		panel.add(luu_btn);
		
		setVisible(true);
	}
	
	public void change_Password(String user,String pass,String repass) {
		if(user.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Vui lòng điền đủ thông tin");
			return;
		}
		if(!TrangChuGUI.tkDTO.getPass().equals(user)) {
			JOptionPane.showMessageDialog(null,"Mật khẩu không đúng");
			return;
		}else {
			if(pass.length() < 6) {
				JOptionPane.showMessageDialog(null,"Mật khẩu mới ít nhất có 6 kí tự");
				return;
			}else if(!pass.equals(repass)) {
				JOptionPane.showMessageDialog(null,"Mật khẩu mới không trùng khớp");
				return;
			}else {
				taikhoanBUS tkBUS = new taikhoanBUS();
				TrangChuGUI.tkDTO.setPass(pass);
				if(tkBUS.change_info(TrangChuGUI.tkDTO) != -1) {
					JOptionPane.showMessageDialog(null,"Thay đổi mật khẩu thành công! Vui lòng đăng nhập lại!");
					setVisible(false);
					 Window[] windows = JFrame.getWindows();
				        for (Window window : windows) {
				            if (window instanceof JFrame) {
				                ((JFrame) window).dispose();
				            }
				        }
					DangNhapGUI dn = new DangNhapGUI();
				}else {
					JOptionPane.showMessageDialog(null,"Thay đổi thất bại!");	
				}
			}
		}
	}
}
