package com.geeks.ds.queue;

/**
 * Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
 * 1. The amount of petrol that every petrol pump has.
 * 2. Distance from that petrol pump to the next petrol pump.
 * Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
 * Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.
 */
public class CircularTour {

    public static void main(String[] args) {

        PetrolPump[] arr = {new PetrolPump(6, 4), new PetrolPump(3, 6), new PetrolPump(7, 3)};

        int start = findTour(arr, arr.length);

        System.out.println(start == -1 ? "No Solution" : "Start = " + start);

    }

    static int findTour(PetrolPump arr[], int n) {
        int start = 0;
        int end = 1;
        int curr_petrol = arr[start].petrol - arr[start].distance;
        while (end != start || curr_petrol < 0) {
            while (curr_petrol < 0 && start != end) {
                curr_petrol -= arr[start].petrol - arr[start].distance;
                start = (start + 1) % n;
                if (start == 0)
                    return -1;
            }
            curr_petrol += arr[end].petrol - arr[end].distance;

            end = (end + 1) % n;
        }

        return start;
    }

    // Method two with constant time complexity
    static int printTour(PetrolPump p[], int n) {
        int start = 0, deficit = 0;
        int capacity = 0;
        for (int i = 0; i < n; i++) {
            capacity += p[i].petrol - p[i].distance;
            if (capacity < 0) {
                start = i + 1;
                deficit += capacity;
                capacity = 0;
            }
        }
        return (capacity + deficit >= 0) ? start : -1;
    }


    static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }
}
