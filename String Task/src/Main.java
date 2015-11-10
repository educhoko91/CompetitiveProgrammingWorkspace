import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		HashSet<Character> vocal = new HashSet<Character>();
		vocal.add('a');
		vocal.add('e');
		vocal.add('i');
		vocal.add('o');
		vocal.add('u');
		vocal.add('y');
		line = line.toLowerCase();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i< line.length(); i++) {
			if(!vocal.contains(line.charAt(i))) {
				sb.append('.').append(line.charAt(i));
			}
		}
		System.out.println(sb.toString());

	}

}
