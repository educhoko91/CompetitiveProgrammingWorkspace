import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long[][] ranges = new long[3][2];
		long[] dist = new long[3];
		long sum = 0;
		for (int i = 0; i < 3; i++) {
			ranges[i][0] = in.nextLong();
			ranges[i][1] = in.nextLong();
			dist[i] = ranges[i][0];
			sum += dist[i];
		}
		while (dist[0] < ranges[0][1] && sum != n) {
			sum++;
			dist[0]++;

		}
		
		while (dist[1] < ranges[1][1] && sum != n) {
			sum++;
			dist[1]++;

		}
		while (dist[2] < ranges[2][1] && sum != n) {
			sum++;
			dist[2]++;

		}
		
		
		System.out.println(dist[0]+" "+dist[1]+" "+dist[2]);

	}
}
