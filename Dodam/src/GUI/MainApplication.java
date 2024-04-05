package GUI;


import javax.swing.SwingUtilities;

public class MainApplication {
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            LoginScreen loginScreen = new LoginScreen(); // LoginScreen 인스턴스 생성
	            loginScreen.setVisible(true); // 화면에 로그인 창을 표시
	        }
	    });
	}

}