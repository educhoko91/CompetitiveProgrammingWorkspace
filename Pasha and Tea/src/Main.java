import java.util.Arrays;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		double w = in.nextLong();
		double[] cups = new double[(int) (2*n)];
		for(int i=0; i<2*n; i++) {
			cups[i] = in.nextDouble(); 
		}
		
		Arrays.sort(cups);
		double fill=0;
		if(cups[0]*2<=cups[(int)n]) {
			fill = cups[0];
		}
		else {
			fill = cups[(int)n]/2;
		}
		double total = (fill*n)+(fill*2*n);
		if(total < w) {
			System.out.println(total);
		}
		else {
			System.out.println(w);
		}
		
		

	}

}
