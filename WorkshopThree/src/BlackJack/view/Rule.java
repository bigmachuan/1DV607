package BlackJack.view;

public class Rule implements RulePart{

	RulePart[] parts;
	
	public Rule(){
		parts= new RulePart[]{new HitStrategy(),new NewGameStrategy(),new WinStrategy()};
	}
	
	
	
	@Override
	public void accept(RuleVisitor ruleVistor) {
		
		for(int i=0;i<parts.length;i++){
			parts[i].accept(ruleVistor);
		}
		ruleVistor.visit(this);
	}



}
