package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginScreen extends JFrame {
    private JTextField txtUserId;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnGoToRegister;
    private UserInfoDAO userInfoDAO; // UserInfoDAO 객체 선언

    public LoginScreen() {
        userInfoDAO = new UserInfoDAO(); // UserInfoDAO 객체 초기화
        initializeUI();
    }

    private void initializeUI() {
        setTitle("로그인");
        setSize(500, 1300); // 화면 크기 조정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
        txtPassword = new JPasswordField("비밀번호");
        txtUserId = new JTextField("아이디");

        btnLogin = new JButton("로그인");
        btnGoToRegister = new JButton("회원가입으로 이동");

        // 텍스트 필드 포커스 리스너 추가
        txtUserId.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUserId.getText().equals("아이디")) {
                    txtUserId.setText("");
                }
            }
        });

        txtPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(txtPassword.getPassword()).equals("비밀번호")) {
                    txtPassword.setText("");
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        btnGoToRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToRegistration();
            }
        });

        add(txtUserId);
        add(txtPassword);
        add(btnLogin);
        add(btnGoToRegister);

        setVisible(true);
    }

    private void performLogin() {
        String userId = txtUserId.getText();
        String password = new String(txtPassword.getPassword());

        if (authenticateUser(userId, password)) {
            JOptionPane.showMessageDialog(this, "로그인 성공!");
            this.dispose(); // 로그인 창을 닫습니다.
            new MainScreen(userId).setVisible(true); // 로그인한 사용자 ID를 MainScreen에 전달합니다.
        } else {
            JOptionPane.showMessageDialog(this, "로그인 실패. 아이디 또는 비밀번호를 확인해주세요.");
        }
    }

    private boolean authenticateUser(String userId, String password) {
        String query = "SELECT * FROM users WHERE userID = ? AND password = ?";
        try (Connection connection = userInfoDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void goToRegistration() {
        new RegistrationScreen(); // userInfos 전달 부분 제거
        dispose();
    }
}
