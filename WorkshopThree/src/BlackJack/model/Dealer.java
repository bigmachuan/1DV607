package BlackJack.model;

//import BlackJack.model.rules.*;
import BlackJack.model.AbstractFactoryPatternRules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinStrategy m_winStrategy;
  
  private void GetAcard(Player p) {
	  Card c=m_deck.GetCard();
	  c.Show(true);
	  p.DealCard(c);
  }

  public Dealer(INewGameStrategy m_newGameRule,IHitStrategy m_hitRule,IWinStrategy m_winStrategy) {
  
    this.m_newGameRule = m_newGameRule;
    this.m_hitRule = m_hitRule;
    this.m_winStrategy= m_winStrategy;
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(m_deck, this, a_player);   
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      GetAcard(a_player);
      return true;
    }
    return false;
  }
  
  public boolean Stand(){
	  if(m_deck!=null){
		  ShowHand();
		  
		  for(Card c : GetHand()){
			  c.Show(true);
			  
		  }
		  
		  while(m_hitRule.DoHit(this))
		  {
			  GetAcard(this);
		  }
		  return true;
	  }
	  return false;
  }

  public boolean IsDealerWinner(Player a_player) {
	  
	  return m_winStrategy.DealerWin(this, a_player);
	  
	  
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }
  
}