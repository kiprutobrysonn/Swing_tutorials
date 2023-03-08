package swing_tutorial;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mybutton extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	// create button and label to ensure there scope is global
	
	JButton button = new JButton();
	JLabel label = new JLabel();
	
	//use the constructor to initialize a frame
	 public Mybutton() {
		
		button.setBounds(100,100,100,50);// sets the size as , start position x,start position y, height and width
		button.setBorder(BorderFactory.createEtchedBorder()); //
		button.setText("OPEN");
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setFont(new Font("MV Boli",Font.BOLD,20));
		button.setVisible(true);
		button.addActionListener(this);
		button.setFocusable(true);
		
		this.add(button);
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(label);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initialize an object of the class
		Mybutton b1= new Mybutton();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// detect if the action performed is on the button
		if(e.getSource()==button) {
			//create a thread to pop-up a new frame within it.
			new Thread() {
				public void run() {
					ImageIcon img =new ImageIcon("C://Users//user//Desktop//edited//ca2.jpg");
			        JLabel label = new JLabel();
			        
			        label.setIcon(img);
			        label.setText("A camera is a device used to take pictures");

			        label.setHorizontalTextPosition(JLabel.CENTER);
			        label.setForeground(Color.cyan);
			        label.setFont(new Font("MV Boli",Font.BOLD,20));
			        label.setIconTextGap(-25);
			        label.setBounds(0,0,750,620);// Since the layout manager is set to null there must be bounds
			        
					JFrame frame = new JFrame();
			        frame.setVisible(true);
			       frame.setSize(750,620);
			        frame.setResizable(false);
			        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        frame.setLayout(null);
			        frame.add(label);
					
				}
			}.start();
			 
			
		}
		
	}

}
