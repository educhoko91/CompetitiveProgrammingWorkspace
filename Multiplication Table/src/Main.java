import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n= in.nextLong();
		long x = in.nextLong();
		long count = 0;;
		for(int i=1; i<=n; i++){
			for(int j=i; j<=n; j++ ) {
				if(i*j==x && i==j){
					count++;
				}
				else if(i*j==x)
					count+=2;
			}
		}
		System.out.println(count);

	}

}
