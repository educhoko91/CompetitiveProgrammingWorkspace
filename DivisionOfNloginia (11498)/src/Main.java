import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		int cases = 0;
		Scanner in = new Scanner(System.in);
		while( (cases= in.nextInt())!=0) {
			
			long n = in.nextLong();
			long m = in.nextLong();
			for(int test=0; test< cases; test++) {
				long x = in.nextLong();
				long y = in.nextLong();
				if(x==n || y==m) {
					System.out.println("divisa");
				}
				else {
					if(x>n && y>m) {
						System.out.println("NE");
					}
					else if(x>n && y<m) {
						System.out.println("SE");
					}
					else if(x<n && y > m) {
						System.out.println("NO");
					}
					else if(x<n && y<m) {
						System.out.println("SO");
					}
				}
			}
			
			
		}

	}

}
