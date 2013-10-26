package log121.lab3.bunco;

import log121.lab3.api.Ensemble;
import log121.lab3.api.Ensembles;
import log121.lab3.api.DiceCollection;
import log121.lab3.api.Game;
import log121.lab3.api.GameStrategy;
import log121.lab3.api.Player;
import log121.lab3.api.Dice;
import log121.lab3.api.Predicate;

public class BuncoGameStrategy implements GameStrategy {

	public static final int MAX_TURNS = 6;
	public static final int BUNCO_SCORE = 21;
	public static final int IDENTICAL_SCORE = 5;

	@Override
	public void evaluateTurnScore(Game game) {
		if (game.getCurrentTurn() > MAX_TURNS)
			return;

		int score = 0;
		final DiceCollection dices = game.getDices();

		DiceCollection matches = getDicesMatches(dices, dices.premier());

		if (matches.taille() == MAX_TURNS
				&& matches.premier().getValue() == game.getCurrentTurn()) {
			score += BUNCO_SCORE;
			game.getCurrentPlayer().setHasHand(false);
		} else if (matches.taille() == MAX_TURNS) {
			score += IDENTICAL_SCORE;
		} else {
			Dice gameTurnDice = new Dice();
			gameTurnDice.setValue(game.getCurrentTurn());
			matches = getDicesMatches(dices, gameTurnDice);
			if (matches.taille() > 0)
				score += matches.taille();
			else
				game.getCurrentPlayer().setHasHand(false);
		}

		game.getCurrentPlayer().setScore(score);
	}

	private DiceCollection getDicesMatches(DiceCollection dices,
			final Dice toMatch) {
		return (DiceCollection) dices.matches(new Predicate<Dice>() {
			@Override
			public boolean compare(Dice element) {
				return element.compareTo(toMatch) == 0;
			}
		});
	}

	@Override
	public Ensemble<Player> evaluateWinner(Game game) {
		return Ensembles.quicksort(game.getPlayers());
	}

}
