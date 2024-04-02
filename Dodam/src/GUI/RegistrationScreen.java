package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;

public class RegistrationScreen extends JFrame {
    private JTextField txtUserID, txtUserName, txtEmail, txtMobilePhone;
    private JPasswordField txtPassword;
    private JButton btnRegister;
    private ArrayList<UserInfo> userInfos; // 사용자 정보를 저장할 ArrayList

    public RegistrationScreen(ArrayList<UserInfo> userInfos) {
        this.userInfos = userInfos;
        initializeUI();
    }
    
    public RegistrationScreen() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("회원가입");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        txtUserID = new JTextField();
        txtUserName = new JTextField();
        txtEmail = new JTextField();
        txtMobilePhone = new JTextField();
        txtPassword = new JPasswordField();
        btnRegister = new JButton("회원가입");

        add(new JLabel("User ID:"));
        add(txtUserID);
        add(new JLabel("Username:"));
        add(txtUserName);
        add(new JLabel("Password:"));
        add(txtPassword);
        add(new JLabel("Email:"));
        add(txtEmail);
        add(new JLabel("Mobile Phone:"));
        add(txtMobilePhone);
        add(btnRegister);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UserInfoDAO userInfoDAO = new UserInfoDAO();
                    String userID = txtUserID.getText();
                    if (userInfoDAO.checkUserExists(userID)) {
                        JOptionPane.showMessageDialog(RegistrationScreen.this, "이미 존재하는 UserID입니다. 다른 UserID를 입력해주세요.");
                    } else {
                        UserInfo newUser = createUserInfo();
                        userInfoDAO.insertUser(newUser);
                        JOptionPane.showMessageDialog(RegistrationScreen.this, "회원가입이 완료되었습니다.");
                        dispose();
                        new LoginScreen();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(RegistrationScreen.this, "회원가입 중 오류가 발생했습니다.");
                }
            }
        });

        setVisible(true);
    }

    private UserInfo createUserInfo() {
        String userID = txtUserID.getText();
        String userName = txtUserName.getText();
        String password = new String(txtPassword.getPassword());
        String email = txtEmail.getText();
        String mobilePhone = txtMobilePhone.getText();
        Timestamp signUpTime = new Timestamp(System.currentTimeMillis());

        return new UserInfo(userID, userName, password, email, mobilePhone, signUpTime, "Active");
    }
}
