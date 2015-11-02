package BlackJack.model.AbstractFactoryPatternRules;

public abstract class AbstractFactory {
	
	public abstract IHitStrategy getHitStrategy(String hitstrategy);
	public abstract INewGameStrategy getNewGameStrategy(String newgamestrategy);
	public abstract IWinStrategy getWinStrategy(String winstrategy);
	

}
