package aes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AesAlthUI extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;
    private JButton encryptButton;
    private JButton decryptButton;
    private byte[] key = "ThanhTien1732300".getBytes(); // key 16 bit

    public AesAlthUI() {
        setTitle("AES Mã Hóa && Giải mã");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputField = new JTextField();
        outputArea = new JTextArea();
        encryptButton = new JButton("Mã Hóa");
        decryptButton = new JButton("Giải mã");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(new JLabel("Input:"));
        panel.add(inputField);
        panel.add(encryptButton);
        panel.add(decryptButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plaintext = inputField.getText();
                if (!plaintext.isEmpty()) {
                    String encryptedText = AesAlth.encryptToString(plaintext.getBytes(), key);
                    outputArea.setText(encryptedText);
                }
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String encryptedText = inputField.getText();
                if (!encryptedText.isEmpty()) {
                    byte[] decryptedBytes = AesAlth.decryptFromString(encryptedText, key);
                    outputArea.setText(new String(decryptedBytes));
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AesAlthUI().setVisible(true);
            }
        });
    }
}