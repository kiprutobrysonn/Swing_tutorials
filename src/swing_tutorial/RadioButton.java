package swing_tutorial;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class RadioButton  extends JFrame implements ActionListener{
	JRadioButton b1 =new JRadioButton("Pizza");
	JRadioButton b2 =new JRadioButton("Pie");
	JRadioButton b3 =new JRadioButton("Apples");
	JRadioButton b4 =new JRadioButton("KFC");
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public RadioButton() {
		ButtonGroup bg= new ButtonGroup();
		bg.add(b1);bg.add(b2);bg.add(b3);bg.add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		this.setTitle("ORDER");
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.pack();
		
		this.setVisible(true);	
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RadioButton rb = new RadioButton();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			JOptionPane.showMessageDialog(null,"You orderd Pizza","Order",JOptionPane.INFORMATION_MESSAGE);
			
			Runtime.getRuntime().exit(DISPOSE_ON_CLOSE);
		}else if(e.getSource()==b2) {
			JOptionPane.showMessageDialog(null,"You ordered Pie","Order",JOptionPane.INFORMATION_MESSAGE);
			Runtime.getRuntime().exit(DISPOSE_ON_CLOSE);
			
		}else if (e.getSource()==b3) {
			JOptionPane.showMessageDialog(null,"You ordered Apples","Order",JOptionPane.INFORMATION_MESSAGE);
			Runtime.getRuntime().exit(DISPOSE_ON_CLOSE);
			
		}else if(e.getSource()==b4) {
			JOptionPane.showMessageDialog(null,"You ordered KFC","Order",JOptionPane.INFORMATION_MESSAGE);
			Runtime.getRuntime().exit(DISPOSE_ON_CLOSE);
			
		}
		
	}

}
