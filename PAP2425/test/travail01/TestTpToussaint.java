package travail01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TestTpToussaint {
	@Test
	void testnbChiffres() {
		assertEquals(3, TpToussaint.nbChiffres(567));
		assertEquals(1, TpToussaint.nbChiffres(000));
		assertThrows(AssertionError.class, () -> TpToussaint.nbChiffres(-1));
	}

	@Test
	void testInverseNbr() {
		assertEquals(765, TpToussaint.inverseNbr(567));
		assertEquals(12, TpToussaint.inverseNbr(21));
		assertEquals(9, TpToussaint.inverseNbr(9));
		assertThrows(AssertionError.class, () -> TpToussaint.inverseNbr(-1));
	}

	@Test
	void testConvertisseur() {
		assertEquals(38.0, TpToussaint.convertTemp(38.0, 'C', 'C'), 0.0);
		assertEquals(100.4, TpToussaint.convertTemp(38.0, 'C', 'F'), 0.0);
		assertEquals(311.15, TpToussaint.convertTemp(38.0, 'C', 'K'), 0.0);
		assertEquals(38.0, TpToussaint.convertTemp(100.4, 'F', 'C'), 0.0);
		assertEquals(311.15, TpToussaint.convertTemp(100.4, 'F', 'K'), 0.0);
		assertEquals(-273.15, TpToussaint.convertTemp(0, 'K', 'C'), 0.0);
		assertThrows(AssertionError.class, () -> TpToussaint.convertTemp(-100, 'K', 'C'));
		assertThrows(AssertionError.class, () -> TpToussaint.convertTemp(-100, 'X', 'C'));
		assertThrows(AssertionError.class, () -> TpToussaint.convertTemp(-100, 'C', 'X'));
	}

}
