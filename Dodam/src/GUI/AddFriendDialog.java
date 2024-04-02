package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddFriendDialog extends JDialog {
    private JTextField userIdField;
    private JTextField contactField;
    private JButton addButton;
    private JButton cancelButton;
    private boolean succeeded;

    public AddFriendDialog(Frame parent) {
        super(parent, "친구 추가", true);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        JLabel userIdLabel = new JLabel("친구 ID: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(userIdLabel, cs);

        userIdField = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(userIdField, cs);

        JLabel contactLabel = new JLabel("연락처(핸드폰/이메일): ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(contactLabel, cs);

        contactField = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(contactField, cs);

        addButton = new JButton("추가");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 여기에 친구 추가 로직을 추가
                succeeded = true;
                dispose();
            }
        });
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(addButton, cs);

        cancelButton = new JButton("취소");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cs.gridx = 2;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(cancelButton, cs);

        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    public String getUserId() {
        return userIdField.getText().trim();
    }

    public String getContact() {
        return contactField.getText().trim();
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}
