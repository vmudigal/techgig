/**
 * 
 * In DPS School, Cadbury bars have to be distributed to children waiting in a queue. Each Cadbury bar is rectangular in shape. Consider its side lengths are integer values. 

The distribution procedure is as follows:- 

1. If bar is not square in shape, then the largest possible square piece of Cadbury is broken and given to the first child in queue.
2. If bar is square in shape, then complete bar is given to the first child in queue.

Once a child receives his share of Cadbury, he leaves the queue. The remaining portion of the Cadbury bar is dealt in same fashion and the whole or a portion of it is given to the next child in the queue.

School has got a carton of Cadbury bars to be distributed among the children all over the School. The Cadbury bars in the carton are of different sizes. A bar of length i and breadth j is considered to be different from a bar of length j and breadth i.
For every i such that M<=i<=N and every j such that P<=j<=Q (where M, N, P and Q are integers). Each Cadbury bar in carton is unique in length (i) and breath(j).

Given the values of M, N, P and Q (where M, N values are the ranges for length of Cadbury and P, Q values are the ranges for breadth of Cadbury). Find the number of children who will receive Cadbury from the carton. 

Input/Output Specifications Input Specification: 
M, N, P, Q are of integer type (M, N values are the ranges for length of Cadbury bar. P, Q values are the ranges for breadth of Cadbury bar).

Output Specification: 
Number of children who will receive Cadbury bar from the carton.
ExamplesM = 5, N = 6, P = 3, Q=4 
Here, i can be from 5 to 6 and j can be from 3 to 4. So the four bars will be in carton of sizes 5x3, 5x4, 6x3, 6x4.

First we choose a cadbury bar of size 5x3 
→ first child would receive 3x3 portion ( remaining 2x3 portion ) 
→ next child would receive 2x2 portion ( remaining 2x1 portion ) 
→ now the remaining portion are 2 square pieces of (1x1), which can be given to 2 more children 

So the Cadbury bar with the size of 5x3 can be distributed  to 4 children.

Similarly we can find out number of children for rest of the combinations (i.e. 5x4, 6x3, 6x4) in the given range as follows

Cadbury bar with the size of 5x3 can be distributed  to 4 children.
Cadbury bar with the size of 5x4 can be distributed  to 5 children.
Cadbury bar with the size of 6x3 can be distributed  to 2 children.
Cadbury bar with the size of 6x4 can be distributed  to 3 children.

So the whole carton can be distributed among 14 children. Hence the output will be 14.


Instructions:
 
 1) Do not write main function. 
 2) Do not print any variables in the code. 
 3) You need to return the required output from the given function. 
 4) Do not change the function and parameter names given in editor code. 
 5) Return type must be the same as mentioned in the problem statement. 
 6) When you submit your code, 10 test cases of different complexity level are executed in the background and marks are given based on number of test cases passed. 
 7) If you do not plan to complete the code in one sitting, then please save your work on a local machine. The code is saved only when it has been submitted using Submit button. 
 8 ) Only two submissions are allowed. 


 * @author Vijayendra Mudigal
 * 
 */
package techgig.cadburyBarPuzzle;

public class CandidateCode {
	public int cadbury(int input1, int input2, int input3, int input4) {
		int total = 0;
		if (input2 >= input1 && input4 >= input3 && input1 > 0 && input2 > 0
				&& input3 > 0 && input4 > 0) {
			for (int row = input1; row <= input2; row++) {
				for (int column = input3; column <= input4; column++) {
					int remainingRow = row, remainingColumn = column;
					System.out.println(row + "x" + column);
					while (true) {
						if (remainingRow == 0 && remainingColumn == 0) {
							break;
						}
						if (remainingRow > remainingColumn) {
							remainingRow = remainingRow - remainingColumn;
							total = total + 1;
						}
						if (remainingRow < remainingColumn) {
							remainingColumn = remainingColumn - remainingRow;
							total = total + 1;
						}
						if (remainingRow == remainingColumn) {
							remainingRow = 0;
							remainingColumn = 0;
							total = total + 1;
						}
					}
				}
			}
		}
		return total;
	}
}