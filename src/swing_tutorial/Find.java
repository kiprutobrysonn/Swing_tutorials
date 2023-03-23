package swing_tutorial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Find extends JFrame {
	
	public Find() {
		setSize(300,150);
		setResizable(false);
		setLayout(null);
		
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

	            }			
		});
		JButton findNext = new JButton ("Find next");
		findNext.setBounds(120,80,90,30);
		
		add(searchField);
		add(label);
		add(findButton);
		add(findNext);
		
		
		
	}
public static void main(String [] args) {
	new Find().setVisible(true);
}

}
