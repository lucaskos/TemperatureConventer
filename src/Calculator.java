import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator extends JFrame {
	private Panel panel;
	
	public Calculator() {
		panel = new Panel();
		setVisible(true);
		setSize(400, 150);
		add(panel);
		pack();
	}
	
}
