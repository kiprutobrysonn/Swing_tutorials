package swing_tutorial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class javaForms extends JFrame implements ActionListener{
	private JButton submitButton,clearButton;
	private JTextField usernameField;
	private JPasswordField  password;
	private JLabel userNameLabel,passwordFieldLabel;
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submitButton) {
			JOptionPane.showMessageDialog(null, "  WELCOME"+usernameField.getText());
			usernameField.setText(null);
			password.setText(null);
		}else if(e.getSource()==clearButton) {
			usernameField.setText(null);
			password.setText(null);
		}
		
	}
	
	public javaForms () {
		     
		     // Username fields
		
		usernameField = new JTextField();
		userNameLabel = new JLabel("Username:");
	    userNameLabel.setBounds(20,20, 80,30);   
		 usernameField.setBounds(100,20, 100,30);
		     
		 
		   //Password fields
		 password = new JPasswordField();       
		 password.setBounds(100,75, 100,30);
		 passwordFieldLabel= new JLabel("Password");
		 passwordFieldLabel.setBounds(20,75, 80,30);
		     
		       
		        
		        // Login s and clear  buttons
		 submitButton = new JButton("Login");
		 submitButton.setBounds(100,120, 80,30);
		 submitButton.addActionListener(this);
		 clearButton= new JButton("Clear ");
		 clearButton.setBounds(190,120,80,30);
		 clearButton.addActionListener(this);
	
		 // initialize the JFrame with components and properties
		this.add(userNameLabel);
		this.add(usernameField);
		this.add(passwordFieldLabel);
		this.add(password);
		this.add(submitButton);
		this.add(clearButton);
		this.setSize(300,300);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);//sets the location that the Jframe appears
		this.setResizable(false);
		this.setVisible(true);
	}
	public static void main (String[]args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				javaForms form1 = new javaForms();
			}
			
		});
		
	}
	
	
}
