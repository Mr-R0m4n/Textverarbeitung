package textverarbeitung;

import java.awt.event.InputEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar {

	private JMenuBar menue = new JMenuBar();
	private JMenu dateiMenue;
	private JMenuItem dateiNeu, dateiOeffnen, dateiSpeichern, dateiBeenden;
	
	public MenuBar() {
		dateiMenue = new JMenu("Datei");
		
		dateiNeu = new JMenuItem("Neu", new ImageIcon("icons/new24.gif"));
		dateiNeu.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
		
		dateiOeffnen = new JMenuItem("Öffnen", new ImageIcon("icons/open24.gif"));
		dateiOeffnen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
		
		dateiSpeichern = new JMenuItem("Speichern", new ImageIcon("icons/save24.gif"));
		dateiSpeichern.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
		
		dateiBeenden = new JMenuItem("Beenden");
		dateiBeenden.setAccelerator(KeyStroke.getKeyStroke('B', InputEvent.CTRL_DOWN_MASK));
		
		dateiMenue.add(dateiNeu);
		dateiMenue.add(dateiOeffnen);
		dateiMenue.add(dateiSpeichern);
		dateiMenue.add(dateiBeenden);
		
		menue.add(dateiMenue);
	}

	public JMenuBar getMenue() {
		return menue;
	}
	
}
