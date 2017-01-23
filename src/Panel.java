import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
	private double fahrenheit;
	private int kelvin, celsius;

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

	public void calculateCelcius(int i) {
		Context context = new Context(new CelsiusConventer());

		setLabelValues(context.executeStrategy(i));

		celsiusLabel.setForeground(Color.RED);
	}

	public void calculateFahrenheit(int i) {

		Context context = new Context(new FahrenheitConventer());

		setLabelValues(context.executeStrategy(i));

		fahrenheitLabel.setForeground(Color.RED);
	}

	public void calculateKelvin(int i) {
		Context context = new Context(new KelvinConventer());
		setLabelValues(context.executeStrategy(i));
		kelvinLabel.setForeground(Color.RED);
	}

	private void setLabelValues(MyResults r) {
		fahrenheit = r.getFahrenheit();
		kelvin = r.getKelvin();
		celsius = r.getCelsius();

		celsiusLabel.setText(String.valueOf(celsius) + CELSIUS);
		fahrenheitLabel.setText(String.valueOf(fahrenheit) + FAHRENHEIT);
		kelvinLabel.setText(String.valueOf(kelvin) + KELVIN);
		setDefaultLabelColors();

	}

	private void setDefaultLabelColors() {
		celsiusLabel.setForeground(Color.BLACK);
		fahrenheitLabel.setForeground(Color.BLACK);
		kelvinLabel.setForeground(Color.BLACK);
	}
}
