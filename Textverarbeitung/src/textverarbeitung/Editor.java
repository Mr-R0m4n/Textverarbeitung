package textverarbeitung;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Editor {

	private JScrollPane container;
	private JTextArea eingabeFeld;
	
	public Editor() {
		eingabeFeld = new JTextArea();
		container = new JScrollPane(eingabeFeld);
	}

	public JTextArea getEingabeFeld() {
		return eingabeFeld;
	}

	public JScrollPane getContainer() {
		return container;
	}
	
}
