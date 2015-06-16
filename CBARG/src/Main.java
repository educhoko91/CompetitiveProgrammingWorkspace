import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		for (int test = 0; test < cases; test++) {
			long allocated = 0;
			long actual = 0;
			long used = 0;
			
			int t = in.nextInt();
			for(int i=0; i< t; i++) {
				used = in.nextLong();
				if(used > actual) {
					allocated += used - actual;
					
				}
				actual = used;
			}
			
			System.out.println(allocated);
		}

	}

}
