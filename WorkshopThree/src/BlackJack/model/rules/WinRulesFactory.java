package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class WinRulesFactory {
	
	private Player a_player;
	private Dealer a_dealer;
	private final int g_maxScore=21;
	private boolean DealerWin=true;
	
	public WinRulesFactory(Player a_player,Dealer a_dealer){
		
		this.a_player=a_player;
		this.a_dealer=a_dealer;
		
	}
	
	public boolean DealerWin(){
		
		if (a_player.CalcScore() > g_maxScore) {
		      return true;
		    } else if (a_dealer.CalcScore() > g_maxScore) {
		      return false;
		    }
		
		if(ScoreEqual())
		{
			EqualPlayerWin();
			EqualDealerWin();
			
			return DealerWin;
		}
		else
		{
			return DealerNormalWin();
		}
		
	}
	
	public boolean ScoreEqual(){
		return a_player.CalcScore()==a_dealer.CalcScore();
	}
	public boolean DealerNormalWin() {
	   
	    return a_dealer.CalcScore() > a_player.CalcScore();
	}
	
	
	
	
	public void EqualDealerWin(){
		//need add rules
		DealerWin=true;
		
	}
	
	public void EqualPlayerWin(){
		//need add rules
		DealerWin=false;
	}
	
	
	
}
