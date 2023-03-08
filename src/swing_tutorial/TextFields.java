package swing_tutorial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TextFields  {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Adding text and option dialog boxes
		final JTextField text = new JTextField();
		JButton button = new JButton();
		text.setCaretColor(Color.black);
		text.setSize(1000,20);
		text.setPreferredSize(new Dimension(150,30));
		text.setText("Enter your username");
		
		button.setSize(100,30);
		button.setText("Submit");
		button.setVisible(true);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text.setEditable(false);
				text.setDragEnabled(false);
				JOptionPane.showConfirmDialog(null, "Do want to submit","Submit",JOptionPane.YES_NO_OPTION);
				
			}
			
		});
		
		
		JFrame f1 = new JFrame();
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
		f1.setLayout(new FlowLayout(FlowLayout.CENTER));
		f1.add(text);
		f1.add(button);
		f1.pack();
		
		
		

	}

	

}
