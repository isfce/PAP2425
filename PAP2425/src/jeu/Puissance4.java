package jeu;

import tp03.MyMat;

/**
 * Jeu de puissance 4 version 0.01
 */
public class Puissance4 {
	// codes des cases ==> static car idem pour tous les objets et fixe
	private static final int BORDURE = -1;
	private static final int VIDE = 0;
	private static final int JAUNE = 1;
	private static final int ROUGE = 2;
	// Joueur
	private final String joueurJaune;
	private final String joueurRouge;
	// Tour
	private boolean tour;
	private static final boolean TOUR_DES_JAUNES = true;
	private static final boolean TOUR_DES_ROUGES = !TOUR_DES_JAUNES;
	// ETAT
	private boolean fin;
	private boolean gagne;
	// Pions
	private static final int NB_CASES = 6 * 7;
	private int nbPions;

	// le plateau de jeu avec une bordure (-1)
	private int[][] jeu = new int[8][9];

	/**
	 * Création d'une nouvelle partie	
	 * @param string
	 * @param string2
	 */
	public Puissance4(String joueur1, String joueur2) {
		this.joueurJaune = joueur1;
		this.joueurRouge = joueur2;
		initPartie();
	}

	/**
	 * Initialise une partie avec les mêmes joueurs
	 */
	private void initPartie() {
		tour = Math.random() < 0.5 ? TOUR_DES_JAUNES : TOUR_DES_ROUGES;
		initJeu();//initialise la matrice
		fin = false;
		gagne = false;
		nbPions = 0;
	}

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
	private void initJeu() {

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

	/**
	 * Lancement d'une partie innitialisée
	 */
	private void start() {
		if (fin) {
			System.out.println("Lancement d'une nouvelle partie!");
			initPartie();
			int col = choisirColonne();
			
		}
		
		while (!fin) {
			afficheJeu();
			

		}

	}

	private int choisirColonne() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		Puissance4 partie = new Puissance4("Waf", "Vo");
		partie.start();
		partie.start();

	}

}
