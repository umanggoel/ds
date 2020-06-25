package com.company.arrays;

public class FindDuplicate287 {

    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        slow = nums[slow];
        fast = nums[nums[fast]];

        //FLOYD HARE & TORTOISE ALGO
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // FINDING STARTING POINT OF CYCLE
        int start = nums[0];
        while(start != slow)
        {
            start = nums[start];
            slow = nums[slow];
        }
        return start;
    }
}
