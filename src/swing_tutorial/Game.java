package swing_tutorial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame implements KeyListener{
	JPanel box = new JPanel();
	ImageIcon icon ;
	public Game() {
		
		box.setBounds(0,0,50,50);
		box.setBackground(Color.black);
				
		icon = new ImageIcon("C:\\Users\\user\\Desktop\\rocket.jpg");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(box.getWidth(), box.getHeight(), Image.SCALE_SMOOTH); // Scale the Image to fit the label
		ImageIcon newIcon = new ImageIcon(newImg); // Create a new ImageIcon with the scaled Image
		

		add(box);
		this.addKeyListener(this);
		getContentPane().setBackground(Color.BLACK);
		setSize(400,600);
		setLayout(null);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game g1 = new Game();
		

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.print(e.getKeyCode());
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case 38:
			box.setLocation(box.getX(), box.getY()-10);
			break;
		case 39:
			box.setLocation(box.getX()+10, box.getY());
			break;
		case 37:
			box.setLocation(box.getX()-10, box.getY()-10);
			break;
		case 40:
			box.setLocation(box.getX(), box.getY()+10);
			break;
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
