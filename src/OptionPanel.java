import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class OptionPanel extends JPanel {
	private RadioButtonListener listener;
	private final String celcius = "celsius";
	private final String fahrenheit = "fahrenheit";
	private final String kelvin = "kelvin";
	private JRadioButton celsius, fahrenheitBtn, kelvinBtn;
	
	private ArrayList<JRadioButton> radioButtons;
	public OptionPanel(){
		
		
		setLayout(new GridLayout(0, 1));
		celsius = new JRadioButton(celcius);
		celsius.setSelected(true);
		fahrenheitBtn = new JRadioButton(fahrenheit);
		kelvinBtn = new JRadioButton(kelvin);
		radioButtons = new ArrayList<>();
		radioButtons.add(celsius);
		radioButtons.add(fahrenheitBtn);
		radioButtons.add(kelvinBtn);
		ButtonGroup group = new ButtonGroup();
		for(JRadioButton button : radioButtons) {
			group.add(button);
			this.add(button);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					listener.getRadioButtonName(button.getText());
				}
			});
		}
		
		
	}
	public void setRadioLisener(RadioButtonListener radioListener) {
		this.listener = radioListener;
	}
}
