package LeatCode;

public class ShipPackages {
    public static int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        // Setting bounds
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                high = mid;  // Mid capacity works, try smaller
            } else {
                low = mid + 1; // Mid too small, increase
            }
        }

        return low;
    }

    private static boolean canShip(int[] weights, int days, int capacity) {
        int dayCount = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                dayCount++;
                currentLoad = 0;
            }
            currentLoad += w;
        }

        return dayCount <= days;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5)); // Output: 15
        System.out.println(shipWithinDays(new int[]{3,2,2,4,1,4}, 3)); // Output: 6
        System.out.println(shipWithinDays(new int[]{1,2,3,1,1}, 4)); // Output: 3
    }
}
