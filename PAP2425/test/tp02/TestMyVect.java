package tp02;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestMyVect {
	int[] v0 = {};
	int[] v1 = { 20 };
	int[] v2 = { 1, 8, 19 };
	int[] v3 = { Integer.MAX_VALUE, Integer.MAX_VALUE };
	int[] v4 = { 19, 2, 3, 8 };

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
	void testClone() {
		int[] clone = { 1, 8, 19 };
		assertArrayEquals(clone, MyVect.cloneV(v2));

	}

}
