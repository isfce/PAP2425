package util;

public interface IStack<T> {

	/**
	 * empile un élément au sommet du stack	
	 * @param elem
	 */
	void push(T elem);

	/**
	 * Retire l'élément au sommet du stack
	 * @return élément
	 * @exception si le stack est vide
	 * 
	 */
	T pop();

	/**
	 * Retourne l'élément au sommet du stack
	 * @return élément au sommet
	 * @exception si le stack est vide
	 */
	T top();

	/**
	 * Indique si le stack est vide
	 * @return true si vide
	 */
	boolean empty();

}