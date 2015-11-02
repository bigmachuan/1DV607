package BlackJack.model;

public interface ICard {
	
	void SubscribeToNewCard(IObserver observer);
	void Notify(Card card);

}
