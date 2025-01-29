package tri;

import java.util.stream.IntStream;

import tp02.MyVect;

public class Tri {
	/**
	 * Tri par insertion linéaire
	 * @param v
	 */
	public static void triIns(int[] v) {
		int elem, j;

		for (int i = 1; i < v.length; i++) {
			elem = v[i];
			j = i - 1;
			while (j >= 0 && elem < v[j]) {
				v[j + 1] = v[j];
				j--;
			}
			v[j + 1] = elem;
		}
	}

	/**
	 * Tri par à Bulles classique
	 * @param v
	 */
	public static void triBulles(int[] v) {
		int d = v.length - 1;
		int fin;
		while (d > 0) {
			fin = d;
			d = 0;
			for (int i = 0; i < fin; i++)
				if (v[i] > v[i + 1]) {
					// swap
					int tmp = v[i];
					v[i] = v[i + 1];
					v[i + 1] = tmp;
					// mémorise la position du dernier échange
					d = i;
				}
		}
	}

	/**
	 * Tri à bulles dans les 2 sens
	 * @param v
	 */
	public static void triDoubleBulles(int[] v) {
		int d = v.length - 1; // d: position de dernier swap à droite
		int g = 0;// g: position du dernier swap à gauche
		int debut, fin;

		while (g < v.length) {
			debut = g;
			fin = d;
			d = 0;// valeur impossible après un swap
			for (int i = debut; i < fin; i++)// boucle de gauche à droite
				if (v[i] > v[i + 1]) {
					// swap
					int tmp = v[i];
					v[i] = v[i + 1];
					v[i + 1] = tmp;
					// mémorise la position du dernier échange
					d = i;
				}
			g = v.length;// valeur impossible après un swap
			// il y a eu un swap
			if (d > 0)
				// boucle de droite à gauche
				for (int i = d; i > debut; i--)
					if (v[i - 1] > v[i]) {
						// swap
						int tmp = v[i - 1];
						v[i - 1] = v[i];
						v[i] = tmp;
						// mémorise la position du dernier échange
						g = i;
					}
		}
	}

	public static void main(String[] args) {
		IntStream stream = IntStream.generate(() -> {
			return (int) (Math.random() * 1000);
		});
		int[] v = stream.limit(15).toArray();

		MyVect.afficheVect(v);
		triIns(v);
		MyVect.afficheVect(v);

	}

}
