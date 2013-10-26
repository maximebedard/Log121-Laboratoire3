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
	 * Instance du joueur à qui est le tour
	 */
	private Player currentPlayer = null;

	/**
	 * Stragégie pour évaluer le score
	 */
	private final GameStrategy strategy;

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
	
	public Game(int nbTurns, GameStrategy strategy){
		if(nbTurns < 0 || strategy == null)  
			throw new IllegalArgumentException();
		
		this.nbTurns = nbTurns;
		this.strategy = strategy;
	}
	

	/**
	 * Évalue le score pour le tour actuel et débute le prochain tour
	 */
	public void evaluateTurnScore() {
		
		for(Player p : players){
			currentPlayer = p;
			p.setHasHand(true);
			while(p.hasHand())
			{
				for(Dice dice : dices)
					dice.roll();
				strategy.evaluateTurnScore(this);
			}
		}
		currentTurn++;
	}

	/**
	 * Évalue le gagnant de la partie
	 */
	public void evaluateWinner() {
		while(currentTurn < nbTurns) 
			evaluateTurnScore();
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
	 * Retourne le numéro du tour actuel
	 * 
	 * @return retourne le tour actuel
	 */
	public int getCurrentTurn() {
		return currentTurn;
	}
	
	public Player getCurrentPlayer(){
		return currentPlayer == null ? players.premier() : currentPlayer;
	}
	
	
}
