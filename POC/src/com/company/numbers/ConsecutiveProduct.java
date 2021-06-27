package com.company.numbers;

public class ConsecutiveProduct {


    public static void main(String[] args) {
        ConsecutiveProduct consecutiveProduct = new ConsecutiveProduct();
        System.out.println(consecutiveProduct.solution(1,1000));
    }

    public int solution(int A, int B) {
        int count = 0;
        for(int i=A;i<=B;i++) {
            if(i%2 != 0) continue;
            int temp = (int)Math.sqrt(A);
            int prod = temp * (temp+1);
            while(prod <= i) {
                if(prod == i) {
                    count++;
                    break;
                }
                temp++;
                prod = temp * (temp + 1);
            }
        }
        return count;
    }
}
