import java.util.Arrays;
import java.util.Scanner;


public class Twins {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		int sum=0;
		for(int i=0; i<n; i++) {
			int x = in.nextInt();
			arr[i]=x;
			sum+=x;
		}
		Arrays.sort(arr);
		int i= n-1;
		int cnd =0;
		int split=0;
		while(true) {
			if(split>sum)
				break;
			split+=arr[i];
			sum-=arr[i];
			cnd++;
			i--;
		}
		System.out.println(cnd);

	}

}
