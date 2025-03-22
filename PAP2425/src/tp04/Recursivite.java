package tp04;

import tp02.MyVect;
import util.StackInt;

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
			deplacer(1, d, a);
			deplacer(n - 1, i, a);
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
		assert d <= f : " d doit être <= à f ";
		int i = d;
		int j = f - 1;
		int pivot = v[f];

		while (i <= j) {
			while (v[i] < pivot)
				i++;
			while (j >= 0 && v[j] >= pivot)
				j--;
			if (i < j) {// swap
				int tmp = v[i];
				v[i] = v[j];
				v[j] = tmp;
			}
		}
		// place le pivot
		v[f] = v[i];
		v[i] = pivot;
	}

	/**
	 * Place le pivot et reetourne sa position
	 * @param v
	 * @param d
	 * @param f
	 * @return position du pivot
	 */
	public static int posPivot(int[] v, int d, int f) {
		assert d <= f : " d doit être <= à f ";
		int i = d;
		int j = f - 1;
		int pivot = v[f];

		while (i <= j) {
			while (v[i] < pivot)
				i++;
			while (j >= 0 && v[j] >= pivot)
				j--;
			if (i < j) {// swap
				int tmp = v[i];
				v[i] = v[j];
				v[j] = tmp;
			}
		}
		// place le pivot
		v[f] = v[i];
		v[i] = pivot;
		return i;
	}

	/**
	 * Quicksort récursif
	 * @param v
	 * @param d
	 * @param f
	 */
	private static void quickSort(int[] v, int d, int f) {
		assert d <= f : " d doit être <= à f ";
		int i = d;
		int j = f - 1;
		int pivot = v[f];

		while (i <= j) {
			while (v[i] < pivot)
				i++;
			while (j >= 0 && v[j] >= pivot)
				j--;
			if (i < j) {// swap
				int tmp = v[i];
				v[i] = v[j];
				v[j] = tmp;
			}
		}
		// place le pivot
		v[f] = v[i];
		v[i] = pivot;
		// appels recursifs
		int tailleG = i - d;
		int tailleD = f - i;
		// traite d'abord les petits intervalles
		if (tailleG < tailleD) {
			if (tailleG > 1)
				quickSort(v, d, i - 1);
			if (tailleD > 1)
				quickSort(v, i + 1, f);
		} else {
			if (tailleD > 1)
				quickSort(v, i + 1, f);
			if (tailleG > 1)
				quickSort(v, d, i - 1);
		}
	}

	/**
	 * Facilite l'appel de la version récursive
	 * QuickSort récursif
	 */
	public static void quickSortR(int[] v) {
		quickSort(v, 0, v.length - 1);
	}

	/**
	 * Quicksort non récursif
	 * @param v
	 */
	public static void quickSort(int[] v) {
		int d, f, p;
		StackInt s = new StackInt(v.length + 1);
		s.push(0);
		s.push(v.length - 1);
		while (!s.empty()) {
			f = s.pop();
			d = s.pop();
			p = posPivot(v, d, f);
			// traite d'abord le petit intervalle
			int tailleG = p - d;
			int tailleD = f - p;
			if (tailleG >= tailleD) {
				if (tailleG > 1) {
					s.push(d);
					s.push(p - 1);
				}
				if (tailleD > 1) {
					s.push(p + 1);
					s.push(f);
				}
			} else {
				if (tailleD > 1) {
					s.push(p + 1);
					s.push(f);
				}
				if (tailleG > 1) {
					s.push(d);
					s.push(p - 1);
				}
			}
		}

	}

	public static void main(String[] args) {
		// System.out.println(facto(25));
		// System.out.println(fibo(7));
		int[] w = { 1, 7, 5, 2, 0, 9, 4 };
		MyVect.afficheVect(w);
		// placePivot(w, 0, 4);
		quickSort(w);
		// quickSortR(w, 0, w.length - 1);
		MyVect.afficheVect(w);

		// System.out.println(power(2, 62));
		// deplacer(3, 1, 3);

	}

}
