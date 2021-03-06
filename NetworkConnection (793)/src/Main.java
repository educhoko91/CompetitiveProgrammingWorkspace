import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

	static int parent[], rank[];
	
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
		in.nextLine();
		for(int test=0; test<tests; test++) {
			int n = in.nextInt();
			int success = 0, unsucess = 0;
			
			parent = new int[n];
			rank = new int[n];
			
			for(int i=0; i<n; i++)
				parent[i]=i;
			in.nextLine();
			StringTokenizer token = new StringTokenizer(in.nextLine());
			while(token.countTokens()>1) {
				if(token.nextToken().equals("c")) {
					union(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1);
				}
				else {
					if(find(Integer.parseInt(token.nextToken())-1)==find(Integer.parseInt(token.nextToken())-1))
						success++;
					else
						unsucess++;
				}
				try {
				token = new StringTokenizer(in.nextLine());
				}
				catch (Exception e) {
					break;
				}
			}
			System.out.println(success+","+unsucess);
			if(test<tests-1)
				System.out.println();
			
		}
		
	}
	
	public static int find(int x) {
		if(parent[x]!=x) parent[x]=find(parent[x]);
		return parent[x];
	}
	
	public static void union(int x, int y) {
		int px = find(x), py=find(y);
		if(rank[px]>rank[py])
			parent[py]=px;
		else {
			parent[px]=py;
			if(rank[px]==rank[py])
				rank[py]++;
		}
			
	}
}
