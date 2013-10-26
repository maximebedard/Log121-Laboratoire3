package log121.lab3.api;

public interface GameStrategy {

	public void evaluateTurnScore(Game game);
	
	public Ensemble<Player> evaluateWinner(Game game);
	
}
