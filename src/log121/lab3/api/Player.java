package log121.lab3.api;

public class Player implements Comparable<Player> {

	private String name;

	private int score;

	public Player(String name) {
		this.name = name;
		this.score = 0;
	}

	@Override
	public int compareTo(Player o) {
		return Integer.compare(this.score, o.score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
