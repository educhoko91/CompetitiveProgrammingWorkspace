import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.InputMismatchException;


public class MainTimeLimit {

	static int wallCount;
	static int [][] m;
	public static void main(String[] args) throws Exception {
		InputReader in = new InputReader(System.in);
		try {
			while(true) {
				int n = in.nextInt();
				m = new int[2*(2*n)+1][2*(2*n+1)+1];
				/*for(int i=0; i<2*(2*n+1); i++) {
					m[2*(2*n)-1][i]=1;
				}*/
				wallCount=0;
				for(int i=1; i<=2*n-1; i++) {
					String line = in.next();
					for(int j=1; j<=n; j++) {
						if(i%2==0) {
							if(line.charAt(j-1)=='H') {
								mark(2*i,4*j-1);
								mark(2*i,4*j-2);
								mark(2*i,4*j);
								mark(2*i,4*j+1);
								mark(2*i,4*j+2);
							}
							else {
								mark(2*i-1,4*j);
								mark(2*i-2,4*j);
								mark(2*i,4*j);
								mark(2*i+1,4*j);
								mark(2*i+2,4*j);
							}
						}
						else {
							if(line.charAt(j-1)=='H') {
								mark(2*i,2*(2*j-1)-1);
								mark(2*i,2*(2*j-1)-2);
								mark(2*i,2*(2*j-1));
								mark(2*i,2*(2*j-1)+1);
								mark(2*i,2*(2*j-1)+2);
							}
							else {
								mark(2*i-1,2*(2*j-1));
								mark(2*i-2,2*(2*j-1));
								mark(2*i,2*(2*j-1));
								mark(2*i+1,2*(2*j-1));
								mark(2*i+2,2*(2*j-1));
							}
						}
						
						/*if(i%2==0) {
							if(line.charAt(j-1)=='H') {
								m[2*i][4*j-1]= 1;
								m[2*i][4*j-2]=1;
								m[2*i][4*j]=1;
								m[2*i][4*j+1]=1;
								m[2*i][4*j+2]=1;
							}
							else {
								m[2*i-1][4*j]=1;
								m[2*i-2][4*j]=1;
								m[2*i][4*j]=1;
								m[2*i+1][4*j]=1;
								m[2*i+2][4*j]=1;
							}
						}
						else {
							if(line.charAt(j-1)=='H') {
								m[2*i][2*(2*j-1)-1]=1;
								m[2*i][2*(2*j-1)-2]=1;
								m[2*i][2*(2*j-1)]=1;
								m[2*i][2*(2*j-1)+1]=1;
								m[2*i][2*(2*j-1)+2]=1;
							}
							else {
								m[2*i-1][2*(2*j-1)]=1;
								m[2*i-2][2*(2*j-1)]=1;
								m[2*i][2*(2*j-1)]=1;
								m[2*i+1][2*(2*j-1)]=1;
								m[2*i+2][2*(2*j-1)]=1;
							}
						}*/
							
					}
				}
				
				/*for(int i=0; i<2*(2*n)+1; i++) {
					for(int j=0; j<2*(2*n+1)+1; j++){
						System.out.print(m[i][j]+" ");
					}
					System.out.println();
				}
				System.out.println();*/
				initSet((2*(2*n)+1)*(2*(2*n+1)+1));
				int cnd = 0;
				for(int i=0; i<2*(2*n)+1; i++) {
					for(int j=0; j<2*(2*n+1)+1; j++){
						if(m[i][j]!=-1) {
							m[i][j]=cnd;
								if(i-1>=0 && m[i-1][j]!=-1)
									unionSet(cnd,m[i-1][j]);
								if(j-1>=0&&m[i][j-1]!=-1)
									unionSet(cnd,m[i][j-1]);
							cnd++;
						}
					}
				}
				/*for(int i=0; i<parent.length; i++) {
					System.out.print(parent[i]+" ");
				}
				System.out.println();
				System.out.println();
				System.out.println();*/
				
				System.out.println(numSets-1-wallCount);
				
				
			}
		}catch (IOException e) {
			
		}
	}
	
	public static void mark(int i, int j) {
		if(m[i][j]!=-1) {
			wallCount++;
			m[i][j]=-1;
		}
	}
	
	/*
	 * 
	 * **************
	 * * UNION FIND *
	 * **************
	 * 
	 * TEMPLATE: union
	 * 
	 */

	public static int parent[];
	public static int numSets;
	static HashSet<Integer> sets;
	public static void initSet(int n) {
		parent = new int[n];
		numSets = n;
		sets= new HashSet<Integer>(n);
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public static int findSet(int i) {
		if (parent[i] == i) {
			//sets.add(parent[i]);
			return i;
		}
		return findSet(parent[i]);
	}

	public static void unionSet(int i, int j) {
		if(!isSameSet(i, j)) numSets--;
		parent[findSet(i)] = findSet(j);
	}

	public static boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}
	
	public static int countSets() {
		
		for(int i=0; i<parent.length; i++) {
			int set = findSet(parent[i]);
			if(!sets.contains(set)) {
				sets.add(set);
			}
		}
		
		return sets.size();
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
