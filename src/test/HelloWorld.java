package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HelloWorld extends JFrame {

	public HelloWorld() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null); // Đặt Layout của JPanel
		panel.setPreferredSize(new Dimension(400, 300));
		panel.setBackground(Color.green);

		// Thêm các thành phần vào JPanel
		for (int i = 0; i < 10; i++) {
			JLabel label = new JLabel("Label " + i);
			panel.add(label);
		}

		// Tạo một JScrollPane và chứa JPanel trong đó
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(5,5,200,200);

		// Đặt các thuộc tính cho JScrollPane
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Thêm JScrollPane vào JFrame
		this.getContentPane().add(scrollPane);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new HelloWorld();

	}

}
