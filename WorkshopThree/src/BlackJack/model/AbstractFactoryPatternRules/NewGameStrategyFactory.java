package BlackJack.model.AbstractFactoryPatternRules;

public class NewGameStrategyFactory extends AbstractFactory{

	@Override
	public
	IHitStrategy getHitStrategy(String hitstrategy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public
	INewGameStrategy getNewGameStrategy(String newgamestrategy) {
		
		if(newgamestrategy==null)
		{
			return null;
		}
		if(newgamestrategy.equalsIgnoreCase("AmericanNewGameStrategy"))
		{
			return new AmericanNewGameStrategy();
		}
		else if(newgamestrategy.equalsIgnoreCase("InternationalNewGameStrategy"))
		{
			return new InternationalNewGameStrategy();
		}
		
		
		return null;
	}

	@Override
	public
	IWinStrategy getWinStrategy(String winstrategy) {
		// TODO Auto-generated method stub
		return null;
	}

}
