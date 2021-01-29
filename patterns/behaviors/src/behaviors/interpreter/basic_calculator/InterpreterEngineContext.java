package behaviors.interpreter.basic_calculator;

public class InterpreterEngineContext {
	
	public int add(String input) {
		String[] tokens = interpret(input);
		int num1 = Integer.parseInt(tokens[0]);
		int num2 = Integer.parseInt(tokens[1]);
		return (num1 + num2);
	}
	
	public int substract(String input) {
		String[] tokens = interpret(input);
		int num1 = Integer.parseInt(tokens[0]);
		int num2 = Integer.parseInt(tokens[1]);
		return (num1 - num2);
	}
	
	public String[] interpret(String input) {
		String str = input.trim().replaceAll("[^0-9]", " ");		
		return str.split("\\s+");
	}
}
