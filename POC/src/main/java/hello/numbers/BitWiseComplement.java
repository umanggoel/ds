package com.company.numbers;

public class BitWiseComplement {

    public static void main(String[] args) {
        BitWiseComplement bitWiseComplement = new BitWiseComplement();
        bitWiseComplement.bitwiseComplement(8);
    }

    public int bitwiseComplement(int N) {

        String binaryComplement = "";
        int num = N;
        double result = 0.0;

        while(num != 1) {
            binaryComplement = (num%2 == 0 ? "1" : "0") + binaryComplement;
            num = num/2;
        }
        binaryComplement = (num == 0 ? "1" : "0") + binaryComplement;
        System.out.println( binaryComplement);

        for(int i=0;i< binaryComplement.length();i++) {
            if(binaryComplement.charAt(i) == '1') {
                result = result + Math.pow(2,i);
            }
        }
        return (int) result;
    }
}
