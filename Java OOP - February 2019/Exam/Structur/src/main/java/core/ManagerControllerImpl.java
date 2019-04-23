package core;

import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.players.Advanced;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.ConstantMessages.*;


public class ManagerControllerImpl implements ManagerController {

    private Battlefield battlefield;
    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private List<Card> cards;
    private Map<String, Player> players;

    public ManagerControllerImpl() {
        this.battlefield = new BattleFieldImpl();
        this.playerRepository = new PlayerRepositoryImpl();
        this.cardRepository = new CardRepositoryImpl();
        this.players = new HashMap<>();
        this.cards = new ArrayList<>();
    }

    @Override
    public String addPlayer(String type, String username) {

        Player player = null;

        if (type.equalsIgnoreCase("Beginner")) {
            player = new Beginner(cardRepository, username);
        }else {
            player = new Advanced(cardRepository, username);
        }

        playerRepository.add(player);
        players.putIfAbsent(username, player);
         return String.format(SUCCESSFULLY_ADDED_PLAYER, type, username);
    }

    @Override
    public String addCard(String type, String name) {
        Card card = null;

        if (type.equalsIgnoreCase("Trap")){
            card = new TrapCard(name);
        }else {
            card = new MagicCard(name);
        }

        cardRepository.add(card);
        cards.add(card);
        return String.format(SUCCESSFULLY_ADDED_CARD, type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {

        Card result = null;
        for (Card card : cards) {
            if (card.getName().equalsIgnoreCase(cardName)){
                result = card;
            }
        }

        players.get(username).getCardRepository().add(result);
        return String.format(SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {

        Player player = playerRepository.find(attackUser);
        Player player1 = playerRepository.find(enemyUser);

        battlefield.fight(player, player1);
        return String.format(FIGHT_INFO, attackUser, enemyUser);
    }

    @Override
    public String report() {
        return null;
    }
}
