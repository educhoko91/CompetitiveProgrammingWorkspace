import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static HashMap<Integer, ArrayList<Integer>> graph;
	public static HashMap<Integer, Boolean> visisted;
	public static int nodos;
	public static int inTll;
	public static int cases = 1;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		while ((n = in.nextInt()) != 0) {
			nodos = 0;
			graph = new HashMap<Integer, ArrayList<Integer>>();
			visisted = new HashMap<Integer, Boolean>();
			for (int i = 0; i < n; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				connectNodo(x, y);
				connectNodo(y, x);
			}
			int nodo, tll;
			while (!((nodo = in.nextInt()) == 0 & (tll = in.nextInt()) == 0)) {
				Set<Integer> set = new HashSet<Integer>();
				set.add(nodo);
				query(set, tll + 1);

				for (Integer x : visisted.keySet()) {
					if (visisted.get(x))
						inTll++;
					visisted.put(x, false);
				}
				System.out.println("Case " + cases + ": " + (nodos - inTll)
						+ " nodes not reachable from node " + nodo
						+ " with TTL = " + tll + ".");
				cases++;
				inTll = 0;
			}
			/*
			 * in.nextLine(); in.nextLine();
			 */

		}

	}

	public static void connectNodo(int x, int y) {
		if (graph.containsKey(x)) {
			graph.get(x).add(y);

		} else {
			ArrayList<Integer> aux = new ArrayList<Integer>();
			aux.add(y);
			graph.put(x, aux);
			visisted.put(x, false);
			nodos++;
		}

	}

	public static void query(Set<Integer> set, int ttl) {
		if (ttl == 0)
			return;
		Set<Integer> aux = new HashSet<Integer>();
		while (!set.isEmpty()) {
			int x = set.iterator().next();
			set.remove(x);
			if (graph.get(x) != null) {
				visisted.put(x, true);

				for (Integer y : graph.get(x)) {
					if (!visisted.get(y))
						aux.add(y);
				}
			}
		}
		query(aux, --ttl);
	}
}
