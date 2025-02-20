package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

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
	// Position du dernier pion
	private int lignePion;
	private int colonnePion;

	// le plateau de jeu avec une bordure (-1)
	private int[][] jeu = new int[8][9];

	// Scanner pour les entrées de l'utilisateur
	private Scanner scan;

	/**
	 * Création d'une nouvelle partie	
	 * @param string
	 * @param string2
	 */
	public Puissance4(String joueur1, String joueur2) {
		this.joueurJaune = joueur1;
		this.joueurRouge = joueur2;
		initPartie();
		scan = new Scanner(System.in);
	}

	/**
	 * Initialise une partie avec les mêmes joueurs
	 */
	private void initPartie() {
		tour = Math.random() < 0.5 ? TOUR_DES_JAUNES : TOUR_DES_ROUGES;
		initJeu();// initialise la matrice
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
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 9; j++)
				if (i == 0 || i == 7 || j == 0 || j == 8)
					jeu[i][j] = BORDURE;
				else
					jeu[i][j] = VIDE;
	}

	/**
	 * Doit insérer le pion dans le jeu et
	 * mettre à jour la position du pion inséré (lignePion,colonnePion)
	 * @param couleur  1 jaune et 2 rouge
	 * @param colonne  1..7
	 * @return true si le coup est valable
	 */
	public boolean insertPion(int couleur, int colonne) {
		if (jeu[1][colonne] != VIDE)
			return false;
		int i = 2;
		// cherche une case occupée
		while (jeu[i][colonne] == VIDE)
			i++;
		i--; // case d'insertion
		jeu[i][colonne] = couleur;
		// maj de la position du pion dans le jeu
		this.lignePion = i;
		this.colonnePion = colonne;
		return true;
	}

	/**
	 * Lancement d'une partie innitialisée
	 */
	private void start() {
		if (fin) {
			System.out.println("Lancement d'une nouvelle partie!");
			initPartie();
		}
		boolean ok;
		while (!fin) {
			afficheJeu();
			do {
				// choix d'une colonne par un joueur (1..7)
				int col = choisirColonne();
				ok = insertPion(pionJoueur(), col);
				if (!ok)
					System.out.println("La colonne est déjà pleine!!");
			} while (!ok);
			nbPions++;// un pion en plus dans le jeu
			gagne = quattreALaSuite();
			fin = gagne || nbPions == NB_CASES;
			if (!fin)// changement joueur
				tour = !tour;
		}

		if (gagne)
			System.out.println("Bravo " + nomJoueur() + " vous avez gagné!!");
		else
			System.out.println("Pas de gagnant");
	}

	/**
	 * Retourne true si au moins 4 pions à la suite pour
	 * le joueur actuel (tour)
	 * @return true si gagné
	 */
	private boolean quattreALaSuite() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Retourne le code du pion du joueur dont c'est le tour
	 * @return
	 */
	private int pionJoueur() {
		return tour == TOUR_DES_JAUNES ? JAUNE : ROUGE;
	}

	/**
	 * Retourne le nom du joueur dont c'est le tour
	 * @return
	 */
	private String nomJoueur() {
		return tour == TOUR_DES_JAUNES ? joueurJaune : joueurRouge;
	}

	/**
	 * Retourne un choix de colonne entre 1 et 7
	 * @return 1..7
	 */
	private int choisirColonne() {
		int colonne = 0;
		boolean bad = false;
		System.out.print(nomJoueur() + ", Entrez un numéro de colonne 1..7: ");
		do {
			try {
				colonne = scan.nextInt();
				bad = colonne < 1 || colonne > 7;
			} catch (InputMismatchException e) {
				bad = true;
				scan.next();// vide le mauvais caractère du buffer
			}
			System.out.println();
			if (bad)
				System.out.print("ERREUR, Entrez un nombre entre 1 et 7: ");
		} while (bad);

		return colonne;
	}

	public static void main(String[] args) {
		Puissance4 partie = new Puissance4("Waf", "Vo");
		partie.start();

		// partie.start();

	}

}
