package swing_tutorial;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends JFrame implements KeyListener{
	JLabel box = new JLabel();
	public Game() {
		
		box.setBounds(0,0,30,30);
		box.setBackground(Color.white);
		box.setOpaque(true);		
		
		
		add(box);
		this.addKeyListener(this);
		getContentPane().setBackground(Color.CYAN);
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
