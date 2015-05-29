package techgig.farmerMaxProfit;

import org.junit.BeforeClass;
import org.junit.Test;

public class CandidateCodeTest {
	
	private static CandidateCode cc;

	@BeforeClass
	public static void initCandidateCode() {
		cc = new CandidateCode();
	}

	@Test
	public void test1() {
		org.springframework.util.Assert.isTrue("83.33,0.00,3.33".equals(cc
				.get_total_profit("10,10,5,2,2,3,1,14,25")));
	}

	@Test
	public void test2() {
		org.springframework.util.Assert.isTrue("105.00,5.00,0.00".equals(cc
				.get_total_profit("10,10,5,1,1,3,1,21,25")));
	}
	
	@Test
	public void test3() {
		org.springframework.util.Assert.isTrue("105.00,5.00,0.00".equals(cc
				.get_total_profit("10,10,5,1,1,6,1,10,60")));
	}

}

