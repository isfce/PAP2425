package tp04;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TestRecursif {

	@Test
	void testPivot() {
		int[] w = { 1, 2, 7, 9, 4 };
		int[] wr = { 1, 2, 4, 9, 7 };
		Recursivite.placePivot(w, 0, 4);
		assertArrayEquals(wr, w);

		int[] w0 = { 1 };
		int[] wr0 = { 1 };
		Recursivite.placePivot(w0, 0, 0);
		assertArrayEquals(wr0, w0);

		int[] w1 = { 1, 2, 3 };
		int[] wr1 = { 1, 2, 3 };
		Recursivite.placePivot(w1, 0, 2);
		assertArrayEquals(wr1, w1);

		int[] w2 = { 3, 2, 1 };
		int[] wr2 = { 1, 2, 3 };
		Recursivite.placePivot(w2, 0, 2);
		assertArrayEquals(wr2, w2);

		int[] w3 = { 3, 2 };
		int[] wr3 = { 2, 3 };
		Recursivite.placePivot(w3, 0, 1);
		assertArrayEquals(wr3, w3);
	}

	@Test
	void testQS() {
		int[] w = { 1, 2, 7, 9, 4 };
		int[] wr = { 1, 2, 4, 7, 9 };
		Recursivite.quickSort(w);
		assertArrayEquals(wr, w);

		int[] w0 = { 1 };
		int[] wr0 = { 1 };
		Recursivite.quickSort(w0);
		assertArrayEquals(wr0, w0);

		int[] w1 = { 1, 2, 3 };
		int[] wr1 = { 1, 2, 3 };
		Recursivite.quickSort(w1);
		assertArrayEquals(wr1, w1);

		int[] w2 = { 3, 2, 1 };
		int[] wr2 = { 1, 2, 3 };
		Recursivite.quickSort(w2);
		assertArrayEquals(wr2, w2);

		int[] w3 = { 3, 2 };
		int[] wr3 = { 2, 3 };
		Recursivite.quickSort(w3);
		assertArrayEquals(wr3, w3);
	}

	@Test
	void testQSR() {
		int[] w = { 1, 2, 7, 9, 4 };
		int[] wr = { 1, 2, 4, 7, 9 };
		Recursivite.quickSortR(w);
		assertArrayEquals(wr, w);

		int[] w0 = { 1 };
		int[] wr0 = { 1 };
		Recursivite.quickSortR(w0);
		assertArrayEquals(wr0, w0);

		int[] w1 = { 1, 2, 3 };
		int[] wr1 = { 1, 2, 3 };
		Recursivite.quickSortR(w1);
		assertArrayEquals(wr1, w1);

		int[] w2 = { 3, 2, 1 };
		int[] wr2 = { 1, 2, 3 };
		Recursivite.quickSortR(w2);
		assertArrayEquals(wr2, w2);

		int[] w3 = { 3, 2 };
		int[] wr3 = { 2, 3 };
		Recursivite.quickSortR(w3);
		assertArrayEquals(wr3, w3);
	}
}
