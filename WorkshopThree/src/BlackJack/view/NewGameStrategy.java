package BlackJack.view;

public class NewGameStrategy implements RulePart{
	@Override
	public void accept(RuleVisitor ruleVistor) {
		ruleVistor.visit(this);
		
	}

}
