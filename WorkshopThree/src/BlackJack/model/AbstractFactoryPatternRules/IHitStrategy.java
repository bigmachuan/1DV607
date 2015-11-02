package BlackJack.model.AbstractFactoryPatternRules;

import BlackJack.model.Player;

public interface IHitStrategy {
    boolean DoHit(Player a_dealer);
}