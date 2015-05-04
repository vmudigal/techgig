package techgig.palindromeLengthPuzzle;

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
		String[] input1 = { "Bharti", "Bharat", "Akash", "Bhavya", "Chand",
				"Brijesh", "Chetak", "Arvind", "Bhavna" };
		org.springframework.util.Assert.isTrue(7 == cc
				.PalindromeLengthPuzzle(input1));
	}

	@Test
	public void test2() {
		String[] input1 = { "a", "d", "c", "b", "z", "x", "s", "a", "e", "l",
				"b", "k", "a" };
		org.springframework.util.Assert.isTrue(5 == cc
				.PalindromeLengthPuzzle(input1));
	}

	@Test
	public void test3() {
		String[] input1 = { "a", "a", "a", "c" };
		org.springframework.util.Assert.isTrue(3 == cc
				.PalindromeLengthPuzzle(input1));
	}

	@Test
	public void test4() {
		String[] input1 = {};
		org.springframework.util.Assert.isTrue(0 == cc
				.PalindromeLengthPuzzle(input1));
	}

	@Test
	public void test5() {
		String[] input1 = { "a" };
		org.springframework.util.Assert.isTrue(1 == cc
				.PalindromeLengthPuzzle(input1));
	}

	@Test
	public void test6() {
		String[] input1 = { "a", "a", "c" };
		org.springframework.util.Assert.isTrue(2 == cc
				.PalindromeLengthPuzzle(input1));
	}

	@Test
	public void test7() {
		String[] input1 = { "a", "a", "c", "a" };
		org.springframework.util.Assert.isTrue(3 == cc
				.PalindromeLengthPuzzle(input1));
	}

	@Test
	public void test8() {
		String[] input1 = { "a", "a" };
		org.springframework.util.Assert.isTrue(2 == cc
				.PalindromeLengthPuzzle(input1));
	}

	@Test
	public void test9() {
		String[] input1 = { "a", "a", "a", "a" };
		org.springframework.util.Assert.isTrue(4 == cc
				.PalindromeLengthPuzzle(input1));
	}
	
	@Test
	public void test10() {
		String[] input1 = null;
		org.springframework.util.Assert.isTrue(0 == cc
				.PalindromeLengthPuzzle(input1));
	}

}
