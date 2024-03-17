package FrameEx;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class ActionEventEx extends Frame implements ActionListener, WindowListener {
	Panel p;
	Button input, exit;
	TextArea ta;

	public ActionEventEx() {
		super("ActionEvent Test");

		p = new Panel();

		input = new Button("input"); // 이벤트 소스
		exit = new Button("exit");
		ta = new TextArea();
		new CloseWindowExample();
		
		input.addActionListener(this); // 이벤트 리스너. this는 내클래스 안에있으므로 기재. 만약 다른 클래스안에 있으면 다른 클래스명적기
		exit.addActionListener(this);

		p.add(input);
		p.add(exit);

		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);

		setBounds(300, 300, 300, 200);
		setVisible(true);

		addWindowListener(this); // 윈도우 이벤트 리스너 등록
	}

	public void windowClosing(ActionEvent ae) {
		// 윈도우를 닫는 코드
		dispose(); // 현재 윈도우를 닫음
		// 또는 setVisible(false);를 사용하여 윈도우를 숨김
	}

	public void windowOpened(ActionEvent ae) {
	}

	public void windowClosing(ActionEvent ae) {
		// 윈도우를 닫는 코드
		dispose(); // 현재 윈도우를 닫음
		// 또는 setVisible(false);를 사용하여 윈도우를 숨김
	}

	public void windowClosed(ActionEvent ae) {
	}

	public void windowIconified(ActionEvent ae) {
	}

	public void windowDeiconified(ActionEvent ae) {
	}

	public void windowActivated(ActionEvent ae) {
	}

	public void windowDeactivated(ActionEvent ae) {
	}

	public void actionPerformed(ActionEvent ae) {
		String name;
		name = ae.getActionCommand(); // name 받아오기

		if (name.equals("input"))
			ta.append("button input.\n");
		else {
			ta.append("exit.\n");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			System.exit(0);
		}
		

	}

	public static void main(String[] args) {
		new ActionEventEx();
	}

}