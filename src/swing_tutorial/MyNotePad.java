package swing_tutorial;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyNotePad extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JPanel topPanel = new JPanel();
    private JPanel statusBar = new JPanel();
    private JTextArea textArea = new JTextArea(10, 50);
    private JButton wordCountButton = new JButton("Words: 0");
    private JButton charCountButton = new JButton("Characters: 0");
    private JComboBox fontSizeSelector;


    public MyNotePad() {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

       Integer [] fontSize= {0,1,2,3,4,5,6,7,8,9,10,11,12,14,15,16,17,18,19,20};
       fontSizeSelector = new JComboBox(fontSize);
       fontSizeSelector.getSelectedItem();
       fontSizeSelector.addActionListener(this);


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
        // A menu bar for the file menus and options
        JMenuBar menu = new JMenuBar();

        // File operations menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem newOption = new JMenuItem("New file");
        newOption.addActionListener(this);

        JMenuItem newWindowOption  = new JMenuItem("New Window");
        
        newWindowOption.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		                new MyNotePad();
		            }
		        });
				
			}
        
        });

        JMenuItem openOption = new JMenuItem("Open ");
        openOption.addActionListener(this);


        JMenuItem saveOption = new JMenuItem("Save");
        saveOption.addActionListener(this);


        JMenuItem saveAsOption  = new JMenuItem("Save as");
        saveAsOption.addActionListener(this);


        JMenuItem exitOption = new JMenuItem("Exit");
        exitOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);

			}

        });
        // Editing operations
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        JMenuItem copyOption = new JMenuItem("Copy");
        copyOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.copy();
			}

        });
       // copyOption.setMnemonic(KeyEvent.VK_CUT);
        editMenu.add(copyOption);

        JMenuItem pasteOption = new JMenuItem("Paste");
        pasteOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.paste();
			}
        });
        editMenu.add(pasteOption);

        JMenuItem cutOption = new JMenuItem("Cut");
        cutOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.cut();

			}

        });
        editMenu.add(cutOption);

        JMenuItem selectAllOption = new JMenuItem("Select All");
        selectAllOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.selectAll();
			}
        });
        editMenu.add(selectAllOption);

        JMenuItem deleteOption = new JMenuItem("Delete");
        deleteOption.addActionListener(this);
        editMenu.add(deleteOption);

        //Tools available
        JMenu toolsMenu = new JMenu("Tools");
        toolsMenu.setMnemonic(KeyEvent.VK_T);
        JMenuItem statusBarView = new JMenuItem("View Status Bar");
        statusBarView.addActionListener(this);
        toolsMenu.add(statusBarView);

        JMenuItem settingsOption= new JMenuItem("Settings");
        settingsOption.addActionListener(this);
        toolsMenu.add(settingsOption);

        // Help menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);// Sets the key shortcut to Alt+H
        JMenuItem viewHelp = new JMenuItem("View Help");
        viewHelp.addActionListener(this);
        helpMenu.add(viewHelp);

        JMenuItem aboutOption = new JMenuItem("About ?");
        aboutOption.addActionListener(this);
        helpMenu.add(aboutOption);

        menu.add(fileMenu);
        fileMenu.add(newOption);
        fileMenu.add(newWindowOption);
        fileMenu.add(openOption);
        fileMenu.add(saveOption);
        fileMenu.add(saveAsOption);
        fileMenu.add(exitOption);

        menu.add(editMenu);
        menu.add(toolsMenu);
        menu.add(helpMenu);


        topPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        topPanel.setPreferredSize(new Dimension(100, 30));
        topPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        topPanel.add(fontSizeSelector);


        statusBar.setPreferredSize(new Dimension(100, 30));
        statusBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        statusBar.setBackground(Color.gray);
        statusBar.setOpaque(false);
        statusBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        statusBar.add(wordCountButton);
        statusBar.add(charCountButton);


        setTitle("MyNotePad");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setResizable(true);
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane);
        add(statusBar, BorderLayout.SOUTH);
        setJMenuBar(menu);

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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==fontSizeSelector) {
        textArea.setFont(new Font("NewTimes Roman",Font.PLAIN,((Integer) fontSizeSelector.getSelectedItem()).intValue()));
		}

	}
}
