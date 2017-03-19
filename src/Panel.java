import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import strategies.Context;

public class Panel extends JPanel {
	private JSlider slider;
	private JLabel celsiusLabel, fahrenheitLabel, kelvinLabel;
	private JPanel northPanel;
	private final static String CELSIUS = "°C";
	private final static String FAHRENHEIT = "°F";
	private final static String KELVIN = "K";
	private OptionPanel optionPanel;
	private String optionName;
	private static double kelvinValue = 273.15;
	private Context context;

	Panel() {
		setLayout(new BorderLayout());

		slider = new JSlider(0, 100);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setEnabled(true);

		celsiusLabel = new JLabel();
		fahrenheitLabel = new JLabel();
		kelvinLabel = new JLabel();

		northPanel = new JPanel();
		optionPanel = new OptionPanel();

		// default color and option
		optionName = "celsius";
		celsiusLabel.setForeground(Color.RED);

		celsiusLabel.setText(String.valueOf(slider.getValue()) + CELSIUS);
		fahrenheitLabel.setText(celsiusLabel.getText());
		kelvinLabel.setText(String.valueOf(slider.getValue()) + KELVIN);
		optionPanel.setRadioLisener(new RadioButtonListener() {
			public void getRadioButtonName(String name) {
				optionName = name;
			}
		});
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = slider.getValue();
				if (optionName.equalsIgnoreCase("celsius") || optionName.isEmpty() || optionName == null
						|| optionName.equals(null)) {
					calculateCelcius(value);
				} else if (optionName.equalsIgnoreCase("fahrenheit")) {
					calculateFahrenheit(value);
				} else {
					calculateKelvin(value);
				}
			}
		});

		northPanel.add(celsiusLabel);
		northPanel.add(fahrenheitLabel);
		northPanel.add(kelvinLabel);

		add(northPanel, BorderLayout.NORTH);
		add(slider, BorderLayout.CENTER);
		add(optionPanel, BorderLayout.EAST);

	}
	
	//REVIEW 
	/*
	 * implement strategy pattern desing
	 */

	public void calculateCelcius(int i) {
		float fahrenheit = (float) (Float.valueOf(i) * 1.8 + 32);
		
		fahrenheitLabel.setText(String.valueOf(fahrenheit) + FAHRENHEIT);
		fahrenheitLabel.setForeground(Color.BLACK);
		celsiusLabel.setText(String.valueOf(i + CELSIUS));
		celsiusLabel.setForeground(Color.RED);
		kelvinLabel.setForeground(Color.BLACK);
		kelvinLabel.setText(String.valueOf(i + kelvinValue) + KELVIN);
	}

	public void calculateFahrenheit(int i) {
		double celsius = (i - 32) * 5 / 9;
		celsiusLabel.setForeground(Color.BLACK);
		celsiusLabel.setText(String.valueOf(celsius + CELSIUS));
		fahrenheitLabel.setForeground(Color.RED);
		fahrenheitLabel.setText(String.valueOf(i) + FAHRENHEIT);
		kelvinLabel.setForeground(Color.BLACK);
		kelvinLabel.setText(String.valueOf(celsius + kelvinValue) + KELVIN);
	}
	
	public void calculateKelvin(int i) {
		double fahrenheit = i * 9 /5 - 459.67;
		float celsius = (float) (i - kelvinValue);
		celsiusLabel.setForeground(Color.BLACK);
		celsiusLabel.setText(String.valueOf(celsius) + CELSIUS);
		fahrenheitLabel.setForeground(Color.BLACK);
		fahrenheitLabel.setText(String.valueOf(fahrenheit) + FAHRENHEIT);
		kelvinLabel.setForeground(Color.RED);
		kelvinLabel.setText(String.valueOf(i) + KELVIN);
	}
}
