package swing_tutorial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.prefs.Preferences;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PageSetup extends JFrame {

	
	JTextField rightMargin = new JTextField();
	JTextField leftMargin = new JTextField();
	JTextField bottomMargin = new JTextField();
	JTextField toppMargin = new JTextField();
	JComboBox pageType;
	Preferences pageMargins;
	public PageSetup() {
		
		pageMargins= Preferences.userRoot().node(getClass().getName());
		rightMargin.setText(pageMargins.get("rightMargin", "1"));
		leftMargin.setText(pageMargins.get("lastinput", "1"));
		bottomMargin.setText(pageMargins.get("lastinput", "1"));
		toppMargin.setText(pageMargins.get("lastinput", "1"));
		
		rightMargin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String input = rightMargin.getText();
		        pageMargins.put("lastinput", input);
				
			}
			
		});
		leftMargin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String input = leftMargin.getText();
		        pageMargins.put("lastinput", input);
				
			}
			
		});
		bottomMargin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String input = bottomMargin.getText();
		        pageMargins.put("lastinput", input);
				
			}
			
		});
		toppMargin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String input = toppMargin.getText();
		        pageMargins.put("lastinput", input);
				
			}
			
		});
		
		//Paper pane
		String [] page = {"Letter 12*10","A4 32*15",""};
		 pageType=new JComboBox(page);
		 JLabel label = new JLabel("Page Size");
		JPanel paperPanel = new JPanel();
		paperPanel.add(label);
		paperPanel.add(pageType);
		paperPanel.setBounds(10,10,300,80);
		//paperPanel.setPreferredSize(new Dimension(400,80));
		paperPanel.setBorder(BorderFactory.createTitledBorder("Paper"));
		paperPanel.setOpaque(false);
		JPanel orientationPanel = new JPanel();
		
		JRadioButton landScape =new JRadioButton("Landscape");
		JRadioButton portrait= new JRadioButton("Portrait  ");
		ButtonGroup orientation = new ButtonGroup();
		orientation.add(portrait);
		orientation.add(landScape);
		
		
		orientationPanel.setBounds(10,90,110,80);
		orientationPanel.setPreferredSize(new Dimension(100,80));
		orientationPanel.setBorder(BorderFactory.createTitledBorder("Layout"));
		orientationPanel.add(portrait);
		orientationPanel.add(landScape);
		orientationPanel.setOpaque(false);
		JPanel marginPanel = new JPanel();
		marginPanel.setBounds(120,90,200,80);
		marginPanel.setPreferredSize(new Dimension(100,80));
		marginPanel.setBorder(BorderFactory.createTitledBorder("Margin"));
		marginPanel.setLayout(new GridLayout(4,4));
		marginPanel.setBackground(Color.WHITE);
		marginPanel.setOpaque(false);
		JLabel rightLabel = new JLabel("right:");
		JLabel leftLabel = new JLabel("left:");
		JLabel topLabel = new JLabel("top:");
		JLabel bottomLabel = new JLabel("bottom:");
		rightLabel.setLabelFor(rightLabel);
		
		
		marginPanel.add(rightLabel);
		marginPanel.add(rightMargin);		
		marginPanel.add(leftLabel);
		marginPanel.add(leftMargin);
		marginPanel.add(topLabel);
		marginPanel.add(toppMargin);
		marginPanel.add(bottomLabel);
		marginPanel.add(bottomMargin);
		
		JButton applyButton = new JButton();
		applyButton.setBounds(200,190, 100, 30);
		applyButton.setText("Apply");
		applyButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		applyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				MyNotePad.note.setEnabled(true);
				
				
			
			}
			
		});
		applyButton.setBorderPainted(false);
		
		
		setLayout(null);
		add(paperPanel);
		add(orientationPanel);
		add(marginPanel);
		add(applyButton);
		setSize(360,260);
		setResizable(false);
		setVisible(true);
		setTitle("Page Setup");
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		setLocationRelativeTo(null);
	}
	public static void main(String []args) {
			
	}

}
