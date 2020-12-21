package com.company.string;

public class DecodeString880 {


    public static void main(String[] args) {
        DecodeString880 decodeString880 = new DecodeString880();
        decodeString880.decodeAtIndex("a2b3c4d5e6f7g8h9", 9);
    }


    public String decodeAtIndex(String S, int k) {

        char arr[] = S.toCharArray();
        int start = 0;
        int digitstart = 0;
        for(int i= 0;i< arr.length;i++){
            if(arr[i] >= '2' && arr[i] <= '9' ){
                if(digitstart == 0) {
                    digitstart = i;
                }
            }else {

                if (digitstart != 0) {
                    int sCount = digitstart - start;

                    if(sCount == 1) return S.substring(start, digitstart);
                    double n = Double.parseDouble(S.substring(digitstart, i));

                    if (sCount * n >= k) {
                        if(k % sCount == 0){
                            return S.substring(start, digitstart).substring(k % sCount, k % sCount+1);
                        }else{
                            return S.substring(start, digitstart).substring((k % sCount)-1, k % sCount);
                        }
                    } else {
                        k = k - (int) (sCount * n);
                    }
                    start = i;
                    digitstart = 0;
                }
            }
        }

        if (digitstart != 0) {
            int sCount = digitstart - start;
            if(sCount == 1) return S.substring(start, digitstart);

            double n = Double.parseDouble(S.substring(digitstart));
            if (sCount * n >= k) {
                if(k % sCount == 0){
                    return S.substring(start, digitstart).substring(k % sCount, k % sCount+1);
                }else{
                    return S.substring(start, digitstart).substring((k % sCount)-1, k % sCount);
                }
            }
        }else {
            int sCount = S.length() - start;
            if(sCount == 1) return S.substring(start, digitstart);
            if(k > sCount) return "";

            return S.substring(start).substring(k-1, k);

        }

        return "";
    }
}
