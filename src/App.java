import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class App {
public static void main(String[] args) {
	try {
		SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
				Conventer c = new Conventer();
				c.addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e) {
						c.dispose();
						System.gc();
					}
				});
				
			}
		});
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}
