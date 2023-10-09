package snakeladder;

import java.util.Random;
import java.util.random.RandomGenerator;

public class DiceUtility {

    static int throwDice(){

        Random r = new Random();
        return  1 + r.nextInt(6);
    }
}
