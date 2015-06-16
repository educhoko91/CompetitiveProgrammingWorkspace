import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);
		int t = Integer.parseInt(reader.readLine());
		for(int i=0; i<t;i++) {
			String[] line2 = reader.readLine().split(" ");
			int n = Integer.parseInt(line2[0]);
			long k = Long.parseLong(line2[1]);
			long[] a = new long[n];
			long[] b = new long[n];
			//Long[] prof = new Long[n];
			BigInteger prof;
			BigInteger max = BigInteger.ZERO;
			String[] aS = reader.readLine().split(" ");
			String[] bS = reader.readLine().split(" ");
			for(int j=0; j<n; j++) {
				a[j]=Long.parseLong(aS[j]);
				b[j]=Long.parseLong(bS[j]);
				long aux = k/a[j];
				prof = new BigInteger(aux+"").multiply(new BigInteger(b[j]+""));
				max = prof.max(max);
			}
			
			System.out.println(max.toString());
		}

	}

}
