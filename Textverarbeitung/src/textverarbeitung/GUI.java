package textverarbeitung;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GUI extends JFrame{

	private static final long serialVersionUID = -4505945941683467289L;
	private MenuBar menuBarReferenzBar;
	private Editor editorReferenz;
	
	public GUI(String titel, MenuBar menuBarReferenzBar, Editor editorReferenz) {
		super(titel);
		this.menuBarReferenzBar = menuBarReferenzBar;
		this.editorReferenz = editorReferenz;
		
		setLayout(new BorderLayout());
		
		setJMenuBar(this.menuBarReferenzBar.getMenue());
		add(this.editorReferenz.getContainer());

		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(600, 200));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
	}
	
}
