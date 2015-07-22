import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		//InputReader in = new InputReader(System.in);
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		
		if(equivalent(a, b)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}

	}

	public static boolean equivalent(String a, String b) {
		if (a.equals(b)) {
			return true;
		} 
		if (a.length() % 2 == 0) {
			/*String a1 = a.substring(0, a.length() / 2);
			String a2 = a.substring(a.length() / 2);
			String b1 = b.substring(0, a.length() / 2);
			String b2 = b.substring(a.length() / 2);*/
			return ((equivalent(a.substring(0, a.length() / 2), b.substring(a.length() / 2)) && equivalent(a.substring(a.length() / 2), b.substring(0, a.length() / 2))) || (equivalent(a.substring(0, a.length() / 2), b.substring(0, a.length() / 2)) && equivalent(a.substring(a.length() / 2), b.substring(a.length() / 2))));
			/*return (equivalent(a1, b1) && equivalent(a2, b2))
					|| (equivalent(a1, b2) && equivalent(a2, b1));*/

		}
		return false;

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
