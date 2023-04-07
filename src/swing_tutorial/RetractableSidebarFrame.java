package swing_tutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RetractableSidebarFrame extends JFrame {
    
    private JPanel sidebar;
    private JPanel contentPanel;
    private JButton toggleButton;
    
    public RetractableSidebarFrame() {
        super("Retractable Sidebar Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create the sidebar
        sidebar = new JPanel();
        sidebar.setBackground(Color.LIGHT_GRAY);
        sidebar.setPreferredSize(new Dimension(150, getHeight()));
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        sidebar.add(button1);
        sidebar.add(button2);
        sidebar.add(button3);
        
        // Create the main content panel
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        JLabel label = new JLabel("This is the main content");
        contentPanel.add(label, BorderLayout.CENTER);
        
        // Create the toggle button for the side bar
        toggleButton = new JButton("<");
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleSidebar();
            }
        });
        
        // Add the sidebar, toggle button, and content panel to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(sidebar, BorderLayout.WEST);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        getContentPane().add(toggleButton, BorderLayout.EAST);
        
        // Set the size of the frame and show it
        setSize(500, 300);
        setVisible(true);
    }
    
    private void toggleSidebar() {
        if (sidebar.isVisible()) {
            sidebar.setVisible(false);
            toggleButton.setText(">");
        } else {
            sidebar.setVisible(true);
            toggleButton.setText("<");
        }
    }
    
    public static void main(String[] args) {
        new RetractableSidebarFrame();
    }
}
