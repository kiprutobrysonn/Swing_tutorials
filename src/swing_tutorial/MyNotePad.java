package swing_tutorial;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyNotePad extends JFrame {
    private static final long serialVersionUID = 1L;

    private JPanel topPanel = new JPanel();
    private JPanel statusBar = new JPanel();
    private JTextArea textArea = new JTextArea(10, 50);
    private JButton wordCountButton = new JButton("Words: 0");
    private JButton charCountButton = new JButton("Characters: 0");

    public MyNotePad() {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        wordCountButton.setEnabled(false);
        wordCountButton.setBorder(BorderFactory.createEmptyBorder(1,1,0,0));

        charCountButton.setEnabled(false);
        charCountButton.setBorder(BorderFactory.createEmptyBorder(1,1,0,0));

        textArea.setAutoscrolls(true);
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateWordAndCharCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateWordAndCharCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateWordAndCharCount();
            }
        });

        JButton fileButton = new JButton("Files");
        fileButton.setBorder(BorderFactory.createEmptyBorder());
        fileButton.setBackground(Color.white);
        JButton viewButton = new JButton("Views");
        viewButton.setBorder(BorderFactory.createEmptyBorder());
        viewButton.setBackground(Color.white);
        JButton toolsButton = new JButton("Tools");
        toolsButton.setBackground(Color.white);
        toolsButton.setBorder(BorderFactory.createEmptyBorder());
        JButton helpButton = new JButton("Help");
        helpButton.setBackground(Color.white);
        helpButton.setBorder(BorderFactory.createEmptyBorder());

        topPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        topPanel.setPreferredSize(new Dimension(100, 30));
        topPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        topPanel.add(fileButton);
        topPanel.add(viewButton);
        topPanel.add(toolsButton);
        topPanel.add(helpButton);

        statusBar.setPreferredSize(new Dimension(100, 30));
        statusBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        statusBar.setBackground(Color.gray);
        statusBar.setOpaque(false);
        statusBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        statusBar.add(wordCountButton);
        statusBar.add(charCountButton);

        setTitle("MyNotePad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane);
        add(statusBar, BorderLayout.SOUTH);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateWordAndCharCount() {
        String textWritten = textArea.getText();
        if (textWritten == null || textWritten.isEmpty()) {
            wordCountButton.setText("Words: 0");
            charCountButton.setText("Characters: 0");
        } else {
            StringTokenizer tokens = new StringTokenizer(textWritten);
            int wordCount = tokens.countTokens();
            int charCount = textWritten.length();
            wordCountButton.setText("Words: " + wordCount);
            charCountButton.setText("Characters: " + charCount);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyNotePad();
            }
        });
    }
}
