package FrameMaking;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdapterExam extends Frame {
	private TextArea textArea;

	public AdapterExam() {
		setTitle("Adapter Exam");
		setSize(400, 300);
		// setLocationRelativeTo(null); // 화면 중앙에 표시

		// 텍스트 필드 생성
		TextField textField = new TextField(20);

		// 텍스트 영역 생성
		textArea = new TextArea(10, 20);
		textArea.setEditable(false); // 텍스트 영역 편집 금지

		// 레이아웃 설정
		setLayout(new BorderLayout());

		// 컴포넌트 추가
		add(textField, BorderLayout.NORTH); // 텍스트 필드는 프레임의 상단에 배치
		add(textArea, BorderLayout.CENTER); // 텍스트 영역은 프레임의 중앙에 배치

		// Clear 버튼 생성 및 ActionListener 추가
		Button clearButton = new Button("Clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText(""); // 텍스트 영역 내용 삭제
			}
		});

		// Exit 버튼 생성 및 ActionListener 추가
		Button exitButton = new Button("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // 프레임 닫기
			}
		});

		// 버튼 패널 생성 및 버튼 추가
		Panel buttonPanel = new Panel(new FlowLayout());
		buttonPanel.add(clearButton);
		buttonPanel.add(exitButton);

		// 버튼 패널 프레임의 하단에 배치
		add(buttonPanel, BorderLayout.SOUTH);

		// 텍스트 필드에 ActionListener 추가
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 텍스트 필드에서 엔터를 입력하면 이벤트가 발생하여 여기서 처리
				String text = textField.getText(); // 텍스트 필드의 내용 가져오기
				textArea.append(text + "\n"); // 텍스트 영역에 추가
				textField.setText(""); // 텍스트 필드 초기화
			}
		});

		// 윈도우 리스너 구현
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose(); // 프레임 닫기
			}
		});
	}

	public static void main(String[] args) {
		AdapterExam frame = new AdapterExam();
		frame.setVisible(true); // 프레임 표시
	}
}