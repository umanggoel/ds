package com.company.arrays;

import java.util.Arrays;

public class MakeSquare473 {

    public static void main(String[] args) {
        MakeSquare473 makeSquare473 = new MakeSquare473();
        int side[] = {5,5,5,5,4,4,4,4,3,3,3,3};
        makeSquare473.makesquare(side);
    }

    public boolean makesquare(int[] matchsticks) {

        int len = matchsticks.length;
        Arrays.sort(matchsticks);
        int sum = 0;
        for (Integer i : matchsticks) {
            sum = sum + i;
        }

        if (sum % 4 != 0) return false;
        int side = sum / 4;

        if (matchsticks[len - 1] > side) return false;

        int count = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            if (matchsticks[i] != -1) {
                if (isSidePossible(matchsticks, side, i)) {
                    count++;
                }
            }
        }


        return count == 4;
    }

    boolean isSidePossible(int[] sticks, int side, int index) {
        if (side == 0) return true;
        if (sticks[index] == side) {
            sticks[index] = -1;
            return true;
        }
        int newSide = side - sticks[index];
        if (newSide < 0) return false;

        int temp = sticks[index];
        sticks[index] = -1;

        for (int i = 0; i < sticks.length; i++) {
            if (sticks[i] != -1) {
                if (isSidePossible(sticks, newSide, i)) return true;
            }
        }

        sticks[index] = temp;
        return false;

    }
}
