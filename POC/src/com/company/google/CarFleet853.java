package com.company.google;

import java.util.ArrayList;
import java.util.List;

public class CarFleet853 {

    public static void main(String[] args) {
        CarFleet853 carFleet853 = new CarFleet853();
        int [] pos = {0,4,2};
        int [] speed = {2,1,3};
        System.out.println(carFleet853.carFleet(10,pos, speed ));
    }


    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) return 0;
        if (position.length == 1) return 1;
        List<Car> list = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            list.add(new Car(position[i], speed[i]));
        }

        list.sort((a, b) -> a.position - b.position);

        int fleetcount = 1;
        int i = 0;

        boolean canCatch = false;

        while (i < position.length - 1) {
            if (list.get(i).speed <= list.get(i + 1).speed) {
                fleetcount++;
                canCatch = false;
            } else {
                int k = 1;
                for (int j = list.get(i + 1).position+list.get(i + 1).speed; j <= target; j = j + list.get(i + 1).speed) {
                    int pos1 = list.get(i + 1).position + (list.get(i + 1).speed * k);
                    int pos2  = list.get(i).position + (list.get(i).speed * k);
                    if ( pos1 <= pos2){
                        canCatch = true;
                        break;
                    }
                    k++;
                }

                if (!canCatch) {
                    fleetcount++;
                }
            }
            i++;
        }

        return fleetcount;
    }
}


class Car {
    int speed;
    int position;

    public Car(int position, int speed) {
        this.speed = speed;
        this.position = position;
    }

    public String toString() {
        return " positon:" + position + " speed:" + speed + "\n";
    }
}