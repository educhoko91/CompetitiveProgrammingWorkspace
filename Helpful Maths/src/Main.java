import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		ArrayList<Character> arr = new ArrayList<Character>();
		for(int i=0;i< line.length(); i+=2) {
			arr.add(line.charAt(i));
		}
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		sb.append(arr.get(0));
		for(int i=1; i<arr.size(); i++)
			sb.append('+').append(arr.get(i));
		System.out.println(sb.toString());
	}

}
