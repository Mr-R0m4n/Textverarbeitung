package textverarbeitung;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class Menu{
	
	private Editor editorReferenz;
	private Dialoge dialogeReferenz;

	public class ActionObjekt extends AbstractAction{
		
		private static final long serialVersionUID = 599695903271286671L;

		public ActionObjekt(String text, ImageIcon icon, String bildschirmTipp, KeyStroke shortcut, String actionText) {
			super(text, icon);
			putValue(SHORT_DESCRIPTION, bildschirmTipp);
			putValue(ACCELERATOR_KEY, shortcut);
			putValue(ACTION_COMMAND_KEY, actionText);
		}
		
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

		dateiMenue = new JMenu("Datei");
		
		ActionObjekt neuAct = new ActionObjekt("Neu", new ImageIcon("icons/new24.gif"), "Erstellt ein neues Dokument", KeyStroke.getKeyStroke('N'), "neu");
		ActionObjekt oeffnenAct = new ActionObjekt("Öffnen", new ImageIcon("icons/open24.gif"), "Öffnet ein vorhandenes Dokument", KeyStroke.getKeyStroke('O'), "laden");
		ActionObjekt speichernAct = new ActionObjekt("Speichern", new ImageIcon("icons/save24.gif"), "Speichert das aktuelle Dokument", KeyStroke.getKeyStroke('S'), "speichern");
		ActionObjekt beendenAct = new ActionObjekt("Beenden", null, "Beendet das Programm", null, "beenden");
		
		dateiMenue.add(neuAct);
		dateiMenue.add(oeffnenAct);
		dateiMenue.addSeparator();
		dateiMenue.add(speichernAct);
		dateiMenue.addSeparator();
		dateiMenue.add(beendenAct);
		
		menue.add(dateiMenue);
		
		return menue;
	}
	
	public JToolBar symbolleiste() {
		JToolBar symbolLeiste = new JToolBar();
		
		ActionObjekt neuAct = new ActionObjekt("Neu", new ImageIcon("icons/new24.gif"), "Erstellt ein neues Dokument", KeyStroke.getKeyStroke('N'), "neu");
		ActionObjekt oeffnenAct = new ActionObjekt("Öffnen", new ImageIcon("icons/open24.gif"), "Öffnet ein vorhandenes Dokument", KeyStroke.getKeyStroke('O'), "laden");
		ActionObjekt speichernAct = new ActionObjekt("Speichern", new ImageIcon("icons/save24.gif"), "Speichert das aktuelle Dokument", KeyStroke.getKeyStroke('S'), "speichern");
		
		symbolLeiste.add(neuAct);
		symbolLeiste.add(oeffnenAct);
		symbolLeiste.add(speichernAct);
		symbolLeiste.addSeparator();
		
		Action fettFormat = new StyledEditorKit.BoldAction();
		fettFormat.putValue(Action.SHORT_DESCRIPTION, "Fett formatieren");
		fettFormat.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/bold24.gif"));
		
		Action kursivFormat = new StyledEditorKit.ItalicAction();
		kursivFormat.putValue(Action.SHORT_DESCRIPTION, "Fett formatieren");
		kursivFormat.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/italic24.gif"));
		
		Action unterstrichenFormat = new StyledEditorKit.UnderlineAction();
		unterstrichenFormat.putValue(Action.SHORT_DESCRIPTION, "Fett formatieren");
		unterstrichenFormat.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/underline24.gif"));
		
		symbolLeiste.add(fettFormat);
		symbolLeiste.add(kursivFormat);
		symbolLeiste.add(unterstrichenFormat);
		symbolLeiste.addSeparator();
		
		Action linksFormat = new StyledEditorKit.AlignmentAction("Linksbündig", StyleConstants.ALIGN_LEFT);
		linksFormat.putValue(Action.SHORT_DESCRIPTION, "Linksbündig formatieren");
		linksFormat.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/alignLeft24.gif"));
		
		Action mittigFormat = new StyledEditorKit.AlignmentAction("Mittig", StyleConstants.ALIGN_CENTER);
		mittigFormat.putValue(Action.SHORT_DESCRIPTION, "Mittig formatieren");
		mittigFormat.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/alignCenter24.gif"));
		
		Action rechtsFormat = new StyledEditorKit.AlignmentAction("Rechtsbündig", StyleConstants.ALIGN_RIGHT);
		rechtsFormat.putValue(Action.SHORT_DESCRIPTION, "Rechtsbündig formatieren");
		rechtsFormat.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/alignRight24.gif"));
		
		Action blockFormat = new StyledEditorKit.AlignmentAction("Blocksatz", StyleConstants.ALIGN_JUSTIFIED);
		blockFormat.putValue(Action.SHORT_DESCRIPTION, "Blocksatz formatieren");
		blockFormat.putValue(Action.LARGE_ICON_KEY, new ImageIcon("icons/alignJustify24.gif"));
		
		symbolLeiste.add(linksFormat);
		symbolLeiste.add(mittigFormat);
		symbolLeiste.add(rechtsFormat);
		symbolLeiste.add(blockFormat);
		
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
				OutputStream output = new FileOutputStream(datei);
				this.editorReferenz.getHtmlFormat().write(output, this.editorReferenz.getEingabeFeld().getDocument(), 0, editorReferenz.getEingabeFeld().getDocument().getLength());
			} catch (IOException | BadLocationException e) {
				JOptionPane.showMessageDialog(null, "Beim Speichern hat es ein problem gegeben.", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void dateiBeenden() {
		if(this.dialogeReferenz.beendenDialog() == JOptionPane.YES_OPTION)
		System.exit(0);
	}
	
}
