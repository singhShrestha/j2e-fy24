package array;

import java.util.Scanner;

public class ten {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; // Update the minimum price if a lower price is found
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice; // Calculate the profit if selling at the current price gives a higher profit
            }
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] prices= new int[size];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            prices[i] = scanner.nextInt();
        }
        ten stockProfit = new ten();
        int maxProfit = stockProfit.maxProfit(prices);
        System.out.println("Maximum profit: " + maxProfit);
    }
}

