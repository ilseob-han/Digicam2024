package GUI;


import javax.swing.SwingUtilities;

public class MainApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginScreen loginScreen = new LoginScreen(); // LoginScreen 인스턴스 생성
//                loginScreen.addDummyUsers(); // 더미 사용자 데이터를 데이터베이스에 추가
            }
        });
    }
}