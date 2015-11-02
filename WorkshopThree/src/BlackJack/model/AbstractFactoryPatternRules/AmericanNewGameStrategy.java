package BlackJack.model.AbstractFactoryPatternRules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;
import BlackJack.model.AbstractFactoryPatternRules.InternationalNewGameStrategy;;

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    
    
    InternationalNewGameStrategy.dealCard(a_deck, a_dealer, a_player);
    
    Card c;
    c = a_deck.GetCard();
    c.Show(false);
    a_dealer.DealCard(c);
    
    return true;
  }
}