package techgig.cadburyBarPuzzle;

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
		org.springframework.util.Assert.isTrue(14 == cc
				.cadbury(5, 6, 3, 4));
	}

	@Test
	public void test2() {
		org.springframework.util.Assert.isTrue(0 == cc
				.cadbury(6, 5, 3, 4));
	}

	@Test
	public void test3() {
		org.springframework.util.Assert.isTrue(0 == cc
				.cadbury(5, 6, 4, 3));
	}

	@Test
	public void test4() {
		org.springframework.util.Assert.isTrue(0 == cc
				.cadbury(-1, 5, 0, 4));
	}

	@Test
	public void test5() {
		org.springframework.util.Assert.isTrue(0 == cc
				.cadbury(0, 0, 0, 0));
	}

	@Test
	public void test6() {
		org.springframework.util.Assert.isTrue(0 == cc
				.cadbury(0, 1, 0, 1));
	}
	
	@Test
	public void test7() {
		org.springframework.util.Assert.isTrue(706497 == cc
				.cadbury(5, 100, 3, 400));
	}

	@Test
	public void test8() {
		org.springframework.util.Assert.isTrue(42354041 == cc
				.cadbury(5000, 6000, 3000, 4000));
	}

	@Test
	public void test9() {
		org.springframework.util.Assert.isTrue(1 == cc
				.cadbury(3, 3, 3, 3));
	}
	
	@Test
	public void test10() {
		int total = cc
				.cadbury(5, 6, 2, 3);
		org.springframework.util.Assert.isTrue(13 == total);
	}
	
	@Test
	public void test11() {
		org.springframework.util.Assert.isTrue(0 == cc
				.cadbury(5, 6, 4, 3));
	}

}

