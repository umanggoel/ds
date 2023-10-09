package snakeladder;

public class IDGen {

    private static int id = 1;

    static int getID() {
        id = id+1;
        return id;
    }

}
