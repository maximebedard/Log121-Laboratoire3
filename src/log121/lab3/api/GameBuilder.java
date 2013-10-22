package log121.lab3.api;

public abstract class GameBuilder {
	
	private int nbTurns;
	private GameStrategy strategy;
	
	public GameBuilder(GameStrategy strategy, int nbTurns) {
		
	}

	public final Game buildGame() {
		Game game = new Game();
		game.setPlayers(makePlayers());
		game.setDices(makeDices());
		game.setNbTurns(nbTurns);
		return game;
	}

	protected abstract PlayerCollection makePlayers();

	protected abstract DiceCollection makeDices();

}
