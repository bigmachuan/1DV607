package BlackJack.view;

public class HitStrategy implements RulePart{
	
	@Override
	public void accept(RuleVisitor ruleVistor) {
		ruleVistor.visit(this);
		
	}

}
