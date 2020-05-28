package com.company.arrays;

public class Main {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        //combinationSum.combinationSum(new int[]{2,3,6,7},7);

        FirstMissingPositive firstMissingPositive= new FirstMissingPositive();
     // firstMissingPositive.firstMissingPositive(new int[]{1});

        MinJump minJump = new MinJump();
        //minJump.canJump(new int[]{1,0,1,0});

        SurroundedRegions surroundedRegions = new SurroundedRegions();
        //surroundedRegions.solve(new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}});

        MaxAreaisland maxAreaisland = new MaxAreaisland();
      //  System.out.println(maxAreaisland.maxAreaOfIsland(new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}}));
      //  System.out.println(maxAreaisland.maxAreaOfIsland(new int[][]{{0,1}}));

        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
       // mergeSortedArrays.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);

        //MaxProduct.maxProduct(new int[]{-2,3,-4});

        PrefixOfWord prefixOfWord = new PrefixOfWord();
      //  System.out.println(prefixOfWord.isPrefixOfWord("i love eating burg","burg"));

        int[][] stones = new int[][]{{1,0,1},{0,1,0},{1,0,1}};
        StonesRemovalGame stonesRemovalGame = new StonesRemovalGame();
        stonesRemovalGame.removeStones(stones);
    }
}
