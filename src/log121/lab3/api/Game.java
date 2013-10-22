package log121.lab3.api;

public class Game {

	private static final int CURRENT_TURN_DEFAULT = 1;
	private static final int NB_TURN_DEFAULT = 1;

	/**
	 * Instance de la liste de tous les joueurs
	 */
	private PlayerCollection players = new PlayerCollection();

	/**
	 * Instance de la liste de tous les dés
	 */
	private DiceCollection dices = new DiceCollection();

	/**
	 * Stragégie pour évaluer le score
	 */
	private GameStrategy strategy;

	/**
	 * Usine qui permet de construire toutes les composantes du jeu
	 */
	// private GameFactory factory;

	/**
	 * Nombre total de tours du jeu
	 */
	private int nbTurns = NB_TURN_DEFAULT;

	/**
	 * Tour actuel
	 */
	private int currentTurn = CURRENT_TURN_DEFAULT;

	/**
	 * Évalue le score pour le tour actuel et débute le prochain tour
	 */
	public void evaluateTurnScore() {
		if (strategy == null)
			throw new NullPointerException();

		strategy.evaluateTurnScore(this);
		currentTurn++;
	}

	/**
	 * Évalue le gagnant de la partie
	 */
	public void evaluateWinner() {
		if (strategy == null)
			throw new NullPointerException();
		strategy.evaluateWinner(this);
	}

	/**
	 * Retourne la liste de tous les dés
	 * 
	 * @return
	 */
	public DiceCollection getDices() {
		return dices;
	}

	/**
	 * Assigne la collection de dés à la partie
	 * @param dices
	 */
	public void setDices(DiceCollection dices) {
		this.dices = dices;
	}

	/**
	 * Retourne la liste de tous les joueurs
	 * 
	 * @return
	 */
	public PlayerCollection getPlayers() {
		return players;
	}

	/**
	 * Assigne la collection de joueur à la partie
	 * @param players
	 */
	public void setPlayers(PlayerCollection players) {
		this.players = players;
	}

	/**
	 * Retourne la stratégie pour évaluer le score
	 * 
	 * @return
	 */
	public GameStrategy getStrategy() {
		return strategy;
	}

	/**
	 * Retourne le nombre de tour de la partie
	 * 
	 * @return nombre de tours total
	 */
	public int getNbTurns() {
		return nbTurns;
	}

	/**
	 * Assigne le nombre de tour à la partie
	 */
	public void setNbTurns(int nbTurns) {
		this.nbTurns = nbTurns;
	}

	/**
	 * Assigne la stratégie pour évaluer le score à la partie
	 * 
	 * @param strategy
	 */
	public void setStrategy(GameStrategy strategy) {
		this.strategy = strategy;
	}
	
	/**
	 * Retourne le numéro du tour actuel
	 * 
	 * @return retourne le tour actuel
	 */
	public int getCurrentTurn() {
		return currentTurn;
	}

}
