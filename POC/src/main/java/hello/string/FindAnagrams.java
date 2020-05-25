
publc class FindAnagrams{

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {

            int sLen = s.length();
            int pLen = p.length();

            if(pLen > sLen) return new ArrayList<>();

            List<Integer> result = new ArrayList<>();

            int sArr[] = new int[26];
            int pArr[] = new int[26];

            for(int i=0;i<pLen;i++) {
                sArr[s.charAt(i)-'a'] =  sArr[s.charAt(i)-'a'] + 1;
                pArr[p.charAt(i)-'a'] =  pArr[p.charAt(i)-'a'] + 1;
            }

            for(int i=pLen;i<sLen;i++){
                if(isEqual(pArr,sArr)) result.add(i-pLen);
                sArr[s.charAt(i)-'a'] =  sArr[s.charAt(i)-'a'] + 1;
                sArr[s.charAt(i-pLen)-'a'] =  sArr[s.charAt(i-pLen)-'a'] - 1;
            }

            if(isEqual(pArr,sArr)) result.add(sLen-pLen);
            return result;

        }

        boolean isEqual(int[] a,int[] b){

            if(a.length != b.length) return false;
            for(int i=0;i<a.length;i++){
                if(a[i]!=b[i]) return false;
            }
            return true;
        }

    }
}