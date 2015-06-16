import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String line = in.nextLine();
			/*StringBuilder clearLine = new StringBuilder();
			for(char c:line.toCharArray()) {
				if(Character.isAlphabetic(c) || c==' ') {
					clearLine.append(c);
				}
			}*/
			boolean inWord = false;
			long cnd = 0;
			
			for(char c:line.toCharArray()) {
				if(Character.isAlphabetic(c))
					inWord=true;
				if((c==' '||!Character.isAlphabetic(c))&&inWord) {
					cnd++;
					inWord= false;
				}
			}
			System.out.println(cnd);
			
			
			/*line = line.replaceAll("\\d", "");
			Matcher m = Pattern.compile(" ?\\w+(.| )").matcher(line);
			long cnd = 0;
			while(m.find()) 
					cnd++;
				
				
			System.out.println(cnd);*/
			
		}

	}

}
