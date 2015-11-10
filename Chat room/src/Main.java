import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		char[] hello = new char[]{'h','e','l','l','o'};
		int index = 0;
		for(int i=0; i<line.length(); i++) {
			if(index<5 && line.charAt(i)==hello[index])
				index++;
		}
		if(index==5)
			System.out.println("YES");
		else
			System.out.println("NO");
		

	}

}
