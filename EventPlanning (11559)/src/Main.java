import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int participants = in.nextInt();
			double buget = in.nextDouble();
			int hotels = in.nextInt();
			int weeks = in.nextInt();
			double prices[] = new double[hotels];
			boolean abilites[] = new boolean[hotels]; 
			for (int i = 0; i < hotels; i++) {
				prices[i] = in.nextDouble();
				for(int j =0; j< weeks; j++) {
					if(!abilites[i] & in.nextInt() >= participants) {
						abilites[i]=true;
						continue;
					}

				}
			}
			
			double minTotal = Double.MAX_VALUE;
			for(int i =0; i< hotels; i++) {
				if(abilites[i]) {
					minTotal = Math.min(minTotal,prices[i]*participants);
				}
			}
			
			if(minTotal==Double.MAX_VALUE || minTotal > buget) {
				System.out.println("stay home");
			}
			else {
				System.out.println((int)minTotal);
			}

		}

	}

}
