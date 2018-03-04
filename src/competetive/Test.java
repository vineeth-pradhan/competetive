/**
 * 
 * @author Vineeth
 *
 * TEST - Life, the Universe, and Everything
 * Your program is to use the brute-force approach in order to find the Answer to Life, 
 * the Universe, and Everything. More precisely... rewrite small numbers from input to 
 * output. Stop processing input after reading in the number 42. All numbers at input 
 * are integers of one or two digits.
 *
 */
package competetive;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Test {
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>();
		Scanner reader = new Scanner(System.in);
		reader.useDelimiter(System.getProperty("line.separator"));
		while(reader.hasNextInt()) {
			int number = reader.nextInt();
			if(number != 42) arr.add(number);
			else break;
		}
		for(int i: arr) {
			System.out.println(i);
		}
		reader.close();
	}
}
