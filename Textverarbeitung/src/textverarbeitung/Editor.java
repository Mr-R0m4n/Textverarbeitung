package textverarbeitung;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Editor extends JFrame{

	private static final long serialVersionUID = 5421030522300044452L;
	private JTextArea eingabeFeld;
	
	public Editor(String titel) {
		super(titel);
		
		setLayout(new BorderLayout());
		
		setJMenuBar(new MenuBar().getMenue());
		
		eingabeFeld = new JTextArea();
		add(new JScrollPane(eingabeFeld), BorderLayout.CENTER);
		
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(600, 200));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
}
