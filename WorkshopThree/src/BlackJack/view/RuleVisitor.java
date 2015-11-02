package BlackJack.view;

public interface RuleVisitor {
	
	public void visit(Rule rule);
	public void visit(HitStrategy hitStrategy);
	public void visit(NewGameStrategy newGameStrategy);
	public void visit(WinStrategy winStrategy);

}
