package Dodam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    String pw;
    
	
	private JTextField idField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public GUI() {
        super("Login Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 120);
        setLocationRelativeTo(null);

        idField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        // 레이아웃 설정
        setLayout(new GridLayout(3, 2));
        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel()); // 공백 레이블로 버튼 위치 조정
        add(loginButton);

        // 로그인 버튼 클릭 이벤트 처리
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passwordField.getPassword());
                // 여기에서 로그인 처리 로직을 구현하세요.
                // 예: 로그인 성공 여부에 따라 다음 화면을 보여주거나 에러 메시지를 표시
                System.out.println("ID: " + id + " Password: " + password);
                
                

            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        // GUI 실행
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
    

    
}