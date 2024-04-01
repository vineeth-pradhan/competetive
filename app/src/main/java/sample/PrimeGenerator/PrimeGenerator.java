/**
 * http://www.spoj.com/problems/PRIME1/
 */
package sample.PrimeGenerator;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class PrimeGenerator {
	static boolean isPrime(int num) {
		if(num == 1 || num == 0) return false;
		for(int i = 2; i*i <= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int noOfTests = reader.nextInt();
		List<String> results = new ArrayList<String>();
		while(noOfTests != 0) {
			int start = reader.nextInt();
			int end = reader.nextInt();
			for(Integer i = start; i <= end; i++) {
				if(isPrime(i)) {
					results.add((String) i.toString());
				}
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
