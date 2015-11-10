import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		HashMap<Character, String> decToBrai = new HashMap<Character, String>();
		HashMap<String, Character> braiToDec = new HashMap<String, Character>();
		decToBrai.put('1', "*...");
		decToBrai.put('2', "*.*.");
		decToBrai.put('3', "**..");
		decToBrai.put('4', "**.*");
		decToBrai.put('5', "*..*");
		decToBrai.put('6', "***.");
		decToBrai.put('7', "****");
		decToBrai.put('8', "*.**");
		decToBrai.put('9', ".**.");
		decToBrai.put('0', ".***");

		braiToDec.put("*...", '1');
		braiToDec.put("*.*.", '2');
		braiToDec.put("**..", '3');
		braiToDec.put("**.*", '4');
		braiToDec.put("*..*", '5');
		braiToDec.put("***.", '6');
		braiToDec.put("****", '7');
		braiToDec.put("*.**", '8');
		braiToDec.put(".**.", '9');
		braiToDec.put(".***", '0');
		int n;
		while ((n = in.nextInt()) != 0) {
			if ("S".equals(in.next())) {
				String line = in.next();
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < n; j++) {
						char c = line.charAt(j);
						if(j==n-1)
							sb.append(decToBrai.get(c).substring(i*2,(i*2)+2));
						else {
							sb.append(decToBrai.get(c).substring(i*2,(i*2)+2)).append(" ");
						}
						
					} 
					sb.append("\n");
				}
				for(int i=0; i<n; i++) {
					if(i==n-1)
						sb.append("..");
					else {
						sb.append("..").append(" ");
					}
				}
				System.out.println(sb.toString());
			}
			else {
				in.nextLine();
				String line1 = in.nextLine();
				String line2 = in.nextLine();
			
				for(int i=0; i<n; i++) {
					String aux = line1.substring(3*i, 3*i+2)+line2.substring(3*i, 3*i+2);
					System.out.print(braiToDec.get(aux));
				}
				System.out.println();
				in.nextLine();
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
