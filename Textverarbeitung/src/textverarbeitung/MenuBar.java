package textverarbeitung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MenuBar {
	
	private Editor editorReferenz;

	private JMenuBar menue = new JMenuBar();
	private JMenu dateiMenue;
	private JMenuItem dateiNeu, dateiOeffnen, dateiSpeichern, dateiBeenden;
	
	class MeinListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("neu"))
				dateiNeu();
			if (e.getActionCommand().equals("öffnen"))
				dateiOeffnen();
			if (e.getActionCommand().equals("speichern"))
				dateiSpeichern();
			if (e.getActionCommand().equals("beenden"))
				dateiBeenden();
		}
	}	
	
	public MenuBar(Editor editorReferenz) {
		this.editorReferenz = editorReferenz;
		MeinListener listener = new MeinListener();
		dateiMenue = new JMenu("Datei");
		
		dateiNeu = new JMenuItem("Neu", new ImageIcon("icons/new24.gif"));
		dateiNeu.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
		dateiNeu.setActionCommand("neu");
		dateiNeu.addActionListener(listener);
		
		dateiOeffnen = new JMenuItem("Öffnen", new ImageIcon("icons/open24.gif"));
		dateiOeffnen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
		dateiOeffnen.setActionCommand("öffnen");
		dateiOeffnen.addActionListener(listener);
		
		dateiSpeichern = new JMenuItem("Speichern", new ImageIcon("icons/save24.gif"));
		dateiSpeichern.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
		dateiSpeichern.setActionCommand("speichern");
		dateiSpeichern.addActionListener(listener);
		
		dateiBeenden = new JMenuItem("Beenden");
		dateiBeenden.setAccelerator(KeyStroke.getKeyStroke('B', InputEvent.CTRL_DOWN_MASK));
		dateiBeenden.setActionCommand("beenden");
		dateiBeenden.addActionListener(listener);
		
		dateiMenue.add(dateiNeu);
		dateiMenue.add(dateiOeffnen);
		dateiMenue.add(dateiSpeichern);
		dateiMenue.add(dateiBeenden);
		
		menue.add(dateiMenue);
	}

	public JMenuBar getMenue() {
		return menue;
	}
	
	public void dateiNeu() {
		if(JOptionPane.showConfirmDialog(null, "Wollen Sie wirklich ein neues Dokument anlegen?", "Neues Dokument", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			editorReferenz.getEingabeFeld().setText("");
	}
	
	public void dateiOeffnen() {
		System.out.println("Datei wird geöffnet");
	}
	
	public void dateiSpeichern() {
		System.out.println("Datei wird gespeichert");
	}
	
	public void dateiBeenden() {
		if(JOptionPane.showConfirmDialog(null, "Wollen Sie wirklich das Programm Beenden?", "Programm Beenden", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
		System.exit(0);
	}
	
}
