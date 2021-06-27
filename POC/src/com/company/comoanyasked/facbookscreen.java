//
//
//
//class Solution {
//
//    public boolean testSorted(String words[], String alphabets[]) {
//
//        if(words.length < 2) return true;
//        Map<String, Integer> ranks = new HashMsp();
//
//        for(int i=0;i< alphabets.length;i++ ) {
//            ranks.put(alphabets[i], i);
//        }
//
//        for(int i = 1; i< words.length;i++){
//
//            if(!compare(words[i-1], words[i], ranks))  return false;
//        }
//
//        return true;
//
//    }
//
//    private boolean compare(String s1, String s2, Map<String, Integer> ranks) {
//
//        int len1 = s1.length();   // tab
//        int len2 = s2.length();   // tabe
//
//        int i = 0;
//        int j = 0;
//        while(i< len1 && j< len2) {
//
//            String t1 = s1.subString(i,i+1);  // t
//            String t2 = s2.subString(j,j+1);  // b
//
//            if(ranks.get(t1) > ranks.get(t2)) {
//                return false;
//            }if(ranks.get(t1) < ranks.get(t2)) {
//                return true;
//            }
//
//            i++;
//            j++;
//
//        }
//
//        if(len1 > len2) return false;
//
//        return true;
//
//
//    }
//
//
//
//}
//
//  }
//
//
////numerator = 31
////divisor = 7
//
////quotient = 4
////remainder = 3
//
//// do not use divide or mod
//// all unsigned integers
//
//
//class Solution {
//
//    public void getQutientAndDivisor(int num, int div) {
//
//        if(div == 0) {
//            System.out.println("divisor cany be zero");
//        }
//        int sum = div;
//        int count = 1;
//
//        while(sum <= num) {
//            sum = sum+ div;
//            count++;
//        }
//
//
//        if(sum == num) {
//            System.out.println("quotient"+ count);
//            System.out.println("remainder"+ 0);
//        } else {
//            System.out.println("quotient"+ count-1);
//            System.out.println("remainder"+ num-sum+div); //31-35+7 = 3
//        }
//
//    }
//
//}