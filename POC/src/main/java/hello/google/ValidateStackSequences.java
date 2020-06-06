package com.company.google;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        boolean result = true;

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i=0;i<pushed.length;i++){
            if(stack.isEmpty()) {
                stack.push(pushed[i]);
                continue;
            }else{
                if(stack.peek() == popped[index]){
                    stack.pop();
                    i = i-1;
                    index++;
                }else{
                    stack.push(pushed[i]);
                }
            }
        }


        for(int i = index;i<popped.length;i++){
            if(stack.pop() != popped[i]) {
                result = false;
                break;
            }
        }

        return result;
    }
}
