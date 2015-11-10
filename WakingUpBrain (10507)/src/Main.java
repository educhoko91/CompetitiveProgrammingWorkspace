import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;


public class Main {
	
	public static void main(String[] args) throws Exception {
		InputReader in = new InputReader(System.in);
		try {
			while(true) {
				HashMap<Character, Nodo> graph = new HashMap<Character, Main.Nodo>();
				int n = in.nextInt();
				int m = in.nextInt();
				HashSet<Character> awake = new HashSet<Character>();
				HashSet<Character> slept = new HashSet<Character>();
				
				String line=in.next();
				for(int i=0; i<3;i++) {
					awake.add(line.charAt(i));
					graph.put(line.charAt(i), new Nodo(true));
				}
				for(int i=0; i<m; i++) {
					line = in.next();
					char a = line.charAt(0);
					char b = line.charAt(1);
					if(!graph.containsKey(a)) {
						graph.put(a, new Nodo());
					}
					if(!graph.containsKey(b)) {
						graph.put(b, new Nodo());
					}
					
					graph.get(a).ad.add(b);
					graph.get(b).ad.add(a);
					
					slept.add(a);
					slept.add(b);
				}
				slept.removeAll(awake);
				int lastSize = -1;
				boolean active = true;
				int years = 0;
				while(true) {
					if(lastSize == slept.size() || slept.isEmpty())
						break;
					HashSet<Character> aux = new HashSet<Character>();
					for(Character c: slept) {
						int activationCount=0;
						for(Character ac: graph.get(c).ad) {
							if(graph.get(ac).awake)
								activationCount++;
						}
						if(activationCount>=3) {
							aux.add(c);
						}
					}
					for(Character c: aux) {
						graph.get(c).awake =true;
					}
					lastSize = slept.size();
					slept.removeAll(aux);
					awake.addAll(aux);
					years++;
					
					
				}
				if(active && awake.size()==n)
					System.out.println("WAKE UP IN, "+years+", YEARS");
				else
					System.out.println("THIS BRAIN NEVER WAKES UP");
				
			}
			
			
		}catch (IOException e) {
			
		}
		
		
	}
	
	static class Nodo {
		ArrayList<Character> ad = new ArrayList<Character>();
		boolean awake=false;
		public Nodo() {
			
		}
		
		public Nodo(boolean awake) {
			this.awake = awake;
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
