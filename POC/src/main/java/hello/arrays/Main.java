package com.company.arrays;

import com.company.graph.CourseSchedule;

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
      //  stonesRemovalGame.removeStones(stones);

        LongestConsecutiveSequence128 longestConsecutiveSequence128= new LongestConsecutiveSequence128();
        //longestConsecutiveSequence128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});

        CourseSchedule courseSchedule = new CourseSchedule();
        //courseSchedule.canFinish(4,new int[][]{{0,1},{3,1},{1,3},{3,2}});
        //courseSchedule.canFinish(3,new int[][]{{0,1},{0,2},{1,2}});

       // courseSchedule.findOrder(2,new int[][]{{0,1}});

        MinFibonicciSum minFibonicciSum = new MinFibonicciSum();
       // System.out.println(minFibonicciSum.findMinFibonacciNumbers(1000000));

        int mat [][] = {{9,9,4},
                {6,6,8},
                {2,1,1}};
        LongestIncreasingPath longestIncreasingPath = new LongestIncreasingPath();
        //longestIncreasingPath.longestIncreasingPath(mat);

        int mat1 [][] = {{2,1,1},
                {1,1,0},
                {0,1,1}};
        RottingOranges rottingOranges = new RottingOranges();
        rottingOranges.orangesRotting(mat1);
    }
}
