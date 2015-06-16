import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		caseWhile:
		while(cases >0) {
			cases--;
			int n = in.nextInt();
			ArrayList<Long> list = new ArrayList<>();
			
			for(int i =0; i<n;i++) {
				long a = in.nextLong();
				list.add(a);
			}
			
			if(list.contains(1)) {
				System.out.println(-1);
				continue caseWhile;
			}
			/*if(n==1) {
				System.out.println(2);
				continue caseWhile;
			}*/
			
			Collections.sort(list, new Comparator<Long>() {

				@Override
				public int compare(Long o1, Long o2) {
					return (int)(o2-o1);
				}
			});
			
			BigInteger sum = BigInteger.ZERO;
			for(int i=0; i<list.size()-1;i++) {
				sum = sum.add(BigInteger.valueOf(list.get(i)));
			}
			sum = sum.add(BigInteger.valueOf(2));
			System.out.println(sum.toString());
			
			
		}

	}

}
