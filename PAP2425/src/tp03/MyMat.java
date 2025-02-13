package tp03;

public class MyMat {

	/**
	 * @param mat
	 * Affichage d'une matrice plus esthétique
	 */
	public static void afficheMat2(int[][] mat) {
		// Définir les caractères pour les bordures
		char bordureHorizontale = '\u2550';
		char bordureVerticale = '\u2551';
		char croixHorizVert = '\u256C';
		// nbr de colonnes
		int m = mat[0].length;
		// nombre de caractères max pour une donnée de mat
		int nb = nbMaxChar(mat) + 1;
		// max car pour afficher l'indice de ligne
		int maxCarLigne = Integer.toString(mat.length).length();
		// max car pour la 1ère colonne de la matrice
		int maxCarColonne1 = nbMaxCharCol1(mat) + 1;

		// début coin sup gauche
		System.out.printf("%" + maxCarLigne + "s" + bordureVerticale, " ");
		// indice de colonne avec un écart minimum pour la 1ère colonne
		for (int j = 0; j < m; j++) {
			int nbr = j == 0 ? maxCarColonne1 : nb;
			System.out.printf("%" + nbr + "d", j);
		}
		System.out.println();
		// Affichage d'une ligne horizontale de séparation
		int cpt = maxCarLigne;
		for (int j = 0; j < cpt; j++)
			System.out.print(bordureHorizontale);
		// La croix
		System.out.print(croixHorizVert);
		// La suite de la ligne horizontale
		cpt = m * nb;
		for (int j = 0; j < cpt; j++)
			System.out.print(bordureHorizontale);

		System.out.println();
		// la matrice avec les entêtes de ligne
		for (int i = 0; i < mat.length; i++) {
			// entête de ligne et séparation
			System.out.printf("%" + maxCarLigne + "d" + bordureVerticale, i);
			for (int j = 0; j < m; j++) {
				// les données en ligne avec le minimum d'espace pour la 1ère colonne
				int nbr = j == 0 ? maxCarColonne1 : nb;
				System.out.printf("%" + nbr + "d", mat[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Pour l'affichage afficheMat2
	 * Retourne le nombre maximum de caractères des nombres de la matrice
	 * @param mat
	 * @return
	 */
	private static int nbMaxChar(int[][] mat) {
		int maxi = 1;
		for (int[] v : mat)
			for (int elem : v)
				maxi = Math.max(maxi, Integer.toString(elem).length());
		return maxi;
	}

	/**
	 * Pour l'affichage afficheMat2
	 * nbr maimum de caractères pour la 1ère colonne de la matrice
	 * @param mat
	 * @return
	 */
	private static int nbMaxCharCol1(int[][] mat) {
		int maxi = 1;
		for (int i = 0; i < mat.length; i++)
			maxi = Math.max(maxi, Integer.toString(mat[i][0]).length());
		return maxi;
	}

	/**
	 *  Affichage simple d'une matrice
	 * @param mat
	 */
	public static void afficheMat(int[][] mat) {
		int nb = nbMaxChar(mat) + 1;
		System.out.println("-----------------------------");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.printf("%" + nb + "d", mat[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------------------------");
	}

	/**
	 * Crée une matrice de n*m initialisée de 1..n*m
	 * @param n
	 * @param m
	 * @return
	 */
	public static int[][] creeMatrice(int n, int m) {
		int[][] mat = new int[n][m];
		int cpt = 1;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				mat[i][j] = cpt++;
		return mat;
	}

	/**
	 * Recherche la valeur minimum dans une matrice
	 * @param m
	 * @return mini
	 */
	public static int rechercheMin(int[][] m) {
		int mini = m[0][0];
		for (int[] v : m)// pour chaque vecteur de m
			for (int elem : v)// pour chaque entier ds v
				mini = Math.min(mini, elem);
		return mini;
	}

	/**
	 * Indique si la valeur existe dans la matrice
	 * @param m
	 * @param valeur
	 * @return 
	 */
	public static boolean existeInMat(int[][] m, int valeur) {
		boolean trouve = false;
		int i = 0;
		while (!trouve && i < m.length) {
			int j = 0;
			while (!trouve && j < m[i].length) {
				trouve = m[i][j] == valeur;
				j++;
			}
			i++;
		}
		return trouve;
	}

	/**
	 * Vérifie si une matrice est symétrique	
	 * @param m
	 * @return
	 */
	public static boolean estSymetrique(int[][] m) {
		boolean sym = true;
		int i = 1;
		while (sym && i < m.length) {
			int j = 0;
			while (sym && j < i) {
				sym = (m[i][j] == m[j][i]);
				j++;
			}
			i++;
		}
		return sym;
	}

	/**
	 * Calcul du produit de 2 matrices (n,k)*(k,m) 
	 * @param m1
	 * @param m2
	 * @return m3 (n,m)
	 */
	public static int[][] produitMat(int[][] m1, int[][] m2) {
		assert m1[0].length == m2.length : "nb colonnes de m1 = nb lignes de m2";
		// Mémorise les tailles par clarté
		int n = m1.length;
		int m = m2[0].length;
		int k = m2.length;
		// Création de m3
		int[][] m3 = new int[n][m];
		// Pour chaque case de m3
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				// calcule sa valeur
				for (int l = 0; l < k; l++)
					m3[i][j] = m3[i][j] + m1[i][l] * m2[l][j];
		return m3;
	}

	public static void main(String[] args) {
		int[][] m1 = { { 2, -47 }, { 1, 2 } };
		int[][] m3 = { { 1, 7, 2 }, { 7, 2, 8 }, { 2, 8, 3 } };
		afficheMat2(m1);
		System.out.println("M1 est Symétrique?: " + estSymetrique(m1));
		System.out.println("M3 est Symétrique?: " + estSymetrique(m3));
		//int[][] m4 = creeMatrice(11, 11);
		//afficheMat2(m4);
		System.out.println("Produit de m5 et m6");
		int[][] m5 = { { 1, 2, 5 }, { 3, 4, 6 } };
		//int[][] m6 = { { 7 }, { 2 }, { 3 } };
		int[][] m6 = { { 7,2 }, { 2,4 }, { 3,-3 } };
		afficheMat2(produitMat(m5, m6));
	}

}
