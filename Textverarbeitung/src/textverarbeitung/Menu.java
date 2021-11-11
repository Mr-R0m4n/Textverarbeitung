package textverarbeitung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Menu{
	
	private Editor editorReferenz;
	private Dialoge dialogeReferenz;

	class MeinListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("neu"))
				dateiNeu();
			if (e.getActionCommand().equals("laden"))
				dateiLaden();
			if (e.getActionCommand().equals("speichern"))
				dateiSpeichern();
			if (e.getActionCommand().equals("beenden"))
				dateiBeenden();
		}
	}	
	
	public Menu(Editor editorReferenz, Dialoge dialogeReferenz) {
		this.editorReferenz = editorReferenz;
		this.dialogeReferenz = dialogeReferenz;
	}
	
	public JMenuBar menueLeiste() {
		JMenuBar menue = new JMenuBar();
		JMenu dateiMenue;
		JMenuItem dateiNeu, dateiOeffnen, dateiSpeichern, dateiBeenden;
		
		MeinListener listener = new MeinListener();
		dateiMenue = new JMenu("Datei");
		
		dateiNeu = new JMenuItem("Neu", new ImageIcon("icons/new24.gif"));
		dateiNeu.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
		dateiNeu.setActionCommand("neu");
		dateiNeu.addActionListener(listener);
		
		dateiOeffnen = new JMenuItem("Öffnen", new ImageIcon("icons/open24.gif"));
		dateiOeffnen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
		dateiOeffnen.setActionCommand("laden");
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
		dateiMenue.addSeparator();
		dateiMenue.add(dateiSpeichern);
		dateiMenue.addSeparator();
		dateiMenue.add(dateiBeenden);
		
		menue.add(dateiMenue);
		
		return menue;
	}
	
	public JToolBar symbolleiste() {
		JToolBar symbolLeiste = new JToolBar();
		
		MeinListener listener = new MeinListener();
		
		JButton dateiNeuButton = new JButton();
		dateiNeuButton.setActionCommand("neu");
		dateiNeuButton.setIcon(new ImageIcon("icons/new24.gif"));
		dateiNeuButton.setToolTipText("Erstellt ein neues Dokument");
		dateiNeuButton.addActionListener(listener);
		
		JButton dateiOeffnenButton = new JButton();
		dateiOeffnenButton.setActionCommand("laden");
		dateiOeffnenButton.setIcon(new ImageIcon("icons/open24.gif"));
		dateiOeffnenButton.setToolTipText("Öffnet ein vorhandenes Dokument");
		dateiOeffnenButton.addActionListener(listener);
		
		JButton dateiSpeichernButton = new JButton();
		dateiSpeichernButton.setActionCommand("speichern");
		dateiSpeichernButton.setIcon(new ImageIcon("icons/save24.gif"));
		dateiSpeichernButton.setToolTipText("Speichert das aktuelle Dokument");
		dateiSpeichernButton.addActionListener(listener);
		
		symbolLeiste.add(dateiNeuButton);
		symbolLeiste.add(dateiOeffnenButton);
		symbolLeiste.add(dateiSpeichernButton);
		
		return symbolLeiste;
	}
	
	public void dateiNeu() {
		if(JOptionPane.showConfirmDialog(null, "Wollen Sie wirklich ein neues Dokument anlegen?", "Neues Dokument", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			this.editorReferenz.getEingabeFeld().setText("");
	}
	
	public void dateiLaden() {
		File datei = this.dialogeReferenz.oeffnenDialog();
		if(datei != null) {
			try {
				this.editorReferenz.getEingabeFeld().read(new FileReader(datei), null);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Beim Laden hat es ein Problem gegeben.", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void dateiSpeichern() {
		File datei = this.dialogeReferenz.speichernDialog();
		if(datei != null) {
			try {
				this.editorReferenz.getEingabeFeld().write(new FileWriter(datei));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Beim Speichern hat es ein problem gegeben.", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void dateiBeenden() {
		if(this.dialogeReferenz.beendenDialog() == JOptionPane.YES_OPTION)
		System.exit(0);
	}
	
}
