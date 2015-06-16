import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int test=0; test<cases; test++) {
			long x = in.nextLong();
			long y = in.nextLong();
			if(x>y) {
				System.out.println('>');
			}
			else if(x<y) {
				System.out.println('<');
			}
			else if(x==y) {
				System.out.println('=');
			}
		}

	}

}
