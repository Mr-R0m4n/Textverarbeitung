package textverarbeitung;

public class Main {

	public static void main(String[] args) {
		
		Editor editor = new Editor();
		MenuBar menuBar = new MenuBar(editor);
		GUI programm = new GUI("Text-Editor", menuBar, editor);
		
	}

}
