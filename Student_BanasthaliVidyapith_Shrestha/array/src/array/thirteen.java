package array;

import java.util.Scanner;

public class thirteen {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] height = new int[size];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            height[i] = scanner.nextInt();
        }
        
        int maxWater = maxArea(height);
        System.out.println("Maximum amount of water that can be stored: " + maxWater);
    }
}
