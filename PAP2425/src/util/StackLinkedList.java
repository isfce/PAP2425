package util;

public class StackLinkedList<T> implements IStack<T> {
	// sommet de la liste chainée
	private Maillon<T> sommet = null;

	@Override
	public void push(T elem) {
		sommet = new Maillon<>(elem, sommet);
	}

	@Override
	public T pop() {
		if (empty())
			throw new ArrayIndexOutOfBoundsException("Le stack est vide");
		T elem = sommet.info();
		sommet = sommet.suiv();
		return elem;
	}

	@Override
	public T top() {
		if (empty())
			throw new ArrayIndexOutOfBoundsException("Le stack est vide");
		return sommet.info();
	}

	@Override
	public boolean empty() {
		return sommet == null;
	}

//	public static void main(String[] args) {
//		Maillon<Integer> m1 = new Maillon<>(5, null);
//		Maillon<Integer> m2 = new Maillon<>(9, m1);
//		m2 = new Maillon<>(6, m2);
//		m1 = null;
//		Maillon<Integer> p = m2;
//		int cpt=0;
//		while (p != null) {
//			cpt++;
//			System.out.println("Elem: "+cpt+" ==> "+p.info());
//			p = p.suiv();
//		}
//
//	}
}

record Maillon<T>(T info, Maillon<T> suiv) {
}
