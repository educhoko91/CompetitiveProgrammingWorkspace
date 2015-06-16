import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

import com.sun.org.apache.regexp.internal.recompile;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int request = 0;
		int proporsal = 0;
		int cnd = 1;
		HashSet<String> requirements = new HashSet<String>();
		while((request=in.nextInt())!=0 | (proporsal=in.nextInt())!=0) {
			if(cnd!=1) {
				System.out.println();
			}
			in.nextLine();
			for(int i=0; i<request; i++) {
				requirements.add(in.nextLine());
			}
			Proporsal array[] = new Proporsal[proporsal];
			for(int i=0; i< proporsal; i++) {
				Proporsal aux = new Proporsal();
				
				aux.name=in.nextLine();
				aux.price=in.nextDouble();
				aux.mets=in.nextInt();
				aux.order = i;
				in.nextLine();
				int descount = 0;
				for(int j=0; j<aux.mets; j++) {
					in.nextLine();
				}
				if(request==0) 
					aux.compli=1;
				else
					aux.compli=(double)aux.mets;
				array[i]=aux;
			}
			
			Arrays.sort(array);
			
			/*for(Proporsal p:array) {
			 System.out.println(p.name+" "+p.compli+" "+p.price);
			}*/
			System.out.println("RFP #"+cnd);
			System.out.println(array[0].name);
			cnd++;
		}

	}

}

class Proporsal implements Comparable<Proporsal> {
	String name;
	double price;
	int mets;
	double compli;
	int order;
	@Override
	public int compareTo(Proporsal o) {
		if(o.compli!=compli) {
			return Double.compare(o.compli, compli);
		}
		else {
			return Double.compare(price, o.price);
		}
		
	}
}
