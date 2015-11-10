import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] sums = new int[5001];
		for(int i=1; i<5001; i++) {
			if(!hasRepetedDigists(i)) {
				sums[i]=sums[i-1]+1;
			}
			else
				sums[i]=sums[i-1];
		}
		while(in.hasNextInt()) {
			int a = in.nextInt();
			int b = in.nextInt();
			
			System.out.println(sums[b]-sums[a-1]);
			
		}
		
		
		

	}
	
	public static boolean hasRepetedDigists(int num) {
		boolean digist[] = new boolean[10];
		
		while(num>0) {
			int digit = num%10;
			if(digist[digit])
				return true;
			else
				digist[digit]=true;
			num/=10;
		}
		return false;
	}

}
