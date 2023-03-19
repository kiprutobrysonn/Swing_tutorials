package swing_tutorial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

	JTextField rightMargin = new JTextField(1);
	JTextField leftMargin = new JTextField(1);
	JTextField bottomMargin = new JTextField(1);
	JTextField toppMargin = new JTextField(1);
	JComboBox pageType;
	Preferences pageMargins;

	public PageSetup() {

		pageMargins = Preferences.userRoot().node(getClass().getName());
		rightMargin.setText(pageMargins.get("rightMargin", "1"));
		leftMargin.setText(pageMargins.get("leftMargin", "1"));
		bottomMargin.setText(pageMargins.get("leftmargin", "1"));
		toppMargin.setText(pageMargins.get("toppMargin", "1"));
		rightMargin.addActionListener(e -> pageMargins.put("rightMargin", rightMargin.getText()));
		leftMargin.addActionListener(e -> pageMargins.put("leftMargin", leftMargin.getText()));
		bottomMargin.addActionListener(e -> pageMargins.put("bottomMargin", bottomMargin.getText()));
		toppMargin.addActionListener(e -> pageMargins.put("toppMargin", toppMargin.getText()));

		// Paper pane
		String[] page = { "Letter 12*10", "A4 32*15", "" };
		pageType = new JComboBox(page);
		JLabel label = new JLabel("Page Size");
		JPanel paperPanel = new JPanel();
		paperPanel.add(label);
		paperPanel.add(pageType);
		paperPanel.setBounds(10, 10, 300, 80);
		// paperPanel.setPreferredSize(new Dimension(400,80));
		paperPanel.setBorder(BorderFactory.createTitledBorder("Paper"));
		paperPanel.setOpaque(false);
		JPanel orientationPanel = new JPanel();

		JRadioButton landScape = new JRadioButton("Landscape");
		JRadioButton portrait = new JRadioButton("Portrait  ");
		ButtonGroup orientation = new ButtonGroup();
		orientation.add(portrait);
		orientation.add(landScape);

		orientationPanel.setBounds(10, 90, 110, 80);
		orientationPanel.setPreferredSize(new Dimension(100, 80));
		orientationPanel.setBorder(BorderFactory.createTitledBorder("Layout"));
		orientationPanel.add(portrait);
		orientationPanel.add(landScape);
		orientationPanel.setOpaque(false);
		JPanel marginPanel = new JPanel();
		marginPanel.setBounds(120, 90, 200, 80);
		marginPanel.setPreferredSize(new Dimension(100, 80));
		marginPanel.setBorder(BorderFactory.createTitledBorder("Margin"));
		marginPanel.setLayout(new GridLayout(4, 4));
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
		applyButton.setBounds(200, 190, 100, 30);
		applyButton.setFocusable(false);
		applyButton.setText("Apply");
		applyButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		applyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				MyNotePad.note.setEnabled(true);
				Insets margin = new Insets(Integer.parseInt(bottomMargin.getText()),
						Integer.parseInt(toppMargin.getText()), Integer.parseInt(leftMargin.getText()),
						Integer.parseInt(rightMargin.getText()));
				MyNotePad.note.getTextArea().setMargin(margin);
			}

		});
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				MyNotePad.note.setEnabled(true);

			}
		});
		applyButton.setBorderPainted(true);
		setLayout(null);
		add(paperPanel);
		add(orientationPanel);
		add(marginPanel);
		add(applyButton);
		setSize(360, 260);
		setResizable(false);
		setVisible(true);
		setTitle("Page Setup");
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		setLocationRelativeTo(null);
	}

}
