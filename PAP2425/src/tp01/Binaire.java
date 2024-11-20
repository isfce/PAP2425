package tp01;

public class Binaire {

	/**
	 * Conversion d'un entier en sa chaine de caractères au format Hexadécimal
	 * @param n un entier de 32 bits
	 * @return l'entier en hexa
	 */
	public static String convertToHex(int n) {
		if (n == 0)// cas particulier
			return "0x0";
		String res = "";
		while (n != 0) {
			int r = n & 0xf;
			// calcule le code unicode du caractère
			// 0-9 ==> '0'-'9' (+48)
			// 10-15 ==> 'a'-'f' (+55+32)
			r = r + (r < 10 ? 48 : 87);
			res = (char) r + res;
			n = n >>> 4;
		}
		return "0x" + res;
	}

	/**
	 * Retourne le nbr de bits à 1
	 * @param n
	 * @return
	 */
	public static byte nbBitV1(int n) {
		byte cpt = 0;
		int masque = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & masque) == masque)
				cpt++;
			masque = masque << 1;
		}
		return cpt;
	}

	/**
		 * Retourne le nbr de bits à 1
		 * @param n
		 * @return
		 */
	public static byte nbBitV3(int n) {
		byte cpt = 0;
		while (n != 0) {
			cpt = (byte) (cpt + (n & 1));
			n = n >>> 1;// ATTENTION injecte des 0
		}
		return cpt;
	}

	/**
	 * Vérifie si une lettre est une majuscule
	 * @param c une lettre
	 * @return true si majuscule
	 */
	public static boolean estMajuscule(char c) {
		assert Character.isLetter(c) : "Il faut une lettre";
		return (c & 32) == 0;
	}

	/**
	 * Indique le nombre de bytes nécessaires
	 *   pour coder le caractère unicode en utf8
	 *   utilise des masques
	 * @param c le caractère
	 * @return 1 2 ou 3 (nbBytes)
	 */
	public static int nbBytesUtf8(char c) {
		if ((c & 0xff80) == 0)
			return 1;
		if ((c & 0xf800) == 0)
			return 2;
		return 3;
	}

	/**
	 * Indique le nombre de bytes nécessaires
	 *   pour coder le caractère unicode en utf8
	 *   utilise des masques
	 * @param c le caractère
	 * @return 1 2 ou 3 (nbBytes)
	 */
	public static int nbBytesUtf8_V2(char c) {
		if (c < 128)
			return 1;
		if (c < 2048)
			return 2;
		return 3;
	}

	/**
	 * Décode un code UTF8 en unicode
	 * @param n un code utf8 (avec remplissage de 0 sur 32 bits)
	 * @return un code unicode 32bits (16bits de poids fort à 0)
	 */
	public static int decodeUtf8(int n) {
		assert (n & 0xff000000) == 0 : "Les 8 bits de poids fort doivent être à 0";
		int res = 0;
		// cas1
		if ((n & 0xffff80) == 0) {// ou faire n<127
			res = n;
		} else // cas 2
		if ((n & 0xff0000) == 0) {// ou faire n< (1<<16)
			assert (n & 0xe0c0) == 0xc080 : "code utf8 invalide";
			res = n & 0x3f; // Extraire les 6 bits de poid faible
			res = res | (n & 0x1F00) >> 2; // extraire 6 bits du 2ème byte, les décaler de bits à droite et écrire dans
											// res
		} else {// TODO
			;
		}

		return res;
	}

	public static void main(String[] args) {
		String s = convertToHex(745);
		System.out.println("745 donne en hexa: " + s);
	}

}
