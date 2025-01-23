package tri;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TestTri {

	@Test
	void testTriIns() {
		int[] v0 = { 1, 2 };
		int[] vt0 = { 1, 2 };
		int[] v1 = { 2, 1 };
		int[] vt1 = { 1, 2 };
		int[] v2 = { 4, 3, 2, 1 };
		int[] vt2 = { 1, 2, 3, 4 };

		Tri.triIns(v0);
		assertArrayEquals(vt0, v0);
		Tri.triIns(v1);
		assertArrayEquals(vt1, v1);
		Tri.triIns(v2);
		assertArrayEquals(vt2, v2);

	}

}
