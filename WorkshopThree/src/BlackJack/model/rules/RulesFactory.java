package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetBasicHitRule() {
    return new BasicHitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
  
  public IHitStrategy GetSoft17Strategy(){
	  return new Soft17Strategy();
  }
  
  public IWinStrategy GetBasicWinStrategy(){
	  return new BasicWinStrategy();
  }
  
  public IWinStrategy GetPlayerWinStrategy(){
	  return new PlayerWinStrategy();
  }
}