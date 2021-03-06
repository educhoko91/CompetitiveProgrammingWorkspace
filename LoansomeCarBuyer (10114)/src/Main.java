import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

	public strictfp static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int duration = 0;
		double down = 0;
		double payment = 0;
		double amount = 0;
		double loan = 0;
		double value = 0;
		double deprInit = 0;
		int numDepr = 0;

		while ((duration = in.nextInt()) > 0) {
			HashMap<Integer, Double> depr = new HashMap<Integer, Double>();

			down = in.nextDouble();
			amount = in.nextDouble();
			numDepr = in.nextInt();
			payment = amount / duration;
			value = amount;
			loan = amount;
			int aux = 0;
			double auxDeprAnt = 0;
			for (int i = 0; i < numDepr; i++) {
				depr.put(in.nextInt(), in.nextDouble());
			}

			value = (amount + down) * (1 - depr.get(0));
			int i = 0;
			int j = 0;
			while (loan > value) {
				i++;
				if (depr.containsKey(i))
					j=i;
				loan -= payment;
				value *= (1 - (depr.get(j)));
				
			}
			if (i==1)
				System.out.println(i+" month");
			else
				System.out.println(i+" months");

		}

	}

}
