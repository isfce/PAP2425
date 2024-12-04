package tp02;

public class MyVect {

	public record RMinMax(int min, int max) {
	};

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
	 * Idem mais avec une boucle "pour"
	 * @param v
	 * @return
	 */
	public static int maxElemV2(int[] v) {
		assert v.length > 0 : "Le vecteur ne peut pas être vide";
		int maxi = v[0];
		for (int i = 1; i < v.length; i++)
			if (maxi < v[i])
				maxi = v[i];
		return maxi;
	}

	/**
	 * Retourne l'élément minimum du vecteur
	 * @param v
	 * @return
	 */
	public static int minElemV(int[] v) {
		assert v.length > 0 : "Le vecteur ne peut pas être vide";
		int mini = v[0];
		for (int elem : v)
			if (mini > elem)
				mini = elem;
		return mini;
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
		// création d'un nouveau vecteur
		int[] clone = new int[v.length];
		for (int i = 0; i < v.length; i++)
			clone[i] = v[i];
		return clone;
	}

	/**
	 * Moyenne des éléments de V
	 * ! taille de v >0
	 * @param v
	 * @return
	 */
	public static double avgElemV(int[] v) {
		assert v.length > 0 : "Le vecteur ne peut pas être vide";
		return (double) sommeV(v) / v.length;// force le calcul en réel
	}

	/**
	 * Indique le nbr de fois qu'"elem" existe ds V
	 * @param v
	 * @param elem
	 * @return
	 */
	public static int nbElemV(int[] v, int elem) {
		int cpt = 0;
		for (int e : v)
			if (e == elem) // si objet ==> e.equals(elem)
				cpt++;
		return cpt;
	}

	/**
	* Retourne le min et la max du vecteur
	* @param v
	* @return  [min,max]
	*/
	public static int[] minMaxElemV(int[] v) {
		assert v.length > 0 : "Le vecteur ne peut pas être vide";
		int[] res = { v[0], v[0] };
		for (int i = 1; i < v.length; i++)
			if (v[i] < res[0])
				res[0] = v[i];
			else if (v[i] > res[1])
				res[1] = v[i];
		return res;
	}

	/**
	* Retourne le min et la max du vecteur
	* @param v
	* @return  Record[min,max]
	*/
	public static RMinMax minMaxElemV2(int[] v) {
		assert v.length > 0 : "Le vecteur ne peut pas être vide";
		int mini = v[0];
		int maxi = v[0];
		for (int i = 1; i < v.length; i++)
			if (v[i] < mini)
				mini = v[i];
			else if (v[i] > maxi)
				maxi = v[i];
		return new RMinMax(mini, maxi);
	}

	/**
	 * Vérifie si le texte est un palindrome
	 * @param v un vecteur de char
	 * @return
	 */
	public static boolean estPalindrome(char[] v) {
		boolean pal = true;
		int i = 0;
		int j = v.length - 1;
		while (pal && i < j) {
			pal = v[i] == v[j];
			i++;
			j--;
		}
		return pal;
	}

	/**
	 * Vérifie si le texte est un palindrome
	 * @param v un String
	 * @return
	 */
	public static boolean estPalindrome(String v) {
		boolean pal = true;
		int i = 0;
		int j = v.length() - 1;
		while (pal && i < j) {
			pal = v.charAt(i) == v.charAt(j);
			i++;
			j--;
		}
		return pal;
	}

	public static void main(String[] args) {
		/*	char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			afficheVect(hex);
		
			char[] v2 = {};
			afficheVect(v2);
		
			int[] v3 = { 9, 7, 0, 3 };
			afficheVect(v3);
			System.out.println("Somme V: " + sommeV(v3));
			*/
		// int[] v1 = { 1, 2, 3, 3, 4 };
		// System.out.println(avgElemV(v1));
		// char[] vc = { 'A', 'B', 'B', 'A', 'I' };
		// System.out.println(estPalindrome(vc));
		// RMinMax r = new RMinMax(5, 76);
		// System.out.println("Le minimum est: " + r.min() + " Le maximum est: " +
		// r.max());
		System.out.println(estPalindrome("RADAR"));

	}
}
