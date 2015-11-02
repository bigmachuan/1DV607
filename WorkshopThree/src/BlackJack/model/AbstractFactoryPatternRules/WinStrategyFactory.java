package BlackJack.model.AbstractFactoryPatternRules;

public class WinStrategyFactory extends AbstractFactory{

	@Override
	public
	IHitStrategy getHitStrategy(String hitstrategy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public
	INewGameStrategy getNewGameStrategy(String newgamestrategy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public
	IWinStrategy getWinStrategy(String winstrategy) {
		
		if(winstrategy==null)
		{
			return null;
		}
		if(winstrategy.equalsIgnoreCase("BasicWinStrategy"))
		{
			return new BasicWinStrategy();
		}
		else if(winstrategy.equalsIgnoreCase("PlayerWinStrategy"))
		{
			return new PlayerWinStrategy();
		}
		
		
		return null;
	}

}
