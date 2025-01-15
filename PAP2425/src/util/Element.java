package util;

import java.util.Objects;

public class Element<T> {
	private T info;
	private Element<T> suiv;

	/**
	 * @param info
	 * @param suiv
	 */
	public Element(T info, Element<T> suiv) {
		this.info = info;
		this.suiv = suiv;
	}

	/**
	 * @param info
	 */
	public Element(T info) {
		this.info = info;
		this.suiv = null;
	}

	/**
	 * @return the info
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(T info) {
		this.info = info;
	}

	/**
	 * @return the suiv
	 */
	public Element<T> getSuiv() {
		return suiv;
	}

	/**
	 * @param suiv the suiv to set
	 */
	public void setSuiv(Element<T> suiv) {
		this.suiv = suiv;
	}

	@Override
	public int hashCode() {
		return Objects.hash(info, suiv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return Objects.equals(info, other.info) && Objects.equals(suiv, other.suiv);
	}

	@Override
	public String toString() {
		return "Element [info=" + info + ", suiv=" + suiv + "]";
	}

}
