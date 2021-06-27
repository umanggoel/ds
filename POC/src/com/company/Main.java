package com.company;

import com.company.arrays.Numbers;
import com.company.arrays.Numbers2;
import com.company.graph.DisjointSets;
import com.company.graph.Kruskal;
import com.company.graph.Prims;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,5},{2,3},{1,8},{3,5}};
        int[][] intervals2 = new int[][]{{7,9},{2,8},{1,3},{10,11},{10,16}};
        int[][] interval3 = {{1,3},{2,6},{8,10},{15,18}};
        int nums[] ={0,1,0,3,12};
        int nums2[] = {-2,1,-3,4,-1,2,1,-5,4};
        int nums3[] ={1,2,3,4};

        int[] n3 ={1,2,3,1,1};

        // System.out.println(repeatedNumber(Arrays.asList(1000274, 1000802, 1000914, 1000847, 1000073, 1000562, 1000741, 1000802, 1000965, 1000371, 1000406, 1000441, 1000179, 1000802, 1000552, 1000802, 1000100, 1000724, 1000024, 1000134, 1000313, 1000802, 1000977, 1000777, 1000206, 1000412, 1000802, 1000570, 1000802, 1000518, 1000691, 1000959, 1000903, 1000802, 1000802, 1000273, 1000802, 1000802, 1000265, 1000706, 1000677, 1000802, 1000843, 1000802, 1000061, 1000802, 1000802, 1000975, 1000403, 1000150, 1000959, 1000889, 1000177, 1000416, 1000491, 1000177, 1000807, 1000989, 1000489, 1000447, 1000802, 1000860, 1000104, 1000802, 1000570, 1000015, 1000802, 1000802, 1000593, 1000802, 1000802, 1000326, 1000802, 1000802, 1000120, 1000772, 1000965, 1000802, 1000887, 1000802, 1000567, 1000973, 1000577, 1000820, 1000922, 1000802, 1000982, 1000525, 1000369, 1000829, 1000740, 1000159, 1000909, 1000510, 1000402, 1000802, 1000802, 1000239, 1000247, 1000328, 1000427, 1000802, 1000519, 1000296, 1000114, 1000149, 1000802, 1000802, 1000107, 1000841, 1000017, 1000909, 1000192, 1000425, 1000088, 1000077, 1000506, 1000163, 1000465, 1000626, 1000371, 1000802, 1000179, 1000306, 1000159, 1000802, 1000802, 1000848, 1000138, 1000306, 1000802, 1000881, 1000828, 1000802, 1000008, 1000802, 1000456, 1000802, 1000880, 1000579, 1000434, 1000163, 1000188, 1000802, 1000802, 1000231, 1000945, 1000802, 1000070, 1000727, 1000802, 1000802, 1000802, 1000051, 1000644, 1000802, 1000802, 1000057, 1000967, 1000802, 1000802, 1000366, 1000802, 1000485, 1000802, 1000061, 1000212, 1000192, 1000577, 1000559, 1000802, 1000189, 1000802, 1000802, 1000107, 1000177, 1000011, 1000802, 1000987, 1000400, 1000802, 1000402, 1000024, 1000009, 1000118, 1000046, 1000349, 1000250, 1000282, 1000138, 1000405, 1000295, 1000802, 1000878, 1000166, 1000802, 1000135, 1000005, 1000723, 1000491, 1000802, 1000802, 1000802, 1000802, 1000786, 1000306, 1000802, 1000802, 1000802, 1000639, 1000683, 1000880, 1000329, 1000408, 1000822, 1000947, 1000802, 1000455, 1000037, 1000311, 1000802, 1000802, 1000339, 1000802, 1000519, 1000401, 1000802, 1000256, 1000802, 1000802, 1000503, 1000802, 1000787, 1000802, 1000802, 1000384, 1000456, 1000845, 1000802, 1000802, 1000000, 1000213, 1000629, 1000802, 1000226, 1000802, 1000802, 1000107, 1000100, 1000802, 1000587, 1000882, 1000049, 1000623, 1000802, 1000178, 1000788, 1000648, 1000802, 1000567, 1000802, 1000802, 1000802, 1000085, 1000109, 1000965, 1000353, 1000802, 1000802, 1000802, 1000982, 1000663, 1000829, 1000578, 1000753, 1000802, 1000802, 1000529, 1000060, 1000047, 1000802, 1000750, 1000780, 1000277, 1000802, 1000751, 1000590, 1000802, 1000953, 1000240, 1000218, 1000659, 1000802, 1000001, 1000766, 1000802, 1000508, 1000802, 1000802, 1000802, 1000028, 1000802, 1000493, 1000077, 1000427, 1000505, 1000752, 1000802, 1000747, 1000126, 1000269, 1000297, 1000394, 1000257, 1000708, 1000802, 1000802, 1000697, 1000802, 1000802, 1000802, 1000921, 1000559, 1000450, 1000206, 1000802, 1000802, 1000149, 1000031, 1000866, 1000721, 1000497, 1000654, 1000057, 1000802, 1000130, 1000523, 1000577, 1000750, 1000536, 1000339, 1000796, 1000802, 1000802, 1000197, 1000584, 1000939, 1000802, 1000633, 1000553, 1000124, 1000086, 1000619, 1000802, 1000415, 1000802, 1000125, 1000802, 1000104, 1000348, 1000464, 1000187, 1000887, 1000369, 1000281, 1000802, 1000802, 1000526, 1000685, 1000029, 1000922, 1000191, 1000802, 1000802, 1000802, 1000298, 1000802, 1000176, 1000295, 1000802, 1000802, 1000238, 1000802, 1000802, 1000314, 1000303, 1000802, 1000698, 1000309, 1000677, 1000606, 1000802, 1000701, 1000898, 1000579, 1000990, 1000513, 1000435, 1000192, 1000960, 1000324, 1000509, 1000906, 1000802, 1000492, 1000705, 1000641, 1000479, 1000662, 1000642, 1000791, 1000942, 1000802, 1000802, 1000100, 1000296, 1000802, 1000802, 1000533, 1000802, 1000038, 1000802, 1000254, 1000802, 1000802, 1000802, 1000802, 1000393, 1000802, 1000435, 1000484, 1000802, 1000847, 1000802, 1000360, 1000961, 1000544, 1000914, 1000802, 1000802, 1000663, 1000802, 1000802, 1000519, 1000802, 1000928, 1000802, 1000802, 1000802, 1000802, 1000258, 1000108, 1000544, 1000802, 1000169, 1000097, 1000802, 1000306, 1000977, 1000802, 1000153, 1000802, 1000802, 1000039, 1000099, 1000802, 1000468, 1000862, 1000802, 1000802, 1000802, 1000068, 1000802, 1000161, 1000179, 1000710, 1000802, 1000802, 1000802, 1000802, 1000540, 1000802, 1000115, 1000802, 1000802, 1000089, 1000802, 1000798, 1000802, 1000802, 1000544, 1000979, 1000850, 1000085, 1000197, 1000802, 1000802, 1000031, 1000704, 1000515, 1000802, 1000198, 1000382, 1000597, 1000613, 1000857, 1000798, 1000319, 1000266, 1000154, 1000753, 1000017, 1000004, 1000802 )));

        // System.out.println(1&1);

        int[][] grid =  {
                {9,9,0,8,9,0,5,7,2,2,7,0,8,0,2,4,8},
                {4,4,2,7,6,0,9,7,3,2,5,4,6,5,4,8,7},
                {4,9,7,0,7,9,2,4,0,2,4,4,6,2,8,0,7},
                {7,7,9,6,6,4,8,4,8,7,9,4,7,6,9,6,5},
                {1,3,7,5,7,9,7,3,3,3,8,3,6,5,0,3,6},
                {7,1,0,7,5,0,6,6,5,3,2,6,0,0,9,5,7},
                {6,5,6,3,8,1,8,6,4,4,3,4,9,9,3,3,1},
                {1,0,2,9,7,9,3,1,7,5,1,8,2,8,4,7,6},
                {9,6,7,7,4,1,4,0,6,5,1,9,0,3,2,1,7},
                {2,0,8,7,1,7,4,3,5,6,1,9,4,0,0,2,7},
                {9,8,1,3,8,7,1,2,8,3,7,3,4,6,7,6,6},
                {4,8,3,8,1,0,4,4,1,0,4,1,4,4,0,3,5},
                {6,3,4,7,5,4,2,2,7,9,8,4,5,6,0,3,9},
                {0,4,9,7,1,0,7,7,3,2,1,4,7,6,0,0,0}
        };

        int screen[][] = {  {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };

        String [] dict = {"table","chair","wheel","whee","lchair"};
        String [] words={"tablechair","wheelchair","tablewheel","nonexist"};
        String pattern = "abcaby";
        String text = "abxabcabcaby";

        // Arrays.stream(searchDictionary(words,dict)).forEach(entry -> System.out.println(entry));

        //freqAlphabets("1326#");
        // merge(intervals);
        // nonOverlapping(intervals2);
        //  mergeSubsets(interval3);
        //System.out.println(isHappy(10));

        //moveZeroes(nums);
        // maxSubArray(nums2);
        // groupAnagrams(strs);
        //  productExceptSelf(nums3);

        //minPathSum(grid);

        //System.out.println(StringPatters.generatePatterns("1??0?101"));
        // System.out.println(LeetCode416.canPartition(new int[]{23,13,11,7,6,5,5}));

        // System.out.println(StringPatters.matchString(text,pattern));
        // StringPatters.kmpUtils("abcdabca");

      //  FillPaint paint = new FillPaint();
      //  paint.fill(screen,4,4,3);

//        Numbers numbers = new Numbers();
//        numbers.printJumpingNumbers(20);
//        System.out.println(numbers.maxHistogramArea(new int[]{1,2,1,2,3,1}));
       // printMatrix(screen);

//        SegmentTree tree = new SegmentTree();
//        Integer[] segTree = new Integer[7];
//        Arrays.fill(segTree, Integer.MAX_VALUE);
//        tree.constructSegmentTreeForMinRange(new int[]{-1,2,4,0},segTree,0,3,0);
//        Util.<Integer>printArray(segTree);

//        StringPermutations stringPermutations = new StringPermutations();
//       // stringPermutations.permutations("aaaaab").forEach(str->System.out.print(str + ","));
//        stringPermutations.combinations("aabc").forEach(str->System.out.print(str + ","));

        Numbers numbers = new Numbers();
       // int trust[][] = {{1,3},{2,3}};
       // numbers.findJudge(3,trust);

        // numbers.isPerfectSquare(2147483647);

        int coo[][] = {{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
        //numbers.checkStraightLine(coo);
      //  numbers.findComplement(1);


        Numbers2 numbers2 = new Numbers2();
       // System.out.println(numbers2.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));

      //  RemoveKDigits removeKDigits = new RemoveKDigits();
      //  System.out.println(removeKDigits.removeKdigits("1234567890",9));

//        Trie trie = Trie.createTrie();
//
//        trie.insert("the");
//        trie.insert("le");
//        trie.insert("leet");
//        trie.insert("code");
//
//        System.out.println("seach leet : "+trie.search("leet"));
//        System.out.println("seach word : "+trie.search("word"));
//        System.out.println("seach lee : "+trie.search("lee"));
//
//        System.out.println("prefix lee : "+trie.startsWith("lee"));

//        WordBoggle wordBoggle = new WordBoggle();
//        String dictionary[] = {"oath", "pea", "eat", "rain"};
//        char boggle[][]   = {{'o','a','a','n'},
//            {'e','t','a','e'},
//            {'i','h','k','r'},
//                {'i','f','l','v'}};
//        wordBoggle.wordBoggle(dictionary,boggle);

//        NumArray numArray = new NumArray(new int[]{-2,0,3,-5,2,-1});
//        Util.<Integer>printArray(numArray.stree);
//        System.out.println(numArray.sumRange(2,5));

        //System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
       // System.out.println(minCostClimbingStairs(new int[]{10,15,20}));

        //integerBreak(2);

//        WordBreakProblem2 wordBreakProblem2 = new WordBreakProblem2();
//        wordBreakProblem2.inserWord("leet");
//        wordBreakProblem2.inserWord("code");
//
//        System.out.println(wordBreakProblem2.wordBreak("leetcode"));

//        MinJump minJump = new MinJump();
//        minJump.jump(new int[]{2,3,1,1,2,4,2,0,1,1});

    }

    public static int  minCostClimbingStairs(int[] cost) {
        return Math.min(minCost(cost,0) ,minCost(cost,1) );
    }

    private static int minCost(int cost[], int curr){
        int l = cost.length;
        if(curr == l-2) return cost[curr];
        if(curr == l-3) return cost[curr]+Math.min(cost[curr+1],cost[curr+2]);

        int min1 = cost[curr]+minCost(cost, curr+1);
        int min2 = cost[curr]+minCost(cost, curr+2);
        return Math.min(min1 , min2);
    }

    public static int integerBreak(int n) {

        int t[][] = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(j>=i){
                    t[i][j] = Math.max(i*Math.max(t[i][j-i],j-i),t[i-1][j]);
                } else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n-1][n-1];
    }
}
