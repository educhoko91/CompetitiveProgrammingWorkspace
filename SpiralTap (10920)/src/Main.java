import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) throws Exception {
		InputReader in = new InputReader(System.in);
		long n, m;
		while ((n = in.nextLong()) != 0 && (m = in.nextLong()) != 0) {
			int[] r = findInSpiral(n, m);
			System.out.println("Line = " + (n - r[0]) + ", column = "
					+ (r[1] + 1) + ".");
		}
	}

	public static int[] findInSpiral(long n, long m) {
		long num = 1;
		int center = (int) (((double) n) / 2.0);
		int positioni = center;
		int positionj = center;
		int[] orderi = { -1, 0, 1, 0 };
		int[] orderj = { 0, -1, 0, 1 };
		int cnd = 0;
		int iter = 1;
		int cndIter = 0;
		if (num == m) {
			return new int[] { positioni, positionj };
		}
		num++;
		while (num <= n * n) {

			for (int i = 0; i < iter && num <= n * n; i++) {
				positioni += orderi[cnd];
				positionj += orderj[cnd];
				if (num == m) {
					return new int[] { positioni, positionj };
				}
				num++;
			}
			cndIter++;
			if (cndIter == 2) {
				iter++;
				cndIter = 0;
			}
			cnd++;
			if (cnd == 4) {
				cnd = 0;
			}
		}
		return new int[] { positioni, positionj };
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

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
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

		public int nextInt() {
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

		public String readString() {
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

		public double nextDouble() {
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

		public long nextLong() {
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

		public String next() {
			return readString();
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}

}
