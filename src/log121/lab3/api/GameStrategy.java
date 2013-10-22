package log121.lab3.api;

public interface GameStrategy {

	public void evaluateTurnScore(Game game);
	
	public Collection<Player> evaluateWinner(Game game);
	
}
