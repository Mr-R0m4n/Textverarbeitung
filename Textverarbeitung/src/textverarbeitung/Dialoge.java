package textverarbeitung;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class Dialoge {
	
	class Filter extends FileFilter{

		@Override
		public String getDescription() {
			return "Textdateien";
		}

		@Override
		public boolean accept(File f) {
			String nameString = f.getName().toLowerCase();
			if (f.isDirectory())
				return true;
			if (nameString.endsWith(".txt"))
				return true;
			return false;
		}
	}
	
	public File oeffnenDialog() {
		JFileChooser oeffnenDialog = new JFileChooser();
		oeffnenDialog.setFileFilter(new Filter());
		oeffnenDialog.setAcceptAllFileFilterUsed(false);
		int status = oeffnenDialog.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION)
			return oeffnenDialog.getSelectedFile();
		else
			return null;
	}

	public File speichernDialog() {
		JFileChooser speichernDialog = new JFileChooser();
		speichernDialog.setFileFilter(new Filter());
		speichernDialog.setAcceptAllFileFilterUsed(false);
		int status = speichernDialog.showSaveDialog(null);
		if (status == JFileChooser.APPROVE_OPTION)
			return speichernDialog.getSelectedFile();
		else
			return null;
	}

}