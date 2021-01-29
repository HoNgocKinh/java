package behaviors.interpreter.basic_calculator;

public class Client {
	
	public static void main(String args[]) {
        System.out.println("20 plus 8 = " + interpret("20 plus 8"));
        System.out.println("10 subtract 4 = " + interpret("10 subtract 4"));
    }
 
    private static int interpret(String input) {
        Expression exp = null;
        if (input.contains("plus")) {
            exp = new AddExpression(input);
        } else if (input.contains("subtract")) {
            exp = new SubtractExpression(input);
        } else {
            throw new UnsupportedOperationException();
        }
        return exp.interpret(new InterpreterEngineContext());
    }
}
