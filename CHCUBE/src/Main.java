import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		String[] sides = new String[6];

		for (int test = 0; test < cases; test++) {
			for (int i = 0; i < 6; i++) {
				sides[i] = in.next();
			}

			if (sides[0].equals(sides[3]) && sides[0].equals(sides[5])) {
				System.out.println("YES");
			} else if (sides[3].equals(sides[1]) && sides[3].equals(sides[5])) {
				System.out.println("YES");
			} else if (sides[2].equals(sides[1]) && sides[2].equals(sides[5])) {
				System.out.println("YES");
			} else if (sides[2].equals(sides[0]) && sides[2].equals(sides[5])) {
				System.out.println("YES");
			} else if (sides[4].equals(sides[0]) && sides[4].equals(sides[3])) {
				System.out.println("YES");
			} else if (sides[4].equals(sides[1]) && sides[4].equals(sides[3])) {
				System.out.println("YES");
			} else if (sides[4].equals(sides[1]) && sides[4].equals(sides[2])) {
				System.out.println("YES");
			} else if (sides[4].equals(sides[0]) && sides[4].equals(sides[2])) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

}
