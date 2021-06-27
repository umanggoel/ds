package com.company.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContinuousSubarraySum526 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k < 0) {
            k = -k;
        }

        int sum = 0;
        int left = 0;
        Set<Integer> remainder = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = k == 0 ? sum : sum % k;
            if (remainder.contains(rem)) {
                return true;
            }
            remainder.add(left);
            left = rem;
        }
        return false;

    }
}
