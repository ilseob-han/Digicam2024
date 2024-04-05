package Dodam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField idField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginGUI() {
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
                performLogin();
            }
        });

        setVisible(true);
    }

    private void performLogin() {
        String id = idField.getText();
        String pw = new String(passwordField.getPassword());

        // LoginClient 인스턴스 생성 및 로그인 시도
        LoginClient loginClient = new LoginClient();
        loginClient.setId(id);
        loginClient.setPw(pw);
        boolean isSuccess = loginClient.login();

        // 로그인 결과에 따른 처리
        if (isSuccess) {
            JOptionPane.showMessageDialog(this, "로그인 성공!", "성공", JOptionPane.INFORMATION_MESSAGE);
            // 로그인 성공 시 추가 작업 수행
        } else {
            JOptionPane.showMessageDialog(this, "로그인 실패!", "실패", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI();
            }
        });
    }
}
