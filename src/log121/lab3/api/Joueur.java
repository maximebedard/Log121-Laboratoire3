package log121.lab3.api;

public class Joueur implements Comparable<Joueur> {

	private String name;
	private boolean hasHand = false;

	private static final int SCORE_DEFAULT = 0;
	private int score = SCORE_DEFAULT;

	public Joueur(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Joueur o) {
		return Integer.compare(this.score, o.score);
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void increaseScore(int value) {
		score += value;
	}

	public boolean hasHand() {
		return hasHand;
	}

	public void setHasHand(boolean hasHand) {
		this.hasHand = hasHand;
	}

}
