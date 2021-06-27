package com.company.arrays;

import java.util.HashSet;
import java.util.Set;

public class FruitBasket904 {

    public static void main(String[] args) {
        FruitBasket904 fruitBasket904 = new FruitBasket904();
        int tree[] = {1,1,1,1};
        fruitBasket904.totalFruit(tree);
    }

    public int totalFruit(int[] tree) {
        int total = 0;
        int i = 0;
        while(i<tree.length) {
            int index = i;
            Set<Integer> set = new HashSet<>();
            int curr = 1;
            set.add(tree[i]);
            int j = i+1;
            while(j<tree.length) {
                set.add(tree[j]);
                if(set.size() > 2){
                    break;
                }else{
                    if(tree[j] != tree[j-1]) index = j;
                    curr++;
                }
                j++;
            }
            total = Math.max(total, curr);
            if(index == i) {
                i++;
            }else if(j == tree.length){
                i = j;
            }else{
                i = index;
            }
        }

        return total;
    }
}