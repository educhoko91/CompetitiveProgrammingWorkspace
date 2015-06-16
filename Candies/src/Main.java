import java.util.Scanner;

import javafx.scene.transform.Scale;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int test =0; test<cases; test++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int sum = 0;
			for(int i=0; i < n; i++) {
				sum += in.nextInt()/k;
			}
			System.out.println(sum);
		}

	}

}
