package swing_tutorial;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider implements ChangeListener {
	
	JFrame frame;
	JPanel panel;
	JSlider slider;
	
	public Slider() {
		frame= new JFrame();
		panel = new JPanel();
		slider = new JSlider(0,100,14);
		
		
		
		slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);  
		slider.setMinorTickSpacing(2);  
		slider.setMajorTickSpacing(10);  
		slider.setPaintTicks(true);  
		slider.setPaintLabels(true);
		panel.add(slider);
		frame.add(panel);
		
		
		frame.setVisible(true);
		frame.pack();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Slider sli = new Slider();

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

}
