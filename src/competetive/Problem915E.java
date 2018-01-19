/**
 * http://codeforces.com/problemset/problem/915/E
 */
package competetive;
import java.util.Scanner;

public class Problem915E {
	public static void main(String[] args) {
		Scanner sentences = new Scanner (System.in);
		int daysRemaining = Integer.parseInt(sentences.nextLine());
		int noOfIntimations = Integer.parseInt(sentences.nextLine());
		String[] intimations = new String[noOfIntimations+1];
		for(int i = 1; i <= noOfIntimations; i++) {
			intimations[i] = sentences.nextLine();
		}
		sentences.close();
		System.out.println("Days Remaining: "+daysRemaining);
		System.out.println("Number of intimations: "+noOfIntimations);
		int a = daysRemaining;
		int b = daysRemaining - a;
		for(int i = 1; i <= noOfIntimations; i++) {
			String[] intimation = intimations[i].split(" ");
			if(Integer.parseInt(intimation[2]) == 2) {
				a = Integer.parseInt(intimation[1]) - Integer.parseInt(intimation[0]) + 1;
				b = daysRemaining - a;
			}
			else {
				a -= daysRemaining - (Integer.parseInt(intimation[1]) - (Integer.parseInt(intimation[0]) - 1));
				b = daysRemaining - a;
			}
			System.out.println(a+", "+b);
		}
	}
}
