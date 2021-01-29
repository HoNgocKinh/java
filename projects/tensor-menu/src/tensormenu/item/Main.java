package tensormenu.item;

import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		List<String> originalMenu = Arrays.asList("Settings", "Tools", "Macro", "Run", "Plugins");
		TensorMenu tensorMenu = new TensorMenu(originalMenu);
		tensorMenu.display();
	}
}



