package textverarbeitung;

public class Main {

	public static void main(String[] args) {
		
		Editor editor = new Editor();
		Dialoge dialoge = new Dialoge();
		Menu menuBar = new Menu(editor, dialoge);
		new GUI("Text-Editor", menuBar, editor);
		
	}

}
