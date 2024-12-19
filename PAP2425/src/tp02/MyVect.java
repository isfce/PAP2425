package tp02;

import java.util.stream.IntStream;

public class MyVect {
	// enregistrement pour un retour de minMaxElemV2
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
	 * Crée une copie avec le contenu de V inversé
	 * @param v
	 * @return
	 */
	public static char[] copieInverse(char[] v) {
		char[] clone = new char[v.length];
		int j = v.length - 1;
		for (char elem : v) {
			clone[j] = elem;
			j--;
		}
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
	* Retourne le min et la max du vecteur ds un vecteur de 2 éléments
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
	* Retourne le min et la max du vecteur dans un record
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
	 * Vérifie si le texte(vecteur de caractères) est un palindrome
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
	 * Vérifie si le texte (String) est un palindrome
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

	/**
	 * recherche binaire
	 * Hyp.: le vecteur doit être trié par ordre croissant!
	 * @param v vecteur trié
	 * @param elem 
	 * @return true si le vecteur contient l'élément
	 */
	public static boolean rechercheBin(int[] v, int elem) {
		int d = 0;
		int f = v.length - 1;
		boolean trouve = false;
		int m;
		while (!trouve && d <= f) {
			m = (d + f) / 2;
			trouve = v[m] == elem;
			if (v[m] > elem)
				f = m - 1;
			else
				d = m + 1;
		}
		return trouve;
	}

	/**
	 * recherche binaire (version sans variable booléenne)
	 * Hyp.: le vecteur doit être trié par ordre croissant!
	 * @param v vecteur trié
	 * @param elem 
	 * @return true si le vecteur contient l'élément
	 */
	public static boolean rechercheBin2(int[] v, int elem) {
		if (v.length == 0)// élimine le cas d'un vecteur vide
			return false;
		int d = 0;
		int f = v.length - 1;

		int m = (d + f) / 2;
		while (d < f && v[m] != elem) {

			if (v[m] > elem)
				f = m - 1;
			else
				d = m + 1;
			m = (d + f) / 2;
		}
		return v[m] == elem;
	}

	

	/**
	 * Indique s'il existe des doublons (version basique non performante)
	 * @param v
	 * @return true si pas de doublon
	 */
	public static boolean sansDoublon(int[] v) {
		boolean sd = true;
		int i = 0;
		int limite = v.length - 1;
		while (sd && i < limite) {
			int j = i + 1;
			while (sd && j < v.length) {
				sd = v[i] != v[j];
				j++;
			}
			i++;
		}
		return sd;
	}

	/* *******************************************
	 * La version 2 utilise 2 autres fonctions:
	 * rechercheBin(v2, n, elem)
	 * insertToPos(v2, n, pos, elem);
	 * ******************************************/
	/**
	 * Indique s'il existe des doublons 
	 * (Version fortement améliorée (500X!!!!) si pas de doublon
	 * @param v
	 * @return true si pas de doublon(s)
	 */
	public static boolean sansDoublonV2(int[] v) {
		if (v.length<2)return true;
		// on crée un nouveau vecteur de même taille
		// qui recevra au fur et à mesure les éléments de V
		// en les insérant de manière triées
		int[] v2 = new int[v.length];
		v2[0] = v[0]; // mets déjà le 1ère élément ds V2
		int n = 1; // nombre d'éléments dans v2

		boolean sd = true; // pas de doublons
		int i = 1;// on commence sur le 2ème élément de v
		int pos;// désignera la position de v[i] dans v2 (pos d'insertion ou de l'élément s'il
				// existe déjà)
		while (sd && i < v.length) {
			int elem = v[i];// élément à recherche dans v2
			pos = rechercheBin(v2, n, elem);// retourne la position d'insertion d'elem ds v2
			// pas de doublon si pos est en fin de v2 (n)
			// ou si v[pos] est différent de elem
			sd = (pos == n) || v2[pos] != elem;
			if (sd) {// si pas de doulon alors on insère elem dans v2 en position 'pos'
				n = insertToPos(v2, n, pos, elem);
				i++;
			}
		}
		return sd;
	}

	/**
	 * @param v vecteur trié de n éléments sans doublon 
	 * @param n nbr d'éléments dans v (n<= taille de v)
	 * @param elem élément qu'on recherche
	 * @return position de l'élément s'il existe sinon sa position d'insertion (sera toujours < v.length)
	 */
	public static int rechercheBin(int[] v, int n, int elem) {
		int d = 0;
		int f = n - 1;
		boolean trouve = false;
		int m = 0;
		while (!trouve && d <= f) {
			m = (d + f) / 2;
			trouve = v[m] == elem;
			if (v[m] > elem)
				f = m - 1;
			else
				d = m + 1;
		}
		// return amélioré (simplifié) par rapport à celui donné au cours
		return trouve ? m : d;

	}
	
	/**
	 * Insère elem en position Pos en décalant les autres éléments
	 * @param v vecteur trié de n éléments 
	 * @param n nbr d'éléments dans v (n <= taille de v)
	 * @param pos position où il faut insérer (intercaler) "elem"
	 * @param elem élement à insérer
	 * @return n+1
	 */
	public static int insertToPos(int[] v, int n, int pos, int elem) {
		for (int i = n; i > pos; i--)
			v[i] = v[i - 1];
		v[pos] = elem;
		return n + 1;
	}
	/* ************************************************************************
	 * Fin sans doublon V2
	 * ************************************************************************/

	public static void main(String[] args) {
		int[] v1 = IntStream.range(0, 100000).toArray();
		// v1[5000]=78;
		// afficheVect(v1);
		
		Long t1 = System.currentTimeMillis();
		boolean res = sansDoublonV2(v1);
		Long t2 = System.currentTimeMillis();
		System.out.println("Res:" + res + " Temps: " + (t2 - t1));
	}
}
