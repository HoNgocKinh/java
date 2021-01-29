import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Stream;

public class Main {
	
	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(new FileReader("day.csv"))) {
			Stream<String> lines = br.lines();
			String[] temp = lines.toArray(String[]::new);
			String[] columns = temp[0].split("\\s+");
			
			for (String column : columns) {
				
			}
		}
		catch (Exception ex) {
			System.err.println(ex.toString());
		}
		
		Tree tree = new Tree();
		
	}
}

class Node {
	
	public String data;
	public List<Node> children;
	
	public Node(String data) {
		this.data = data;
	}
}

class Tree {
	
	private float information_gain() {
		
		return 0f;
	}
	
	private float entropy() {
		
		return 0f;
	}
}