import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

	static ArrayList<Pair> critical;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()) {
			int n = in.nextInt();
			in.nextLine();
			init(n);
			for(int i=0; i<n; i++) {
				
				String line[] = in.nextLine().replaceAll("[()]", "").split(" ");
				for(int j=2; j<line.length; j++) {
					int a = Integer.parseInt(line[0]);
					int b = Integer.parseInt(line[j]);
					graph.get(a).add(b);
					graph.get(b).add(a);
				}
			}
			
			critical = new ArrayList<Pair>();
			findArticulationPointAndBridge();
			System.out.println(critical.size()+" critical links");
			Collections.sort(critical, new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					if(o1.a==o2.a) {
						return Integer.compare(o1.b, o2.b);
					}
					return Integer.compare(o1.a, o2.a);
				}
			});
			
			for(Pair p: critical) {
				System.out.println(p.a+" - "+p.b);
			}
			System.out.println();
			
		}
	}
	
	static class Pair {
		int a;
		int b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
	}
	/*
	 *
	 *  *********************************
	 *  * ARTICULATION POINT AND BRIDGE *
	 *  *********************************
	 *  
	 *  TEMPLATE: bridge
	 *
	 */

	public static int[] dfsNum;
	public static int[] dfsLow;
	public static int dfsCounter;
	public static int[] dfsParent;
	public static int dfsRoot;
	public static int rootChildren;
	public static boolean[] visit;
	public static boolean[] articulationVertex;
	public static ArrayList<ArrayList<Integer>> graph;

	/*
	 * num = Numero de Vertices (Nodos)
	 */
	public static void init(int num) {
		dfsLow = new int[num];
		dfsNum = new int[num]; 
		visit = new boolean[num];
		articulationVertex = new boolean[num];
		dfsParent = new int[num];
		dfsCounter = 0;
		dfsRoot = 0;
		rootChildren = 0;
		graph = new ArrayList<ArrayList<Integer>>();
		// cambiar dependiendo del indice
		for (int i = 0; i < num; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}

	public static void articulationPointAndBridge(int u) {
		dfsCounter++;
		dfsNum[u] = dfsCounter;
		dfsLow[u] = dfsCounter;
		visit[u] = true;
		for (Integer v : graph.get(u)) {
			if (!visit[v]) {
				dfsParent[v] = u;
				if (u == dfsRoot)
					rootChildren++;

				articulationPointAndBridge(v);

				/*
				 * Verifica si es articulacion
				 */
				if (dfsLow[v] >= dfsNum[u]) {
					articulationVertex[u] = true;
				}
				/*
				 * Verifica si es un puente
				 */
				if (dfsLow[v] > dfsNum[u]) {
					//System.out.printf(" Edge (%d, %d) is a bridge\n", u, v);
					if(v<u)
						critical.add(new Pair(v, u));
					else
					critical.add(new Pair(u, v));
				}
				dfsLow[u] = Math.min(dfsLow[u], dfsLow[v]);
			} else if (v != dfsParent[u]) {
				dfsLow[u] = Math.min(dfsLow[u], dfsNum[v]);
			}
		}
	}

	public static void findArticulationPointAndBridge() {
		// cambiar dependiendo del indice
		for (int i = 0; i < graph.size(); i++) {
			if (!visit[i]) {
				dfsRoot = i;
				rootChildren = 0;
				articulationPointAndBridge(dfsRoot);
				articulationVertex[dfsRoot] = (rootChildren > 1);
			}
		}
	}

}
