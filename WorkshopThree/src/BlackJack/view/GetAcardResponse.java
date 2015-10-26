package BlackJack.view;

import java.util.Observable;
import java.util.Observer;

public class GetAcardResponse implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		
		GetAcard c= (GetAcard)o;
		c.Stop();
		System.out.println("The New Card is "+"" + c.getCard().GetValue() + " of " + c.getCard().GetColor());
	}
	
}
