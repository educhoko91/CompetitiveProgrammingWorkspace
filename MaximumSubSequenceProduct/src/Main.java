import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	static int dpTable[];
	static ArrayList<Integer> arr;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		arr = new ArrayList<Integer>();
		while(in.hasNextInt()) {
			dpTable = new int[101];
			int x =in.nextInt();
			if(x==-999999) {
				
				long max = -99999;
				for(int i=0; i<arr.size(); i++) {
					  max=Math.max(max, dp(i,arr.size()-i));
					  
				}
				System.out.println(max);
				arr = new ArrayList<Integer>();
			}
			else
				arr.add(x);
		}

	}
	
	public static long dp(int n, int l) {
		if(l==0)
			return arr.get(n);
		long max = arr.get(n);
		for(int i=1; i<arr.size()-n; i++)
			max= Math.max(max, max*dp(n+1,l--));
		return max;
	}

}
