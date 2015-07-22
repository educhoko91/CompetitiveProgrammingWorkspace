import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(reader.readLine());
		
		for(int test=0; test<cases; test++) {
			double[] values = new double[300];
			int k = Integer.parseInt(reader.readLine());
			for(int i=0; i<k; i++) {
				String[] line = reader.readLine().split(" ");
				
				values[(int)line[0].charAt(0)] = Double.parseDouble(line[1])/100;
			}
			int m = Integer.parseInt(reader.readLine());
			double sum = 0;
			for(int i=0; i<m; i++) {
				for(char c: reader.readLine().toCharArray()) {
					sum += values[c];
				}
			}
			System.out.printf("%.2f$\n", sum);
		}

	}

}
