package util;

/**
 * Stack d'entiers (type primitif)
 */
public class Stack<T> implements IStack<T> {
	private static final int increment = 20;
	private T[] v;
	private int sommet;// 1ère position de libre
	private int tmax;// taille max du vecteur = v.length

	/**
	 * Crée un stack d'une capacité initiale de tmax
	 * @param tmax
	 */
	@SuppressWarnings("unchecked")
	public Stack(int tmax) {
		this.tmax = tmax;
		this.v = (T[]) new Object[tmax];
		this.sommet = 0;
	}

	/**
	 * Crée un stack avec une capacité initiale de 20 éléments
	 */
	public Stack() {
		this(increment);
	}

	/**
	 * empile un élément au sommet du stack	
	 * @param elem
	 */
	@Override
	public void push(T elem) {
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
		@SuppressWarnings("unchecked")
		T[] x = (T[]) new Object[newTaille];
		System.arraycopy(v, 0, x, 0, tmax);
		v = x;
		// System.out.println("Augmente taille de v de "+ tmax+ " à "+newTaille);
		tmax = newTaille;
	}

	/**
	 * Retire l'élément au sommet du stack
	 * @return élément
	 * @exception si le stack est vide
	 * 
	 */
	@Override
	public T pop() {
		if (empty())
			throw new ArrayIndexOutOfBoundsException("Le stack est vide");
		sommet--;
		T elem = v[sommet];
		v[sommet] = null;//perte de la référence sur l'objet
		return elem;
	}

	/**
	 * Retourne l'élément au sommet du stack
	 * @return élément au sommet
	 * @exception si le stack est vide
	 */
	@Override
	public T top() {
		if (empty())
			throw new ArrayIndexOutOfBoundsException();
		return v[sommet - 1];
	}

	/**
	 * Indique si le stack est vide
	 * @return true si vide
	 */
	@Override
	public boolean empty() {
		return sommet == 0;
	}

}
