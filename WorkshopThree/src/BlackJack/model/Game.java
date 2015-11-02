package BlackJack.model;

import BlackJack.model.AbstractFactoryPatternRules.*;

public class Game {

  private Dealer m_dealer;
  private Player m_player;

  public Game()
  {
    AbstractFactory HitStrategyFactory=FactoryProducer.getFactory("HitStrategy");
    IHitStrategy hit=HitStrategyFactory.getHitStrategy("Soft17Strategy");
    AbstractFactory NewGameStrategyFactory=FactoryProducer.getFactory("NewGameStrategy");
    INewGameStrategy NG=NewGameStrategyFactory.getNewGameStrategy("AmericanNewGameStrategy");
    AbstractFactory WinStrategy=FactoryProducer.getFactory("WinStrategy");
    IWinStrategy Win=WinStrategy.getWinStrategy("PlayerWinStrategy");
    
	  
	m_dealer = new Dealer(NG,hit,Win);
    m_player = new Player();
    
  }
    
    
  public boolean IsGameOver()
  {
    return m_dealer.IsGameOver();
  }
  
  public boolean IsDealerWinner()
  {
    return m_dealer.IsDealerWinner(m_player);
  }
  
  public boolean NewGame()
  {
    return m_dealer.NewGame(m_player);
  }
  
  public boolean Hit()
  {
    return m_dealer.Hit(m_player);
  }
  
  public boolean Stand()
  {
    return m_dealer.Stand();
  }
  
  public Iterable<Card> GetDealerHand()
  {
    return m_dealer.GetHand();
  }
  
  public Iterable<Card> GetPlayerHand()
  {
    return m_player.GetHand();
  }
  
  public int GetDealerScore()
  {
    return m_dealer.CalcScore();
  }
  
  public int GetPlayerScore()
  {
    return m_player.CalcScore();
  }
  
  public void SubscribeToNewCard(IObserver observer)
  {
	  m_player.SubscribeToNewCard(observer);
	  m_dealer.SubscribeToNewCard(observer);
  }
    
  
}