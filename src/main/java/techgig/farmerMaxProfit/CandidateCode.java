/**
 * 
 * An Indian farmer has a piece of farm land, say L square kilometer and wants to either sow wheat or rice or combination of both. Farmer has limited amount of F kg of fertilizer and P kg of insecticide. 

Every square kilometer of wheat requires F1 Kg of fertilizer, and P1 Kg of insecticide, while every square kilometer of rice requires F2 Kg of fertilizer and P2 Kg of insecticide. Let S1 be the selling price of wheat per square kilometer and S2 be the selling price of rice per square kilometer.

You have to find the maximum total profit that the farmer can earn and how much square kilometers wheat/rice should be planted.
 
For example: L = 10 Km2 , F = 10 Kg, P = 5 Kg, F1 = 2 Kg, P1 = 2 Kg, F2 = 3 Kg, P2 = 1 Kg, S1 = Rs.14, S2 = Rs.25. In this case, farmer will earn maximum profit if he sows only Rice on 3.33 Km2 area and maximum profit value will be Rs.83.33.

Input/Output Specifications Input Specification: 

Input will be L,F,P,F1,P1,F2,P2,S1,S2(as string). 

Output Specification: 
Output will be < Maximum profit correct upto 2 digits >,< value in km 2 where wheat should be planted correct upto 2 digits >,< value in km 2 where rice should be planted correct upto 2 digits >. For the example considered in the question output will be 83.33,0.00,3.33(as string). 

Note: In case there are more than one answer to the question return -1(as string).

Examples
Example 1:
Input: 10,10,5,2,2,3,1,14,25
let us say that L = 10 Km2 , F = 10 Kg, P = 5 Kg, F1 = 2 Kg, P1 = 2 Kg, F2 = 3 Kg, P2 = 1 Kg, S1 = 14 ₹, S2 = 25 ₹. Total profit will be maximum if farmer does not plant any wheat but plants rice on 3.33 km2 area and maximum profit value is 83.33 ₹.

Output: 83.33,0.00,3.33

Example 2:
Input: 50,200,30,5,3,2,2,15,10
Output: -1

Instructions:
  1) Do not write main function. 
 2) Do not print any variables in the code. 
 3) You need to return the required output from the given function. 
 4) Do not change the function and parameter names given in editor code. 
 5) Return type must be the same as mentioned in the problem statement. 
 6) When you submit your code, 10 test cases of different complexity level are executed in the background and marks are given based on number of test cases passed. 
 7) If you do not plan to complete the code in one sitting, then please save your work on a local machine. The code is saved only when it has been submitted using Submit button. 
 8 ) Only two submissions are allowed. 

 * 
 * 
 */

package techgig.farmerMaxProfit;

import java.text.DecimalFormat;

public class CandidateCode {
	public String get_total_profit(String input1) {
		String[] inputs = input1.split(",");
		// Piece of farm land in square kilometer
		float L = Float.valueOf(inputs[0]);
		// Fertilizer in kg
		float F = Float.valueOf(inputs[1]);
		// Insecticide in kg
		float P = Float.valueOf(inputs[2]);
		// Fertilizer required in kg for square kilometer of Wheat
		float F1 = Float.valueOf(inputs[3]);
		// Insecticide required in kg for square kilometer of Wheat
		float P1 = Float.valueOf(inputs[4]);
		// Fertilizer required in kg for square kilometer of Rice
		float F2 = Float.valueOf(inputs[5]);
		// Insecticide required in kg for square kilometer of Rice
		float P2 = Float.valueOf(inputs[6]);
		// Selling price of wheat per square kilometer
		float S1 = Float.valueOf(inputs[7]);
		// Selling price of rice per square kilometer
		float S2 = Float.valueOf(inputs[8]);

		// Result Variables
		float totalRiceInsecUsed = 0f;
		float totalRiceFertUsed = 0f;
		float totalWheatInsecUsed = 0f;
		float totalWheatFertUsed = 0f;
		float areaOfWheat = 0.00f;
		float areaOfRice = 0.00f;
		float amount = 0.00f;

		while (true) {
			if ((L == areaOfRice + areaOfWheat)
					|| P == totalRiceInsecUsed + totalWheatInsecUsed
					|| F == totalRiceFertUsed + totalWheatFertUsed || F2 == 0
					|| F1 == 0 || P2 == 0 || P1 == 0) {
				break;
			}

			float calRiceProfit = Math.min(F / F2, P / P2) * S2;
			float calWheatProfit = Math.min(F / F1, P / P1) * S1;

			if (calRiceProfit > calWheatProfit) {
				float areaInsecUsed = P / P2;
				float areaFertUsed = F / F2;
				if (areaInsecUsed > areaFertUsed) {
					L = L - areaFertUsed;
					F2 = 0;
					totalRiceFertUsed = totalRiceFertUsed + F2;
					areaOfRice = areaOfRice + areaFertUsed;
					amount = amount + areaFertUsed * S2;
				} else if (areaInsecUsed < areaFertUsed) {
					L = L - areaInsecUsed;
					P2 = 0;
					totalRiceInsecUsed = totalRiceInsecUsed + areaInsecUsed;
					areaOfRice = areaOfRice + areaInsecUsed;
					amount = amount + areaInsecUsed * S2;
				}
			} else {
				float areaInsecUsed = P / P1;
				float areaFertUsed = F / F1;
				if (areaInsecUsed > areaFertUsed) {
					L = L - areaFertUsed;
					F1 = 0;
					totalWheatFertUsed = totalWheatFertUsed + F1;
					areaOfWheat = areaOfWheat + areaFertUsed;
					amount = amount + areaFertUsed * S1;
				} else if (areaInsecUsed < areaFertUsed) {
					L = L - areaInsecUsed;
					P1 = 0;
					totalWheatInsecUsed = totalWheatInsecUsed + areaInsecUsed;
					areaOfWheat = areaOfWheat + areaInsecUsed;
					amount = amount + areaInsecUsed * S1;
				}
			}

		}
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		return df.format(amount) + "," + df.format(areaOfWheat) + ","
				+ df.format(areaOfRice);
	}
}