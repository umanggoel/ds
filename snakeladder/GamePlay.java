package snakeladder;

public class GamePlay {

    static  BoardManager boardManager = new BoardManager();
    static GameManager gameManager = new GameManager(boardManager);

    public static void main(String[] args) {
            int id = boardManager.createNewBoard();
            int gameId = gameManager.createGame(id);
            Player p1= new Player();
            Player p2 = new Player();
            gameManager.addPlayer(gameId, p1);
            gameManager.addPlayer(gameId, p2);
            gameManager.startGame(gameId);

            int diceNumber;
            State gameState = gameManager.getState(gameId);
            while(true) {
                diceNumber = DiceUtility.throwDice();
                gameManager.getNextPlayer(gameId);
                System.out.println("Dice thrown :" + diceNumber);
                gameManager.updateGameWithDiceThrown(gameId, diceNumber);
                gameState = gameManager.getState(gameId);
                if(gameState == State.FINISHED) {
                    System.out.println("game over :" + gameId);
                    System.out.println("game winner :" + gameManager.getWinner(gameId));
                    break;
                }
            }

    }
}
