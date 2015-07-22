import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class MainTimeLimit {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int s,b;
		String line=null;
		while((line=br.readLine())!=null) {
			StringTokenizer token = new StringTokenizer(line);
			if((s=Integer.parseInt(token.nextToken()))==0 & (b=Integer.parseInt(token.nextToken()))==0) break;
			boolean army[]  = new boolean[s+1];
			for(int a=0; a<b; a++) {
				line = br.readLine();
				token = new StringTokenizer(line);
				int l = Integer.parseInt(token.nextToken());
				int r = Integer.parseInt(token.nextToken());
				if(r<l) {
					int aux = l;
					l=r;
					r=aux;
				}
				else {
					for(int i=l; i<=r; i++ ){
						army[i]=true;
					}
				}
				int i = l;
				while(i > 0 && army[i])
					i--;
				int j = r;
				while(j<=s && army[j]) {
					j++;
				}
				if(i==0)
					System.out.print("* ");
				else
					System.out.print(i+" ");
				
				if(j==s+1)
					System.out.print("*");
				else
					System.out.print(j);
				System.out.println();
			}
			System.out.println("-");
		}

	}

}
