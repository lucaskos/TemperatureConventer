import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class App {
public static void main(String[] args) {
	try {
		SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
				new Conventer();
			}
		});
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}
