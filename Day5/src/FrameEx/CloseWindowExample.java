package FrameEx;

import java.awt.*;
import java.awt.event.*;

public class CloseWindowExample extends Frame implements WindowListener {
    
    public CloseWindowExample() {
        super("Close Window Example");
        addWindowListener(this); // 윈도우 이벤트 리스너 등록
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CloseWindowExample();
    }

    // WindowListener 인터페이스의 메서드 구현
    public void windowOpened(WindowEvent e) {}

    public void windowClosing(WindowEvent e) {
        // 윈도우를 닫는 코드
        dispose(); // 현재 윈도우를 닫음
        // 또는 setVisible(false);를 사용하여 윈도우를 숨김
    }

    public void windowClosed(WindowEvent e) {}

    public void windowIconified(WindowEvent e) {}

    public void windowDeiconified(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}
}