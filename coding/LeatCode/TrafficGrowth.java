package LeatCode;

public class TrafficGrowth {
    public static int maxGrowth(int[] visits) {
        int minVisits = Integer.MAX_VALUE;
        int maxGrowth = 0;

        for (int v : visits) {
            if (v < minVisits) {
                minVisits = v;        // update minimum
            } else {
                maxGrowth = Math.max(maxGrowth, v - minVisits); // possible growth
            }
        }

        return maxGrowth;
    }

    public static void main(String[] args) {
        int[] n1 = {1200, 900, 1100, 800, 1500};

        System.out.println(maxGrowth(n1)); // 700
        System.out.println(maxGrowth(new int[]{500, 480, 470, 460}));        // 0
        System.out.println(maxGrowth(new int[]{300, 250, 400, 200, 600, 100})); // 400
    }
}
