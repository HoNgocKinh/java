import java.util.Scanner;
import java.util.Stack;
public class TrungToSangKQ {

	

	
	public static void main(String[] args){
		new TrungToSangKQ();
	}
	public TrungToSangKQ() {
		System.out.println("Nhap Bieu Thuc");
		String str = new Scanner(System.in).nextLine();
		String str2 = HauTo(str);		
		KQ(str2);
	}
	public static String HauTo(String str){

		
		String str1 = "";
		String str2 = "";
		Stack <Character> s = new Stack <Character>();
		for(int i = 0 ; i < str.length() ; i++){
			char c = str.charAt(i);
			if(c != ' '){
				if(c - '0' >= 0 && c - '0' <= 9) str1 += c;
				else {
					str1 += " ";
					str2 += str1;				
					str1 = "";
					if(c == '(') s.push(c);
					else{
						if(c == ')'){
							while(s.peek() != '(') {
								str2 += s.peek();
								s.pop();
							}
							s.pop();
						}
						else {
							while(!s.empty() && UuTien(c) <= UuTien(s.peek())){
								str2 += s.peek();
								s.pop();
							}
							s.push(c);
						}
					}
				}
			}
		}
		if(str1 != ""){
			str1 += " ";
			str2 += str1;
		}
		while(!s.empty()){
			str2 += s.peek();
			s.pop();
		}
		System.out.println(str2);
		return str2;
	}
	public static void KQ(String str){
		double res = 0;
		Stack <Double> s = new Stack <Double> (); 
		for(int i = 0 ; i < str.length() ; i++){
			char c = str.charAt(i);
			if(c != ' '){
				if(c - '0' >= 0 && c - '0' <= 9){
					res = res*10 + c - '0';
					if(i < str.length() - 1){
						int temp = str.charAt(i + 1) - '0';
						if(temp > 9 || temp < 0){
							s.push(res);
							res = 0;
						}
					}
				}
				else {
					double a,b;
					b = (double) s.pop();
					a = (double) s.pop();
					if(c == '+') s.push(a + b);
					if(c == '-') s.push(a - b);
					if(c == '*') s.push(a * b);
					if(c == '/') s.push(a / b);
					if(c == '^') s.push(Math.pow(a,b));
					if(c == '%') s.push(a % b);
				}
			}
		}
		System.out.print("Gia Tri cua Bieu thuc la: " + s.pop());
	}
	public static int UuTien(char c){
		if(c == '(') return 0;
		if(c == '+' || c == '-') return 1;
		if(c == '*'  || c == '/' || c == '%' ) return 2;
		if(c == '^') return 3;
		return 0;
	}
}
