package com.company.google;

import java.util.HashMap;
import java.util.Map;

class SnapshotArray {

    int snapcount = 0;
    int max;
    Map<Integer, Map<Integer,Integer>> map = new HashMap<>();

    public SnapshotArray(int length) {
        snapcount = 0;
        max = length;
        map.put(snapcount, new HashMap<>());
    }

    public void set(int index, int val) {
        map.get(snapcount).put(index,val);
    }

    public int snap() {
        Map<Integer,Integer> temp = new HashMap<>();
        temp.putAll(map.get(snapcount));
        map.put(snapcount+1, temp);
        return snapcount++;
    }

    public int get(int index, int snap_id) {
        if(index >= max) return -1;
        if(snap_id >= snapcount) return -1;
        if(map.get(snap_id).get(index) == null) return 0;
        return map.get(snap_id).get(index);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
