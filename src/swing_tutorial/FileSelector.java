package swing_tutorial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileSelector extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFileChooser fileChooser= new JFileChooser();


	public FileSelector() {
		
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (Exception e1) { } 
		
		final JTextArea ta = new JTextArea(20,20);
		JMenuItem openFile = new JMenuItem("Open File");
		openFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				   
				int n =fileChooser.showOpenDialog(null);
				FileNameExtensionFilter ft ;
				if(n==JFileChooser.APPROVE_OPTION) {
					
					
					try {
						File newfile = new File(fileChooser.getSelectedFile().getAbsolutePath());
						BufferedReader b = new BufferedReader(new FileReader(newfile));
						   String s1="",s2="";                         
					        while((s1=b.readLine())!=null){    
					        s2+=s1+"\n";    
					        }    
					        ta.setText(s2);    
					        b.close(); 
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Error file not found", "File not Found", JOptionPane.ERROR_MESSAGE);
						
					}
					
				}
				
				
			}
			
		});
		JMenuItem saveFile = new JMenuItem("Save");
		saveFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n=fileChooser.showSaveDialog(null);
				if(n==JFileChooser.APPROVE_OPTION) {
					File  fileSave = new File(fileChooser.getSelectedFile().getAbsolutePath());
					boolean result;  
					try   
					{  
					result = fileSave.createNewFile();  //creates a new file  
					if(result)      // test if successfully created a new file  
					{  
					 JOptionPane.showMessageDialog(null,"File Save Succesfully", "Saved",JOptionPane.INFORMATION_MESSAGE);//returns the path string  
					 PrintWriter writerToSaved = new PrintWriter(fileSave);
					 writerToSaved.write(ta.getText());
					}  
					else  
					{  
					JOptionPane.showMessageDialog(null,"File Already Exists");
					}  
					}   
					catch (IOException e2)   
					{  
					//PrintWriter writeToSave = 
				}
				}
				
				
			}
			
		});
		
		JMenu file = new JMenu("File");
		file.add(openFile);
		file.add(saveFile);
		
		JMenuBar menu = new JMenuBar();
		menu.add(file);
		menu.setBounds(0, 0,100 ,50);
		
		
		
		
		setJMenuBar(menu);
		add(ta);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new FileSelector();
				
			}
			
		});

	}

}
