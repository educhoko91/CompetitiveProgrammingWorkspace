import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		
		for(int test = 0; test<cases; test++) {
			
			int n = in.nextInt();
			long k = in.nextLong();
			long days[] = new long[n];
			long packages = 0;
			long numBreads = 0;
			for(int i=0; i<n; i++) {
				long eat = in.nextLong();
				if(numBreads<eat) {
					/*while(numBreads<eat){
						packages++;
						numBreads += k;
					}*/
					long increment = (long) Math.ceil((double)((double)(eat-numBreads)/(double)k));
					packages+=increment;
					numBreads += k*increment;
				}
				numBreads -= eat;
				
				if(numBreads>0)
					numBreads--;
			}
			System.out.println(packages);
			
		}

	}

}
