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
package sample.problem915E;
import java.util.Scanner;

public class Problem915E {
	public static void main(String[] args) {
		Scanner sentences = new Scanner (System.in);
		int daysRemaining = sentences.nextInt();
		int noOfIntimations = sentences.nextInt();
		int[] output = new int[noOfIntimations+1];
		int[] wd = new int[daysRemaining+1];
		int totalWD = daysRemaining;
		// Mark all days as WD by default
		for(int i = 1; i <= daysRemaining; i++) {
			wd[i] = 1;
		}
		for(int i = 1; i <= noOfIntimations; i++) {
			int[] intimations = new int[3];
			intimations[0] = sentences.nextInt();
			intimations[1] = sentences.nextInt();
			intimations[2] = sentences.nextInt();
			// intimation = {0: startDay, 1: endDay, 2: wd/nwd}
			for(int j = intimations[0]; j <= intimations[1]; j++) {
				if(intimations[2] == 2 && wd[j] == 0) {
					wd[j] = 1;
					totalWD += 1;
				}
				else if(intimations[2] == 1 && wd[j] == 1) {
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
