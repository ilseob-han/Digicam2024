package FrameMaking;


import java.awt.*;

public class AdapteExamWithNoInnerClass extends Frame {
    private TextArea textArea;
    private TextField textField;

    public AdapteExamWithNoInnerClass() {
        setTitle("Main Frame");
        setSize(400, 300);
        setLocationRelativeTo(null); // 화면 중앙에 표시

        // 텍스트 필드 생성
        textField = new TextField(20);

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
        clearButton.addActionListener(new ClearButtonListener());

        // Exit 버튼 생성 및 ActionListener 추가
        Button exitButton = new Button("Exit");
        exitButton.addActionListener(new ExitButtonListener());

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

        // 윈도우 리스너 추가
        addWindowListener(new WindowEventHandler());
    }

    // Clear 버튼 리스너 클래스
    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText(""); // 텍스트 영역 내용 삭제
        }
    }

    // Exit 버튼 리스너 클래스
    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose(); // 프레임 닫기
        }
    }

    // 윈도우 이벤트 핸들러 클래스
    private class WindowEventHandler extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            dispose(); // 프레임 닫기
        }
    }

    public static void main(String[] args) {
        AdapteExamWithNoInnerClass frame = new AdapteExamWithNoInnerClass();
        frame.setVisible(true); // 프레임 표시
    }
}