package tp02;

public class MyVect {
	/**
	 * Affiche un vecteur d'entiers
	 * v ne doit pas être null
	 * @param v
	 */
	public static void afficheVect(int[] v) {
		assert v != null : "v ne peut pas être à null";
		System.out.println();
		System.out.print('[');
		for (int i = 0; i < v.length - 1; i++)
			System.out.print(v[i] + ",");
		System.out.println(v.length == 0 ? "]" : v[v.length - 1] + "]");
	}

	/**
	 * Affiche un vecteur de caractères
	 * v ne doit pas être null
	 * @param v
	 */
	public static void afficheVect(char[] v) {
		assert v != null : "v ne peut pas être à null";
		System.out.println();
		System.out.print('[');
		for (int i = 0; i < v.length - 1; i++)
			System.out.print(v[i] + ",");
		System.out.println(v.length == 0 ? "]" : v[v.length - 1] + "]");
	}

	/**
	 * Somme des éléments d'un vecteur
	 * @param v
	 * @return
	 */
	public static long sommeV(int[] v) {
		long res = 0;
		for (int elem : v)
			res = res + elem;
		return res;
	}

	/**
	 * Retourne l'élément maximum du vecteur
	 * @param v
	 * @return
	 */
	public static int maxElemV(int[] v) {
		assert v.length > 0 : "Le vecteur ne peut pas être vide";
		int maxi = v[0];
		for (int elem : v)
			if (maxi < elem)
				maxi = elem;
		return maxi;
	}

	/**
	 * Retourne l'élément minimum du vecteur
	 * @param v
	 * @return
	 */
	public static int minElemV(int[] v) {
		assert v.length > 0 : "Le vecteur ne peut pas être vide";
		int maxi = v[0];
		for (int elem : v)
			if (maxi > elem)
				maxi = elem;
		return maxi;
	}

	public static int maxElemV2(int[] v) {
		assert v.length > 0 : "Le vecteur ne peut pas être vide";
		int maxi = v[0];
		for (int i = 1; i < v.length; i++)
			if (maxi < v[i])
				maxi = v[i];
		return maxi;
	}

	/**
	 * Retourne l'élément maximum ou minimum du vecteur en fonction de max
	 * @param v
	 * @param max true=>maximum  false=>minimum
	 * @return
	 */
	public static int minMaxElemV(int[] v, boolean max) {
		// assert v.length > 0 : "Le vecteur ne peut pas être vide";
		return max ? maxElemV(v) : minElemV(v);
	}

	/**
	 * Effectue un clone du vecteur V
	 * @param v
	 * @return
	 */
	public static int[] cloneV(int[] v) {
		int[] cl = new int[v.length];
		for (int i = 0; i < v.length; i++)
			cl[i] = v[i];
		return cl;
	}

	public static void main(String[] args) {
		char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		afficheVect(hex);

		char[] v2 = {};
		afficheVect(v2);

		int[] v3 = { 9, 7, 0, 3 };
		afficheVect(v3);
		System.out.println("Somme V: " + sommeV(v3));
	}
}
