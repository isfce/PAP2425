package tp01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBinaire {

	@Test
	void testNbBitV1() {
		assertEquals(0, Binaire.nbBitV1(0));
		assertEquals(1, Binaire.nbBitV1(1));
		assertEquals(3, Binaire.nbBitV1(25));
		assertEquals(32, Binaire.nbBitV1(-1));
	}

	@Test
	void testNbBitV2() {
		assertEquals(0, Binaire.nbBitV3(0));
		assertEquals(1, Binaire.nbBitV3(1));
		assertEquals(3, Binaire.nbBitV3(25));
		assertEquals(32, Binaire.nbBitV3(-1));
	}

	@Test
	void testEstMajuscule() {
		assertTrue(Binaire.estMajuscule('T'));
		assertFalse(Binaire.estMajuscule('b'));
		assertThrows(AssertionError.class, () -> Binaire.estMajuscule('+'));
	}

	@Test
	void testnbBytesUtf8() {
		assertEquals(1, Binaire.nbBytesUtf8('A'));
		assertEquals(2, Binaire.nbBytesUtf8('é'));
		assertEquals(3, Binaire.nbBytesUtf8('€'));
	}

	@Test
	void testnbBytesUtf8V2() {
		assertEquals(1, Binaire.nbBytesUtf8_V2('A'));
		assertEquals(2, Binaire.nbBytesUtf8_V2('é'));
		assertEquals(3, Binaire.nbBytesUtf8_V2('€'));
	}

	@Test
	void testHexa() {
		assertTrue("0xDEE27".equalsIgnoreCase(Binaire.convertToHex(912935)));
		assertEquals("0x0", Binaire.convertToHex(0));
		assertEquals("0xdee27", Binaire.convertToHex(912935));
		assertEquals("0xffffffff", Binaire.convertToHex(-1));
	}

	@Test
	void testDecode() {
		assertEquals(65, Binaire.decodeUtf8(65));
		assertEquals(224, Binaire.decodeUtf8(0b11000011_10100000));
		// assertEquals((int)'€', Binaire.decodeUtf8(0xe282ac));
		assertThrows(AssertionError.class, () -> Binaire.decodeUtf8(0xf0000000));
		assertThrows(AssertionError.class, () -> Binaire.decodeUtf8(0b11000011_11100000));
		assertThrows(AssertionError.class, () -> Binaire.decodeUtf8(0b10100011_10100000));
		// assertThrows(AssertionError.class, () ->
		// Binaire.decodeUtf8(0b1010_0000_1000_0000_1000_0000));
		// assertThrows(AssertionError.class, () ->
		// Binaire.decodeUtf8(0b1110_0000_1100_0000_1000_0000));
		// assertThrows(AssertionError.class, () ->
		// Binaire.decodeUtf8(0b1110_0000_1000_0000_1100_0000));

	}
}
