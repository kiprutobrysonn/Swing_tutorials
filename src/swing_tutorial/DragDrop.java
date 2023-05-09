package swing_tutorial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DragDrop  extends JFrame{
	Point currentPos,prevPt;
	ImageIcon icon  = new ImageIcon("\\swing_tutorial\\src\\20221029_135106.jpg");
	
	JPanel label = new JPanel();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		icon.paintIcon(label, g, label.getX(),label.getY());
	}
	public DragDrop() {
		
		label.setBounds(0,0,100,100);
		label.setBackground(Color.BLACK);
		
		
		
		
		label.setOpaque(false);
		
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					Y= e.getY();
							X=e.getX();
				} else if (SwingUtilities.isLeftMouseButton(e)) {

				}
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

				
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		setSize(400,600);
		setLayout(null);
		add(label);
		setVisible(true);
		
	}
	public static void main(String []args) {
		new DragDrop();
	}

}
