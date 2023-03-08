package swing_tutorial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panels{// panels that have borders an aligned

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPanel topPanel = new JPanel();
		
		JButton fileButton = new JButton();
		topPanel.setLayout(null);
		fileButton.setText("Files");
		fileButton.setBounds(0,0,100,20);
		fileButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		fileButton.setBackground(Color.white);
		
		JButton viewButton = new JButton();
		viewButton.setText("Views");
		viewButton.setBounds(100,0,100,20);
		viewButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		viewButton.setBackground(Color.white);
		
		
		JButton toolsButton = new JButton();
		toolsButton.setText("Tools");
		toolsButton.setBounds(200,0,100,20);
		toolsButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		toolsButton.setBackground(Color.white);
		
		JButton helpButton = new JButton();
		helpButton.setText("Help");
		helpButton.setBounds(300,0,100,20);
		helpButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		helpButton.setBackground(Color.white);
	
		topPanel.setPreferredSize(new Dimension(100,50));
		topPanel.add(fileButton);
		topPanel.add(viewButton);
		topPanel.add(toolsButton);
		topPanel.add(helpButton);
		
		JFrame frame= new JFrame();
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLayout(new BorderLayout());
		frame.add(topPanel,BorderLayout.NORTH);
		
		
		

	}

}
