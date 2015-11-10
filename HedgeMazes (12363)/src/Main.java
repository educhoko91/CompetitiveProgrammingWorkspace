import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class Main {
	

	// FAST IO
	private static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() throws EOFException {
			if (numChars == -1)
				throw new EOFException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() throws EOFException {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String readString() throws EOFException {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public double nextDouble() throws EOFException {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}

		public long nextLong() throws EOFException {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() throws EOFException {
			return readString();
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
	
	public static ArrayList<ArrayList<Integer>> graph;
	
	
	
	public static void main(String args[]) throws Exception {
		InputReader in = new InputReader(System.in);
		int r,c,q;
		while(!(((r=in.nextInt())==0) & ((c=in.nextInt())==0) & ((q=in.nextInt())==0))) {
			graph = new ArrayList<ArrayList<Integer>>();
			init(r+1);
			initSet(r+1);
			for(int i=0; i<r+1; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			for(int i=0; i<c; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			findArticulationPointAndBridge(r);
			
			for(int i=0; i<q; i++) {
				System.out.println(isSameSet(in.nextInt(), in.nextInt())?"Y":"N");
			}
			System.out.println("-");
		}
	}
	
	/*
	 *
	 *  *********************************
	 *  * ARTICULATION POINT AND BRIDGE *
	 *  ********************************* 
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
					unionSet(u, v);
				}
				dfsLow[u] = Math.min(dfsLow[u], dfsLow[v]);	
			}
			else if(v!=dfsParent[u]) {
				dfsLow[u] = Math.min(dfsLow[u], dfsNum[v]);	
			}
		}
	}
	
	/*
	 * num = Numero de Vertices
	 */
	public static void findArticulationPointAndBridge(int num) {
		// cambiar dependiendo del indice
		for(int i=1; i<=num; i++) {
			if(!visit[i]) {
				dfsRoot = i;
				rootChildren=0;
				articulationPointAndBridge(dfsRoot);
				articulationVertex[dfsRoot] = (rootChildren>1);
			}
		}
	}
	
	
	/*
	 * 
	 * **************
	 * * UNION FIND *
	 * **************
	 * 
	 */
	
	public static int parent[];
	
	public static void initSet(int n) {
		parent = new int[n];
		for(int i=0; i<n; i++) {
			parent[i]=i;
		}
	}
	
	public static int findSet(int i) {
		if(parent[i]==i) {
			return i;
		}
		return findSet(parent[i]);
	}
	
	public static void unionSet(int i, int j) {
		parent[findSet(i)] = findSet(j);
	}
	
	public static boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}
	

}

