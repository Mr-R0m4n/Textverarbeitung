package textverarbeitung;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.text.html.HTMLEditorKit;

public class Editor {

	private JScrollPane container;
	private JEditorPane eingabeFeld;
	private HTMLEditorKit htmlFormat;
	
	public Editor() {
		eingabeFeld = new JEditorPane();
		htmlFormat = new HTMLEditorKit();
		eingabeFeld.setEditorKit(htmlFormat);
		container = new JScrollPane(eingabeFeld);
	}

	public JEditorPane getEingabeFeld() {
		return eingabeFeld;
	}
	
	public HTMLEditorKit getHtmlFormat() {
		return htmlFormat;
	}

	public JScrollPane getContainer() {
		return container;
	}
}
