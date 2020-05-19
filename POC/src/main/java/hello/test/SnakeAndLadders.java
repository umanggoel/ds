import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakeAndLadders {

	private static int WINPOINT=100;
	static Map < Integer , Integer > snake = new HashMap < Integer , Integer >();
    static Map < Integer , Integer > ladder = new HashMap< Integer , Integer >();
     
    {
        snake.put(99,54);
        snake.put(70,55);
        snake.put(52,42);
        snake.put(25,2);
        snake.put(95,72);
         
        ladder.put(6,25);
        ladder.put(11,40);
        ladder.put(60,85);
        ladder.put(46,90);
        ladder.put(17,69);
    }
    
    private static int rollDice() {
    		int result = 1;
    		Random r = new Random();
    		result = r.nextInt(7);
    		if(result == 0) {
    			result = 1;
    		}
    		return result;
    }
    
    private static int turnResult(int playerCount, int currentChance) {
    		int temp = playerCount+currentChance;
    		if(snake.get(temp) != null) {
    			return snake.get(temp);
    		}
    		if(ladder.get(temp) != null) {
    			return ladder.get(temp);
    		}
    		return temp;
    }
    
    private static boolean hasWon(int playerCount) {
    		if(playerCount >= WINPOINT) {
    			return true;
    		}
    		return false;
    }
    
    public static void main(String[] args) {
    	 int player1 = 0, player2=0;
    	 int count = -1;
		while(!hasWon(player1) && !hasWon(player2)) {
			int chance = rollDice();
			if(count == -1) {
				player1 = turnResult(player1, chance);
				count = 0;
			}else {
				player2 = turnResult(player2, chance);
				count =-1;
			}
		}
		
		if(count == 0) {
			System.out.println("player 1 score"+player1);
		}else {
			System.out.println("player 2 score"+player2);			
		}
	}
}
