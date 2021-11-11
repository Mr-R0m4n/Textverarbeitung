package textverarbeitung;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GUI extends JFrame{

	private static final long serialVersionUID = -4505945941683467289L;
	private Menu menuReferenz;
	private Editor editorReferenz;
	
	public GUI(String titel, Menu menuReferenz, Editor editorReferenz) {
		super(titel);
		this.menuReferenz = menuReferenz;
		this.editorReferenz = editorReferenz;
		
		setLayout(new BorderLayout());
		
		setJMenuBar(this.menuReferenz.menueLeiste());
		add(menuReferenz.symbolleiste(), BorderLayout.NORTH);
		add(this.editorReferenz.getContainer(), BorderLayout.CENTER);

		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(600, 200));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
	}
	
}
