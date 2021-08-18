package com.company.arrays;

import java.util.Stack;

public class PushDominoes {
    public static void main(String[] args) {
        PushDominoes pushDominoes = new PushDominoes();
        pushDominoes.pushDominoes("R.R.L");
    }

    public String pushDominoes(String d) {

        Stack<Integer> ele = new Stack();
        Stack<Integer> pushes = new Stack();

        char arr[] = d.toCharArray();

        for(int i = 0;i< arr.length;i++) {
            if(arr[i] == '.') {
                ele.push(i);
            }else if(arr[i] == 'L'){
                if(pushes.isEmpty()){
                    while(!ele.isEmpty()){
                        arr[ele.pop()] = 'L';
                    }
                }else{
                    int size = ele.peek()-pushes.peek();
                    for(int j=0;j< size/2;j++) {
                        arr[ele.pop()] = 'L';
                    }
                    if(size%2 != 0) ele.pop();
                    while(!ele.isEmpty() && ele.peek() > pushes.peek()) {
                        arr[ele.pop()] = 'R';
                    }
                    pushes.pop();
                }
            }else{
                pushes.push(i);
                while(!ele.isEmpty() && ele.peek() < pushes.peek()){
                    ele.pop();
                }
            }
        }

        if(!pushes.isEmpty()){
            while(!ele.isEmpty() ){
                arr[ele.pop()] = 'R';
            }
        }

        String result = String.valueOf(arr);
        return result;
    }

}