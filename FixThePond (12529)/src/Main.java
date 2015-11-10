import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {
	
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		InputReader in = new InputReader(System.in);
		try {
			while(true) {
				int n = in.nextInt();
				int rows=2*n, cols =2*n+1; 
				graph = new int[(rows)*(cols)+1][4];
				visited = new boolean[(rows)*(cols)+1];
				visited[0]=true;
				int cnd = 1;
				for(int i=1; i<=rows; i++) {
					for(int j=1; j<=cols; j++) {
						if(i-1>0) {
							graph[cnd][0] = cnd-cols;
						}
						if(j-1>0) {
							graph[cnd][1]= cnd-1;
						}
						if(j+1<=cols) {
							graph[cnd][2]= cnd+1;
						}
						if(i+1<=rows) {
							graph[cnd][3]= cnd+cols;
						}
						cnd++;
					}
				}
				
				for(int i=1; i<=2*n-1; i++) {
					String line = in.next();
					for(int j=1; j<=n; j++) {
						if(i%2==0) {
							if(line.charAt(j-1)=='H') {
								graph[cols*(i-1)+2*j][3]=0;
								if(cols*(i-1)+2*j+cols < graph.length)
									graph[cols*(i-1)+2*j+cols][0]=0;
								if(cols*(i-1)+2*j+1 < graph.length)
									graph[cols*(i-1)+2*j+1][3]=0;
								if(cols*(i-1)+2*j+1+cols < graph.length)
									graph[cols*(i-1)+2*j+1+cols][0]=0;
							}
							else {
								graph[cols*(i-1)+2*j][2]=0;
								if(cols*(i-1)+2*j+1 < graph.length)
									graph[cols*(i-1)+2*j+1][1]=0;
								if(cols*(i-1)+2*j+cols < graph.length)
									graph[cols*(i-1)+2*j+cols][2]=0;
								if(cols*(i-1)+2*j+1+cols < graph.length)
									graph[cols*(i-1)+2*j+1+cols][1]=0;
							}
						}
						else {
							if(line.charAt(j-1)=='H') {
								graph[cols*(i-1)+2*j-1][3]=0;
								if(cols*(i-1)+2*j-1+cols < graph.length)
									graph[cols*(i-1)+2*j-1+cols][0]=0;
								if(cols*(i-1)+2*j-1+1 < graph.length)
									graph[cols*(i-1)+2*j-1+1][3]=0;
								if(cols*(i-1)+2*j-1+1+cols < graph.length)
									graph[cols*(i-1)+2*j-1+1+cols][0]=0;
								
							}
							else {
								graph[cols*(i-1)+2*j-1][2]=0;
								if(cols*(i-1)+2*j-1+1<graph.length)
									graph[cols*(i-1)+2*j-1+1][1]=0;
								if(cols*(i-1)+2*j-1+cols<graph.length)
									graph[cols*(i-1)+2*j-1+cols][2]=0;
								if(cols*(i-1)+2*j-1+1+cols<graph.length)
									graph[cols*(i-1)+2*j-1+1+cols][1]=0;
							}
						}
					}
				}
				
				
				int res = 0;;
				for(int i=1; i<graph.length; i++) {
					if(!visited[i]) {
						res++;
						bfs(i);
					}
				}
				
				
				System.out.println(res-1);
				
				
				
			}
		} catch (IOException e) {
			
		}
		
		
	}
	
	public static void bfs(int nodo) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(nodo);
		while(!queue.isEmpty()) {
			int x = queue.poll();
			visited[x]=true;
			for(int i=0; i<4; i++) {
				if(!visited[graph[x][i]]) {
					queue.add(graph[x][i]);
				}
			}
		}
	}

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

}
