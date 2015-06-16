import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);
		String[] line1 = reader.readLine().split(" ");
		
		int n = Integer.parseInt(line1[0]);
		long k = Long.parseLong(line1[1]);
		long cnd = 0;
		for(int i = 0; i<n; i++) {
			long x = Long.parseLong(reader.readLine());
			if(x%k==0)
				cnd++;
		}
		System.out.println(cnd);

	}

}
