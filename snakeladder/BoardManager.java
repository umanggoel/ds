package snakeladder;

import java.util.HashMap;
import java.util.Map;

public class BoardManager {

    Map<Integer, Board> boards = new HashMap<>();

    int createNewBoard() {
        Board b = new Board();
        b.boardId = IDGen.getID();
        b.snakes = new HashMap<>();
        b.ladders = new HashMap<>();
        boards.put(b.boardId,b);
        return b.boardId;
    }

    int getNewPos(int boardId, int currentPos, int diceNumber) {

        Board b = boards.get(boardId);
        int newPos = currentPos + diceNumber;

        if(b.snakes.get(newPos) != null) {
            newPos = b.snakes.get(newPos).end;
        }

        if(b.ladders.get(newPos) != null) {
            newPos = b.ladders.get(newPos).end;
        }

        return  newPos;
    }
    void addElementtoBoard(Integer boardId, ElementType type, int start, int end) {
        if(boards.get(boardId) == null) {
            return;
        }

        int boardSize = boards.get(boardId).boardSize;

        if(type == ElementType.Snake)  {
            SpecialElement element = generateSnake(start, end, boardSize);
            if(element == null) return;
            boards.get(boardId).snakes.put(element.start,element);
            return;
        }
        if(type == ElementType.Ladder) {
            SpecialElement element = generateLadder(start, end, boardSize);
            if(element == null) return;
            boards.get(boardId).ladders.put(element.start,element);
        }

    }

    SpecialElement generateSnake(int start, int end, int boardSize) {
        if( start > boardSize || end < 0 || end >boardSize || start <= end) return null;
        SpecialElement element = new SpecialElement();
        element.start =start;
        element.end = end;
        return element;
    }

    SpecialElement generateLadder(int start , int end, int boardSize) {
        if( start <0 || end < 0 || end >boardSize || start >= end) return null;
        SpecialElement element = new SpecialElement();
        element.start =start;
        element.end = end;
        return element;
    }

    public int getBoardSize(Integer boardId) {
        return boards.get(boardId).boardSize;
    }
}
