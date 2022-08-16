package array;

//leetcode 122
public class BestTimeSellingStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int size = prices.length;
        for (int i = 0; i < size - 1; i++) {
            int current = prices[i];
            int left = i + 1;
            int max = current;
            while (left < size) {
                if (prices[left] > max) {
                    max = prices[left];
                    left++;
                } else {
                    break;
                }
            }
            left--;
            profit += prices[left] - current;
            i = left;

        }


        return profit;
    }

    public int maxProfitOptimal(int[] prices) {
        int maxProfit = 0;
        int minCost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int benefit = prices[i] - minCost;
            if (benefit > 0) maxProfit += benefit;
            minCost = prices[i];
        }
        return maxProfit;
    }

    public void client() {
        int[] p = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(p));
    }
}
