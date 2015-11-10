import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line1 = in.nextLine().toLowerCase();
		String line2 = in.nextLine().toLowerCase();
		int x =line1.compareTo(line2);
		if(x>0) {
			System.out.println(1);
		}
		else if(x<0) {
			System.out.println(-1);
		}
		else
			System.out.println(0);
		//System.out.println(line1.compareTo(line2));

	}

}
