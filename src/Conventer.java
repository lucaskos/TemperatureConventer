import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Conventer extends JFrame {
	private Panel panel;
	
	public Conventer() {
		panel = new Panel();
		setVisible(true);
		setSize(400, 150);
		add(panel);
		pack();
	}
	
}
