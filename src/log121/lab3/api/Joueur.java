package log121.lab3.api;

public class Joueur implements Comparable<Joueur> {

	private String name;

	private static final int SCORE_DEFAULT = 0;
	private int score = SCORE_DEFAULT;

	/**
	 * Créé un nouveau joueur avec un nom
	 * @param name
	 */
	public Joueur(String name) {
		if (name == null || name.equals(""))
			throw new IllegalArgumentException();

		this.name = name;
	}

	/**
	 * Compare le score du joueur
	 */
	@Override
	public int compareTo(Joueur o) {
		if (o == null)
			throw new IllegalArgumentException();

		return Integer.compare(this.score, o.score);
	}

	/**
	 * Retourne le nom du joueur
	 * @return nom du joueur
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retourne le score du joueur
	 * @return score du joueur
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Assigne le score au joueur
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Augmente le score du joueur
	 * @param value
	 */
	public void increaseScore(int value) {
		score += value;
	}

	/**
	 * Retourne le nom du joueur
	 */
	@Override
	public String toString() {
		return name;
	}

}
