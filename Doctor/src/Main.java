import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();

		for (int test = 0; test < cases; test++) {
			int n = in.nextInt();
			int m = in.nextInt();
			Visitor[] visitors = new Visitor[n];
			ArrayList<Queue<Visitor>> offices = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				Queue<Visitor> office = new LinkedList<>();
				offices.add(office);
			}
			for (int i = 0; i < n; i++) {
				Visitor v = new Visitor();
				v.t = in.nextInt();
				v.k = in.nextInt();
				for (int j = 0; j < v.k; j++) {
					v.q.add(in.nextInt() - 1);
				}
				visitors[i] = v;
			}
			int totalT = 1;
			for (int i = 0; i < 1000001; i++) {
				for (Visitor v : visitors) {
					if (!v.exist && v.t == i) {
						if (!v.q.isEmpty()) {
							int o = v.q.poll();
							offices.get(o).add(v);
							v.t++;
						}
					}
				}
				/*
				 * for (Queue<Visitor> o : offices) { if (!o.isEmpty()) {
				 * Visitor v = o.poll(); if(v.t<i) { v.t=i; } v.t++; } }
				 */
			}

			int max = 0;

			for (Queue<Visitor> o : offices) {
				if (max < o.size()) {
					max = o.size();
				}
			}

			System.out.println(max);

		}

	}

}

class Visitor {
	int t;
	int k;
	boolean exist = false;
	Queue<Integer> q = new LinkedList<>();
}
