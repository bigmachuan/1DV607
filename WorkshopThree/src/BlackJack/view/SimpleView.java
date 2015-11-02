package BlackJack.view;


public class SimpleView implements IView 
{
	
	private BlackJack.view.RulePart rule=new Rule();
	
        public void DisplayWelcomeMessage()
        {
          System.out.println("Hello Black Jack World");
          System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
          System.out.println("The Play Rules:");
          rule.accept(new RuleDisplayVistor());
          System.out.println("\n");
        }

        public int GetInput()
        {
          try {
            return System.in.read();
          } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
          }
        }

        public void DisplayCard(BlackJack.model.Card a_card)
        {
            System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
        }

        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Player", a_hand, a_score);
        }

        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Dealer", a_hand, a_score);
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Has: ");
            for(BlackJack.model.Card c : a_hand)
            {
            	DisplayCard(c);
                
            }
            System.out.println("Score: " + a_score);
            System.out.println("");
        }

        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("GameOver: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Dealer Won!");
            }
            else
            {
                System.out.println("You Won!");
            }
            
        }
        public void PauseGame(){
        	System.out.print("Dealing.");
        	try {
				Thread.sleep(500);
				System.out.print(".");
        	    Thread.sleep(500);
        	    System.out.println(".");
        	    Thread.sleep(500);
        	    for(int clear = 0; clear < 1000; clear++)
        	    {
        	       System.out.println("\b") ;
        	    }
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	
        }
        
    }