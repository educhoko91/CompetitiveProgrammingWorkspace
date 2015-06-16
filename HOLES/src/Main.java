import java.util.HashSet;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		int[] holes = new int[]{
			1,2,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0		
		};
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for(int i =0; i<n;i++) {
			String line = in.nextLine();
			int cnd = 0;
			for(char c: line.toCharArray()) {
				cnd += holes[c-'A'];
			}
			System.out.println(cnd);
		}
		

	}

}
