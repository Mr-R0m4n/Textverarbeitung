package textverarbeitung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

import textverarbeitung.Dialoge.Filter;

public class MenuBar{
	
	private Editor editorReferenz;
	private Dialoge dialogeReferenz;

	private JMenuBar menue = new JMenuBar();
	private JMenu dateiMenue;
	private JMenuItem dateiNeu, dateiOeffnen, dateiSpeichern, dateiBeenden;
	
	class MeinListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("neu"))
				dateiNeu();
			if (e.getActionCommand().equals("�ffnen"))
				dateiOeffnen();
			if (e.getActionCommand().equals("speichern"))
				dateiSpeichern();
			if (e.getActionCommand().equals("beenden"))
				dateiBeenden();
		}
	}	
	
	public MenuBar(Editor editorReferenz, Dialoge dialogeReferenz) {
		this.editorReferenz = editorReferenz;
		this.dialogeReferenz = dialogeReferenz;
		MeinListener listener = new MeinListener();
		dateiMenue = new JMenu("Datei");
		
		dateiNeu = new JMenuItem("Neu", new ImageIcon("icons/new24.gif"));
		dateiNeu.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
		dateiNeu.setActionCommand("neu");
		dateiNeu.addActionListener(listener);
		
		dateiOeffnen = new JMenuItem("�ffnen", new ImageIcon("icons/open24.gif"));
		dateiOeffnen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
		dateiOeffnen.setActionCommand("�ffnen");
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
	}

	public JMenuBar getMenue() {
		return menue;
	}
	
	public void dateiNeu() {
		if(JOptionPane.showConfirmDialog(null, "Wollen Sie wirklich ein neues Dokument anlegen?", "Neues Dokument", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			editorReferenz.getEingabeFeld().setText("");
	}
	
	public void dateiOeffnen() {
		this.dialogeReferenz.oeffnenDialog();
	}

	
	public void dateiSpeichern() {
		this.dialogeReferenz.speichernDialog();
	}
	
	public void dateiBeenden() {
		if(JOptionPane.showConfirmDialog(null, "Sind Sie sicher?", "Anwendung schlie�en", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
		System.exit(0);
	}

	
}
