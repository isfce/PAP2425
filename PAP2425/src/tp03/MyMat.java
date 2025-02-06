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

	public static void main(String[] args) {
		int[][] m1 = { { 2, -47, 6 }, { 1, 2, 25 } };
		afficheMat(m1);
		afficheMat2(m1);

	}

}
