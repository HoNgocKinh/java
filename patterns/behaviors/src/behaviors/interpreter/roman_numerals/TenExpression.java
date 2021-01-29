package behaviors.interpreter.roman_numerals;

public class TenExpression extends Expression {
	 
    @Override
    public String one() {
        return "X";
    }
 
    @Override
    public String four() {
        return "XL";
    }
 
    @Override
    public String five() {
        return "L";
    }
 
    @Override
    public String nine() {
        return "XC";
    }
 
    @Override
    public int multiplier() {
        return 10;
    }
 
}
