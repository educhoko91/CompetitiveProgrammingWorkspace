import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Main {

	
	public static void main(String[] args) throws Exception {
		InputReader in = new InputReader(System.in);
		try {
			while (true) {
				int n = in.nextInt();
				Nodo trie = new Nodo('*');
				for (int i = 0; i < n; i++) {
					trie.prefixes = 0;
					addWord(trie, new StringBuilder(in.next()));

				}
				prepSum(trie);
				
				System.out.printf("%.2f\n",((double)getSum(trie))/(double)n);
			}
		} catch (IOException e) {
		}
	}

	/*
	 * 
	 * ********
	 * * TRIE * ********
	 * 
	 * TEMPLATE: trie
	 */


	public static void addWord(Nodo vertex, StringBuilder word) {
		if (word.length() == 0) {
			vertex.words++;
		} else {

			int k = word.charAt(0) - 'a';
			if (!vertex.edges.containsKey(k)) {
				vertex.edges.put(k, new Nodo(word.charAt(0)));
			}
			addWord(vertex.edges.get(k), word.deleteCharAt(0));
		}
	}

	public static void propagate(Nodo vertex) {
		for (Nodo n : vertex.edges.values()) {
			n.prefixes++;
			propagate(n);
		}
	}

	public static void prepSum(Nodo vertex) {
		if(vertex.edges.size()==1 && vertex.letter=='*')
			vertex.prefixes++;
		if(vertex.edges.size()>1) {
			for(Nodo n: vertex.edges.values()) {
				n.prefixes=vertex.prefixes+1;
				prepSum(n);
			}
		}
		else if(vertex.edges.size()==1 && vertex.words>0) {
			vertex.edges.values().iterator().next().prefixes=vertex.prefixes+1;
			prepSum(vertex.edges.values().iterator().next());
		}
		else {
		
			for(Nodo n: vertex.edges.values()) {
				n.prefixes=vertex.prefixes;
				prepSum(n);
			}
		}
		
	}
	
	public static int getSum(Nodo vertex) {

		if(vertex.edges.size()==0) {
			return vertex.prefixes;
		}
		int sum = 0;
		if(vertex.words>0) {
			sum+=vertex.prefixes;
		}
		for(Nodo n: vertex.edges.values()){
			sum+=getSum(n);
		}
		return sum;
	}

	/*
	 * public static int countWords(Nodo vertex, StringBuilder word) { int k =
	 * word.charAt(0) - 'a'; if (word.length() == 0) { return vertex.words; }
	 * else if (!vertex.edges.containsKey(k)) { return 0; } else { return
	 * countWords(vertex.edges[k], word.deleteCharAt(0)); } }
	 */

	/*
	 * public static int countPrefixes(Nodo vertex, StringBuilder prefix) { int
	 * k = prefix.charAt(0) - 'a'; if (prefix.length() == 0) { return
	 * vertex.prefixes; } else if (vertex.edges[k] == null) { return 0; } else {
	 * return countPrefixes(vertex.edges[k], prefix.deleteCharAt(0)); } }
	 */

	static class Nodo {
		int words;
		char letter;
		int prefixes;
		HashMap<Integer, Nodo> edges = new HashMap<Integer, Main.Nodo>();

		public Nodo(char letter) {
			this.words = 0;
			this.prefixes = 0;
			this.letter=letter;
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
