package BlackJack.view;

public class WinStrategy implements RulePart{
	
	@Override
	public void accept(RuleVisitor ruleVistor) {
		ruleVistor.visit(this);
		
	}


}
