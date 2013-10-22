package log121.lab3.api;

public class Player implements Comparable<Player> {

	private String name;

	private static final int SCORE_DEFAULT = 0;
	private int score = SCORE_DEFAULT;

	public Player(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Player o) {
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
	
	public void increaseScore(int value){
		score += value;
	}

}
