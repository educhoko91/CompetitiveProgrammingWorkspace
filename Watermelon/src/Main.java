import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		for(int i=2; i<=x/2; i+=2) {
			if((i-x)%2 == 0) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");

	}

}
