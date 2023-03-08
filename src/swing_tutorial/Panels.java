package swing_tutorial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import javax.swing.border.BevelBorder;

public class Panels{// panels that have borders an aligned

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPanel topPanel = new JPanel();
		JTextArea text = new JTextArea(800,800);
		
		text.setAutoscrolls(true);
		
		JButton fileButton = new JButton();
		// use of flow layout to place buttons in a application
		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		fileButton.setText("Files");
		fileButton.setBorder(BorderFactory.createEmptyBorder());
		fileButton.setBackground(Color.white);
		
		JButton viewButton = new JButton();
		viewButton.setText("Views");
		viewButton.setBorder(BorderFactory.createEmptyBorder());
		viewButton.setBackground(Color.white);
		
		
		JButton toolsButton = new JButton();
		toolsButton.setText("Tools");
		toolsButton.setBorder(BorderFactory.createEmptyBorder());
		toolsButton.setBackground(Color.white);
		
		JButton helpButton = new JButton();
		helpButton.setText("Help");
		helpButton.setBorder(BorderFactory.createEmptyBorder());
		helpButton.setBackground(Color.white);
	
		topPanel.setPreferredSize(new Dimension(100,30));
		topPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		topPanel.add(fileButton);
		topPanel.add(viewButton);
		topPanel.add(toolsButton);
		topPanel.add(helpButton);
		
		JFrame frame= new JFrame("MyNotePad");
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		//Border layout to place sections 
		frame.setLayout(new BorderLayout());
		frame.add(topPanel,BorderLayout.NORTH);
		frame.setVisible(true);
		frame.add(text);
		
		
		

	}

}
