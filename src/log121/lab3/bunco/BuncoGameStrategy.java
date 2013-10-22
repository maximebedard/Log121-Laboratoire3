package log121.lab3.bunco;

import log121.lab3.api.Collection;
import log121.lab3.api.Collections;
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

		//for (Player player : game.getPlayers()) {
		//	evaluateTurnScoreFor(game, player);
		//}
	}
	
	public int evaluateScore(int score, int gameTurn, final DiceCollection dices){
		
		Collection<Dice> matches = getDicesMatches(dices , dices.first());

		if(matches.size() == MAX_TURNS && matches.first().getValue() == gameTurn)
			score += BUNCO_SCORE;
		else if(matches.size() == MAX_TURNS) {
			score += IDENTICAL_SCORE;
			evaluateScore(score, gameTurn, dices);
		}
		else
		{
			Dice gameTurnDice = new Dice();
			gameTurnDice.setValue(gameTurn);
			matches = getDicesMatches(dices, gameTurnDice);
			
			if(matches.size() > 0){
				score += matches.size();
				evaluateScore(score, gameTurn, dices);
			}
		}
		
		return score;
	}
	
	private Collection<Dice> getDicesMatches(DiceCollection dices, final Dice toMatch)
	{
		return dices.matches(new Predicate<Dice>() {
			@Override
			public boolean compare(Dice element) {
				return element.compareTo(toMatch) == 0;
			}
		});
	}
	

	@Override
	public Collection<Player> evaluateWinner(Game game) {
		return Collections.quicksort(game.getPlayers());
	}

}
