import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class uimain {
	public static JFrame frame;
	public static JPanel contentPanel;
	public static void main(String[] args) {
		frame = new JFrame("Encryptle");
		frame.setSize(1000, 500);
		frame.setLocation(100, 100);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		contentPanel = new JPanel(new BorderLayout());
		frame.setContentPane(contentPanel);
		frame.setVisible(true);
	}
	
}
