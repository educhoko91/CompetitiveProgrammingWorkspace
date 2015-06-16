import java.util.Arrays;
import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int test=1; test<= cases; test++) {
			int n = in.nextInt();
			int speeds[] = new int[n];
			for(int i=0; i< n; i++) {
				speeds[i]=in.nextInt();
			}
			Arrays.sort(speeds);
			System.out.println("Case "+test+": "+speeds[n-1]);
		}

	}

}
