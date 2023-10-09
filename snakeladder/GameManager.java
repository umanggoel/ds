package snakeladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameManager {
    Map<Integer, Game> map = new HashMap<>();
    BoardManager boardManager = new BoardManager();

    public GameManager(BoardManager boardManager) {
        this.boardManager = boardManager;
    }

    int createGame(Integer boardId) {
        Game game = new Game();
        game.state = State.WAITING;
        game.currentPlayer = 0;
        game.boardId = boardId;
        game.players = new ArrayList<>();
        game.id = IDGen.getID();
        map.put(game.id,game);
        return game.id;
    }

    void startGame(Integer gameId) {
        if(map.get(gameId) == null) return;
        map.get(gameId).state = State.STARTED;
    }

    void addPlayer (Integer gameId, Player player) {
        if(map.get(gameId) == null || map.get(gameId).state != State.WAITING ) {
            return;
        }
        map.get(gameId).players.add(player);
    }

    Integer getNextPlayer(Integer gameId) {
        if(map.get(gameId) == null) return  -1;
        Game game = map.get(gameId);
        game.currentPlayer++;
        if(game.currentPlayer >= game.players.size()) {
            game.currentPlayer = 0;
        }
        System.out.println("Next Player:"+ game.currentPlayer);
        return game.currentPlayer;
    }

    boolean isGameOver(Integer gameId) {
        return map.get(gameId) != null && map.get(gameId).state == State.FINISHED;
    }

    int getWinner(Integer gameId) {
        if(map.get(gameId) != null && map.get(gameId).state == State.FINISHED){
            return map.get(gameId).currentPlayer;
        }
        return -1;
    }

    State getState(Integer gameId) {
        return map.get(gameId).state;
    }

    void updateGameWithDiceThrown(Integer gameId , Integer diceNumber) {
        if(map.get(gameId) == null) {
            return;
        }

        Game game = map.get(gameId);

        if(game.state != State.STARTED) return;

        Player p = game.players.get(game.currentPlayer);
        int current = p.currentpos;

        int newPos = boardManager.getNewPos(game.boardId,current, diceNumber);

        int boardSize = boardManager.getBoardSize(game.boardId);
        if(newPos >= boardSize) {
            game.state = State.FINISHED;
            p.isWinner = true;
            p.currentpos = newPos;
            return;
        }

        p.currentpos = newPos;
    }

}
