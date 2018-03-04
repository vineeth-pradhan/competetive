package competetive;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class PrimeGenerator {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int noOfTests = reader.nextInt();
		List<String> results = new ArrayList<String>();
		while(noOfTests != 0) {
			int start = reader.nextInt();
			int end = reader.nextInt();
			for(Integer j = start; j <= end; j++) {
				boolean flag = true;
				if(j == 2) { results.add((String) j.toString()); continue;}
				if(j % 2 == 0 || j == 1) { continue; }
				for(int k = 3; k <= j/2; k++) {
					if (j != k && j % k == 0) { flag = false; break; }
				}
				if(flag == true) { results.add((String) j.toString()); }
			}
			results.add("");
			noOfTests--;
		}
		reader.close();
		for(String item: results) {
			System.out.println(item);
		}
	}
}