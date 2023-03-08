package swing_tutorial;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CAPTCHA extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Create  a global submit and checkbox
	
	JButton submit = new JButton("Submit");
	//Checkboxes are to select the pictures
	JCheckBox box1 = new JCheckBox();
	JCheckBox box2 = new JCheckBox();
	JCheckBox box3 = new JCheckBox();
	JCheckBox box4 = new JCheckBox();
	
	//Use the constructor to initialize Frame and its components
	public CAPTCHA(String a) {
		
		box1.setBounds(0,0,30,30);
		
		box2.setBounds(0,0,30,30);
		
		box3.setBounds(0,0,30,30);
		
		box4.setBounds(0,0,30,30);
		
		submit.setSize(150,50);
		submit.setBounds(150, 400, 100, 50);
		submit.addActionListener(this);;
		
		
		
		ImageIcon img1= new ImageIcon("C://Users//user//Desktop//workspace//swing_tutorial//src//cap1.jpg");
		ImageIcon img2= new ImageIcon("C://Users//user//Desktop//workspace//swing_tutorial//src//cap2.jpg");
		ImageIcon img3= new ImageIcon("C://Users//user//Desktop//workspace//swing_tutorial//src//cap3.jpg");
		ImageIcon img4= new ImageIcon("C://Users//user//Desktop//workspace//swing_tutorial//src//cap4.jpg");
		
		JLabel l1= new JLabel();
		l1.setIcon(img1);
		l1.add(box1);
		l1.setBounds(0,0,200,200);
		
		JLabel l2= new JLabel();
		l2.setIcon(img2);
		l2.add(box2);
		l2.setBounds(200,0,200,200);
		
		JLabel l3= new JLabel();
		l3.setIcon(img3);
		l3.add(box3);
		l3.setBounds(0,200,200,200);
		
		JLabel l4= new JLabel();
		l4.setIcon(img4);
		l4.add(box4);
		l4.setBounds(200,200,200,200);
		
		this.setSize(400,480);
		this.setTitle(a);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.setBackground(Color.gray);
		this.setVisible(true);
		this.add(l1);
		this.add(l2);
		this.add(l3);
		this.add(l4);
		this.add(submit);
		
	}
	 static  void Interact (){
		 int opt =JOptionPane.showConfirmDialog(null,"Are you a robot?","CAPTCHA", JOptionPane.YES_NO_OPTION);
			if(opt==0) {
				JOptionPane.showMessageDialog(null,"Application EXIT","EXIT",JOptionPane.ERROR_MESSAGE);
				Interact();
				
			}else if (opt==1) {
				JOptionPane.showMessageDialog(null,"Select the pictures of houses with chimneys");
				CAPTCHA c1= new CAPTCHA("CAPTCHA");
			}else {
				
			Runtime.getRuntime().exit(DISPOSE_ON_CLOSE);
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interact();
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit) {
			if(box1.isSelected()&box3.isSelected()&box4.isSelected()||box4.isSelected()&box3.isSelected()&box1.isSelected()||box1.isSelected()&box4.isSelected()&box3.isSelected()||
					box3.isSelected()&box1.isSelected()&box4.isSelected()) {
				JOptionPane.showMessageDialog(null,"Confrimed continue");
				Runtime.getRuntime().exit(EXIT_ON_CLOSE);
			}else if(box1.isSelected()&box3.isSelected()&box4.isSelected()){
				JOptionPane.showMessageDialog(null,"Invalid Try again","TRY AGAIN",JOptionPane.WARNING_MESSAGE);
			}else if(box1.isSelected()&box2.isSelected()&box4.isSelected()) {
				
			
				JOptionPane.showMessageDialog(null,"Invalid Try again","TRY AGAIN",JOptionPane.WARNING_MESSAGE);
				
			}else if(box1.isSelected()&box3.isSelected()) {
				JOptionPane.showMessageDialog(null,"Invalid Try again","TRY AGAIN",JOptionPane.WARNING_MESSAGE);
				
			}else {
				JOptionPane.showMessageDialog(null,"Invalid Try again","TRY AGAIN",JOptionPane.WARNING_MESSAGE);
			}
		}
	}

}
