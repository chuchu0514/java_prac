package exam.gui;

import java.awt.*;
import javax.swing.*;  

public class Main{
	public static void main(String args[]) {
		new MyFrame();
		
	}
}

class MyFrame extends JFrame{
	public MyFrame() {
		setTitle("로그인");
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,2));
		
		JLabel lbl = new JLabel("아이디");
		add(lbl);
		add(new JTextField());
		add(new JLabel("비밀번호"));
		add(new JPasswordField());
		
		setVisible(true);
	}
}