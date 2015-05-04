
/*****************************************************************************************************************************
 *
 * A teacher play a interesting game in the class. He select some n students of the class and make a row of these 
 * n students(where 0<=n<=1000). He makes the row randomly. He puts a very interesting question to the remaining 
 * student of the class. He told them to select some of the student out of the row such that when we make the 
 * string using the first character of their names ( consider only the first name) that string becomes a palindrome.
 * 
 * (Palindrome is a string which is equal to the reverse of itself for example ASPDPSA) of the longest length possible.
 * 
 * The condition is that the string which is constructed using the first character of students should be constructed
 * in a way that the characters should come in the same order in which the students are standing in the row. 
 * 
 * You have to answer the length of longest possible palindrome. Input/Output Specifications
 * 
 * Input Specification:
 * a list of students
 *
 * Output Specifications :
 * length of longest palindrome constructed using the first characters of students in any sublist of the input student list
 * Examples
 * Lets teacher selects following student to make row.
 * 
 * {Bharti, Bharat, Akash, Bhavya, Chand, Brijesh ,Chetak, Arvind, Bhavna} and put the question to select some student out of the row.
 *
 * One students select- Bharti, Bharat, Bhavya, Brijesh, Bhavna
 * String- BBBBB : This is a palindrome of length 5
 *
 * Another student select- Bharti, Bharat, Chand, Brijesh, Bhavna
 * String- BBCBB : This is a palindrome of length 5
 *
 * Third student selects- Bharti, Akash, Bhavya, Chand, Brijesh, Arvind, Bhavna
 * String- BABCBAB : This is a palindrome of length 7 ( longest possible for this example)
 *
 *
 * @author Vijayendra Mudigal
 *
 *
 ******************************************************************************************************************************/

package techgig.palindromeLengthPuzzle;

public class CandidateCode {

	/****************************************
	 * 
	 * PalindromeLengthPuzzle
	 * 
	 * @param input1
	 * @return
	 *
	 ****************************************/
	public int PalindromeLengthPuzzle(String[] input1) {
		if (input1 == null) {
			return 0;
		}
		// First Char String Builder
		StringBuilder fcsb = new StringBuilder();
		for (String name : input1) {
			fcsb.append(name.charAt(0));
		}
		return getMaxPalindrome(fcsb.toString()).length();
	}

	private String getMaxPalindrome(String string) {
		int charIndex = 0;
		String maxPalindromeSoFar = "";
		if (string.length() == 1) {
			maxPalindromeSoFar = string;
		} else if (string.length() == 2) {
			if (string.charAt(0) == string.charAt(1)) {
				maxPalindromeSoFar = string;
			} else {
				maxPalindromeSoFar = String.valueOf(string.charAt(0));
			}
		} else {
			for (int i = 0; i < string.length() - 1; i++) {
				charIndex++;
				if (maxPalindromeSoFar.length() == string.length()) {
					break;
				}
				// Check
				String palindrome = getPalindrome(charIndex, string);
				if (palindrome.length() > maxPalindromeSoFar.length()) {
					maxPalindromeSoFar = palindrome;
				}
			}
		}
		// System.out.println(maxPalindromeSoFar);
		return maxPalindromeSoFar.toString();
	}

	private String getPalindrome(int charIndex, String string) {
		StringBuilder resultString = new StringBuilder();
		resultString.append(string.charAt(charIndex));
		int j, oldJ = charIndex + 1;
		for (int z = charIndex - 1; z >= 0; z--) {
			j = oldJ;
			while (!(z < 0 && j >= string.length())) {
				if ((z >= 0 && string.charAt(z) == string.charAt(charIndex))
						|| (j < string.length() && string.charAt(j) == string
								.charAt(charIndex))) {
					if (j < string.length()
							&& string.charAt(j) == string.charAt(charIndex)) {
						if (string.charAt(j) == string.charAt(j - 1)) {
							StringBuilder oldString = resultString;
							resultString = new StringBuilder();
							resultString.append(oldString).append(string.charAt(j));
							oldJ = j;
						}
						j++;
					}
					if (z >= 0 && string.charAt(z) == string.charAt(charIndex)) {
						if (string.charAt(z) == string.charAt(z + 1)) {
							StringBuilder oldString = resultString;
							resultString = new StringBuilder();
							resultString.append(string.charAt(z)).append(oldString);
						}
						z--;
					}
				} else {
					if (z >= 0 && j < string.length()
							&& string.charAt(z) == string.charAt(j)) {
						StringBuilder oldString = resultString;
						resultString = new StringBuilder();
						resultString.append(string.charAt(z)).append(oldString).append(string.charAt(j));
						j++;
						oldJ = j;
						z--;
					} else {
						if (j < string.length()) {
							j++;
						} else {
							j = oldJ;
							z--;
						}
					}
				}
			}
		}
		return resultString.toString();
	}
}