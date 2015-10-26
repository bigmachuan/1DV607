package BlackJack.view;

import java.util.Observable;

import BlackJack.model.Card;

public class GetAcard extends Observable{
	
	private Card c=null;

	public void setCard(Card c){
		
		this.c=c;
		setChanged();
		notifyObservers(this);
		
	}
	
	public Card getCard(){
		return c;
	}
	
	public void Stop(){
		try{
		    Thread.sleep(500);
		}catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}
	
}
