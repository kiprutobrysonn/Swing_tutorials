package swing_tutorial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyNotePad extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel statusBar = new JPanel();
	private JTextArea textArea = new JTextArea(10, 50);
	private JButton wordCountButton = new JButton("Words: 0");
	private JButton charCountButton = new JButton("Characters: 0");
	private File selectedFile, fileSave;
	private JFileChooser fileSelector = new JFileChooser();
	static MyNotePad note;
	private int lastIndex = -1;

	public MyNotePad() {
		setTitle("Untitled");

		JScrollPane scrollPane = new JScrollPane(getTextArea());

		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		wordCountButton.setEnabled(false);
		wordCountButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 0, 0));

		charCountButton.setEnabled(false);
		charCountButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 0, 0));

		getTextArea().setAutoscrolls(true);
		getTextArea().setLineWrap(true);
		getTextArea().setWrapStyleWord(true);
		getTextArea().getDocument().addDocumentListener(new DocumentListener() {
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

		JMenuItem newWindowOption = new JMenuItem("New Window");
		newWindowOption.setAccelerator(KeyStroke.getKeyStroke("control N"));
		AbstractAction newWindow = new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				new MyNotePad().setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}

		};
		newWindowOption.addActionListener(newWindow);
		fileSelector.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileSelector.setFileSelectionMode(JFileChooser.FILES_ONLY);

		fileSelector.addChoosableFileFilter(new FileNameExtensionFilter("Text Documents", "txt"));
		fileSelector.setAcceptAllFileFilterUsed(true);

		JMenuItem openOption = new JMenuItem("Open ");
		openOption.setAccelerator(KeyStroke.getKeyStroke("control O"));
		AbstractAction openAction = new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openFile();
			}
		};
		openOption.addActionListener(openAction);

		JMenuItem saveOption = new JMenuItem("Save");
		saveOption.setAccelerator(KeyStroke.getKeyStroke("control S"));
		AbstractAction saveAction = new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveFile();
			}
		};
		saveOption.addActionListener(saveAction);

		JMenuItem saveAsOption = new JMenuItem("Save as ...");
		saveAsOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n = fileSelector.showSaveDialog(null);
				if (n == JFileChooser.APPROVE_OPTION) {
					File fileSave = new File(fileSelector.getSelectedFile().getAbsolutePath());
					boolean result;
					try {
						result = fileSave.createNewFile(); // creates a new file
						if (result) // test if successfully created a new file
						{
							JOptionPane.showMessageDialog(null, "File Save Successfully", "Saved",
									JOptionPane.INFORMATION_MESSAGE);// returns the path string
							PrintWriter writerToSaved = new PrintWriter(fileSave);
							writerToSaved.write(getTextArea().getText());
							writerToSaved.close();
							setTitle(fileSave.getName());
							selectedFile = fileSave;
						} else {
							JOptionPane.showMessageDialog(null, "File Already Exists");

						}
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}

			}

		});

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
		copyOption.setAccelerator(KeyStroke.getKeyStroke("control C"));
		AbstractAction copyAction = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getTextArea().copy();
				
			}
		};
		copyOption.addActionListener(copyAction);
		
		// copyOption.setMnemonic(KeyEvent.VK_CUT);
		editMenu.add(copyOption);

		JMenuItem pasteOption = new JMenuItem("Paste");
		pasteOption.setAccelerator(KeyStroke.getKeyStroke("control V"));
		AbstractAction pasteAction = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getTextArea().paste();
			}
		};
		pasteOption.addActionListener(pasteAction);
		editMenu.add(pasteOption);

		JMenuItem cutOption = new JMenuItem("Cut");
		cutOption.setAccelerator(KeyStroke.getKeyStroke("control X"));
		AbstractAction cutAction = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getTextArea().cut();
			}
		};
		cutOption.addActionListener(cutAction);
		editMenu.add(cutOption);

		JMenuItem selectAllOption = new JMenuItem("Select All");
		selectAllOption.setAccelerator(KeyStroke.getKeyStroke("control A"));
		AbstractAction selectAction = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getTextArea().selectAll();
				
			}
		};
		selectAllOption.addActionListener(selectAction);
		editMenu.add(selectAllOption);

		JMenuItem deleteOption = new JMenuItem("Delete");
		deleteOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getTextArea().setText(null);
			}

		});
		editMenu.add(deleteOption);

		// Tools available
		JMenu toolsMenu = new JMenu("Tools");
		toolsMenu.setMnemonic(KeyEvent.VK_T);
		JMenuItem statusBarView = new JMenuItem("View Status Bar");
		statusBarView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (statusBar.isVisible()) {
					statusBar.setVisible(false);
				} else {
					statusBar.setVisible(true);
				}
			}

		});
		toolsMenu.add(statusBarView);

		JMenuItem settingsOption = new JMenuItem("Settings");
		settingsOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyNotePad.note.setEnabled(false);
				PageSetup layout = new PageSetup();

				layout.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			}
		});
		toolsMenu.add(settingsOption);
		//Find menu Item
		JMenuItem findOption = new JMenuItem("Find");
		toolsMenu.add(findOption);
		findOption.setAccelerator(KeyStroke.getKeyStroke("control F"));
		AbstractAction findAction = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Thread() {
					public void run() {
						
					}
				}.start();
				JFrame find = new JFrame("Find");
				find.setSize(300,150);
				find.setResizable(false);
				find.setLayout(null);
				
				JTextField searchField = new JTextField();
				searchField.setBounds(110,20,80,30);
				JLabel label = new JLabel("Find:");
				label.setBounds(20,20,80,30);
				JButton findButton = new JButton("Find");
				findButton.setBounds(210,80,80,30);
				findButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						 String searchText = searchField.getText();
			                String text = textArea.getText();
			                lastIndex = text.indexOf(searchText);
			                if (lastIndex != -1) {
			                    textArea.requestFocusInWindow();
			                    textArea.setCaretPosition(lastIndex);
			                    textArea.moveCaretPosition(lastIndex + searchText.length());
			                } else {
			                    JOptionPane.showMessageDialog(null,
			                            "Text not found", "Search",
			                            JOptionPane.INFORMATION_MESSAGE);
			                }
			            }
						
					
					
				});
				JButton findNext = new JButton ("Find next");
				findNext.setBounds(120,80,90,30);
				
				find.add(searchField);
				find.add(label);
				find.add(findButton);
				find.add(findNext);
				find.setVisible(true);
				
			}
		};
		findOption.addActionListener(findAction);
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

		statusBar.setPreferredSize(new Dimension(100, 30));
		statusBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		statusBar.setBackground(Color.gray);
		statusBar.setOpaque(false);
		statusBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		statusBar.add(wordCountButton);
		statusBar.add(charCountButton);

		// setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(true);
		setLayout(new BorderLayout());
		add(scrollPane);
		add(statusBar, BorderLayout.SOUTH);
		setJMenuBar(menu);
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		setSize(500, 500);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (textArea.getText() == null || textArea.getText() == "") {
					System.exit(0);
				} else {
					int option = JOptionPane.showConfirmDialog(null, "Do you want to exit", "Exit",
							JOptionPane.YES_NO_CANCEL_OPTION);
					if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.NO_OPTION) {
						setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					} else {
						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					}
				}

			}
		});
		setVisible(true);

	}

	private void saveFile() {
		if (selectedFile == null) {
			int n = fileSelector.showSaveDialog(null);
			if (n == JFileChooser.APPROVE_OPTION) {
				fileSave = new File(fileSelector.getSelectedFile().getAbsolutePath());
				boolean result;
				try {
					result = fileSave.createNewFile(); // creates a new file
					if (result) // test if successfully created a new file
					{
						JOptionPane.showMessageDialog(null, "File Save Successfully", "Saved",
								JOptionPane.INFORMATION_MESSAGE);// returns the path string
						PrintWriter writerToSaved = new PrintWriter(fileSave);
						writerToSaved.write(getTextArea().getText());
						writerToSaved.close();
						selectedFile = fileSave;
						setTitle(fileSave.getName());
					} else {
						JOptionPane.showMessageDialog(null, "File Already Exists");
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		} else {
			PrintWriter writerToSaved;
			try {
				writerToSaved = new PrintWriter(fileSave);
				writerToSaved.write(getTextArea().getText());
				writerToSaved.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void openFile() {
		int n = fileSelector.showOpenDialog(null);
		if (n == JFileChooser.APPROVE_OPTION) {

			selectedFile = fileSelector.getSelectedFile();

			try {
				BufferedReader b = new BufferedReader(new FileReader(selectedFile));
				String s1 = "", s2 = "";
				while ((s1 = b.readLine()) != null) {
					s2 += s1 + "\n";
				}
				getTextArea().setText(s2);
				b.close();
				setTitle(selectedFile.getName());
				fileSave = selectedFile;
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Error file not found", "File not Found",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private void updateWordAndCharCount() {
		String textWritten = getTextArea().getText();
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

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public static void main(String[] args) {
		try {
			// Set the look and feel to the system's most recent available
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				note = new MyNotePad();

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
