package com.company.design;

import java.util.LinkedList;
import java.util.function.Function;

public class RateLimiter {


    public static void main(String[] args) {
        Function myFunc = new Function() {
            @Override
            public Object apply(Object o) {
                System.out.println("helloWorld"+o);
                return null;
            }
        };

        Function rateLimit = rateLimit(myFunc,500,5);
            rateLimit.apply("1");
            rateLimit.apply("2");
            rateLimit.apply("3");
            rateLimit.apply("4");
            rateLimit.apply("5");
            rateLimit.apply("6");

    }


    static Function rateLimit(Function myFunc,int time, int calls){
        final Counter start = new Counter();
        return (o) -> {

            if (start.start == null) {
                start.start = System.currentTimeMillis();
                start.q = new LinkedList();
                start.q.add(start.start);
                myFunc.apply(o);
            } else {
                Long curr = System.currentTimeMillis();
                while(!start.q.isEmpty() && (long)start.q.peek()-curr > time){
                    start.q.remove();
                }
                if(start.q.size() < calls && (long)start.q.peek()-curr < time){
                    myFunc.apply(o.toString());
                    start.q.add(curr);
                }
//                if (curr - start.start < time) {
//                    myFunc.apply(o.toString());
//                    start.start = curr;
//                }
            }
            return null;
        };


    }
}

