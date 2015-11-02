package BlackJack.model.AbstractFactoryPatternRules;

public class FactoryProducer {
	
	public static AbstractFactory getFactory(String choice){
		
		if(choice.equalsIgnoreCase("HitStrategy"))
		{
			return new HitStrategyFactory();
		}
		else if(choice.equalsIgnoreCase("NewGameStrategy"))
		{
			return new NewGameStrategyFactory();
		}
		else if(choice.equalsIgnoreCase("WinStrategy"))
		{
			return new WinStrategyFactory();
		}
		
		return null;
		
	}

}
