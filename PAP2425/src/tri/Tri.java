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
