package travail01;

import java.util.function.DoubleFunction;

public class TpToussaint {
	/**
	 * Retourne le nombre de chiffres du nombre n
	 * hyp.: n>=0
	 * @param n
	 * @return nombre de chiffre
	 */
	public static byte nbChiffres(int n) {
		assert n >= 0 : "Le nombre doit être >=0";
		byte cpt = 1;
		while (n >= 10) {
			n = n / 10;
			cpt++;
		}
		return cpt;
	}

	/**
	 * Inverse les chiffres d'un nombre
	 * Version qui utilise nbChiffres (moins performante)
	 * @param n un nombre entier >=0
	 * @return le nombre inversé
	 */
	public static int inverseNbr1(int n) {
		assert n >= 0 : "N doit être >=0";
		int inv = 0;
		for (int i = nbChiffres(n); i > 0; i--) {
			inv = inv * 10 + n % 10;
			n = n / 10;
		}
		return inv;
	}

	/**
	 * Inverse les chiffres d'un nombre
	 * @param n un nombre entier >=0
	 * @return le nombre inversé
	 */
	public static int inverseNbr(int n) {
		assert n >= 0 : "N doit être >=0";
		int inv = 0;
		while (n > 0) {
			inv = inv * 10 + n % 10;
			n = n / 10;
		}
		return inv;
	}

	/**
	 * Convertisseur de température Celsius Fahrenheit Kelvin
	 * @param t la température à convertir
	 * @param unitI(K,C,F) de t
	 * @param unitD(K,C,F) de la sortie (destination)
	 * @return la température dans l'unité unitD
	 */
	public static double convertTemp(double t, char unitI, char unitD) {
		assert (unitD == 'C' || unitD == 'F' || unitD == 'K')
				&& ((unitI == 'K' && t >= 0) || (unitI == 'C' || unitI == 'F'))
				: "t doit être positif pour UnitI=K sinon unit doit être C F ou K";
		if (unitI == unitD)
			return t;
		DoubleFunction<Double> cf = (x) -> (x * 18) / 10 + 32.0;
		DoubleFunction<Double> fc = (x) -> (x - 32.0) * 10 / 18.0;
		DoubleFunction<Double> ck = (x) -> (x * 100 + 27315) / 100.0;
		DoubleFunction<Double> kc = (x) -> (x * 100 - 27315) / 100.0;
		// mets en celcius
		double dc = switch (unitI) {
		case 'K' -> kc.apply(t);
		case 'F' -> fc.apply(t);
		default -> t;
		};
		double res = switch (unitD) {
		case 'K' -> ck.apply(dc);
		case 'F' -> cf.apply(dc);
		default -> dc;
		};
		return res;
	}

}
