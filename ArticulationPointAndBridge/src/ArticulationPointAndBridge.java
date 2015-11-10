import java.util.ArrayList;


public class ArticulationPointAndBridge {

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
	 * num = Numero de Vertices
	 */
	public static void init(int num) {
		dfsLow = new int[num];
		dfsNum = new int[num];
		visit = new boolean[num];
		articulationVertex = new boolean[num];
		dfsParent = new int[num];
		dfsCounter=0;
		dfsRoot=0;
		rootChildren=0;
		graph = new ArrayList<ArrayList<Integer>>();
		// cambiar dependiendo del indice
		for(int i=0; i<num; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}
	
	public static void articulationPointAndBridge(int u) {
		dfsCounter++;
		dfsNum[u]=dfsCounter;
		dfsLow[u]=dfsCounter;
		visit[u]=true;
		for(Integer v: graph.get(u)) {
			if(!visit[v]) {
				dfsParent[v]=u;
				if(u==dfsRoot)
					rootChildren++;
				
				articulationPointAndBridge(v);
				
				/*
				 * Verifica si es articulacion
				 */
				if(dfsLow[v] >= dfsNum[u]) {
					articulationVertex[u] = true;
				}
				/*
				 * Verifica si es un puente
				 */
				if(dfsLow[v] > dfsNum[u]) {
					//System.out.printf(" Edge (%d, %d) is a bridge\n", u, v);
				}
				dfsLow[u] = Math.min(dfsLow[u], dfsLow[v]);	
			}
			else if(v!=dfsParent[u]) {
				dfsLow[u] = Math.min(dfsLow[u], dfsNum[v]);	
			}
		}
	}
	

	public static void findArticulationPointAndBridge() {
		// cambiar dependiendo del indice
		for(int i=0; i<graph.size(); i++) {
			if(!visit[i]) {
				dfsRoot = i;
				rootChildren=0;
				articulationPointAndBridge(dfsRoot);
				articulationVertex[dfsRoot] = (rootChildren>1);
			}
		}
	}
	
	
}
