package tp03;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class TestMyMat {
	@Test
	void testRechercheMin() {
		int[][] m1 = { { 1, 7, 2 }, { 7, 2, 8 }, { -2, 8, 3 } };
		assertEquals(-2, MyMat.rechercheMin(m1));
		int[][] m2 = { { 1, 7, 2 }, { 7, 2, 8 }, { 2, 8, 0 } };
		assertEquals(0, MyMat.rechercheMin(m2));
	}

	@Test
	void testExistInMat() {
		int[][] m1 = { { 1, 7, 2 }, { 7, 2, 8 }, { 2, 8, 3 } };
		assertTrue(MyMat.existeInMat(m1, 3));
		assertTrue(MyMat.existeInMat(m1, 1));
		assertFalse(MyMat.existeInMat(m1, 100));

	}

	@Test
	void testSymetrique() {
		int[][] m1 = { { 2, -47 }, { 1, 2 } };
		int[][] m3 = { { 1, 7, 2 }, { 7, 2, 8 }, { 2, 8, 3 } };
		assertFalse(MyMat.estSymetrique(m1));
		assertTrue(MyMat.estSymetrique(m3));
	}

	@Test
	void testProduitMat() {
		int[][] m5 = { { 1, 2, 5 }, { 3, 4, 6 } };
		int[][] m6 = { { 7, 2 }, { 2, 4 }, { 3, -3 } };
		int[][] m7 = MyMat.produitMat(m5, m6);
		int[][] mR7 = { { 26, -5 }, { 47, 4 } };
		assertArrayEquals(mR7, m7);
	}

}
