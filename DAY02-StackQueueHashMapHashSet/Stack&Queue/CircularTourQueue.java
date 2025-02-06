/*
 * Circular Tour Problem
Problem: Given a set of petrol pumps with petrol and distance to the next pump, determine the starting point for completing a circular tour.
Hint: Use a queue to simulate the tour, keeping track of surplus petrol at each pump.
 */

import java.util.LinkedList;
import java.util.Queue;

class PetrolPump {
    int petrol, distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTourQueue {
    public static int findStartingPump(int[] petrol, int[] distance) {
        int n = petrol.length;
        Queue<Integer> queue = new LinkedList<>();
        int surplus = 0, deficit = 0, start = 0;

        for (int i = 0; i < n; i++) {
            surplus += petrol[i] - distance[i];
            queue.add(i);  // Add pump index to the queue

            if (surplus < 0) {  // If deficit occurs, reset the tour
                start = i + 1;
                deficit += surplus;
                surplus = 0;
                queue.clear();  // Reset the queue as previous pumps are invalid
            }
        }

        return (surplus + deficit >= 0) ? start : -1;  // If total fuel is enough, return the starting pump
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int result = findStartingPump(petrol, distance);
        System.out.println("Starting Petrol Pump: " + (result != -1 ? result : "No Solution"));
    }
}
