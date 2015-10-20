import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new  Scanner(System.in);
		long max=0, n, sum;
		
		
		while((n=in.nextLong())!=0) {
			max = 0;
			sum=0;
			long[] values = new long[(int)n];
			for(int i=0; i<n; i++) {
				values[i] = in.nextLong();
			}
			
			for(int i=0; i<n; i++) {
				sum=0;
				for(int j=i; j<n; j++) {
					sum += values[j];
					max = Math.max(sum, max);
				}
			}
			if(max > 0)
			System.out.println("The maximum winning streak is "+max+".");
			else
				System.out.println("Losing streak.");
		}
		
		

	}

}
