/**
 * http://codeforces.com/problemset/problem/915/E
 *
 *
Input:

4
6
1 2 1
3 4 1
2 3 2
1 3 2
2 4 1
1 4 2

Output:
2
0
2
3
1
4

Verdict:
Time limit exceeded on test 4
 */
package competetive;
import java.util.Scanner;

public class Problem915E {
	public static void main(String[] args) {
		Scanner sentences = new Scanner (System.in);
		int daysRemaining = Integer.parseInt(sentences.nextLine());
		int noOfIntimations = Integer.parseInt(sentences.nextLine());
		int[] output = new int[noOfIntimations+1];
		int[] wd = new int[daysRemaining+1];
		int totalWD = daysRemaining;
		String[] intimations = new String[noOfIntimations+1];
		// Mark all days as WD by default
		for(int i = 1; i <= daysRemaining; i++) {
			wd[i] = 1;
		}
		for(int i = 1; i <= noOfIntimations; i++) {
			intimations[i] = sentences.nextLine();
			// intimation = {0: startDay, 1: endDay, 2: wd/nwd}
			String[] intimation = intimations[i].split(" ");
			for(int j = Integer.parseInt(intimation[0]); j <= Integer.parseInt(intimation[1]); j++) {
				if(Integer.parseInt(intimation[2]) == 2 && wd[j] == 0) {
					wd[j] = 1;
					totalWD += 1;
				}
				else if(Integer.parseInt(intimation[2]) == 1 && wd[j] == 1) {
					wd[j] = 0;
					totalWD -= 1;
				}
			}
			output[i] = totalWD;
		}
		for(int i = 1; i < output.length; i++) {
			System.out.println(output[i]);
		}
		sentences.close();
	}
}
