package BlackJack.view;

public class RuleDisplayVistor implements RuleVisitor{

	@Override
	public void visit(Rule rule) {
		String line="";
		for(int i=0;i<100;i++)
		{
			line=line+"*";
		}
		System.out.println(line);
		
	}

	@Override
	public void visit(HitStrategy hitStrategy) {
		System.out.println("HitStrategy is Soft17 Strategy");
		
	}

	@Override
	public void visit(NewGameStrategy newGameStrategy) {
		System.out.println("NewGameStrategy is AmericanNewGameStrategy");
		
	}

	@Override
	public void visit(WinStrategy winStrategy) {
		System.out.println("WinStrategy is PlayerWinStrategy (When Dealer and Player has equal hand as 21, Player wins)");
		
	}

}
