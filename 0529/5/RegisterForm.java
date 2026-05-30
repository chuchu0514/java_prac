import java.awt.*;
import javax.swing.*;

public class RegisterForm extends JFrame {

    public RegisterForm() {
        setTitle("회원가입");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridLayout(3, 2));

        centerPanel.add(new JLabel("이름"));
        centerPanel.add(new JTextField());

        centerPanel.add(new JLabel("아이디"));
        centerPanel.add(new JTextField());

        centerPanel.add(new JLabel("비밀번호"));
        centerPanel.add(new JPasswordField());

        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JButton("가입"));
        bottomPanel.add(new JButton("취소"));

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterForm();
    }
}