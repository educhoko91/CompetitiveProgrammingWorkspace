import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double h = 0;
		double u = 0;
		double d = 0;
		double f = 0;
		
		
		while ((h = in.nextDouble()) != 0) {
			double actual = 0;
			boolean succes = false;
			int days = 0;
			u = in.nextDouble();
			d = in.nextDouble();
			f = (in.nextDouble()/100)*u;
			
			while(true) {
				days++;
				actual += u;
				if(actual > h) {
					succes = true;
					break;
				}
				//nigh
				actual -= d;
				if(actual < 0) {
					succes = false;
					break;
				}
				u -= f;
				if(u<0)
					u=0;
			}
			if(succes) {
				System.out.println("success on day "+days);
			}
			else {
				System.out.println("failure on day "+days);
			}
		}
		
		

	}

}
