import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNextLong()) {
			long n = in.nextLong();
			long level= 0;
			if(n>7)  {
				for(int i=7; i<=n; i++) {
					if(Long.bitCount(i)%3==0) {
						level++;
					}
				}
			}
			System.out.println("Day "+n+": Level = "+level);
		}

	}

}
