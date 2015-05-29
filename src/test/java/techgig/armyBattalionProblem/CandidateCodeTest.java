package techgig.armyBattalionProblem;

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
		String[] input1 = { "1#2", "2#3", "1#11", "3#11", "4#11", "4#5", "5#6", "5#7", "6#7", "4#12", "8#12", "9#12", "8#10", "9#10", "8#9" };
		int result = cc.maxno_city(input1);
		org.springframework.util.Assert.isTrue(9 == result);
	}

	@Test
	public void test2() {
		String[] input1 = { "1#1" };
		org.springframework.util.Assert.isTrue(1 == cc
				.maxno_city(input1));
	}

	@Test
	public void test3() {
		String[] input1 = { "1#2", "4#3" };
		org.springframework.util.Assert.isTrue(2 == cc
				.maxno_city(input1));
	}

	@Test
	public void test4() {
		String[] input1 = {};
		org.springframework.util.Assert.isTrue(0 == cc
				.maxno_city(input1));
	}

	@Test
	public void test5() {
		String[] input1 = { "a#b", "b#c" };
		org.springframework.util.Assert.isTrue(0 == cc
				.maxno_city(input1));
	}

	@Test
	public void test6() {
		String[] input1 = { "a", "a", "c" };
		org.springframework.util.Assert.isTrue(0 == cc
				.maxno_city(input1));
	}

	@Test
	public void test7() {
		String[] input1 = { "1#2", "1#2" };
		org.springframework.util.Assert.isTrue(2 == cc
				.maxno_city(input1));
	}

	@Test
	public void test8() {
		String[] input1 = { "1#1", "1#1", "1#1", "1#1", "2#2", "2#2", "2#2", "1#1", "2#2", "1#1", "2#2" };
		org.springframework.util.Assert.isTrue(1 == cc
				.maxno_city(input1));
	}

	@Test
	public void test9() {
		String[] input1 = { "1#2", "2#3", "1#11", "3#11", "4#11", "4#5", "5#6", "5#7", "6#7", "7#8", "12#11", "4#12", "8#12", "9#12", "8#10", "9#10", "8#9" };
		org.springframework.util.Assert.isTrue(12 == cc
				.maxno_city(input1));
	}
	
	@Test
	public void test10() {
		String[] input1 = null;
		org.springframework.util.Assert.isTrue(0 == cc
				.maxno_city(input1));
	}
	
	@Test
	public void test11() {
		String[] input1 = { "1#2", "2#3", "1#3" };
		org.springframework.util.Assert.isTrue(3 == cc
				.maxno_city(input1));
	}

}
