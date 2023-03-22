package swing_tutorial;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TextAreaSearch extends JFrame {

    private JTextArea textArea;
    private JTextField searchField;
    private int lastIndex = -1;

    public TextAreaSearch() {
        super("Text Area Search");

        // Create components
        textArea = new JTextArea();
        searchField = new JTextField();
        JButton searchButton = new JButton("Search");
        JButton findNextButton = new JButton("Find Next");

        // Add components to the frame
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);
        searchPanel.add(findNextButton, BorderLayout.SOUTH);
        add(searchPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Configure the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText();
                String text = textArea.getText();
                lastIndex = text.indexOf(searchText);
                if (lastIndex != -1) {
                    textArea.requestFocusInWindow();
                    textArea.setCaretPosition(lastIndex);
                    textArea.moveCaretPosition(lastIndex + searchText.length());
                } else {
                    JOptionPane.showMessageDialog(TextAreaSearch.this,
                            "Text not found", "Search",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Configure the find next button
        findNextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText();
                String text = textArea.getText();
                int index = text.indexOf(searchText, lastIndex + 1);
                if (index != -1) {
                    textArea.requestFocusInWindow();
                    textArea.setCaretPosition(index);
                    textArea.moveCaretPosition(index + searchText.length());
                    lastIndex = index;
                } else {
                    JOptionPane.showMessageDialog(TextAreaSearch.this,
                            "No more matches found", "Find Next",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Configure the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TextAreaSearch();
    }
}
