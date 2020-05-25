package com.company.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PsedoPalindromicPaths {

    public int pseudoPalindromicPaths (TreeNode root) {

        List<String> paths = new ArrayList<>();
        pathStrings(root, paths,"");
        int count = 0;
        for(String str: paths){
            System.out.println(str);
            if(isPseudoPalindrome(str)) count++;
        }
        return count;
    }

    private void pathStrings(TreeNode root, List<String> paths, String curr){
        if(root == null) return;
        curr = curr + root.val;

        if(root.left == null && root.right == null){
            paths.add(curr);
        }else{
            pathStrings(root.left, paths, curr);
            pathStrings(root.right, paths, curr);
        }

    }

    private boolean isPseudoPalindrome(String str){
        if(str == null || str.length() == 0) return false;
        if(str.length() == 1) return true;

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }

        int odd  = 0;

        for(Object entry : map.values()){
            if((int)entry%2 != 0) odd++;
        }

        if(odd > 1) return false;
        return true;
    }
}
