package log121.lab3.api;

public class Game {

	private final PlayerCollection players = new PlayerCollection();

	private final DiceCollection dices = new DiceCollection();

	private GameStrategy strategy;

	public Game() {
	}

	public void evaluateTurnScore() {
		strategy.evaluateTurnScore(this);
	}

	public void evaluateWinner() {
		strategy.evaluateWinner(this);
	}

	public PlayerCollection getPlayers() {
		return players;
	}

	public DiceCollection getDices() {
		return dices;
	}

	public GameStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(GameStrategy strategy) {
		this.strategy = strategy;
	}
}
