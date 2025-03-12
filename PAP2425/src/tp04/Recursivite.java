package tp04;

public class Recursivite {

	/**
	 * Calcule la factorielle de n de manière récursive
	 * @param n    0<=n<26
	 * @return
	 */
	public static long facto(int n) {
		assert n >= 0 && n < 26 : " n<26 sinon débordement";
		if (n <= 1)
			return 1;
		return n * facto(n - 1);
	}

	/**
	 * Calcule le nème nombre de Finonacci 
	 * @param n  n>=0
	 * @return Fibo_n
	 */
	public static long fibo(int n) {
		assert n >= 0 : " n>=0";
		if (n < 2)
			return n;
		return fibo(n - 1) + fibo(n - 2);
	}

	/**
	 * calcule x**y
	 * @param x
	 * @param y entier >=0
	 * @return
	 */
	public static long power(long x, int y) {
		if (y == 0)
			return 1;
		if (y == 0 || x == 0 || x == 1)
			return x;
		long res = power(x, y / 2);
		res = res * res;
		if (y % 2 != 0)
			res = res * x;
		return res;
	}

	public static void deplacer(int n, int d, int a) {
		if (n == 1)
			System.out.println("deplacer de " + d + " vers " + a);
		else {
			int i = 6 - d - a;
			deplacer(n - 1, d, i);
			deplacer(1,d,a);
			deplacer(n-1,i,a);
		}

	}

	/**
	 * le pivot sera égal à v[f]
	 * trouve la position du pivot (supposant l'indice x)
	 * Il faut ensuite que
	 * ==> v[i] < pivot pour d<=i<x
	 * ==> v[j]>= pivot pour x<j<= f
	 * hyp: d<=f  d>=0  f< taille de V 
	 * @param v
	 * @param d 
	 * @param f
	 */
	public static void placePivot(int[] v, int d, int f) {

	}

	public static void main(String[] args) {
		// System.out.println(facto(25));
		// System.out.println(fibo(7));

		System.out.println(power(2, 62));
		deplacer(3, 1, 3);

	}

}
