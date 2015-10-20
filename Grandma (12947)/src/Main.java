import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		main: while (in.hasNextLine()) {
			StringBuilder sb= new StringBuilder();
			String line = in.nextLine();
			StringTokenizer tokens = new StringTokenizer(line);
			int size = tokens.countTokens() + 2;
			ArrayList<Integer> arr = new ArrayList<Integer>();
			int[][] graf = new int[size][size];
			Set<Integer> hojas = new HashSet<Integer>();
			Set<Integer> ramas = new HashSet<Integer>();
			for (int i = 0; i < size; i++) {
				hojas.add(i);
			}
			for (int i = 0; i < size - 2; i++) {
				int x = Integer.parseInt(tokens.nextToken());
				if (x >= size) {
					System.out.println("impossible");
					if (in.hasNextLine()) {
						System.out.println("*");
					}
					continue main;
				}
				ramas.add(x);
				arr.add(x);
			}
			hojas.removeAll(ramas);
			int x = 0;
			while (!arr.isEmpty()) {
				int elem = hojas.iterator().next();
				x = arr.get(0);
				graf[x][elem] = 1;
				graf[elem][x] = 1;
				hojas.remove(elem);
				arr.remove(0);
				if (!arr.contains(x)) {
					hojas.add(x);
				}
			}
			
			int elem = hojas.iterator().next();
			hojas.remove(elem);
			elem = hojas.iterator().next();
			graf[x][elem] = 1;
			graf[elem][x] = 1;
			hojas.remove(elem);
			if(!hojas.isEmpty()|| elem!=size-1) {
				System.out.println("impossible");
				if (in.hasNextLine()) {
					System.out.println("*");
				}
					continue main;
			}
			
			System.out.println(size);
			for (int i = 0; i < size; i++) {
				boolean first = true;
				for (int j = 0; j < size; j++) {
					if (graf[i][j] == 1) {
						if (first) {
							sb.append(j);
							first = false;
						} else {
							sb.append(" " + j);
						}
					}
				}
				sb.append("\n");
				
			}
			if (in.hasNextLine()) {
				sb.append("*\n");
			}
			System.out.println(sb.toString());
		}
	}

}
