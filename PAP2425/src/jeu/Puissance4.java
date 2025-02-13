package jeu;

import tp03.MyMat;

/**
 * Jeu de puiissance 4 version 0.01
 */
public class Puissance4 {
	// codes des cases ==> static car idem pour tous les objets et fixe
	private static final int BORDURE = -1;
	private static final int VIDE = 0;
	public static final int JAUNE = 1;
	public static final int ROUGE = 2;

	// le plateau de jeu avec une bordure (-1)
	private int[][] jeu = new int[8][9];

	// actuellement public, utilise ma méthode pour afficher la matrice
	public void afficheJeu() {
		System.out.println("-----------------------------------------------------");
		MyMat.afficheMat2(jeu);
		System.out.println("-----------------------------------------------------");
	}

	/**
	 * Crée une bordure avec des -1 et des 0 ailleurs
	 *  temporairement avec une visibilité "public"
	 */
	public void initJeu() {
		
	}

	/**
	 * @param couleur  1 jaune et 2 rouge
	 * @param colonne  1..7
	 * @return true si le coup est valable
	 */
	public boolean joue(int couleur, int colonne) {
		boolean ok = true;
		// TODO
		return ok;
	}

	public static void main(String[] args) {
		Puissance4 partie = new Puissance4();
		partie.initJeu();
		partie.afficheJeu();
		partie.joue(ROUGE, 2);
		partie.afficheJeu();
		partie.joue(JAUNE, 2);
		partie.afficheJeu();
		partie.joue(ROUGE, 1);
		partie.afficheJeu();
		partie.joue(JAUNE, 2);
		partie.afficheJeu();
		partie.joue(ROUGE, 1);
		partie.afficheJeu();

	}
}
