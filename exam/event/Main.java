import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  

public class Main{
	public static void main(String args[]) {
		new MyFrame();
		
	}
}

class MyFrame extends JFrame{
	JLabel lbl = new JLabel("대기중");
	
	public MyFrame() {
		setTitle("클릭테스트");
		setSize(250,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		add(lbl);
		JButton btn = new JButton("눌러");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl.setText("눌렸다!");   
				
			}
		});
		add(btn);
		setVisible(true);
	}
}