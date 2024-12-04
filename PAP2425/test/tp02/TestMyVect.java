package tp02;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestMyVect {
	int[] v0 = {};
	int[] v1 = { 20 };
	int[] v2 = { 1, 8, 19 };
	int[] v3 = { Integer.MAX_VALUE, Integer.MAX_VALUE };
	int[] v4 = { 19, 2, 3, 8 };
	char[] txt1 = { 'a' };
	char[] txt2 = { 'a', 'a' };
	char[] txt3 = { 'a', 'b', 'b', 'a' };
	char[] txt4 = { 'r', 'a', 'd', 'a', 'r' };
	char[] txt5 = { 'z', 'a', 'd', 'a', 'r' };
	char[] txt6 = { 'r', 'a', 'd', 'o', 'r' };
	char[] txt7 = { 'r', 'a', 'o', 'r' };

	@Test
	void testSommeV() {
		assertEquals(0, MyVect.sommeV(v0));
		assertEquals(20, MyVect.sommeV(v1));
		assertEquals(28, MyVect.sommeV(v2));
		assertEquals((long) 2 * Integer.MAX_VALUE, MyVect.sommeV(v3));
	}

	@Test
	void testMaxElemV() {
		assertEquals(20, MyVect.maxElemV(v1));
		assertEquals(19, MyVect.maxElemV(v2));
		assertEquals(19, MyVect.maxElemV(v4));
	}

	@Test
	void testEstPalindrome() {
		assertTrue(MyVect.estPalindrome(txt1));
		assertTrue(MyVect.estPalindrome(txt2));
		assertTrue(MyVect.estPalindrome(txt3));
		assertTrue(MyVect.estPalindrome(txt4));
		assertFalse(MyVect.estPalindrome(txt5));
		assertFalse(MyVect.estPalindrome(txt6));
		assertFalse(MyVect.estPalindrome(txt7));
	}

	@Test
	void testClone() {
		int[] clone = { 1, 8, 19 };
		assertArrayEquals(clone, MyVect.cloneV(v2));

	}

}
