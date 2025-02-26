package util;

/**
 * Stack d'entiers (type primitif)
 */
public class StackInt {
	private static final int increment = 20;
	private int[] v;
	private int sommet;// 1ère position de libre
	private int tmax;// taille max du vecteur = v.length

	/**
	 * Crée un stack d'une capacité initiale de tmax
	 * @param tmax
	 */
	public StackInt(int tmax) {
		this.tmax = tmax;
		this.v = new int[tmax];
		this.sommet = 0;
	}

	/**
	 * Crée un stack avec une capacité initiale de 20 éléments
	 */
	public StackInt() {
		this(increment);
	}

	/**
	 * empile un élément au sommet du stack	
	 * @param elem
	 */
	public void push(int elem) {
		if (sommet == tmax)
			augmenteTailleVecteur();
		v[sommet] = elem;
		sommet++;
	}

	/**
	 * augmente la taille du vecteur V de l'increment
	 */
	private void augmenteTailleVecteur() {
		int newTaille = tmax + increment;
		int[] x = new int[newTaille];
		System.arraycopy(v, 0, x, 0, tmax);
		v = x;
		//System.out.println("Augmente taille de v de "+ tmax+ " à "+newTaille);
		tmax = newTaille;
	}

	/**
	 * Retire l'élément au sommet du stack
	 * @return élément
	 * @exception si le stack est vide
	 * 
	 */
	public int pop() {
		if (empty())
			throw new ArrayIndexOutOfBoundsException("Le stack est vide");
		sommet--;
		return v[sommet];
	}

	/**
	 * Retourne l'élément au sommet du stack
	 * @return élément au sommet
	 * @exception si le stack est vide
	 */
	public int top() {
		if (empty())
			throw new ArrayIndexOutOfBoundsException();
		return v[sommet - 1];
	}

	/**
	 * Indique si le stack est vide
	 * @return true si vide
	 */
	public boolean empty() {
		return sommet == 0;
	}
	
}
