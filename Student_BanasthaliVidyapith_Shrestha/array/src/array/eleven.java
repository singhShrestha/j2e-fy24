package array;

import java.util.Scanner;

public class eleven {
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < nums[mid + 1]) {
                // Move towards the higher side
                left = mid + 1;
            } else {
                // Move towards the lower side
                right = mid;
            }
        }
        
        return left;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] nums = new int[size];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element index: " + peakIndex);
    }
}
