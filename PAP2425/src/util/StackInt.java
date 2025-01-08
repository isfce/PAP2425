package util;
/**
 * Stack d'entiers (type primitif)
 */
public class StackInt {
	private int[] v;
	private int sommet;// 1ère position de libre
	private int tmax;//taille max du vecteur = v.length

	/**
	 * @param tmax
	 */
	public StackInt(int tmax) {
		this.tmax = tmax;
		this.v = new int[tmax];
		this.sommet = 0;
	}

	/**
	 * empile un élément au sommet du stack	
	 * @param elem
	 */
	public void push(int elem) {
		if (sommet == tmax)
			throw new ArrayIndexOutOfBoundsException();
		v[sommet] = elem;
		sommet++;
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
