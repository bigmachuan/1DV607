package BlackJack.model.AbstractFactoryPatternRules;

public class HitStrategyFactory extends AbstractFactory{

	@Override
	public
	IHitStrategy getHitStrategy(String hitstrategy) {
		
		if(hitstrategy==null)
		{
			return null;
		}
		if(hitstrategy.equalsIgnoreCase("BasicHitStrategy"))
		{
			return new BasicHitStrategy();
		}
		else if(hitstrategy.equalsIgnoreCase("Soft17Strategy"))
		{
			return new Soft17Strategy();
		}
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
