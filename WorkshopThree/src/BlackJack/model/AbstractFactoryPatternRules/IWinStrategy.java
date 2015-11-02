package BlackJack.model.AbstractFactoryPatternRules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface IWinStrategy {
	
	boolean DealerWin(Dealer a_dealer,Player a_player);

}
