package com.company.comoanyasked;

public class GasStation {

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int gas[] = {1,2,3,4,5};
        int cost[] = {3,4,5,1,2};
        gasStation.canCompleteCircuit(gas,cost);
    }
        public int canCompleteCircuit(int[] gas, int[] cost) {

            for(int i = 0 ;i< gas.length;i++) {
                if(canCompleteLoop(gas, cost, i)) return i;
            }

            return -1;
        }

        boolean canCompleteLoop(int[] gas, int[] cost, int start) {

            int fuel = 0;
            int index = start;
            if(index == gas.length) {
                index = 0;
            }
            int i = 0;
            for(;i<gas.length;i++) {
                fuel = fuel+gas[index];
                fuel = fuel - cost[index];
                index++;
                if(index == gas.length) {
                    index = 0;
                }
                if(fuel <= 0){
                    break;
                }
            }

            if(i == gas.length){
                return true;
            }
            return false;
        }
}
