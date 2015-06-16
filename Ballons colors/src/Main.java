import java.util.Scanner;


public class Main {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int test=0; test< cases; test++) {
			int n = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			int first = -1;
			int last = -1;
			for(int i =0; i< n; i++) {
				int a = in.nextInt();
				if(i == 0) {
					first = a;
				}
				if(i == n-1) {
					last = a;
				}
			}
			
			if(x==first && y == last) {
				System.out.println("BOTH");
			}
			else if(x==first)  {
				System.out.println("EASY");
			}
			else if(y == last) {
				System.out.println("HARD");
			}
			else
				System.out.println("OKAY");
		}
	}

}
