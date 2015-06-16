import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<String, Matrix> map = new HashMap<String, Matrix>();
		Stack<String> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			String name = in.next();
			map.put(name, new Matrix(in.nextInt(),in.nextInt(),name));
		}
		in.nextLine();
		expretions:
		while(in.hasNextLine()) {
			long sum = 0;
			String line = in.nextLine();
			for(Character c: line.toCharArray()) {
				if(Character.isLetter(c)) {
					stack.push(c.toString());
				}
				if(c==')') {
					Matrix b = map.get(stack.pop());
					Matrix a = map.get(stack.pop());
					if(a.b!=b.a) {
						System.out.println("error");
						continue expretions;
					}
					else {
						sum += b.a*b.b*a.a;
						map.put(a.name+b.name, new Matrix(a.a, b.b, a.name+b.name));
						stack.push(a.name+b.name);
					}
					
				}
				
			}
			System.out.println(sum);
			stack.clear();
			
		}

	}

}

class Matrix {
	int a;
	int b;
	String name;
	
	public Matrix(int a, int b, String name) {
		this.a = a;
		this.b = b;
		this.name = name;
	}
}
